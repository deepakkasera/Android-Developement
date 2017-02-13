package com.example.deepak.savetoexternalstorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "PERMS";
    public static final int REQ_PERM_CODE =111;
    EditText etToSave;
    Button btnSave,btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int perm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(perm == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                Toast.makeText(this,"Permission needed",Toast.LENGTH_SHORT).show();
            }
            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQ_PERM_CODE
                    );
        }

        etToSave = (EditText) findViewById(R.id.etToSave);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnGet = (Button) findViewById(R.id.btnGet);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile("MYFILE",etToSave.getText().toString());
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etToSave.setText(readFromFile("MYFILE"));
            }
        });
    }

    public void writeToFile(String fileName,String data){

        if(ContextCompat.checkSelfPermission(
                this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this,"We dont have a permission to write external storage",Toast.LENGTH_SHORT).show();
            return ;
        }

        File fileToWrite = new File(Environment.getExternalStorageDirectory(),fileName);

        try {
            FileOutputStream fOutStream = new FileOutputStream(fileToWrite );
            fOutStream.write(data.getBytes());
            fOutStream.close();
        } catch (IOException e) {
            Log.e(TAG, "writeToFile: ",  e);
        }
    }


    public String readFromFile(String fileName){
        File fileToRead = new File(Environment.getExternalStorageDirectory(),fileName);
        try {
            FileInputStream fInStream = new FileInputStream(fileToRead);
            InputStreamReader inputStreamReader = new InputStreamReader(fInStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //char[] buff = new char[10];
            StringBuilder stringBuilder = new StringBuilder();
            String str = null;
            while((str = bufferedReader.readLine())!= null ){
                stringBuilder.append(str);
            }
            return stringBuilder.toString();

        } catch (IOException e) {
            Log.e(TAG, "readFromFile: ", e);
        }
        return null;
    }
}
