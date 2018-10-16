package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.Date;
import java.util.List;

public class Cardiovascular extends AppCompatActivity {

    private TextView age,systolic,cholesterol;
    private RadioButton male,female,diabestesYes,diabetesNo,smokeYes,smokeNo;
    private Button cal;
    private PersonalInformation person;
    private PhysicalInformation phy;
    private ChemistryInformation chem;
    private List<PersonalInformation> info;
    private List<PhysicalInformation> physical;
    private List<ChemistryInformation> chemical;
    private double value = 0.0818347640193792;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular);

        age = (TextView)findViewById(R.id.age);
        systolic = (TextView)findViewById(R.id.systo);
        cholesterol = (TextView)findViewById(R.id.choles);
        male = (RadioButton)findViewById(R.id.sexMale);
        female = (RadioButton)findViewById(R.id.sexFemale);
        diabestesYes = (RadioButton)findViewById(R.id.diabetesYes);
        diabetesNo = (RadioButton)findViewById(R.id.diabetesNo);
        smokeYes = (RadioButton)findViewById(R.id.smokeYes);
        smokeNo = (RadioButton)findViewById(R.id.smokeNo);
        cal = (Button)findViewById(R.id.btnCal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onCalculate();
//                startActivity(Cardiovascular.this,);
            }
        });

        Intent intent = getIntent();
        info = (List<PersonalInformation>) intent.getSerializableExtra("date");
        person = info.get(0);
//        Date age = person.getDateOfBirth();
        physical = (List<PhysicalInformation>) intent.getSerializableExtra("physical");
        phy = physical.get(0);
        String  systolic = phy.getPhysicalExValue();
        chemical = (List<ChemistryInformation>) intent.getSerializableExtra("chem");
        chem = chemical.get(0);
        String totalCholesterol = chem.getClinicalChemistryValue();


    }

//    private void onCalculate() {
//        String data = (value*age)+(0.394986128542107*"sex") + (0.0208425438624519*systolic)
//                +(0.699741921871007*"diabetes")+ (0.00212384055469836*cholesterol) + (0.419162811751856*"smoke");
//    }
}
