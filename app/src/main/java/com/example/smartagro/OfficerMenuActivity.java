package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OfficerMenuActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_menu);
        findViewById(R.id.imgbtnSearchFarmer).setOnClickListener(this);
       //findViewById(R.id.imgbtnFarmerResult).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtnSearchFarmer:
                Intent intent1 = new Intent(this, FieldResultViewActivity.class);

                startActivity(intent1);
                break;
            /*case R.id.imgbtnSearchFarmer:

                Intent intent = new Intent(this, MapsActivity.class);

                startActivity(intent);
                break;*/
        }

    }
}
