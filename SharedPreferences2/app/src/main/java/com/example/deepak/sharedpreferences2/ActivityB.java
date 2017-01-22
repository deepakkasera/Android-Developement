package com.example.deepak.sharedpreferences2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    EditText etUserName,etPassWord;
    Button btnLd,btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassWord = (EditText) findViewById(R.id.etPassword);
        btnLd = (Button) findViewById(R.id.btnLd);
        btnPrev = (Button) findViewById(R.id.btnPrev);

        btnLd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });

    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        String name = sharedPreferences.getString("userName","");
        String pass = sharedPreferences.getString("passWord","");
        if(name.equals("") || pass.equals("")){
            Toast.makeText(this,"Data not found",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data loaded successfully",Toast.LENGTH_SHORT).show();
            etUserName.setText(name);
            etPassWord.setText(pass);
        }
    }
    public void previous(){
        Toast.makeText(this,"Previous",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ActivityB.this,MainActivity.class);
        startActivity(intent);
    }
}
