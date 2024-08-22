package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

public final class zzl {
    public static volatile boolean zzjs = (!zzan());
    @GuardedBy("DirectBootUtils.class")
    public static boolean zzjt = false;

    @RequiresApi(24)
    @TargetApi(24)
    public static Context getDeviceProtectedStorageContext(Context context) {
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }

    public static boolean zzan() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
