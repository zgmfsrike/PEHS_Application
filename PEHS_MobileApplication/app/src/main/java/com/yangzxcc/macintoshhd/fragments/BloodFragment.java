package com.yangzxcc.macintoshhd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.pehs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodFragment extends Fragment {

    private TextView bloodWBC,bloodRBC,hgb,hct,mcv,mch,mchc,plt,neutrophil,lymphocyte,monocyte,eosinophil,basophil;

    public BloodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blood, container, false);

        bloodWBC = (TextView)view.findViewById(R.id.bloodWhiteRe);
        bloodRBC = (TextView)view.findViewById(R.id.bloodRedRe);
        hgb = (TextView)view.findViewById(R.id.hgbRe);
        hct = (TextView)view.findViewById(R.id.hctRe);
        mcv = (TextView)view.findViewById(R.id.mcvRe);
        mch = (TextView)view.findViewById(R.id.mchRe);
        mchc = (TextView)view.findViewById(R.id.mchcRe);
        plt = (TextView)view.findViewById(R.id.pltRe);
        neutrophil = (TextView)view.findViewById(R.id.neutrophilRe);
        lymphocyte = (TextView)view.findViewById(R.id.lymphocyteRe);
        monocyte = (TextView)view.findViewById(R.id.monocyteRe);
        eosinophil = (TextView)view.findViewById(R.id.eosinophilRe);
        basophil = (TextView)view.findViewById(R.id.basophilRe);

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        String bloodWhite = bundle.getString("title");
        String bloodRed = bundle.getString("title");
        String hgb = bundle.getString("title");
        String hct = bundle.getString("title");
        String mcv = bundle.getString("title");
        String mch = bundle.getString("title");
        String mchc = bundle.getString("title");
        String plt = bundle.getString("title");
        String neutrophil = bundle.getString("title");
        String lymphocyte = bundle.getString("title");
        String monocyte = bundle.getString("title");
        String eosinophil = bundle.getString("title");
        String basophil = bundle.getString("title");

        bloodWBC.setText(bloodWhite);
        bloodRBC.setText(bloodRed);
        return view;
    }

}
