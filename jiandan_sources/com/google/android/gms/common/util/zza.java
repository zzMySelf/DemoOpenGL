package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zza {
    public static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    public static long zzhl;
    public static float zzhm = Float.NaN;

    @TargetApi(20)
    public static int zzh(Context context) {
        int i2;
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
        int i3 = 0;
        if (registerReceiver == null) {
            i2 = 0;
        } else {
            i2 = registerReceiver.getIntExtra("plugged", 0);
        }
        int i4 = 3;
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            i4 = 7;
        }
        int i5 = (i2 & i4) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i3 = 2;
        }
        return i3 | i5;
    }

    public static synchronized float zzi(Context context) {
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - zzhl >= 60000 || Float.isNaN(zzhm)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
                if (registerReceiver != null) {
                    zzhm = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzhl = SystemClock.elapsedRealtime();
                float f = zzhm;
                return f;
            }
            float f2 = zzhm;
            return f2;
        }
    }
}
