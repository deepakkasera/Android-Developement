package com.example.deepak.listview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvStudent;
    ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<>();
        studentList.add(new Student("A",18,"Launchpad")) ;
        studentList.add(new Student("B",18,"Launchpad")) ;
        studentList.add(new Student("C",28,"Pandora")) ;
        studentList.add(new Student("D",21,"Elixir")) ;
        studentList.add(new Student("E",22,"Crux")) ;
        studentList.add(new Student("F",18,"Pandora")) ;
        studentList.add(new Student("G",20,"Launchpad")) ;
 
        lvStudent = (ListView)findViewById(R.id.lvStudent); 
        
        StudentAdapterList studentAdapterList = new StudentAdapterList();
        lvStudent.setAdapter(studentAdapterList);
    }

    public class StudentAdapterList extends BaseAdapter{

        public static final String TAG = "ListView";
        @Override
        public int getCount() {
            Log.d(TAG, "getCount: ");
            return studentList.size();
        }

        @Override
        public Student getItem(int position) {
            Log.d(TAG, "getItem: ");
            return studentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            Log.d(TAG, "getItemId: ");
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.lsit_view_student,null);

            Student student = getItem(position);
            
            ((TextView)itemView.findViewById(R.id.tvName)).setText(student.getName());
            ((TextView)itemView.findViewById(R.id.tvAge)).setText(student.getAge().toString());
            ((TextView)itemView.findViewById(R.id.tvCourse)).setText(student.getCourse());


            Log.d(TAG, "getView: ");

            return itemView ;

        }
    }
}
