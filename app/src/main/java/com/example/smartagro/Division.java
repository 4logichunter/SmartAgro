package com.example.smartagro;


import com.google.gson.annotations.SerializedName;
public class Division {
    @SerializedName("divisionCode")
    private int divisionCode;

    @SerializedName("divisionName")

    private String divisionName;

    public int getDivisionCode() {
        return divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }
}



//public class Division {
//
//
//    private int userId;
//
//    private int id;
//
//    private String title;
//
//    @SerializedName("body")
//    private String text;
//
//    public Division(int userId, int id, String title, String text) {
//        this.userId = userId;
//        this.id = id;
//        this.title = title;
//        this.text = text;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getText() {
//        return text;
//    }

    /* @SerializedName("divisionCode")
    @Expose
    private int divisionCode;

    @SerializedName("divisionName")
    @Expose
    private String divisionName;

    public Division() {
    }

    public Division(int divisionCode, String divisionName) {
        this.divisionCode = divisionCode;
        this.divisionName = divisionName;
    }

    public int getdivisionCode() {
        return divisionCode;
    }

    public void setdivisionCode(int divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getdivisionName() {
        return divisionName;
    }

    public void setdivisionName(String name) {
        this.divisionName = name;
    }*/
//}
