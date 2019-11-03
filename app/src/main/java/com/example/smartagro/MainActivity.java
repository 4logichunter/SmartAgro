package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_MESSAGE = "0";
private ImageButton btnFarmer;
private  int userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // btnFarmer=findViewById(R.id.btnFarmer);
        findViewById(R.id.btnFarmer).setOnClickListener(this);

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
          //  case R.id.textView9:
          //      break;
        }
    }
}
