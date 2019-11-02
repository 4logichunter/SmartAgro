package com.example.smartagro;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

    public interface Api {


        @FormUrlEncoded
        @POST("User")
        Call<ResponseBody> createUser(
                @Field("mobileNo") String mobileNo,
                @Field("password") String password,
                @Field("name") String name,
                @Field("userType") int userType
        );

    }
