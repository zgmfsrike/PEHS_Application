package com.yangzxcc.macintoshhd.activities.blood;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
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


    public LymphocyteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lymphocyte, container, false);

        if (InformationSingleton.getInstance().getInformation().getHealthInformation().size() > 0) {
            List<HealthInformation> data = InformationSingleton.getInstance().getInformation().getHealthInformation();

            ArrayList<Integer> myLymList = new ArrayList<Integer>();
            ArrayList<String> myDatelist = new ArrayList<String>();

            for (int i = 0; i < data.size(); i++) {
                int lymValue = Integer.parseInt(data.get(i).getLymphocyte());
                String dateValue = data.get(i).getDate();

                myLymList.add(lymValue);
                myDatelist.add(dateValue);
                System.out.println(myLymList.get(i));
                System.out.println(myDatelist.get(i));
            }
            GraphView graph = (GraphView) view.findViewById(R.id.graph);

            DataPoint[] dp = new DataPoint[5];
            for (int i = 5; i > 0; i--) {
                dp[5 - i] = new DataPoint(data.size() - i, myLymList.get(data.size() - i));
            }
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);
            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                @Override
                public String formatLabel(double value, boolean isValueX) {
                    if (isValueX) {
                        // show normal x values
                        return "Day " + super.formatLabel(value, isValueX);
                    } else {
                        // show currency for y values
                        return super.formatLabel(value, isValueX) + " %";
                    }
                }
            });
            graph.addSeries(series);

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
