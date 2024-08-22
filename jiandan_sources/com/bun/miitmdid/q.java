package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.zui.opendeviceidlibrary.OpenDeviceId;

@Keep
public class q extends m implements OpenDeviceId.CallBack<String> {
    @Keep
    public Context n;
    @Keep

    /* renamed from: o  reason: collision with root package name */
    public OpenDeviceId f3771o;

    public q(Context context) {
        this.n = context;
    }

    @Keep
    /* renamed from: a */
    public native void serviceConnected(String str, OpenDeviceId openDeviceId);

    @Keep
    public native void doStart();

    @Keep
    public native boolean isSync();

    @Keep
    public native void shutDown();
}
