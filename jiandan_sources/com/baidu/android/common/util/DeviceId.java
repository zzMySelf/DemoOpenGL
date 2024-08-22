package com.baidu.android.common.util;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.cesium.h;
import fe.fe.fe.i.de;
import fe.fe.fe.o;
import fe.fe.fe.pf;
import fe.fe.fe.th;
import fe.fe.fe.yj.qw;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DeviceId {
    public static final String a = "DeviceId";
    public static final boolean b = false;
    public static h.a d = null;
    public static volatile DeviceId g = null;

    /* renamed from: i  reason: collision with root package name */
    public static CuidChangeCallback f690i = null;
    public static boolean sDataCuidInfoShable = true;
    public final Context c;
    public h e;
    public pf f;
    public th h;
    public Executor j = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    public interface CuidChangeReceivedCallback {
        void onCuidChangeReceived();
    }

    public DeviceId(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null || !(context instanceof Application)) {
            this.c = applicationContext;
        } else {
            this.c = context;
        }
        this.h = new th();
        this.e = new h(this.c, new qw(this.c), this.h);
        this.f = new pf(this.c, this.h);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (o.class) {
            if (g == null) {
                g = new DeviceId(context);
            }
            deviceId = g;
        }
        return deviceId;
    }

    private h.a a(String str) {
        return this.e.pf(str);
    }

    private h.a a(String str, String str2) {
        h.a aVar = this.e.m9switch(str2);
        return aVar == null ? b(str, str2) : aVar;
    }

    private boolean a(h.a aVar) {
        return aVar != null && aVar.xxx() && !TextUtils.isEmpty(aVar.ddd()) && !TextUtils.equals(aVar.ddd(), h.m8if());
    }

    public static h.a b(Context context) {
        if (d == null) {
            synchronized (o.class) {
                if (d == null) {
                    SystemClock.uptimeMillis();
                    d = a(context).c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        a(context).d();
        return d;
    }

    private h.a b(String str, String str2) {
        o ad2 = this.f.ad(str);
        if (ad2 == null || TextUtils.equals(str2, ad2.qw) || !pf.ad.qw(ad2.qw)) {
            return null;
        }
        return this.e.ad(ad2);
    }

    /* access modifiers changed from: private */
    public void b(final h.a aVar) {
        this.j.execute(new Runnable() {
            public void run() {
                synchronized (o.class) {
                    if (DeviceId.f690i != null) {
                        DeviceId.this.e.when();
                        try {
                            aVar.th(true);
                            DeviceId.this.e.o(aVar, true, true);
                            CuidChangeCallback unused = DeviceId.f690i = null;
                        } finally {
                            DeviceId.this.e.ggg();
                        }
                    }
                }
            }
        });
    }

    private h.a c() {
        this.e.when();
        try {
            h.a e2 = e();
            boolean a2 = a(e2);
            boolean z = e2 != null && !pf.ad.qw(e2.uk());
            if (!a2) {
                if (!z) {
                    if (e2 == null) {
                        e2 = a((String) null, (String) null);
                    }
                    if (e2 == null) {
                        e2 = a((String) null);
                    }
                    c(e2);
                    return e2;
                }
            }
            h.a a3 = a((String) null, e2.uk());
            if (a3 == null) {
                a3 = a((String) null);
            }
            a3.th(false);
            a3.rg(e2.a());
            c(a3);
            return a3;
        } catch (Throwable th2) {
            this.e.ggg();
            throw th2;
        }
    }

    private synchronized void c(h.a aVar) {
        this.j.execute(d(aVar));
    }

    private Runnable d(final h.a aVar) {
        return new Runnable() {
            public void run() {
                try {
                    DeviceId.this.e(aVar);
                } finally {
                    DeviceId.this.e.ggg();
                }
            }
        };
    }

    private void d() {
        final h.a aVar = d;
        if (f690i != null) {
            if (aVar == null || aVar.mmm() || TextUtils.isEmpty(aVar.aaa())) {
                f690i = null;
            } else {
                this.j.execute(new Runnable() {
                    public void run() {
                        if (DeviceId.f690i != null) {
                            h.a aVar = aVar;
                            if (aVar == null || aVar.mmm() || TextUtils.isEmpty(aVar.aaa())) {
                                CuidChangeCallback unused = DeviceId.f690i = null;
                            } else {
                                DeviceId.f690i.onCuidChanged(aVar.a(), aVar.aaa(), new CuidChangeReceivedCallback() {
                                    public void onCuidChangeReceived() {
                                        AnonymousClass1 r0 = AnonymousClass1.this;
                                        DeviceId.this.b(aVar);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
    }

    private h.a e() {
        h.a f2 = f();
        return f2 == null ? g() : f2;
    }

    /* access modifiers changed from: private */
    public void e(h.a aVar) {
        if (aVar != null) {
            o rrr = aVar.rrr();
            if (!aVar.xxx() || TextUtils.isEmpty(aVar.ddd())) {
                aVar.qqq();
            }
            this.e.o(aVar, true, false);
            if (!aVar.eee()) {
                this.f.de(rrr);
                this.e.i(aVar);
                return;
            }
            return;
        }
        throw new NullPointerException("cuidV270Info should not be null");
    }

    private h.a f() {
        return this.e.qw();
    }

    private h.a g() {
        o rg2;
        File file = new File(this.c.getFilesDir(), "libcuid.so");
        if (!file.exists() || (rg2 = o.rg(de.qw(file))) == null) {
            return null;
        }
        return this.e.ad(rg2);
    }

    public static String getCUID(Context context) {
        return b(context).a();
    }

    public static String getDeviceID(Context context) {
        return b(context).uk();
    }

    public static String getOldCUID(Context context) {
        return b(context).aaa();
    }

    public static boolean isMySelfTrusted(Context context) {
        return a(context).h.fe(context.getApplicationContext());
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        f690i = cuidChangeCallback;
        b(context);
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
    }

    public h a() {
        return this.e;
    }
}
