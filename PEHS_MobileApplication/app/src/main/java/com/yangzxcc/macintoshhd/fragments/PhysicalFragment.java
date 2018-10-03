package com.yangzxcc.macintoshhd.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.pehs.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {
    TextView tvResult;
    HealthAdapter healthAdapter;


//        title = getArguments().getString("title");


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
        tvResult = (TextView) view.findViewById(R.id.tvResult);
        String title = this.getArguments().getString("title","kk");
//        initInstances(view);
        tvResult.setText(title);
        return view;
    }

//    private void initInstances(View view) {
//        tvResult = (TextView) view.findViewById(R.id.tvResult);
//        tvResult.setText(title);
//
//    }

}
