package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "sucsessfully created", Toast.LENGTH_LONG).show();




        ImageButton ImItem = (ImageButton) findViewById(R.id.ImgItem);
        ImItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openItem();

            }
        });



        ImageButton IuserBtn = (ImageButton) findViewById(R.id.iUser);
        IuserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openUserpanel();

            }
        });


        ImageButton Ideliverbtn = (ImageButton) findViewById(R.id.iDeliver);
        Ideliverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opendeliverDash();

            }
        });


    }

    private void opendeliverDash() {

        Intent intent = new Intent(this, deliverDash.class);
        startActivity(intent);

    }

    public void openItem() {

        Intent intent = new Intent(this, Item.class);
        startActivity(intent);
    }

    public void openUserpanel(){

        Intent intent = new Intent(this, Userpanel.class);
        startActivity(intent);
    }


}