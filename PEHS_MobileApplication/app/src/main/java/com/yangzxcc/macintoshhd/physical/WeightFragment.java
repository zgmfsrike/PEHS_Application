package com.yangzxcc.macintoshhd.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.yangzxcc.macintoshhd.activities.HealthPhysicalVisualization;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.manager.InformationSingleton;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
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

        HealthPhysicalVisualization activity = (HealthPhysicalVisualization)getActivity();
        Bundle bundle = activity.getPhysical();
        String date = bundle.getString("date");

        physicalInformations = (List<PhysicalInformation>) bundle.getSerializable("physical");
//        PhysicalInformation value = (physicalInformations.get(0));
//        String value = (String) bundle.getSerializable("physical");




//        HealthPhysicalVisualization activity = (HealthPhysicalVisualization)getActivity();
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
//        String
//        System.out.println(InformationSingleton.getInstance().getInformation().getHealthInformation().get(0).getWeight());

        List<HealthInformation> data = InformationSingleton.getInstance().getInformation().getHealthInformation();
//        data.get(0).getWeight();
        ArrayList<Integer> myWeightlist = new ArrayList<Integer>();
        ArrayList<String> myDatelist = new ArrayList<String>();
//        mylist.add(mystring);

        for (int i = 0; i < data.size(); i++) {
            int weightValue = Integer.parseInt(data.get(i).getWeight());
            String dateValue = data.get(i).getDate();

            myWeightlist.add(weightValue);
            myDatelist.add(dateValue);
            System.out.println(myWeightlist.get(i));
            System.out.println(myDatelist.get(i));
        }
//        int weight = Integer.parseInt(InformationSingleton.getInstance().getInformation().getHealthInformation().get(0).getWeight());
        int weight1 = Integer.parseInt(InformationSingleton.getInstance().getInformation().getHealthInformation().get(1).getWeight());

        GraphView graph = (GraphView)view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {

//                new DataPoint(1, ),
//                new DataPoint(2, 12),

        });

        graph.addSeries(series);

        return view;
    }

}
