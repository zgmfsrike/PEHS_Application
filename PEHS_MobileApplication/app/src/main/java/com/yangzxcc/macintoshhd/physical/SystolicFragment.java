package com.yangzxcc.macintoshhd.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.yangzxcc.macintoshhd.pehs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SystolicFragment extends Fragment {


    public SystolicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_systolic, container, false);

//        HealthPhysicalVisualization activity = (HealthPhysicalVisualization)getActivity();
//        Bundle bundle = activity.getListOfData();
//        List<PhysicalInformation> systolic = (List<PhysicalInformation>) bundle.getSerializable("physical");
//        PhysicalInformation sys = systolic.get(4); //Systolic value
//        String systolic1 = sys.getPhysicalExValue();
//
//
        GraphView graph = (GraphView)view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 119),
                new DataPoint(1, 60),
                new DataPoint(2, 56),
                new DataPoint(3, 90),
                new DataPoint(4, 90),
                new DataPoint(5, 90),
                new DataPoint(6, 90),
                new DataPoint(7, 90),
                new DataPoint(8, 90),
                new DataPoint(9, 90),
                new DataPoint(10, 90),
                new DataPoint(11, 90),
                new DataPoint(12, 120),

//                new DataPoint(1, parseInt(weightValue)),
//                new DataPoint(2, parseInt(weightValue)),
//                new DataPoint(3, parseInt(weightValue)),
//                new DataPoint(4, parseInt(weightValue))
        });
        graph.addSeries(series);

        return view;
    }

}
