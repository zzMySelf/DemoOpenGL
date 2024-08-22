package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public final class zza extends CancellationToken {
    public final zzu<Void> zza = new zzu<>();

    public final void cancel() {
        this.zza.trySetResult(null);
    }

    public final boolean isCancellationRequested() {
        return this.zza.isComplete();
    }

    public final CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
        this.zza.addOnSuccessListener(new zzb(this, onTokenCanceledListener));
        return this;
    }
}
