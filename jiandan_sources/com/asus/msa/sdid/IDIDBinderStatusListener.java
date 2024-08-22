package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
public interface IDIDBinderStatusListener extends IInterface {

    @Keep
    public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
        @Keep
        public static final String DESCRIPTOR = "com.asus.msa.sdid.IDIDBinderStatusListener";
        @Keep
        public static final int TRANSACTION_onError = 2;
        @Keep
        public static final int TRANSACTION_onSuccess = 1;

        @Keep
        public static class Proxy implements IDIDBinderStatusListener {
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
            public native void onError();

            @Keep
            public native void onSuccess(IDidAidlInterface iDidAidlInterface);
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Keep
        public static native IDIDBinderStatusListener asInterface(IBinder iBinder);

        @Keep
        public native IBinder asBinder();

        @Keep
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    @Keep
    void onError();

    @Keep
    void onSuccess(IDidAidlInterface iDidAidlInterface);
}
