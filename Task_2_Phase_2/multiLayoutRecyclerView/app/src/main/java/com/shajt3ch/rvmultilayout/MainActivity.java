package com.shajt3ch.rvmultilayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shajt3ch.rvmultilayout.adapter.MainActivityAdapter;
import com.shajt3ch.rvmultilayout.model.ModelClass;

import java.util.ArrayList;
import java.util.List;

import static com.shajt3ch.rvmultilayout.model.ModelClass.USER_DOWN_LAYOUT;
import static com.shajt3ch.rvmultilayout.model.ModelClass.USER_UP_LAYOUT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvVertical;
    private List<ModelClass> modelClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvVertical = findViewById(R.id.rvVertical);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVertical.setLayoutManager(linearLayoutManager);

        modelClassList = new ArrayList<>();

        modelClassList.add(new ModelClass(USER_UP_LAYOUT, "SHAJ"));
        modelClassList.add(new ModelClass(USER_DOWN_LAYOUT, "01","Khulna"));
        modelClassList.add(new ModelClass(USER_UP_LAYOUT, "SHAKIL"));
        modelClassList.add(new ModelClass(USER_DOWN_LAYOUT, "02","Dhaka"));
        modelClassList.add(new ModelClass(USER_UP_LAYOUT, "RAHIM"));
        modelClassList.add(new ModelClass(USER_DOWN_LAYOUT, "03","Jessore"));
        modelClassList.add(new ModelClass(USER_UP_LAYOUT, "KARIM"));
        modelClassList.add(new ModelClass(USER_DOWN_LAYOUT, "04","Barishal"));





        MainActivityAdapter adapter = new MainActivityAdapter(modelClassList);
        rvVertical.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}
