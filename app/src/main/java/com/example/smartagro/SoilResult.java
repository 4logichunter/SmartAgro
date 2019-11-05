package com.example.smartagro;


import androidx.annotation.NonNull;

public class SoilResult {
     private String mobile_no;
    private String ph;
    private String carbon;
    private String magnesum;
    private String calcium;
    private String sulphur;
    private String phosphorus;
    private String nitrogen;

    private int is_viewed;

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getCarbon() {
        return carbon;
    }

    public void setCarbon(String carbon) {
        this.carbon = carbon;
    }

    public String getMagnesum() {
        return magnesum;
    }

    public void setMagnesum(String magnesum) {
        this.magnesum = magnesum;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getSulphur() {
        return sulphur;
    }

    public void setSulphur(String sulphur) {
        this.sulphur = sulphur;
    }

    public String getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(String phosphorus) {
        this.phosphorus = phosphorus;
    }

    public String getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(String nitrogen) {
        this.nitrogen = nitrogen;
    }

    public int getIs_viewed() {
        return is_viewed;
    }

    public void setIs_viewed(int is_viewed) {
        this.is_viewed = is_viewed;
    }

    @NonNull
    @Override
    public String toString() {
        return "[Mobile No]: "+
        mobile_no+" [ph]: "+ph
                +" [carbon]: "+carbon
                +" [magnesum]: "+magnesum
                +" [calcium]: "+calcium
                +" [sulphur]: "+sulphur
                +" [phosphorus]: "+phosphorus
                +" [nitrogen]: "+nitrogen;
    }
}
