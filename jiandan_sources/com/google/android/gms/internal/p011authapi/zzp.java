package com.google.android.gms.internal.p011authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* renamed from: com.google.android.gms.internal.auth-api.zzp  reason: invalid package */
public final class zzp extends zzh {
    public BaseImplementation.ResultHolder<Status> zzaq;

    public zzp(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzaq = resultHolder;
    }

    public final void zzd(Status status) {
        this.zzaq.setResult(status);
    }
}
