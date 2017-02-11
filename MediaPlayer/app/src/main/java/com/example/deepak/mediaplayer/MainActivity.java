package com.example.deepak.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create( this,R.raw.audio);
        mediaPlayer.start();

    }


    @Override
    protected void onStop() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onStop();
    }
}
