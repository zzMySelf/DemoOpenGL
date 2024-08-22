package com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IdsSupplier extends IInterface {

    @Keep
    public static abstract class Stub extends Binder implements IdsSupplier {
        @Keep
        public static final String DESCRIPTOR = "com.android.creator.IdsSupplier";
        @Keep
        public static final int TRANSACTION_getAAID = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 3;
        @Keep
        public static final int TRANSACTION_getUDID = 2;
        @Keep
        public static final int TRANSACTION_getVAID = 4;
        @Keep
        public static final int TRANSACTION_isSupported = 1;

        @Keep
        public static class Proxy implements IdsSupplier {
            @Keep
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native String getAAID(String str);

            @Keep
            public native String getInterfaceDescriptor();

            @Keep
            public native String getOAID();

            @Keep
            public native String getUDID(String str);

            @Keep
            public native String getVAID();

            @Keep
            public native boolean isSupported();
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native IdsSupplier asInterface(IBinder iBinder);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    String getAAID(String str);

    @Keep
    String getOAID();

    @Keep
    String getUDID(String str);

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
