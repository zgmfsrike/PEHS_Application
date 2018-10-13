package com.yangzxcc.macintoshhd.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    public static final String BASE_URL = "http://127.0.0.1:8000/api/auth/";
    public static final String BASE_URL = "http://10.0.2.2:8000/api/auth/";
//    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}