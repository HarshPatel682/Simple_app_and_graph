package com.example.patel.simple_app_with_graph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class bar_graph extends AppCompatActivity {

    BarChart barChart;
    TextView tvViewPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);


        barChart = (BarChart) findViewById(R.id.bargraph);
        tvViewPercent = (TextView) findViewById(R.id.tvViewPercent);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 44f));
        barEntries.add(new BarEntry(1, 88f));
        barEntries.add(new BarEntry(2, 34f));
        barEntries.add(new BarEntry(3, 78f));
        barEntries.add(new BarEntry(4, 90f));
        barEntries.add(new BarEntry(5, 75f));


        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");

        /*
        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("June");
        theDates.add("July");
        theDates.add("August");
        theDates.add("September");
        theDates.add("October");
        theDates.add("November");
        theDates.add("December");
        */

        BarData data = new BarData(barDataSet);
        barChart.setData(data);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

        barChart.animateXY(900,900);

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                float y = e.getY();
                String s = "" + y;
                tvViewPercent.setText(s);
            }

            @Override
            public void onNothingSelected() {
                tvViewPercent.setText("--");
            }
        });
    }
}
