package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.textViewNext).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.textViewNext:

                Intent intent = new Intent(this, FarmerLocationActivity.class);
                intent.putExtra("EXTRA_MESSAGE", 1);
                startActivity(intent);
                break;
        }
    }
}
