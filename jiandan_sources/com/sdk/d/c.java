package com.sdk.d;

import android.os.Process;
import android.os.SystemClock;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.a.h;
import com.sdk.d.e;
import com.sdk.o.a;
import com.sdk.o.b;
import java.net.HttpURLConnection;

public class c extends e.c<Params, Result> {
    public final /* synthetic */ e b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super((c) null);
        this.b = eVar;
    }

    public Result call() {
        this.b.f.set(true);
        Process.setThreadPriority(10);
        e eVar = this.b;
        Params[] paramsArr = this.a;
        com.sdk.a.e eVar2 = (com.sdk.a.e) eVar;
        if (!(eVar2.p == e.a.CANCELLED || paramsArr == null || paramsArr.length == 0)) {
            if (paramsArr.length == 4) {
                String valueOf = String.valueOf(paramsArr[1]);
                eVar2.t = valueOf;
                eVar2.u = valueOf != null;
                eVar2.v = (Boolean) paramsArr[2];
                eVar2.w = (Boolean) paramsArr[3];
            }
            if (paramsArr.length == 2) {
                eVar2.x = (Boolean) paramsArr[1];
            }
            try {
                eVar2.s = SystemClock.uptimeMillis();
                eVar2.a((Progress[]) new Object[]{1});
                f fVar = (f) paramsArr[0];
                String a = fVar.a();
                eVar2.f6811o = a;
                HttpURLConnection a2 = fVar.a(a, false);
                if (a2 == null) {
                    eVar2.a((Progress[]) new Object[]{4, new h(0, eVar2.b(), false)});
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("client: ");
                    sb.append(a2);
                    sb.toString();
                    h b2 = eVar2.b(fVar, a2);
                    if (b2.a() == 0) {
                        eVar2.a((Progress[]) new Object[]{4, b2});
                    } else {
                        eVar2.a((Progress[]) new Object[]{3, Integer.valueOf(b2.a()), b2.b()});
                    }
                }
            } catch (Exception e) {
                b.c(e.toString());
                a.a("PriorityAsyncTask", "HttpHandler：doInBackground\n" + e.toString(), eVar2.h);
                eVar2.a((Progress[]) new Object[]{3, 302002, "网络访问异常"});
            }
        }
        return eVar.a(null);
    }
}
