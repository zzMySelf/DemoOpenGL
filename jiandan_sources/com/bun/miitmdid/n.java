package com.bun.miitmdid;

import androidx.annotation.Keep;

@Keep
public abstract class n extends o {
    @Keep
    public g f = d();
    @Keep
    public String g = "";
    @Keep
    public String h = "";
    @Keep

    /* renamed from: i  reason: collision with root package name */
    public String f3770i = "";
    @Keep
    public boolean j = false;
    @Keep
    public boolean k = false;

    public abstract g d();

    @Keep
    public native void doStart();

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
