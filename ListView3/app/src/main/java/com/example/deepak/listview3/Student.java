package com.example.deepak.listview3;

/**
 * Created by deepak on 29/12/16.
 */

public class Student {

    String name;
    int age ;
    String course ;


    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }


    public String getName() {
        return name;
    }


    public Integer getAge() {
        return age;
    }


    public String getCourse() {
        return course;
    }
}
