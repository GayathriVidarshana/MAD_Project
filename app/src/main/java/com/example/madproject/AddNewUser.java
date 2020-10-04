package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.DATABASE.Add_Driver;
import com.example.madproject.DATABASE.Add_Item_DB;
import com.example.madproject.DATABASE.Add_User_DB;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewUser extends AppCompatActivity {

    EditText inputusrename, InputPhone, InputEmail, inputPswrd;
    Button btnsave;
    DatabaseReference reff;
    Add_User_DB Add_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);



        TextView txtaddnewUser = findViewById(R.id.addUName);
        txtaddnewUser.setText(R.string.UserName);

        inputusrename =(EditText) findViewById(R.id.EnterUName);
        inputusrename.setHint(R.string.EnterUserName);

        TextView userPhone = findViewById(R.id.uPhone);
        userPhone.setText(R.string.userPhone);

        InputPhone =findViewById(R.id.inputPhone);
        InputPhone.setHint(R.string.InputPhone);

        TextView UserEmail = findViewById(R.id.Uemail);
        UserEmail.setText(R.string.UserEmail);

        InputEmail =(EditText) findViewById(R.id.inputEmail);
        InputEmail.setHint(R.string.InputEmail);

        TextView UserPassword = findViewById(R.id.Upaswrd);
        UserPassword.setText(R.string.UserPassword);

        inputPswrd =(EditText) findViewById(R.id.inputpawrd);
        inputPswrd.setHint(R.string.inputPswrd);

        TextView btnsave = findViewById(R.id.btnSave);
        btnsave.setText(R.string.saveUser);

        Add_User = new Add_User_DB();

        //location to save
        reff = FirebaseDatabase.getInstance().getReference().child("User_Details");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int phone_u = Integer.parseInt(InputPhone.getText().toString().trim());

                Add_User.setUName(inputusrename.getText().toString().trim());
                Add_User.setUphone(phone_u);
                Add_User.setUEmail(InputEmail.getText().toString().trim());
                Add_User.setUPw(inputPswrd.getText().toString().trim());


                //set Primary key
                reff.child(inputusrename.getText().toString().trim()).setValue(Add_User);

                reff.push().setValue(Add_User);
                Toast.makeText( AddNewUser.this, "Done", Toast.LENGTH_LONG).show();

            }
        });


        }
    }

