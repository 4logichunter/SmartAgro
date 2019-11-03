package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

private ImageButton btnFarmer;
private  int userType;
    public static final String EXTRA_MESSAGE = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFarmer=findViewById(R.id.btnFarmer);

    }

    @Override
    public void onClick(View v) {
        String a="mofiz";
        switch (v.getId()) {
            case R.id.btnFarmer:
                userType=1;
                Intent intent = new Intent(this, FarmerActivity.class);

                intent.putExtra(EXTRA_MESSAGE, userType);
                startActivity(intent);


                break;
          //  case R.id.textView9:
          //      break;
        }
    }
}
