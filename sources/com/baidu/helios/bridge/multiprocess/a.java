package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.bridge.local.LocalBridge;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class a extends BaseBridge {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f12709a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12710b = "Helios-mul";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile g f12711c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile LocalBridge f12712d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f12713e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f12714f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f12715g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Future<Boolean> f12716h;

    /* renamed from: i  reason: collision with root package name */
    private volatile Future<Boolean> f12717i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f12718j;
    /* access modifiers changed from: private */
    public String k;
    private Object l = new Object();
    private Object m = new Object();

    public a(String str) {
        this.k = str;
    }

    private void b() {
        if (!this.f12713e && !this.f12714f) {
            synchronized (this.m) {
                c();
            }
            try {
                this.f12717i.get();
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (!this.f12714f && this.f12717i == null) {
            this.f12717i = this.attachInfo.singleExecutorService.submit(new Callable<Boolean>() {
                /* renamed from: a */
                public Boolean call() {
                    LocalBridge unused = a.this.f12712d = new LocalBridge();
                    a.this.f12712d.attach(a.this.attachInfo);
                    a.this.f12712d.init(a.this.initOptions);
                    boolean unused2 = a.this.f12714f = true;
                    return true;
                }
            });
        }
    }

    private void d() {
        if (this.f12713e) {
            if (!this.f12715g) {
                synchronized (this.l) {
                    e();
                }
            }
            try {
                this.f12716h.get();
            } catch (Exception e2) {
            }
        }
    }

    private void e() {
        if (!this.f12715g && this.f12716h == null) {
            this.f12716h = this.attachInfo.singleExecutorService.submit(new Callable<Boolean>() {
                /* renamed from: a */
                public Boolean call() {
                    a aVar = a.this;
                    a aVar2 = a.this;
                    g unused = aVar.f12711c = new g(aVar2, aVar2.k);
                    a.this.f12711c.attach(a.this.attachInfo);
                    a.this.f12711c.init(a.this.initOptions);
                    boolean unused2 = a.this.f12715g = true;
                    if (a.this.f12711c.a()) {
                        boolean unused3 = a.this.f12718j = true;
                        return true;
                    }
                    boolean unused4 = a.this.f12718j = false;
                    boolean unused5 = a.this.f12713e = false;
                    a.this.c();
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f12713e = false;
        c();
    }

    public void asyncRequestId(String str, Bundle bundle, BaseBridge.OnGetResultCallback<String> onGetResultCallback) {
        if (this.f12713e) {
            d();
            if (this.f12718j) {
                this.f12711c.asyncRequestId(str, bundle, onGetResultCallback);
                return;
            }
        }
        b();
        this.f12712d.asyncRequestId(str, bundle, onGetResultCallback);
    }

    public void initPrivacyInfoAsync() {
        if (this.f12713e) {
            d();
            if (this.f12718j && this.f12711c != null) {
                this.f12711c.initPrivacyInfoAsync();
                return;
            }
        }
        b();
        if (this.f12712d != null) {
            this.f12712d.initPrivacyInfoAsync();
        }
    }

    public boolean isPackageTrusted(String str) {
        if (this.f12713e) {
            d();
            if (this.f12718j) {
                return this.f12711c.isPackageTrusted(str);
            }
        }
        b();
        return this.f12712d.isPackageTrusted(str);
    }

    public void onInit(BaseBridge.InitOptions initOptions) {
        if (this.f12713e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.m) {
            c();
        }
    }

    public BaseBridge.Result syncGetId(String str, Bundle bundle) {
        if (this.f12713e) {
            d();
            if (this.f12718j) {
                BaseBridge.Result syncGetId = this.f12711c.syncGetId(str, bundle);
                if (syncGetId.isSuccess()) {
                    return syncGetId;
                }
                this.f12713e = false;
            }
        }
        b();
        return this.f12712d.syncGetId(str, bundle);
    }
}
