package com.think.linxuanxuan.volleysample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class NetworkPicActivity extends Activity {

    private android.support.v7.widget.RecyclerView lvNetworkPic;
    private NetworkPicListAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_pic);
        lvNetworkPic = (RecyclerView) findViewById(R.id.lv_network_pic);
        //这个很重要，没有这个什么都显示不了
        lvNetworkPic.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NetworkPicListAdpater(NetworkPicActivity.this, lvNetworkPic);
        lvNetworkPic.setAdapter(adapter);
    }
}
