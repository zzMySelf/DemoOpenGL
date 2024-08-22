package fe.fe.ddd.p001switch.p002if;

import android.os.Handler;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.multipath.IMultiPath;
import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import com.baidu.searchbox.http.statistics.NetworkStat;
import fe.fe.ddd.p001switch.p002if.rg;
import fe.fe.ddd.p001switch.when.qw;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.switch.if.fe  reason: invalid package */
public abstract class fe<T extends rg> {
    public int a = 0;
    public NetworkStat<Request> aaa;

    /* renamed from: ad  reason: collision with root package name */
    public Object f1583ad;
    public String b;
    public JSONObject c;
    public Dns d;
    public LogInterceptor.Level ddd;

    /* renamed from: de  reason: collision with root package name */
    public Headers f1584de;
    public int e;
    public boolean eee;
    public volatile boolean f = false;

    /* renamed from: fe  reason: collision with root package name */
    public OkHttpClient f1585fe;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f1586i = 0;

    /* renamed from: if  reason: not valid java name */
    public Request.Builder f33if;
    public CookieManager mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1587o = true;

    /* renamed from: pf  reason: collision with root package name */
    public IAsyncRequestParamsHandler f1588pf = null;
    public Proxy ppp;
    public qw qqq = null;
    public HttpUrl qw;

    /* renamed from: rg  reason: collision with root package name */
    public RequestHandler f1589rg;
    public Object rrr;

    /* renamed from: switch  reason: not valid java name */
    public Request f34switch;

    /* renamed from: th  reason: collision with root package name */
    public Handler f1590th;
    public int tt = 0;

    /* renamed from: uk  reason: collision with root package name */
    public int f1591uk = 0;
    public boolean vvv;
    public fe.fe.ddd.p001switch.qw when;
    public String xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f1592yj = 0;

    public fe(T t) {
        String str;
        fe.fe.ddd.p001switch.qw qwVar = t.f1606fe;
        this.when = qwVar;
        this.f1585fe = qwVar.pf();
        this.f1589rg = this.when.m86if();
        this.aaa = this.when.o();
        this.f1590th = this.when.yj();
        HttpUrl httpUrl = t.qw;
        this.qw = httpUrl;
        this.f1583ad = t.f1604ad;
        this.f1592yj = t.f1610rg;
        this.f1591uk = t.f1611th;
        this.f1586i = t.f1613yj;
        this.f1587o = t.f1612uk;
        this.xxx = t.f1607i;
        this.ddd = t.f1608o;
        this.nn = t.f1609pf;
        this.mmm = t.f35if;
        this.f1588pf = t.f36switch;
        this.eee = t.when;
        this.tt = t.ppp;
        this.a = t.ggg;
        this.c = t.vvv;
        this.ppp = t.xxx;
        this.vvv = t.nn;
        this.ggg = t.ddd;
        if (httpUrl != null) {
            String qw2 = fe.fe.ddd.p001switch.ppp.qw.qw();
            this.b = qw2;
            t.f1605de.add("X-Bd-Traceid", qw2);
            qw(t.f1605de);
            if (t.aaa) {
                t.f1605de.add("bdapp-support-brotli", "1");
            }
            IMultiPath iMultiPath = fe.fe.ddd.p001switch.o.qw.qw;
            if (!(iMultiPath == null || iMultiPath.qw() == null || !iMultiPath.qw().contains(Integer.valueOf(this.tt)))) {
                String str2 = t.rrr;
                if (str2 != null) {
                    t.fe(str2);
                } else {
                    t.fe("1");
                }
            }
            if (t.eee && (str = t.rrr) != null) {
                t.f1605de.add("X-Bind-Mobile", str);
                String str3 = t.rrr;
            }
            this.f1584de = t.f1605de.build();
            if (this.eee) {
                qw qwVar2 = new qw();
                this.qqq = qwVar2;
                qwVar2.eee = this.qw.toString();
                qw qwVar3 = this.qqq;
                qwVar3.t = t.ppp;
                qwVar3.u = t.ggg;
            }
            this.d = t.mmm;
            this.e = t.qqq;
            ppp(t);
            return;
        }
        throw new IllegalArgumentException(" url not set, please check");
    }

    public abstract Request ad(RequestBody requestBody);

    public abstract RequestBody de();

    public <T> Cancelable fe(fe.fe.ddd.p001switch.rg.qw<T> qwVar) {
        pf pfVar = new pf(this);
        pfVar.when(qwVar);
        return pfVar;
    }

    public boolean ggg() {
        IHttpContext qw2 = fe.fe.ddd.p001switch.fe.qw();
        if (qw2 == null) {
            return false;
        }
        return qw2.ggg(this.qw.host(), this.tt, this.f1584de);
    }

    public JSONObject i() {
        return this.c;
    }

    /* renamed from: if  reason: not valid java name */
    public qw m80if() {
        return this.qqq;
    }

    public Request o() {
        return this.f34switch;
    }

    public int pf() {
        return this.tt;
    }

    public final void ppp(T t) {
        Request.Builder builder = new Request.Builder();
        this.f33if = builder;
        builder.url(this.qw);
        Object obj = this.f1583ad;
        this.rrr = obj;
        if (obj != null) {
            this.f33if.tag(obj);
        }
        if (this.aaa != null || this.eee) {
            this.f33if.tag(this);
        }
        Headers headers = this.f1584de;
        if (headers != null && headers.size() > 0) {
            this.f33if.headers(this.f1584de);
        }
        when(t);
        this.f34switch = ad(de());
    }

    public final void qw(Headers.Builder builder) {
        IHttpContext qw2;
        fe.fe.ddd.p001switch.i.qw fe2;
        if (builder != null && (qw2 = fe.fe.ddd.p001switch.fe.qw()) != null && (fe2 = qw2.fe()) != null && fe2.rg() && fe2.fe() != null && fe2.fe().size() > 0 && fe2.fe().contains(Integer.valueOf(pf()))) {
            int qw3 = fe2.qw();
            int de2 = fe2.de();
            int ad2 = fe2.ad();
            if (qw3 > 0 && ad2 > 0 && de2 > 0) {
                builder.add("Multiple-Connect-Num", String.valueOf(qw3));
                if (this.when.ppp()) {
                    builder.add("Multiple-Connect-Delay-Time", String.valueOf(de2));
                } else {
                    builder.add("Multiple-Connect-Delay-Time", String.valueOf(ad2));
                }
            }
        }
    }

    public Response rg() throws IOException {
        return new pf(this).vvv();
    }

    /* renamed from: switch  reason: not valid java name */
    public int m81switch() {
        return this.a;
    }

    public String th() {
        return this.b;
    }

    public Dns uk() {
        return this.d;
    }

    public abstract void when(T t);

    public long yj() {
        try {
            return this.f34switch.body().contentLength();
        } catch (IOException unused) {
            return 0;
        }
    }
}
