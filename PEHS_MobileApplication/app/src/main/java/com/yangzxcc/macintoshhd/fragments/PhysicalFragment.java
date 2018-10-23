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

    private TextView weightResult, heightResult, waistResult, bmiResult, systolicResult, diastolicResult, pulseResult;
    private List<PhysicalInformation> physical;
    private PhysicalInformation weight1, height1, waist1, bmi1, systo1, dias1, pul1;
    String weights,heights,wrists,bmis,systolics,diastolics,pulses;
    int waist,systolic,diastolic,pulse;
    int colorCondition,colorConditiondi;
    double bmi;


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
        waistResult = (TextView) view.findViewById(R.id.waistRe);
        bmiResult = (TextView) view.findViewById(R.id.bmiRe);
        systolicResult = (TextView) view.findViewById(R.id.systolicRe);
        diastolicResult = (TextView) view.findViewById(R.id.diastolicRe);
        pulseResult = (TextView) view.findViewById(R.id.pulseRe);


        Record activity = (Record)getActivity();
        Bundle bundle = activity.getPhysicalData();
        weights = bundle.getString("weight");
        heights = bundle.getString("height");
        wrists = bundle.getString("wrist");
        bmis = bundle.getString("bmi");
        systolics = bundle.getString("systolic");
        diastolics = bundle.getString("diastolic");
        pulses = bundle.getString("pulse");


        setColorType();
        waist = Integer.parseInt(wrists);
        bmi = Double.parseDouble(bmis);
        systolic = Integer.parseInt(systolics);
        diastolic = Integer.parseInt(diastolics);
        pulse = Integer.parseInt(pulses);

        weightResult.setText(weights);
        heightResult.setText(heights);
        waistResult.setText(wrists);
        bmiResult.setText(bmis);
        systolicResult.setText(systolics);
        diastolicResult.setText(diastolics);
        pulseResult.setText(pulses);

        return view;
    }
    private void setColorType() {
        if (waist < 90){
            colorCondition = Color.parseColor("#689f38"); //green
            waistResult.setTextColor(colorCondition);
        }else {
            colorConditiondi = Color.parseColor("#ff5722"); //red;
            waistResult.setTextColor(colorConditiondi);
        }
        if(bmi < 23.0 && bmi > 18.5) {
            colorCondition = Color.parseColor("#689f38"); //green
            bmiResult.setTextColor(colorCondition);
        }else {
            colorConditiondi = Color.parseColor("#ff5722"); //red;
            bmiResult.setTextColor(colorConditiondi);
        }
        if (systolic < 139 && systolic > 90) {
            colorCondition = Color.parseColor("#689f38"); //green
            systolicResult.setTextColor(colorCondition);
        }else {
            colorConditiondi = Color.parseColor("#ff5722"); //red;
            systolicResult.setTextColor(colorConditiondi);
        }
        if (diastolic < 90 && diastolic > 60) {
            colorCondition = Color.parseColor("#689f38"); //green
            diastolicResult.setTextColor(colorCondition);
        }else{
            colorConditiondi = Color.parseColor("#ff5722"); //red;
            diastolicResult.setTextColor(colorConditiondi);
        }
        if (pulse < 100 && pulse > 60) {
            colorCondition = Color.parseColor("#689f38"); //green
            pulseResult.setTextColor(colorCondition);
        }else {
            colorConditiondi = Color.parseColor("#ff5722"); //red
            pulseResult.setTextColor(colorConditiondi);
        }
    }
}

//        Record activity = (Record)getActivity();
//        Bundle bundle = activity.getData();
//        String title = bundle.getString("title");
//        String text = bundle.getString("text");

//        ---------------------------------------------------------------------------------
//        Record activity = (Record)getActivity();
//        Bundle bundle = activity.getData();
//        physical = (List<PhysicalInformation>) bundle.getSerializable("physical");
//
//        weight1 = physical.get(0);
//        height1 = physical.get(1);
//        waist1 = physical.get(2);
//        bmi1 = physical.get(3);
//        systo1 = physical.get(4);
//        dias1 = physical.get(5);
//        pul1 = physical.get(6);
//
//
//        String weight = weight1.getPhysicalExValue();
//        String height = height1.getPhysicalExValue();
//        String waist = waist1.getPhysicalExValue();
//        String bmi = bmi1.getPhysicalExValue();
//        String systolic = systo1.getPhysicalExValue();
//        String diastolic = dias1.getPhysicalExValue();
//        String pulse = pul1.getPhysicalExValue();
//
//        setColorType();
//
//        weightResult.setText(weight);
//        heightResult.setText(height);
//        waistResult.setText(waist);
//        bmiResult.setText(bmi);
//        systolicResult.setText(systolic);
//        diastolicResult.setText(diastolic);
//        pulseResult.setText(pulse);
//
//        return view;
//
//    }
//
//    private void setColorType( ) {
//        int waist = Integer.parseInt(waist1.getPhysicalExValue());
//        double bmi = new Double(bmi1.getPhysicalExValue());
//        int systolic = Integer.parseInt(systo1.getPhysicalExValue());
//        int diastolic = Integer.parseInt(dias1.getPhysicalExValue());
//        int pulse = Integer.parseInt(pul1.getPhysicalExValue());
//        int colorCondition,colorConditiondi;
//
//        if (waist < 90){
//            colorCondition = Color.parseColor("#689f38"); //green
//            waistResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            waistResult.setTextColor(colorConditiondi);
//        }
//        if(bmi < 23.0 && bmi > 18.5) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            bmiResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            bmiResult.setTextColor(colorConditiondi);
//        }
//        if (systolic < 139 && systolic > 90) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            systolicResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            systolicResult.setTextColor(colorConditiondi);
//        }
//        if (diastolic < 90 && diastolic > 60) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            diastolicResult.setTextColor(colorCondition);
//        }else{
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            diastolicResult.setTextColor(colorConditiondi);
//        }
//        if (pulse < 100 && pulse > 60) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            pulseResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            pulseResult.setTextColor(colorConditiondi);
//        }
//    }
//    ---------------------------------------------------------------------------------
//}
