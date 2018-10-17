package com.yangzxcc.macintoshhd.api;

import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.infos.InformationManager;
import com.yangzxcc.macintoshhd.infos.PhysicalInformation;
import com.yangzxcc.macintoshhd.models.AccessToken;
import com.yangzxcc.macintoshhd.models.HealthRecordTest;
import com.yangzxcc.macintoshhd.models.Patient;
import com.yangzxcc.macintoshhd.models.SignIn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    //  Request Login ----------------------------------------
    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @POST("login")
    Call<AccessToken> signIn(@Body SignIn signIn);
    //  Request Login ----------------------------------------


    //  Request Information ----------------------------------------
    @Headers({
            "Content-Type: application/json",
            "X-Requested-With:XMLHttpRequest",
            "Accept: application/json"
    })
    @GET("info")
    Call<InformationManager> getInfo(@Header("Authorization") String authHeader);
    //  Request Information ----------------------------------------


    //  Request HealthRecord ----------------------------------------
    @GET("info")
    Call<HealthRecord> getHealthRecord(@Header("Authorization") String authHeader);
    //  Request HealthRecord ----------------------------------------




//    @GET("info")
//    Call<ResponseBody> getInfo(@Header("Authorization") String authHeader);



    @GET("posts")
    Call<List<HealthRecordTest>> getPosts();

    @FormUrlEncoded
    @POST("user.php")
    Call<Patient> performPatientLogin(@Query("username") String username,@Query("password") String password); //The query must match with php

}
