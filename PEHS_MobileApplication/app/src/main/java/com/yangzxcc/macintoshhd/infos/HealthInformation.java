package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HealthInformation {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("Weight")
    @Expose
    private String weight;
    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Wrist")
    @Expose
    private String wrist;
    @SerializedName("BMI")
    @Expose
    private String bMI;
    @SerializedName("Systolic")
    @Expose
    private String systolic;
    @SerializedName("Diastolic")
    @Expose
    private String diastolic;
    @SerializedName("Pulse")
    @Expose
    private String pulse;
    @SerializedName("Blood WBC")
    @Expose
    private String bloodWBC;
    @SerializedName("Blood RBC")
    @Expose
    private String bloodRBC;
    @SerializedName("HGB")
    @Expose
    private String hGB;
    @SerializedName("HCT")
    @Expose
    private String hCT;
    @SerializedName("MCV")
    @Expose
    private String mCV;
    @SerializedName("MCH")
    @Expose
    private String mCH;
    @SerializedName("MCHC")
    @Expose
    private String mCHC;
    @SerializedName("PLT count")
    @Expose
    private String pLTCount;
    @SerializedName("Neutrophil")
    @Expose
    private String neutrophil;
    @SerializedName("Lymphocyte")
    @Expose
    private String lymphocyte;
    @SerializedName("Monocyte")
    @Expose
    private String monocyte;
    @SerializedName("Eosinophil")
    @Expose
    private String eosinophil;
    @SerializedName("Basophil")
    @Expose
    private String basophil;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("Appearance")
    @Expose
    private String appearance;
    @SerializedName("Specific Gravity")
    @Expose
    private String specificGravity;
    @SerializedName("pH")
    @Expose
    private String pH;
    @SerializedName("Albumin")
    @Expose
    private String albumin;
    @SerializedName("Sugar")
    @Expose
    private String sugar;
    @SerializedName("Urine RBC")
    @Expose
    private String urineRBC;
    @SerializedName("Urine WBC")
    @Expose
    private String urineWBC;
    @SerializedName("Epithelial Cell")
    @Expose
    private String epithelialCell;
    @SerializedName("Glucose")
    @Expose
    private String glucose;
    @SerializedName("BUN")
    @Expose
    private String bUN;
    @SerializedName("Creatine")
    @Expose
    private String creatine;
    @SerializedName("Uric acid")
    @Expose
    private String uricAcid;
    @SerializedName("Cholesterol")
    @Expose
    private String cholesterol;
    @SerializedName("Triglyceride")
    @Expose
    private String triglyceride;
    @SerializedName("HDL-C")
    @Expose
    private String hDLC;
    @SerializedName("Calculated LDL")
    @Expose
    private String calculatedLDL;
    @SerializedName("AST/SGOT")
    @Expose
    private String aSTSGOT;
    @SerializedName("ALT/SGPT")
    @Expose
    private String aLTSGPT;
    @SerializedName("ALP")
    @Expose
    private String aLP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWrist() {
        return wrist;
    }

    public void setWrist(String wrist) {
        this.wrist = wrist;
    }

    public String getbMI() {
        return bMI;
    }

    public void setbMI(String bMI) {
        this.bMI = bMI;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBloodWBC() {
        return bloodWBC;
    }

    public void setBloodWBC(String bloodWBC) {
        this.bloodWBC = bloodWBC;
    }

    public String getBloodRBC() {
        return bloodRBC;
    }

    public void setBloodRBC(String bloodRBC) {
        this.bloodRBC = bloodRBC;
    }

    public String gethGB() {
        return hGB;
    }

    public void sethGB(String hGB) {
        this.hGB = hGB;
    }

    public String gethCT() {
        return hCT;
    }

    public void sethCT(String hCT) {
        this.hCT = hCT;
    }

    public String getmCV() {
        return mCV;
    }

    public void setmCV(String mCV) {
        this.mCV = mCV;
    }

    public String getmCH() {
        return mCH;
    }

    public void setmCH(String mCH) {
        this.mCH = mCH;
    }

    public String getmCHC() {
        return mCHC;
    }

    public void setmCHC(String mCHC) {
        this.mCHC = mCHC;
    }

    public String getpLTCount() {
        return pLTCount;
    }

    public void setpLTCount(String pLTCount) {
        this.pLTCount = pLTCount;
    }

    public String getNeutrophil() {
        return neutrophil;
    }

    public void setNeutrophil(String neutrophil) {
        this.neutrophil = neutrophil;
    }

    public String getLymphocyte() {
        return lymphocyte;
    }

    public void setLymphocyte(String lymphocyte) {
        this.lymphocyte = lymphocyte;
    }

    public String getMonocyte() {
        return monocyte;
    }

    public void setMonocyte(String monocyte) {
        this.monocyte = monocyte;
    }

    public String getEosinophil() {
        return eosinophil;
    }

    public void setEosinophil(String eosinophil) {
        this.eosinophil = eosinophil;
    }

    public String getBasophil() {
        return basophil;
    }

    public void setBasophil(String basophil) {
        this.basophil = basophil;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(String specificGravity) {
        this.specificGravity = specificGravity;
    }

    public String getpH() {
        return pH;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public String getAlbumin() {
        return albumin;
    }

    public void setAlbumin(String albumin) {
        this.albumin = albumin;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getUrineRBC() {
        return urineRBC;
    }

    public void setUrineRBC(String urineRBC) {
        this.urineRBC = urineRBC;
    }

    public String getUrineWBC() {
        return urineWBC;
    }

    public void setUrineWBC(String urineWBC) {
        this.urineWBC = urineWBC;
    }

    public String getEpithelialCell() {
        return epithelialCell;
    }

    public void setEpithelialCell(String epithelialCell) {
        this.epithelialCell = epithelialCell;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getbUN() {
        return bUN;
    }

    public void setbUN(String bUN) {
        this.bUN = bUN;
    }

    public String getCreatine() {
        return creatine;
    }

    public void setCreatine(String creatine) {
        this.creatine = creatine;
    }

    public String getUricAcid() {
        return uricAcid;
    }

    public void setUricAcid(String uricAcid) {
        this.uricAcid = uricAcid;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(String triglyceride) {
        this.triglyceride = triglyceride;
    }

    public String gethDLC() {
        return hDLC;
    }

    public void sethDLC(String hDLC) {
        this.hDLC = hDLC;
    }

    public String getCalculatedLDL() {
        return calculatedLDL;
    }

    public void setCalculatedLDL(String calculatedLDL) {
        this.calculatedLDL = calculatedLDL;
    }

    public String getaSTSGOT() {
        return aSTSGOT;
    }

    public void setaSTSGOT(String aSTSGOT) {
        this.aSTSGOT = aSTSGOT;
    }

    public String getaLTSGPT() {
        return aLTSGPT;
    }

    public void setaLTSGPT(String aLTSGPT) {
        this.aLTSGPT = aLTSGPT;
    }

    public String getaLP() {
        return aLP;
    }

    public void setaLP(String aLP) {
        this.aLP = aLP;
    }
}
