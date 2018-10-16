package com.yangzxcc.macintoshhd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.UrineInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrineFragment extends Fragment {

    private TextView colorResult,appearanceResult,specificGravityResult,phResult,albuminResult,sugarResult,urineRBCResult,
            urineWBCResult,epithelialResult;
    private List<UrineInformation> urine;
    private UrineInformation urin;

    public UrineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_urine, container, false);
        colorResult = (TextView)view.findViewById(R.id.colorRe);
        appearanceResult = (TextView)view.findViewById(R.id.appearanceRe);
        specificGravityResult = (TextView)view.findViewById(R.id.specificGravityRe);
        phResult = (TextView)view.findViewById(R.id.phRe);
        albuminResult = (TextView)view.findViewById(R.id.albuminRe);
        sugarResult = (TextView)view.findViewById(R.id.sugarRe);
        urineRBCResult = (TextView)view.findViewById(R.id.urineRedRe);
        urineWBCResult = (TextView)view.findViewById(R.id.urineWhiteRe);
        epithelialResult = (TextView)view.findViewById(R.id.epithelialRe);

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        urine = (List<UrineInformation>) bundle.getSerializable("urine");
        urin = urine.get(0);
        String color = urin.getUrineExValue();
        String appear = urin.getUrineExValue();
        String spec = urin.getUrineExValue();
        String ph = urin.getUrineExValue();
        String albu = urin.getUrineExValue();
        String sugar = urin.getUrineExValue();
        String urineRed = urin.getUrineExValue();
        String urineWhite = urin.getUrineExValue();
        String epi = urin.getUrineExValue();

        colorResult.setText(color);
        appearanceResult.setText(appear);
        specificGravityResult.setText(spec);
        phResult.setText(ph);
        albuminResult.setText(albu);
        sugarResult.setText(sugar);
        urineRBCResult.setText(urineRed);
        urineWBCResult.setText(urineWhite);
        epithelialResult.setText(epi);

        return view;
    }
}
