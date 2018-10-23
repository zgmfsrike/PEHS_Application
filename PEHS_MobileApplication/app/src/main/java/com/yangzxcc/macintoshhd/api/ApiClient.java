package com.yangzxcc.macintoshhd.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yangzxcc.macintoshhd.TokenManager;
import com.yangzxcc.macintoshhd.models.AccessToken;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    public static final String BASE_URL = "http://127.0.0.1:8000/api/auth/";
    public static final String BASE_URL = "http://10.0.2.2:8000/api/auth/";
    public static final String BASE__MOCK_URL = "https://api.myjson.com";
//    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit = null;
    public static Gson gson = null;




    public static Retrofit getRetrofit(){

        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setLenient()
                .create();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getMockUpRetrofit(){
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setLenient()
                .create();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE__MOCK_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}