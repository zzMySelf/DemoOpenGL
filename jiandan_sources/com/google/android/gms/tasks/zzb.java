package com.google.android.gms.tasks;

public final class zzb implements OnSuccessListener<Void> {
    public final /* synthetic */ OnTokenCanceledListener zzb;

    public zzb(zza zza, OnTokenCanceledListener onTokenCanceledListener) {
        this.zzb = onTokenCanceledListener;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzb.onCanceled();
    }
}
