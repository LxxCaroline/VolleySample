package com.think.linxuanxuan.volleysample;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;


public class MyImageCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> cache;

    public MyImageCache() {
//        cache = new LruCache<String, Bitmap>(200 * 1024) {
//        cache = new LruCache<String, Bitmap>(5 * 1024) {
        cache = new LruCache<String, Bitmap>((int) Runtime.getRuntime().maxMemory() / 2) {

            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
                //可以将删除掉的图片缓存在本地，比如SD卡等，或者直接丢掉，如果缓存在本地，应该在getBitmap中也找本地
                Log.d("tag", "remove==============key:" + key + " is removed.   evicted:" + evicted);
            }

            @Override
            protected int sizeOf(String key, Bitmap value) {
                Log.d("tag", "size of-----------value size is " + value.getRowBytes() * value.getHeight() /
                        1024 + "--------key:" + key);
//                return value.getRowBytes() * value.getHeight() / 1024;
                return value.getByteCount();

            }
        };
    }

    @Override
    public synchronized Bitmap getBitmap(String url) {
        return cache.get(url);
    }


    @Override
    public synchronized void putBitmap(String url, Bitmap bitmap) {
        Log.d("tag", "putbitmap--------------:" + url);
        cache.put(url, bitmap);
    }
}
