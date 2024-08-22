package com.baidu.searchbox.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ActivityUtils {
    public static boolean startActivitySafely(Context activity, Intent intent, boolean newTask) {
        if (newTask || !(activity instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        return startActivitySafely(context, intent, false);
    }

    public static boolean startActivityForResultSafely(Context activity, Intent intent, int requestCode) {
        return startActivityForResultSafely((Activity) activity, intent, requestCode, false, false);
    }

    public static boolean startActivityForResultSafely(Activity activity, Intent intent, int requestCode, boolean newTask, boolean withToast) {
        if (newTask) {
            intent.addFlags(268435456);
        }
        try {
            activity.startActivityForResult(intent, requestCode);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static int releaseFixedOrientation(Activity activity) {
        int orientation = -1;
        if (Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && isTranslucentOrFloating(activity) && isFixedOrientation(activity)) {
            try {
                Field activityInfoField = Activity.class.getDeclaredField("mActivityInfo");
                activityInfoField.setAccessible(true);
                Object obj = activityInfoField.get(activity);
                Field screenOrientationFiled = ActivityInfo.class.getDeclaredField("screenOrientation");
                screenOrientationFiled.setAccessible(true);
                orientation = screenOrientationFiled.getInt(obj);
                if (orientation != -1) {
                    screenOrientationFiled.setInt(obj, -1);
                }
            } catch (NoSuchFieldException var5) {
                var5.printStackTrace();
            } catch (IllegalAccessException var6) {
                var6.printStackTrace();
            }
        }
        return orientation;
    }

    public static void fixedOrientation(Activity activity, int orientation) {
        if (orientation != -1 && Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && isTranslucentOrFloating(activity) && !isFixedOrientation(activity)) {
            try {
                Field activityInfoField = Activity.class.getDeclaredField("mActivityInfo");
                activityInfoField.setAccessible(true);
                Object obj = activityInfoField.get(activity);
                Field screenOrientationFile = ActivityInfo.class.getDeclaredField("screenOrientation");
                screenOrientationFile.setAccessible(true);
                if (screenOrientationFile.getInt(obj) == -1) {
                    screenOrientationFile.setInt(obj, orientation);
                }
            } catch (NoSuchFieldException var6) {
                var6.printStackTrace();
            } catch (IllegalAccessException var7) {
                var7.printStackTrace();
            }
        }
    }

    public static void convertFromTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && isTranslucentOrFloating(activity) && isFixedOrientation(activity)) {
            try {
                Method convertFromTranslucent = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                convertFromTranslucent.setAccessible(true);
                convertFromTranslucent.invoke(activity, new Object[0]);
            } catch (IllegalAccessException var2) {
                var2.printStackTrace();
            } catch (NoSuchMethodException var3) {
                var3.printStackTrace();
            } catch (InvocationTargetException var4) {
                var4.printStackTrace();
            }
        }
    }

    private static boolean isFixedOrientation(Activity activity) {
        try {
            Field activityInfoField = Activity.class.getDeclaredField("mActivityInfo");
            activityInfoField.setAccessible(true);
            Object obj = activityInfoField.get(activity);
            Method isFixedOrientationMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
            isFixedOrientationMethod.setAccessible(true);
            return ((Boolean) isFixedOrientationMethod.invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException var5) {
            var5.printStackTrace();
            return false;
        } catch (IllegalAccessException var6) {
            var6.printStackTrace();
            return false;
        } catch (NoSuchFieldException var7) {
            var7.printStackTrace();
            return false;
        } catch (InvocationTargetException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    private static boolean isTranslucentOrFloating(Activity activity) {
        try {
            Class clasz = Class.forName("com.android.internal.R$styleable");
            Field window = clasz.getDeclaredField("Window");
            window.setAccessible(true);
            TypedArray attributes = activity.obtainStyledAttributes((int[]) window.get((Object) null));
            Field Window_windowIsTranslucent = clasz.getDeclaredField("Window_windowIsTranslucent");
            Window_windowIsTranslucent.setAccessible(true);
            Field Window_windowSwipeToDismiss = clasz.getDeclaredField("Window_windowSwipeToDismiss");
            Window_windowSwipeToDismiss.setAccessible(true);
            Field Window_windowIsFloating = clasz.getDeclaredField("Window_windowIsFloating");
            Window_windowIsFloating.setAccessible(true);
            boolean isTranslucent = attributes.getBoolean(((Integer) Window_windowIsTranslucent.get((Object) null)).intValue(), false);
            boolean isSwipeToDismiss = !attributes.hasValue(((Integer) Window_windowIsTranslucent.get((Object) null)).intValue()) && attributes.getBoolean(((Integer) Window_windowSwipeToDismiss.get((Object) null)).intValue(), false);
            boolean isFloating = attributes.getBoolean(((Integer) Window_windowIsFloating.get((Object) null)).intValue(), false);
            attributes.recycle();
            if (isFloating || isTranslucent || isSwipeToDismiss) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
            return false;
        } catch (NoSuchFieldException var11) {
            var11.printStackTrace();
            return false;
        } catch (IllegalAccessException var12) {
            var12.printStackTrace();
            return false;
        }
    }
}
