package com.example.hafiz_quran_record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hafiz_quran_record.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowStudents extends AppCompatActivity {
    DbHelper dbHelper;
    List<Student> friendsList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new DbHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        friendsList = dbHelper.selectAllStudents();
        recyclerView = findViewById(R.id.recylerViewStudent);


        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(ShowStudents.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(friendsList) ;
        recyclerView.setAdapter(adapter);

    }
}