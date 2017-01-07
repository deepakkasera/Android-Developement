package com.example.deepak.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by deepak on 7/1/17.
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public static final String TAG = "LOOP";

    public MyIntentService() {
        super("MIS");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        loopWithLog(10);

    }

    public void loopWithLog(int duration) {
        for (int i = 0; i < duration; i++) {
            loopOneSecond();
            Log.d(TAG, "loopWithLog:" + i);
        }
    }

    public void loopOneSecond() {
        long start_time = System.currentTimeMillis();
        while (System.currentTimeMillis() - start_time < 1000) ;
    }

}
