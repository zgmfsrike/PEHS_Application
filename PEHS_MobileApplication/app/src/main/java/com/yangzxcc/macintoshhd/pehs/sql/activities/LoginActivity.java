package com.yangzxcc.macintoshhd.pehs.sql.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.pehs.sql.model.Patient;
import com.yangzxcc.macintoshhd.pehs.sql.sql.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    TextInputEditText textInputEditUsername, textInputEditPassword;
    AppCompatButton btnLogin, btnReg;

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
                btnLogin_onClick(v);
            }
        });
        btnReg = (AppCompatButton) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnReg_onClick(v);

            }
        });
    }
    public void btnLogin_onClick(View v) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        String username = textInputEditUsername.getText().toString();
        String password = textInputEditPassword.getText().toString();
        Patient patient = databaseHelper.login(username, password);
        if (patient == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.invalid_account);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            builder.show();
        } else {
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            intent.putExtra("patient", patient);
            startActivity(intent);
        }
    }
    public void btnReg_onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}



