package com.baidu.searchbox.process.ipc.util;

import android.app.Activity;
import android.app.ActivityOptions;
import java.lang.reflect.Method;

public class TranslucentUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "TranslucentUtils";

    public static void convertFromTranslucent(Activity activity) {
        try {
            Method convertFromTranslucent = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            convertFromTranslucent.setAccessible(true);
            convertFromTranslucent.invoke(activity, new Object[0]);
        } catch (Exception e2) {
        }
    }

    public static void convertToTranslucent(Activity activity) {
        try {
            Method getActivityOptions = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            getActivityOptions.setAccessible(true);
            Object options = getActivityOptions.invoke(activity, new Object[0]);
            Class<?> translucentConversionListenerClazz = null;
            for (Class<?> clazz : Activity.class.getDeclaredClasses()) {
                if (clazz.getSimpleName().contains("TranslucentConversionListener")) {
                    translucentConversionListenerClazz = clazz;
                }
            }
            Method convertToTranslucent = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{translucentConversionListenerClazz, ActivityOptions.class});
            convertToTranslucent.setAccessible(true);
            convertToTranslucent.invoke(activity, new Object[]{null, options});
        } catch (Exception e2) {
        }
    }
}
