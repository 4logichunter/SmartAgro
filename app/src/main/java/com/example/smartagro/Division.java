package com.example.smartagro;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Division {
    @SerializedName("divisionCode")
    @Expose
    private int divisionCode;

    public void setDivisionCode(int divisionCode) {
        this.divisionCode = divisionCode;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @SerializedName("divisionName")
    @Expose
    private String divisionName;

    public int getDivisionCode() {
        return divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }
}


