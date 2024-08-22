package com.huawei.hms.ads.identifier.aidl;

import android.os.IBinder;
import android.os.IInterface;

public interface OpenDeviceIdentifierService extends IInterface {

    public static abstract class Stub {
        private static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        public static final int TRANSACTION_GETOAID = 1;
        public static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;

        public static class Proxy implements OpenDeviceIdentifierService {
            private IBinder mBinderRemote;

            public Proxy(IBinder iBinder) {
                this.mBinderRemote = iBinder;
            }

            public native IBinder asBinder();

            public native String getInterfaceDescriptor();

            public native String getOaid();

            public native boolean isOaidTrackLimited();
        }

        public static native OpenDeviceIdentifierService asInterface(IBinder iBinder);
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
