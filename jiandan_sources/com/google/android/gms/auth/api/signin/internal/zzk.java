package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class zzk extends zzd {
    public final /* synthetic */ zzl zzcg;

    public zzk(zzl zzl) {
        this.zzcg = zzl;
    }

    public final void zze(Status status) throws RemoteException {
        this.zzcg.setResult(status);
    }
}
