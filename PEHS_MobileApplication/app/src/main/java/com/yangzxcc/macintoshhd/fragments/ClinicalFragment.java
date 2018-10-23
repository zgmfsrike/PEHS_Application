package com.yangzxcc.macintoshhd.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.ChemistryInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClinicalFragment extends Fragment {

    private TextView glucoseResult,bunResult,creatineResult,uricResult,cholesterolResult,triglycerideResult,hdlResult,
                ldlResult,astResut,altResult,alpResult;
    private List<ChemistryInformation> chemistry;
    private ChemistryInformation glu1,bun1,cre1,uric1,cho1,tri1,hdl1,ldl1,ast1,alt1,alp1;
    public ClinicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinical, container, false);

        glucoseResult = (TextView)view.findViewById(R.id.glucoseRe);
        bunResult = (TextView)view.findViewById(R.id.bunRe);
        creatineResult = (TextView)view.findViewById(R.id.creatineRe);
        uricResult = (TextView)view.findViewById(R.id.uricRe);
        cholesterolResult = (TextView)view.findViewById(R.id.cholesterolRe);
        triglycerideResult = (TextView)view.findViewById(R.id.triglycerideRe);
        hdlResult = (TextView)view.findViewById(R.id.hdlRe);
        ldlResult = (TextView)view.findViewById(R.id.ldlRe);
        astResut = (TextView)view.findViewById(R.id.astRe);
        altResult = (TextView)view.findViewById(R.id.altRe);
        alpResult = (TextView)view.findViewById(R.id.alpRe);

//        Record activity = (Record)getActivity();
//        Bundle bundle = activity.getData();
//        chemistry = (List<ChemistryInformation>) bundle.getSerializable("chem");
//        glu1 = chemistry.get(0);
//        bun1 = chemistry.get(1);
//        cre1 = chemistry.get(2);
//        uric1 = chemistry.get(3);
//        cho1 = chemistry.get(4);
//        tri1 = chemistry.get(5);
//        hdl1 = chemistry.get(6);
//        ldl1 = chemistry.get(7);
//        ast1 = chemistry.get(8);
//        alt1 = chemistry.get(9);
//        alp1 = chemistry.get(10);
//
//        String glucose = glu1.getClinicalChemistryValue();
//        String bun = bun1.getClinicalChemistryValue();
//        String creatine = cre1.getClinicalChemistryValue();
//        String uric = uric1.getClinicalChemistryValue();
//        String cholesterol = cho1.getClinicalChemistryValue();
//        String triglyceride = tri1.getClinicalChemistryValue();
//        String hdl = hdl1.getClinicalChemistryValue();
//        String ldl = ldl1.getClinicalChemistryValue();
//        String ast = ast1.getClinicalChemistryValue();
//        String alt = alt1.getClinicalChemistryValue();
//        String alp = alp1.getClinicalChemistryValue();
//
//        setColor();
//        glucoseResult.setText(glucose);
//        bunResult.setText(bun);
//        creatineResult.setText(creatine);
//        uricResult.setText(uric);
//        cholesterolResult.setText(cholesterol);
//        triglycerideResult.setText(triglyceride);
//        hdlResult.setText(hdl);
//        ldlResult.setText(ldl);
//        astResut.setText(ast);
//        altResult.setText(alt);
//        alpResult.setText(alp);
//
        return view;
    }
//
//    private void setColor() {
//        int glucose = Integer.parseInt(glu1.getClinicalChemistryValue());
//        double bun = Double.parseDouble(bun1.getClinicalChemistryValue());
//        double creatine = Double.parseDouble(cre1.getClinicalChemistryValue());
//        double uric = Double.parseDouble(uric1.getClinicalChemistryValue());
//        double cholesterol = Double.parseDouble(cho1.getClinicalChemistryValue());
//        int triglyceride = Integer.parseInt(tri1.getClinicalChemistryValue());
//        int hdl = Integer.parseInt(hdl1.getClinicalChemistryValue());
//        int ldl = Integer.parseInt(ldl1.getClinicalChemistryValue());
//        int ast = Integer.parseInt(ast1.getClinicalChemistryValue());
//        int alt = Integer.parseInt(alt1.getClinicalChemistryValue());
//        int alp = Integer.parseInt(alp1.getClinicalChemistryValue());
//        int colorCondition,colorConditiondi;
//
//        if (glucose < 99 && glucose < 70){
//            colorCondition = Color.parseColor("#689f38"); //green
//            glucoseResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            glucoseResult.setTextColor(colorConditiondi);
//        }
//        if(bun < 20.06 && bun > 8.09) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            bunResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            bunResult.setTextColor(colorConditiondi);
//        }
//        if (creatine < 1.25 && creatine > 0.72) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            creatineResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            creatineResult.setTextColor(colorConditiondi);
//        }
//        if (uric < 7.2 && uric > 3.5) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            uricResult.setTextColor(colorCondition);
//        }else{
//            colorConditiondi = Color.parseColor("#ff5722"); //red;
//            uricResult.setTextColor(colorConditiondi);
//        }
//        if (cholesterol < 200) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            cholesterolResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            cholesterolResult.setTextColor(colorConditiondi);
//        }
//        if (triglyceride < 150) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            triglycerideResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            triglycerideResult.setTextColor(colorConditiondi);
//        }
//        if (hdl < 40) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            hdlResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            hdlResult.setTextColor(colorConditiondi);
//        }
//        if (ldl < 150) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            ldlResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            ldlResult.setTextColor(colorConditiondi);
//        }
//        if (ast < 34 && ast > 5) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            astResut.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            astResut.setTextColor(colorConditiondi);
//        }
//        if (alt < 55 && alt > 0)  {
//            colorCondition = Color.parseColor("#689f38"); //green
//            altResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            altResult.setTextColor(colorConditiondi);
//        }
//        if (alp < 150 && alp > 40) {
//            colorCondition = Color.parseColor("#689f38"); //green
//            alpResult.setTextColor(colorCondition);
//        }else {
//            colorConditiondi = Color.parseColor("#ff5722"); //red
//            alpResult.setTextColor(colorConditiondi);
//        }
//    }

}
