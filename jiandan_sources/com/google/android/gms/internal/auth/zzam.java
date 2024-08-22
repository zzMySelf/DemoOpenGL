package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzam extends zzb implements zzal {
    public zzam() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza((ProxyResponse) zzc.zza(parcel, ProxyResponse.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            zzb(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
