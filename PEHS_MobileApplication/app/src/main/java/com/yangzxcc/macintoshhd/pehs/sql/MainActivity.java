package com.yangzxcc.macintoshhd.pehs.sql;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.pehs.sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity{

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnReg, btnLogin;
    EditText editUsername, editPassword, editName, editSurname, editAddress, editEmail, editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListener();

        openHelper = new DatabaseHelper(this);
    }
    private void initViews() {
        editUsername = (EditText)findViewById(R.id.editUsername);
        editPassword= (EditText)findViewById(R.id.editPassword);
        editName = (EditText)findViewById(R.id.editName);
        editSurname = (EditText)findViewById(R.id.editSurname);
        editAddress = (EditText)findViewById(R.id.editAddress);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPhone = (EditText)findViewById(R.id.editPhone);
        btnReg = (Button)findViewById(R.id.btnReg);
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }
    private void initListener() {
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String name = editName.getText().toString();
                String surname = editSurname.getText().toString();
                String address = editAddress.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();
                insertdata(username, password, name, surname, address, email, phone);
                Toast.makeText(getApplicationContext(),"register successfully", Toast.LENGTH_LONG).show();
            }
            public void insertdata(String username, String password, String name, String surname, String address, String email, String phone){
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_USERNAME,username);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_PASSWORD,password);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_NAME,name);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_SURNAME,surname);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_ADDRESS,address);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_EMAIL,email);
                contentValues.put(DatabaseHelper.COLUMN_PATIENT_TELEPHONE_NUMBER,phone);
                long id = db.insert(DatabaseHelper.TABLE_PATIENT,null,contentValues);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
