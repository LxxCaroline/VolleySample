package com.think.linxuanxuan.volleysample;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by hzlinxuanxuan on 2015/10/13.
 */
public class CustomNetworkImageView extends NetworkImageView {
    public CustomNetworkImageView(Context context) {
        super(context);
    }

    public CustomNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mShowLocal) {
            setImageBitmap(mLocalBitmap);
        }
    }

    private Bitmap mLocalBitmap;

    private boolean mShowLocal;

    public void setLocalImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            mShowLocal = true;
        }
        this.mLocalBitmap = bitmap;
        requestLayout();
    }

    @Override
    public void setImageUrl(String url, ImageLoader imageLoader) {
        mShowLocal = false;
        super.setImageUrl(url, imageLoader);
    }
}
