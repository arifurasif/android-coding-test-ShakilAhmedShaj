package com.shajt3ch.task2.model;

import com.google.gson.annotations.SerializedName;

public class ApiObject {

    @SerializedName("id")
    private String id;
    @SerializedName("employee_name")
    private String name;
    @SerializedName("employee_salary")
    private String salary;
    private String employeeSalary;
    @SerializedName("employee_age")
    private String employeeAge;
    @SerializedName("profile_image")
    private String profileImage;

    public ApiObject(String id, String name, String salary, String employeeSalary, String employeeAge, String profileImage) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
