package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface MsaIdInterface extends IInterface {

    @Keep
    public static class Default implements MsaIdInterface {
        @Keep
        public native IBinder asBinder();

        @Keep
        public native String getAAID();

        @Keep
        public native String getOAID();

        @Keep
        public native String getVAID();

        @Keep
        public native boolean isDataArrived();

        @Keep
        public native boolean isSupported();

        @Keep
        public native void shutDown();
    }

    @Keep
    public static abstract class Stub extends Binder implements MsaIdInterface {
        @Keep
        public static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        @Keep
        public static final int TRANSACTION_getAAID = 2;
        @Keep
        public static final int TRANSACTION_getOAID = 1;
        @Keep
        public static final int TRANSACTION_getVAID = 3;
        @Keep
        public static final int TRANSACTION_isDataArrived = 4;
        @Keep
        public static final int TRANSACTION_isSupported = 5;
        @Keep
        public static final int TRANSACTION_shutDown = 6;

        @Keep
        public static class Proxy implements MsaIdInterface {
            @Keep
            public static MsaIdInterface sDefaultImpl;
            @Keep
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native String getAAID();

            @Keep
            public native String getInterfaceDescriptor();

            @Keep
            public native String getOAID();

            @Keep
            public native String getVAID();

            @Keep
            public native boolean isDataArrived();

            @Keep
            public native boolean isSupported();

            @Keep
            public native void shutDown();
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native MsaIdInterface asInterface(IBinder iBinder);

        @Keep
        public static native MsaIdInterface getDefaultImpl();

        @Keep
        public static native boolean setDefaultImpl(MsaIdInterface msaIdInterface);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isDataArrived();

    @Keep
    boolean isSupported();

    @Keep
    void shutDown();
}
