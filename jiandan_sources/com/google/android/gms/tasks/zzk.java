package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class zzk<TResult> implements zzq<TResult> {
    public final Object mLock = new Object();
    public final Executor zzd;
    public OnFailureListener zzn;

    public zzk(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzd = executor;
        this.zzn = onFailureListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzn = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzn != null) {
                    this.zzd.execute(new zzl(this, task));
                }
            }
        }
    }
}
