package com.yangzxcc.macintoshhd.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

public class RecordHistory extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HealthAdapter adapter;
    private List<HealthRecord> healthRecordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_history);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Health Record History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        healthRecordList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        healthRecordList.add(new HealthRecord(
                1,"Date 10/06/18"
        ));
        healthRecordList.add(new HealthRecord(
                2,"Date 23/06/18"
        ));
        healthRecordList.add(new HealthRecord(
                3,"Date 27/06/18"
        ));
        healthRecordList.add(new HealthRecord(
                4,"Date 12/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                5,"Date 16/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                6,"Date 20/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                7,"Date 23/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                8,"Date 28/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                2,"Date 30/07/18"
        ));
        healthRecordList.add(new HealthRecord(
                9,"Date 03/08/18"
        ));
        healthRecordList.add(new HealthRecord(
                10,"Date 08/08/18"
        ));
        healthRecordList.add(new HealthRecord(
                11,"Date 14/08/18"
        ));
        healthRecordList.add(new HealthRecord(
                12,"Date 19/08/18"
        ));
        healthRecordList.add(new HealthRecord(
                13,"Date 25/08/18"
        ));
        healthRecordList.add(new HealthRecord(
                14,"Date 29/08/18"
        ));

       adapter = new HealthAdapter(healthRecordList,this);
       recyclerView.setAdapter(adapter);
    }
}
