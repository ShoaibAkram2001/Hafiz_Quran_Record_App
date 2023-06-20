package com.example.hafiz_quran_record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class ShowStudents extends AppCompatActivity {

    List<Student> StudentsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbHelper DH1=new DbHelper(this);
           List<Student> StdLists=DH1.selectAllStudents();

        StudentsList.addAll(StdLists);
        recyclerView = findViewById(R.id.recylerViewStudent);


      //  recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(ShowStudents.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(StudentsList) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();


    }
}