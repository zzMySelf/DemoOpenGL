package com.dxmpay.apollon.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public final class DisplayUtils {
    public static DisplayMetrics qw;

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getDisplayHeight(Context context) {
        qw(context);
        return qw.heightPixels;
    }

    public static int getDisplayWidth(Context context) {
        qw(context);
        return qw.widthPixels;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f, float f2) {
        return (int) ((f / f2) + 0.5f);
    }

    public static void qw(Context context) {
        if (qw == null) {
            qw = context.getResources().getDisplayMetrics();
        }
    }

    public static int sp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }
}
