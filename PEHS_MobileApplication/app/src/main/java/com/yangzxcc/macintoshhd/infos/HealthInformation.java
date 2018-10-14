package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HealthInformation {
    private List<HealthRecordInformation> healthRecordInformations;

    public List<HealthRecordInformation> getHealthRecordInformations() {
        return healthRecordInformations;
    }

    public void setHealthRecordInformations(List<HealthRecordInformation> healthRecordInformations) {
        this.healthRecordInformations = healthRecordInformations;
    }
}
