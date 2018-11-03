package com.yangzxcc.macintoshhd.api;

import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.Information;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.models.AccessToken;
import com.yangzxcc.macintoshhd.models.SignIn;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    //  Request Login ----------------------------------------
    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @POST("login")
    Call<AccessToken> signIn(@Body SignIn signIn);

    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @POST("login")
    Call<ResponseBody> postLogin(@Body SignIn requestBody);
    //  Request Login ----------------------------------------


    //  Request Information ----------------------------------------
    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @GET("info")
    Call<Information> getInfo(@Header("Authorization") String authHeader);
    //  Request Information ----------------------------------------


    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @GET("info")
    Call<List<HealthInformation>> getHealthInfo(@Header("Authorization") String authHeader);


    //  Request HealthRecord ----------------------------------------
    @GET("info")
    Call<HealthRecord> getHealthRecord(@Header("Authorization") String authHeader);
    //  Request HealthRecord ----------------------------------------

    @GET("info")
    Call<PhysicalInformation> getPhysical(@Header("Authorization") String authHeader);

    //  Request HealthRecord ----------------------------------------

//    @GET("info")
//    Call<ResponseBody> getInfo(@Header("Authorization") String authHeader);


//
//    @GET("posts")
//    Call<List<HealthRecordTest>> getPosts();

//    @FormUrlEncoded
//    @POST("user.php")
//    Call<Patient> performPatientLogin(@Query("username") String username,@Query("password") String password); //The query must match with php

    @GET("/bins/bubxw?fbclid=IwAR1k78p0NTabbomB9KdqNJz0vLWS-l-c11fb0RwfSYHvEc13ighhbbRLwZs")
    Call<Information> getMockUpInfo();

    @GET("/bins/1f6ef6")
    Call<Information> getMock();



}
