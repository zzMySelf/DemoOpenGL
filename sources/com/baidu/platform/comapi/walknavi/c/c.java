package com.baidu.platform.comapi.walknavi.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.platform.comapi.walknavi.m;
import com.baidu.platform.comjni.bikenavi.JNIEngineManager;
import com.baidu.platform.comjni.jninative.EngineCommonConfig;

/* compiled from: WNaviEngineManager */
public class c extends com.baidu.platform.comapi.walknavi.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public JNIEngineManager f16271a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f16272b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f16273c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f16274d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f16275e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f16276f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handler f16277g = new b(this);

    /* compiled from: WNaviEngineManager */
    private class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private EngineCommonConfig f16278a;

        /* renamed from: b  reason: collision with root package name */
        private long f16279b;

        public a(long j2, EngineCommonConfig engineCommonConfig) {
            this.f16279b = j2;
            this.f16278a = engineCommonConfig;
        }

        public void run() {
            long[] jArr = {0};
            int initBaseManager = c.this.f16271a.initBaseManager(this.f16278a, this.f16279b, jArr);
            Log.d("ret====", "ret：" + initBaseManager);
            if (initBaseManager == 0) {
                long unused = c.this.f16272b = jArr[0];
                Message.obtain(c.this.f16277g, 16).sendToTarget();
                return;
            }
            Message.obtain(c.this.f16277g, 1).sendToTarget();
        }
    }

    /* compiled from: WNaviEngineManager */
    private class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Context f16281a;

        public b(Context context) {
            this.f16281a = context;
        }

        public void run() {
            if (b.a.a.a.c.q.a.a.a(this.f16281a)) {
                Message.obtain(c.this.f16277g, 32).sendToTarget();
                return;
            }
            b.a.a.a.c.d.a.a("InitResourceThread  error");
            Log.d("InitResourceThread", "InitResourceThread  error");
            Message.obtain(c.this.f16277g, 1).sendToTarget();
        }
    }

    public boolean ready() {
        return true;
    }

    public synchronized void release() {
        d();
        this.f16271a = null;
        this.f16273c = 0;
        this.f16274d = 0;
        this.f16276f = 0;
        this.f16272b = 0;
        this.f16275e = null;
    }

    private synchronized void d() {
        JNIEngineManager jNIEngineManager = this.f16271a;
        if (jNIEngineManager != null) {
            jNIEngineManager.uninitBaseManager(this.f16272b);
            this.f16273c = 0;
        }
    }

    public long b() {
        if (this.f16273c == 0) {
            this.f16273c = c(0);
        }
        return this.f16273c;
    }

    public int c() {
        return this.f16276f;
    }

    private long c(int i2) {
        JNIEngineManager jNIEngineManager = this.f16271a;
        if (jNIEngineManager != null) {
            long j2 = this.f16272b;
            if (j2 != 0) {
                long[] jArr = {0};
                try {
                    jNIEngineManager.getSubSysHandle(j2, i2, jArr);
                } catch (Exception e2) {
                    b.a.a.a.c.d.a.b(e2.getMessage());
                }
                return jArr[0];
            }
        }
        return 0;
    }

    public void a(Context context, long j2, a aVar) {
        this.f16275e = aVar;
        if (this.f16276f != 48) {
            EngineCommonConfig engineCommonConfig = new EngineCommonConfig();
            int min = Math.min(b.a.a.a.c.q.b.c.b().d(), 800);
            engineCommonConfig.mStreetPicWidth = min;
            engineCommonConfig.mStreetPicHeight = (min * 3) / 5;
            engineCommonConfig.mStreetPicQuality = 80;
            engineCommonConfig.mNoExistSensor = !m.h().G();
            this.f16271a = new JNIEngineManager();
            new a(j2, engineCommonConfig).start();
            new b(context).start();
        } else if (aVar != null) {
            aVar.engineInitSuccess();
        }
    }

    public long a() {
        if (this.f16274d == 0) {
            this.f16274d = c(1);
        }
        return this.f16274d;
    }
}
