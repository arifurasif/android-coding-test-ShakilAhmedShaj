package com.shajt3ch.task2.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shajt3ch.task2.model.ApiObject;
import com.shajt3ch.task2.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.DataViewHolder> {

    private Context context;
    private List<ApiObject> apiObjectList;

    public MainAdapter(Context context, List<ApiObject> apiObjects) {
        this.context = context;
        this.apiObjectList = apiObjects;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        ApiObject apiObject = apiObjectList.get(position);
        holder.e_name.setText(apiObject.getName());
        holder.e_salary.setText(apiObject.getSalary());
        holder.e_age.setText(apiObject.getEmployeeAge());


        Glide.with(context)
                .asBitmap()
                .load(apiObjectList.get(position).getProfileImage())
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return apiObjectList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        public ImageView photo;
        public TextView e_name;
        public TextView e_salary;
        public TextView e_age;

        public DataViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            e_name = itemView.findViewById(R.id.e_name_id);
            e_salary = itemView.findViewById(R.id.e_salary_id);
            e_age = itemView.findViewById(R.id.e_age_id);
        }
    }
}

