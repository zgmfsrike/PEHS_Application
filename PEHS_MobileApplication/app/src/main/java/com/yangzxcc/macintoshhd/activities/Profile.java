package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yangzxcc.macintoshhd.pehs.R;


public class Profile extends AppCompatActivity {



    Button btnEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btnEdit = (Button) findViewById(R.id.btnEdit);
        loadData();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,EditProfile.class));
                finish();
            }
        });

    }

    private void loadData() {
    }

}
