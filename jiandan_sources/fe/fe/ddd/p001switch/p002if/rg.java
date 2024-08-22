package fe.fe.ddd.p001switch.p002if;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.multipath.IMultiPath;
import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import fe.fe.ddd.p001switch.fe;
import fe.fe.ddd.p001switch.p002if.rg;
import fe.fe.ddd.p001switch.qw;
import java.net.Proxy;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.switch.if.rg  reason: invalid package */
public abstract class rg<T extends rg> {
    public boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public Object f1604ad;
    public boolean ddd = true;

    /* renamed from: de  reason: collision with root package name */
    public Headers.Builder f1605de;
    public boolean eee;

    /* renamed from: fe  reason: collision with root package name */
    public qw f1606fe;
    public int ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f1607i = null;

    /* renamed from: if  reason: not valid java name */
    public CookieManager f35if;
    public Dns mmm;
    public boolean nn = true;

    /* renamed from: o  reason: collision with root package name */
    public LogInterceptor.Level f1608o = null;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f1609pf = false;
    public int ppp = 0;
    public int qqq;
    public HttpUrl qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f1610rg;
    public String rrr;

    /* renamed from: switch  reason: not valid java name */
    public IAsyncRequestParamsHandler f36switch;

    /* renamed from: th  reason: collision with root package name */
    public int f1611th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f1612uk = true;
    public JSONObject vvv;
    public boolean when;
    public Proxy xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f1613yj;

    public rg(qw qwVar) {
        this.f1606fe = qwVar;
        this.f1605de = new Headers.Builder();
    }

    public abstract fe ad();

    public T de(CookieManager cookieManager) {
        this.f35if = cookieManager;
        return this;
    }

    public T fe(String str) {
        IMultiPath iMultiPath = fe.fe.ddd.p001switch.o.qw.qw;
        if (iMultiPath != null && iMultiPath.ad() && rg()) {
            this.eee = true;
            this.rrr = str;
        }
        return this;
    }

    public T qw(String str, String str2) {
        this.f1605de.add(str, str2);
        return this;
    }

    public final boolean rg() {
        int i2 = this.ppp;
        return i2 == 1 || i2 == 14 || i2 == 2;
    }

    public T th(int i2) {
        this.ppp = i2;
        return this;
    }

    public T uk(String str) {
        if (str != null) {
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                this.qw = parse;
                return this;
            }
            fe.fe.ddd.p001switch.when.qw qwVar = new fe.fe.ddd.p001switch.when.qw();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unexpected url: " + str);
            qwVar.nn = illegalArgumentException;
            fe.qw().uk(qwVar.rg());
            throw illegalArgumentException;
        }
        throw new NullPointerException("url == null");
    }

    public T yj(int i2) {
        this.ggg = i2;
        return this;
    }
}
