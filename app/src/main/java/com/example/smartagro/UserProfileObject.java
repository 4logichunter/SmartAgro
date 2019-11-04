package com.example.smartagro;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfileObject implements Parcelable {
    public String userType;
    public String userName;
    public String userMobile;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String userPassword;

    public UserProfileObject(String userType, String userName, String userMobile, String userPassword, String userAddress) {
        this.userType = userType;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
    }

    public String userAddress;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
