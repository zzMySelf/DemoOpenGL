package com.google.android.gms.tasks;

public final class zzl implements Runnable {
    public final /* synthetic */ Task zzg;
    public final /* synthetic */ zzk zzo;

    public zzl(zzk zzk, Task task) {
        this.zzo = zzk;
        this.zzg = task;
    }

    public final void run() {
        synchronized (this.zzo.mLock) {
            if (this.zzo.zzn != null) {
                this.zzo.zzn.onFailure(this.zzg.getException());
            }
        }
    }
}
