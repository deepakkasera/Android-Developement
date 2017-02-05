package com.example.deepak.baseadapter;

/**
 * Created by deepak on 4/2/17.
 */

public class Student {
    String name;

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public void setName(String name) {

        this.name = name;
    }

    Integer age;
    String course;


    public Student(String name, Integer age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
