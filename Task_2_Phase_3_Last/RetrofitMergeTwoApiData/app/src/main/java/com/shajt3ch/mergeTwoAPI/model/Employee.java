package com.shajt3ch.mergeTwoAPI.model;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("employee_name")
    private String name;
    @SerializedName("employee_salary")
    private String salary;
    @SerializedName("employee_age")
    private String age;
    @SerializedName("profile_image")
    private String profile_image;

    public Employee(String name, String salary, String age, String profile_image) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
