package com.think.linxuanxuan.volleysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * request queue is a queue to store all the http request.
     * send the requests concurrency according to some specific algorithm.
     * there is no need to create a request queue for each http request,else it will waste the resource.
     * so creating a request queue for every activity is already enough.
     */
    private static RequestQueue requestQueue;
    private StringRequest stringRequest;
    private JsonObjectRequest jsonObjectRequest;

    //widget
    private TextView tvResponse1, tvResponse2, tvJsonRequest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }


    private void initData() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(MainActivity.this);
        tvResponse1 = (TextView) findViewById(R.id.tvResponse1);
        tvResponse2 = (TextView) findViewById(R.id.tvResponse2);
        tvJsonRequest1 = (TextView) findViewById(R.id.tvJsonRequest1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStringRequest1:
                stringRequest = new StringRequest("http://www.baidu.com", listener1, errorListener1);
                requestQueue.add(stringRequest);
                break;
            case R.id.btnStringRequest2:
                stringRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", listener2,
                        errorListener2);
                requestQueue.add(stringRequest);
                break;
            case R.id.btnJsonRequest1:
                jsonObjectRequest = new JsonObjectRequest("http://www.baidu.com", null, listener3, errorListener3);
                requestQueue.add(jsonObjectRequest);
                break;
            case R.id.btnStartActivity:
                Intent intent = new Intent(MainActivity.this, NetworkPicActivity.class);
                startActivity(intent);
                break;
        }
    }

    Response.Listener<String> listener1 = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            tvResponse1.setText(response);
        }
    };

    Response.ErrorListener errorListener1 = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            tvResponse1.setText(error.getMessage());
        }
    };

    Response.Listener<String> listener2 = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            tvResponse2.setText(response);
        }
    };

    Response.ErrorListener errorListener2 = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            tvResponse2.setText(error.getMessage());
        }
    };

    Response.Listener<JSONObject> listener3 = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject jsonObject) {
            tvJsonRequest1.setText(jsonObject.toString());
        }
    };

    Response.ErrorListener errorListener3 = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            tvJsonRequest1.setText(error.getMessage());
        }
    };
}
