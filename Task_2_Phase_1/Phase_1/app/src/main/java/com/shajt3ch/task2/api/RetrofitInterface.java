package com.shajt3ch.task2.api;


import com.shajt3ch.task2.model.ApiObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/v2/5cdf27653000002b00430d14")
    public Call<List<ApiObject>> getAllPost();
}
