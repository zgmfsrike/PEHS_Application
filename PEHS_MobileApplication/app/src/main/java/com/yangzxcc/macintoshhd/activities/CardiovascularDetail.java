package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.pehs.R;

public class CardiovascularDetail extends AppCompatActivity {

    Toolbar toolbar;
    TextView cardio,cardioDetail;
    private String CardioValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cardiovascular Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardio = (TextView)findViewById(R.id.tvCar);
//        cardioDetail = (TextView)findViewById(R.id.cardioDetail);

        Intent intent = getIntent();
        CardioValue = intent.getStringExtra("score");

        cardio.setText(CardioValue+" %");
    }
}
