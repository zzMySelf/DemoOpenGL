package com.google.android.gms.tasks;

public final class zzh implements Runnable {
    public final /* synthetic */ zzg zzk;

    public zzh(zzg zzg) {
        this.zzk = zzg;
    }

    public final void run() {
        synchronized (this.zzk.mLock) {
            if (this.zzk.zzj != null) {
                this.zzk.zzj.onCanceled();
            }
        }
    }
}
