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
    AccessToken accessToken;

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
                        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImUwYjY0NGM2NTBjMWM0ZGNhZTU5MDZiMTU2ODc2N2M1NmQ1ZWVjYWY1ZWE0NWU4NDQwNGZkMDdhYTQ0NDg3NzczZjM4OTg2ZjUxOGUyYmZmIn0.eyJhdWQiOiIxIiwianRpIjoiZTBiNjQ0YzY1MGMxYzRkY2FlNTkwNmIxNTY4NzY3YzU2ZDVlZWNhZjVlYTQ1ZTg0NDA0ZmQwN2FhNDQ0ODc3NzNmMzg5ODZmNTE4ZTJiZmYiLCJpYXQiOjE1Mzk0MDk5NzAsIm5iZiI6MTUzOTQwOTk3MCwiZXhwIjoxNTcwOTQ1OTcwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.Kp88GX4sgbKRcTEH43yGrGH3n9CLLuNvDW9Tdy1XyJ_xMBi5zqfKcuEDhdrTd4GrbVzD3H6BM1R8f6pwU-L77RRLKV0uO1oFyiwdaFRlFN-qlkALkD9Rtm7IRAG5Crzj8FwKiqLpMdf5vjHdHkqdZjUktMerX1N4FUZvuhAsulyr7IAWPfb23hd6N5NE5yjNGEPfFH1KxNVggBq9hv34pdLp3AydwX-Op_-4WkeMWs0InSZ9Ufb4WTavXjXHhS0B5__qzA40_dka1iNNY8qpBGKyqAiMwgFZBYq_X1BNBCy_YYqd15xANhlgUVoa4g-RDkLmiiamss-KUy39Vg3XqEwMbdCGvF_JAm5APSI8hyImcUOiBVVuksZVnr2PM1uu5um1wKybq5mhCes0gQQpdf32SEs_HtEF3MmQOfhFAxsvzwHV63bhUqeGwuqp4er3Dahs3jtdzSATrpwtBmP-4K3oYDybkmm5wgKn8bTf_jSVjRVA45HpzKsgXQQq-RY9UtH5SIg3m4dhDTyR1VKRzsA9Gb4pIRaXlOqrTqskL2PiqTgp8Dp4pdOdUQSSFtsobagCd-3ObaTCTvqASCHMMM_dxmUQtKyLMMXYhbHkBceuzVG5uEZTcgFRvDtz0Bffa_0UvbfTvy5F2U9aams2tWxYxQOshj5at1fcEV4gRUI";
                        Intent intent = new Intent(Login.this,Home.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                        finish();

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

// Log.e("Get Json","Get JSon :" + new Gson().toJson(response.body().getAccessToken()));
//         Toast.makeText(Login.this,"Get Json :"+ new Gson().toJson(response.body().getAccessToken()),Toast.LENGTH_LONG).show();

