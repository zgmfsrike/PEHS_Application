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
    private UrineInformation col1,app1,spec1,ph1,alb1,sug1,uriRed1,uriWh1,epi1;

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
        col1 = urine.get(0);
        app1 = urine.get(1);
        spec1 = urine.get(2);
        ph1 = urine.get(3);
        alb1 = urine.get(4);
        sug1 = urine.get(5);
        uriRed1 = urine.get(6);
        uriWh1 = urine.get(7);
        epi1 = urine.get(8);

        String color = col1.getUrineExValue();
        String appear = app1.getUrineExValue();
        String spec = spec1.getUrineExValue();
        String ph = ph1.getUrineExValue();
        String albu = alb1.getUrineExValue();
        String sugar = sug1.getUrineExValue();
        String urineRed = uriRed1.getUrineExValue();
        String urineWhite = uriWh1.getUrineExValue();
        String epi = epi1.getUrineExValue();

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
