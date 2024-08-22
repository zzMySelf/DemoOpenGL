package com.baidu.apollon.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public final class DisplayUtils {
    public static final float a = 0.5f;
    public static DisplayMetrics b;

    public static void a(Context context) {
        if (b == null) {
            b = context.getResources().getDisplayMetrics();
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getDisplayHeight(Context context) {
        a(context);
        return b.heightPixels;
    }

    public static int getDisplayWidth(Context context) {
        a(context);
        return b.widthPixels;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f, float f2) {
        return (int) ((f / f2) + 0.5f);
    }

    public static int sp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }
}
