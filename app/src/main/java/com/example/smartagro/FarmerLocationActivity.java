package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.SortedList;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FarmerLocationActivity extends AppCompatActivity {
    private Spinner spinnerDivision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_location);
        spinnerDivision = findViewById(R.id.spinnerDivison);
       fetchJSON();
    }
    private void fetchJSON(){


        Call<List<Division>> callDivision = RetrofitClient
                .getInstance()
                .getApi()
                .getDivision();

        callDivision.enqueue(new Callback<List<Division>>() {
            @Override
            public void onResponse(Call<List<Division>> call, Response<List<Division>> response) {

                if(response.isSuccessful()){
                    String a=response.toString();
                    Toast.makeText(FarmerLocationActivity.this, "User updated successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Division>> call, Throwable t) {

            }
        });



    }


}
