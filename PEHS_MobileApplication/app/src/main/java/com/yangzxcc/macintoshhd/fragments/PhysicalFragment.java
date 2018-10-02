package com.yangzxcc.macintoshhd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.pehs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    HealthAdapter healthAdapter;
    TextView tvResult;

    public PhysicalFragment() {
        // Required empty public constructor
    }
    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        String strtext = getArguments().getString("edttext");

//        int mPostId = getIntent().getIntExtra("pos",0);
//        Call<List<HealthRecord>> call = ApiInterface
        View view = inflater.inflate(R.layout.fragment_physical, container, false);
        initInstances(view);
        return view;
    }

    private void initInstances(View view) {
        tvResult = (TextView) view.findViewById(R.id.tvResult);
    }

}
