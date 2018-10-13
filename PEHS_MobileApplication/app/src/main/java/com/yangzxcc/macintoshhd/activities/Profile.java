package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;


public class Profile extends AppCompatActivity {


    Toolbar toolbar;
    Button btnEdit;
    String title,text;
    TextView titleR,textR;
    private List<HealthRecord> healthRecordList;
    private Profile profile;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        titleR = (TextView)findViewById(R.id.TestTitle);
        textR = (TextView)findViewById(R.id.TestText);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });



        titleR.setText(title);
        textR.setText(text);



    }
    private void getData(){
        HealthRecord current = (HealthRecord) healthRecordList;
        title = current.getTitle();
        titleR.setText(title);
    }


}
