package com.yangzxcc.macintoshhd.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.activities.physical.BmiFragment;
import com.yangzxcc.macintoshhd.activities.physical.DiastolicFragment;
import com.yangzxcc.macintoshhd.activities.physical.PulseFragment;
import com.yangzxcc.macintoshhd.activities.physical.SystolicFragment;
import com.yangzxcc.macintoshhd.activities.physical.WeightFragment;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

public class HealthPhysicalVisualization extends AppCompatActivity {
    
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager1;
    private String physicalName,physicalValue,chemName,chemValue,bloodName,bloodValue,value,date;
    List<ChemistryInformation> chemical;
    List<BloodInformation> blood;
    List<PhysicalInformation> physical,physicalInformations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_physical_visualization);
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Physical");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager1);

        tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager1);




//        Intent intent = getIntent();
//        physical = (List<PhysicalInformation>) intent.getSerializableExtra("physicalName");
//
//
//        physicalValue = intent.getStringExtra("physicalValue");
//        chemName = intent.getStringExtra("chemName");
//        chemValue = intent.getStringExtra("chemValue");
//        bloodName = intent.getStringExtra("bloodName");
//        bloodValue = intent.getStringExtra("bloodValue");
//
//        physical = (List<PhysicalInformation>)intent.getSerializableExtra("physical");
//        PhysicalInformation phy = physical.get(4);
//        phy.getPhysicalExValue();

//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImUwYjY0NGM2NTBjMWM0ZGNhZTU5MDZiMTU2ODc2N2M1NmQ1ZWVjYWY1ZWE0NWU4NDQwNGZkMDdhYTQ0NDg3NzczZjM4OTg2ZjUxOGUyYmZmIn0.eyJhdWQiOiIxIiwianRpIjoiZTBiNjQ0YzY1MGMxYzRkY2FlNTkwNmIxNTY4NzY3YzU2ZDVlZWNhZjVlYTQ1ZTg0NDA0ZmQwN2FhNDQ0ODc3NzNmMzg5ODZmNTE4ZTJiZmYiLCJpYXQiOjE1Mzk0MDk5NzAsIm5iZiI6MTUzOTQwOTk3MCwiZXhwIjoxNTcwOTQ1OTcwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.Kp88GX4sgbKRcTEH43yGrGH3n9CLLuNvDW9Tdy1XyJ_xMBi5zqfKcuEDhdrTd4GrbVzD3H6BM1R8f6pwU-L77RRLKV0uO1oFyiwdaFRlFN-qlkALkD9Rtm7IRAG5Crzj8FwKiqLpMdf5vjHdHkqdZjUktMerX1N4FUZvuhAsulyr7IAWPfb23hd6N5NE5yjNGEPfFH1KxNVggBq9hv34pdLp3AydwX-Op_-4WkeMWs0InSZ9Ufb4WTavXjXHhS0B5__qzA40_dka1iNNY8qpBGKyqAiMwgFZBYq_X1BNBCy_YYqd15xANhlgUVoa4g-RDkLmiiamss-KUy39Vg3XqEwMbdCGvF_JAm5APSI8hyImcUOiBVVuksZVnr2PM1uu5um1wKybq5mhCes0gQQpdf32SEs_HtEF3MmQOfhFAxsvzwHV63bhUqeGwuqp4er3Dahs3jtdzSATrpwtBmP-4K3oYDybkmm5wgKn8bTf_jSVjRVA45HpzKsgXQQq-RY9UtH5SIg3m4dhDTyR1VKRzsA9Gb4pIRaXlOqrTqskL2PiqTgp8Dp4pdOdUQSSFtsobagCd-3ObaTCTvqASCHMMM_dxmUQtKyLMMXYhbHkBceuzVG5uEZTcgFRvDtz0Bffa_0UvbfTvy5F2U9aams2tWxYxQOshj5at1fcEV4gRUI";
//        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//
//        Call<HealthRecord> call = apiInterface.getHealthRecord("Bearer "+token);
//
//        call.enqueue(new Callback<HealthRecord>() {
//            @Override
//            public void onResponse(Call<HealthRecord> call, Response<HealthRecord> response) {
//                if (response.isSuccessful()){
//                    physicalInformations = response.body().getPhysicalInformation();
//                    date = response.body().getDate();
//                    Log.e("tag","ss"+date);
//                    Log.e("tag","ss"+physicalInformations);
//                }else {
//                    Log.e("tag","ss"+date);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<HealthRecord> call, Throwable t) {
//                Log.e("tag","ss"+t.getMessage());
//            }
//        });
//        Call<PhysicalInformation> call = apiInterface.getPhysical("Bearer "+token);
//
//        call.enqueue(new Callback<PhysicalInformation>() {
//            @Override
//            public void onResponse(Call<PhysicalInformation> call, Response<PhysicalInformation> response) {
//                 value = response.body().getPhysicalExValue();
//
//            }
//
//            @Override
//            public void onFailure(Call<PhysicalInformation> call, Throwable t) {
//
//            }
//        });





    }
//    public Bundle getPhysical(){
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("physical", (Serializable) physicalInformations);
//        bundle.putSerializable("date",date);
//        return bundle;
//    }
//    public Bundle getListOfData(){
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("physical", (Serializable) physical);
//        bundle.putSerializable("chemical", (Serializable) chemical);
//        bundle.putSerializable("blood", (Serializable) blood);
//        return bundle;
//    }
//    public Bundle getData(){
//
//        Bundle bundle = new Bundle();
//        bundle.putString("physicalName",physicalName);
//        bundle.putString("physicalValue",physicalValue);
//        bundle.putString("chemName",chemName);
//        bundle.putString("chemValue",chemValue);
//        bundle.putString("bloodName",bloodName);
//        bundle.putString("bloodValue",bloodValue);
//
//        return bundle;
//    }

    private void setupViewPager(ViewPager viewPager1) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WeightFragment(), "Weight");
        adapter.addFrag(new BmiFragment(), "BMI");
        adapter.addFrag(new SystolicFragment(), "Systolic");
        adapter.addFrag(new DiastolicFragment(), "Diastolic");
        adapter.addFrag(new PulseFragment(), "Pulse");
        viewPager1.setAdapter(adapter);

    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
