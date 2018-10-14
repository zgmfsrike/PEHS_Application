package com.yangzxcc.macintoshhd.models;

import com.squareup.moshi.Json;

public class SignIn {
//    @Json(name = "username")
    private String username;
//    @Json(name = "password")
    private String password;

    public SignIn(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
