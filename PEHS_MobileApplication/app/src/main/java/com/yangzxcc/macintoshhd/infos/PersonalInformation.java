package com.yangzxcc.macintoshhd.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalInformation {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("telephone_number")
    @Expose
    private String telephoneNumber;
    @SerializedName("drug_allergy")
    @Expose
    private Object drugAllergy;
    @SerializedName("underlying_disease")
    @Expose
    private Object underlyingDisease;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public Object getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(Object drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public Object getUnderlyingDisease() {
        return underlyingDisease;
    }

    public void setUnderlyingDisease(Object underlyingDisease) {
        this.underlyingDisease = underlyingDisease;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
