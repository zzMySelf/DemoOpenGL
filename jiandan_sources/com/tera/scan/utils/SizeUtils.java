package com.tera.scan.utils;

import android.content.res.Resources;

public final class SizeUtils {

    public interface OnGetSizeListener {
    }

    public static int ad(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int qw(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
