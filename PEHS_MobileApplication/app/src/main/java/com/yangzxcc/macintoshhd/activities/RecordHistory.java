package com.yangzxcc.macintoshhd.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.HealthRecord;
import com.yangzxcc.macintoshhd.JsonPlaceHolderApi;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecordHistory extends AppCompatActivity {
    private TextView tvId,tvUserId,tvText,tvTitle;
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


//        healthRecordList = new ArrayList<>();
//
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HealthAdapter(healthRecordList,this);
        recyclerView.setAdapter(adapter);

        tvTitle = findViewById(R.id.tvTitle);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<HealthRecord> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<HealthRecord>() {
            @Override
            public void onResponse(Call<HealthRecord> call, Response<HealthRecord> response) {
                HealthRecord healthRecord = response.body();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HealthRecord> call, Throwable t) {

            }
        });
    }
}