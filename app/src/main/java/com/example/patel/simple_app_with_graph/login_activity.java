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

public class login_activity extends AppCompatActivity {

    Button bLogin;
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);


        //init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users");


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(login_activity.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //check if user exists
                        if (dataSnapshot.child(etUsername.getText().toString()).exists()) {

                            //get user info
                            mDialog.dismiss();

                            User user = dataSnapshot.child(etUsername.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(etPassword.getText().toString())) {
                                Toast.makeText(login_activity.this, "Sign In Success!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login_activity.this, Main_Menu.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(login_activity.this, "Sign In Failed!!!", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(login_activity.this, "User does not exist in Database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
