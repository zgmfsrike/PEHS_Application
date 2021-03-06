package com.yangzxcc.macintoshhd.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yangzxcc.macintoshhd.TokenManager;
import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.Information;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.infos.UrineInformation;
import com.yangzxcc.macintoshhd.manager.InformationSingleton;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.pehs.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView name;
    private Toolbar toolbar;
    private List<HealthRecordTest> healthRecordTestList;
    String token;
    List<PersonalInformation> personalInformations;
    List<HealthInformation> healthInformations;
    List<HealthRecord> healthRecords;
    List<PhysicalInformation> physicalInformations;
    List<ChemistryInformation> chemistryInformations;
    List<BloodInformation> bloodInformations;
    List<UrineInformation> urineInformations;
    HealthRecord healthRecord;
    TokenManager tokenManager;
    JSONObject c;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


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

//        PersonalInformation value = personalInformations.get(0);
//        String data = value.getName();
//        name = (TextView)findViewById(R.id.homeName);
//        name.setText(data);


//        final Intent intent = getIntent();
//        token = intent.getStringExtra("token");
        SharedPreferences preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
        token = preferences.getString("token","");
        getUserInformation(token);
    }

    private void getUserInformation(String token) {

        Retrofit retrofit;
        ApiInterface apiInterface;
        Call<Information> call1;

        if (token == null){
             retrofit = ApiClient.getMockUpRetrofit();
             apiInterface = retrofit.create(ApiInterface.class);
//             call1 = apiInterface.getMockUpInfo();
            call1 = apiInterface.getMock();
//            Log.e("Output","1   "+token);
        }else {
             retrofit = ApiClient.getRetrofit();
             apiInterface = retrofit.create(ApiInterface.class);
             call1 = apiInterface.getInfo("Bearer "+this.token);
//            Log.e("Output ddd","Token is here   "+token);
        }

        call1.enqueue(new Callback<Information>() {
            @Override
            public void onResponse(Call<Information> call, Response<Information> response) {
                if (response.isSuccessful()) {

                    if (response.body() == null) {
                        try {
                            Log.w("Output","NO data :"+response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        InformationSingleton.getInstance().setInformation(response.body());
                        Log.w("SUCCESS !","SUCCESS :"+response.body());
                        personalInformations = response.body().getPersonalInformation();
                        healthInformations = response.body().getHealthInformation();
                        Log.w("Record","Total record is "+healthInformations.size());
                        Log.w("Data","Data receive"+new Gson().toJson(InformationSingleton.getInstance().getInformation().getHealthInformation()));
//                        JSONObject jsonResult = new JSONObject();
//                        try {
//                            JSONArray arr = jsonResult.getJSONArray("health_information");
//                            c = arr.getJSONObject(0);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }

                        if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0)
                        {
                            System.out.println(InformationSingleton.getInstance().getInformation().getHealthInformation().get(0).getWeight());
//                            System.out.println(InformationSingleton.getInstance().getInformation().getHealthInformation().get(1).getWeight());
                        }else {
                            System.out.println("..");
                        }
                    }

//                    healthInformations = response.body().getHealthInformation();


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
                }else {
                    try {
                        Log.e("Output","response not successful"+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Information> call, Throwable t) {
                Log.e("Output","fail to connect"+t.getMessage());
            }
        });
    }
//        call1.enqueue(new Callback<Information>() {
//            @Override
//            public void onResponse(@NonNull Call<Information> call, @NonNull Response<Information> response) {
//                if (response.isSuccessful()) {
//
//                    if (response.body() == null) {
//                        try {
//                            Log.e("Output","NO data :"+response.errorBody().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }else {
//                        InformationSingleton.getInstance().setInformation(response.body());
//                        Log.e("SUCCESS !","SUCCESS :"+response.body());
//                        personalInformations = response.body().getPersonalInformation();
//                    }
//
////                    healthInformations = response.body().getHealthInformation();
//
//
////                    HealthInformation health = healthInformations.get(0);
////                    healthRecords = health.getHealthRecords();
//
////                    for (int i = 0; i < healthRecords.size(); i++) {
////
////                    }
////                    HealthRecord record = healthRecords.get(0);
////                    physicalInformations = record.getPhysicalInformation();
////                    chemistryInformations = record.getChemistryInformation();
////                    bloodInformations = record.getBloodInformation();
////                    urineInformations = record.getUrineInformation();
//
////                    PhysicalInformation phy = physicalInformations.get(0);
////                    phy.getPhysicalExName();
////                    phy.getPhysicalExValue();
//                }else {
//                    try {
//                        Log.e("Output","response not successful"+response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Information> call, Throwable t) {
//                Log.e("Output","fail to connect"+t.getMessage());
//            }
//        });
//    }


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
            Intent intent = new Intent(Home.this,RecordHistory.class);
            intent.putExtra("token",token);
            startActivity(intent);


//       Oat Did -------------------------------------------------------------
//            Intent intent = new Intent(Home.this, RecordHistory.class);
//                Log.e("Size : ",""+healthInformations.size());
//                List<HealthInformation> health = healthInformations;
//                HealthRecord[] arr = new HealthRecord[healthInformations.size()];
//                for (int i = 0; i < healthInformations.size(); i++){
//                    arr[i] = health.get(i).getHealthRecords();
//                }
//
//                healthRecords = new ArrayList<HealthRecord>();
//                intent.putExtra("record", (Serializable) healthRecords);
//
//            intent.putExtra("record", (Serializable) healthRecords);
//            startActivity(intent);
//            Oat Did -------------------------------------------------------------




//      Working Code  Get only 1---------------------------------------------------------------
//            Intent intent = new Intent(Home.this, RecordHistory.class);
//                for (int j = 0; j < healthInformations.size() ; j++) {
//
//                Log.e("Size : ",""+healthInformations.size());
//                HealthInformation health = healthInformations.get(j);
//                healthRecords = health.getHealthRecords();
//
//                intent.putExtra("record", (Serializable) healthRecords);
//            }
//            startActivity(intent);
//       Working Code  Get only 1---------------------------------------------------------------
//                for (int i = 0; i < healthRecords.size(); i++) {
//                    Log.e("Size",""+healthRecords.size());
//                healthRecords.get(i);
//
//
//            }

//                healthRecords = health.getHealthRecords();
//                HealthRecord record = healthRecords.get(0);
//                physicalInformations = record.getPhysicalInformation();
//                chemistryInformations = record.getChemistryInformation();
//                bloodInformations = record.getBloodInformation();
//                urineInformations = record.getUrineInformation();


        } else if (id == R.id.nav_car) {
            Intent intent = new Intent(Home.this,Cardiovascular.class);
            PersonalInformation value = personalInformations.get(0);
            value.getDateOfBirth();
            intent.putExtra("date",value.getDateOfBirth());
            startActivity(intent);
//
//            intent.putExtra("",);


//
//
//            Intent intent = new Intent(Home.this, Cardiovascular.class);
//            PersonalInformation value = personalInformations.get(0);
//            Bundle data = new Bundle();
//            data.putSerializable("date",value.getDateOfBirth());
//            intent.putExtra("date", value.getDateOfBirth());
//            intent.putExtra("physical", (Serializable) physicalInformations);
//            intent.putExtra("chem", (Serializable) chemistryInformations);


        } else if (id == R.id.nav_health) {
            Intent intent = new Intent(Home.this, HealthDataList.class);
                startActivity(intent);
//            if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0){
//                Intent intent = new Intent(Home.this, HealthDataList.class);
//                startActivity(intent);
//            }else {
//                Intent intent = new Intent(Home.this, HealthDataCheck.class);
//                startActivity(intent);
//            }


//-----------------------------------------------------------------------------------------------------
//            List<HealthRecord> datalist = (List<HealthRecord>) healthInformations.get(0);
//            HealthRecord data = datalist.get(0);
//            data.getChemistryInformation();
//            data.getBloodInformation();
//            data.getPhysicalInformation();
//            intent.putExtra("physical", (Serializable) data.getPhysicalInformation());
//            intent.putExtra("chemical", (Serializable) data.getChemistryInformation());
//            intent.putExtra("blood", (Serializable) data.getBloodInformation());
//            startActivity(intent);
//-----------------------------------------------------------------------------
//            physicalInformations.get(0);
//            chemistryInformations.get(0);
//            bloodInformations.get(0);
//            urineInformations.get(0);
//            intent.putExtra("physical", (Serializable) physicalInformations);
//            intent.putExtra("chemical", (Serializable) chemistryInformations);
//            intent.putExtra("blood", (Serializable) bloodInformations);
//            intent.putExtra("urine", (Serializable) urineInformations);


//---------------------------------------------------------------------------------------
//            Intent intent = new Intent(Home.this, HealthDataList.class);
//            physicalInformations = new ArrayList<PhysicalInformation>();
//            chemistryInformations = new ArrayList<ChemistryInformation>();
//            bloodInformations = new ArrayList<BloodInformation>();
//            urineInformations = new ArrayList<UrineInformation>();
//            intent.putExtra("physical", (Serializable) physicalInformations);
//            intent.putExtra("chemical", (Serializable) chemistryInformations);
//            intent.putExtra("blood", (Serializable) bloodInformations);
//            intent.putExtra("urine", (Serializable) urineInformations);
//            startActivity(intent);

//---------------------------------------------------------------------------------------
//            HealthInformation record = healthInformations.get(0);
//            List<HealthRecord> healthRecords = record.getHealthRecords();
//            intent.putExtra("record", (Serializable) healthRecords);
            //---------------------------------------------------------------------------------------

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(Home.this,Login.class);
            startActivity(intent);
//            sp = getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
//            editor.putString("token",token);
//            editor = sp.edit();
//            editor.remove("token").apply();
//            editor.commit();
            finish();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }
}