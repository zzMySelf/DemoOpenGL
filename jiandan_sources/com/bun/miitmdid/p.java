package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class p extends n {
    @Keep
    public Context l;

    public p(Context context) {
        this.l = context;
    }

    @Keep
    public native g d();

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native String getVAID();

    @Keep
    public native boolean isLimited();

    @Keep
    public native boolean isSupported();

    @Keep
    public native boolean isSync();

    @Keep
    public native void shutDown();
}
