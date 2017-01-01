package com.example.deepak.fragments;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvNum ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum = (TextView) findViewById(R.id.tvNum);
    }
        public void showToastBlue(){
            Toast.makeText(this,"Incremented",Toast.LENGTH_SHORT).show();
    }

        public void showToastRed(){
            Toast.makeText(this,"Decremented",Toast.LENGTH_SHORT).show();
    }

        public void shiftIncrementer(int shiftAmt){
            tvNum.setText(String.valueOf(Integer.valueOf(tvNum.getText().toString()) + shiftAmt ));
    }
}
