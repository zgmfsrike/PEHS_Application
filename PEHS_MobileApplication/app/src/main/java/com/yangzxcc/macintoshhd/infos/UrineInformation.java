package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UrineInformation implements Serializable {
    @SerializedName("urine_ex_name")
    @Expose
    private String urineExName;
    @SerializedName("urine_ex_value")
    @Expose
    private String urineExValue;

    public String getUrineExName() {
        return urineExName;
    }

    public void setUrineExName(String urineExName) {
        this.urineExName = urineExName;
    }

    public String getUrineExValue(int i) {
        return urineExValue;
    }

    public void setUrineExValue(String urineExValue) {
        this.urineExValue = urineExValue;
    }
}
