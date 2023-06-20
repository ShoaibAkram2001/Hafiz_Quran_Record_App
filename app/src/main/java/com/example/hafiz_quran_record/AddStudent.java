package com.example.hafiz_quran_record;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText etName,etAge,etClass,etRollNo;
    Button adBtn;
    DbHelper db;
    ListView listView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = findViewById(R.id.editTextTextPersonName2);
        etRollNo = findViewById(R.id.editTextTextPersonName);
        etAge = findViewById(R.id.editTextTextPersonName3);
        etClass = findViewById(R.id.editTextTextPersonName4);
        adBtn = findViewById(R.id.button2);



     db = new DbHelper(this);

     adBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String name = etName.getText().toString();
             String rollNo = etRollNo.getText().toString();
             String Class = etClass.getText().toString();
             String Age = etAge.getText().toString();

             if (name.isEmpty() || rollNo.isEmpty() || Class.isEmpty()||Age.isEmpty()) {
                 Toast.makeText(AddStudent.this, "Please Fill all the fields ", Toast.LENGTH_SHORT).show();
                 return;
             }


             Student student = new Student(name, rollNo, Age, Class);
             db.insertStudent(student);

             Toast.makeText(AddStudent.this, "Student Record has been submitted ", Toast.LENGTH_SHORT).show();


         }
     });


    }
}