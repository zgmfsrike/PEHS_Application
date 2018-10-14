package com.yangzxcc.macintoshhd.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.pehs.R;

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
//                login();
            }
        });

        btngetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private static String text;



//    private void login() {
//        SignIn signIn = new SignIn("nimmit","123456");
//        Call<AccessToken> call = apiInterface.signIn(signIn);
//        call.enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                if (response.isSuccessful()){
//                    Toast.makeText(TestLogin.this,"pass ???????",Toast.LENGTH_LONG).show();
//                    text = response.body().getToken();
//                    Call<ResponseBody> call2 = apiInterface.getInfo(text);
//                    call2.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            if (response.isSuccessful()){
//                                try {
//                                    Toast.makeText(TestLogin.this,response.body().string(),Toast.LENGTH_LONG).show();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
////                                Toast.makeText(TestLogin.this,"Login  correct",Toast.LENGTH_LONG).show();
//
//                            }else {
//                                Toast.makeText(TestLogin.this,"Login not correct",Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                                    Toast.makeText(TestLogin.this,t.getMessage(),Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }else {
//                    Toast.makeText(TestLogin.this,response.message(),Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AccessToken> call, Throwable t) {
//                Toast.makeText(TestLogin.this,t.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });

}
