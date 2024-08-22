package com.cmic.sso.sdk.c.c;

import android.os.SystemClock;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.a.d;
import com.cmic.sso.sdk.c.b.b;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.f;
import com.cmic.sso.sdk.c.b.h;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.i;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import org.json.JSONObject;

public class a {
    public static a a;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        b bVar = new b();
        bVar.b("1.0");
        bVar.c("Android");
        bVar.d(k.b("AID", ""));
        bVar.e(z ? "1" : "0");
        bVar.f(AuthnHelper.SDK_VERSION);
        bVar.g(aVar.b("appid"));
        bVar.h(bVar.v("iYm0HAnkxQtpvN44"));
        com.cmic.sso.sdk.a.a b = aVar.b();
        a(new c("https://" + b.c() + "/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        c cVar;
        String str;
        com.cmic.sso.sdk.a aVar2 = aVar;
        int c = aVar2.c("networktype");
        h hVar = new h();
        hVar.b("1.0");
        hVar.c(AuthnHelper.SDK_VERSION);
        hVar.d(aVar2.b("appid"));
        hVar.e(aVar2.b("operatortype"));
        hVar.f(c + "");
        hVar.g(m.a());
        hVar.h(m.b());
        hVar.i(m.c());
        hVar.j("0");
        hVar.k("3.0");
        hVar.l(q.b());
        hVar.m(o.a());
        hVar.o(aVar2.b("apppackage"));
        hVar.p(aVar2.b("appsign"));
        hVar.a(k.b("AID", ""));
        if (aVar2.c("logintype") == 3 || aVar2.b("isRisk", false)) {
            hVar.s("pre");
        } else {
            hVar.x(aVar2.b("userCapaid"));
            if (aVar2.c("logintype") == 1) {
                hVar.x("200");
            } else {
                hVar.x("50");
            }
            hVar.s("authz");
        }
        q.a(aVar2, "scripAndTokenForHttps");
        com.cmic.sso.sdk.a.a b = aVar.b();
        if (aVar2.b("isCacheScrip", false) || aVar2.b("isGotScrip", false)) {
            hVar.w(aVar2.b("phonescrip"));
            hVar.n(hVar.v(aVar2.b(com.alipay.sdk.m.s.a.r)));
            cVar = new c("https://" + b.a() + "/unisdk/rs/scripAndTokenForHttps", hVar, "POST", aVar2.b("traceId"));
            cVar.a("defendEOF", "0");
        } else {
            e eVar = new e();
            eVar.a(aVar2.a(b.a.a));
            eVar.b(aVar2.a(b.a.b));
            eVar.a((com.cmic.sso.sdk.c.b.a) hVar);
            eVar.a(false);
            aVar2.a("isCloseIpv4", b.h());
            aVar2.a("isCloseIpv6", b.i());
            String str2 = "https://" + b.b() + "/unisdk/rs/scripAndTokenForHttps";
            if (aVar2.b("use2048PublicKey", false)) {
                c.a("BaseRequest", "使用2对应的编码");
                eVar.b("2");
                str = i.a().b(aVar2.a(b.a.a));
            } else {
                str = i.a().a(aVar2.a(b.a.a));
            }
            eVar.c(str);
            cVar = new b(str2, eVar, "POST", aVar2.b("traceId"));
            cVar.a("defendEOF", "1");
            if (c == 3) {
                cVar.a(true);
                aVar2.a("doNetworkSwitch", true);
            } else {
                cVar.a(false);
                aVar2.a("doNetworkSwitch", false);
            }
        }
        cVar.a("interfaceVersion", "3.0");
        a(cVar, dVar, aVar2);
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        f fVar = new f();
        f.a aVar2 = new f.a();
        f.b bVar = new f.b();
        bVar.e(q.b());
        bVar.f(o.a());
        bVar.b("2.0");
        bVar.c(aVar.b("appid", ""));
        bVar.d(bVar.v(""));
        aVar2.a(jSONObject);
        fVar.a(aVar2);
        fVar.a(bVar);
        com.cmic.sso.sdk.a.a b = aVar.b();
        a(new c("https://" + b.d() + "/log/logReport", fVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    private void a(final c cVar, final d dVar, final com.cmic.sso.sdk.a aVar) {
        d dVar2 = new d();
        com.cmic.sso.sdk.c.a.c cVar2 = new com.cmic.sso.sdk.c.a.c();
        com.cmic.sso.sdk.c.a.a aVar2 = new com.cmic.sso.sdk.c.a.a();
        dVar2.a(cVar2);
        cVar2.a((com.cmic.sso.sdk.c.a.b) aVar2);
        cVar.a(SystemClock.elapsedRealtime());
        dVar2.a(cVar, new com.cmic.sso.sdk.c.d.c() {
            public void a(com.cmic.sso.sdk.c.d.b bVar) {
                String str;
                try {
                    a();
                    JSONObject jSONObject = new JSONObject(bVar.c());
                    if (jSONObject.has("resultcode")) {
                        str = jSONObject.getString("resultcode");
                    } else {
                        str = jSONObject.getString("resultCode");
                    }
                    q.b(aVar, str);
                    dVar.a(str, jSONObject.optString("desc"), jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                    a(com.cmic.sso.sdk.c.d.a.a(102223));
                }
            }

            public void a(com.cmic.sso.sdk.c.d.a aVar) {
                a();
                q.b(aVar, String.valueOf(aVar.a()));
                dVar.a(String.valueOf(aVar.a()), aVar.b(), com.cmic.sso.sdk.auth.c.a(String.valueOf(aVar.a()), aVar.b()));
            }

            private void a() {
                if (!cVar.a().contains("uniConfig")) {
                    q.c(aVar, String.valueOf(SystemClock.elapsedRealtime() - cVar.h()));
                }
            }
        }, aVar);
    }
}
