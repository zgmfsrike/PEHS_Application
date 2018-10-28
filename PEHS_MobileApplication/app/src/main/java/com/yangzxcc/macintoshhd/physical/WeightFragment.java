package com.yangzxcc.macintoshhd.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
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

        for (int i = 0; i < data.size(); i++) {
            int weightValue = Integer.parseInt(data.get(i).getWeight());
            String dateValue = data.get(i).getDate();


            myWeightlist.add(weightValue);
            myDatelist.add(dateValue);
            System.out.println(myWeightlist.get(i));
            System.out.println(myDatelist.get(i));

//            DataPoint point = new DataPoint(i, Double.parseDouble(data.get(i).getWeight()));

        }

//        int weight = Integer.parseInt(InformationSingleton.getInstance().getInformation().getHealthInformation().get(0).getWeight());
//        int weight1 = Integer.parseInt(InformationSingleton.getInstance().getInformation().getHealthInformation().get(1).getWeight());
//
//        public DataPoint[] data1(){
//            int n=myWeightlist.size();     //to find out the no. of data-points
//            DataPoint[] values = new DataPoint[n];     //creating an object of type DataPoint[] of size 'n'
//            for(int i=0;i<n;i++){
//                DataPoint v = new DataPoint ((myWeightlist.get(i)),(myDatelist.get(i)));
//                values[i] = v;
//            }
//            return values;
//        }

//
//            GraphView graph = (GraphView) view.findViewById(R.id.graph);
////            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//        for (int i = 0; i < data.size(); i++) {
//            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//
//                    new DataPoint(i, myWeightlist.get(i))
////                new DataPoint(1, ),
////                new DataPoint(2, 12),
//
//        });
//
//            graph.addSeries(series);
//}
        GraphView graph = (GraphView) view.findViewById(R.id.graph);
////
        DataPoint[] dp = new DataPoint[data.size()];
        for(int i=0;i<data.size();i++){
            dp[i] = new DataPoint(i+1, myWeightlist.get(i));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

        graph.addSeries(series);
        // use static labels for horizontal and vertical labels
//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new"});
//        staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);


        return view;
    }

}
