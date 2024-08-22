package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import java.lang.reflect.Field;

public class BaiduWalletFixOUtils {
    public static final String TAG = "BaiduWalletFixOUtils";
    public static boolean gIsSpecialPlugin = false;

    public static boolean fixOrientation(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static void setIsSpecialPlugin(boolean z) {
        gIsSpecialPlugin = z;
    }
}
