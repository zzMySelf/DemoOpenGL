package com.baidu.sofire.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class i {
    public static final i c = new i();
    public HandlerThread a;
    public Handler b = new Handler(this.a.getLooper());

    public i() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.a = handlerThread;
        handlerThread.start();
    }

    public static Looper a() {
        return c.b.getLooper();
    }
}
