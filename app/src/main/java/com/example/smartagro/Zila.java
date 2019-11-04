package com.example.smartagro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Zila {
    @SerializedName("divisionCode")
    @Expose
    public int zilaCode ;
    @SerializedName("divisionCode")
    @Expose
    public  String zilaName;

    public int getZilaCode() {
        return zilaCode;
    }

    public void setZilaCode(int zilaCode) {
        this.zilaCode = zilaCode;
    }

    public String getZilaName() {
        return zilaName;
    }

    public void setZilaName(String zilaName) {
        this.zilaName = zilaName;
    }


}
