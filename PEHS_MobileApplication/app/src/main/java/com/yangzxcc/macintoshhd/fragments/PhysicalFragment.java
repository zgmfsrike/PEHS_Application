package com.yangzxcc.macintoshhd.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    private TextView weightResult,heightResult,waistResult,bmiResult,systolicResult,diastolicResult,pulseResult;
    private List<PhysicalInformation> physical;
    private PhysicalInformation weight1,height1,waist1,bmi1,systo1,dias1,pul1;

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

        weight1 = physical.get(0);
        height1 = physical.get(1);
        waist1 = physical.get(2);
        bmi1 = physical.get(3);
        systo1 = physical.get(4);
        dias1 = physical.get(5);
        pul1 = physical.get(6);


        String weight = weight1.getPhysicalExValue();
        String height = height1.getPhysicalExValue();
        String waist = waist1.getPhysicalExValue();
        String bmi = bmi1.getPhysicalExValue();
        String systolic = systo1.getPhysicalExValue();
        String diastolic = dias1.getPhysicalExValue();
        String pulse = pul1.getPhysicalExValue();

        setColor();

        weightResult.setText(weight);
        heightResult.setText(height);
        waistResult.setText(waist);
        bmiResult.setText(bmi);
        systolicResult.setText(systolic);
        diastolicResult.setText(diastolic);
        pulseResult.setText(pulse);

        return view;

    }

    private void setColor( ) {
         double bmi = new Double(bmi1.getPhysicalExValue());

        int colorCondition, colorConditiondi;

        if (parseInt(waist1.getPhysicalExValue()) < 90){
            colorCondition = Color.parseColor("#689f38"); //green
        }else if(bmi < 23.0 && bmi > 18.5) {
            colorCondition = Color.parseColor("#689f38"); //green
        }else if (parseInt(systo1.getPhysicalExValue())  < 139 && parseInt(bmi1.getPhysicalExValue()) > 90) {
            colorCondition = Color.parseColor("#689f38"); //green
        }
//        else if (parseInt(dias1.getPhysicalExValue()) < 90 && parseInt(systo1.getPhysicalExValue()) > 90) {
//            colorCondition = Color.parseColor("#689f38"); //green
//        }
        else if (parseInt(pul1.getPhysicalExValue()) < 100 && parseInt(dias1.getPhysicalExValue()) > 60) {
            colorCondition = Color.parseColor("#689f38"); //green
        }else {
            colorCondition = Color.parseColor("#ff5722"); //red
        }

        if (parseInt(dias1.getPhysicalExValue()) < 90 && parseInt(systo1.getPhysicalExValue()) > 90) {
            colorConditiondi = Color.parseColor("#689f38"); //green
        }else{
            colorConditiondi = Color.parseColor("#ff5722"); //red;
        }
        weightResult.setTextColor(colorCondition);
        heightResult.setTextColor(colorCondition);
        waistResult.setTextColor(colorCondition);
        bmiResult.setTextColor(colorCondition);
        systolicResult.setTextColor(colorCondition);
        diastolicResult.setTextColor(colorConditiondi);
        pulseResult.setTextColor(colorCondition);
    }

}
