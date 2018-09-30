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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.fragments.BloodFragment;
import com.yangzxcc.macintoshhd.fragments.ClinicalFragment;
import com.yangzxcc.macintoshhd.fragments.PhysicalFragment;
import com.yangzxcc.macintoshhd.fragments.UrineFragment;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

public class Record extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HealthAdapter healthAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Record Date");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }
    private void setupTabIcons() {

        TextView tabPhysical = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabPhysical.setText("Physical");
        tabPhysical.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.muscle, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabPhysical);

        TextView tabClinical = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabClinical.setText("Clinical");
        tabClinical.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dna, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabClinical);

        TextView tabUrine = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabUrine.setText("Urine");
        tabUrine.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.test_tube, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabUrine);

        TextView tabBlood = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabBlood.setText("Blood");
        tabBlood.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.water, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabBlood);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new PhysicalFragment(), "Physical");
        adapter.addFrag(new BloodFragment(), "Blood");
        adapter.addFrag(new UrineFragment(), "Urine");
        adapter.addFrag(new ClinicalFragment(), "Clinical");

        viewPager.setAdapter(adapter);
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
