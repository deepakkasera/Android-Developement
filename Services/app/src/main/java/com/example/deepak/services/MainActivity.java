package com.example.deepak.services;

import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button ;
    public static final String TAG = "LOOP" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(MainActivity.this,MyIntentService.class) ;
                i.putExtra("Hello","World") ;
                startService(i) ;
            }
        });
    }
    public void loopWithLog(int duration) {
        for(int i = 0; i<duration ;i++){
            loopOneSecond();
            Log.d(TAG, "loopWithLog:" + 1);
        }
    }
    public void loopOneSecond(){
         long start_time = System.currentTimeMillis() ;
         while(System.currentTimeMillis() - start_time < 1000) ;
    }
}
