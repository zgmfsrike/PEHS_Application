package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HealthInformation implements Serializable {

    @SerializedName("health_record")
    private List<HealthRecord> healthRecords = null;

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }
}
