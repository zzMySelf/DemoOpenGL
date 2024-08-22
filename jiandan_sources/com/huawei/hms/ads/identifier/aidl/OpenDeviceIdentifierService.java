package com.huawei.hms.ads.identifier.aidl;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;

@Keep
public interface OpenDeviceIdentifierService extends IInterface {

    @Keep
    public static abstract class Stub {
        @Keep
        public static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        @Keep
        public static final int TRANSACTION_GETOAID = 1;
        @Keep
        public static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;

        @Keep
        public static class Proxy implements OpenDeviceIdentifierService {
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
            public native String getOaid();

            @Keep
            public native boolean isOaidTrackLimited();
        }

        @Keep
        public static native OpenDeviceIdentifierService asInterface(IBinder iBinder);
    }

    @Keep
    String getOaid();

    @Keep
    boolean isOaidTrackLimited();
}
