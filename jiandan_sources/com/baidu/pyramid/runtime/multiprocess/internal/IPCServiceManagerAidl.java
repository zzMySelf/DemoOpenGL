package com.baidu.pyramid.runtime.multiprocess.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPCServiceManagerAidl extends IInterface {

    public static class Default implements IPCServiceManagerAidl {
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public IBinder getService(String str) throws RemoteException {
            return null;
        }

        public boolean removeService(String str) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IPCServiceManagerAidl {
        public static final String DESCRIPTOR = "com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl";
        public static final int TRANSACTION_addService = 3;
        public static final int TRANSACTION_getService = 1;
        public static final int TRANSACTION_removeService = 2;

        public static class Proxy implements IPCServiceManagerAidl {
            public static IPCServiceManagerAidl sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().addService(str, iBinder, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public IBinder getService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getService(str);
                    }
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    obtain2.recycle();
                    obtain.recycle();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean removeService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeService(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPCServiceManagerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPCServiceManagerAidl)) {
                return new Proxy(iBinder);
            }
            return (IPCServiceManagerAidl) queryLocalInterface;
        }

        public static IPCServiceManagerAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPCServiceManagerAidl iPCServiceManagerAidl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iPCServiceManagerAidl == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iPCServiceManagerAidl;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IBinder service = getService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(service);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean removeService = removeService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(removeService ? 1 : 0);
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                addService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void addService(String str, IBinder iBinder, boolean z) throws RemoteException;

    IBinder getService(String str) throws RemoteException;

    boolean removeService(String str) throws RemoteException;
}
