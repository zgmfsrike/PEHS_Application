package com.yangzxcc.macintoshhd.activities.blood;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.manager.InformationSingleton;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LymphocyteFragment extends Fragment {

    private GridLabelRenderer gridLabel;
    private LineGraphSeries<DataPoint> series;

    public LymphocyteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0) {
            View view = inflater.inflate(R.layout.fragment_lymphocyte, container, false);

            List<HealthInformation> data = InformationSingleton.getInstance().getInformation().getHealthInformation();

            ArrayList<Integer> myLymList = new ArrayList<Integer>();
            ArrayList<String> myDatelist = new ArrayList<String>();
            ArrayList<Integer> myIdList = new ArrayList<Integer>();

            for (int i = 0; i < data.size(); i++) {
                int lymValue = Integer.parseInt(data.get(i).getLymphocyte());
                String dateValue = data.get(i).getDate();
                int idValue = data.get(i).getId();

                myLymList.add(lymValue);
                myDatelist.add(dateValue);
                myIdList.add(idValue);
//                System.out.println(myLymList.get(i));
//                System.out.println(myDatelist.get(i));
            }
            GraphView graph = (GraphView) view.findViewById(R.id.graph);

//            Handle error
            if (data.size() > 4) {
                DataPoint[] dp = new DataPoint[4];
                String[] myDate = new String[4];
                for (int i = 4; i > 0; i--) {
                    dp[4 - i] = new DataPoint(myIdList.get(data.size() - i), myLymList.get(data.size() - i));
                    myDate[4 - i] = myDatelist.get(data.size() - i).substring(8, 10) + "/" + myDatelist.get(data.size() - i).substring(5, 7) + "/" + myDatelist.get(data.size() - i).substring(2, 4);
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(new String[]{myDate[0], myDate[1], myDate[2], myDate[3]});
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

                GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
                gridLabel.setPadding(32);
//                gridLabel.setVerticalAxisTitle("Percentage");
//                gridLabel.setVerticalAxisTitleTextSize(19);
//                gridLabel.setLabelHorizontalHeight(50);

                graph.addSeries(series);
                return view;
            } else if (data.size() > 3) {

                DataPoint[] dp = new DataPoint[data.size()];
                String[] myDate = new String[data.size()];
                for(int i=0;i<data.size();i++){
                    dp[i] = new DataPoint(myIdList.get(i), myLymList.get(i));
                    myDate[i] = myDatelist.get(i).substring(8,10)+"/"+myDatelist.get(i).substring(5,7)+"/"+myDatelist.get(i).substring(2,4);
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(new String[] {myDate[0],myDate[1], myDate[2], myDate[3]});
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

                GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
                gridLabel.setPadding(32);
//                gridLabel.setVerticalAxisTitle("Percentage");
//                gridLabel.setVerticalAxisTitleTextSize(19);
//                gridLabel.setLabelHorizontalHeight(50);

                graph.addSeries(series);
                return view;
            } else if (data.size() > 2) {

                DataPoint[] dp = new DataPoint[data.size()];
                String[] myDate = new String[data.size()];
                for(int i=0;i<data.size();i++){
                    dp[i] = new DataPoint(myIdList.get(i), myLymList.get(i));
                    myDate[i] = myDatelist.get(i).substring(8,10)+"/"+myDatelist.get(i).substring(5,7)+"/"+myDatelist.get(i).substring(2,4);
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(new String[] {myDate[0],myDate[1], myDate[2]});
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

                GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
                gridLabel.setPadding(32);
//                gridLabel.setVerticalAxisTitle("Percentage");
//                gridLabel.setVerticalAxisTitleTextSize(19);
//                gridLabel.setLabelHorizontalHeight(50);

                graph.addSeries(series);
                return view;
            } else if (data.size() > 1) {

                DataPoint[] dp = new DataPoint[data.size()];
                String[] myDate = new String[data.size()];
                for(int i=0;i<data.size();i++){
                    dp[i] = new DataPoint(myIdList.get(i), myLymList.get(i));
                    myDate[i] = myDatelist.get(i).substring(8,10)+"/"+myDatelist.get(i).substring(5,7)+"/"+myDatelist.get(i).substring(2,4);
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                staticLabelsFormatter.setHorizontalLabels(new String[] {myDate[0],myDate[1]});
                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

                GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
                gridLabel.setPadding(32);
//                gridLabel.setVerticalAxisTitle("Percentage");
//                gridLabel.setVerticalAxisTitleTextSize(19);
//                gridLabel.setLabelHorizontalHeight(50);

                graph.addSeries(series);
                return view;
            }else {

//                Toast.makeText(getActivity(),"There is only one record",Toast.LENGTH_LONG).show();
//                DataPoint[] dp = new DataPoint[data.size()];
//                final String[] myDate = new String[data.size()];
//                for (int i = 0; i < data.size(); i++) {
//                    dp[i] = new DataPoint(myIdList.get(i), myLymList.get(i));
//                    myDate[i] = myDatelist.get(i).substring(8, 10) + "/" + myDatelist.get(i).substring(5, 7) + "/" + myDatelist.get(i).substring(2, 4);
//                }
//                series = new LineGraphSeries<>(dp);
//
//                gridLabel = graph.getGridLabelRenderer();
//                gridLabel.setLabelFormatter(new DefaultLabelFormatter() {
//                    @Override
//                    public String formatLabel(double value, boolean isValueX) {
//                        if (isValueX) {
//                            // show normal x values
//                            return myDate[0];
//                        } else {
//                            return super.formatLabel(value, isValueX);
//                        }
//                    }
//                });
//                gridLabel.setVerticalAxisTitle("Percentage");
//                gridLabel.setNumHorizontalLabels(1);
//                gridLabel.setVerticalAxisTitleTextSize(19);
//                gridLabel.setLabelHorizontalHeight(50);
//                graph.addSeries(series);
            }

        }else {
//            Toast.makeText(getActivity(),"The data cannot be visualized due to the insufficient amount of data",Toast.LENGTH_LONG).show();

        }
        return null;
    }

}
