package fe.th.de.rrr.o;

import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import fe.th.de.aaa;
import fe.th.de.ddd;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.rrr.uk.o;
import fe.th.de.rrr.uk.uk;
import fe.th.de.rrr.uk.yj;
import fe.th.de.rrr.yj.th;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class fe implements HttpCodec {

    /* renamed from: th  reason: collision with root package name */
    public static final List<String> f5329th = fe.th.de.rrr.fe.mmm(Http2ExchangeCodec.CONNECTION, "host", Http2ExchangeCodec.KEEP_ALIVE, Http2ExchangeCodec.PROXY_CONNECTION, Http2ExchangeCodec.TE, Http2ExchangeCodec.TRANSFER_ENCODING, Http2ExchangeCodec.ENCODING, Http2ExchangeCodec.UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: yj  reason: collision with root package name */
    public static final List<String> f5330yj = fe.th.de.rrr.fe.mmm(Http2ExchangeCodec.CONNECTION, "host", Http2ExchangeCodec.KEEP_ALIVE, Http2ExchangeCodec.PROXY_CONNECTION, Http2ExchangeCodec.TE, Http2ExchangeCodec.TRANSFER_ENCODING, Http2ExchangeCodec.ENCODING, Http2ExchangeCodec.UPGRADE);

    /* renamed from: ad  reason: collision with root package name */
    public final th f5331ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f5332de;

    /* renamed from: fe  reason: collision with root package name */
    public yj f5333fe;
    public final Interceptor.Chain qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Protocol f5334rg;

    public class qw extends ForwardingSource {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f5335ad = false;

        /* renamed from: th  reason: collision with root package name */
        public long f5336th = 0;

        public qw(Source source) {
            super(source);
        }

        public void close() throws IOException {
            super.close();
            qw((IOException) null);
        }

        public final void qw(IOException iOException) {
            if (!this.f5335ad) {
                this.f5335ad = true;
                fe feVar = fe.this;
                feVar.f5331ad.qqq(false, feVar, this.f5336th, iOException);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.f5336th += read;
                }
                return read;
            } catch (IOException e) {
                qw(e);
                throw e;
            }
        }
    }

    public fe(ggg ggg, Interceptor.Chain chain, th thVar, rg rgVar) {
        Protocol protocol;
        this.qw = chain;
        this.f5331ad = thVar;
        this.f5332de = rgVar;
        if (ggg.eee().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f5334rg = protocol;
    }

    public static List<qw> fe(ddd ddd) {
        pf fe2 = ddd.fe();
        ArrayList arrayList = new ArrayList(fe2.yj() + 4);
        arrayList.add(new qw(qw.f5347th, ddd.th()));
        arrayList.add(new qw(qw.f5349yj, uk.de(ddd.uk())));
        String de2 = ddd.de("Host");
        if (de2 != null) {
            arrayList.add(new qw(qw.f5345i, de2));
        }
        arrayList.add(new qw(qw.f5348uk, ddd.uk().b()));
        int yj2 = fe2.yj();
        for (int i2 = 0; i2 < yj2; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(fe2.rg(i2).toLowerCase(Locale.US));
            if (!f5329th.contains(encodeUtf8.utf8())) {
                arrayList.add(new qw(encodeUtf8, fe2.uk(i2)));
            }
        }
        return arrayList;
    }

    public static mmm.qw rg(pf pfVar, Protocol protocol) throws IOException {
        pf.qw qwVar = new pf.qw();
        int yj2 = pfVar.yj();
        o oVar = null;
        for (int i2 = 0; i2 < yj2; i2++) {
            String rg2 = pfVar.rg(i2);
            String uk2 = pfVar.uk(i2);
            if (rg2.equals(Header.RESPONSE_STATUS_UTF8)) {
                oVar = o.ad("HTTP/1.1 " + uk2);
            } else if (!f5330yj.contains(rg2)) {
                fe.th.de.rrr.qw.qw.ad(qwVar, rg2, uk2);
            }
        }
        if (oVar != null) {
            mmm.qw qwVar2 = new mmm.qw();
            qwVar2.when(protocol);
            qwVar2.yj(oVar.f5474ad);
            qwVar2.pf(oVar.f5475de);
            qwVar2.o(qwVar.rg());
            return qwVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void ad(ddd ddd) throws IOException {
        if (this.f5333fe == null) {
            yj aaa = this.f5332de.aaa(fe(ddd), ddd.qw() != null);
            this.f5333fe = aaa;
            aaa.when().timeout((long) this.qw.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f5333fe.mmm().timeout((long) this.qw.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void cancel() {
        yj yjVar = this.f5333fe;
        if (yjVar != null) {
            yjVar.uk(ErrorCode.CANCEL);
        }
    }

    public Sink de(ddd ddd, long j) {
        return this.f5333fe.o();
    }

    public void finishRequest() throws IOException {
        this.f5333fe.o().close();
    }

    public void flushRequest() throws IOException {
        this.f5332de.flush();
    }

    public aaa qw(mmm mmm) throws IOException {
        th thVar = this.f5331ad;
        thVar.f5519th.responseBodyStart(thVar.f5518rg);
        return new yj(mmm.yj("Content-Type"), fe.th.de.rrr.uk.fe.ad(mmm), Okio.buffer((Source) new qw(this.f5333fe.pf())));
    }

    public mmm.qw readResponseHeaders(boolean z) throws IOException {
        mmm.qw rg2 = rg(this.f5333fe.ddd(), this.f5334rg);
        if (!z || fe.th.de.rrr.qw.qw.fe(rg2) != 100) {
            return rg2;
        }
        return null;
    }
}
