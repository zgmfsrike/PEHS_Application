package com.yangzxcc.macintoshhd.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.BloodInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodFragment extends Fragment {

    private TextView bloodWBCResult,bloodRBCResult,hgbResult,hctResult,mcvResult,mchResult,mchcResult,pltResult,
            neutrophilResult,lymphocyteResult,monocyteResult,eosinophilResult,basophilResult;
    private List<BloodInformation> blood;
    private BloodInformation wbc,rbc,hgb1,hct1,mcv1,mch1,mchc1,plt1,neu1,lym1,mono1,eos1,bas1;
    public BloodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blood, container, false);

        bloodWBCResult = (TextView)view.findViewById(R.id.bloodWhiteRe);
        bloodRBCResult = (TextView)view.findViewById(R.id.bloodRedRe);
        hgbResult = (TextView)view.findViewById(R.id.hgbRe);
        hctResult = (TextView)view.findViewById(R.id.hctRe);
        mcvResult = (TextView)view.findViewById(R.id.mcvRe);
        mchResult = (TextView)view.findViewById(R.id.mchRe);
        mchcResult = (TextView)view.findViewById(R.id.mchcRe);
        pltResult = (TextView)view.findViewById(R.id.pltRe);
        neutrophilResult = (TextView)view.findViewById(R.id.neutrophilRe);
        lymphocyteResult = (TextView)view.findViewById(R.id.lymphocyteRe);
        monocyteResult = (TextView)view.findViewById(R.id.monocyteRe);
        eosinophilResult = (TextView)view.findViewById(R.id.eosinophilRe);
        basophilResult = (TextView)view.findViewById(R.id.basophilRe);

//        Record activity = (Record)getActivity();
//        Bundle bundle = activity.getData();
//        blood = (List<BloodInformation>) bundle.getSerializable("blood");
//        wbc = blood.get(0);
//        rbc = blood.get(1);
//        hgb1 = blood.get(2);
//        hct1 = blood.get(3);
//        mcv1 = blood.get(4);
//        mch1 = blood.get(5);
//        mchc1 = blood.get(6);
//        plt1 = blood.get(7);
//        neu1 = blood.get(8);
//        lym1 = blood.get(9);
//        mono1 = blood.get(10);
//        eos1 = blood.get(11);
//        bas1 = blood.get(12);
//
//        String bloodWBC = wbc.getBloodExValue();
//        String bloodRBC = rbc.getBloodExValue();
//        String hgb = hgb1.getBloodExValue();
//        String hct = hct1.getBloodExValue();
//        String mcv = mcv1.getBloodExValue();
//        String mch = mch1.getBloodExValue();
//        String mchc = mchc1.getBloodExValue();
//        String plt = plt1.getBloodExValue();
//        String neutrophil = neu1.getBloodExValue();
//        String lymphocyte = lym1.getBloodExValue();
//        String monocyte = mono1.getBloodExValue();
//        String eosinophil = eos1.getBloodExValue();
//        String basophil = bas1.getBloodExValue();
//
//        setColor();
//        bloodWBCResult.setText(bloodWBC);
//        bloodRBCResult.setText(bloodRBC);
//        hgbResult.setText(hgb);
//        hctResult.setText(hct);
//        mcvResult.setText(mcv);
//        mchResult.setText(mch);
//        mchcResult.setText(mchc);
//        pltResult.setText(plt);
//        neutrophilResult.setText(neutrophil);
//        lymphocyteResult.setText(lymphocyte);
//        monocyteResult.setText(monocyte);
//        eosinophilResult.setText(eosinophil);
//        basophilResult.setText(basophil);
//
        return view;
    }
//
//    private void setColor() {
//        double bloodWBC = Double.parseDouble(wbc.getBloodExValue());
//        double bloodRBC = Double.parseDouble(rbc.getBloodExValue());
//        double hgb = Double.parseDouble(hgb1.getBloodExValue());
//        double hct = Double.parseDouble(hct1.getBloodExValue());
//        int mcv = Integer.parseInt(mcv1.getBloodExValue());
//        int mch = Integer.parseInt(mch1.getBloodExValue());
//        int mchc = Integer.parseInt(mchc1.getBloodExValue());
//        int plt = Integer.parseInt(plt1.getBloodExValue());
//        int neu = Integer.parseInt(neu1.getBloodExValue());
//        int lym = Integer.parseInt(lym1.getBloodExValue());
//        int mono = Integer.parseInt(mono1.getBloodExValue());
//        int eos = Integer.parseInt(eos1.getBloodExValue());
//        int bas = Integer.parseInt(bas1.getBloodExValue());
//
//        int colorCondition,colorConditiondi;
//
//        if (bloodWBC < 10.0 && bloodWBC > 5.5){
//            colorCondition = Color.parseColor("#689f38"); //green
//            bloodWBCResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            bloodWBCResult.setTextColor(colorConditiondi);
//        }
//        if(bloodRBC < 6.01 && bloodRBC > 4.45) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            bloodRBCResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            bloodRBCResult.setTextColor(colorConditiondi);
//        }
//        if (hgb < 16.8 && hgb > 13.2) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            hgbResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            hgbResult.setTextColor(colorConditiondi);
//        }
//        if (hct < 52.9 && hct > 39.7) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            hctResult.setTextColor(colorCondition);
//        }else{
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            hctResult.setTextColor(colorConditiondi);
//        }
//        if (mcv < 97 && mcv > 82) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            mcvResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            mcvResult.setTextColor(colorConditiondi);
//        }
//        if (mch < 31 && mch > 27) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            mchResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            mchResult.setTextColor(colorConditiondi);
//        }
//        if (mchc < 36 && mchc > 32) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            mchcResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            mchcResult.setTextColor(colorConditiondi);
//        }
//        if (plt < 421 && plt > 167) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            pltResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            pltResult.setTextColor(colorConditiondi);
//        }
//        if (neu < 62 && neu > 45) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            neutrophilResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            neutrophilResult.setTextColor(colorConditiondi);
//        }
//        if (lym < 42 && lym > 34)  {
//            colorCondition = Color.parseColor("#689f38"); //green
//            lymphocyteResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            lymphocyteResult.setTextColor(colorConditiondi);
//        }
//        if (mono < 8 && mono > 6) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            monocyteResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            monocyteResult.setTextColor(colorConditiondi);
//        }
//        if (eos < 5 && eos > 0) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            eosinophilResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            eosinophilResult.setTextColor(colorConditiondi);
//        }
//        if (bas <= 1 && bas > 0) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            basophilResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            basophilResult.setTextColor(colorConditiondi);
//        }
//    }
}
