package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.infos.UrineInformation;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private HealthAdapter adapter;
    private List<HealthRecordTest> healthRecordTestList;
    String token;
    List<PersonalInformation> personalInformations;
    List<HealthInformation> healthInformations;
    List<HealthRecord> healthRecords;
    List<PhysicalInformation> physicalInformations;
    List<ChemistryInformation> chemistryInformations;
    List<BloodInformation> bloodInformations;
    List<UrineInformation> urineInformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Retrofit retrofit = ApiClient.getRetrofit();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        final Intent intent = getIntent();
        token = intent.getStringExtra("token");

        Call<InformationManager> call1 = apiInterface.getInfo("Bearer " + token);
        call1.enqueue(new Callback<InformationManager>() {
            @Override
            public void onResponse(Call<InformationManager> call, Response<InformationManager> response) {
                if (response.isSuccessful()) {
                    personalInformations = response.body().getPersonalInformation();
                    healthInformations = response.body().getHealthInformation();


//                    HealthInformation health = healthInformations.get(0);
//                    healthRecords = health.getHealthRecords();

//                    for (int i = 0; i < healthRecords.size(); i++) {
//
//                    }
//                    HealthRecord record = healthRecords.get(0);
//                    physicalInformations = record.getPhysicalInformation();
//                    chemistryInformations = record.getChemistryInformation();
//                    bloodInformations = record.getBloodInformation();
//                    urineInformations = record.getUrineInformation();

//                    PhysicalInformation phy = physicalInformations.get(0);
//                    phy.getPhysicalExName();
//                    phy.getPhysicalExValue();
                }
            }

            @Override
            public void onFailure(Call<InformationManager> call, Throwable t) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_profile) {

            for (int i = 0; i < personalInformations.size(); i++) {
                PersonalInformation value = personalInformations.get(i);

                value.getName();
                value.getSurname();
                value.getEmail();
                value.getAddress();
                value.getGender();
                value.getDateOfBirth();
                value.getTelephoneNumber();
                value.getDrugAllergy();
                value.getUnderlyingDisease();
                Intent intent1 = new Intent(Home.this, Profile.class);
                intent1.putExtra("name", value.getName());
                intent1.putExtra("surname", value.getSurname());
                intent1.putExtra("email", value.getEmail());
                intent1.putExtra("address", value.getAddress());
                intent1.putExtra("gender", value.getGender());
                intent1.putExtra("date", value.getDateOfBirth());
                intent1.putExtra("phone", value.getTelephoneNumber());
                intent1.putExtra("drug", value.getDrugAllergy());
                intent1.putExtra("disease", value.getUnderlyingDisease());
                startActivity(intent1);
            }

        } else if (id == R.id.nav_record_history) {

                HealthInformation health = healthInformations.get(0);
                health.getHealthRecords();

//                healthRecords = health.getHealthRecords();
//                HealthRecord record = healthRecords.get(0);
//                physicalInformations = record.getPhysicalInformation();
//                chemistryInformations = record.getChemistryInformation();
//                bloodInformations = record.getBloodInformation();
//                urineInformations = record.getUrineInformation();
                Intent intent = new Intent(Home.this, RecordHistory.class);
                intent.putExtra("record", (Serializable) health.getHealthRecords());
//                healthRecords = new ArrayList<HealthRecord>();
//                intent.putExtra("record", (Serializable) healthRecords);
                startActivity(intent);


        } else if (id == R.id.nav_car) {
            PersonalInformation value = personalInformations.get(0);
            Intent intent = new Intent(Home.this, Cardiovascular.class);
            physicalInformations = new ArrayList<PhysicalInformation>();
            chemistryInformations = new ArrayList<ChemistryInformation>();
            value.getDateOfBirth();
            intent.putExtra("date", value.getDateOfBirth());
            intent.putExtra("physical", (Serializable) physicalInformations);
            intent.putExtra("chem", (Serializable) chemistryInformations);
            startActivity(intent);

        } else if (id == R.id.nav_health) {
            Intent intent = new Intent(Home.this, HealthDataList.class);
            physicalInformations = new ArrayList<PhysicalInformation>();
            chemistryInformations = new ArrayList<ChemistryInformation>();
            bloodInformations = new ArrayList<BloodInformation>();
            urineInformations = new ArrayList<UrineInformation>();
            intent.putExtra("physical", (Serializable) physicalInformations);
            intent.putExtra("chemical", (Serializable) chemistryInformations);
            intent.putExtra("blood", (Serializable) bloodInformations);
            intent.putExtra("urine", (Serializable) urineInformations);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }
}