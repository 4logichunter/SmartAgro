package com.example.smartagro;

import androidx.annotation.NonNull;

public class Paurasava {


    public  int  PaurasavaCode;
    public  String  PaurasavaName ;

    public int getPaurasavaCode() {
        return PaurasavaCode;
    }

    public void setPaurasavaCode(int paurasavaCode) {
        PaurasavaCode = paurasavaCode;
    }

    public String getPaurasavaName() {
        return PaurasavaName;
    }

    public void setPaurasavaName(String paurasavaName) {
        PaurasavaName = paurasavaName;
    }

    @NonNull
    @Override
    public String toString() {
        return PaurasavaName;
    }
}
