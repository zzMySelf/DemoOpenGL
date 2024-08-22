package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class zzi<TResult> implements zzq<TResult> {
    public final Object mLock = new Object();
    public final Executor zzd;
    public OnCompleteListener<TResult> zzl;

    public zzi(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzd = executor;
        this.zzl = onCompleteListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzl = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzl != null) {
                this.zzd.execute(new zzj(this, task));
            }
        }
    }
}
