package com.baidu.searchbox.qrcode.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public final class DensityUtils {
    private static final float DOT_FIVE = 0.5f;
    private static DisplayMetrics sDisplayMetrics;

    private DensityUtils() {
    }

    public static int dip2px(Context context, float dip) {
        return (int) ((dip * getDensity(context)) + 0.5f);
    }

    public static int px2dip(Context context, float px) {
        return (int) ((px / getDensity(context)) + 0.5f);
    }

    public static int getDisplayWidth(Context context) {
        initDisplayMetrics(context);
        return sDisplayMetrics.widthPixels;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(context);
        return sDisplayMetrics.heightPixels;
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(context);
        return sDisplayMetrics.density;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(context);
        return sDisplayMetrics.densityDpi;
    }

    private static synchronized void initDisplayMetrics(Context context) {
        synchronized (DensityUtils.class) {
            if (sDisplayMetrics == null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }
}
