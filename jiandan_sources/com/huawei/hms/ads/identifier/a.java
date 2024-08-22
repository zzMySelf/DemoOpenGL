package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public final class a implements ServiceConnection {
    @Keep
    public static final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    @Keep
    public boolean b = false;
    @Keep
    public final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

    @Keep
    public native IBinder a();

    @Keep
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Keep
    public native void onServiceDisconnected(ComponentName componentName);
}
