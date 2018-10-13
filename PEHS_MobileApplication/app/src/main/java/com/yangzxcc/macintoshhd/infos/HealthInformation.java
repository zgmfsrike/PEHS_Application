package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HealthInformation {
    @SerializedName("physical_information")
    @Expose
    private List<PhysicalInformation> physicalInformation = null;
    @SerializedName("blood_information")
    @Expose
    private List<BloodInformation> bloodInformation = null;
    @SerializedName("urine_information")
    @Expose
    private List<UrineInformation> urineInformation = null;
    @SerializedName("chemistry_information")
    @Expose
    private List<ChemistryInformation> chemistryInformation = null;

    public List<PhysicalInformation> getPhysicalInformation() {
        return physicalInformation;
    }

    public void setPhysicalInformation(List<PhysicalInformation> physicalInformation) {
        this.physicalInformation = physicalInformation;
    }

    public List<BloodInformation> getBloodInformation() {
        return bloodInformation;
    }

    public void setBloodInformation(List<BloodInformation> bloodInformation) {
        this.bloodInformation = bloodInformation;
    }

    public List<UrineInformation> getUrineInformation() {
        return urineInformation;
    }

    public void setUrineInformation(List<UrineInformation> urineInformation) {
        this.urineInformation = urineInformation;
    }

    public List<ChemistryInformation> getChemistryInformation() {
        return chemistryInformation;
    }

    public void setChemistryInformation(List<ChemistryInformation> chemistryInformation) {
        this.chemistryInformation = chemistryInformation;
    }
}
