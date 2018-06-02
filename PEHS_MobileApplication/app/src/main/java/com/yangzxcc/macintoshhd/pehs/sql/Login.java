package com.yangzxcc.macintoshhd.pehs.sql;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yangzxcc.macintoshhd.pehs.R;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    InputValidation inputValidation;
    Cursor cursor;
    Button btnLogin, btnReg;
    EditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initObjects();
        initViews();
        initListeners();
    }

    private void initObjects() {
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        inputValidation = new InputValidation(this);

    }

    private void initViews() {
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnReg = (Button) findViewById(R.id.btnReg);
    }

    private void initListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_PATIENT + " WHERE " + DatabaseHelper.COLUMN_PATIENT_USERNAME + "=? AND " + DatabaseHelper.COLUMN_PATIENT_PASSWORD + "=? ", new String[]{username, password});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        verifyFromSQlite();
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void verifyFromSQlite() {

    }

}



