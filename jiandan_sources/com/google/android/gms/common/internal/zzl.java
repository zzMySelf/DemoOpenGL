package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzl extends zzb implements IGmsCallbacks {
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(1, zza);
    }

    public final void zza(int i2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(2, zza);
    }

    public final void zza(int i2, IBinder iBinder, zza zza) throws RemoteException {
        Parcel zza2 = zza();
        zza2.writeInt(i2);
        zza2.writeStrongBinder(iBinder);
        zzd.zza(zza2, (Parcelable) zza);
        zzb(3, zza2);
    }
}
