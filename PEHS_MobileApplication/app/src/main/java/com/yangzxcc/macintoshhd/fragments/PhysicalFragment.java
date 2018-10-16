package com.yangzxcc.macintoshhd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    private TextView weightResult,heightResult,waistResult,bmiResult,systolicResult,diastolicResult,pulseResult;
    private List<PhysicalInformation> physical;
    private PhysicalInformation phy,phy1;
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
        phy1 = physical.get(1);

        String weight = phy.getPhysicalExValue();
        String height = phy1.getPhysicalExValue();
        String waist = phy.getPhysicalExValue();
        String bmi = phy.getPhysicalExValue();
        String systolic = phy.getPhysicalExValue();
        String diastolic = phy.getPhysicalExValue();
        String pulse = phy.getPhysicalExValue();


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
