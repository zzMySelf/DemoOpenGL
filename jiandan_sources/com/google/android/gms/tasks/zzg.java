package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class zzg<TResult> implements zzq<TResult> {
    public final Object mLock = new Object();
    public final Executor zzd;
    public OnCanceledListener zzj;

    public zzg(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.zzd = executor;
        this.zzj = onCanceledListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzj = null;
        }
    }

    public final void onComplete(@NonNull Task task) {
        if (task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzj != null) {
                    this.zzd.execute(new zzh(this));
                }
            }
        }
    }
}
