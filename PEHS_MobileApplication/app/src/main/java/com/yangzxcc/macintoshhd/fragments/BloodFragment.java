package com.yangzxcc.macintoshhd.fragments;


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
    private BloodInformation bloo;
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

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        blood = (List<BloodInformation>) bundle.getSerializable("blood");
        bloo = blood.get(0);

        String bloodWBC = bloo.getBloodExValue(0);
        String bloodRBC = bloo.getBloodExValue(1);
        String hgb = bloo.getBloodExValue(2);
        String hct = bloo.getBloodExValue(3);
        String mcv = bloo.getBloodExValue(4);
        String mch = bloo.getBloodExValue(5);
        String mchc = bloo.getBloodExValue(6);
        String plt = bloo.getBloodExValue(7);
        String neutrophil = bloo.getBloodExValue(8);
        String lymphocyte = bloo.getBloodExValue(9);
        String monocyte = bloo.getBloodExValue(10);
        String eosinophil = bloo.getBloodExValue(11);
        String basophil = bloo.getBloodExValue(12);

        bloodWBCResult.setText(bloodWBC);
        bloodRBCResult.setText(bloodRBC);
        hgbResult.setText(hgb);
        hctResult.setText(hct);
        mcvResult.setText(mcv);
        mchResult.setText(mch);
        mchcResult.setText(mchc);
        pltResult.setText(plt);
        neutrophilResult.setText(neutrophil);
        lymphocyteResult.setText(lymphocyte);
        monocyteResult.setText(monocyte);
        eosinophilResult.setText(eosinophil);
        basophilResult.setText(basophil);

        return view;
    }
}
