package com.example.deepak.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by deepak on 19/2/17.
 */

public class MyIdService extends FirebaseInstanceIdService {
    public static final String TAG = "TOKEN";
    @Override
    public void onTokenRefresh() {
        String myToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + myToken);
        super.onTokenRefresh();
    }
}
