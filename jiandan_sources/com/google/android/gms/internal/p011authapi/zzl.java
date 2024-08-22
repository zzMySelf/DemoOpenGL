package com.google.android.gms.internal.p011authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzl  reason: invalid package */
public final class zzl extends zzh {
    public final /* synthetic */ zzi zzap;

    public zzl(zzi zzi) {
        this.zzap = zzi;
    }

    public final void zzc(Status status, Credential credential) {
        this.zzap.setResult(new zzg(status, credential));
    }

    public final void zzd(Status status) {
        this.zzap.setResult(zzg.zzc(status));
    }
}
