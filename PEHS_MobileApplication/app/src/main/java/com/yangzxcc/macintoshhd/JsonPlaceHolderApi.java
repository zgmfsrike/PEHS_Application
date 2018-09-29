package com.yangzxcc.macintoshhd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<HealthRecord> getPosts();
}
