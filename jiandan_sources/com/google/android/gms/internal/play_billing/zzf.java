package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzf extends zzi implements zzg {
    public zzf() {
        super("com.android.vending.billing.IInAppBillingServiceCallback");
    }

    public final boolean zzb(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzj.zzb(parcel);
        zza((Bundle) zzj.zza(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
