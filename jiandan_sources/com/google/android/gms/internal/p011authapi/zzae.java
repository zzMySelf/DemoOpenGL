package com.google.android.gms.internal.p011authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzae  reason: invalid package */
public final /* synthetic */ class zzae implements RemoteCall {
    public final zzaf zzbh;
    public final BeginSignInRequest zzbi;

    public zzae(zzaf zzaf, BeginSignInRequest beginSignInRequest) {
        this.zzbh = zzaf;
        this.zzbi = beginSignInRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zzaf zzaf = this.zzbh;
        BeginSignInRequest beginSignInRequest = this.zzbi;
        ((zzad) ((zzak) obj).getService()).zzc((zzab) new zzaj(zzaf, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(beginSignInRequest));
    }
}
