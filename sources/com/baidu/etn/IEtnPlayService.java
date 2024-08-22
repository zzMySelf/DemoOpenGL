package com.baidu.etn;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.etn.IEtnPlayStatesListener;

public interface IEtnPlayService extends IInterface {

    public static abstract class th extends Binder implements IEtnPlayService {

        /* renamed from: com.baidu.etn.IEtnPlayService$th$th  reason: collision with other inner class name */
        private static class C0217th implements IEtnPlayService {

            /* renamed from: th  reason: collision with root package name */
            public IBinder f11523th;

            public C0217th(IBinder iBinder) {
                this.f11523th = iBinder;
            }

            public IBinder asBinder() {
                return this.f11523th;
            }

            public String getProxyUrl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.etn.IEtnPlayService");
                    obtain.writeString(str);
                    this.f11523th.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setEtnStatesListener(IEtnPlayStatesListener iEtnPlayStatesListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.etn.IEtnPlayService");
                    obtain.writeStrongBinder(iEtnPlayStatesListener != null ? iEtnPlayStatesListener.asBinder() : null);
                    this.f11523th.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startEtnEngine(EtnConfig etnConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.etn.IEtnPlayService");
                    if (etnConfig != null) {
                        obtain.writeInt(1);
                        etnConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11523th.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopEtnEngine() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.etn.IEtnPlayService");
                    this.f11523th.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public th() {
            attachInterface(this, "com.baidu.etn.IEtnPlayService");
        }

        public static IEtnPlayService th(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.etn.IEtnPlayService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IEtnPlayService)) {
                return new C0217th(iBinder);
            }
            return (IEtnPlayService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.baidu.etn.IEtnPlayService");
                        startEtnEngine(parcel.readInt() != 0 ? EtnConfig.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.baidu.etn.IEtnPlayService");
                        String proxyUrl = getProxyUrl(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(proxyUrl);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.baidu.etn.IEtnPlayService");
                        setEtnStatesListener(IEtnPlayStatesListener.th.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.baidu.etn.IEtnPlayService");
                        stopEtnEngine();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            } else {
                parcel2.writeString("com.baidu.etn.IEtnPlayService");
                return true;
            }
        }
    }

    String getProxyUrl(String str) throws RemoteException;

    void setEtnStatesListener(IEtnPlayStatesListener iEtnPlayStatesListener) throws RemoteException;

    void startEtnEngine(EtnConfig etnConfig) throws RemoteException;

    void stopEtnEngine() throws RemoteException;
}
