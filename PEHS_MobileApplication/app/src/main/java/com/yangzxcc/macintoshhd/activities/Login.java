package com.yangzxcc.macintoshhd.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import com.yangzxcc.macintoshhd.TokenManager;
import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.models.AccessToken;
import com.yangzxcc.macintoshhd.models.SignIn;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditUsername, textInputEditPassword;
    AppCompatButton btnLogin;
    TokenManager tokenManager;
    ApiInterface apiInterface;
    AccessToken accessToken;
    String tokenNimmit;
    String tokenNipon;
    String token;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
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
            textInputEditUsername.setError("Please fill out this fields");
            textInputEditUsername.requestFocus();
            return;
        } else if (password.isEmpty()) {
            textInputEditPassword.setError("Please fill out this fields");
            textInputEditPassword.requestFocus();
            return;
        }
        Retrofit retrofit = ApiClient.getRetrofit();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        SignIn signIn = new SignIn(username, password);

        Call<ResponseBody> call = apiInterface.postLogin(new SignIn(username,password));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        Intent intent = new Intent(Login.this, Home.class);
                        Log.e("Output","out1"+response.body().string());
                        Log.e("Output","out2"+response.body().toString());
                        Log.e("Output","out3"+response.code());
                        Log.e("Output","out4"+response.raw().body().string());
                        Log.e("Output","out5"+response.headers().get("access_token"));
                        Log.e("Outputttt","out6"+response.headers().get("value"));
                        Log.e("Output","out"+response.headers().toString());
//                        token = response.body().string();

                        sp = getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
                        editor = sp.edit();
//                        token = response.body().string();
                        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImZlNTYyNGQxYWQ3OGVhYmM1MGVmNDY5YzM5ZThhOGFlZWY4MWNiNzljN2I2YzExNTkxMTA3YzkwMTNkMmMzZTEwOWE4ODdiNGQyOWQwYWYzIn0.eyJhdWQiOiIxIiwianRpIjoiZmU1NjI0ZDFhZDc4ZWFiYzUwZWY0NjljMzllOGE4YWVlZjgxY2I3OWM3YjZjMTE1OTExMDdjOTAxM2QyYzNlMTA5YTg4N2I0ZDI5ZDBhZjMiLCJpYXQiOjE1NDAzODU2MzAsIm5iZiI6MTU0MDM4NTYzMCwiZXhwIjoxNTcxOTIxNjMwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.QNfTum_nwhtPRfBImeFGvS4hdceNKeExNz7cLXeJaxDXNHahVseMEpebGkKe6Pd-7kWmK7h9VsNHo5M-qYChOcePnfHZZynq24RgDJWnlVcRaAh52a8hc0KsKeNXxxB82axwEQQwVJph_fQL5uIuXiNgbkZHL4PTAf2D1032-Kt3BBY7J4Yi8iXL2mMy9mh3ul_W18kMepCCBgtFAuA40y4AwVUZhkmFjLN7Ml4IDd2P2Dcf6LF4UFhirGLryXfC0LpJ4U_XbSb1-66S9NhKuWLQvYwDLqIIw_wfCYZBwQufwbno1u1tax8wMKNXUGddNzXTbfrH1wiZi9HMt3cE1uOwM3vbep0kSY54Ov2HbG7duKue9fvyrIVfEuh-W_j2mMvhabJumvXagOE31vbi9wbteUqqhhGXSKevv2PQgGtpZKiI1WFIrUvVywCLcfRK8ONYLZLrHdfmLpbyx5aWAu_-BRhls1tXszqBcA8O-F69vTlZqysf-IXUefLm3JQaK2q3mKBxxoXBZHtJnzssKzwq2nQldPGlDw-2Pi6RJyP7Rds_7YzkN_oT27DjG3uhEXztCSuyDGnS7DsKxTBkfeRXxQYzLrcRTXds7bEv6pO33ZQ8OQPXm74o7Ru3SuQ0qr4bM7JRXZuPbyCvAUMIryuq6b7TU_1QYDarSCi95Ak";

                        editor.putString("token",token).apply();
                        editor.commit();
//                        editor.putString("token",token);
//                        editor.apply();
//                        sp.edit().putString("token",response.body().string()).commit();
//                        intent.putExtra("token",token);
                        startActivity(intent);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Log.e("Error Output",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Error :",t.getMessage());
            }
        });
//
//  String json = "{\n" +
//                "\t\"username\":\"nimmit\",\n" +
//                "\t\"password\":\"123456\",\n" +
//                "}";
// final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),json);


//        apiInterface.postLogin(requestBody).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    try {
//                        Log.e("Output",response.body().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    try {
//                        Log.e("Error :",response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("Error :",t.getMessage());
//            }
//        });
//    }

//    Lastest ---------------------------------------------------------------------------------------------
//    private void patientLogin() {
//        String username = textInputEditUsername.getText().toString().trim();
//        String password = textInputEditPassword.getText().toString().trim();
//        String name = "nimmit";
//        String pass = "123456";
//        String name2 = "nipon";
//
//        if (username.isEmpty()) {
////            textInputEditUsername.setError("Please fill out this fields");
////            textInputEditUsername.requestFocus();
//            return;
//        } else if (password.isEmpty()) {
//            textInputEditPassword.setError("Please fill out this fields");
//            textInputEditPassword.requestFocus();
//            return;
//        }
//        final String tokenNimmit = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImUwYjY0NGM2NTBjMWM0ZGNhZTU5MDZiMTU2ODc2N2M1NmQ1ZWVjYWY1ZWE0NWU4NDQwNGZkMDdhYTQ0NDg3NzczZjM4OTg2ZjUxOGUyYmZmIn0.eyJhdWQiOiIxIiwianRpIjoiZTBiNjQ0YzY1MGMxYzRkY2FlNTkwNmIxNTY4NzY3YzU2ZDVlZWNhZjVlYTQ1ZTg0NDA0ZmQwN2FhNDQ0ODc3NzNmMzg5ODZmNTE4ZTJiZmYiLCJpYXQiOjE1Mzk0MDk5NzAsIm5iZiI6MTUzOTQwOTk3MCwiZXhwIjoxNTcwOTQ1OTcwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.Kp88GX4sgbKRcTEH43yGrGH3n9CLLuNvDW9Tdy1XyJ_xMBi5zqfKcuEDhdrTd4GrbVzD3H6BM1R8f6pwU-L77RRLKV0uO1oFyiwdaFRlFN-qlkALkD9Rtm7IRAG5Crzj8FwKiqLpMdf5vjHdHkqdZjUktMerX1N4FUZvuhAsulyr7IAWPfb23hd6N5NE5yjNGEPfFH1KxNVggBq9hv34pdLp3AydwX-Op_-4WkeMWs0InSZ9Ufb4WTavXjXHhS0B5__qzA40_dka1iNNY8qpBGKyqAiMwgFZBYq_X1BNBCy_YYqd15xANhlgUVoa4g-RDkLmiiamss-KUy39Vg3XqEwMbdCGvF_JAm5APSI8hyImcUOiBVVuksZVnr2PM1uu5um1wKybq5mhCes0gQQpdf32SEs_HtEF3MmQOfhFAxsvzwHV63bhUqeGwuqp4er3Dahs3jtdzSATrpwtBmP-4K3oYDybkmm5wgKn8bTf_jSVjRVA45HpzKsgXQQq-RY9UtH5SIg3m4dhDTyR1VKRzsA9Gb4pIRaXlOqrTqskL2PiqTgp8Dp4pdOdUQSSFtsobagCd-3ObaTCTvqASCHMMM_dxmUQtKyLMMXYhbHkBceuzVG5uEZTcgFRvDtz0Bffa_0UvbfTvy5F2U9aams2tWxYxQOshj5at1fcEV4gRUI";
//        final String tokenNipon = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjNiMDY1ZjA1NWMzMzBiZmY0ZDIyMTViZDk5NzRjMmNhMWNiOTllZGY0MWM3ODMxNDI3ZmMxZWIyZGQ5MDJmODY2NTJkOTQ3YTIzOTQ1NGNjIn0.eyJhdWQiOiIxIiwianRpIjoiM2IwNjVmMDU1YzMzMGJmZjRkMjIxNWJkOTk3NGMyY2ExY2I5OWVkZjQxYzc4MzE0MjdmYzFlYjJkZDkwMmY4NjY1MmQ5NDdhMjM5NDU0Y2MiLCJpYXQiOjE1Mzk3MTQ0MzEsIm5iZiI6MTUzOTcxNDQzMSwiZXhwIjoxNTcxMjUwNDMxLCJzdWIiOiI2Iiwic2NvcGVzIjpbXX0.4CrO1SJ8sWBHK3htP8yfPQt8gG4BKCzQPgcQdk7DFe34N9kGZTqxp5AhkBpFcKEh61KKoSUBKMl8Z5D_xhmMgVBfdU8UeWLWQUxjh1MDggi6r8KGqOCZMxHoKg2DiYSFn2Ov2U6fG7AKKhJ7NF8UY2BilK8n53R4dnwrn3h5jfjuandNM5gl2Jjo-iI7EsmHc3iVIFjAfdgo7HRxuj3s6PygNRcjfQ_-J5Wr4R_yOvch4zSKo3GaFm4PBbVETm3jgAnryEZ56PIfUisq82bPtNtVklUXC6cKkikUo7P9vMti0BxJ2pyKVbFxpokqRvFli_GRbIpdKsoYfqYRMxKAcEy-CAcOHezEjScJs0OCtRdXlR_pYHv-IuD6_UNl7HmxUSTlAaQavEFtg6FJ1zVxGg6szkq02KTun7S2U0ucqQ174h73_Rf3DKOfM3_hUVk9knFQsj_Ke5erF84jcfjubxyGLYKFYdZsBAXSi6GA-tPmVTudcBpRH01WGki2Wmg-0w1Nw1IoqqhEAaAF6ZQkbe3-xkMzwQz9jC-TstoVrAvqFuV3QjlexG26wPtH37EDKvJt_96PtJUAe5q6d3tqzNHBgUVYC3C7COKiQhtBQ7JTDzAiQAbAiPlYcYYEbTyVK6j7T0PROPn4XSnGVCsgwon5jV3IPhDZm4wQpHcvsTE";
//        Retrofit retrofit = ApiClient.getRetrofit();
//
//        apiInterface = retrofit.create(ApiInterface.class);
//
//        if (username.equals(name) && password.equals(pass)){
//
//
//            SignIn testLogin = new SignIn(username, password);
//
//
//            Call<AccessToken> call = apiInterface.signIn(testLogin);
//
//            call.enqueue(new Callback<AccessToken>() {
//                @Override
//                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//
//                                Intent intent = new Intent(Login.this, Home.class);
//                                intent.putExtra("token", tokenNimmit);
//                                startActivity(intent);
//                                finish();
//
//                            } else {
//                                try {
//                                    Toast.makeText(Login.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        } else {
//                            Toast.makeText(Login.this, "Username Invalid", Toast.LENGTH_LONG).show();
//                        }
//                }
//                @Override
//                public void onFailure(Call<AccessToken> call, Throwable t) {
//                    Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//        }else if (username.equals(name2) && password.equals(pass)){
//            SignIn testLogin = new SignIn(username, password);
//
//
//            Call<AccessToken> call = apiInterface.signIn(testLogin);
//
//            call.enqueue(new Callback<AccessToken>() {
//                @Override
//                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//
//                                Intent intent = new Intent(Login.this, Home.class);
//                                intent.putExtra("token", tokenNipon);
//                                startActivity(intent);
//                                finish();
//
//                            } else {
//                                try {
//                                    Toast.makeText(Login.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        } else {
//                            Toast.makeText(Login.this, "Username invalid", Toast.LENGTH_LONG).show();
//                        }
//                }
//                @Override
//                public void onFailure(Call<AccessToken> call, Throwable t) {
//                    Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//    Lastest ---------------------------------------------------------------------------------------------



//                Call<AccessToken> call = apiInterface.signIn(testLogin);
//                call.enqueue(new Callback<AccessToken>() {
//                    @Override
//                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//
//                                Intent intent = new Intent(Login.this, Home.class);
//                                intent.putExtra("token", tokenNipon);
//                                startActivity(intent);
//                                finish();
//
//                            } else {
//                                try {
//                                    Toast.makeText(Login.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        } else {
//                            Toast.makeText(Login.this, "Cannot Login", Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<AccessToken> call, Throwable t) {
//                        Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//            } else {
//                Toast.makeText(Login.this, "Username Invalid", Toast.LENGTH_LONG).show();
    }
}






//        call.enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//
//                        Intent intent = new Intent(Login.this,Home.class);
//                        intent.putExtra("token",token);
//                        startActivity(intent);
//                        finish();
//
//                    }else {
//                        try {
//                            Toast.makeText(Login.this,response.errorBody().string(),Toast.LENGTH_LONG).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                } else {
//                    Toast.makeText(Login.this,"Cannot Login",Toast.LENGTH_LONG).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<AccessToken> call, Throwable t) {
//                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}
//
// Log.e("Get Json","Get JSon :" + new Gson().toJson(response.body().getAccessToken()));
//         Toast.makeText(Login.this,"Get Json :"+ new Gson().toJson(response.body().getAccessToken()),Toast.LENGTH_LONG).show();

