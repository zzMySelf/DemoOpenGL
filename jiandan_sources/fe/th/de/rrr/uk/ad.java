package fe.th.de.rrr.uk;

import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import com.google.common.net.HttpHeaders;
import fe.th.de.ddd;
import fe.th.de.eee;
import fe.th.de.mmm;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.yj.de;
import fe.th.de.rrr.yj.th;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public final class ad implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static String f5466ad = "CallServerInterceptor";
    public final boolean qw;

    public static final class qw extends ForwardingSink {

        /* renamed from: ad  reason: collision with root package name */
        public long f5467ad;

        public qw(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            this.f5467ad += j;
        }
    }

    public ad(boolean z) {
        this.qw = z;
    }

    public static void qw(String str, ddd ddd, String str2) {
        eee.qw(str, ddd, str2, f5466ad);
    }

    public mmm intercept(Interceptor.Chain chain) throws IOException {
        mmm mmm;
        th thVar = (th) chain;
        HttpCodec fe2 = thVar.fe();
        th th2 = thVar.th();
        de deVar = (de) thVar.connection();
        ddd request = thVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        thVar.de().requestHeadersStart(thVar.ad());
        fe2.ad(request);
        thVar.de().requestHeadersEnd(thVar.ad(), request);
        qw("HttpMethod.permitsRequestBody:: ", request, "intercept");
        mmm.qw qwVar = null;
        if (rg.ad(request.th()) && request.qw() != null) {
            if ("100-continue".equalsIgnoreCase(request.de(HttpHeaders.EXPECT))) {
                fe2.flushRequest();
                thVar.de().responseHeadersStart(thVar.ad());
                qwVar = fe2.readResponseHeaders(true);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("responseBuilder is null:: ");
            sb.append(qwVar == null);
            qw(sb.toString(), request, "intercept");
            if (qwVar == null) {
                thVar.de().requestBodyStart(thVar.ad());
                qw qwVar2 = new qw(fe2.de(request, request.qw().qw()));
                BufferedSink buffer = Okio.buffer((Sink) qwVar2);
                request.qw().yj(buffer);
                buffer.close();
                thVar.de().requestBodyEnd(thVar.ad(), qwVar2.f5467ad);
            } else if (!deVar.m361switch()) {
                th2.ppp();
            }
        }
        fe2.finishRequest();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("responseBuilder is null:: ");
        sb2.append(qwVar == null);
        qw(sb2.toString(), request, "intercept");
        if (qwVar == null) {
            thVar.de().responseHeadersStart(thVar.ad());
            qwVar = fe2.readResponseHeaders(false);
        }
        qwVar.ggg(request);
        qwVar.uk(th2.fe().handshake());
        qwVar.vvv(currentTimeMillis);
        qwVar.ppp(System.currentTimeMillis());
        mmm de2 = qwVar.de();
        int rg2 = de2.rg();
        qw("code:: " + rg2, request, "intercept");
        if (rg2 == 100) {
            mmm.qw readResponseHeaders = fe2.readResponseHeaders(false);
            readResponseHeaders.ggg(request);
            readResponseHeaders.uk(th2.fe().handshake());
            readResponseHeaders.vvv(currentTimeMillis);
            readResponseHeaders.ppp(System.currentTimeMillis());
            de2 = readResponseHeaders.de();
            rg2 = de2.rg();
        }
        thVar.de().responseHeadersEnd(thVar.ad(), de2);
        qw("forWebSocket:: " + this.qw + "  code:: " + rg2, request, "intercept");
        if (!this.qw || rg2 != 101) {
            mmm.qw ggg = de2.ggg();
            ggg.ad(fe2.qw(de2));
            mmm = ggg.de();
        } else {
            mmm.qw ggg2 = de2.ggg();
            ggg2.ad(fe.f5255de);
            mmm = ggg2.de();
        }
        if ("close".equalsIgnoreCase(mmm.nn().de(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(mmm.yj(HttpHeaders.CONNECTION))) {
            th2.ppp();
        }
        if ((rg2 != 204 && rg2 != 205) || mmm.qw().fe() <= 0) {
            return mmm;
        }
        throw new ProtocolException("HTTP " + rg2 + " had non-zero Content-Length: " + mmm.qw().fe());
    }
}
