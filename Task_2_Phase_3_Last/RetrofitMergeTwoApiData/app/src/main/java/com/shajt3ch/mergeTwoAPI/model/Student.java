package com.shajt3ch.mergeTwoAPI.model;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("roll")
    private int roll;
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("tagline")
    private String tagline;

    public Student(int roll, String name, String location, String tagline) {
        this.roll = roll;
        this.name = name;
        this.location = location;
        this.tagline = tagline;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
