package com.example.deepak.recyclerview.model;

/**
 * Created by deepak on 7/2/17.
 */

public class Student {
    String name;
    Integer age;
    String course;

    public Student(String name, Integer age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Integer incrementAge(){
        return ++this.age;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
