package fe.th.de;

import com.alipay.sdk.m.m.a;
import com.duxiaoman.okhttp3.Authenticator;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.CookieJar;
import com.duxiaoman.okhttp3.Dns;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.WebSocket;
import com.duxiaoman.okhttp3.internal.cache.InternalCache;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.p019if.yj;
import fe.th.de.rrr.when.de;
import fe.th.de.rrr.yj.th;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;

public class ggg implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final List<Protocol> p = fe.mmm(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List<yj> q = fe.mmm(yj.f5574yj, yj.f5573uk);
    public static int r = 300;
    public static boolean s = false;
    public static boolean t = false;
    public final HostnameVerifier aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final int f5158ad;
    public final SocketFactory ddd;
    public final Dns e;
    public final Authenticator eee;
    public final boolean f;
    public final boolean g;
    public final CookieJar ggg;
    public final boolean h;

    /* renamed from: i  reason: collision with root package name */
    public final Proxy f5159i;

    /* renamed from: if  reason: not valid java name */
    public final List<Interceptor> f201if;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final de mmm;
    public final int n;
    public final SSLSocketFactory nn;

    /* renamed from: o  reason: collision with root package name */
    public final List<Protocol> f5160o;

    /* renamed from: pf  reason: collision with root package name */
    public final List<yj> f5161pf;
    public final ProxySelector ppp;
    public final fe qqq;
    public final Authenticator rrr;

    /* renamed from: switch  reason: not valid java name */
    public final List<Interceptor> f202switch;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f5162th;
    public final th tt;

    /* renamed from: uk  reason: collision with root package name */
    public final i f5163uk;
    public final ad vvv;
    public final EventListener.Factory when;
    public final InternalCache xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f5164yj;

    public class qw extends fe.th.de.rrr.qw {
        public void ad(pf.qw qwVar, String str, String str2) {
            qwVar.de(str, str2);
        }

        public void de(yj yjVar, SSLSocket sSLSocket, boolean z) {
            yjVar.qw(sSLSocket, z);
        }

        public int fe(mmm.qw qwVar) {
            return qwVar.f5204de;
        }

        public boolean i(IllegalArgumentException illegalArgumentException) {
            return illegalArgumentException.getMessage().startsWith(HttpUrl.Builder.INVALID_HOST);
        }

        /* renamed from: if  reason: not valid java name */
        public IOException m337if(Call call, IOException iOException) {
            return ((xxx) call).uk(iOException);
        }

        public void o(th thVar, fe.th.de.rrr.yj.de deVar) {
            thVar.th(deVar);
        }

        public fe.th.de.rrr.yj.fe pf(th thVar) {
            return thVar.f5534rg;
        }

        public void qw(pf.qw qwVar, String str) {
            qwVar.ad(str);
        }

        public boolean rg(th thVar, fe.th.de.rrr.yj.de deVar) {
            return thVar.ad(deVar);
        }

        public Socket th(th thVar, qw qwVar, th thVar2) {
            return thVar.de(qwVar, thVar2);
        }

        public fe.th.de.rrr.yj.de uk(th thVar, qw qwVar, th thVar2, qqq qqq) {
            return thVar.fe(qwVar, thVar2, qqq);
        }

        public boolean yj(qw qwVar, qw qwVar2) {
            return qwVar.fe(qwVar2);
        }
    }

    static {
        fe.th.de.rrr.qw.qw = new qw();
    }

    public ggg() {
        this(new ad());
    }

    public static SSLSocketFactory aaa(X509TrustManager x509TrustManager) {
        try {
            SSLContext ppp2 = yj.m350switch().ppp();
            ppp2.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return ppp2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw fe.ad("No System TLS", e2);
        }
    }

    public ProxySelector a() {
        return this.ppp;
    }

    public Authenticator ad() {
        return this.rrr;
    }

    public int b() {
        return this.l;
    }

    public boolean c() {
        return this.h;
    }

    public SocketFactory d() {
        return this.ddd;
    }

    public List<Interceptor> ddd() {
        return this.f202switch;
    }

    public int de() {
        return this.j;
    }

    public SSLSocketFactory e() {
        return this.nn;
    }

    public List<Protocol> eee() {
        return this.f5160o;
    }

    public int f() {
        return this.m;
    }

    public fe fe() {
        return this.qqq;
    }

    public List<Interceptor> ggg() {
        return this.f201if;
    }

    public i i() {
        return this.f5163uk;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m333if() {
        return this.g;
    }

    public Call mmm(ddd ddd2) {
        return xxx.th(this, ddd2, false);
    }

    public ad nn() {
        return new ad(this);
    }

    public Dns o() {
        return this.e;
    }

    public EventListener.Factory pf() {
        return this.when;
    }

    public HostnameVerifier ppp() {
        return this.aaa;
    }

    public int qqq() {
        return this.n;
    }

    public int rg() {
        return this.k;
    }

    public Proxy rrr() {
        return this.f5159i;
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m334switch() {
        return this.f;
    }

    public th th() {
        return this.tt;
    }

    public Authenticator tt() {
        return this.eee;
    }

    public CookieJar uk() {
        return this.ggg;
    }

    public InternalCache vvv() {
        ad adVar = this.vvv;
        return adVar != null ? adVar.f5124ad : this.xxx;
    }

    public int when() {
        return this.f5158ad;
    }

    public boolean xxx() {
        return this.f5162th;
    }

    public List<yj> yj() {
        return this.f5161pf;
    }

    public ggg(ad adVar) {
        boolean z;
        this.f5163uk = adVar.qw;
        this.f5159i = adVar.f5165ad;
        this.f5160o = adVar.f5166de;
        this.f5161pf = adVar.f5167fe;
        this.f201if = fe.nn(adVar.f5171rg);
        this.f202switch = fe.nn(adVar.f5172th);
        this.when = adVar.f5174yj;
        this.ppp = adVar.f5173uk;
        this.ggg = adVar.f5168i;
        this.vvv = adVar.f5169o;
        this.xxx = adVar.f5170pf;
        this.ddd = adVar.f203if;
        Iterator<yj> it = this.f5161pf.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                yj next = it.next();
                if (z || next.fe()) {
                    z = true;
                }
            }
        }
        if (adVar.f204switch != null || !z) {
            this.nn = adVar.f204switch;
            this.mmm = adVar.when;
        } else {
            X509TrustManager c = fe.c();
            this.nn = aaa(c);
            this.mmm = de.ad(c);
        }
        if (this.nn != null) {
            yj.m350switch().yj(this.nn);
        }
        this.aaa = adVar.ppp;
        this.qqq = adVar.ggg.th(this.mmm);
        this.eee = adVar.vvv;
        this.rrr = adVar.xxx;
        this.tt = adVar.ddd;
        this.e = adVar.nn;
        this.f = adVar.mmm;
        this.g = adVar.aaa;
        this.h = adVar.qqq;
        this.j = adVar.eee;
        this.k = adVar.rrr;
        this.l = adVar.tt;
        this.m = adVar.a;
        this.n = adVar.b;
        this.f5158ad = adVar.c;
        this.f5162th = adVar.d;
        this.f5164yj = adVar.e;
        if (this.f201if.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f201if);
        } else if (this.f202switch.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f202switch);
        }
    }

    public static final class ad {
        public int a;
        public boolean aaa;

        /* renamed from: ad  reason: collision with root package name */
        public Proxy f5165ad;
        public int b;
        public int c;
        public boolean d;
        public th ddd;

        /* renamed from: de  reason: collision with root package name */
        public List<Protocol> f5166de;
        public boolean e;
        public int eee;

        /* renamed from: fe  reason: collision with root package name */
        public List<yj> f5167fe;
        public fe ggg;

        /* renamed from: i  reason: collision with root package name */
        public CookieJar f5168i;

        /* renamed from: if  reason: not valid java name */
        public SocketFactory f203if;
        public boolean mmm;
        public Dns nn;

        /* renamed from: o  reason: collision with root package name */
        public ad f5169o;

        /* renamed from: pf  reason: collision with root package name */
        public InternalCache f5170pf;
        public HostnameVerifier ppp;
        public boolean qqq;
        public i qw;

        /* renamed from: rg  reason: collision with root package name */
        public final List<Interceptor> f5171rg;
        public int rrr;

        /* renamed from: switch  reason: not valid java name */
        public SSLSocketFactory f204switch;

        /* renamed from: th  reason: collision with root package name */
        public final List<Interceptor> f5172th;
        public int tt;

        /* renamed from: uk  reason: collision with root package name */
        public ProxySelector f5173uk;
        public Authenticator vvv;
        public de when;
        public Authenticator xxx;

        /* renamed from: yj  reason: collision with root package name */
        public EventListener.Factory f5174yj;

        public ad() {
            this.f5171rg = new ArrayList();
            this.f5172th = new ArrayList();
            this.qw = new i();
            this.f5166de = ggg.p;
            this.f5167fe = ggg.q;
            this.f5174yj = EventListener.factory(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f5173uk = proxySelector;
            if (proxySelector == null) {
                this.f5173uk = new fe.th.de.rrr.p020switch.qw();
            }
            this.f5168i = CookieJar.qw;
            this.f203if = SocketFactory.getDefault();
            this.ppp = fe.th.de.rrr.when.fe.qw;
            this.ggg = fe.f5153de;
            Authenticator authenticator = Authenticator.qw;
            this.vvv = authenticator;
            this.xxx = authenticator;
            this.ddd = new th();
            this.nn = Dns.qw;
            this.mmm = true;
            this.aaa = true;
            this.qqq = true;
            this.eee = 0;
            this.rrr = 10000;
            this.tt = 10000;
            this.a = 10000;
            this.b = 0;
            this.c = ggg.r;
            this.d = ggg.s;
            this.e = ggg.t;
        }

        public ggg ad() {
            return new ggg(this);
        }

        public ad de(ad adVar) {
            this.f5169o = adVar;
            this.f5170pf = null;
            return this;
        }

        public ad fe(long j, TimeUnit timeUnit) {
            this.rrr = fe.rg(a.Z, j, timeUnit);
            return this;
        }

        public ad ggg(long j, TimeUnit timeUnit) {
            this.tt = fe.rg(a.Z, j, timeUnit);
            return this;
        }

        public ad i(boolean z) {
            this.e = z;
            eee.qw = z;
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public ad m335if(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.ppp = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public ad o(EventListener.Factory factory) {
            if (factory != null) {
                this.f5174yj = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public ad pf(boolean z) {
            this.aaa = z;
            return this;
        }

        public ad ppp(Proxy proxy) {
            this.f5165ad = proxy;
            return this;
        }

        public ad qw(Interceptor interceptor) {
            if (interceptor != null) {
                this.f5171rg.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public ad rg(int i2) {
            this.c = i2;
            return this;
        }

        /* renamed from: switch  reason: not valid java name */
        public List<Interceptor> m336switch() {
            return this.f5171rg;
        }

        public ad th(CookieJar cookieJar) {
            if (cookieJar != null) {
                this.f5168i = cookieJar;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        public ad uk(boolean z) {
            this.d = z;
            return this;
        }

        public ad vvv(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.f204switch = sSLSocketFactory;
                this.when = yj.m350switch().de(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public List<Interceptor> when() {
            return this.f5172th;
        }

        public ad yj(i iVar) {
            if (iVar != null) {
                this.qw = iVar;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public ad(ggg ggg2) {
            this.f5171rg = new ArrayList();
            this.f5172th = new ArrayList();
            this.qw = ggg2.f5163uk;
            this.f5165ad = ggg2.f5159i;
            this.f5166de = ggg2.f5160o;
            this.f5167fe = ggg2.f5161pf;
            this.f5171rg.addAll(ggg2.f201if);
            this.f5172th.addAll(ggg2.f202switch);
            this.f5174yj = ggg2.when;
            this.f5173uk = ggg2.ppp;
            this.f5168i = ggg2.ggg;
            this.f5170pf = ggg2.xxx;
            this.f5169o = ggg2.vvv;
            this.f203if = ggg2.ddd;
            this.f204switch = ggg2.nn;
            this.when = ggg2.mmm;
            this.ppp = ggg2.aaa;
            this.ggg = ggg2.qqq;
            this.vvv = ggg2.eee;
            this.xxx = ggg2.rrr;
            this.ddd = ggg2.tt;
            this.nn = ggg2.e;
            this.mmm = ggg2.f;
            this.aaa = ggg2.g;
            this.qqq = ggg2.h;
            this.eee = ggg2.j;
            this.rrr = ggg2.k;
            this.tt = ggg2.l;
            this.a = ggg2.m;
            this.b = ggg2.n;
            this.c = ggg2.f5158ad;
            this.d = ggg2.f5162th;
            this.e = ggg2.f5164yj;
        }
    }
}
