package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

@Keep
public interface IDeviceidInterface extends IInterface {

    @Keep
    public static abstract class Stub extends Binder implements IDeviceidInterface {
        @Keep
        public static final String DESCRIPTOR = "com.zui.deviceidservice.IDeviceidInterface";
        @Keep
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        @Keep
        public static final int TRANSACTION_getAAID = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 1;
        @Keep
        public static final int TRANSACTION_getUDID = 2;
        @Keep
        public static final int TRANSACTION_getVAID = 4;
        @Keep
        public static final int TRANSACTION_isSupport = 3;

        @Keep
        public static class Proxy implements IDeviceidInterface {
            @Keep
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Keep
            public native IBinder asBinder();

            @Keep
            public native boolean createAAIDForPackageName(String str);

            @Keep
            public native String getAAID(String str);

            @Keep
            public native String getInterfaceDescriptor();

            @Keep
            public native String getOAID();

            @Keep
            public native String getUDID();

            @Keep
            public native String getVAID(String str);

            @Keep
            public native boolean isSupport();
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        @Keep
        public static native IDeviceidInterface asInterface(IBinder iBinder);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    boolean createAAIDForPackageName(String str);

    @Keep
    String getAAID(String str);

    @Keep
    String getOAID();

    @Keep
    String getUDID();

    @Keep
    String getVAID(String str);

    @Keep
    boolean isSupport();
}
