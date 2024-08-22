package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zab implements IInterface {
    public final IBinder zab;
    public final String zac;

    public zab(IBinder iBinder, String str) {
        this.zab = iBinder;
        this.zac = str;
    }

    public IBinder asBinder() {
        return this.zab;
    }

    public final Parcel zaa() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zac);
        return obtain;
    }

    public final void zab(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zab.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zac(int i2, Parcel parcel) throws RemoteException {
        try {
            this.zab.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel zaa(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.zab.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }
}
