package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.p;

public class b extends c {
    public final e b;
    public boolean c = false;

    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.b = eVar;
    }

    public void a(a aVar) {
        com.cmic.sso.sdk.c.b.a c2 = this.b.c();
        c2.u(aVar.b("socketip"));
        c.b("GetPrePhonescripParam", "socket socketip = " + aVar.b("socketip"));
        if (!this.c) {
            String[] strArr = null;
            if (!aVar.b("isCloseIpv4", false)) {
                strArr = p.a(true);
                c2.q(strArr[0]);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                if (strArr == null) {
                    strArr = p.a(true);
                }
                c2.r(strArr[1]);
            }
            this.c = true;
        }
        c2.n(c2.v(aVar.b(com.alipay.sdk.m.s.a.r)));
        this.b.a(c2);
        this.b.a(true);
        this.a = this.b.b().toString();
    }
}
