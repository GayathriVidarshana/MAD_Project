package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.DATABASE.Deliver_Charges;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDileiverCharges extends AppCompatActivity {

    EditText add1, add2, add3, add4, add5, add6, add7, add8, add9 ;
    Button Btnadd1, Btnadd2, Btnadd3, Btnadd4, Btnadd5, Btnadd6, Btnadd7, Btnadd8, Btnadd9, btnSave;
    DatabaseReference reff;
    Deliver_Charges D_charges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deiver_charges);

//distric deliver charges
        TextView gampaha = findViewById (R.id.D1);
        gampaha.setText(R.string.d1Gampaha);

        add1 = (EditText)findViewById(R.id.crg1);

        TextView Colombo = findViewById (R.id.d2);
        Colombo.setText(R.string.d2Colombo);

        add2 = (EditText)findViewById(R.id.crg2);

        TextView Kalutara = findViewById (R.id.d3);
        Kalutara.setText(R.string.d3Kalutara);

        add3 = (EditText)findViewById(R.id.crg3);

        TextView Kandy = findViewById (R.id.d4);
        Kandy.setText(R.string.d4Kandy);

        add4 = (EditText)findViewById(R.id.crg4);

        TextView Kegalle = findViewById (R.id.d5);
        Kegalle.setText(R.string.d5Kegalle);

        add5 = (EditText)findViewById(R.id.crg5);

        TextView Ratnapura = findViewById (R.id.d6);
        Ratnapura.setText(R.string.d6Ratnapura);

        add6 = (EditText)findViewById(R.id.crg6);

        TextView Hambantota = findViewById (R.id.d7);
        Hambantota.setText(R.string.d7Hambantota);

        add7 = (EditText)findViewById(R.id.crg7);

        TextView Matara = findViewById (R.id.d8);
        Matara.setText(R.string.d8Matara);

        add8 = (EditText)findViewById(R.id.crg8);

        TextView Galle = findViewById (R.id.d9);
        Galle.setText(R.string.d9Galle);

        add9 = (EditText)findViewById(R.id.crg9);



// button

        Button Btnadd1 = (Button)findViewById(R.id.Add1);
        Btnadd1.setText(R.string.ADD1);

        Button Btnadd2 = (Button)findViewById(R.id.add2);
        Btnadd2.setText(R.string.ADD2);

        Button Btnadd3 = (Button)findViewById(R.id.add3);
        Btnadd3.setText(R.string.ADD3);

        Button Btnadd4 = (Button)findViewById(R.id.add4);
        Btnadd4.setText(R.string.ADD4);

        Button Btnadd5 = (Button)findViewById(R.id.add5);
        Btnadd5.setText(R.string.ADD5);

        Button Btnadd6 = (Button)findViewById(R.id.add6);
        Btnadd6.setText(R.string.ADD6);

        Button Btnadd7 = (Button)findViewById(R.id.add7);
        Btnadd7.setText(R.string.ADD7);

        Button Btnadd8 = (Button)findViewById(R.id.add8);
        Btnadd8.setText(R.string.ADD8);

        Button Btnadd9 = (Button)findViewById(R.id.add9);
        Btnadd9.setText(R.string.ADD9);


        Button btnSave = (Button)findViewById(R.id.savebtn);
        btnSave.setText(R.string.Btnsave);




        D_charges  = new Deliver_Charges();
        reff = FirebaseDatabase.getInstance().getReference().child("Diliver_Charges");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double GampahaC = Double.parseDouble(add1.getText().toString().trim());
                Double ColomboC = Double.parseDouble(add2.getText().toString().trim());
                Double KalutharaC = Double.parseDouble(add3.getText().toString().trim());
                Double KandyC = Double.parseDouble(add4.getText().toString().trim());
                Double KegalleC = Double.parseDouble(add5.getText().toString().trim());
                Double RathnapuraC = Double.parseDouble(add6.getText().toString().trim());
                Double HambanthotaC = Double.parseDouble(add7.getText().toString().trim());
                Double MataraC = Double.parseDouble(add8.getText().toString().trim());
                Double GalleC = Double.parseDouble(add9.getText().toString().trim());


                D_charges.setGampaha(GampahaC);
                D_charges.setColombo(ColomboC);
                D_charges.setKaluthar(KalutharaC);
                D_charges.setKandy(KandyC);
                D_charges.setKagalle(KegalleC);
                D_charges.setRathnapura(RathnapuraC);
                D_charges.setHambanthota(HambanthotaC);
                D_charges.setMatara(MataraC);
                D_charges.setGalle(GalleC);


                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, " Add Diliver Charges ", Toast.LENGTH_LONG).show();





            }
        });
        /*
        Btnadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double GampahaC = Double.parseDouble(add1.getText().toString().trim());

                D_charges.setGampaha(GampahaC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();
            }
        });


        Btnadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double ColomboC = Double.parseDouble(add2.getText().toString().trim());

                D_charges.setColombo(ColomboC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });

        Btnadd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double KalutharaC = Double.parseDouble(add3.getText().toString().trim());

                D_charges.setKaluthar(KalutharaC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });

        Btnadd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double KandyC = Double.parseDouble(add4.getText().toString().trim());

                D_charges.setKandy(KandyC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });

        Btnadd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double KegalleC = Double.parseDouble(add5.getText().toString().trim());

                D_charges.setKagalle(KegalleC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });


        Btnadd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double RathnapuraC = Double.parseDouble(add6.getText().toString().trim());

                D_charges.setRathnapura(RathnapuraC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });


        Btnadd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double HambanthotaC = Double.parseDouble(add7.getText().toString().trim());

                D_charges.setHambanthota(HambanthotaC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });

        Btnadd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double MataraC = Double.parseDouble(add8.getText().toString().trim());

                D_charges.setMatara(MataraC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        });


        Btnadd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double GalleC = Double.parseDouble(add9.getText().toString().trim());

                D_charges.setGalle(GalleC);

                reff.push().setValue(D_charges);
                Toast.makeText( AddDileiverCharges.this, "Change Price ", Toast.LENGTH_LONG).show();

            }
        }); */



    }
}