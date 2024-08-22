package com.google.android.gms.internal.p011authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzm  reason: invalid package */
public final class zzm extends zzo<Status> {
    public zzm(zzj zzj, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zzc(Context context, zzx zzx) throws RemoteException {
        zzx.zzc(new zzp(this));
    }
}
