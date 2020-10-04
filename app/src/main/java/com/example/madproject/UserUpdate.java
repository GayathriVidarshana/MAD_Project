package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);


        TextView upUName = findViewById(R.id.upUname);
        upUName.setText(R.string.upUName);
        EditText upUserDsplynmae =(EditText) findViewById(R.id.UpdateName);
        upUserDsplynmae.setHint(R.string.upUserDsplynmae);

        TextView upUphone = findViewById(R.id.upUPhone);
        upUphone.setText(R.string.upUphone);
        EditText upUdsplyphone =(EditText) findViewById(R.id.upUPhone);
        upUdsplyphone.setHint(R.string.upUdsplyphone);

        TextView upUemail = findViewById(R.id.upUEmail);
        upUemail.setText(R.string.upUemail);
        EditText upUsrdsplyEmail =(EditText) findViewById(R.id.UdateEmail);
        upUsrdsplyEmail.setHint(R.string.upUsrdsplyEmail);

        TextView upUpswrd = findViewById(R.id.upUPswrd);
        upUpswrd.setText(R.string.upUpswrd);
        EditText upusrdsplyPswrd =(EditText) findViewById(R.id.inputpawrd);
        upusrdsplyPswrd.setHint(R.string.upusrdsplyPswrd);

        TextView upsave = findViewById(R.id.btnUpSave);
        upsave.setText(R.string.upsave);
    }
}