package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.c.b.d;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.c.c;
import com.cmic.sso.sdk.e.q;
import java.util.List;
import java.util.Map;

public class b {
    public String a;
    public String b;

    public c a(c cVar, com.cmic.sso.sdk.c.d.b bVar, a aVar) {
        List list;
        Map<String, List<String>> b2 = bVar.b();
        if (TextUtils.isEmpty(this.a) && (list = b2.get("pplocation")) != null && list.size() > 0) {
            this.a = (String) list.get(0);
        }
        q.b(aVar, String.valueOf(bVar.a()));
        List list2 = b2.get("Location");
        if (list2 == null || list2.isEmpty()) {
            list2 = b2.get("Location".toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            String str = (String) list2.get(0);
            this.b = str;
            if (!TextUtils.isEmpty(str)) {
                String b3 = aVar.b("operatortype", "0");
                if ("2".equals(b3)) {
                    q.a(aVar, "getUnicomMobile");
                } else if ("3".equals(b3)) {
                    q.a(aVar, "getTelecomMobile");
                } else {
                    q.a(aVar, "NONE");
                }
            }
        }
        com.cmic.sso.sdk.e.c.b("Location", this.b);
        c a2 = a(this.b, cVar.f(), ShareTarget.METHOD_GET, new com.cmic.sso.sdk.c.b.c(cVar.j().a()));
        a2.a(cVar.g());
        return a2;
    }

    public c b(c cVar, com.cmic.sso.sdk.c.d.b bVar, a aVar) {
        String b2 = aVar.b("operatortype", "0");
        if ("2".equals(b2)) {
            q.a(aVar, "getNewUnicomPhoneNumberNotify");
        } else if ("3".equals(b2)) {
            q.a(aVar, "getNewTelecomPhoneNumberNotify");
        } else {
            q.a(aVar, "NONE");
        }
        q.b(aVar, String.valueOf(bVar.a()));
        d dVar = new d(cVar.j().a(), "1.0", bVar.c());
        dVar.c(aVar.b("userCapaid"));
        if (aVar.c("logintype") == 3) {
            dVar.b("pre");
        } else if (aVar.b("isRisk", false)) {
            dVar.b("pre");
        } else {
            dVar.b("authz");
        }
        c a2 = a(this.a, cVar.f(), "POST", dVar);
        a2.a(cVar.g());
        this.a = null;
        return a2;
    }

    private c a(String str, String str2, String str3, g gVar) {
        c cVar = new c(str, gVar, str3, str2);
        if (str3.equals(ShareTarget.METHOD_GET)) {
            cVar.a("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        }
        return cVar;
    }

    public String a() {
        return this.a;
    }
}
