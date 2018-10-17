package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.infos.UrineInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.Serializable;
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
        getSupportActionBar().setTitle("Record Date");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        List<HealthRecord> healthRecords = (List<HealthRecord>) intent.getSerializableExtra("record");

        HealthRecord healthRecord = healthRecords.get(0); //Health record อันแรก
        PhysicalInformation physicalInformation = (PhysicalInformation) healthRecord.getPhysicalInformation();



        physical = (List<PhysicalInformation>)intent.getSerializableExtra("physical");
        phy = physical.get(0);
//        phy.getPhysicalExName(); //Weight at 0 position
//        phy.getPhysicalExValue();

        chemistry = (List<ChemistryInformation>) intent.getSerializableExtra("chemical");
        chem = chemistry.get(0);
//        chem.getClinicalChemistryName();
//        chem.getClinicalChemistryValue();

        blood = (List<BloodInformation>) intent.getSerializableExtra("blood");
        bloo = blood.get(0);
//        bloo.getBloodExName();
//        bloo.getBloodExValue();

        phyCard = (CardView)findViewById(R.id.phyCard);
        chemCard = (CardView)findViewById(R.id.chemCard);
        bloodCard = (CardView)findViewById(R.id.bloodCard);

        phyCard.setOnClickListener(this);
        chemCard.setOnClickListener(this);
        bloodCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phyCard:
                Intent intent = new Intent(HealthDataList.this,HealthDataVisualization.class);
                intent.putExtra("physicalName",);
//                intent.putExtra("physicalValue",phy.getPhysicalExValue());
                startActivity(intent);
                break;
//            case R.id.chemCard:
//                Intent intent2 = new Intent(HealthDataList.this,HealthDataVisualization.class);
//                intent2.putExtra("chemName",chem.getClinicalChemistryName());
//                intent2.putExtra("chemValue",chem.getClinicalChemistryValue());
//                break;
//            case R.id.bloodCard:
//                Intent intent3 = new Intent(HealthDataList.this,HealthDataVisualization.class);
//                intent3.putExtra("bloodName",bloo.getBloodExName());
//                intent3.putExtra("bloodValue",bloo.getBloodExValue());
//                break;
        }
    }
}
