package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicalInformation {
    @SerializedName("physical_ex_name")
    @Expose
    private String physicalExName;
    @SerializedName("physical_ex_value")
    @Expose
    private String physicalExValue;

    public String getPhysicalExName() {
        return physicalExName;
    }

    public void setPhysicalExName(String physicalExName) {
        this.physicalExName = physicalExName;
    }

    public String getPhysicalExValue() {
        return physicalExValue;
    }

    public void setPhysicalExValue(String physicalExValue) {
        this.physicalExValue = physicalExValue;
    }
}
