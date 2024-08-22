package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

public final class zzm extends zzn {
    public final /* synthetic */ zzl zzag;

    public zzm(zzl zzl) {
        this.zzag = zzl;
    }

    public final void zza(boolean z) {
        this.zzag.setResult(new zzq(z ? Status.RESULT_SUCCESS : zzh.zzad));
    }
}
