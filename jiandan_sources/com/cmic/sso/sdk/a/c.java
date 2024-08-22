package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.e.k;

public class c implements b.a {
    @SuppressLint({"StaticFieldLeak"})
    public static c a;
    public a b;
    public a c;
    public b d;
    public Context e;

    public c(Context context) {
        this.e = context;
        b();
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    private void b() {
        String b2 = k.b("sdk_config_version", "");
        if (TextUtils.isEmpty(b2) || !AuthnHelper.SDK_VERSION.equals(b2)) {
            b a2 = b.a(true);
            this.d = a2;
            this.b = a2.a();
            if (!TextUtils.isEmpty(b2)) {
                c();
            }
        } else {
            b a3 = b.a(false);
            this.d = a3;
            this.b = a3.b();
        }
        this.d.a((b.a) this);
        this.c = this.d.a();
    }

    private void c() {
        com.cmic.sso.sdk.e.c.b("UmcConfigManager", "delete localConfig");
        this.d.c();
    }

    public a a() {
        try {
            return this.b.clone();
        } catch (CloneNotSupportedException unused) {
            return this.c;
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(a aVar) {
        this.d.a(aVar);
    }
}
