package com.example.deepak.jsongson;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.deepak.jsongson.model.Courses;
import com.example.deepak.jsongson.model.TestJson;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSenReq;
    public static final String TAG = "JSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Gson gson = new Gson();
        btnSenReq = (Button) findViewById(R.id.btnSendReq);
        btnSenReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jsonData = getJsonFileAsString("test.json");
                TestJson testJson = gson.fromJson(
                        jsonData,
                        TestJson.class
                );

                Log.d(TAG, "onClick: " + testJson.getCourses().get(0).getTeacher());
                Log.d(TAG, "onClick: " + testJson.getCourses().get(2).getStudentList().get(0).getName());

//                try {
//                    JSONObject jsonObject = new JSONObject(jsonData);
//                    JSONArray jsonArray = jsonObject.getJSONArray("courses");
//
//                    ArrayList<Courses> courseList = new ArrayList<Courses>();
//
//                    for(int i=0;i<jsonArray.length();i++) {
//                        courseList.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Courses.class));
//                    }
//                    Log.d(TAG, "onClick: " + courseList.get(0).getTeacher());
//                }
//                catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        });
    }

    String getJsonFileAsString(String fileName){
        AssetManager am = getAssets();
        InputStream ir = null;
        try {
            ir = am.open(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(ir);
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String str=null;
            while( (str = br.readLine()) != null){
                sb.append(str);
            }
            return sb.toString();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
