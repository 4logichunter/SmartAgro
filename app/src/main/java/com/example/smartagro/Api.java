package com.example.smartagro;


import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

        @FormUrlEncoded
        @POST("RegisterUser")
        Call<ResponseBody> createRegisterUser(
                @Field("mobileNo") String mobileNo,
                @Field("password") String password,
                @Field("name") String name,
                @Field("userType") int userType,

                @Field("address") String address,
                @Field("division_code") int division_code,
                @Field("zila_code") int zila_code,
                @Field("upazila_code") int upazila_code,
                @Field("paurasava_code") int paurasava_code,
                @Field("union_code") int union_code

        );
        @FormUrlEncoded
        @POST("SoilTestResult")
        Call<ResponseBody> createSoilTestResult(
                @Field("mobile_no") String mobile_no,
                @Field("ph") String ph,
                @Field("carbon") String carbon,
                @Field("magnesium") String magnesium,
                @Field("calcium") String calcium,
                @Field("sulphur") String sulphur,
                @Field("phosphorus") String phosphorus,
                @Field("nitrogen") String nitrogen,
                @Field("is_viewed") int is_viewed





        );

        /*@FormUrlEncoded
        @GET("Division")
        Call<List<Division>> getDivision();*/

        @GET("Division")
        Call<List<Division>> getDivision();


        /*@PUT("update/{id}")
        Call<User> updateUser(@Path("id") int id, @Body User user);

        @DELETE("delete/{id}")
        Call<User> deleteUser(@Path("id") int id);*/

    }
