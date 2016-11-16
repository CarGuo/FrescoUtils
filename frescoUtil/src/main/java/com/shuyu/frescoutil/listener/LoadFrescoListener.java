package com.shuyu.frescoutil.listener;

import android.graphics.Bitmap;

public interface LoadFrescoListener {
    void onSuccess(Bitmap bitmap);

    void onFail();
}