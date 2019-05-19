package com.shajt3ch.rvmultilayout.model;

public class ModelClass {

    public static final int USER_UP_LAYOUT = 0;
    public static final int USER_DOWN_LAYOUT = 1;


    private int viewType;


    private String strName;
    private String strRoll;
    private String strLocation;


    public ModelClass(int viewType, String strName) {
        this.viewType = viewType;
        this.strName = strName;
    }

    public ModelClass(int viewType, String strRoll, String strLocation) {
        this.viewType = viewType;
        this.strRoll = strRoll;
        this.strLocation = strLocation;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrRoll() {
        return strRoll;
    }

    public void setStrRoll(String strRoll) {
        this.strRoll = strRoll;
    }

    public String getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }
}
