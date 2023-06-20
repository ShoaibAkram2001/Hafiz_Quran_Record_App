package com.example.hafiz_quran_record;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {

    Button AddBtn;
    Button ShowBtn;
    Button SearchBtn;

    Button GithubBtn;
    Button DailyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddBtn=findViewById(R.id.addBtn);
        ShowBtn=findViewById(R.id.showBtn);
        SearchBtn=findViewById(R.id.searchBtn);
        GithubBtn=findViewById(R.id.githubBtn);
        DailyBtn=findViewById(R.id.dailyTaskBtn);

        // go AddStudent
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent=new Intent(MainActivity.this,AddStudent.class);

                startActivity(addIntent);

            }
        });

        // go showStudent
        ShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showIntent=new Intent(MainActivity.this,ShowStudents.class);

                startActivity(showIntent);

            }
        });


        // go SearchStudent
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent=new Intent(MainActivity.this,SearchStudent.class);
                startActivity(searchIntent);
            }
        });

        // go DailyTaskActivity
        DailyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TaskIntent=new Intent(MainActivity.this,DailyTask.class);
                startActivity(TaskIntent);

            }
        });



        // go Github
        GithubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGithub("https://github.com/ShoaibAkram2001/Hafiz_Quran_Record_App.git");
            }
        });


    }

    public void goToGithub(String s)
    {
        Uri uri=Uri.parse(s);
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        startActivity((i));

    }
}