package com.google.android.gms.internal.p011authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzk  reason: invalid package */
public final class zzk extends zzo<Status> {
    public final /* synthetic */ Credential zzao;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzk(zzj zzj, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zzao = credential;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zzc(Context context, zzx zzx) throws RemoteException {
        zzx.zzc((zzv) new zzp(this), new zzz(this.zzao));
    }
}
