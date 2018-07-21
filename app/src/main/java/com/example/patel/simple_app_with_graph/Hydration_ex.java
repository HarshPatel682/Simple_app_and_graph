package com.example.patel.simple_app_with_graph;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Hydration_ex extends AppCompatActivity {

    PieChart pieChart;
    Button bTest;
    EditText etHydration;
    TextView tvHydration_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydration_ex);

        bTest = (Button) findViewById(R.id.bHydration_Change);
        etHydration = (EditText) findViewById(R.id.etHydration_Test);
        tvHydration_Value = (TextView) findViewById(R.id.tvShow_Percent);

        pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setBackgroundColor(Color.WHITE);
        //moveOffScreen();

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setMaxAngle(180);
        pieChart.setRotationAngle(180);
        pieChart.setCenterTextOffset(0, -20);
        pieChart.setRotationEnabled(false);
        pieChart.animateXY(900, 900);
        setData(80);

        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float val = Float.parseFloat(etHydration.getText().toString());
                tvHydration_Value.setText(etHydration.getText().toString());
                setData(val);
            }
        });
    }

    protected void setData(float value) {

        if (value >= 100 || value <= 0) {
            String s = "Ha, You Thought!";
            tvHydration_Value.setText(s);
            return;
        }

        float extra = 100 - value;
        ArrayList<PieEntry> data = new ArrayList<>();
        data.add(new PieEntry(value, "Hydration"));
        data.add(new PieEntry(extra, ""));

        PieDataSet pieDataSet = new PieDataSet(data, "Hydration %");
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);


        PieData pieData = new PieData(pieDataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(15f);
        pieData.setValueTextColor(Color.BLUE);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    protected void moveOffScreen() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;

        int offset = (int) (height + .5);


        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)pieChart.getLayoutParams();
        //RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)pieChart
        //.getLayoutParams();
        params.setMargins(0, 0, 0, -offset);
        pieChart.setLayoutParams(params);
    }
}
