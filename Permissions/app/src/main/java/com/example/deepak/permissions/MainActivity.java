package com.example.deepak.permissions;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etToSave;
    Button button;
    public static final String TAG = "File";
    public static final int PERMISSION_REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int perm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(perm == PackageManager.PERMISSION_DENIED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                Toast.makeText(this,"Give the damn Permission",Toast.LENGTH_SHORT).show();
            }
            ActivityCompat.requestPermissions(this,new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },PERMISSION_REQUEST_CODE);
        }


        etToSave = (EditText) findViewById(R.id.etToSave);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile("MYFILE",etToSave.getText().toString());
            }
        });
    }


    void writeToFile(String fileName,String data){

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
            Toast.makeText(this,"Not have Write Access to External Storage",Toast.LENGTH_SHORT).show();
            return;
        }

        File fileTOWrite = new File(Environment.getExternalStorageDirectory(),fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileTOWrite, true);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
            Toast.makeText(this,"Data Written",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.e(TAG, "writeToFile: ", e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


//        if(requestCode == PERMISSION_REQUEST_CODE){
//             for(int i=0;i<permissions.length;i++){
//                 if(permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
//                     if(grantResults[i] == PackageManager.PERMISSION_DENIED ?
//                             writeToFile();
//                     :
//                     Toast.makeText(this,"File Can,t be Written",Toast.LENGTH_SHORT).show();)
//                 }
//             }
//        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
