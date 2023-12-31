package com.example.hafiz_quran_record;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_CLASS = "Class";
    private static final String COLUMN_ROLLNo = "Roll_No";


    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNo + " TEXT UNIQUE,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNo, student.getRollNo());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClas());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // search Student


   /* public List<Student> searchStudentsByRollNumber(String rollNumber) {
        List<Student> studentList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_NAME, COLUMN_CLASS, COLUMN_ROLLNo,COLUMN_AGE};
        String selection = "Roll_No = ?";
        String[] selectionArgs = {rollNumber};

        Cursor cursor = db.query("students", projection, selection, selectionArgs, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {

                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("Name"));
                @SuppressLint("Range") String className = cursor.getString(cursor.getColumnIndex("Class"));
                @SuppressLint("Range") String rollNo = cursor.getString(cursor.getColumnIndex("Roll_No"));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex("Age"));

                Student student = new Student( name, rollNo, age, className);
                studentList.add(student);
            }

            cursor.close();
        }

        db.close();
        return studentList;
    }
*/

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNo, student.getRollNo());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClas());

        db.update(TABLE_NAME, values, COLUMN_ROLLNo + " = ?", new String[] {student.getRollNo()});
        db.close();
    }

    public void deleteStudent(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ROLLNo + " = ?", new String[] {rollNo});
        db.close();
    }


    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
    if(cursor!=null) {
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String rollNo = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNo));
                @SuppressLint("Range") String Class = cursor.getString(cursor.getColumnIndex(COLUMN_CLASS));
                Log.d("Student", "RollNo: " + rollNo + ", Name: " + name + ", Age: " + age+ ", Age: "+Class);
                students.add(new Student(name, rollNo, age, Class));
            } while (cursor.moveToNext());
        }

        cursor.close();
    }
        db.close();

        return students;
    }
}