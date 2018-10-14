package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.models.Patient;
import com.yangzxcc.macintoshhd.models.SignIn;
import com.yangzxcc.macintoshhd.models.User;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity{

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditUsername, textInputEditPassword;
    AppCompatButton btnLogin;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

    }
    private void patientLogin() {
        String username = textInputEditUsername.getText().toString().trim();
        String password = textInputEditPassword.getText().toString().trim();


        if (username.isEmpty()){
//            textInputEditUsername.setError("Please fill out this fields");
//            textInputEditUsername.requestFocus();
            return;
        }else if (password.isEmpty()){
            textInputEditPassword.setError("Please fill out this fields");
            textInputEditPassword.requestFocus();
            return;
        }
//        startActivity(new Intent(Login.this,Home.class));

        Retrofit retrofit = ApiClient.getRetrofit();

        final ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        SignIn testLogin = new SignIn(username,password);

        Call<User> call = apiInterface.signIn(testLogin);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    token = response.body().getToken();
                    String authHeader = "Bearer " + token;
                    Call<InformationManager> call1 = apiInterface.getInfo(authHeader);
                    call1.enqueue(new Callback<InformationManager>() {
                        @Override
                        public void onResponse(Call<InformationManager> call, Response<InformationManager> response) {
                            if (response.isSuccessful()){


                                Toast.makeText(Login.this,"Success Get token",Toast.LENGTH_LONG).show();

                            }else {
                                try {
                                    Toast.makeText(Login.this,response.errorBody().string(),Toast.LENGTH_LONG).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
//                                Toast.makeText(Login.this,"Failed to get Token",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<InformationManager> call, Throwable t) {
                            Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }else {
                    Toast.makeText(Login.this,"Login not correct",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}



