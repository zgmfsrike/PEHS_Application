package com.yangzxcc.macintoshhd.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.ApiInterface;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecordHistory extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
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
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);



//        adapter = new HealthAdapter(healthRecordList,this);
//        recyclerView.setAdapter(adapter);

//        tvTitle = findViewById(R.id.tvTitle);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<HealthRecord>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<HealthRecord>>() {
            @Override
            public void onResponse(Call<List<HealthRecord>> call, Response<List<HealthRecord>> response) {
                if (response.isSuccessful()){
                    healthRecordList = response.body();
                    adapter = new HealthAdapter(healthRecordList);
                    recyclerView.setAdapter(adapter);
                }else {

                }
            }

            @Override
            public void onFailure(Call<List<HealthRecord>> call, Throwable t) {
//                healthRecordList.add(new HealthRecord(1,1,"eiei","ddd"));
//                adapter = new HealthAdapter(healthRecordList);
//                recyclerView.setAdapter(adapter);
            }
        });

    }
}