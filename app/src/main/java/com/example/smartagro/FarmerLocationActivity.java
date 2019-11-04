package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;


import java.util.ArrayList;
import java.util.List;


import retrofit2.Response;


public class FarmerLocationActivity extends AppCompatActivity {
    private static  List<Division> posts;
    Button btnGetDivisionList;
    private Spinner spinner;


    //Api userService;
    List<Division> listDivision = new ArrayList<Division>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_location);
        spinner = findViewById(R.id.spinnerDivison);


        btnGetDivisionList = findViewById(R.id.btnGetDivison);

       // getUsersList();

       /* Spinner s = (Spinner) findViewById(R.id.spinnerDivison);
        ArrayAdapter<Division> adapter = new ArrayAdapter<Division>(this,
                android.R.layout.simple_spinner_item, posts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);*/


        btnGetDivisionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Division> listDivision1=     getUsersList();


String m="sdf";

          //      Spinner s = (Spinner) findViewById(R.id.spinnerDivison);
                /*ArrayAdapter<Division> adapter = new ArrayAdapter<Division>(this,
                        android.R.layout.simple_spinner_item, listDivision);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s.setAdapter(adapter);*/

            }
        });

    }

    public  List<Division> getUsersList() {
        Call<List<Division>> call = RetrofitClient
                .getInstance()
                .getApi().getDivision();
        // Call<List<Division>> call = userService.getDivision();
        call.enqueue(new Callback<List<Division>>() {
            @Override
            public void onResponse(Call<List<Division>> call, Response<List<Division>> response) {

                if (response.isSuccessful()) {
                    listDivision = response.body();



                }
            }


            @Override
            public void onFailure(Call<List<Division>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        return listDivision;
    }



}
