package com.google.android.gms.common.util.concurrent;

import android.os.Process;

public final class zza implements Runnable {
    public final int priority;
    public final Runnable zzii;

    public zza(Runnable runnable, int i2) {
        this.zzii = runnable;
        this.priority = i2;
    }

    public final void run() {
        Process.setThreadPriority(this.priority);
        this.zzii.run();
    }
}
