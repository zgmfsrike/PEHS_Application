package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

public class RecordHistory extends AppCompatActivity{

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HealthAdapter adapter;
    private List<HealthRecordTest> healthRecordTestList;
    private Profile profile;
    HealthRecordTest healthRecordTest;
    TextView textView;
    private List<HealthRecord> healthRecords;
    private List<HealthInformation> healthInformations;
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
        healthRecords = (List<HealthRecord>) intent.getSerializableExtra("record");

        adapter = new HealthAdapter(healthRecords);
        recyclerView.setAdapter(adapter);

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
//        Call<List<HealthRecordTest>> call = apiInterface.getPosts();
//
//       call.enqueue(new Callback<List<HealthRecordTest>>() {
//           @Override
//           public void onResponse(Call<List<HealthRecordTest>> call, Response<List<HealthRecordTest>> response) {
//               healthRecordTestList = response.body();
//               adapter = new HealthAdapter(healthRecordTestList);
//               recyclerView.setAdapter(adapter);
//           }
//
//           @Override
//           public void onFailure(Call<List<HealthRecordTest>> call, Throwable t) {
//
//           }
//       });
    }
}