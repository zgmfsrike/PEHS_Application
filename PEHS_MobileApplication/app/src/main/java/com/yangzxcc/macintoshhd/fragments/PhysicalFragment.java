package com.yangzxcc.macintoshhd.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.nio.file.WatchEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    private TextView weightResult,heightResult,waistResult,bmiResult,systolicResult,diastolicResult,pulseResult;

    public PhysicalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physical, container, false);

        weightResult = (TextView) view.findViewById(R.id.weightRe);
        heightResult = (TextView) view.findViewById(R.id.heightRe);
        waistResult = (TextView)view.findViewById(R.id.waistRe);
        bmiResult = (TextView)view.findViewById(R.id.bmiRe);
        systolicResult = (TextView)view.findViewById(R.id.systolicRe);
        diastolicResult = (TextView)view.findViewById(R.id.diastolicRe);
        pulseResult = (TextView)view.findViewById(R.id.pulseRe);

        Record activity = (Record)getActivity();
        Bundle bundle = activity.getData();
        String title = bundle.getString("title");
        String text = bundle.getString("text");

        weightResult.setText(title);
        heightResult.setText(text);
        waistResult.setText(text);
        bmiResult.setText(text);
        systolicResult.setText(text);
        diastolicResult.setText(text);
        pulseResult.setText(text);
        return view;

    }
}
