package com.yangzxcc.macintoshhd.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.models.SignIn;
import com.yangzxcc.macintoshhd.models.User;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestLogin extends AppCompatActivity {

    Button btnlogin,btngetData;

    Retrofit retrofit = ApiClient.getRetrofit();
    ApiInterface apiInterface = retrofit.create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);

        btnlogin = (Button)findViewById(R.id.blog);
        btngetData = (Button)findViewById(R.id.bget);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btngetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                token();
            }
        });

    }

    private static String text;
    private void token() {
        Call<ResponseBody> call = apiInterface.getInfo(text);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        Toast.makeText(TestLogin.this,response.body().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(TestLogin.this,"Login not correct",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void login() {
        SignIn signIn = new SignIn("nimmit","123456");
        Call<User> call = apiInterface.login(signIn);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    Toast.makeText(TestLogin.this,"pass ???????",Toast.LENGTH_LONG).show();
                    text = response.body().getToken();
                }else {
                    Toast.makeText(TestLogin.this,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(TestLogin.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
