package com.example.patel.simple_app_with_graph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Current_Status extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current__status);

        imageButton = (ImageButton) findViewById(R.id.ibBack);
        refresh = (ImageButton) findViewById(R.id.ibRefresh);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Current_Status.this, Main_Menu.class);
                startActivity(intent);
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Current_Status.this, Current_Status.class);
                startActivity(intent);
            }
        });
    }

}
