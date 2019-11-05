package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class ViewResultActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);
        LoadResult _LoadResult=new  LoadResult();
        _LoadResult.execute();
        listView=findViewById(R.id.ListView);
    }

    public void showResult(ArrayList<SoilResult> _SoilResult)
    {
        /*ArrayAdapter<SoilResult> spinnerArrayAdapter = new ArrayAdapter<SoilResult>
                (this, android.R.layout.simple_spinner_item,_SoilResult);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        listView.setAdapter(spinnerArrayAdapter);*/

        ArrayAdapter adapter = new ArrayAdapter<SoilResult>(this,
                android.R.layout.simple_expandable_list_item_1, _SoilResult);

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }
    public class LoadResult extends AsyncTask<Void,Void,ArrayList<SoilResult>>
    {

        @Override
        protected void onPostExecute(ArrayList<SoilResult> soilResults) {

            ViewResultActivity.this.showResult(soilResults);
        }

        @Override
        protected ArrayList<SoilResult> doInBackground(Void... voids) {
            Integer result;
            JSONObject jObject;
            JSONArray jsonArray = null;
            int i = 0;
            String str = "http://202.126.122.85:71/api/SoilTestResult2" ;//"http://202.126.122.85:71/api/Division";
            String response = "";
            ArrayList<SoilResult> SoilResultArrayList = new ArrayList();
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
                        SoilResult _SoilResult= new SoilResult ();
                        _SoilResult.setCalcium(object2.getString("calcium"));
                        _SoilResult.setCarbon(object2.getString("carbon"));
                        _SoilResult.setIs_viewed(object2.getInt("is_viewed"));
                        _SoilResult.setMagnesum(object2.getString("magnesium"));
                        _SoilResult.setMobile_no(object2.getString("mobile_no"));
                        _SoilResult.setNitrogen(object2.getString("nitrogen"));
                        _SoilResult.setPh(object2.getString("ph"));
                        _SoilResult.setPhosphorus(object2.getString("phosphorus"));
                        _SoilResult.setSulphur(object2.getString("sulphur"));
                        SoilResultArrayList.add(_SoilResult);
                        //id":26,"mobile_no":"01713332618","ph":"5","calcium":"1","carbon":"5","magnesium":"1","nitrogen":"1","phosphorus":"1","sulphur":"1","is_viewed":0
                    }
                } catch (JSONException e322) {
                    response = e322.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return SoilResultArrayList ;
        }
    }
}
