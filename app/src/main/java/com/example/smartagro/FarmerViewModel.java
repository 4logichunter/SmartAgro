package com.example.smartagro;

import java.io.Serializable;

public class FarmerViewModel implements Serializable {

    public User user ;
    public  UserAdditionalInfo userAdditionalInfo ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAdditionalInfo getUserAdditionalInfo() {
        return userAdditionalInfo;
    }

    public void setUserAdditionalInfo(UserAdditionalInfo userAdditionalInfo) {
        this.userAdditionalInfo = userAdditionalInfo;
    }
}
