package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.SerializedName;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.PersonalInformation;

import java.util.List;

public class Information {
    @SerializedName("personal_information")
    private List<PersonalInformation> personalInformation;
    @SerializedName("health_information")
    private List<HealthInformation> healthInformation;

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
