package com.example.patel.simple_app_with_graph;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.patel.simple_app_with_graph.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button bContinue;
    Button bLogin;
    int cont = 0;
    EditText etUsername, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bContinue = (Button) findViewById(R.id.bContinue);
        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);


        //init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users");

        bContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //check if already exists
                        if (dataSnapshot.child(etUsername.getText().toString()).exists()) {

                            mDialog.dismiss();
                            Toast.makeText(MainActivity.this, "User already exists in Database", Toast.LENGTH_SHORT).show();

                        } else {
                            mDialog.dismiss();

                            User user = new User(etPassword.getText().toString(), etEmail.getText().toString());
                            table_user.child(etUsername.getText().toString()).setValue(user);
                            Toast.makeText(MainActivity.this, "Sign up success!", Toast.LENGTH_SHORT).show();
                            cont++;

                            Intent intent = new Intent(MainActivity.this, Main_Menu.class);
                            startActivity(intent);
                            //finish();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
//
//                if (cont != 0) {
//                    Intent intent = new Intent(MainActivity.this, Main_Menu.class);
//                    startActivity(intent);
//                }

            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, login_activity.class);
                startActivity(intent);
            }
        });




    }
}
