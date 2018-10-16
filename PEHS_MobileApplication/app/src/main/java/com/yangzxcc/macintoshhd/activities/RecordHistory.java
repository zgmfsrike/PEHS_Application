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
import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        Intent intent = getIntent();
        healthRecords= (List<HealthRecord>) intent.getSerializableExtra("record");
        adapter = new HealthAdapter(healthRecords);
        recyclerView.setAdapter(adapter);



//
//        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//
//        String token;
//        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImUwYjY0NGM2NTBjMWM0ZGNhZTU5MDZiMTU2ODc2N2M1NmQ1ZWVjYWY1ZWE0NWU4NDQwNGZkMDdhYTQ0NDg3NzczZjM4OTg2ZjUxOGUyYmZmIn0.eyJhdWQiOiIxIiwianRpIjoiZTBiNjQ0YzY1MGMxYzRkY2FlNTkwNmIxNTY4NzY3YzU2ZDVlZWNhZjVlYTQ1ZTg0NDA0ZmQwN2FhNDQ0ODc3NzNmMzg5ODZmNTE4ZTJiZmYiLCJpYXQiOjE1Mzk0MDk5NzAsIm5iZiI6MTUzOTQwOTk3MCwiZXhwIjoxNTcwOTQ1OTcwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.Kp88GX4sgbKRcTEH43yGrGH3n9CLLuNvDW9Tdy1XyJ_xMBi5zqfKcuEDhdrTd4GrbVzD3H6BM1R8f6pwU-L77RRLKV0uO1oFyiwdaFRlFN-qlkALkD9Rtm7IRAG5Crzj8FwKiqLpMdf5vjHdHkqdZjUktMerX1N4FUZvuhAsulyr7IAWPfb23hd6N5NE5yjNGEPfFH1KxNVggBq9hv34pdLp3AydwX-Op_-4WkeMWs0InSZ9Ufb4WTavXjXHhS0B5__qzA40_dka1iNNY8qpBGKyqAiMwgFZBYq_X1BNBCy_YYqd15xANhlgUVoa4g-RDkLmiiamss-KUy39Vg3XqEwMbdCGvF_JAm5APSI8hyImcUOiBVVuksZVnr2PM1uu5um1wKybq5mhCes0gQQpdf32SEs_HtEF3MmQOfhFAxsvzwHV63bhUqeGwuqp4er3Dahs3jtdzSATrpwtBmP-4K3oYDybkmm5wgKn8bTf_jSVjRVA45HpzKsgXQQq-RY9UtH5SIg3m4dhDTyR1VKRzsA9Gb4pIRaXlOqrTqskL2PiqTgp8Dp4pdOdUQSSFtsobagCd-3ObaTCTvqASCHMMM_dxmUQtKyLMMXYhbHkBceuzVG5uEZTcgFRvDtz0Bffa_0UvbfTvy5F2U9aams2tWxYxQOshj5at1fcEV4gRUI";
//
//        Call<InformationManager> call = apiInterface.getInfo("Bearer "+token);
//        call.enqueue(new Callback<InformationManager>() {
//            @Override
//            public void onResponse(Call<InformationManager> call, Response<InformationManager> response) {
//                if (response.isSuccessful()){
//                    healthInformations = response.body().getHealthInformation();
//                    adapter = new HealthAdapter(healthInformations);
//                    recyclerView.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<InformationManager> call, Throwable t) {
//
//            }
//        });

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