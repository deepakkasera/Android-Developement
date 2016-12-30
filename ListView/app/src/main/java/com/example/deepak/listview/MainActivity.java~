package com.example.deepak.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvStudents ;

    String[] students = new String[]{
            "Deepak",
            "Pankaj",
            "Ram",
            "Shyam",
            "Prince"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStudents = (ListView) findViewById(R.id.lvStudents);

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students
        );

        lvStudents.setAdapter(studentAdapter);
    }
}
