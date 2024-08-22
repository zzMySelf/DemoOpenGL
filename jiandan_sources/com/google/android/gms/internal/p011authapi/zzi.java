package com.google.android.gms.internal.p011authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzi  reason: invalid package */
public final class zzi extends zzo<CredentialRequestResult> {
    public final /* synthetic */ CredentialRequest zzan;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzi(zzj zzj, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.zzan = credentialRequest;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return zzg.zzc(status);
    }

    public final void zzc(Context context, zzx zzx) throws RemoteException {
        zzx.zzc((zzv) new zzl(this), this.zzan);
    }
}
