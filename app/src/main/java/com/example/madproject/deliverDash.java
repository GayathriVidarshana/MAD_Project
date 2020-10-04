package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class deliverDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_dash);



        ImageButton AddChrges = (ImageButton) findViewById(R.id.AddDcharges);
        AddChrges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAddDeiverCharges();

            }
        });


        ImageButton IDriver = (ImageButton) findViewById(R.id.AddDriver);
        IDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAddDriver();

            }
        });



    }

    private void openAddDriver() {
        Intent intent = new Intent(this, AddDriver.class);
        startActivity(intent);

    }

    private void openAddDeiverCharges() {


        Intent intent = new Intent(this, AddDileiverCharges.class);
        startActivity(intent);
    }
}