package com.baidu.android.util.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class ServiceUtils {
    public static ComponentName startServiceSafely(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                return context.startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
