package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.DATABASE.Add_Item_DB;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

    EditText Inputcode, InputName, InputModel, InputDiscount, InputPrice, InputDescription, InputStock;
    Button SaveNewItemBtn;
    ImageView imageView;
    public Uri imageUri;

    //declare database reference
    DatabaseReference reff;
    //declare storage Reference
    StorageReference myStorage;
    Add_Item_DB Add_Item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //CODE FOR INPUT IMAGES FROM GALLERY
        TextView ImgButtonAdd = findViewById(R.id.btnimage);
        ImgButtonAdd.setText(R.string.ImgButtonAdd);
        ImgButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Filechooser();
                if (ActivityCompat.checkSelfPermission(AddItem.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AddItem.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);

                }

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                startActivityForResult(intent, 1);

            }

        });


        TextView Itemcode = findViewById(R.id.txtcode);
        Itemcode.setText(R.string.Itemcode);

        Inputcode = (EditText) findViewById(R.id.inptcode);
        Inputcode.setHint(R.string.Inputcode);

        TextView ItemName = findViewById(R.id.txtname);
        ItemName.setText(R.string.ItemName);

        InputName = (EditText) findViewById(R.id.InptName);
        InputName.setHint(R.string.InputName);

        TextView ItemModel = findViewById(R.id.txtmodule);
        ItemModel.setText(R.string.ItemModel);

        InputModel = (EditText) findViewById(R.id.inptModule);
        InputModel.setHint(R.string.InputModel);

        TextView ItemDiscount = findViewById(R.id.txtDiscount);
        ItemDiscount.setText(R.string.ItemDiscount);

        InputDiscount = (EditText) findViewById(R.id.inptDiscount);
        InputDiscount.setHint(R.string.InputDiscount);

        TextView ItemPrice = findViewById(R.id.txtPrice);
        ItemPrice.setText(R.string.ItemPrice);

        InputPrice = (EditText) findViewById(R.id.inptPrice);
        InputPrice.setHint(R.string.InputPrice);

        TextView ItemDiscription = findViewById(R.id.txtdiscription);
        ItemDiscription.setText(R.string.ItemDiscription);

        InputDescription = (EditText) findViewById(R.id.inptDiscription);
        InputDescription.setHint(R.string.InputDescription);

        TextView ItemStock = findViewById(R.id.txtStock);
        ItemStock.setText(R.string.ItemStock);

        InputStock = (EditText) findViewById(R.id.inptStock);
        InputStock.setHint(R.string.InputStock);

        TextView SaveNewItemBtn = findViewById(R.id.btnsave);
        SaveNewItemBtn.setText(R.string.SaveNewItem);


        //firebase table
        Add_Item = new Add_Item_DB();
        //location to save Item data in firebase
        reff = FirebaseDatabase.getInstance().getReference().child("Item_Details");
        //location to save images of Item in firebase
        myStorage = FirebaseStorage.getInstance().getReference("Item_Image");

        SaveNewItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double InputPriceC = Double.parseDouble(InputPrice.getText().toString().trim());
                double InputDiscountI = Double.parseDouble(InputDiscount.getText().toString().trim());
                int StockI = Integer.parseInt(InputStock.getText().toString().trim());

                Add_Item.setIcode(Inputcode.getText().toString().trim());
                Add_Item.setBrName(InputName.getText().toString().trim());
                Add_Item.setImodel(InputModel.getText().toString().trim());
                Add_Item.setIprice(InputPriceC);
                Add_Item.setIDiscount(InputDiscountI);
                Add_Item.setIdescription(InputDescription.getText().toString().trim());
                Add_Item.setStock(StockI);

                //set primary key(Icode)
                reff.child(Inputcode.getText().toString().trim()).setValue(Add_Item);

                reff.push().setValue(Add_Item);
                Toast.makeText(AddItem.this, "Successfully saved", Toast.LENGTH_LONG).show();
                ClearFields();

            }

        });


    }

    private void Filechooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

//save image as a url in firebase
    private String getExtention(Uri uri) {

        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));

    }
    private void Fileuploder() {

        StorageReference Ref = myStorage.child(System.currentTimeMillis() + "." + getExtention(imageUri));

        Ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        // Get a URL to the uploaded content
                        // Uri downloadUrl = taskSnapshot.getUploadSessionUri();
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(AddItem.this, "Image Uploaded successfully", Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }
        //choose image fro gallery
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1 && requestCode == RESULT_OK && data != null && data.getData() != null) {
                imageView = findViewById(R.id.imageViewP);
                final List<Bitmap> bitmaps = new ArrayList<>();
                ClipData clipData = data.getClipData();

                if (clipData != null) {
                    for (int i = 0; i < clipData.getItemCount(); i++) {

                        imageUri = clipData.getItemAt(i).getUri();
                        try {
                            InputStream is = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            bitmaps.add(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } else {

                    imageUri = data.getData();
                    try {
                        InputStream is = getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        bitmaps.add(bitmap);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (final Bitmap b : bitmaps) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(b);
                                }
                            });
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();

            }
        }


    private void ClearFields(){

        Inputcode.setText("");
        InputName.setText("");
        InputModel.setText("");
        InputDiscount.setText("");
        InputPrice.setText("");
        InputDescription.setText("");
        InputStock.setText("");

    }

    }

