package com.example.deepak.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    
    public static final String TAG = "" ;
    
    public MyService() {
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null) {
            Log.d(TAG, "onStartCommand: " + intent.getStringExtra("Hello"));
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
    public void loopWithLog(int duration) {
        for(int i = 0; i<duration ;i++){
            loopOneSecond();
            Log.d(TAG, "loopWithLog:" + i);
        }
    }
    public void loopOneSecond(){
        long start_time = System.currentTimeMillis() ;
        while(System.currentTimeMillis() - start_time < 1000) ;
    }

}
