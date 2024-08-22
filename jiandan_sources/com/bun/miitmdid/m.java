package com.bun.miitmdid;

import androidx.annotation.Keep;
import androidx.lifecycle.CoroutineLiveDataKt;

@Keep
public abstract class m extends o {
    @Keep
    public volatile String f = "";
    @Keep
    public volatile String g = "";
    @Keep
    public volatile String h = "";
    @Keep

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f3769i = false;
    @Keep
    public volatile boolean j = false;
    @Keep
    public volatile long k;
    @Keep
    public volatile long l = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    @Keep
    public volatile boolean m;

    @Keep
    public native void d();

    @Keep
    public native void e();

    @Keep
    public native void f();

    @Keep
    public native boolean g();

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native String getVAID();

    @Keep
    public native void h();

    @Keep
    public native boolean isLimited();

    @Keep
    public native boolean isSupported();

    @Keep
    public native boolean isSync();
}
