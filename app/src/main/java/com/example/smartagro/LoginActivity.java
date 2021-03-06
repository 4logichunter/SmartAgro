package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


import retrofit2.Response;




public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextmobileNo, editTextpassword, editTextname, editTextuserType;
    String userType="1";
    @Expose
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        userType = intent.getStringExtra("EXTRA_MESSAGE");


        editTextmobileNo = findViewById(R.id.editTextMobile);
        editTextpassword = findViewById(R.id.editTextPassword);
        editTextname = findViewById(R.id.editTextName);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.txtviewRegister).setOnClickListener(this);


    }

    private void userSignUp() {
        String email = editTextmobileNo.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String name = "test";


        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, password, name, 1);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    s = response.body().string();

                    if (s.contains("0"))  {
                        Toast.makeText(LoginActivity.this, "User Name or Password Invalid", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent=new Intent(LoginActivity.this,FarmerActivity.class);
                        startActivity((intent));
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
        //int str=s.indexOf(0);


    }

    @Override
    public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnLogin:
                    userSignUp();
                    break;
                case R.id.txtviewRegister:

                    Intent intent = new Intent(this, RegisterActivity.class);
                    intent.putExtra("EXTRA_MESSAGE", userType);
                    startActivity(intent);
                    break;
            }

    }
}