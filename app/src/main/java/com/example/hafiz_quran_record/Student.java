package com.example.hafiz_quran_record;

public class Student {
    private String name;
    private String rollNo;

    private int Age;
    private String Class;

    public Student(String name, String rollNo, int Age,String Class) {
        this.name = name;
        this.rollNo = rollNo;
        this.Age=Age;
        this.Class=Class;
    }

    public String getName() {
        return name;
    }

    public String getClas(){
        return Class;
    }


    public void setClass(String Class) {
        this.Class= Class;
    }

    public int getAge() {
        return Age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }


    public void setAge(int Age) {
        this.Age = Age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", Age="+Age+", Class="+Class+ "]";

    }

}