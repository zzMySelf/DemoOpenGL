package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IOpenID extends IInterface {

    @Keep
    public static class Default implements IOpenID {
        @Keep
        public native IBinder asBinder();

        @Keep
        public native String getSerID(String str, String str2, String str3);
    }

    @Keep
    public static abstract class Stub extends Binder implements IOpenID {
        @Keep
        public static final String DESCRIPTOR = "com.heytap.openid.IOpenID";
        @Keep
        public static final int TRANSACTION_getSerID = 1;

        @Keep
        public static class Proxy implements IOpenID {
            @Keep
            public static IOpenID sDefaultImpl;
            @Keep
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native String getInterfaceDescriptor();

            @Keep
            public native String getSerID(String str, String str2, String str3);
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native IOpenID asInterface(IBinder iBinder);

        @Keep
        public static native IOpenID getDefaultImpl();

        @Keep
        public static native boolean setDefaultImpl(IOpenID iOpenID);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    String getSerID(String str, String str2, String str3);
}
