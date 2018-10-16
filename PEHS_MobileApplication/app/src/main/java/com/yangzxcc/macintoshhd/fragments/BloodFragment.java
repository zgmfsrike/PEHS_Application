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

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        blood = (List<BloodInformation>) bundle.getSerializable("blood");
        wbc = blood.get(0);
        rbc = blood.get(1);
        hgb1 = blood.get(2);
        hct1 = blood.get(3);
        mcv1 = blood.get(4);
        mch1 = blood.get(5);
        mchc1 = blood.get(6);
        plt1 = blood.get(7);
        neu1 = blood.get(8);
        lym1 = blood.get(9);
        mono1 = blood.get(10);
        eos1 = blood.get(11);
        bas1 = blood.get(12);

        String bloodWBC = wbc.getBloodExValue();
        String bloodRBC = rbc.getBloodExValue();
        String hgb = hgb1.getBloodExValue();
        String hct = hct1.getBloodExValue();
        String mcv = mcv1.getBloodExValue();
        String mch = mch1.getBloodExValue();
        String mchc = mchc1.getBloodExValue();
        String plt = plt1.getBloodExValue();
        String neutrophil = neu1.getBloodExValue();
        String lymphocyte = lym1.getBloodExValue();
        String monocyte = mono1.getBloodExValue();
        String eosinophil = eos1.getBloodExValue();
        String basophil = bas1.getBloodExValue();

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
