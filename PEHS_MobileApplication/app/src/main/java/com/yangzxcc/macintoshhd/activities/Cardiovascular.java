package com.yangzxcc.macintoshhd.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.Information;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.manager.InformationSingleton;
import com.yangzxcc.macintoshhd.pehs.R;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

public class Cardiovascular extends AppCompatActivity implements View.OnClickListener {

    private TextView age, systolic, cholesterol;
    private AppCompatRadioButton male, female, diabestesYes, diabetesNo, smokeYes, smokeNo;
    private RadioGroup gender, dia, smokes;
    private Button cal;
    private PersonalInformation person;
    private PhysicalInformation phy, systolicData;
    private ChemistryInformation chem, totalCholesterol;
    private List<PersonalInformation> info;
    private List<PhysicalInformation> physical;
    private List<ChemistryInformation> chemical;
    private EditText age1, systolic1, cholesterol1;
    private  double value;
    private double Pfullscore;
    private String value1;
    private Toolbar toolbar;
    private String carValue;
    private String dateOfBirth;
    private String dateValue;


    private String systo, choles;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular);

//        age = (TextView)findViewById(R.id.age);

//        systolic = (TextView)findViewById(R.id.systo);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cardiovascular");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cholesterol = (TextView) findViewById(R.id.choles);
        male = (AppCompatRadioButton) findViewById(R.id.sexMale);
        female = (AppCompatRadioButton) findViewById(R.id.sexFemale);
        diabestesYes = (AppCompatRadioButton) findViewById(R.id.diabetesYes);
        diabetesNo = (AppCompatRadioButton) findViewById(R.id.diabetesNo);
        smokeYes = (AppCompatRadioButton) findViewById(R.id.smokeYes);
        smokeNo = (AppCompatRadioButton) findViewById(R.id.smokeNo);
        gender = (RadioGroup) findViewById(R.id.gender);
        dia = (RadioGroup) findViewById(R.id.diabRadio);
        smokes = (RadioGroup) findViewById(R.id.smokeRadio);
        cal = (Button) findViewById(R.id.btnCal);

        age1 = (EditText) findViewById(R.id.age);
        systolic1 = (EditText) findViewById(R.id.systo5);
        cholesterol1 = (EditText) findViewById(R.id.choles);
        cal.setOnClickListener(this);
//        input.setRawInputType(Configuration.KEYBOARD_12KEY);


        dateOfBirth = InformationSingleton.getInstance().getInformation().getPersonalInformation().get(0).getDateOfBirth();
        dateValue = dateOfBirth.substring(0,4);

        List<HealthInformation> data = InformationSingleton.getInstance().getInformation().getHealthInformation();

        if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0){

            int dateValue1 = Integer.parseInt(dateValue);
            int calAge = Calendar.getInstance().get(Calendar.YEAR) - dateValue1;
            String calAge1 = String.valueOf(calAge);
            Log.e("Test Date","Dateeeee " +calAge);

            String sys = data.get(data.size()-1).getSystolic();
            String chol = data.get(data.size()-1).getCholesterol();
            age1.setText(calAge1);
            systolic1.setText(sys);
            cholesterol1.setText(chol);
        }
    }
    private void calculate() {
        String age = age1.getText().toString().trim();
        String systolic = systolic1.getText().toString().trim();
        String cholesterol = cholesterol1.getText().toString().trim();

        double ageValue = Double.parseDouble(age);
        double systolicValue = Double.parseDouble(systolic);
        double cholesterolValue = Double.parseDouble(cholesterol);

        double SexType = 1;
        double Smoked = 1;
        double isdiabetes = 1;

        double valueBuffer;
        double pFullScoreBuffer;

    if (male.isChecked()){
        SexType =  1;
    } else{
        SexType = 0;
    }
    if (smokeYes.isChecked()){
        Smoked = 1;
    } else{
        Smoked = 0;
    }
    if (diabestesYes.isChecked()){
        isdiabetes = 1;
    } else{
        isdiabetes = 0;
    }

    value = (0.08183 * ageValue) + (0.39499 * SexType) + (0.02084 * systolicValue)
                    + (0.699741921871007 * isdiabetes) + (0.00212 * cholesterolValue) + (0.41916 * Smoked);
    pFullScoreBuffer = 0.978296;
    valueBuffer = value - 7.044233;

    Pfullscore = 1- (Math.pow(pFullScoreBuffer,Math.exp(valueBuffer)));

    DecimalFormat df = new DecimalFormat("#.##");
    double pScore = Double.parseDouble(df.format(Pfullscore*100));
    value1 = String.valueOf(pScore);

    }

    @Override
    public void onClick(View v) {
        calculate();
        Log.e("Calculate","Calucalte  "+value1);
        Intent intent = new Intent(Cardiovascular.this,CardiovascularDetail.class);

        intent.putExtra("score",value1);
        startActivity(intent);

    }
}

//    private void calculate() {
//        String age = age1.getText().toString().trim();
//        String systolic = systolic1.getText().toString().trim();
//        String cholesterol = cholesterol1.getText().toString().trim();
//        Double temp = Double.valueOf(age);
//        double ageNumber = temp.doubleValue();
//        Double temp1 = Double.valueOf(age);
//        double systolicNumber = temp1.doubleValue();
//        Double temp2 = Double.valueOf(age);
//        double choles = temp2.doubleValue();
//

//        //check operator
//        if (male.isChecked() && smokeYes.isChecked() && diabestesYes.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 1) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 1) + (0.00212384055469836 * choles) + (0.419162811751856 * 1);
//        }
//        if (male.isChecked() && smokeNo.isChecked() && diabestesYes.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 1) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 0) + (0.00212384055469836 * choles) + (0.419162811751856 * 1);
//        }
//        if (male.isChecked() && smokeYes.isChecked() && diabetesNo.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 1) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 1) + (0.00212384055469836 * choles) + (0.419162811751856 * 0);
//        }
//        if (male.isChecked() && smokeNo.isChecked() && diabetesNo.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 1) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 0) + (0.00212384055469836 * choles) + (0.419162811751856 * 0);
//        }
//        if (female.isChecked() && smokeYes.isChecked() && diabestesYes.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 0) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 1) + (0.00212384055469836 * choles) + (0.419162811751856 * 1);
//        }
//        if (female.isChecked() && smokeNo.isChecked() && diabestesYes.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 0) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 0) + (0.00212384055469836 * choles) + (0.419162811751856 * 1);
//        }
//        if (female.isChecked() && smokeYes.isChecked() && diabetesNo.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 0) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 1) + (0.00212384055469836 * choles) + (0.419162811751856 * 0);
//        }
//        if (female.isChecked() && smokeNo.isChecked() && diabetesNo.isChecked()) {
//            double value = (0.0818347640193792 * ageNumber) + (0.394986128542107 * 0) + (0.0208425438624519 * systolicNumber)
//                    + (0.699741921871007 * 0) + (0.00212384055469836 * choles) + (0.419162811751856 * 0);
//        }
//    }

//    private void checkButton(){
//        int radioId = gender.getCheckedRadioButtonId();
//        male = findViewById(radioId);
//        female = findViewById(radioId);
//
////        male = 1;
////        female = 0;
////        diabestesYes = 1;
////        diabetesNo = 0;
////        smokeYes = 1;
////        smokeNo = 0
//    }
////    private void onCalculate() {
//        Intent intent1 = getIntent();
////        String age = String.valueOf(intent1.getSerializableExtra("value"));
////        int age = (int) intent1.getSerializableExtra("value");
//        systo = systolicData.getPhysicalExValue();
//        choles = totalCholesterol.getClinicalChemistryValue();
//        int sys = Integer.parseInt(systolicData.getPhysicalExValue());
//        int cho = Integer.parseInt(totalCholesterol.getClinicalChemistryValue());

//        double value = 0.0818347640193792;
//        String data = (value*age)+(0.394986128542107*"sex") + (0.0208425438624519*sys)
//                +(0.699741921871007*"diabetes")+ (0.00212384055469836*cho) + (0.419162811751856*"smoke");
//    }

//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case 0 : onCalculate();
//
//        }
//    }

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
//
//
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
