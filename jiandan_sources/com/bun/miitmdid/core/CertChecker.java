package com.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class CertChecker {
    @Keep
    public static final CertChecker a = new CertChecker();

    static {
        try {
            System.loadLibrary("msaoaidauth");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Keep
    public static native CertChecker a();

    public native boolean verifyCert(Context context, String str);
}
