package com.example.smartagro;


import com.google.gson.annotations.SerializedName;

public class Division {

    @SerializedName("divisionCode")
    private int divisionCode;

    public Division(int divisionCode, String divisionName) {
        this.divisionCode = divisionCode;
        this.divisionName = divisionName;
    }

    public int getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(int divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @SerializedName("divisionName")
    private String divisionName;

}
