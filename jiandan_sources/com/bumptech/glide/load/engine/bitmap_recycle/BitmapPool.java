package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public interface BitmapPool {
    void ad();

    void de(Bitmap bitmap);

    @NonNull
    Bitmap fe(int i2, int i3, Bitmap.Config config);

    void qw(int i2);

    @NonNull
    Bitmap rg(int i2, int i3, Bitmap.Config config);
}
