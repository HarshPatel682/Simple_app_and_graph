package com.example.patel.simple_app_with_graph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

public class Main_Menu extends AppCompatActivity {

    Button bCurr;
    Button pReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        bCurr = (Button) findViewById(R.id.bCurrentStatus);
        pReport = (Button) findViewById(R.id.bProgressReport);

        bCurr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Menu.this, Current_Status.class);
                startActivity(intent);
            }
        });

        pReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Menu.this, progress_report.class);
                startActivity(intent);
            }
        });


    }
}
