package com.google.android.gms.internal.p011authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzaa  reason: invalid package */
public abstract class zzaa extends zzc implements zzab {
    public zzaa() {
        super("com.google.android.gms.auth.api.identity.internal.IBeginSignInCallback");
    }

    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzc((Status) zzf.zzc(parcel, Status.CREATOR), (BeginSignInResult) zzf.zzc(parcel, BeginSignInResult.CREATOR));
        return true;
    }
}
