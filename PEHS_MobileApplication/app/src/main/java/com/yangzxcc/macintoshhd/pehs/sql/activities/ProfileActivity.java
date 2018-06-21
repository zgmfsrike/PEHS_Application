package com.yangzxcc.macintoshhd.pehs.sql.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.pehs.sql.model.Patient;
import com.yangzxcc.macintoshhd.pehs.sql.sql.DatabaseHelper;


public class ProfileActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword, textInputLayoutName;
    TextInputEditText textInputEditTextUsername, textInputEditTextPassword, textInputEditTextName;
    AppCompatButton btnSave, btnCancel;
    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);

        textInputEditTextUsername = (TextInputEditText) findViewById(R.id.textInputEditUsername);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditPassword);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditName);

        loadData();
        btnSave = (AppCompatButton) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSave_onClick(v);
            }
        });
        btnCancel = (AppCompatButton) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, WelcomeActivity.class);
                intent.putExtra("patient", patient);
                startActivity(intent);
            }
        });
    }
    public void btnSave_onClick(View v) {
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            Patient currentPatient = databaseHelper.find(patient.getId());
            String newUsername = textInputEditTextUsername.getText().toString();
            Patient temp = databaseHelper.checkUsername(newUsername);
            if (!newUsername.equalsIgnoreCase(currentPatient.getUsername()) && temp != null) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.username_already_exist);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.show();
                return;
            }
            currentPatient.setUsername(textInputEditTextUsername.getText().toString());
            currentPatient.setName(textInputEditTextName.getText().toString());
            String password = textInputEditTextPassword.getText().toString();
            if (!password.isEmpty()) {
                currentPatient.setPassword(textInputEditTextPassword.getText().toString());
            }
            if (databaseHelper.update(currentPatient)) {
                Intent intent = new Intent(ProfileActivity.this, WelcomeActivity.class);
                intent.putExtra("patient", currentPatient);
                startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.change_profile_error);
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
    private void loadData() {
        Intent intent = getIntent();
        patient = (Patient) intent.getSerializableExtra("patient");
        textInputEditTextUsername.setText(patient.getUsername());
        textInputEditTextPassword.setText(patient.getPassword());
        textInputEditTextName.setText(patient.getName());
    }
}
