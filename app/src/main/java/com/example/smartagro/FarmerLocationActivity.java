package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

    Button btnGetDivisionList;
    Button btnRegister;
    List<Zila> listZila = new ArrayList<Zila>();
    List<Paurasava> listPaurasava = new ArrayList<Paurasava>();
    List<Union> listUnion = new ArrayList<Union>();
    List<Upazila> listUpazila = new ArrayList<Upazila>();




    //Api userService;
    List<Division> listDivision = new ArrayList<Division>();
    private Spinner spinnerZila ;
    private Spinner spinnerPaurasava ;
    private Spinner spinnerUnion ;
    private Spinner spinnerUpazila;
    private Spinner spinnerDivison;

    private TextView txtView;
    private String userType;
    private String userName;
    private String userMobile;
    private String userAddress;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_location);


        Bundle extras = getIntent().getExtras();
        // Extract the array from the Bundle object
        String[] myArr= extras.getStringArray("EXTRA_MESSAGE");
        // Output the array
        if (myArr.length>0)
        {
            userType = myArr[0].toString();
            userName = myArr[1].toString();
            userMobile = myArr[4].toString();
            userAddress=myArr[3].toString();
        userPassword= myArr[2].toString();
        }



        spinnerDivison = findViewById(R.id.spinnerDivison);
        spinnerZila=findViewById(R.id.spinnerZila);
        spinnerPaurasava=findViewById(R.id.spinnerpaurasava);
        spinnerUnion=findViewById(R.id.spinnerUnion);
        spinnerUpazila=findViewById(R.id.spinnerUpaZila);

        btnGetDivisionList = findViewById(R.id.btnGetDivison);
        txtView=findViewById(R.id.textViewNext2);
        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Division division= (Division) spinnerDivison.getSelectedItem();
                Upazila upazila= (Upazila) spinnerUpazila.getSelectedItem();
                Zila zila= (Zila) spinnerZila.getSelectedItem();
                Union union= (Union) spinnerUnion.getSelectedItem();
                Paurasava paurasava= (Paurasava ) spinnerPaurasava.getSelectedItem();
                int strDivision= division.getDivisionCode();
                int strUpazila= upazila.getUpazilaCode();
                int strZila= zila.getZilaCode();
                int strUnion= union.getUnionCode();
                int strPaurasava= paurasava.getPaurasavaCode();



            }
        });

        LoadDivision loadDivision=new LoadDivision();
        loadDivision.execute();

        LoadZila loadZila=new LoadZila();
        loadZila.execute();

        LoadPaurasava loadPaurasava=new LoadPaurasava();
        loadPaurasava.execute();

        LoadUnion loadUnion=new LoadUnion();
        loadUnion.execute();

        LoadUpazila loadUpazila=new LoadUpazila();
        loadUpazila.execute();



    }
    ///////////////////////////////////////////////////////////////////////
    /*-----------------------------Show Division(Start)----------------------*/
    public void ShowDivision(ArrayList<Division> s)
    {
        ArrayAdapter<Division> spinnerArrayAdapter = new ArrayAdapter<Division>
                (this, android.R.layout.simple_spinner_item,
                        s); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinnerDivison.setAdapter(spinnerArrayAdapter);


    }

    /*-----------------------------Show Division(End)----------------------*/
    ///////////////////////////////////////////////////////////////////////
    /*-----------------------------Show Zila(Start)----------------------*/
    public void ShowZila(ArrayList<Zila> s)
    {
        ArrayAdapter<Zila> spinnerArrayAdapter = new ArrayAdapter<Zila>
                (this, android.R.layout.simple_spinner_item,
                        s); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinnerZila.setAdapter(spinnerArrayAdapter);
    }

    public void ShowPaurasava(ArrayList<Paurasava> s)
    {
        ArrayAdapter<Paurasava> spinnerArrayAdapter = new ArrayAdapter<Paurasava>
                (this, android.R.layout.simple_spinner_item,s);
                  spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                  .simple_spinner_dropdown_item);
        spinnerPaurasava.setAdapter(spinnerArrayAdapter);
    }

    public void ShowUnion(ArrayList<Union> s)
    {
        ArrayAdapter<Union> spinnerArrayAdapter = new ArrayAdapter<Union>
                (this, android.R.layout.simple_spinner_item,s);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinnerUnion.setAdapter(spinnerArrayAdapter);
    }
    /*-----------------------------Show Zila(End)----------------------*/
    ///////////////////////////////////////////////////////////////////////
    /*-----------------------------Show Paurasava(Start)----------------------*/

    public void ShowUpazila(ArrayList<Upazila> s)
    {
        ArrayAdapter<Upazila> spinnerArrayAdapter = new ArrayAdapter<Upazila>
                (this, android.R.layout.simple_spinner_item,s);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinnerUpazila.setAdapter(spinnerArrayAdapter);
    }

    public class LoadDivision extends AsyncTask<Void,Void,ArrayList<Division>>
    {
        @Override
        protected void onPostExecute(ArrayList<Division> divisionArrayList) {
            super.onPostExecute(divisionArrayList);
            FarmerLocationActivity.this.ShowDivision(divisionArrayList);
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
    /*-----------------------------Show Paurasava(End)----------------------*/
    ///////////////////////////////////////////////////////////////////////
    /*-----------------------------Show Union(Start)----------------------*/

    public class LoadZila extends AsyncTask<Void,Void,ArrayList<Zila>>
    {
        @Override
        protected void onPostExecute(ArrayList<Zila> zilaArrayList ) {
            super.onPostExecute(zilaArrayList);
            FarmerLocationActivity.this.ShowZila(zilaArrayList);
        }

        @Override
        protected ArrayList<Zila> doInBackground(Void... voids) {
            Integer result;
            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;
            String str = "http://202.126.122.85:71/api/zila" ;//"http://202.126.122.85:71/api/Division";
            String response = "";
            ArrayList<Zila> zilaArrayList = new ArrayList();
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
                        Zila zila= new Zila ();
                        zila.setZilaCode(object2.getInt("zilaCode"));
                        zila.setZilaName(object2.getString("zilaName"));
                        zilaArrayList.add(zila);
                    }
                } catch (JSONException e322) {
                    response = e322.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return zilaArrayList ;
        }
    }

    public class LoadPaurasava extends AsyncTask<Void,Void,ArrayList<Paurasava>>
    {
        @Override
        protected void onPostExecute(ArrayList<Paurasava> PaurasavaArrayList ) {
            super.onPostExecute(PaurasavaArrayList);
            FarmerLocationActivity.this.ShowPaurasava(PaurasavaArrayList);
        }

        @Override
        protected ArrayList<Paurasava> doInBackground(Void... voids) {
            Integer result;
            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;
            String str = "http://202.126.122.85:71/api/Paurasava" ;//"http://202.126.122.85:71/api/Division";
            String response = "";
            ArrayList<Paurasava> PaurasavaArrayList = new ArrayList();
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
                        Paurasava paurasava= new Paurasava ();
                        paurasava.setPaurasavaCode(object2.getInt("PaurasavaCode"));
                        paurasava.setPaurasavaName(object2.getString("PaurasavaName"));
                        PaurasavaArrayList.add(paurasava);
                    }
                } catch (JSONException e322) {
                    response = e322.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return PaurasavaArrayList ;
        }
    }
    /*-----------------------------Show Union(End)----------------------*/
    ///////////////////////////////////////////////////////////////////////
    /*-----------------------------Show Upazila(Start)----------------------*/

    public class LoadUnion extends AsyncTask<Void,Void,ArrayList<Union>>
    {
        @Override
        protected void onPostExecute(ArrayList<Union> UnionArrayList ) {
            super.onPostExecute(UnionArrayList);
            FarmerLocationActivity.this.ShowUnion(UnionArrayList);
        }

        @Override
        protected ArrayList<Union> doInBackground(Void... voids) {
            Integer result;
            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;
            String str = "http://202.126.122.85:71/api/Union" ;//"http://202.126.122.85:71/api/Division";
            String response = "";
            ArrayList<Union> UnionArrayList = new ArrayList();
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
                        Union Union= new Union ();
                        Union.setUnionCode(object2.getInt("UnionCode"));
                        Union.setUnionName(object2.getString("UnionName"));
                        UnionArrayList.add(Union);
                    }
                } catch (JSONException e322) {
                    response = e322.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return UnionArrayList ;
        }
    }

    public class LoadUpazila extends AsyncTask<Void,Void,ArrayList<Upazila>>
    {
        @Override
        protected void onPostExecute(ArrayList<Upazila> UpazilaArrayList ) {
            super.onPostExecute(UpazilaArrayList);
            FarmerLocationActivity.this.ShowUpazila(UpazilaArrayList);
        }

        @Override
        protected ArrayList<Upazila> doInBackground(Void... voids) {
            Integer result;
            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;
            String str = "http://202.126.122.85:71/api/Upazila" ;//"http://202.126.122.85:71/api/Division";
            String response = "";
            ArrayList<Upazila> UpazilaArrayList = new ArrayList();
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
                        Upazila Upazila= new Upazila ();
                        Upazila.setUpazilaCode(object2.getInt("UpazilaCode"));
                        Upazila.setUpazilaName(object2.getString("UpazilaName"));
                        UpazilaArrayList.add(Upazila);
                    }
                } catch (JSONException e322) {
                    response = e322.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return UpazilaArrayList ;
        }
    }
    /*-----------------------------Show Upazila(End)----------------------*/
    ///////////////////////////////////////////////////////////////////////


/*Data parsing method*/

    public class SendData extends AsyncTask<String[] ,Void ,Void>
    {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(String[]... strings) {
            String userType=strings[0].toString();
            String userMobile=strings[1].toString();
            String userName=strings[2].toString();
            String userAddress=strings[3].toString();
            String userPassword=strings[4].toString();
            String userUpozila=strings[5].toString();
            String userZila=strings[6].toString();
            String userDivision=strings[7].toString();
            String userPaurashova=  strings[8].toString();
            String userUnion=  strings[9].toString();


            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;

            String str = "http://202.126.122.85:71/api/FarmerRegestration" ;//"http://202.126.122.85:71/api/Division";
            String response = "";

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

            return null;
        }
    }

}

