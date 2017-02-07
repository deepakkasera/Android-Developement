package com.example.deepak.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.deepak.recyclerview.model.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListStudent;
    ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<Student>();

        studentList.add(new Student("A", 18, "Pandora"));
        studentList.add(new Student("B", 19, "Elixir"));
        studentList.add(new Student("C", 18, "Pandora"));
        studentList.add(new Student("D", 20, "Pandora"));
        studentList.add(new Student("E", 18, "Elixir"));
        studentList.add(new Student("F", 19, "Pandora"));
        studentList.add(new Student("G", 18, "Elixir"));
        studentList.add(new Student("H", 19, "Pandora"));
        studentList.add(new Student("I", 20, "Pandora"));
        studentList.add(new Student("J", 20, "Elixir"));
        studentList.add(new Student("K", 18, "Pandora"));
        studentList.add(new Student("L", 18, "Elixir"));
        studentList.add(new Student("A", 18, "Pandora"));
        studentList.add(new Student("B", 19, "Elixir"));
        studentList.add(new Student("C", 18, "Pandora"));
        studentList.add(new Student("D", 20, "Pandora"));
        studentList.add(new Student("E", 18, "Elixir"));
        studentList.add(new Student("F", 19, "Pandora"));
        studentList.add(new Student("G", 18, "Elixir"));
        studentList.add(new Student("H", 19, "Pandora"));
        studentList.add(new Student("I", 20, "Pandora"));
        studentList.add(new Student("J", 20, "Elixir"));
        studentList.add(new Student("K", 18, "Pandora"));
        studentList.add(new Student("L", 18, "Elixir"));
        studentList.add(new Student("A", 18, "Pandora"));
        studentList.add(new Student("B", 19, "Elixir"));
        studentList.add(new Student("C", 18, "Pandora"));
        studentList.add(new Student("D", 20, "Pandora"));
        studentList.add(new Student("E", 18, "Elixir"));
        studentList.add(new Student("F", 19, "Pandora"));
        studentList.add(new Student("G", 18, "Elixir"));
        studentList.add(new Student("H", 19, "Pandora"));
        studentList.add(new Student("I", 20, "Pandora"));
        studentList.add(new Student("J", 20, "Elixir"));
        studentList.add(new Student("K", 18, "Pandora"));
        studentList.add(new Student("L", 18, "Elixir"));
        studentList.add(new Student("A", 18, "Pandora"));
        studentList.add(new Student("B", 19, "Elixir"));
        studentList.add(new Student("C", 18, "Pandora"));
        studentList.add(new Student("D", 20, "Pandora"));
        studentList.add(new Student("E", 18, "Elixir"));
        studentList.add(new Student("F", 19, "Pandora"));
        studentList.add(new Student("G", 18, "Elixir"));
        studentList.add(new Student("H", 19, "Pandora"));
        studentList.add(new Student("I", 20, "Pandora"));
        studentList.add(new Student("J", 20, "Elixir"));
        studentList.add(new Student("K", 18, "Pandora"));
        studentList.add(new Student("L", 18, "Elixir"));

        rvListStudent = (RecyclerView) findViewById(R.id.rvListStudent);
        StudentAdapter studentAdapter = new StudentAdapter();
        rvListStudent.setLayoutManager(new LinearLayoutManager(this));

        rvListStudent.setAdapter(studentAdapter);


    }
    class StudentHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvAge,tvCourse;
        Button btnAgeIncrement;
        public StudentHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            this.tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            this.btnAgeIncrement = (Button) itemView.findViewById(R.id.btnIncrementAge);
        }
    }

    class StudentAdapter extends RecyclerView.Adapter<StudentHolder>{

        @Override
        public int getItemViewType(int position) {

            if(studentList.get(position).getCourse().equals("Pandora")){
                return 1;
            }

            else {
                return 0;
            }

        }

        @Override
        public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();

            View itemView;

            switch (viewType){
                case 1:default:
                    itemView = layoutInflater.inflate(R.layout.list_item_pandora,parent,false);
                    break;
                case 0:
                    itemView = layoutInflater.inflate(R.layout.list_item_elixir,parent,false);
                    break;
            }

            return new StudentHolder(itemView);

        }

        @Override
        public void onBindViewHolder(final StudentHolder holder, int position) {
            final Student student = studentList.get(position);
            holder.tvName.setText(student.getName());
            holder.tvAge.setText(student.getAge().toString());
            holder.tvCourse.setText(student.getCourse());

            holder.btnAgeIncrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.tvAge.setText(student.incrementAge().toString());
                }
            });
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }
}


