package com.example.hafiz_quran_record;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hafiz_quran_record.MainActivity;
import com.example.hafiz_quran_record.R;
import com.example.hafiz_quran_record.Task;
import com.example.hafiz_quran_record.TaskDBHelper;

public class DailyTask extends AppCompatActivity {

    // temp
    TaskDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);

        db = new TaskDBHelper(this);
        Button insertStudentTask = findViewById(R.id.insert_student_task_btn);
        TextView sabaqView = findViewById(R.id.edit_student_record_sabaq);
        TextView sabaqiView = findViewById(R.id.edit_student_record_sabaqi);
      TextView manzalView = findViewById(R.id.edit_student_record_manzal);
        TextView rollNoView = findViewById(R.id.edit_student_record_rollno);
        insertStudentTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoView.getText().toString();
                String sabaq = sabaqView.getText().toString();
                String sabaqi = sabaqiView.getText().toString();
                String manzal = manzalView.getText().toString();
                String currentDate = db.getCurrentDate();
                Task task = new Task(rollNo, sabaq, sabaqi, manzal, currentDate);
                db.insertTask(task);
                Toast.makeText(DailyTask.this, "Today record has been added successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyTask.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}