package fe.th.de.rrr.uk;

import com.alipay.sdk.m.n.a;
import com.duxiaoman.okhttp3.CookieJar;
import com.duxiaoman.okhttp3.Interceptor;
import com.google.common.net.HttpHeaders;
import fe.th.de.ddd;
import fe.th.de.eee;
import fe.th.de.mmm;
import fe.th.de.nn;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.rg;
import fe.th.de.uk;
import fe.th.de.when;
import java.io.IOException;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public final class qw implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static String f5476ad = "BridgeInterceptor";
    public final CookieJar qw;

    public qw(CookieJar cookieJar) {
        this.qw = cookieJar;
    }

    public static void ad(String str, ddd ddd, String str2) {
        eee.qw(str, ddd, str2, f5476ad);
    }

    public mmm intercept(Interceptor.Chain chain) throws IOException {
        ddd request = chain.request();
        ddd.qw yj2 = request.yj();
        nn qw2 = request.qw();
        StringBuilder sb = new StringBuilder();
        sb.append("RequestBody is null:: ");
        boolean z = true;
        sb.append(qw2 == null);
        ad(sb.toString(), request, "intercept");
        if (qw2 != null) {
            when ad2 = qw2.ad();
            if (ad2 != null) {
                yj2.de("Content-Type", ad2.toString());
            }
            long qw3 = qw2.qw();
            if (qw3 != -1) {
                yj2.de("Content-Length", Long.toString(qw3));
                yj2.th("Transfer-Encoding");
            } else {
                yj2.de("Transfer-Encoding", "chunked");
                yj2.th("Content-Length");
            }
            ad("RequestBody contentType:: " + ad2 + "  contentLength:: " + qw3, request, "intercept");
        }
        if (request.de("Host") == null) {
            yj2.de("Host", fe.ddd(request.uk(), false));
        }
        if (request.de(HttpHeaders.CONNECTION) == null) {
            yj2.de(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (request.de("Accept-Encoding") == null && request.de("Range") == null) {
            yj2.de("Accept-Encoding", "gzip");
        } else {
            z = false;
        }
        List<uk> qw4 = this.qw.qw(request.uk());
        if (!qw4.isEmpty()) {
            yj2.de("Cookie", qw(qw4));
        }
        if (request.de("User-Agent") == null) {
            yj2.de("User-Agent", rg.qw());
        }
        mmm qw5 = chain.qw(yj2.ad());
        fe.rg(this.qw, request.uk(), qw5.pf());
        mmm.qw ggg = qw5.ggg();
        ggg.ggg(request);
        ad("transparentGzip:: ", request, "intercept");
        if (z && "gzip".equalsIgnoreCase(qw5.yj("Content-Encoding")) && fe.de(qw5)) {
            GzipSource gzipSource = new GzipSource(qw5.qw().uk());
            pf.qw th2 = qw5.pf().th();
            th2.yj("Content-Encoding");
            th2.yj("Content-Length");
            ggg.o(th2.rg());
            ggg.ad(new yj(qw5.yj("Content-Type"), -1, Okio.buffer((Source) gzipSource)));
        }
        return ggg.de();
    }

    public final String qw(List<uk> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            uk ukVar = list.get(i2);
            sb.append(ukVar.de());
            sb.append(a.h);
            sb.append(ukVar.pf());
        }
        return sb.toString();
    }
}
