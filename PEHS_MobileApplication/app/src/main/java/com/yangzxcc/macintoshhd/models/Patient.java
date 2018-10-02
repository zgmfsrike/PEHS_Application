package com.yangzxcc.macintoshhd.models;

import com.google.gson.annotations.SerializedName;

public class Patient {
    @SerializedName("response")
    private String Response;

    @SerializedName("name")
    private String Name;

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return Name;
    }
}
