package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Object zzdy = new Object();
    public static ClassLoader zzdz;
    public static Integer zzea;
    public boolean zzeb = false;

    @KeepForSdk
    public static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }

    @KeepForSdk
    public static Integer getUnparcelClientVersion() {
        synchronized (zzdy) {
        }
        return null;
    }

    public static ClassLoader zzp() {
        synchronized (zzdy) {
        }
        return null;
    }

    @KeepForSdk
    public abstract boolean prepareForClientVersion(int i2);

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.zzeb = z;
    }

    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzeb;
    }
}
