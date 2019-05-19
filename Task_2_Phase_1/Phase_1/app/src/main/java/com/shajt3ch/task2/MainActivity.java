package com.shajt3ch.task2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import com.shajt3ch.task2.adapter.MainAdapter;
import com.shajt3ch.task2.api.ApiUtil;
import com.shajt3ch.task2.model.ApiObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {
            @Override
            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
                if(response.isSuccessful()){
                    List<ApiObject> postList = response.body();
                    Log.d(TAG, "Returned count " + postList.size());
                    MainAdapter adapter = new MainAdapter(getApplicationContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API");
            }
        });
    }
}
