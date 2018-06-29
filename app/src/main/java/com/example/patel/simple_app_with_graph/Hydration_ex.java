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

    PieChart mChart;
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

        mChart = (PieChart) findViewById(R.id.piechart);
        mChart.setBackgroundColor(Color.WHITE);
        //moveOffScreen();

        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setDrawHoleEnabled(true);
        mChart.setMaxAngle(180);
        mChart.setRotationAngle(180);
        mChart.setCenterTextOffset(0, -20);
        mChart.setRotationEnabled(false);
        mChart.animateXY(900, 900);
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
        mChart.setData(pieData);
        mChart.invalidate();

    }

    protected void moveOffScreen() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;

        int offset = (int) (height + .5);


        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)mChart.getLayoutParams();
        //RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mChart.getLayoutParams();
        params.setMargins(0, 0, 0, -offset);
        mChart.setLayoutParams(params);
    }
}
