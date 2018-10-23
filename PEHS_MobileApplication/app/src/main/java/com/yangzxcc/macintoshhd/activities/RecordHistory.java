package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.manager.InformationSingleton;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecordHistory extends AppCompatActivity{

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HealthAdapter adapter;
    private List<HealthRecordTest> healthRecordTestList;
    private Profile profile;
    HealthRecordTest healthRecordTest;
    TextView textView;
    private List<HealthInformation> healthInformations;
    ArrayList<String> arrayList;
    private HealthRecord healthRecord;
    private List<HealthRecord> healthRecords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_history);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Health Record History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        adapter = new HealthAdapter(InformationSingleton.getInstance().getInformation().getHealthInformation());
        recyclerView.setAdapter(adapter);


    }
}