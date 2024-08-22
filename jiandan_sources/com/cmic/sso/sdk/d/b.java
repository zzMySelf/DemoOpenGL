package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.f;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    public a a;

    public static void a(a aVar, a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.b(aVar2.b("appid", ""));
            aVar.e(m.a());
            aVar.h(aVar2.b("interfaceType", ""));
            aVar.g(aVar2.b("interfaceCode", ""));
            aVar.f(aVar2.b("interfaceElasped", ""));
            aVar.k(aVar2.b("timeOut"));
            aVar.r(aVar2.b("traceId"));
            aVar.m(aVar2.b("simCardNum"));
            aVar.n(aVar2.b("operatortype"));
            aVar.o(m.b());
            aVar.p(m.c());
            aVar.w(String.valueOf(aVar2.b("networktype", 0)));
            aVar.s(aVar2.b("starttime"));
            aVar.t(aVar2.b("endtime"));
            aVar.l(String.valueOf(aVar2.b("systemEndTime", 0) - aVar2.b("systemStartTime", 0)));
            aVar.c(aVar2.b("imsiState"));
            aVar.x(k.b("AID", ""));
            aVar.y(aVar2.b("operatortype"));
            aVar.z(aVar2.b("scripType"));
            aVar.A(aVar2.b("networkTypeByAPI"));
            c.a("SendLog", "traceId" + aVar2.b("traceId"));
        }
    }

    public void a(Context context, String str, a aVar) {
        String str2 = "";
        try {
            a a2 = aVar.a();
            String b = f.b(context);
            a2.d(str);
            a2.u(aVar.b("loginMethod", str2));
            if (aVar.b("isCacheScrip", false)) {
                a2.q("scrip");
            } else {
                a2.q("pgw");
            }
            a2.i(f.a(context));
            if (!TextUtils.isEmpty(b)) {
                str2 = b;
            }
            a2.j(str2);
            a(a2, aVar);
            JSONArray jSONArray = null;
            if (a2.a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> it = a2.a.iterator();
                while (it.hasNext()) {
                    Throwable next = it.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        stringBuffer.append(StringUtils.LF);
                        stringBuffer.append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                a2.a.clear();
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                a2.a(jSONArray);
            }
            c.a("SendLog", "登录日志");
            a(a2.b(), aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, a aVar) {
        this.a = aVar;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        com.cmic.sso.sdk.c.c.a.a().a(jSONObject, this.a, (d) new d() {
            public void a(String str, String str2, JSONObject jSONObject) {
                com.cmic.sso.sdk.a.a b = b.this.a.b();
                HashMap hashMap = new HashMap();
                if (str.equals("103000")) {
                    hashMap.put("logFailTimes", 0);
                    hashMap.put("logCloseTime", 0L);
                } else if (!(b.l() == 0 || b.k() == 0)) {
                    int a2 = k.a("logFailTimes", 0) + 1;
                    if (a2 >= b.k()) {
                        hashMap.put("logFailTimes", 0);
                        hashMap.put("logCloseTime", Long.valueOf(System.currentTimeMillis()));
                    } else {
                        hashMap.put("logFailTimes", Integer.valueOf(a2));
                    }
                }
                k.a((Map<String, Object>) hashMap);
            }
        });
    }
}
