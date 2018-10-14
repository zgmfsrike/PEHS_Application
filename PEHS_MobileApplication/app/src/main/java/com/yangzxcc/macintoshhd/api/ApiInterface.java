package com.yangzxcc.macintoshhd.api;

import com.yangzxcc.macintoshhd.activities.Login;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.models.Patient;
import com.yangzxcc.macintoshhd.models.SignIn;
import com.yangzxcc.macintoshhd.models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest"
    })
    @POST("login")
    Call<User> signIn(@Body String signIn);

    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest"
    })
    @GET("info")
    Call<InformationManager> getInfo(@Header("Authorization") String authHeader);




//    @GET("info")
//    Call<ResponseBody> getInfo(@Header("Authorization") String authHeader);




    @GET("login")
    Call<User> getUser(@Header("Authorization") String authHeader);

    @GET("posts")
    Call<List<HealthRecord>> getPosts();

    @FormUrlEncoded
    @POST("user.php")
    Call<Patient> performPatientLogin(@Query("username") String username,@Query("password") String password); //The query must match with php

}
