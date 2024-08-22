package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IDeviceIdService extends IInterface {

    @Keep
    public static class Default implements IDeviceIdService {
        @Keep
        public IBinder asBinder() {
            return null;
        }

        @Keep
        public String getAAID(String str) {
            return null;
        }

        @Keep
        public String getOAID() {
            return null;
        }

        @Keep
        public String getVAID(String str) {
            return null;
        }
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceIdService {
        @Keep
        public static final String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";
        @Keep
        public static final int TRANSACTION_getAAID = 3;
        @Keep
        public static final int TRANSACTION_getOAID = 1;
        @Keep
        public static final int TRANSACTION_getVAID = 2;

        @Keep
        public static class Proxy implements IDeviceIdService {
            @Keep
            public static IDeviceIdService sDefaultImpl;
            @Keep
            public IBinder mRemote;

            @Keep
            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Keep
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Keep
            public String getAAID(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getAAID(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Keep
            public String getInterfaceDescriptor() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }

            @Keep
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Keep
            public String getVAID(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getVAID(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Keep
        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        @Keep
        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) queryLocalInterface;
        }

        @Keep
        public static IDeviceIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Keep
        public static boolean setDefaultImpl(IDeviceIdService iDeviceIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDeviceIdService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDeviceIdService;
                return true;
            }
        }

        @Keep
        public IBinder asBinder() {
            return this;
        }

        @Keep
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String oaid;
            if (i2 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                oaid = getOAID();
            } else if (i2 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                oaid = getVAID(parcel.readString());
            } else if (i2 == 3) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                oaid = getAAID(parcel.readString());
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel2.writeNoException();
            parcel2.writeString(oaid);
            return true;
        }
    }

    @Keep
    String getAAID(String str);

    @Keep
    String getOAID();

    @Keep
    String getVAID(String str);
}
