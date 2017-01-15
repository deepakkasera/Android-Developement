package com.example.deepak.permissions2;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etToSave;
    Button btnSave;
    public static final String TAG = "PERM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.etToSave);
        btnSave = (Button) findViewById(R.id.button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermMan.askForPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE, new PermMan.onPermissionResultListener() {
                    @Override
                    public void onGranted() {
                        writeToFile("MYFILE",etToSave.getText().toString());
                    }
                    @Override
                    public void onDenied() {
                        Toast.makeText(MainActivity.this,"Permission denied",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void writeToFile(String FileName,String data){
        Log.d(TAG, "writeToFile: ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermMan.onPermResult(requestCode,permissions,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
