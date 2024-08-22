package com.google.android.gms.internal.p011authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzu  reason: invalid package */
public abstract class zzu extends zzc implements zzv {
    public zzu() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc((Status) zzf.zzc(parcel, Status.CREATOR), (Credential) zzf.zzc(parcel, Credential.CREATOR));
        } else if (i2 == 2) {
            zzd((Status) zzf.zzc(parcel, Status.CREATOR));
        } else if (i2 != 3) {
            return false;
        } else {
            zzc((Status) zzf.zzc(parcel, Status.CREATOR), parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
