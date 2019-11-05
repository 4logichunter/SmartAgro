package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmerActivity extends AppCompatActivity   {

    private  ImageButton btnImage;
    private  ImageButton imagebtnSync;
    private  ImageButton imageButtonResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);*/
         btnImage=findViewById(R.id.imageButtonPushData );
         imageButtonResult=findViewById(R.id.imageButtonResult);
         imagebtnSync=findViewById(R.id.imagebtnSync);

        imagebtnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerActivity.this, GetDataActivity.class);
                startActivity(intent);
            }
        });

            btnImage.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                    PushToDB("dfs");
            }
            });
        imageButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FarmerActivity.this, ViewResultActivity.class);
                startActivity(intent);
            }
        });

    }




    public void PushToDB(String result)
    {
        PushData();
    }

    private void PushData()
      {
        String email = "";
        String password = "";
        String name = "test";
          String sDate1="31/12/1998";
          Date date1=null;
          try {
               date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
          } catch (ParseException e) {
              e.printStackTrace();
          }

          Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .createSoilTestResult("01713332618","5","5","1","1","1","1","1",0);

            //    .createSoilTestResult("1","2",new Date("01/01/2019"),"0","1","018325","1","5","1","1",new Date("01/01/2019"));


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    String s=response.body().toString();



                   Toast.makeText(FarmerActivity.this, s, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(FarmerActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
        //int str=s.indexOf(0);


    }

}
