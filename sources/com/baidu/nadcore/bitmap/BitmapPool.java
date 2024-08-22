package com.baidu.nadcore.bitmap;

import android.graphics.Bitmap;

interface BitmapPool {
    void clearMemory();

    Bitmap get(int i2, int i3, Bitmap.Config config);

    Bitmap getDirty(int i2, int i3, Bitmap.Config config);

    long getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f2);

    void trimMemory(int i2);
}
