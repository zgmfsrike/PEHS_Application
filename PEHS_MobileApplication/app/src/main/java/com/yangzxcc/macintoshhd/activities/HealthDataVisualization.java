package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.yangzxcc.macintoshhd.fragments.BmiFragment;
import com.yangzxcc.macintoshhd.fragments.DiastolicFragment;
import com.yangzxcc.macintoshhd.fragments.PulseFragment;
import com.yangzxcc.macintoshhd.fragments.SystolicFragment;
import com.yangzxcc.macintoshhd.fragments.WeightFragment;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

public class HealthDataVisualization extends AppCompatActivity {
    
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager1;
    private String physicalName,physicalValue,chemName,chemValue,bloodName,bloodValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_data_visualization);
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Record Date");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager1);

        tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager1);

        Intent intent = getIntent();
        physicalName = intent.getStringExtra("physicalName");
        physicalValue = intent.getStringExtra("physicalValue");
        chemName = intent.getStringExtra("chemName");
        chemValue = intent.getStringExtra("chemValue");
        bloodName = intent.getStringExtra("bloodName");
        bloodValue = intent.getStringExtra("bloodValue");


    }
    public Bundle getData(){

        Bundle bundle = new Bundle();
        bundle.putString("physicalName",physicalName);
        bundle.putString("physicalValue",physicalValue);
        bundle.putString("chemName",chemName);
        bundle.putString("chemValue",chemValue);
        bundle.putString("bloodName",bloodName);
        bundle.putString("bloodValue",bloodValue);

        return bundle;
    }

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
