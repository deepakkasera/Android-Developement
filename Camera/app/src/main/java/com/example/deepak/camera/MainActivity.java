package com.example.deepak.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    public static final String TAG1 = "PIC";
    public static final String TAG2 = "VID";
    public static final String TAG3 = "PREV";

    Camera cam  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(cam == null){
            cam = Camera.open();
        }

        List<Camera.Size> picSizes = cam.getParameters().getSupportedPictureSizes();
        List<Camera.Size> vidSizes = cam.getParameters().getSupportedVideoSizes();
        List<Camera.Size> prevSizes = cam.getParameters().getSupportedPreviewSizes();

        for(Camera.Size size : picSizes){
            Log.d(TAG1, "PIC: " + size.width +  " "  +size.height );
        }

        for(Camera.Size size : vidSizes){
            Log.d(TAG2, "VID: " + size.width +  " "  +size.height );
        }

        for(Camera.Size size : prevSizes){
            Log.d(TAG3, "PREV: " + size.width +  " "  +size.height );
        }

        final Camera.PictureCallback picCallback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                File filesDir = Environment.getExternalStorageDirectory();
                File fileToWrite = new File(filesDir,"PICTURE3.jpg");
                FileOutputStream fOutStr = null;
                try {
                    fOutStr = new FileOutputStream(fileToWrite);
                    fOutStr.write(data);
                    fOutStr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG1, "onPictureTaken: " + data.length);
                cam.stopPreview();
                cam.startPreview();
            }
        };

        Button btnCamera = (Button) findViewById(R.id.btnCamera);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.preview_container);

        int rotation = 0;

        switch(getWindowManager().getDefaultDisplay().getRotation()){
            case Surface.ROTATION_0: rotation = 90;break;
            case Surface.ROTATION_90: rotation = 0;break;
            case Surface.ROTATION_270: rotation = 180;break;
        }

        cam.setDisplayOrientation(rotation);
        cam.getParameters().setRotation(rotation);

        CameraPreview camPreview = new CameraPreview(this,cam);

        frameLayout.addView(camPreview);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cam.takePicture(null,null,picCallback);
            }
        });

//        CameraPreview camPrev = (CameraPreview) findViewById(R.id.preview);
//        camPrev.initialise(cam);

    }


    @Override
    protected void onStop() {
        cam.release();
        super.onStop();
    }


}
