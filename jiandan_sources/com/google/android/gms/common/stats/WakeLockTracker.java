package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class WakeLockTracker {
    public static WakeLockTracker zzgr = new WakeLockTracker();
    public static Boolean zzgs;
    @VisibleForTesting
    public static boolean zzgt = false;

    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zzgr;
    }

    public static void zza(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(LoggingConstants.zzfo).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e) {
            Log.wtf("WakeLockTracker", e);
        }
    }

    public static boolean zzw() {
        if (zzgs == null) {
            zzgs = Boolean.FALSE;
        }
        return zzgs.booleanValue();
    }

    @KeepForSdk
    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i2, String str4) {
        Intent intent2 = intent;
        Context context2 = context;
        registerEvent(context2, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 7, str, str2, str3, i2, Arrays.asList(new String[]{str4}));
    }

    @KeepForSdk
    public void registerDeadlineEvent(Context context, String str, String str2, String str3, int i2, List<String> list, boolean z, long j) {
        if (zzw()) {
            Context context2 = context;
            zza(context2, new WakeLockEvent(System.currentTimeMillis(), 16, str, i2, StatsUtils.zza(list), (String) null, j, zza.zzh(context), str2, StatsUtils.zzi(context.getPackageName()), zza.zzi(context), 0, str3, z));
        }
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        registerEvent(context, str, i2, str2, str3, str4, i3, list, 0);
    }

    @KeepForSdk
    public void registerReleaseEvent(Context context, Intent intent) {
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 8, (String) null, (String) null, (String) null, 0, (List<String>) null);
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j) {
        int i4 = i2;
        if (zzw()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "missing wakeLock key. ".concat(valueOf);
                } else {
                    new String("missing wakeLock key. ");
                }
            } else if (7 == i4 || 8 == i4 || 10 == i4 || 11 == i4) {
                WakeLockEvent wakeLockEvent = r0;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(System.currentTimeMillis(), i2, str2, i3, StatsUtils.zza(list), str, SystemClock.elapsedRealtime(), zza.zzh(context), str3, StatsUtils.zzi(context.getPackageName()), zza.zzi(context), j, str4, false);
                zza(context, wakeLockEvent);
            }
        }
    }
}
