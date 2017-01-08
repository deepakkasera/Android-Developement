package com.example.deepak.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart,btnStop ;
    TextView textView ;
    int i ;
    public static final String TAG = "MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        textView = (TextView) findViewById(R.id.textView);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                MyTask myTask = new MyTask();
                myTask.execute(10) ;
            }
        });

    }

    class MyTask extends AsyncTask<Integer,Float,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {
            for(int i=0;i<params[0];i++){
                loopOneSec();
                Log.d(TAG, "doInBackground: " + i);
                publishProgress(((float) i + 1)/ (float) params[0]);
            }
            return "Completed";
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText(Float.toString(values[0]));

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }

    static void loopOneSec(){
        long startTime = System.currentTimeMillis() ;
        while(System.currentTimeMillis() - startTime  < 1000 ) ;
    }

}
