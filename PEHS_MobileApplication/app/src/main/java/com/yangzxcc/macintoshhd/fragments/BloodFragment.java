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

        String bloodWBC = bloo.getBloodExValue();
        String bloodRBC = bloo.getBloodExValue();
        String hgb = bloo.getBloodExValue();
        String hct = bloo.getBloodExValue();
        String mcv = bloo.getBloodExValue();
        String mch = bloo.getBloodExValue();
        String mchc = bloo.getBloodExValue();
        String plt = bloo.getBloodExValue();
        String neutrophil = bloo.getBloodExValue();
        String lymphocyte = bloo.getBloodExValue();
        String monocyte = bloo.getBloodExValue();
        String eosinophil = bloo.getBloodExValue();
        String basophil = bloo.getBloodExValue();

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
