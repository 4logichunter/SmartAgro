package com.example.smartagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import android.widget.Toast;

import java.io.IOException;


import retrofit2.Response;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextmobileNo, editTextpassword, editTextname, editTextuserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextmobileNo = findViewById(R.id.editTextMobile);
        editTextpassword = findViewById(R.id.editTextPassword);
        editTextname = findViewById(R.id.editTextName);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.textView9).setOnClickListener(this);


    }

    private void userSignUp() {
        String email = editTextmobileNo.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String name = "test";
        int userType = 1;

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, password, name, userType);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Toast.makeText(LoginActivity.this, s, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnLogin:
                    userSignUp();
                    break;
                case R.id.textView9:
                    break;
            }

    }
}