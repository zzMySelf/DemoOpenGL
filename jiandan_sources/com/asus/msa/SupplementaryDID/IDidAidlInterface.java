package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IDidAidlInterface extends IInterface {

    @Keep
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        @Keep
        public static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        @Keep
        public static final int TRANSACTION_getAAID = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 3;
        @Keep
        public static final int TRANSACTION_getUDID = 2;
        @Keep
        public static final int TRANSACTION_getVAID = 4;
        @Keep
        public static final int TRANSACTION_isSupport = 1;

        @Keep
        public static class Proxy implements IDidAidlInterface {
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
            public native String getUDID();

            @Keep
            public native String getVAID();

            @Keep
            public native boolean isSupport();
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native IDidAidlInterface asInterface(IBinder iBinder);

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
    String getUDID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupport();
}
