package com.example.deepak.jsongson.model;

import java.util.ArrayList;

/**
 * Created by deepak on 16/2/17.
 */

public class Courses {
    String name;
    int id;
    int strength;
    String teacher;
    ArrayList<Student> studentList;

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getStrength() {
        return strength;
    }

    public String getTeacher() {
        return teacher;
    }
}
