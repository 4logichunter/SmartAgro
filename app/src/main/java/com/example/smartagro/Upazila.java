package com.example.smartagro;

import androidx.annotation.NonNull;

public class Upazila {

    public  int UpazilaCode;
    public  String UpazilaName;

    public int getUpazilaCode() {
        return UpazilaCode;
    }

    public void setUpazilaCode(int upazilaCode) {
        UpazilaCode = upazilaCode;
    }

    public String getUpazilaName() {
        return UpazilaName;
    }

    public void setUpazilaName(String upazilaName) {
        UpazilaName = upazilaName;
    }

    @NonNull
    @Override
    public String toString() {
        return UpazilaName;
    }
}
