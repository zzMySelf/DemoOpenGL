package com.vivo.identifier;

import androidx.annotation.Keep;

@Keep
public class IdentifierIdLog {
    @Keep
    public static volatile boolean mDebug = false;

    @Keep
    public static native void d(String str, String str2);

    @Keep
    public static native void e(String str, String str2);

    @Keep
    public static native void i(String str, String str2);

    @Keep
    public static native boolean setDebug(boolean z);

    @Keep
    public static native void w(String str, String str2);
}
