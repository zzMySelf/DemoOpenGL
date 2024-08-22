package com.google.android.gms.common.api.internal;

public final class zzb implements Runnable {
    public final /* synthetic */ LifecycleCallback zzbu;
    public final /* synthetic */ String zzbv;
    public final /* synthetic */ zza zzbw;

    public zzb(zza zza, LifecycleCallback lifecycleCallback, String str) {
        this.zzbw = zza;
        this.zzbu = lifecycleCallback;
        this.zzbv = str;
    }

    public final void run() {
        if (this.zzbw.zzbs > 0) {
            this.zzbu.onCreate(this.zzbw.zzbt != null ? this.zzbw.zzbt.getBundle(this.zzbv) : null);
        }
        if (this.zzbw.zzbs >= 2) {
            this.zzbu.onStart();
        }
        if (this.zzbw.zzbs >= 3) {
            this.zzbu.onResume();
        }
        if (this.zzbw.zzbs >= 4) {
            this.zzbu.onStop();
        }
        if (this.zzbw.zzbs >= 5) {
            this.zzbu.onDestroy();
        }
    }
}
