package com.example.deepak.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by deepak on 25/2/17.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {


    private Camera camera;
    private SurfaceHolder holder;
    private boolean initialised;

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CameraPreview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CameraPreview(Context context, Camera camera) {
        super(context);

        this.camera = camera;
        this.holder = getHolder();
        holder.addCallback(this);
        initialised = true;
    }

    public void initialise(Camera camera){
        if(initialised) return;
        this.camera = camera;
        this.holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;

        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        if(holder.getSurface() == null){
            return ;
        }

        camera.stopPreview();

        try {
            camera.getParameters().setPreviewSize(width,height);
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
