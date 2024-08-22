package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.samsung.android.deviceidservice.IDeviceIdService;

@Keep
public class v extends m implements ServiceConnection {
    @Keep
    public Context n;
    @Keep

    /* renamed from: o  reason: collision with root package name */
    public String f3772o;
    @Keep
    public ServiceConnection p;
    @Keep
    public IDeviceIdService q;

    public v(Context context) {
        this.n = context;
        Context a = a(context);
        this.n = a;
        this.f3772o = a != null ? a.getPackageName() : "";
    }

    @Keep
    public native void doStart();

    @Keep
    public native boolean isSync();

    @Keep
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Keep
    public native void onServiceDisconnected(ComponentName componentName);

    @Keep
    public native void shutDown();
}
