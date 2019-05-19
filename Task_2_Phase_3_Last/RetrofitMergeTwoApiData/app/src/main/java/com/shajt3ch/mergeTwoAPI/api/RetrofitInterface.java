package com.shajt3ch.mergeTwoAPI.api;


import com.shajt3ch.mergeTwoAPI.model.Employee;
import com.shajt3ch.mergeTwoAPI.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/v2/5cdf27653000002b00430d14")
    public Call<List<Employee>> getEmployeeList();

    @GET("/v2/5cdf2f353000004600430d29")
    public Call<List<Student>> getStudentList();
}
