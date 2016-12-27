package com.example.deepak.lecture3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etVar1,etVar2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv  = (Button) findViewById(R.id.btnDiv);
        tvResult =(TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int a = Integer.valueOf(etVar1.getText().toString());
        int b = Integer.valueOf(etVar2.getText().toString());

        int c = 0;

        switch (v.getId()){

            case R.id.btnAdd:
                c = a+b;
                break;
            case R.id.btnSub:
                c = a - b ;
                break;
            case R.id.btnMul:
                c = a * b ;
                break;
            case R.id.btnDiv:
                c = a / b ;
                break;
        }

        tvResult.setText(String.valueOf(c));
    }


}
