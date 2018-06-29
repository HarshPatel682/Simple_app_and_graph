package com.example.patel.simple_app_with_graph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bSubmit = (Button) findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bar_graph.class);
                startActivity(intent);
            }
        });

        Button bSubmit_Hydration = (Button) findViewById(R.id.bSubmit_Hydration);
        bSubmit_Hydration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Hydration_ex.class);
                startActivity(intent2);
            }
        });
    }
}
