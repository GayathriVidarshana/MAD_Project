package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        TextView UName = findViewById(R.id.Uname);
        UName.setText(R.string.UName);

        TextView UserDsplynmae = findViewById(R.id.UDName);
        UserDsplynmae.setText(R.string.UserDsplynmae);

        TextView Uphone = findViewById(R.id.Uphone);
        Uphone.setText(R.string.Uphone);

        TextView Udsplyphone = findViewById(R.id.UDPhone);
        Udsplyphone.setText(R.string.Udsplyphone);

        TextView Uemail = findViewById(R.id.UEmail);
        Uemail.setText(R.string.Uemail);

        TextView UsrdsplyEmail = findViewById(R.id.UDEmail);
        UsrdsplyEmail.setText(R.string.UsrdsplyEmail);

        TextView Upswrd = findViewById(R.id.UPswrd);
        Upswrd.setText(R.string.Upswrd);

        TextView usrdsplyPswrd = findViewById(R.id.UDPswrd);
        usrdsplyPswrd.setText(R.string.usrdsplyPswrd);

        TextView btnuserDelete = findViewById(R.id.UserDelete);
        btnuserDelete.setText(R.string.btnuserDelete);

        TextView btnuserUpdate = findViewById(R.id.UserUpdate);
        btnuserUpdate.setText(R.string.btnuserUpdate);
        Button button = (Button)findViewById(R.id.UserUpdate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openUserUpdate();
            }

        });

    }

    public void openUserUpdate(){

        Intent intent = new Intent(this, UserUpdate.class);
        startActivity(intent);
    }
}