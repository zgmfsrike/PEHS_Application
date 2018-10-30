package com.yangzxcc.macintoshhd.activities.physical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
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
    WebView webView;
    String newDateString;
    public WeightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

//        HealthPhysicalVisualization activity = (HealthPhysicalVisualization)getActivity();
//        Bundle bundle = activity.getPhysical();
//        String date = bundle.getString("date");
//
//        physicalInformations = (List<PhysicalInformation>) bundle.getSerializable("physical");
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

        if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0) {
            List<HealthInformation> data = InformationSingleton.getInstance().getInformation().getHealthInformation();

            ArrayList<Integer> myWeightlist = new ArrayList<Integer>();
            ArrayList<String> myDatelist = new ArrayList<String>();

            for (int i = 0; i < data.size(); i++) {
                int weightValue = Integer.parseInt(data.get(i).getWeight());
                String dateValue = data.get(i).getDate();

//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            Date startDate;
//            try {
//                startDate = df.parse(dateValue);
//                newDateString = df.format(startDate);
//                Log.e("DATE","DATE"+newDateString);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

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

//        DataPoint[] dp = new DataPoint[5];
//        for(int i = 5; i >0; i--){
//            dp[5-i] = new DataPoint(Double.parseDouble(myDatelist.get(data.size()-i)), myWeightlist.get(data.size()-i));
//        }
            DataPoint[] dp = new DataPoint[5];
            for (int i = 5; i > 0; i--) {
                dp[5 - i] = new DataPoint(data.size() - i, myWeightlist.get(data.size() - i));
            }
//        for(int i=0;i<data.size();i++){
//            dp[i] = new DataPoint(i, myWeightlist.get(i));
//        }

            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);


            // activate horizontal zooming and scrolling
//        graph.getViewport().setScalable(true);
//        if (data.size() > 10){
//            graph.getViewport().setMaxX(10);
//        }else {
//            graph.getViewport().setMaxX(data.size());
//        }


// activate horizontal scrolling
//        graph.getViewport().setScrollable(true);

//// activate horizontal and vertical zooming and scrolling
//        graph.getViewport().setScalableY(true);
//
//// activate vertical scrolling
//        graph.getViewport().setScrollableY(true);

//        NumberFormat nf = NumberFormat.getInstance();
//        nf.setMinimumFractionDigits(3);
//        nf.setMinimumIntegerDigits(2);
//
//        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf));


            // custom label formatter to show currency "EUR"
            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                @Override
                public String formatLabel(double value, boolean isValueX) {
                    if (isValueX) {
                        // show normal x values
                        return "Day " + super.formatLabel(value, isValueX);
                    } else {
                        // show currency for y values
                        return super.formatLabel(value, isValueX) + " Kg";
                    }
                }
            });

            graph.addSeries(series);
            // use static labels for horizontal and vertical labels
//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new"});
//        staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        }else {
            GraphView graph = (GraphView)view.findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
//                    new DataPoint(0, 1),
//                    new DataPoint(1, 5),
//                    new DataPoint(2, 3),
//                    new DataPoint(3, 2),
//                    new DataPoint(4, 6)
            });
            graph.addSeries(series);
        }
        return view;
    }

}
