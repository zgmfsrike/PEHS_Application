package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yangzxcc.macintoshhd.ApiInterface;
import com.yangzxcc.macintoshhd.models.Patient;
import com.yangzxcc.macintoshhd.pehs.R;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity{

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditUsername, textInputEditPassword;
    AppCompatButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);
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
            textInputEditUsername.setError("Please fill out this fields");
            textInputEditUsername.requestFocus();
            return;
        }else if (password.isEmpty()){
            textInputEditPassword.setError("Please fill out this fields");
            textInputEditPassword.requestFocus();
            return;
        }
        startActivity(new Intent(Login.this,Home.class));
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        retrofit2.Call<Patient> call = apiInterface.performPatientLogin(username, password);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(retrofit2.Call<Patient> call, Response<Patient> response) {


            }

            @Override
            public void onFailure(retrofit2.Call<Patient> call, Throwable t) {

            }
        });
    }
}



