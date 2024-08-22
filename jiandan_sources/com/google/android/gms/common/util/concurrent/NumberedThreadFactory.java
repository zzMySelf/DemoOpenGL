package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {
    public final int priority;
    public final ThreadFactory zzih;
    public final String zzij;
    public final AtomicInteger zzik;

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.zzih.newThread(new zza(runnable, 0));
        String str = this.zzij;
        int andIncrement = this.zzik.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }

    public NumberedThreadFactory(String str, int i2) {
        this.zzik = new AtomicInteger();
        this.zzih = Executors.defaultThreadFactory();
        this.zzij = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.priority = 0;
    }
}
