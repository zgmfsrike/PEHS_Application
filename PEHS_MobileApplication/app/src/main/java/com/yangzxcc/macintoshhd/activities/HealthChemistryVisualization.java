package com.yangzxcc.macintoshhd.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.yangzxcc.macintoshhd.activities.chemistry.CholesterolFragment;
import com.yangzxcc.macintoshhd.activities.chemistry.GlucoseFragment;
import com.yangzxcc.macintoshhd.activities.chemistry.HDLFragment;
import com.yangzxcc.macintoshhd.activities.chemistry.LDLFragment;
import com.yangzxcc.macintoshhd.activities.chemistry.TriglycerideFragment;
import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.physical.BmiFragment;
import com.yangzxcc.macintoshhd.physical.DiastolicFragment;
import com.yangzxcc.macintoshhd.physical.PulseFragment;
import com.yangzxcc.macintoshhd.physical.SystolicFragment;
import com.yangzxcc.macintoshhd.physical.WeightFragment;

import java.util.ArrayList;
import java.util.List;

public class HealthChemistryVisualization extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_chemistry_visualization);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chemistry");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager1);

        tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager1);
    }

    private void setupViewPager(ViewPager viewPager1) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new GlucoseFragment(), "Glucose");
        adapter.addFrag(new CholesterolFragment(), "Cholesterol");
        adapter.addFrag(new TriglycerideFragment(), "Triglyceride");
        adapter.addFrag(new HDLFragment(), "HDL");
        adapter.addFrag(new LDLFragment(), "LDL");
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
