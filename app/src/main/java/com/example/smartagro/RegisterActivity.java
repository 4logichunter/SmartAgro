package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButton;
 private  EditText txtName,txtMobile,txtPassword,txtAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.textViewNext).setOnClickListener(this);
         txtName=findViewById(R.id.editTextName);
         txtMobile=findViewById(R.id.editTextMobile);
         txtPassword=findViewById(R.id.editTextPassword);
         txtAddress=findViewById(R.id.editTextAddress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.textViewNext:


        String strname=txtName.getText().toString();

                String[] myArray={"1",txtName.getText().toString(),"123",txtAddress.getText().toString(),txtMobile.getText().toString()};

                Intent intent = new Intent(this, FarmerLocationActivity.class);
                intent.putExtra("EXTRA_MESSAGE", myArray);

                startActivity(intent);
                break;
        }
    }
}
