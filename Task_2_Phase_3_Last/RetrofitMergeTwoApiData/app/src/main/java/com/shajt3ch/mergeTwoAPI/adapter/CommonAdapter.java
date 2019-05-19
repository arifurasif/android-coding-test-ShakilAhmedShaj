package com.shajt3ch.mergeTwoAPI.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shajt3ch.mergeTwoAPI.model.Employee;
import com.shajt3ch.mergeTwoAPI.R;
import com.shajt3ch.mergeTwoAPI.model.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int STUDENT_LAYOUT = 0;
    public static final int EMPLOYEE_LAYOUT = 1;

    private Context context;
    private List<Employee> employeeList;
    private List<Student> studentList;

    public CommonAdapter(Context context, List<Employee> employeeList, List<Student> studentList) {
        this.context = context;
        this.employeeList = employeeList;
        this.studentList = studentList;
    }


    @Override
    public int getItemViewType(int position) {

        return position % 2;

    }

    @Override
    public int getItemCount() {
        int size = employeeList.size() + studentList.size();
        return size;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case STUDENT_LAYOUT:
                View studentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout, parent, false);
                return new StudentLayout(studentView);

            case EMPLOYEE_LAYOUT:
                View employeeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_layout, parent, false);
                return new EmployeeLayout(employeeView);


            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        position = position / 2;

        switch (holder.getItemViewType()) {
            case 0:
                String roll = String.valueOf(studentList.get(position).getRoll());
                String name = studentList.get(position).getName();
                String location = studentList.get(position).getLocation();
                String tagline = studentList.get(position).getTagline();

                ((StudentLayout) holder).setDate(roll, name, location, tagline);
                break;

            case 1:
                String ep_name = employeeList.get(position).getName();
                String salary = employeeList.get(position).getSalary();
                String age = employeeList.get(position).getAge();
                String profile_image = employeeList.get(position).getProfile_image();

                ((EmployeeLayout) holder).setData(ep_name, salary, age, profile_image);
                break;
            default:

        }

        /* if (position % 2 == 0) {
            // student

            String roll = String.valueOf(studentList.get(position).getRoll());
            String name = studentList.get(position).getName();
            String location = studentList.get(position).getLocation();
            String tagline = studentList.get(position).getTagline();

            ((StudentLayout) holder).setDate(roll, name, location, tagline);

        } else {

            // employee

            String name = employeeList.get(position).getName();
            String salary = employeeList.get(position).getSalary();
            String age = employeeList.get(position).getAge();
            String profile_image = employeeList.get(position).getProfile_image();

            ((EmployeeLayout) holder).name.setText(name);
            ((EmployeeLayout) holder).salary.setText(salary);
            ((EmployeeLayout) holder).age.setText(age);

            Picasso.get().load(profile_image).into(((EmployeeLayout) holder).profile_image);

        }*/
    }

    class EmployeeLayout extends RecyclerView.ViewHolder {

        TextView tv_name, tv_salary, tv_age;
        ImageView iv_profile_image;

        EmployeeLayout(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
            tv_salary = itemView.findViewById(R.id.salary);
            tv_age = itemView.findViewById(R.id.age);
            iv_profile_image = itemView.findViewById(R.id.profile_image);
        }

        private void setData(String name, String salary, String age, String profile_image) {

            tv_name.setText(name);
            tv_salary.setText(salary);
            tv_age.setText(age);
            Picasso.get().load(profile_image).into((iv_profile_image));

        }

    }

    class StudentLayout extends RecyclerView.ViewHolder {

        TextView tv_roll, tv_name, tv_location, tv_tagline;

        StudentLayout(View itemView) {
            super(itemView);
            tv_roll = itemView.findViewById(R.id.roll);
            tv_name = itemView.findViewById(R.id.name);
            tv_location = itemView.findViewById(R.id.location);
            tv_tagline = itemView.findViewById(R.id.tagline);
        }

        private void setDate(String roll, String name, String location, String tagline) {
            tv_roll.setText(roll);
            tv_name.setText(name);
            tv_location.setText(location);
            tv_tagline.setText(tagline);
        }

    }
}
