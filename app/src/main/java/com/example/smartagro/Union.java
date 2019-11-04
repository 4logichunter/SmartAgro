package com.example.smartagro;

import androidx.annotation.NonNull;

public class Union {
    public  int UnionCode;
    public String UnionName;

    public int getUnionCode() {
        return UnionCode;
    }

    public void setUnionCode(int unionCode) {
        UnionCode = unionCode;
    }

    public String getUnionName() {
        return UnionName;
    }

    public void setUnionName(String unionName) {
        UnionName = unionName;
    }

    @NonNull
    @Override
    public String toString() {
        return UnionName;
    }
}
