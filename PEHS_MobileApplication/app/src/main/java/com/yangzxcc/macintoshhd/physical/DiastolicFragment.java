package com.yangzxcc.macintoshhd.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.yangzxcc.macintoshhd.activities.HealthDataVisualization;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiastolicFragment extends Fragment {


    public DiastolicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diastolic, container, false);

        HealthDataVisualization activity = (HealthDataVisualization)getActivity();
        Bundle bundle = activity.getListOfData();
        List<PhysicalInformation> dias = (List<PhysicalInformation>) bundle.getSerializable("physical");
        PhysicalInformation diastolic = dias.get(5); //Diastolic value
        String dia = diastolic.getPhysicalExValue();



        GraphView graph = (GraphView)view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, Double.parseDouble(dia)),
//                new DataPoint(1, parseInt(weightValue)),
//                new DataPoint(2, parseInt(weightValue)),
//                new DataPoint(3, parseInt(weightValue)),
//                new DataPoint(4, parseInt(weightValue))
        });
        graph.addSeries(series);

        return view;
    }

}