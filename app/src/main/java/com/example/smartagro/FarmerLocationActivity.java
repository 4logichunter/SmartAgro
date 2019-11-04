package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;

import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;


import java.util.ArrayList;
import java.util.List;


import retrofit2.Response;


public class FarmerLocationActivity extends AppCompatActivity {
    private List<Division> posts;
    Button btnGetDivisionList;
    private Spinner spinner;


    //Api userService;
    List<Division> list = new ArrayList<Division>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_location);
        spinner = findViewById(R.id.spinnerDivison);


        btnGetDivisionList = findViewById(R.id.btnGetDivison);


        btnGetDivisionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDivisonList();
            }
        });

    }

    public void getDivisonList() {
        Call<List<Division>> call = RetrofitClient
                .getInstance()
                .getApi().getDivision();



        call.enqueue(new Callback<List<Division>>() {
            @Override
            public void onResponse(Call<List<Division>> call, Response<List<Division>> response) {

               // Toast.makeText(getApplication().getApplicationContext(),"sdfsdf",Toast.LENGTH_LONG);

boolean mo=response.isSuccessful();
                String asd="sfdsf";

                if (response.isSuccessful()) {
                    list = response.body();


                }
            }


            @Override
            public void onFailure(Call<List<Division>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }



}
