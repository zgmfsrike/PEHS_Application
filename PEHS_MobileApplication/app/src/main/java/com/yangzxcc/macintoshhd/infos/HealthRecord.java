package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HealthRecord implements Serializable {

    @SerializedName("physical_information")
    @Expose
    private List<PhysicalInformation> physicalInformation;

    @SerializedName("blood_information")
    @Expose
    private List<BloodInformation> bloodInformation;

    @SerializedName("urine_information")
    @Expose
    private List<UrineInformation> urineInformation;

    @SerializedName("chemistry_information")
    @Expose
    private List<ChemistryInformation> chemistryInformation;

    @SerializedName("date")
    private String date;

    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
