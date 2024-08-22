package com.google.android.gms.common.api.internal;

public final class zzc implements Runnable {
    public final /* synthetic */ LifecycleCallback zzbu;
    public final /* synthetic */ String zzbv;
    public final /* synthetic */ zzd zzbx;

    public zzc(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.zzbx = zzd;
        this.zzbu = lifecycleCallback;
        this.zzbv = str;
    }

    public final void run() {
        if (this.zzbx.zzbs > 0) {
            this.zzbu.onCreate(this.zzbx.zzbt != null ? this.zzbx.zzbt.getBundle(this.zzbv) : null);
        }
        if (this.zzbx.zzbs >= 2) {
            this.zzbu.onStart();
        }
        if (this.zzbx.zzbs >= 3) {
            this.zzbu.onResume();
        }
        if (this.zzbx.zzbs >= 4) {
            this.zzbu.onStop();
        }
        if (this.zzbx.zzbs >= 5) {
            this.zzbu.onDestroy();
        }
    }
}
