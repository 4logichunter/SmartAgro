package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import retrofit2.Call;
import retrofit2.Callback;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Response;


public class FarmerLocationActivity extends AppCompatActivity {
    private static  List<Division> posts;
    Button btnGetDivisionList;
    private Spinner spinner;


    //Api userService;
    List<Division> listDivision = new ArrayList<Division>();
    List<Division> listDivision1 = new ArrayList<Division>();
    private TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_location);
        spinner = findViewById(R.id.spinnerDivison);


        btnGetDivisionList = findViewById(R.id.btnGetDivison);
        txtView=findViewById(R.id.textViewNext2);

        LoadDivision loadDivision=new LoadDivision();
        loadDivision.execute();


    }
    public void ShowMyText(ArrayList<Division> s)
    {
        ArrayAdapter<Division> spinnerArrayAdapter = new ArrayAdapter<Division>
                (this, android.R.layout.simple_spinner_item,
                        s); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
public class LoadDivision extends AsyncTask<Void,Void,ArrayList<Division>>
{
    @Override
    protected void onPostExecute(ArrayList<Division> divisionArrayList) {
        super.onPostExecute(divisionArrayList);
       FarmerLocationActivity.this.ShowMyText(divisionArrayList);
    }

    @Override
    protected ArrayList<Division> doInBackground(Void... voids) {
        Integer result;
        JSONObject jObject;
        JSONArray jsonArray = null;
        int i = 0;
        String str = "http://202.126.122.85:71/api/Division" ;//"http://202.126.122.85:71/api/Division";
        String response = "";
        ArrayList<Division> divisionArrayList = new ArrayList();
        URL url = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            response = e.getMessage();
        } catch (Exception ex) {
            response = ex.getMessage();
        }
        HttpURLConnection conn = null;

        JSONObject jsonObject;
        JSONStringer userJson = null;
        OutputStreamWriter outputStreamWriter = null;
        int responseCode;
        BufferedReader br;
        String line;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
            //starting
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        try {
            responseCode = conn.getResponseCode();
              br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while (true) {
                line = br.readLine();
                if (line != null) {
                    response = response + line;
                }
                else
                {
                    break;
                }

            }
            jObject = null;
            if (!response.isEmpty()) {
                try {
                     jsonArray = new JSONArray(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            try {

                for (i = 0; i < jsonArray.length(); i++) {
                    JSONObject object2 = jsonArray.getJSONObject(i);
                    Division division= new Division ();
                    division.setDivisionCode(object2.getInt("divisionCode"));
                    division.setDivisionName(object2.getString("divisionName"));
                    divisionArrayList.add(division);
                }
            } catch (JSONException e322) {
                response = e322.getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
String m="sdf";

        return divisionArrayList;
    }
}


}

