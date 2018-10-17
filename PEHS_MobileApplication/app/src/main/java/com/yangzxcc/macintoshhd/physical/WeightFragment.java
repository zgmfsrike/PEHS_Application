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
public class WeightFragment extends Fragment {

    List<PhysicalInformation> physicalInformations;

    public WeightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        HealthDataVisualization activity = (HealthDataVisualization)getActivity();
        Bundle bundle = activity.getPhysical();
        String date = bundle.getString("date");
        physicalInformations = (List<PhysicalInformation>) bundle.getSerializable("physical");
//        PhysicalInformation value = (physicalInformations.get(0));
//        String value = (String) bundle.getSerializable("physical");



//        HealthDataVisualization activity = (HealthDataVisualization)getActivity();
//        Bundle bundle = activity.getListOfData();
//        List<PhysicalInformation> physicalInformation = (List<PhysicalInformation>) bundle.getSerializable("physical");
//        PhysicalInformation data = physicalInformation.get(0); // Weight
//        String weight = data.getPhysicalExValue();
//
// physicalInformation.getPhysicalExValue();
//        String weight = bundle.getString("physicalName");
//        String weightValue = bundle.getString("physicalValue");

//        List<PhysicalInformation> systolic = (List<PhysicalInformation>) bundle.getSerializable("physical");
//        PhysicalInformation sys = systolic.get(4); //Systolic value
//        String systolic1 = sys.getPhysicalExValue();

        GraphView graph = (GraphView)view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(Double.parseDouble(date),2 ),
//                new DataPoint(1, 5),
//                new DataPoint(2, parseInt(weightValue)),
//                new DataPoint(3, parseInt(weightValue)),
//                new DataPoint(4, parseInt(weightValue))
        });
        graph.addSeries(series);
        return view;
    }

}
