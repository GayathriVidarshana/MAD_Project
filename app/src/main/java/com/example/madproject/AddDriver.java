package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.DATABASE.Add_Driver;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDriver extends AppCompatActivity {

    EditText editname, editphone, editLno, editNIC, editVtype, editVno;
    Button addBtn;
    DatabaseReference reff;
    Add_Driver Driver_Details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);



        TextView Dname = findViewById(R.id.Dname);
        Dname.setText(R.string.DriverName);

         editname = (EditText)findViewById(R.id.getname);

        TextView DPhone = findViewById(R.id.Dphone);
        DPhone.setText(R.string.DriverPhone);

         editphone = (EditText)findViewById(R.id.getphone);

        TextView DLno = findViewById(R.id.DLno);
        DLno.setText(R.string.DriverLicenseNo);

         editLno = (EditText)findViewById(R.id.getLno);

        TextView DNIC = findViewById(R.id.DNIC);
        DNIC.setText(R.string.DriverNIC);

         editNIC = (EditText)findViewById(R.id.getNIC);

        TextView DVehicalType = findViewById(R.id.DvehicalType);
        DVehicalType.setText(R.string.DVehicalType);

         editVtype = (EditText)findViewById(R.id.getvtype);

        TextView Dvehicalno = findViewById(R.id.DvehicaleNo);
        Dvehicalno.setText(R.string.DVehicalNum);

        editVno = (EditText)findViewById(R.id.getvNo);

        //save button
        TextView addBtn = findViewById(R.id.AddDriver);
        addBtn.setText(R.string.AddDriverBtn);


        Driver_Details = new Add_Driver();
        reff = FirebaseDatabase.getInstance().getReference().child("Driver_Details ");

        Button saveBtn = (Button)findViewById(R.id.AddDriver);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int phone = Integer.parseInt(editphone.getText().toString().trim());

                Driver_Details.setName(editname.getText().toString().trim());
                Driver_Details.setPhone(phone);
                Driver_Details.setLicenseNo(editLno.getText().toString().trim());
                Driver_Details.setNIC(editNIC.getText().toString().trim());
                Driver_Details.setV_type(editVtype.getText().toString().trim());
                Driver_Details.setV_No(editVno.getText().toString().trim());

                //set primary Key
                reff.child(editNIC.getText().toString().trim()).setValue(Driver_Details);
                reff.push().setValue(Driver_Details);

                Toast.makeText( AddDriver.this, "Add Driver Details", Toast.LENGTH_LONG).show();


            }
        });

    }



}