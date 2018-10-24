
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
    private String title,text,weight,height,wrist,bmi,systolic,diastolic,pulse;
    private String bloodWbc,bloodRbc,hgb,hct,mcv,mch,mchc,plt,neu,lym,mono,eos,bas;
    private String color,app,sg,ph,alb,sugar,urineRbc,urineWbc,epi;
    private String glucose,bun,creatine,uric,chol,tri,hdl,ldl,ast,alt,alp;
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

        Intent intent = getIntent();
        weight = intent.getStringExtra("weight");
        height = intent.getStringExtra("height");
        wrist = intent.getStringExtra("wrist");
        bmi = intent.getStringExtra("bmi");
        systolic = intent.getStringExtra("systolic");
        diastolic = intent.getStringExtra("diastolic");
        pulse = intent.getStringExtra("pulse");

        bloodWbc = intent.getStringExtra("bloodWbc");
        bloodRbc = intent.getStringExtra("bloodRbc");
        hgb = intent.getStringExtra("hgb");
        hct = intent.getStringExtra("hct");
        mcv = intent.getStringExtra("mcv");
        mch = intent.getStringExtra("mch");
        mchc = intent.getStringExtra("mchc");
        plt = intent.getStringExtra("plt");
        neu = intent.getStringExtra("neu");
        lym = intent.getStringExtra("lym");
        mono = intent.getStringExtra("mono");
        eos = intent.getStringExtra("eos");
        bas = intent.getStringExtra("bas");

        color = intent.getStringExtra("color");
        app = intent.getStringExtra("app");
        sg = intent.getStringExtra("sg");
        ph = intent.getStringExtra("ph");
        alb = intent.getStringExtra("albumin");
        sugar = intent.getStringExtra("sugar");
        urineRbc = intent.getStringExtra("urineRbc");
        urineWbc = intent.getStringExtra("urineWbc");
        epi = intent.getStringExtra("epi");

        glucose = intent.getStringExtra("glucose");
        bun = intent.getStringExtra("bun");
        creatine = intent.getStringExtra("creatine");
        uric = intent.getStringExtra("uric");
        chol = intent.getStringExtra("chol");
        tri = intent.getStringExtra("tri");
        hdl = intent.getStringExtra("hdl");
        ldl = intent.getStringExtra("ldl");
        ast = intent.getStringExtra("ast");
        alt = intent.getStringExtra("alt");
        alp = intent.getStringExtra("alp");
    }
    public Bundle getPhysicalData(){
        Bundle bundle = new Bundle();
        bundle.putString("weight",weight);
        bundle.putString("height",height);
        bundle.putString("wrist",wrist);
        bundle.putString("bmi",bmi);
        bundle.putString("systolic",systolic);
        bundle.putString("diastolic",diastolic);
        bundle.putString("pulse",pulse);

        return bundle;
    }
    public Bundle getBloodData(){
        Bundle bundle = new Bundle();
        bundle.putString("bloodWbc",bloodWbc);
        bundle.putString("bloodRbc",bloodRbc);
        bundle.putString("hgb",hgb);
        bundle.putString("hct",hct);
        bundle.putString("mcv",mcv);
        bundle.putString("mch",mch);
        bundle.putString("mchc",mchc);
        bundle.putString("plt",plt);
        bundle.putString("neu",neu);
        bundle.putString("lym",lym);
        bundle.putString("mono",mono);
        bundle.putString("eos",eos);
        bundle.putString("bas",bas);

        return bundle;
    }
    public Bundle getUrineData(){
        Bundle bundle = new Bundle();
        bundle.putString("color",color);
        bundle.putString("app",app);
        bundle.putString("sg",sg);
        bundle.putString("ph",ph);
        bundle.putString("alb",alb);
        bundle.putString("sugar",sugar);
        bundle.putString("urineRbc",urineRbc);
        bundle.putString("urineWbc",urineWbc);
        bundle.putString("epi",epi);

        return bundle;
    }
    public Bundle getChemistryData(){
        Bundle bundle = new Bundle();
        bundle.putString("glucose",glucose);
        bundle.putString("bun",bun);
        bundle.putString("creatine",creatine);
        bundle.putString("uric",uric);
        bundle.putString("chol",chol);
        bundle.putString("tri",tri);
        bundle.putString("hdl",hdl);
        bundle.putString("ldl",ldl);
        bundle.putString("ast",ast);
        bundle.putString("alt",alt);
        bundle.putString("alp",alp);

        return bundle;
    }
//        Intent intent = getIntent();
//        title = intent.getStringExtra("title");
//        text = intent.getStringExtra("text");

//        Intent intent = getIntent();
//
//
//        physical = (List<PhysicalInformation>)intent.getSerializableExtra("physical");
//        PhysicalInformation phy = physical.get(4);
//        phy.getPhysicalExValue();
//
//
//        chemistry = (List<ChemistryInformation>) intent.getSerializableExtra("chem");
//
//        blood = (List<BloodInformation>) intent.getSerializableExtra("blood");
//
//        urine = (List<UrineInformation>) intent.getSerializableExtra("urine");



//    public Bundle getData(){
//
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("physical", (Serializable) physical);
//        bundle.putSerializable("chem", (Serializable) chemistry);
//        bundle.putSerializable("blood", (Serializable) blood);
//        bundle.putSerializable("urine", (Serializable) urine);
//
//        return bundle;
//    }
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