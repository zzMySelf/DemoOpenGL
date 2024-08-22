package com.baidu.browser.core.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import com.baidu.searchbox.lightbrowser.IntentConstant;
import java.lang.reflect.Method;

public final class BdStatusBarUtils {
    private static final String MANUFACTURE_NAME_XIAOMI = "Xiaomi";
    private static int mIsMIUI = -1;

    private BdStatusBarUtils() {
    }

    public static void closeStatusBarPanel(Context context) {
        Method collapse;
        try {
            Object service = context.getSystemService(IntentConstant.EXTRA_STATUS_BAR_LIGHT_MODE);
            Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
            if (service != null) {
                if (Build.VERSION.SDK_INT <= 16) {
                    collapse = statusbarManager.getMethod("collapse", new Class[0]);
                } else {
                    collapse = statusbarManager.getMethod("collapsePanels", new Class[0]);
                }
                collapse.setAccessible(true);
                collapse.invoke(service, new Object[0]);
            }
        } catch (Exception e2) {
            BdLog.printStackTrace(e2);
        }
    }

    public static void setStatusBarColor(Window window, int color) {
        int systemUiVisibility;
        if (window == null) {
            return;
        }
        if (!isMIUI()) {
            if (color == -16777216 && window.getNavigationBarColor() == -16777216) {
                window.clearFlags(Integer.MIN_VALUE);
            } else {
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility2 = window.getDecorView().getSystemUiVisibility();
                if (isDarkColor(color)) {
                    systemUiVisibility = systemUiVisibility2 & -8193;
                } else {
                    systemUiVisibility = systemUiVisibility2 | 8192;
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            }
            try {
                window.setStatusBarColor(color);
            } catch (Throwable t) {
                BdLog.printStackTrace(t);
            }
        } else if (setStatusBarLightModeMIUI(window, !isDarkColor(color))) {
            try {
                window.setStatusBarColor(color);
            } catch (Throwable t2) {
                BdLog.printStackTrace(t2);
            }
        }
    }

    private static boolean setStatusBarLightModeMIUI(Window window, boolean dark) {
        if (window == null) {
            return false;
        }
        Class clazz = window.getClass();
        try {
            Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int darkModeFlag = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            if (dark) {
                extraFlagField.invoke(window, new Object[]{Integer.valueOf(darkModeFlag), Integer.valueOf(darkModeFlag)});
            } else {
                extraFlagField.invoke(window, new Object[]{0, Integer.valueOf(darkModeFlag)});
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isDarkColor(int color) {
        if (getDarkness(color) < 0.3d) {
            return false;
        }
        return true;
    }

    public static double getDarkness(int color) {
        return 1.0d - ((((((double) Color.red(color)) * 0.299d) + (((double) Color.green(color)) * 0.587d)) + (((double) Color.blue(color)) * 0.114d)) / 255.0d);
    }

    public static boolean isMIUI() {
        int i2 = mIsMIUI;
        if (i2 < 0) {
            BdLog.d("liuwons", "MANUFACTURE: " + Build.MANUFACTURER);
            if ("Xiaomi".equals(Build.MANUFACTURER)) {
                mIsMIUI = 1;
            }
            if (mIsMIUI == 1) {
                return true;
            }
            return false;
        } else if (i2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
