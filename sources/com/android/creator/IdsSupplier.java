package com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IdsSupplier extends IInterface {

    public static class Default implements IdsSupplier {
        public native IBinder asBinder();

        public native String getAAID(String str);

        public native String getOAID();

        public native String getUDID(String str);

        public native String getVAID();

        public native boolean isSupported();
    }

    public static abstract class Stub extends Binder implements IdsSupplier {
        private static final String DESCRIPTOR = "com.android.creator.IdsSupplier";
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupported = 1;

        public static class Proxy implements IdsSupplier {
            public static IdsSupplier sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public native IBinder asBinder();

            public native String getAAID(String str);

            public native String getInterfaceDescriptor();

            public native String getOAID();

            public native String getUDID(String str);

            public native String getVAID();

            public native boolean isSupported();
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static native IdsSupplier asInterface(IBinder iBinder);

        public static native IdsSupplier getDefaultImpl();

        public static native boolean setDefaultImpl(IdsSupplier idsSupplier);

        public native IBinder asBinder();

        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    String getAAID(String str);

    String getOAID();

    String getUDID(String str);

    String getVAID();

    boolean isSupported();
}
