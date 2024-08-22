package com.google.android.gms.tasks;

public final class zzs implements OnTokenCanceledListener {
    public final /* synthetic */ TaskCompletionSource zzv;

    public zzs(TaskCompletionSource taskCompletionSource) {
        this.zzv = taskCompletionSource;
    }

    public final void onCanceled() {
        this.zzv.zza.zza();
    }
}
