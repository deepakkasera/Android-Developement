package com.example.deepak.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentList ;
    ListView lvStudenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<>();
        studentList.add(new Student("A",18,"Pandora")) ;
        studentList.add(new Student("B",20,"Pandora"));
        studentList.add(new Student("C",18,"Elixir"));
        studentList.add(new Student("D",18,"Elixir"));
        studentList.add(new Student("E",18,"Elixir"));

        lvStudenList = (ListView) findViewById(R.id.lvStudentList);

        StudentListAdapter studentListAdapter = new StudentListAdapter();
        lvStudenList.setAdapter(studentListAdapter);

    }

    public class StudentListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return studentList.size();
        }

        @Override
        public Student getItem(int position) {
            return studentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();

            View itemView = li.inflate(R.layout.list_item_student,null);
            Student student = getItem(position);

            ((TextView)itemView.findViewById(R.id.tvName)).setText(student.getName());
            ((TextView)itemView.findViewById(R.id.tvAge)).setText(student.getAge().toString());
            ((TextView)itemView.findViewById(R.id.tvCourse)).setText(student.getCourse());

            return itemView;
        }

    }
}