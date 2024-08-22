package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class zzm extends zzd {
    public final /* synthetic */ zzn zzch;

    public zzm(zzn zzn) {
        this.zzch = zzn;
    }

    public final void zzf(Status status) throws RemoteException {
        this.zzch.setResult(status);
    }
}
