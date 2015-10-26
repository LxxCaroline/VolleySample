package com.think.linxuanxuan.volleysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * request queue is a queue to store all the http request.
     * send the requests concurrency according to some specific algorithm.
     * there is no need to create a request queue for each http request,else it will waste the resource.
     * so creating a request queue for every activity is already enough.
     */
    private static RequestQueue requestQueue;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edittext);
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NetworkPicActivity.class);
        startActivity(intent);
    }

    public void shouldCache(View view) {
        StringRequest request = new StringRequest(editText.getText().toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("tag", error.getMessage());
            }
        });
        requestQueue.add(request);
    }

    public void notCache(View view) {
        StringRequest request = new StringRequest(editText.getText().toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("tag", "onResponse:" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "omErrorResposen:" + error.getMessage());
            }
        });
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}
