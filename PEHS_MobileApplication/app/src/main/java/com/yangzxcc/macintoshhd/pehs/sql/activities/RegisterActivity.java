package com.yangzxcc.macintoshhd.pehs.sql.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;


import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.pehs.sql.model.Patient;
import com.yangzxcc.macintoshhd.pehs.sql.sql.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private final AppCompatActivity activity = RegisterActivity.this;

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword, textInputLayoutName;
    TextInputEditText textInputEditTextUsername, textInputEditTextPassword, textInputEditTextName;
    AppCompatButton btnReg, btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);

        textInputEditTextUsername = (TextInputEditText) findViewById(R.id.textInputEditUsername);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditPassword);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditName);

        btnReg = (AppCompatButton) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnReg_onClick(v);
            }
        });
        btnCancel = (AppCompatButton) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btnReg_onClick(View v) {
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            Patient patient = new Patient();
            patient.setName(textInputEditTextName.getText().toString());
            patient.setPassword(textInputEditTextPassword.getText().toString());
            patient.setUsername(textInputEditTextUsername.getText().toString());
            Patient temp = databaseHelper.checkUsername(textInputEditTextUsername.getText().toString());
            if (temp == null) {
                if (databaseHelper.create(patient)) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle(R.string.error);
                    builder.setMessage(R.string.cannot_create_account);
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.username_already_exist);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(e.getMessage());
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
}
