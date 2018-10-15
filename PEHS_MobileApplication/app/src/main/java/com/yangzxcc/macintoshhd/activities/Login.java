package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yangzxcc.macintoshhd.TokenManager;
import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.models.AccessToken;
import com.yangzxcc.macintoshhd.models.Patient;
import com.yangzxcc.macintoshhd.models.SignIn;
import com.yangzxcc.macintoshhd.pehs.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity{

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditUsername, textInputEditPassword;
    AppCompatButton btnLogin;
    TokenManager tokenManager;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);
//        textInputLayoutUsername.setError("Please fill out this fields");
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputEditUsername = (TextInputEditText) findViewById(R.id.textInputEditUsername);
        textInputEditPassword = (TextInputEditText) findViewById(R.id.textInputEditPassword);
        btnLogin = (AppCompatButton) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patientLogin();
            }
        });

        if(tokenManager.getToken().getAccessToken() != null){
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }

    }


    private void patientLogin() {


        String username = textInputEditUsername.getText().toString().trim();
        String password = textInputEditPassword.getText().toString().trim();

        if (username.isEmpty()) {
//            textInputEditUsername.setError("Please fill out this fields");
//            textInputEditUsername.requestFocus();
            return;
        } else if (password.isEmpty()) {
            textInputEditPassword.setError("Please fill out this fields");
            textInputEditPassword.requestFocus();
            return;
        }

        Retrofit retrofit = ApiClient.getRetrofit();

        apiInterface = retrofit.create(ApiInterface.class);

        SignIn testLogin = new SignIn(username,password);

        Call<AccessToken> call = apiInterface.signIn(testLogin);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        String value = response.body().getAccessToken();
                        Log.w("MyTag",value);
                    }else {
                        try {
                            Toast.makeText(Login.this,response.errorBody().string(),Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    Toast.makeText(Login.this,"Cannot Login",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}



