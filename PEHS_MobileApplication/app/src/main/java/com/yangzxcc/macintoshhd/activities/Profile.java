package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.pehs.R;


public class Profile extends AppCompatActivity {


    Toolbar toolbar;
    TextView name,surname,email,address,gender,dob,tel,drug,underlying;
    String name1,surname1,email1,address1,gender1,tel1,drug1,underlying1;
    String dob1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView)findViewById(R.id.name);
        surname = (TextView)findViewById(R.id.surname);
        email = (TextView)findViewById(R.id.email);
        address = (TextView)findViewById(R.id.address);
        gender = (TextView)findViewById(R.id.gender);
        dob = (TextView)findViewById(R.id.date);
        tel = (TextView)findViewById(R.id.tele);
        drug = (TextView)findViewById(R.id.drug);
        underlying = (TextView)findViewById(R.id.under);


        Intent intent = getIntent();
        name1 = intent.getStringExtra("name");
        surname1 = intent.getStringExtra("surname");
        email1 = intent.getStringExtra("email");
        address1 = intent.getStringExtra("address");
        gender1 = intent.getStringExtra("gender");
        dob1 = intent.getStringExtra("date");
        tel1 = intent.getStringExtra("phone");
        drug1 = intent.getStringExtra("drug");
        underlying1 = intent.getStringExtra("disease");

        name.setText(name1);
        surname.setText(surname1);
        email.setText(email1);
        address.setText(address1);
        gender.setText(gender1);
        dob.setText(dob1);
        tel.setText(tel1);
        drug.setText(drug1);
        underlying.setText(underlying1);
    }
}
