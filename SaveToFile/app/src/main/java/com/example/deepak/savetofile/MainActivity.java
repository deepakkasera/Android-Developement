package com.example.deepak.savetofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText etToSave;
    Button btnSave;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.etToSave);
        btnSave = (Button) findViewById(R.id.btnSave);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(readFromFile("MYFILE"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      writeToFile("MYFILE",etToSave.getText().toString());
            }
        });

    }

    void writeToFile(String fileName,String data) {
         File fileDir = getFilesDir();
         File fileToWrite = new File(fileDir,fileName);
         FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileToWrite,true);
            fileOutputStream.write(data.getBytes());
         }
         catch(IOException e) {
             e.printStackTrace();
         }
    }

    String readFromFile(String fileName){
        File filesDir = getFilesDir();
        FileInputStream fileInputStream = null;
        File fileTORead = new File(filesDir,fileName);
        try{
            fileInputStream = new FileInputStream(fileTORead);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            StringBuilder stringBuilder = new StringBuilder();
            char[] charbuffer = new char[10];
            boolean end = false;
            while(!end){
                if(inputStreamReader.read(charbuffer) == -1){
                    end = true;
                    break ;
                }
                stringBuilder.append(charbuffer);
            }

            return stringBuilder.toString();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
