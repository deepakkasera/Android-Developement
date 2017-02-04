package com.example.deepak.jsondataactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.deepak.jsondataactivity.model.Post;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ERROR";
    RequestQueue requestQueue;
    ArrayList<Post> postArrayList;
    final Gson gson = new Gson();
    Button btnSendRequest;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                "http://jsonplaceholder.typicode.com/posts",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        postArrayList = new ArrayList<>();
                        for(int i=0;i<response.length();i++){
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = response.getJSONObject(i);
                                postArrayList.add(gson.fromJson(jsonObject.toString(),Post.class));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: ");
                    }
                }
        );
        btnSendRequest = (Button) findViewById(R.id.btnSendRequest);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQueue.add(jsonArrayRequest);
            }
        });
    }
}
