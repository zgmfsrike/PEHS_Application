package com.yangzxcc.macintoshhd.fragments;


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
    private ChemistryInformation chem;
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

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        chemistry = (List<ChemistryInformation>) bundle.getSerializable("chem");
        chem = chemistry.get(0);
        String glucose = chem.getClinicalChemistryValue(0);
        String bun = chem.getClinicalChemistryValue(1);
        String creatine = chem.getClinicalChemistryValue(2);
        String uric = chem.getClinicalChemistryValue(3);
        String cholesterol = chem.getClinicalChemistryValue(4);
        String triglyceride = chem.getClinicalChemistryValue(5);
        String hdl = chem.getClinicalChemistryValue(6);
        String ldl = chem.getClinicalChemistryValue(7);
        String ast = chem.getClinicalChemistryValue(8);
        String alt = chem.getClinicalChemistryValue(9);
        String alp = chem.getClinicalChemistryValue(10);

        glucoseResult.setText(glucose);
        bunResult.setText(bun);
        creatineResult.setText(creatine);
        uricResult.setText(uric);
        cholesterolResult.setText(cholesterol);
        triglycerideResult.setText(triglyceride);
        hdlResult.setText(hdl);
        ldlResult.setText(ldl);
        astResut.setText(ast);
        altResult.setText(alt);
        alpResult.setText(alp);

        return view;
    }

}
