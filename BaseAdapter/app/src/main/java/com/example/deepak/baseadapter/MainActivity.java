package com.example.deepak.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvStudentList;
    ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStudentList = (ListView) findViewById(R.id.lvStudentList);

        studentArrayList = new ArrayList<Student>();
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Arnav",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Pandora"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        studentArrayList.add(new Student("Deepak",20,"Elixir"));
        StudentAdapter studentAdapter = new StudentAdapter();
        lvStudentList.setAdapter(studentAdapter);

    }

    public class StudentAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return studentArrayList.size();
        }

        @Override
        public Student getItem(int position) {
            return studentArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View itemView;
            Student student = getItem(position);

            if(student.getCourse().equals("Pandora")){
                itemView = layoutInflater.inflate(R.layout.list_item_pandora,null);
            }
            else {
                itemView = layoutInflater.inflate(R.layout.list_item_elixir,null);
            }

            TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvName.setText(student.getName());

            TextView tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            tvName.setText(student.getAge().toString());

            TextView tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            tvName.setText(student.getCourse());

            return itemView;
        }
    }

}
