package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import org.w3c.dom.Text;

public class RecordData extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView weightResult,heightResult,waistResult,bmiResult,systolicResult,diastolicResult,pulseResult
            ,glucoseResult,cholesterolResult,triglycerideResult,hdlResult,ldlResult;
    private HealthRecord healthRecord;
    int conditionColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_data);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Record Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        weightResult = (TextView)findViewById(R.id.tvWeightResult);
        heightResult = (TextView)findViewById(R.id.tvHeightResult);
        waistResult = (TextView)findViewById(R.id.tvWaistResult);
        bmiResult = (TextView)findViewById(R.id.tvBMIResult);
        systolicResult = (TextView)findViewById(R.id.tvSystolicResult);
        diastolicResult = (TextView)findViewById(R.id.tvDiastolicResult);
        pulseResult = (TextView)findViewById(R.id.tvPulseResult);
        glucoseResult = (TextView)findViewById(R.id.tvGlucoseResult);
        cholesterolResult = (TextView)findViewById(R.id.tvCholesterolResult);
        triglycerideResult = (TextView)findViewById(R.id.tvTriglycerideResult);
        hdlResult = (TextView)findViewById(R.id.tvHDLResult);
        ldlResult = (TextView)findViewById(R.id.tvLDLResult);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
//        if (title.length()>6){
//            conditionColor = Color.parseColor("#689f38");
//        }
        String text = intent.getStringExtra("text");
        heightResult.setText(text);
        weightResult.setText(title);
    }
}
