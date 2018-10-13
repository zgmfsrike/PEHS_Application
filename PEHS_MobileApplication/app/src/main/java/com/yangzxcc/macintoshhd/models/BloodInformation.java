package com.yangzxcc.macintoshhd.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloodInformation {
    @SerializedName("blood_ex_name")
    @Expose
    private String bloodExName;
    @SerializedName("blood_ex_value")
    @Expose
    private String bloodExValue;

    public String getBloodExName() {
        return bloodExName;
    }

    public void setBloodExName(String bloodExName) {
        this.bloodExName = bloodExName;
    }

    public String getBloodExValue() {
        return bloodExValue;
    }

    public void setBloodExValue(String bloodExValue) {
        this.bloodExValue = bloodExValue;
    }
}
