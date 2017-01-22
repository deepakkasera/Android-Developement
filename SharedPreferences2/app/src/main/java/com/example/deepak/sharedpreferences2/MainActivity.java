package com.example.deepak.sharedpreferences2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ERROR";
    EditText etUserName,etPassWord;
    Button btnSave,btnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassWord = (EditText) findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnIntent = (Button) findViewById(R.id.btnIntent);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    public void save(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        sharedPreferences.edit().putString("userName",etUserName.getText().toString()).apply();
        sharedPreferences.edit().putString("passWord",etPassWord.getText().toString()).apply();
        Toast.makeText(this,"Data saved successfully",Toast.LENGTH_SHORT).show();
    }
    public void next(){
        Toast.makeText(this,"Activity B",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ActivityB.class);
        startActivity(intent);
    }
}
