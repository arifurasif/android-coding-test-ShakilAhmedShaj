package com.shajt3ch.rvmultilayout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shajt3ch.rvmultilayout.R;
import com.shajt3ch.rvmultilayout.model.ModelClass;

import java.util.List;

import static com.shajt3ch.rvmultilayout.model.ModelClass.USER_DOWN_LAYOUT;
import static com.shajt3ch.rvmultilayout.model.ModelClass.USER_UP_LAYOUT;

public class MainActivityAdapter extends RecyclerView.Adapter {

    private List<ModelClass> modelClassList;
    private int lastPosition = -1;

    public MainActivityAdapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @Override
    public int getItemViewType(int position) {

        switch (modelClassList.get(position).getViewType()) {

            case 0:
                return USER_UP_LAYOUT;

            case 1:
                return USER_DOWN_LAYOUT;

            default:
                return -1;


        }


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case USER_UP_LAYOUT:

                View upLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
                return new upLayout(upLayout);

            case USER_DOWN_LAYOUT:

                View downLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_layout, parent, false);
                return new downLayout(downLayout);

            default:
                return null;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (modelClassList.get(position).getViewType()) {


            case USER_UP_LAYOUT:

                String eNamee = modelClassList.get(position).getStrName();

                ((upLayout) holder).setData(eNamee);
                break;

            case USER_DOWN_LAYOUT:

                String roll = modelClassList.get(position).getStrRoll();
                String location = modelClassList.get(position).getStrLocation();

                ((downLayout) holder).setData(roll, location);
                break;
            default:
                return;

        }

        if (lastPosition < position) {
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.setAnimation(animation);

        }


    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }


    class upLayout extends RecyclerView.ViewHolder {

        private TextView e_name_tv;

        public upLayout(@NonNull View itemView) {
            super(itemView);

            e_name_tv = itemView.findViewById(R.id.tvName);
        }

        private void setData(String eName) {

            e_name_tv.setText(eName);

        }


    }

    class downLayout extends RecyclerView.ViewHolder {

        TextView roll_tv;
        TextView location_tv;


        public downLayout(@NonNull View itemView) {
            super(itemView);

            roll_tv = itemView.findViewById(R.id.tvRoll);
            location_tv = itemView.findViewById(R.id.tvLocation);
        }

        private void setData(String roll, String location) {

            roll_tv.setText(roll);
            location_tv.setText(location);

        }
    }

}
