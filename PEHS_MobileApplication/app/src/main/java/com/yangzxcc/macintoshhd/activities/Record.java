
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
        import android.widget.TextView;

        import com.yangzxcc.macintoshhd.HealthAdapter;
        import com.yangzxcc.macintoshhd.fragments.PhysicalFragment;
        import com.yangzxcc.macintoshhd.fragments.BloodFragment;
        import com.yangzxcc.macintoshhd.fragments.ClinicalFragment;
        import com.yangzxcc.macintoshhd.fragments.UrineFragment;
        import com.yangzxcc.macintoshhd.infos.BloodInformation;
        import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
        import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
        import com.yangzxcc.macintoshhd.infos.UrineInformation;
        import com.yangzxcc.macintoshhd.models.HealthRecordTest;
        import com.yangzxcc.macintoshhd.pehs.R;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

public class Record extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public HealthAdapter healthAdapter;
    private HealthRecordTest model;
    private String title,text;
    List<PhysicalInformation> physical;
    List<ChemistryInformation> chemistry;
    List<BloodInformation> blood;
    List<UrineInformation> urine;
    PhysicalInformation phy;
    ChemistryInformation chem;
    BloodInformation bloo;
    UrineInformation uri;


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

//        Intent intent = getIntent();
//        title = intent.getStringExtra("title");
//        text = intent.getStringExtra("text");

        Intent intent = getIntent();


        physical = (List<PhysicalInformation>)intent.getSerializableExtra("physical");
        PhysicalInformation phy = physical.get(4);
        phy.getPhysicalExValue();



        chemistry = (List<ChemistryInformation>) intent.getSerializableExtra("chem");

        blood = (List<BloodInformation>) intent.getSerializableExtra("blood");

        urine = (List<UrineInformation>) intent.getSerializableExtra("urine");

    }
    public Bundle getData(){

        Bundle bundle = new Bundle();
        bundle.putSerializable("physical", (Serializable) physical);
        bundle.putSerializable("chem", (Serializable) chemistry);
        bundle.putSerializable("blood", (Serializable) blood);
        bundle.putSerializable("urine", (Serializable) urine);

        return bundle;
    }
//    public Bundle getData(){
//
//        Bundle bundle = new Bundle();
//        bundle.putString("title",title);
//        bundle.putString("text",text);
//
//        return bundle;
//    }
    private void setupTabIcons() {

        TextView tabPhysical = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabPhysical.setText("Physical");
        tabPhysical.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.muscle, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabPhysical);

        TextView tabBlood = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabBlood.setText("Blood");
        tabBlood.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.water, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabBlood);

        TextView tabUrine = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabUrine.setText("Urine");
        tabUrine.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.test_tube, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabUrine);

        TextView tabClinical = (TextView) LayoutInflater.from(this).inflate(R.layout.record_tab, null);
        tabClinical.setText("Clinical");
        tabClinical.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dna, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabClinical);


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new PhysicalFragment(), "Physical");
        adapter.addFrag(new BloodFragment(), "Blood");
        adapter.addFrag(new UrineFragment(), "Urine");
        adapter.addFrag(new ClinicalFragment(), "Chemistry");

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