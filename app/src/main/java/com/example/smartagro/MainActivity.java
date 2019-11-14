package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_MESSAGE = "0";
private ImageButton btnFarmer;
private  int userType;
private  ImageButton btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // btnFarmer=findViewById(R.id.btnFarmer);
        findViewById(R.id.btnFarmer).setOnClickListener(this);
        findViewById(R.id.btnOfficer).setOnClickListener(this);
        findViewById(R.id.btnAboutUs).setOnClickListener(this);
        findViewById(R.id.btnLocation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String a="mofiz";
        switch (v.getId()) {
            case R.id.btnFarmer:
                userType=1;
                Intent intent = new Intent(this, LoginActivity.class);

                intent.putExtra(EXTRA_MESSAGE, userType);
                startActivity(intent);


            break;
            case R.id.btnOfficer:

                Intent  intent1= new Intent(this, RegisterOfficerActivity.class);


                startActivity(intent1);


                break;
            case R.id.btnAboutUs:

                Intent  intent2= new Intent(this, AboutActivity.class);


                startActivity(intent2);


                break; case R.id.btnLocation:

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Barisal Barguna Amtali");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }


                break;

        }
    }
}
