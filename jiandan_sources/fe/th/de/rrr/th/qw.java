package fe.th.de.rrr.th;

import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.cache.CacheRequest;
import com.duxiaoman.okhttp3.internal.cache.InternalCache;
import com.google.common.net.HttpHeaders;
import fe.th.de.aaa;
import fe.th.de.ddd;
import fe.th.de.eee;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.th.ad;
import fe.th.de.rrr.uk.rg;
import fe.th.de.rrr.uk.yj;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class qw implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static String f5461ad = "CacheInterceptor";
    public final InternalCache qw;

    /* renamed from: fe.th.de.rrr.th.qw$qw  reason: collision with other inner class name */
    public class C0227qw implements Source {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f5462ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ BufferedSource f5463th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f5464uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ CacheRequest f5465yj;

        public C0227qw(qw qwVar, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f5463th = bufferedSource;
            this.f5465yj = cacheRequest;
            this.f5464uk = bufferedSink;
        }

        public void close() throws IOException {
            if (!this.f5462ad && !fe.ggg(this, 100, TimeUnit.MILLISECONDS)) {
                this.f5462ad = true;
                this.f5465yj.abort();
            }
            this.f5463th.close();
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = this.f5463th.read(buffer, j);
                if (read == -1) {
                    if (!this.f5462ad) {
                        this.f5462ad = true;
                        this.f5464uk.close();
                    }
                    return -1;
                }
                buffer.copyTo(this.f5464uk.buffer(), buffer.size() - read, read);
                this.f5464uk.emitCompleteSegments();
                return read;
            } catch (IOException e) {
                if (!this.f5462ad) {
                    this.f5462ad = true;
                    this.f5465yj.abort();
                }
                throw e;
            }
        }

        public Timeout timeout() {
            return this.f5463th.timeout();
        }
    }

    public qw(InternalCache internalCache) {
        this.qw = internalCache;
    }

    public static pf ad(pf pfVar, pf pfVar2) {
        pf.qw qwVar = new pf.qw();
        int yj2 = pfVar.yj();
        for (int i2 = 0; i2 < yj2; i2++) {
            String rg2 = pfVar.rg(i2);
            String uk2 = pfVar.uk(i2);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(rg2) || !uk2.startsWith("1")) && (de(rg2) || !fe(rg2) || pfVar2.de(rg2) == null)) {
                fe.th.de.rrr.qw.qw.ad(qwVar, rg2, uk2);
            }
        }
        int yj3 = pfVar2.yj();
        for (int i3 = 0; i3 < yj3; i3++) {
            String rg3 = pfVar2.rg(i3);
            if (!de(rg3) && fe(rg3)) {
                fe.th.de.rrr.qw.qw.ad(qwVar, rg3, pfVar2.uk(i3));
            }
        }
        return qwVar.rg();
    }

    public static boolean de(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean fe(String str) {
        return !HttpHeaders.CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !HttpHeaders.TE.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !HttpHeaders.UPGRADE.equalsIgnoreCase(str);
    }

    public static void rg(String str, ddd ddd, String str2) {
        eee.qw(str, ddd, str2, f5461ad);
    }

    public static mmm th(mmm mmm) {
        if (mmm == null || mmm.qw() == null) {
            return mmm;
        }
        mmm.qw ggg = mmm.ggg();
        ggg.ad((aaa) null);
        return ggg.de();
    }

    public mmm intercept(Interceptor.Chain chain) throws IOException {
        ddd request = chain.request();
        InternalCache internalCache = this.qw;
        mmm fe2 = internalCache != null ? internalCache.fe(chain.request()) : null;
        ad de2 = new ad.qw(System.currentTimeMillis(), chain.request(), fe2).de();
        ddd ddd = de2.qw;
        mmm mmm = de2.f5450ad;
        StringBuilder sb = new StringBuilder();
        sb.append("cache is null:: ");
        boolean z = true;
        sb.append(this.qw == null);
        rg(sb.toString(), request, "intercept");
        InternalCache internalCache2 = this.qw;
        if (internalCache2 != null) {
            internalCache2.qw(de2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cacheCandidate is null:: ");
        sb2.append(fe2 == null);
        sb2.append("  cacheResponse is null:: ");
        sb2.append(mmm == null);
        rg(sb2.toString(), request, "intercept");
        if (fe2 != null && mmm == null) {
            fe.yj(fe2.qw());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("networkRequest is null:: ");
        sb3.append(ddd == null);
        sb3.append("  cacheResponse is null:: ");
        sb3.append(mmm == null);
        rg(sb3.toString(), request, "intercept");
        if (ddd == null && mmm == null) {
            mmm.qw qwVar = new mmm.qw();
            qwVar.ggg(chain.request());
            qwVar.when(Protocol.HTTP_1_1);
            qwVar.yj(504);
            qwVar.pf("Unsatisfiable Request (only-if-cached)");
            qwVar.ad(fe.f5255de);
            qwVar.vvv(-1);
            qwVar.ppp(System.currentTimeMillis());
            return qwVar.de();
        } else if (ddd == null) {
            mmm.qw ggg = mmm.ggg();
            ggg.fe(th(mmm));
            return ggg.de();
        } else {
            try {
                mmm qw2 = chain.qw(ddd);
                if (qw2 == null && fe2 != null) {
                }
                if (mmm != null) {
                    if (qw2.rg() == 304) {
                        mmm.qw ggg2 = mmm.ggg();
                        ggg2.o(ad(mmm.pf(), qw2.pf()));
                        ggg2.vvv(qw2.mmm());
                        ggg2.ppp(qw2.ddd());
                        ggg2.fe(th(mmm));
                        ggg2.m343if(th(qw2));
                        mmm de3 = ggg2.de();
                        qw2.qw().close();
                        this.qw.trackConditionalCacheHit();
                        this.qw.rg(mmm, de3);
                        return de3;
                    }
                    fe.yj(mmm.qw());
                }
                mmm.qw ggg3 = qw2.ggg();
                ggg3.fe(th(mmm));
                ggg3.m343if(th(qw2));
                mmm de4 = ggg3.de();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("cache is null::");
                if (this.qw != null) {
                    z = false;
                }
                sb4.append(z);
                rg(sb4.toString(), request, "intercept");
                if (this.qw != null) {
                    if (fe.th.de.rrr.uk.fe.de(de4) && ad.qw(de4, ddd)) {
                        return qw(this.qw.ad(de4), de4);
                    }
                    if (rg.qw(ddd.th())) {
                        try {
                            this.qw.de(ddd);
                        } catch (IOException unused) {
                        }
                    }
                }
                return de4;
            } finally {
                if (fe2 != null) {
                    fe.yj(fe2.qw());
                }
            }
        }
    }

    public final mmm qw(CacheRequest cacheRequest, mmm mmm) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return mmm;
        }
        C0227qw qwVar = new C0227qw(this, mmm.qw().uk(), cacheRequest, Okio.buffer(body));
        String yj2 = mmm.yj("Content-Type");
        long fe2 = mmm.qw().fe();
        mmm.qw ggg = mmm.ggg();
        ggg.ad(new yj(yj2, fe2, Okio.buffer((Source) qwVar)));
        return ggg.de();
    }
}
