package com.example.deepak.lecture4;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvStudents ;

    String[] students = new String[] {
            "Deepak",
            "Aman",
            "Pankaj"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStudents = (ListView) findViewById(R.id.lvStudents);

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>(
                this,
                R.layout.student_list_name,
                R.id.tvStudentsName,
                students
        );

        lvStudents.setAdapter(studentAdapter);
    }
}
