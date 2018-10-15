package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecordInformation;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecordHistory extends AppCompatActivity{

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HealthAdapter adapter;
    private List<HealthRecord> healthRecordList;
    private Profile profile;
    HealthRecord healthRecord;
    TextView textView;
    private List<HealthRecordInformation> healthRecordInformations;
    ArrayList<String> arrayList;


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

        Intent intent = getIntent();
        healthRecordInformations = (List<HealthRecordInformation>) intent.getSerializableExtra("record");
        adapter = new HealthAdapter(healthRecordInformations);

//        String data = intent.getStringExtra("record");



//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//
//        Call<List<HealthRecord>> call = apiInterface.getPosts();
//
//       call.enqueue(new Callback<List<HealthRecord>>() {
//           @Override
//           public void onResponse(Call<List<HealthRecord>> call, Response<List<HealthRecord>> response) {
//               healthRecordList = response.body();
//               adapter = new HealthAdapter(healthRecordList);
//               recyclerView.setAdapter(adapter);
//           }
//
//           @Override
//           public void onFailure(Call<List<HealthRecord>> call, Throwable t) {
//
//           }
//       });
    }
}