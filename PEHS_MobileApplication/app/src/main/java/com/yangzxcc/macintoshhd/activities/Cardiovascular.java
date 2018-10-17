package com.yangzxcc.macintoshhd.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.api.ApiClient;
import com.yangzxcc.macintoshhd.api.ApiInterface;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cardiovascular extends AppCompatActivity implements View.OnClickListener {

    private TextView age,systolic,cholesterol;
    private AppCompatRadioButton male,female,diabestesYes,diabetesNo,smokeYes,smokeNo;
    private RadioGroup gender,dia,smokes;
    private Button cal;
    private PersonalInformation person;
    private PhysicalInformation phy,systolicData;
    private ChemistryInformation chem,totalCholesterol;
    private List<PersonalInformation> info;
    private List<PhysicalInformation> physical;
    private List<ChemistryInformation> chemical;

    private String systo,choles;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular);

        age = (TextView)findViewById(R.id.age);
        systolic = (TextView)findViewById(R.id.systo);
        cholesterol = (TextView)findViewById(R.id.choles);
        male = (AppCompatRadioButton)findViewById(R.id.sexMale);
        female = (AppCompatRadioButton)findViewById(R.id.sexFemale);
        diabestesYes = (AppCompatRadioButton)findViewById(R.id.diabetesYes);
        diabetesNo = (AppCompatRadioButton)findViewById(R.id.diabetesNo);
        smokeYes = (AppCompatRadioButton)findViewById(R.id.smokeYes);
        smokeNo = (AppCompatRadioButton)findViewById(R.id.smokeNo);
        gender = (RadioGroup)findViewById(R.id.gender);
        dia = (RadioGroup)findViewById(R.id.diabRadio);
        smokes = (RadioGroup)findViewById(R.id.smokeRadio);
        cal = (Button)findViewById(R.id.btnCal);

        cal.setOnClickListener(this);

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

//        Intent intent = getIntent();
//        String token = intent.getStringExtra("token");
//        Call<HealthRecord> call = apiInterface.getHealthRecord("Bearer "+token);
//        call.enqueue(new Callback<HealthRecord>() {
//            @Override
//            public void onResponse(Call<HealthRecord> call, Response<HealthRecord> response) {
//                List<PhysicalInformation> physicalInformations = response.body().getPhysicalInformation();
//                 systolicData = physicalInformations.get(4);
//
//                List<ChemistryInformation> chemistryInformations = response.body().getChemistryInformation();
//                totalCholesterol = chemistryInformations.get(4);
//            }
//
//            @Override
//            public void onFailure(Call<HealthRecord> call, Throwable t) {
//
//            }
//        });
    }
    private void checkButton(){
        int radioId = gender.getCheckedRadioButtonId();
        male = findViewById(radioId);
        female = findViewById(radioId);

//        male = 1;
//        female = 0;
//        diabestesYes = 1;
//        diabetesNo = 0;
//        smokeYes = 1;
//        smokeNo = 0
    }
    private void onCalculate() {
        Intent intent1 = getIntent();
//        String age = String.valueOf(intent1.getSerializableExtra("value"));
        int age = (int) intent1.getSerializableExtra("value");
        systo = systolicData.getPhysicalExValue();
        choles = totalCholesterol.getClinicalChemistryValue();
        int sys = Integer.parseInt(systolicData.getPhysicalExValue());
        int cho = Integer.parseInt(totalCholesterol.getClinicalChemistryValue());

//        double value = 0.0818347640193792;
//        String data = (value*age)+(0.394986128542107*"sex") + (0.0208425438624519*sys)
//                +(0.699741921871007*"diabetes")+ (0.00212384055469836*cho) + (0.419162811751856*"smoke");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 0 : onCalculate();

        }
    }

//        Call<PhysicalInformation> call = apiInterface.getPhysical("Bearer "+token);
//        call.enqueue(new Callback<PhysicalInformation>() {
//            @Override
//            public void onResponse(Call<PhysicalInformation> call, Response<PhysicalInformation> response) {
//              String physicalExValue  = response.body().getPhysicalExValue();
//
//            }
//
//            @Override
//            public void onFailure(Call<PhysicalInformation> call, Throwable t) {
//
//            }
//        });


//        Intent intent = getIntent();
//        info = (List<PersonalInformation>) intent.getSerializableExtra("date");
//        person = info.get(0);
//        Date age = person.getDateOfBirth();
//        physical = (List<PhysicalInformation>) intent.getSerializableExtra("physical");
//        phy = physical.get(0);
//        String  systolic = phy.getPhysicalExValue();
//        chemical = (List<ChemistryInformation>) intent.getSerializableExtra("chem");
//        chem = chemical.get(0);
//        String totalCholesterol = chem.getClinicalChemistryValue();

}
