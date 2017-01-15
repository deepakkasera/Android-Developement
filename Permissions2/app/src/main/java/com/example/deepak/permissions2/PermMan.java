package com.example.deepak.permissions2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;

/**
 * Created by deepak on 15/1/17.
 */

public class PermMan {

    interface  onPermissionResultListener{
        void onGranted();
        void onDenied();
    }

    private static onPermissionResultListener sOprl;
    static void askForPermission(Activity activity, String perm, onPermissionResultListener oprl){
        sOprl = oprl;
        ActivityCompat.requestPermissions(activity,new String[] { perm },111);
    }

    static void onPermResult (int reqCode,String[] perms,int[] resCodes){
        if(reqCode == 111 ){
            if(resCodes[0] == PackageManager.PERMISSION_GRANTED){
                sOprl.onGranted();
            }
            else {
                sOprl.onDenied();
            }
        }
    }
}
