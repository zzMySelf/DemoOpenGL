package com.baidu.searchbox.imagesearch.host.entry.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0000\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"scale", "Landroid/graphics/Bitmap;", "bitmap", "", "scaleBitmap", "maxSize", "lib-entry_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BitmapUtils.kt */
public final class BitmapUtilsKt {
    public static final Bitmap scaleBitmap(Bitmap bitmap, float maxSize) {
        boolean z = false;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    z = true;
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
                Bitmap bitmap2 = null;
                return null;
            }
        }
        if (!z) {
            return null;
        }
        float scale = maxSize / ((float) Math.max(bitmap.getWidth(), bitmap.getHeight()));
        if (scale < 1.0f) {
            return scale(bitmap, scale);
        }
        return bitmap;
    }

    private static final Bitmap scale(Bitmap bitmap, float scale) {
        boolean z = false;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    z = true;
                }
            } catch (Throwable throwable) {
                if (AppConfig.isDebug()) {
                    throwable.printStackTrace();
                }
                Bitmap bitmap2 = null;
                return null;
            }
        }
        if (!z) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
