package com.cmic.sso.sdk.c.a;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.c.c.c;
import com.cmic.sso.sdk.c.d.b;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WifiChangeInterceptor */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f4308a;

    public void a(final c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final a aVar) {
        if (!cVar.b()) {
            b(cVar, cVar2, aVar);
            return;
        }
        r a2 = r.a((Context) null);
        if (Build.VERSION.SDK_INT >= 21) {
            a2.a((r.a) new r.a() {

                /* renamed from: e  reason: collision with root package name */
                private final AtomicBoolean f4313e = new AtomicBoolean(false);

                public void a(final Network network) {
                    if (!this.f4313e.getAndSet(true)) {
                        n.a(new n.a((Context) null, aVar) {
                            /* access modifiers changed from: protected */
                            public void a() {
                                if (network != null) {
                                    com.cmic.sso.sdk.e.c.b("WifiChangeInterceptor", "onAvailable");
                                    cVar.a(network);
                                    AnonymousClass1 r0 = AnonymousClass1.this;
                                    d.this.b(cVar, cVar2, aVar);
                                    return;
                                }
                                cVar2.a(com.cmic.sso.sdk.c.d.a.a(102508));
                            }
                        });
                    }
                }
            });
            return;
        }
        com.cmic.sso.sdk.e.c.a("WifiChangeInterceptor", "低版本不在支持wifi切换");
        cVar2.a(com.cmic.sso.sdk.c.d.a.a(102508));
    }

    public void b(c cVar, final com.cmic.sso.sdk.c.d.c cVar2, a aVar) {
        b bVar = this.f4308a;
        if (bVar != null) {
            bVar.a(cVar, new com.cmic.sso.sdk.c.d.c() {
                public void a(b bVar) {
                    cVar2.a(bVar);
                }

                public void a(com.cmic.sso.sdk.c.d.a aVar) {
                    cVar2.a(aVar);
                }
            }, aVar);
        }
    }

    public void a(b bVar) {
        this.f4308a = bVar;
    }
}
