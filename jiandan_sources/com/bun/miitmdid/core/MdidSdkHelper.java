package com.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;

@Keep
public class MdidSdkHelper {
    @Keep
    public static final int SDK_VERSION_CODE = e.a();
    @Keep
    public static long globalTimeout = CoroutineLiveDataKt.DEFAULT_TIMEOUT;

    @Keep
    public static boolean InitCert(Context context, String str) {
        try {
            return e.a(context, str);
        } catch (AbstractMethodError | Error unused) {
            return false;
        }
    }

    @Keep
    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        try {
            return new e(z, globalTimeout).a(context, iIdentifierListener);
        } catch (UnsatisfiedLinkError unused) {
            return 1008615;
        }
    }

    @Keep
    public static int InitSdk(Context context, boolean z, boolean z2, boolean z3, boolean z4, IIdentifierListener iIdentifierListener) {
        try {
            return new e(z, globalTimeout, z2, z3, z4).a(context, iIdentifierListener);
        } catch (UnsatisfiedLinkError unused) {
            return 1008615;
        }
    }

    @Keep
    public static boolean setGlobalTimeout(long j) {
        if (j <= 0) {
            return false;
        }
        globalTimeout = j;
        return true;
    }
}
