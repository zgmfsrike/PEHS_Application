package com.yangzxcc.macintoshhd.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangzxcc.macintoshhd.activities.HealthDataVisualization;
import com.yangzxcc.macintoshhd.pehs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeightFragment extends Fragment {


    public WeightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        HealthDataVisualization activity = (HealthDataVisualization)getActivity();
        Bundle bundle = activity.getData();
        String weight = bundle.getString("physicalName");
        String weightValue = bundle.getString("physicalValue");


        return view;
    }

}
