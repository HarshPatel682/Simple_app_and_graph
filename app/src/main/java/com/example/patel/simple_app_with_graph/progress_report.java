package com.example.patel.simple_app_with_graph;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorLong;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class progress_report extends AppCompatActivity {

    private Spinner month_spinner;
    private ImageButton imageButton;
    private LineChart mChart;
    private ColorfulRingProgressView crpv;
    private PieChart pieChart;
    private PieChart pieC_Steps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_report);

        imageButton = (ImageButton) findViewById(R.id.ibBack);
        mChart = findViewById(R.id.lineChart);
        pieChart = findViewById(R.id.piechart_hours);
        pieC_Steps = findViewById(R.id.piechart_steps);
        setUpChart();
        setUpPieChartHours();
        setUpPieChartSteps();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(progress_report.this, Main_Menu.class);
                startActivity(intent);
            }
        });

    }

    private void setUpChart() {

        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(1, 50));
        values.add(new Entry(2, 48));
        values.add(new Entry(3, 45));
        values.add(new Entry(4, 40));
        values.add(new Entry(5, 35));
        values.add(new Entry(6, 33));
        values.add(new Entry(7, 28));
        values.add(new Entry(8, 24));
        values.add(new Entry(9, 15));
        values.add(new Entry(10, 9));


        LineDataSet set = new LineDataSet(values, "Trial Data set");
        set.setLineWidth(3f);
        set.setCircleRadius(3f);
        set.setCircleHoleRadius(2.5f);
        set.setColor(Color.LTGRAY);
        set.setCircleColor(Color.WHITE);
        set.setHighLightColor(Color.WHITE);
        set.setDrawValues(false);
        set.setDrawCircles(false);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawFilled(true);
        set.setFillColor(Color.CYAN);
        set.setFillAlpha(80);

        LineData data = new LineData(set);

        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setGridBackgroundColor(Color.WHITE);
        mChart.setBackgroundColor(Color.WHITE);

        mChart.setViewPortOffsets(10,0,10,0);
        mChart.setData(data);
    }

    private void setUpPieChartHours() {
        Legend l = pieChart.getLegend();
        l.setEnabled(false);



        pieChart.setBackgroundColor(Color.WHITE);
        //moveOffScreen();

        pieChart.setBackgroundColor(Color.TRANSPARENT);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleRadius(75f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setRotationEnabled(false);
        pieChart.setHighlightPerTapEnabled(false);

        pieChart.setTransparentCircleRadius(25f);
        pieChart.animateXY(900, 900);

        pieChart.setCenterText("300/400 Hrs");

        ArrayList<PieEntry> data = new ArrayList<>();
        data.add(new PieEntry(75, ""));
        data.add(new PieEntry(25, ""));

        PieDataSet pieDataSet = new PieDataSet(data, "");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData = new PieData(pieDataSet);
        //pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(0f);
        //pieData.setValueTextColor(Color.BLUE);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private void setUpPieChartSteps() {
        Legend l = pieC_Steps.getLegend();
        l.setEnabled(false);



        pieC_Steps.setBackgroundColor(Color.WHITE);
        //moveOffScreen();

        pieC_Steps.setBackgroundColor(Color.TRANSPARENT);
        pieC_Steps.setHoleColor(Color.TRANSPARENT);
        pieC_Steps.setUsePercentValues(false);
        pieC_Steps.getDescription().setEnabled(false);
        pieC_Steps.setDrawHoleEnabled(true);
        pieC_Steps.setHoleRadius(75f);
        pieC_Steps.setDrawHoleEnabled(true);
        pieC_Steps.setHoleColor(Color.WHITE);
        pieC_Steps.setRotationEnabled(false);
        pieC_Steps.setTransparentCircleRadius(25f);
        pieC_Steps.setHighlightPerTapEnabled(false);
        pieC_Steps.animateXY(900, 900);

        pieC_Steps.setCenterText("4k/5k Steps");

        ArrayList<PieEntry> data = new ArrayList<>();
        data.add(new PieEntry(80, ""));
        data.add(new PieEntry(20, ""));

        PieDataSet pieDataSet = new PieDataSet(data, "");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData = new PieData(pieDataSet);
        //pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(0f);
        //pieData.setValueTextColor(Color.BLUE);
        pieC_Steps.setData(pieData);
        pieC_Steps.invalidate();
    }

}
