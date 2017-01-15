package com.example.deepak.sharedprefs;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText etToSave ;
    public static final String TAG = "FILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.etToSave);
        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF",MODE_PRIVATE);
        String savedText = sharedPreferences.getString("text","");
        etToSave.setText(savedText);

        Log.d(TAG, "Data " + Environment.getDataDirectory().getAbsolutePath());
        Log.d(TAG, "Root " + Environment.getRootDirectory().getAbsolutePath());
        Log.d(TAG, "dl cache " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d(TAG, "ExternalStorage " + Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "root " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());

        Log.d(TAG, "filesDir " + getFilesDir());
        Log.d(TAG, " cacheDir " + getCacheDir());
        Log.d(TAG, "externalCache " + getExternalCacheDir());
        Log.d(TAG, "externalfiles dir " + getExternalFilesDir(null));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            File[] extDirs = getExternalFilesDirs(null) ;
            for(File f : extDirs){
                Log.d(TAG, "extDirs " + f.getAbsolutePath());
            }
        }
    }
    
    @Override
    protected void onStop() {
        String textToSave = etToSave.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF",MODE_PRIVATE);
        sharedPreferences.edit().putString("text",textToSave).apply();
//        sharedPreferences.Editor editor = (Editor) sharedPreferences.edit();
        super.onStop();
    }

}
