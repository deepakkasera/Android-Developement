package com.example.deepak.volleygson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "VOLLEY";
    Button btnSendReq;
    RequestQueue requestQueue;
    TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvText = (TextView) findViewById(R.id.tvText);
        tvText.setMovementMethod(new ScrollingMovementMethod());
        requestQueue = Volley.newRequestQueue(this);
        btnSendReq = (Button) findViewById(R.id.btnSendReq);
        
        btnSendReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(
                        Request.Method.GET,
                        "http://example.com",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                tvText.setText(response);
                                Log.d(TAG, "onResponse: " + response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "onErrorResponse: ");
                            }
                        }
                );
                stringRequest.setTag("myRequest");
                requestQueue.add(stringRequest);
                requestQueue.cancelAll("myRequest");
            }
        });
    }
}
