package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzd;

public interface IGmsCallbacks extends IInterface {

    public static abstract class zza extends com.google.android.gms.internal.common.zza implements IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                zza(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                zza(parcel.readInt(), parcel.readStrongBinder(), (zza) zzd.zza(parcel, zza.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(int i2, Bundle bundle) throws RemoteException;

    void zza(int i2, IBinder iBinder, zza zza2) throws RemoteException;
}
