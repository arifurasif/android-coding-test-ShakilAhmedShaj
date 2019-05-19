package com.shajt3ch.mergeTwoAPI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import com.shajt3ch.mergeTwoAPI.adapter.CommonAdapter;
import com.shajt3ch.mergeTwoAPI.api.ApiUtil;
import com.shajt3ch.mergeTwoAPI.model.Employee;
import com.shajt3ch.mergeTwoAPI.model.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*
     *
     * TODO:
     *   1. get Student Data
     *   2. Merge Student & Employee or, Pass it with Adapter
     *   3. In adapter, multiView work needed -> position 1: employee, position: student
     *   4. Need to research on parallel request.
     *
     * */

    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    private List<Employee> employeeList;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        // Employee

        ApiUtil.getServiceClass().getEmployeeList().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(@NonNull Call<List<Employee>> call, @NonNull Response<List<Employee>> response) {
                if (response.isSuccessful()) {
                    employeeList = response.body();

                    // Student

                    ApiUtil.getServiceClass().getStudentList().enqueue(new Callback<List<Student>>() {
                        @Override
                        public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                            if (response.isSuccessful()) {
                                studentList = response.body();

                                CommonAdapter adapter = new CommonAdapter(MainActivity.this, employeeList, studentList);
                                recyclerView.setAdapter(adapter);
                            }

                        }

                        @Override
                        public void onFailure(Call<List<Student>> call, Throwable t) {
                            //showErrorMessage();
                            Log.d(TAG, "error loading from API");
                        }
                    });

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Employee>> call, @NonNull Throwable t) {
                Log.d(TAG, "error loading from API");
            }
        });


    }
}
