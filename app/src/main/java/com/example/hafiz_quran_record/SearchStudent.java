package com.example.hafiz_quran_record;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SearchStudent extends AppCompatActivity {
    TaskDBHelper dbHelper;
    EditText rollNoEntryView;
    List<Task> tasksList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);

        dbHelper = new TaskDBHelper(this);

        Button searchTaskBtn = findViewById(R.id.seaButton);
        rollNoEntryView = findViewById(R.id.searchByRno);
        searchTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoEntryView.getText().toString();

                tasksList = dbHelper.selectAllTasks(rollNo);
                recyclerView = findViewById(R.id.SearchView);


                recyclerView.setHasFixedSize(true);

                //LinearLayoutManager GridLayoutManager
                layoutManager = new LinearLayoutManager(SearchStudent.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new TaskRecyclerViewAdapter(tasksList) ;
                recyclerView.setAdapter(adapter);
            }
        });
    }
}