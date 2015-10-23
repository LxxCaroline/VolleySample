package com.think.linxuanxuan.picassosample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.think.linxuanxuan.picassosample.R;
import com.think.linxuanxuan.picassosample.volley.StringRequest;
import com.think.linxuanxuan.picassosample.volley.Volley;
import com.think.linxuanxuan.picassosample.volleybox.RequestQueue;
import com.think.linxuanxuan.picassosample.volleybox.Response;
import com.think.linxuanxuan.picassosample.volleybox.VolleyError;

public class MainActivity extends Activity {

    private RequestQueue queue;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edittext);
        queue = Volley.newRequestQueue(this);
    }

    public void shouldCache(View view) {
        StringRequest request = new StringRequest("http:www.qq.com", new Response.Listener<String>() {
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
        queue.add(request);
    }

    public void notCache(View view) {
        StringRequest request = new StringRequest("http:www.csdn.com", new Response.Listener<String>() {
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
        request = (StringRequest) queue.add(request);
    }
}
