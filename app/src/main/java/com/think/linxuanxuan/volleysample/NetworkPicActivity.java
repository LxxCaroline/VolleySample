package com.think.linxuanxuan.volleysample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class NetworkPicActivity extends Activity {

    private ListView lvNetworkPic;
    private NetworkPicListAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_pic);
        lvNetworkPic = (ListView) findViewById(R.id.lv_network_pic);
        adapter = new NetworkPicListAdpater(NetworkPicActivity.this, lvNetworkPic);
        lvNetworkPic.setAdapter(adapter);
    }
}
