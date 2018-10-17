package com.yangzxcc.macintoshhd.activities.chemistry;


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
public class CholesterolFragment extends Fragment {


    public CholesterolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cholesterol, container, false);

        GraphView graph = (GraphView)view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 189),
//                new DataPoint(1, parseInt(weightValue)),
//                new DataPoint(2, parseInt(weightValue)),
//                new DataPoint(3, parseInt(weightValue)),
//                new DataPoint(4, parseInt(weightValue))
        });
        graph.addSeries(series);

        return view;
    }


}
