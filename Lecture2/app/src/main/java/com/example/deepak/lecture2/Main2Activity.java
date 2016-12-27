package com.example.deepak.lecture2;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText etVar1,etVar2;
    Button btnAdd,btnMul,btnSub,btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        View.OnClickListener oCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(etVar1.getText().toString());
                int b = Integer.parseInt(etVar2.getText().toString());

                int c = a+b;

                tvResult.setText(String.valueOf(c));
            }
        };

        btnAdd.setOnClickListener(oCL);

    }

}
