package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f6410c;

    /* renamed from: a  reason: collision with root package name */
    private a f6411a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6412b;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f6410c == null) {
                f6410c = new b();
            }
            bVar = f6410c;
        }
        return bVar;
    }

    private b() {
    }

    public final synchronized a a(Context context) {
        a aVar = this.f6411a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            this.f6412b = ContextDelegate.getContext(context.getApplicationContext());
            this.f6411a = new c(this.f6412b);
        }
        return this.f6411a;
    }
}
