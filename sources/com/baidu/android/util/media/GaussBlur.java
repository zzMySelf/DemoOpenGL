package com.baidu.android.util.media;

import android.graphics.Bitmap;

@Deprecated
public final class GaussBlur {
    public static final int RADIUS = 10;

    private GaussBlur() {
    }

    public static Bitmap fastBlur(Bitmap inBitmap, boolean canReuseInBitmap, float scale, int radius) {
        return com.baidu.android.util.bitmap.GaussBlur.fastBlur(inBitmap, canReuseInBitmap, scale, radius);
    }
}
