package com.example.deepak.lecture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MA";

    EditText etVar1,etVar2;
    Button btnAdd;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);

        View.OnClickListener oCL = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(etVar1.getText().toString());
                int b = Integer.parseInt(etVar2.getText().toString());

                //int c = 0;
                //c = a+b;

                tvResult.setText(String.valueOf(a + b));
            }
        };

        btnAdd.setOnClickListener(oCL);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

}
