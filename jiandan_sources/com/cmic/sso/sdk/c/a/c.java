package com.cmic.sso.sdk.c.a;

import android.text.TextUtils;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.c.b;

public class c implements b {
    public b a;
    public com.cmic.sso.sdk.c.d.c b;
    public final b c = new b();

    public void b(final com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final a aVar) {
        if (this.a != null) {
            AnonymousClass1 r0 = new com.cmic.sso.sdk.c.d.c() {
                public void a(com.cmic.sso.sdk.c.d.b bVar) {
                    if (bVar.d()) {
                        c.this.b(c.this.c.a(cVar, bVar, aVar), cVar2, aVar);
                    } else if (!TextUtils.isEmpty(c.this.c.a())) {
                        c.this.b(c.this.c.b(cVar, bVar, aVar), cVar2, aVar);
                    } else {
                        cVar2.a(bVar);
                    }
                }

                public void a(com.cmic.sso.sdk.c.d.a aVar) {
                    if (cVar.i()) {
                        com.cmic.sso.sdk.e.c.a("RetryAndRedirectInterceptor", "retry: " + cVar.a());
                        c.this.b(cVar, cVar2, aVar);
                        return;
                    }
                    cVar2.a(aVar);
                }
            };
            this.b = r0;
            this.a.a(cVar, r0, aVar);
        }
    }

    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
