package com.yangzxcc.macintoshhd.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    private String token;
    private String tokenType;
    private Date expiredDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
