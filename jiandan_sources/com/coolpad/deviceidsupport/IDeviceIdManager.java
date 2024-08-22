package com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IDeviceIdManager extends IInterface {

    @Keep
    public static class Default implements IDeviceIdManager {
        @Keep
        public native IBinder asBinder();

        @Keep
        public native String getAAID(String str);

        @Keep
        public native String getCoolOsVersion();

        @Keep
        public native String getIMEI(String str);

        @Keep
        public native String getOAID(String str);

        @Keep
        public native String getUDID(String str);

        @Keep
        public native String getVAID(String str);

        @Keep
        public native boolean isCoolOs();
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        @Keep
        public static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        @Keep
        public static final int TRANSACTION_getAAID = 4;
        @Keep
        public static final int TRANSACTION_getCoolOsVersion = 7;
        @Keep
        public static final int TRANSACTION_getIMEI = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 2;
        @Keep
        public static final int TRANSACTION_getUDID = 1;
        @Keep
        public static final int TRANSACTION_getVAID = 3;
        @Keep
        public static final int TRANSACTION_isCoolOs = 6;

        @Keep
        public static class Proxy implements IDeviceIdManager {
            @Keep
            public static IDeviceIdManager sDefaultImpl;
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
            public native String getCoolOsVersion();

            @Keep
            public native String getIMEI(String str);

            @Keep
            public native String getInterfaceDescriptor();

            @Keep
            public native String getOAID(String str);

            @Keep
            public native String getUDID(String str);

            @Keep
            public native String getVAID(String str);

            @Keep
            public native boolean isCoolOs();
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native IDeviceIdManager asInterface(IBinder iBinder);

        @Keep
        public static native IDeviceIdManager getDefaultImpl();

        @Keep
        public static native boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    String getAAID(String str);

    @Keep
    String getCoolOsVersion();

    @Keep
    String getIMEI(String str);

    @Keep
    String getOAID(String str);

    @Keep
    String getUDID(String str);

    @Keep
    String getVAID(String str);

    @Keep
    boolean isCoolOs();
}
