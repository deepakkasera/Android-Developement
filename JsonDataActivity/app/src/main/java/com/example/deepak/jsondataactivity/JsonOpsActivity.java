package com.example.deepak.jsondataactivity;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.deepak.jsondataactivity.model.Courses;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonOpsActivity extends AppCompatActivity {

    public static final String TAG = "Error";
    Button btnReadJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_ops);
        final Gson gson = new Gson();
        btnReadJson = (Button) findViewById(R.id.btnReadJson);
        btnReadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonData = getJsonAsFileAsString("test.json");
                try {
                    JSONObject courseObj = new JSONObject(jsonData));
                    JSONArray courseArray = courseObj.getJSONArray("courses");
                    ArrayList<Courses> coursesArrayList = new ArrayList<Courses>();

                    for(int i=0; i < courseArray.length() ; i++){
                        coursesArrayList.add(gson.fromJson(courseArray.getJSONObject(i).toString()
                                ,Courses.class)
                        );
                    }
                }
                catch (Exception e) {
                    Log.d(TAG, "onClick: Some problem with jso parsing");
                }
            }
        });
    }
    String getJsonAsFileAsString(String fileName){
        AssetManager assetManager = getAssets();
        try {
            assetManager.open(fileName);
            InputStream inputStream = assetManager.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String buff = null;
            StringBuilder stringBuilder = new StringBuilder();
            while((buff = bufferedReader.readLine() )!= null){
                stringBuilder.append(buff);
            }
        } catch (Exception e) {
            Log.d(TAG, "Error reading file ");
        }

    }
}
