package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.pehs.R;

public class CardiovascularDetail extends AppCompatActivity {

    TextView cardio;
    private String CardioValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular_detail);

        cardio = (TextView)findViewById(R.id.tvCar);


        Intent intent = getIntent();
        CardioValue = intent.getStringExtra("score");

        cardio.setText(CardioValue+" %");
    }
}
