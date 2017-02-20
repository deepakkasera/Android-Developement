package com.example.deepak.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by deepak on 19/2/17.
 */

public class MyMsgService extends FirebaseMessagingService {

    public static final String TAG = "NOTIFICATION";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived: ");
        NotificationCompat.Builder notBuilder = new NotificationCompat.Builder(this);
        notBuilder.setContentText("Some Content")
                .setColor(Color.BLUE)
                .setSubText("Some more Text")
                .setSmallIcon(R.mipmap.ic_launcher);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                123,
                new Intent(this,MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        notBuilder.setContentIntent(pendingIntent);
        NotificationManager notMan = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notMan.notify(234,notBuilder.build());

    }
}
