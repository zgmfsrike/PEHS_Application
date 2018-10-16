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

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        chemistry = (List<ChemistryInformation>) bundle.getSerializable("chem");
        glu1 = chemistry.get(0);
        bun1 = chemistry.get(0);
        cre1 = chemistry.get(0);
        uric1 = chemistry.get(0);
        cho1 = chemistry.get(0);
        tri1 = chemistry.get(0);
        hdl1 = chemistry.get(0);
        ldl1 = chemistry.get(0);
        ast1 = chemistry.get(0);
        alt1 = chemistry.get(0);
        alp1 = chemistry.get(0);

        String glucose = glu1.getClinicalChemistryValue();
        String bun = bun1.getClinicalChemistryValue();
        String creatine = cre1.getClinicalChemistryValue();
        String uric = uric1.getClinicalChemistryValue();
        String cholesterol = cho1.getClinicalChemistryValue();
        String triglyceride = tri1.getClinicalChemistryValue();
        String hdl = hdl1.getClinicalChemistryValue();
        String ldl = ldl1.getClinicalChemistryValue();
        String ast = ast1.getClinicalChemistryValue();
        String alt = alt1.getClinicalChemistryValue();
        String alp = alp1.getClinicalChemistryValue();

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
