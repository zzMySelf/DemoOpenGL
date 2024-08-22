package com.google.android.gms.tasks;

public final class zzj implements Runnable {
    public final /* synthetic */ Task zzg;
    public final /* synthetic */ zzi zzm;

    public zzj(zzi zzi, Task task) {
        this.zzm = zzi;
        this.zzg = task;
    }

    public final void run() {
        synchronized (this.zzm.mLock) {
            if (this.zzm.zzl != null) {
                this.zzm.zzl.onComplete(this.zzg);
            }
        }
    }
}
