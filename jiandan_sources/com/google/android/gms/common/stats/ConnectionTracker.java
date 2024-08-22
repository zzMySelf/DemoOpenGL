package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class ConnectionTracker {
    public static final Object zzfw = new Object();
    public static volatile ConnectionTracker zzfx = null;
    @VisibleForTesting
    public static boolean zzfy = false;
    public final List<String> zzfz;
    public final List<String> zzga;
    public final List<String> zzgb;
    public final List<String> zzgc;

    public ConnectionTracker() {
        List<String> list = Collections.EMPTY_LIST;
        this.zzfz = list;
        this.zzga = list;
        this.zzgb = list;
        this.zzgc = list;
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzfx == null) {
            synchronized (zzfw) {
                if (zzfx == null) {
                    zzfx = new ConnectionTracker();
                }
            }
        }
        return zzfx;
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = ClientLibraryUtils.zzc(context, component.getPackageName());
        }
        if (z) {
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }
}
