package com.baidu.searchbox.account.userinfo.clip.util;

import android.content.Context;
import android.util.DisplayMetrics;

public final class DensityUtils {
    private static final float DOT_FIVE = 0.5f;
    private static DisplayMetrics sDisplayMetrics;

    private DensityUtils() {
    }

    public static int sp2px(Context context, float spValue) {
        if (context == null) {
            return 0;
        }
        return (int) ((spValue * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        if (context == null) {
            return 0;
        }
        return (int) ((pxValue / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int dip2px(Context context, float dip) {
        return (int) ((dip * getDensity(context)) + 0.5f);
    }

    public static int px2dip(Context context, float px) {
        return (int) ((px / getDensity(context)) + 0.5f);
    }

    public static int getDisplayWidth(Context context) {
        initDisplayMetrics(context);
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(context);
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static float getDensity(Context context) {
        initDisplayMetrics(context);
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics == null) {
            return 0.0f;
        }
        return displayMetrics.density;
    }

    public static int getDensityDpi(Context context) {
        initDisplayMetrics(context);
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.densityDpi;
    }

    private static synchronized void initDisplayMetrics(Context context) {
        synchronized (DensityUtils.class) {
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }
}
