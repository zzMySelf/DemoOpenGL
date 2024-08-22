package com.dxmpay.apollon.imagemanager;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImageMemoryCache$1 extends LinkedHashMap<String, Bitmap> {
    public static final long serialVersionUID = 1;

    public ImageMemoryCache$1(int i2, float f, boolean z) {
        super(i2, f, z);
    }

    public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (size() <= 15) {
            return false;
        }
        b.qw.put(entry.getKey(), new SoftReference(entry.getValue()));
        return true;
    }
}
