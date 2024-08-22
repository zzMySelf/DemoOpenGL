package com.baidu.nadcore.load;

import android.graphics.Bitmap;

public interface IImageLoadCallback {
    void onLoadError();

    void onLoadSuccess(Bitmap bitmap);
}
