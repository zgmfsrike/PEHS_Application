package com.yangzxcc.macintoshhd;

import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.models.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts")
    Call<HealthRecord> getPosts();

    @FormUrlEncoded
    @POST("user.php")
    Call<Patient> performPatientLogin(@Query("username") String username,@Query("password") String password); //The query must match with php

}
