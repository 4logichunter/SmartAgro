package com.example.smartagro;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {

    public int id ;
    public String mobileNo ;
    public String password ;
    public String name ;
    public int userType ;

    public String address ;
    public int division_code ;
    public int zila_code;
    public int upazila_code ;
    public int paurasava_code ;
    public int union_code ;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDivision_code() {
        return division_code;
    }

    public void setDivision_code(int division_code) {
        this.division_code = division_code;
    }

    public int getZila_code() {
        return zila_code;
    }

    public void setZila_code(int zila_code) {
        this.zila_code = zila_code;
    }

    public int getUpazila_code() {
        return upazila_code;
    }

    public void setUpazila_code(int upazila_code) {
        this.upazila_code = upazila_code;
    }

    public int getPaurasava_code() {
        return paurasava_code;
    }

    public void setPaurasava_code(int paurasava_code) {
        this.paurasava_code = paurasava_code;
    }

    public int getUnion_code() {
        return union_code;
    }

    public void setUnion_code(int union_code) {
        this.union_code = union_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
