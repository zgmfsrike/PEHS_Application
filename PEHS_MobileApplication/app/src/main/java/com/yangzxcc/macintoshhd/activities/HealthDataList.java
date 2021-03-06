package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.infos.UrineInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

public class HealthDataList extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    List<PhysicalInformation> physical;
    List<ChemistryInformation> chemistry;
    List<BloodInformation> blood;
    List<UrineInformation> urine;
    CardView phyCard,chemCard,bloodCard;
    PhysicalInformation phy;
    ChemistryInformation chem;
    BloodInformation bloo;
    UrineInformation uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_visualization);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Visualization");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        physical = (List<PhysicalInformation>)intent.getSerializableExtra("physical");
//        phy = physical.get(0);
////        phy.getPhysicalExName(); //Weight at 0 position
////        phy.getPhysicalExValue();
//
//        chemistry = (List<ChemistryInformation>) intent.getSerializableExtra("chemical");
//        chem = chemistry.get(0);
////        chem.getClinicalChemistryName();
////        chem.getClinicalChemistryValue();
//
//        blood = (List<BloodInformation>) intent.getSerializableExtra("blood");
//        bloo = blood.get(0);
////        bloo.getBloodExName();
////        bloo.getBloodExValue();

        phyCard = (CardView)findViewById(R.id.phyCard);
        chemCard = (CardView)findViewById(R.id.chemCard);
        bloodCard = (CardView)findViewById(R.id.bloodCard);

        phyCard.setOnClickListener(this);
        chemCard.setOnClickListener(this);
        bloodCard.setOnClickListener(this);
//
//        Intent intent = getIntent();
//        List<HealthRecord> healthRecords = (List<HealthRecord>) intent.getSerializableExtra("record");
//        healthRecords.get(0); //Health record อันแรก
//        healthRecords.get(0);

//        PhysicalInformation physicalInformation = (PhysicalInformation) healthRecord.getPhysicalInformation();.
//        Intent intent = getIntent();
//        List<PhysicalInformation> physicalInformations = (List<PhysicalInformation>) intent.getSerializableExtra("physical");
//        physicalInformations.get(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phyCard:
                Intent intent = new Intent(HealthDataList.this,HealthPhysicalVisualization.class);
                startActivity(intent);
                break;
            case R.id.chemCard:
                Intent intent2 = new Intent(HealthDataList.this,HealthChemistryVisualization.class);
                startActivity(intent2);

                break;
            case R.id.bloodCard:
                Intent intent3 = new Intent(HealthDataList.this,HealthBloodVisualization.class);
                startActivity(intent3);
                break;
        }
    }
}
