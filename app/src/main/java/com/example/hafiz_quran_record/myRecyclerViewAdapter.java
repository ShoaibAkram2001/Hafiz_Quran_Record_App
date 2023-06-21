package com.example.hafiz_quran_record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {

    List<Student> StudentsList;
    public myRecyclerViewAdapter(List<Student> StudentsList) {
        this.StudentsList = StudentsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=StudentsList.get(position);
        holder.StudentName.setText(holder.data.getName());
        holder.StudentRollNo.setText(holder.data.getRollNo());
        holder.StudentAge.setText(String.valueOf(holder.data.getAge()));

    }

    @Override
    public int getItemCount() {
        return StudentsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {


        TextView StudentName;
        TextView StudentRollNo;
        TextView StudentAge;
        TextView StudentClass;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            StudentName = itemView.findViewById(R.id.StName);
            StudentRollNo= itemView.findViewById(R.id.StRollNo);
            StudentAge= itemView.findViewById(R.id.StAge);
        }
    }
}