package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.coolpad.deviceidsupport.IDeviceIdManager;

@Keep
public class j extends m implements ServiceConnection {
    @Keep
    public static IDeviceIdManager p;
    @Keep
    public Context n;
    @Keep

    /* renamed from: o  reason: collision with root package name */
    public String f3767o;

    public j(Context context) {
        this.n = context;
    }

    @Keep
    public native void doStart();

    @Keep
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Keep
    public native void onServiceDisconnected(ComponentName componentName);

    @Keep
    public native void shutDown();
}
