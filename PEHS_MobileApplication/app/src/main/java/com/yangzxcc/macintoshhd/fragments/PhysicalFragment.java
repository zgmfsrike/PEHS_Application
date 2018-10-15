package com.yangzxcc.macintoshhd.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.nio.file.WatchEvent;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    private TextView weightResult,heightResult,waistResult,bmiResult,systolicResult,diastolicResult,pulseResult;
    private List<PhysicalInformation> physical;
    private PhysicalInformation phy;
    public PhysicalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physical, container, false);

        weightResult = (TextView) view.findViewById(R.id.weightRe);
        heightResult = (TextView) view.findViewById(R.id.heightRe);
        waistResult = (TextView)view.findViewById(R.id.waistRe);
        bmiResult = (TextView)view.findViewById(R.id.bmiRe);
        systolicResult = (TextView)view.findViewById(R.id.systolicRe);
        diastolicResult = (TextView)view.findViewById(R.id.diastolicRe);
        pulseResult = (TextView)view.findViewById(R.id.pulseRe);

//        Record activity = (Record)getActivity();
//        Bundle bundle = activity.getData();
//        String title = bundle.getString("title");
//        String text = bundle.getString("text");

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        physical = (List<PhysicalInformation>) bundle.getSerializable("physical");
        phy = physical.get(0);
        String weight = phy.getPhysicalExValue(0);
        String height = phy.getPhysicalExValue(1);
        String waist = phy.getPhysicalExValue(2);
        String bmi = phy.getPhysicalExValue(3);
        String systolic = phy.getPhysicalExValue(4);
        String diastolic = phy.getPhysicalExValue(5);
        String pulse = phy.getPhysicalExValue(6);


        weightResult.setText(weight);
        heightResult.setText(height);
        waistResult.setText(waist);
        bmiResult.setText(bmi);
        systolicResult.setText(systolic);
        diastolicResult.setText(diastolic);
        pulseResult.setText(pulse);

        return view;

    }
}
