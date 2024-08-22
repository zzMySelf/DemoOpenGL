package fe.th.de;

import com.alipay.sdk.m.n.a;
import com.duxiaoman.okhttp3.CookieJar;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.p019if.yj;
import fe.th.de.uk;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: fe.th.de.switch  reason: invalid class name */
public final class Cswitch implements CookieJar {

    /* renamed from: ad  reason: collision with root package name */
    public final CookieHandler f5529ad;

    public Cswitch(CookieHandler cookieHandler) {
        this.f5529ad = cookieHandler;
    }

    public void ad(Cif ifVar, List<uk> list) {
        if (this.f5529ad != null) {
            ArrayList arrayList = new ArrayList();
            for (uk o2 : list) {
                arrayList.add(o2.o(true));
            }
            try {
                this.f5529ad.put(ifVar.c(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (IOException e) {
                yj yjVar = yj.m350switch();
                yjVar.mmm(5, "Saving cookies failed for " + ifVar.a("/..."), e);
            }
        }
    }

    public final List<uk> de(Cif ifVar, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int ppp = fe.ppp(str, i2, length, ";,");
            int when = fe.when(str, i2, ppp, a.h);
            String j = fe.j(str, i2, when);
            if (!j.startsWith("$")) {
                String j2 = when < ppp ? fe.j(str, when + 1, ppp) : "";
                if (j2.startsWith("\"") && j2.endsWith("\"")) {
                    j2 = j2.substring(1, j2.length() - 1);
                }
                uk.qw qwVar = new uk.qw();
                qwVar.fe(j);
                qwVar.rg(j2);
                qwVar.ad(ifVar.m338if());
                arrayList.add(qwVar.qw());
            }
            i2 = ppp + 1;
        }
        return arrayList;
    }

    public List<uk> qw(Cif ifVar) {
        try {
            ArrayList arrayList = null;
            for (Map.Entry next : this.f5529ad.get(ifVar.c(), Collections.emptyMap()).entrySet()) {
                String str = (String) next.getKey();
                if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) next.getValue()).isEmpty()) {
                    for (String str2 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(de(ifVar, str2));
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException e) {
            yj yjVar = yj.m350switch();
            yjVar.mmm(5, "Loading cookies failed for " + ifVar.a("/..."), e);
            return Collections.emptyList();
        }
    }
}
