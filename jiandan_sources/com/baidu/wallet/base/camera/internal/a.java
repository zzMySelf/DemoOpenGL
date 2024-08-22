package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;

public final class a implements Camera.AutoFocusCallback {
    public static final String c = a.class.getSimpleName();
    public long a = 500;
    public long b = 500;
    public volatile Handler d;
    public boolean e = false;
    public int f;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.d != null) {
            this.d.sendMessageDelayed(this.d.obtainMessage(this.f, Boolean.valueOf(z)), this.e ? this.a : this.b);
            this.e = true;
            this.d = null;
        } else {
            LogUtil.w(c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i2) {
        this.d = handler;
        this.f = i2;
    }
}
