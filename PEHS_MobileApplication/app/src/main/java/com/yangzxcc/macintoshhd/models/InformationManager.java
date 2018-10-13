package com.yangzxcc.macintoshhd.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InformationManager {
    @SerializedName("personal_information")
    private List<PersonalInformation> personalInformation = null;
    @SerializedName("health_information")
    private List<HealthInformation> healthInformation = null;

    public List<PersonalInformation> getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(List<PersonalInformation> personalInformation) {
        this.personalInformation = personalInformation;
    }

    public List<HealthInformation> getHealthInformation() {
        return healthInformation;
    }

    public void setHealthInformation(List<HealthInformation> healthInformation) {
        this.healthInformation = healthInformation;
    }
}
