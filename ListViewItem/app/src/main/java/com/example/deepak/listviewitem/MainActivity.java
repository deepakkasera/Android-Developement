package com.example.deepak.listviewitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStudents = (ListView) findViewById(R.id.lvStudents);
        String[] studentList = new String[]{
                "deepak",
                "Amit",
                "Arnav",
                "Prateek",
                "Vishal",
                "Bhuvesh"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.student_item,
                R.id.tvName,
                studentList
        );
        lvStudents.setAdapter(arrayAdapter);
    }
}
