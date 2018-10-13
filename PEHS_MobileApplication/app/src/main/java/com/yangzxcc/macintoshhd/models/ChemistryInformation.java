package com.yangzxcc.macintoshhd.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChemistryInformation {
    @SerializedName("clinical_chemistry_name")
    @Expose
    private String clinicalChemistryName;
    @SerializedName("clinical_chemistry_value")
    @Expose
    private String clinicalChemistryValue;

    public String getClinicalChemistryName() {
        return clinicalChemistryName;
    }

    public void setClinicalChemistryName(String clinicalChemistryName) {
        this.clinicalChemistryName = clinicalChemistryName;
    }

    public String getClinicalChemistryValue() {
        return clinicalChemistryValue;
    }

    public void setClinicalChemistryValue(String clinicalChemistryValue) {
        this.clinicalChemistryValue = clinicalChemistryValue;
    }
}
