package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.deviceidservice.IDeviceIdService;

public class x extends m implements ServiceConnection {
    public Context n;
    public String o;
    public ServiceConnection p;
    public IDeviceIdService q;

    public x(Context context) {
        this.n = context;
        Context a2 = a(context);
        this.n = a2;
        this.o = a2 != null ? a2.getPackageName() : "";
    }

    public native void doStart();

    public native boolean isSync();

    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    public native void onServiceDisconnected(ComponentName componentName);

    public native void shutDown();
}
