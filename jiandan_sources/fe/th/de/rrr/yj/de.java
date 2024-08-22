package fe.th.de.rrr.yj;

import com.baidu.sapi2.activity.BindVerifyActivity;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Connection;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.google.common.net.HttpHeaders;
import fe.th.de.Cif;
import fe.th.de.ddd;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.nn;
import fe.th.de.o;
import fe.th.de.qqq;
import fe.th.de.qw;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.o.rg;
import fe.th.de.rrr.o.yj;
import fe.th.de.th;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.connection.RealConnection;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class de extends rg.o implements Connection {

    /* renamed from: ad  reason: collision with root package name */
    public final th f5493ad;

    /* renamed from: de  reason: collision with root package name */
    public final qqq f5494de;

    /* renamed from: fe  reason: collision with root package name */
    public Socket f5495fe;

    /* renamed from: i  reason: collision with root package name */
    public BufferedSource f5496i;

    /* renamed from: if  reason: not valid java name */
    public int f218if;

    /* renamed from: o  reason: collision with root package name */
    public BufferedSink f5497o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f5498pf;
    public long ppp = Long.MAX_VALUE;

    /* renamed from: rg  reason: collision with root package name */
    public Socket f5499rg;

    /* renamed from: switch  reason: not valid java name */
    public int f219switch = 1;

    /* renamed from: th  reason: collision with root package name */
    public o f5500th;

    /* renamed from: uk  reason: collision with root package name */
    public rg f5501uk;
    public final List<Reference<th>> when = new ArrayList();

    /* renamed from: yj  reason: collision with root package name */
    public Protocol f5502yj;

    public de(th thVar, qqq qqq) {
        this.f5493ad = thVar;
        this.f5494de = qqq;
    }

    public void ad(yj yjVar) throws IOException {
        yjVar.th(ErrorCode.REFUSED_STREAM);
    }

    public void de() {
        fe.uk(this.f5495fe);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fe(int r17, int r18, int r19, int r20, boolean r21, com.duxiaoman.okhttp3.Call r22, com.duxiaoman.okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            com.duxiaoman.okhttp3.Protocol r0 = r7.f5502yj
            if (r0 != 0) goto L_0x0150
            fe.th.de.qqq r0 = r7.f5494de
            fe.th.de.qw r0 = r0.qw()
            java.util.List r0 = r0.ad()
            fe.th.de.rrr.yj.ad r10 = new fe.th.de.rrr.yj.ad
            r10.<init>(r0)
            fe.th.de.qqq r1 = r7.f5494de
            fe.th.de.qw r1 = r1.qw()
            javax.net.ssl.SSLSocketFactory r1 = r1.pf()
            if (r1 != 0) goto L_0x0074
            fe.th.de.yj r1 = fe.th.de.yj.f5573uk
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            fe.th.de.qqq r0 = r7.f5494de
            fe.th.de.qw r0 = r0.qw()
            fe.th.de.if r0 = r0.m345if()
            java.lang.String r0 = r0.m338if()
            fe.th.de.rrr.if.yj r1 = fe.th.de.rrr.p019if.yj.m350switch()
            boolean r1 = r1.ddd(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            com.duxiaoman.okhttp3.internal.connection.RouteException r1 = new com.duxiaoman.okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            com.duxiaoman.okhttp3.internal.connection.RouteException r0 = new com.duxiaoman.okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            fe.th.de.qqq r0 = r7.f5494de
            fe.th.de.qw r0 = r0.qw()
            java.util.List r0 = r0.th()
            com.duxiaoman.okhttp3.Protocol r1 = com.duxiaoman.okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            fe.th.de.qqq r0 = r7.f5494de     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.de()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.yj(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f5495fe     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.rg(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.o(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00f5 }
            fe.th.de.qqq r0 = r7.f5494de     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.fe()     // Catch:{ IOException -> 0x00f5 }
            fe.th.de.qqq r1 = r7.f5494de     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.ad()     // Catch:{ IOException -> 0x00f5 }
            com.duxiaoman.okhttp3.Protocol r2 = r7.f5502yj     // Catch:{ IOException -> 0x00f5 }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            fe.th.de.qqq r0 = r7.f5494de
            boolean r0 = r0.de()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f5495fe
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            com.duxiaoman.okhttp3.internal.connection.RouteException r1 = new com.duxiaoman.okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            fe.th.de.rrr.o.rg r0 = r7.f5501uk
            if (r0 == 0) goto L_0x00f4
            fe.th.de.th r1 = r7.f5493ad
            monitor-enter(r1)
            fe.th.de.rrr.o.rg r0 = r7.f5501uk     // Catch:{ all -> 0x00f1 }
            int r0 = r0.nn()     // Catch:{ all -> 0x00f1 }
            r7.f219switch = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f5499rg
            fe.th.de.rrr.fe.uk(r1)
            java.net.Socket r1 = r7.f5495fe
            fe.th.de.rrr.fe.uk(r1)
            r7.f5499rg = r11
            r7.f5495fe = r11
            r7.f5496i = r11
            r7.f5497o = r11
            r7.f5500th = r11
            r7.f5502yj = r11
            r7.f5501uk = r11
            fe.th.de.qqq r1 = r7.f5494de
            java.net.InetSocketAddress r3 = r1.fe()
            fe.th.de.qqq r1 = r7.f5494de
            java.net.Proxy r4 = r1.ad()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            com.duxiaoman.okhttp3.internal.connection.RouteException r12 = new com.duxiaoman.okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.addConnectException(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.ad(r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            com.duxiaoman.okhttp3.internal.connection.RouteException r0 = new com.duxiaoman.okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.de.fe(int, int, int, int, boolean, com.duxiaoman.okhttp3.Call, com.duxiaoman.okhttp3.EventListener):void");
    }

    public final void ggg(int i2) throws IOException {
        this.f5499rg.setSoTimeout(0);
        rg.uk ukVar = new rg.uk(true);
        ukVar.fe(this.f5499rg, this.f5494de.qw().m345if().m338if(), this.f5496i, this.f5497o);
        ukVar.ad(this);
        ukVar.de(i2);
        rg qw = ukVar.qw();
        this.f5501uk = qw;
        qw.f();
    }

    public o handshake() {
        return this.f5500th;
    }

    public final ddd i() throws IOException {
        ddd.qw qwVar = new ddd.qw();
        qwVar.yj(this.f5494de.qw().m345if());
        qwVar.rg("CONNECT", (nn) null);
        qwVar.de("Host", fe.ddd(this.f5494de.qw().m345if(), true));
        qwVar.de("Proxy-Connection", "Keep-Alive");
        qwVar.de("User-Agent", fe.th.de.rrr.rg.qw());
        ddd ad2 = qwVar.ad();
        mmm.qw qwVar2 = new mmm.qw();
        qwVar2.ggg(ad2);
        qwVar2.when(Protocol.HTTP_1_1);
        qwVar2.yj(BindVerifyActivity.O);
        qwVar2.pf("Preemptive Authenticate");
        qwVar2.ad(fe.f5255de);
        qwVar2.vvv(-1);
        qwVar2.ppp(-1);
        qwVar2.i(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive");
        ddd qw = this.f5494de.qw().uk().qw(this.f5494de, qwVar2.de());
        return qw != null ? qw : ad2;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m360if(boolean z) {
        int soTimeout;
        if (this.f5499rg.isClosed() || this.f5499rg.isInputShutdown() || this.f5499rg.isOutputShutdown()) {
            return false;
        }
        rg rgVar = this.f5501uk;
        if (rgVar != null) {
            return rgVar.ddd(System.nanoTime());
        }
        if (z) {
            try {
                soTimeout = this.f5499rg.getSoTimeout();
                this.f5499rg.setSoTimeout(1);
                if (this.f5496i.exhausted()) {
                    this.f5499rg.setSoTimeout(soTimeout);
                    return false;
                }
                this.f5499rg.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th2) {
                this.f5499rg.setSoTimeout(soTimeout);
                throw th2;
            }
        }
        return true;
    }

    public final void o(ad adVar, int i2, Call call, EventListener eventListener) throws IOException {
        if (this.f5494de.qw().pf() != null) {
            eventListener.secureConnectStart(call);
            th(adVar);
            eventListener.secureConnectEnd(call, this.f5500th);
            if (this.f5502yj == Protocol.HTTP_2) {
                ggg(i2);
            }
        } else if (this.f5494de.qw().th().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.f5499rg = this.f5495fe;
            this.f5502yj = Protocol.H2_PRIOR_KNOWLEDGE;
            ggg(i2);
        } else {
            this.f5499rg = this.f5495fe;
            this.f5502yj = Protocol.HTTP_1_1;
        }
    }

    public boolean pf(qw qwVar, qqq qqq) {
        if (this.when.size() >= this.f219switch || this.f5498pf || !fe.th.de.rrr.qw.qw.yj(this.f5494de.qw(), qwVar)) {
            return false;
        }
        if (qwVar.m345if().m338if().equals(route().qw().m345if().m338if())) {
            return true;
        }
        if (this.f5501uk == null || qqq == null || qqq.ad().type() != Proxy.Type.DIRECT || this.f5494de.ad().type() != Proxy.Type.DIRECT || !this.f5494de.fe().equals(qqq.fe()) || qqq.qw().rg() != fe.th.de.rrr.when.fe.qw || !vvv(qwVar.m345if())) {
            return false;
        }
        try {
            qwVar.qw().qw(qwVar.m345if().m338if(), handshake().rg());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public Socket ppp() {
        return this.f5499rg;
    }

    public Protocol protocol() {
        return this.f5502yj;
    }

    public void qw(rg rgVar) {
        synchronized (this.f5493ad) {
            this.f219switch = rgVar.nn();
        }
    }

    public final void rg(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        Proxy ad2 = this.f5494de.ad();
        qw qw = this.f5494de.qw();
        if (ad2.type() == Proxy.Type.DIRECT || ad2.type() == Proxy.Type.HTTP) {
            socket = qw.o().createSocket();
        } else {
            socket = new Socket(ad2);
        }
        this.f5495fe = socket;
        eventListener.connectStart(call, this.f5494de.fe(), ad2);
        this.f5495fe.setSoTimeout(i3);
        try {
            fe.th.de.rrr.p019if.yj.m350switch().i(this.f5495fe, this.f5494de.fe(), i2);
            try {
                this.f5496i = Okio.buffer(Okio.source(this.f5495fe));
                this.f5497o = Okio.buffer(Okio.sink(this.f5495fe));
            } catch (NullPointerException e) {
                if (RealConnection.NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5494de.fe());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public qqq route() {
        return this.f5494de;
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m361switch() {
        return this.f5501uk != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0137 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013d A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void th(fe.th.de.rrr.yj.ad r8) throws java.io.IOException {
        /*
            r7 = this;
            fe.th.de.qqq r0 = r7.f5494de
            fe.th.de.qw r0 = r0.qw()
            javax.net.ssl.SSLSocketFactory r1 = r0.pf()
            r2 = 0
            java.net.Socket r3 = r7.f5495fe     // Catch:{ AssertionError -> 0x0130 }
            fe.th.de.if r4 = r0.m345if()     // Catch:{ AssertionError -> 0x0130 }
            java.lang.String r4 = r4.m338if()     // Catch:{ AssertionError -> 0x0130 }
            fe.th.de.if r5 = r0.m345if()     // Catch:{ AssertionError -> 0x0130 }
            int r5 = r5.qqq()     // Catch:{ AssertionError -> 0x0130 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0130 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0130 }
            fe.th.de.yj r8 = r8.qw(r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r3 = r8.th()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r3 == 0) goto L_0x0041
            fe.th.de.rrr.if.yj r3 = fe.th.de.rrr.p019if.yj.m350switch()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.if r4 = r0.m345if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r4 = r4.m338if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r5 = r0.th()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r3.uk(r1, r4, r5)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.o r4 = fe.th.de.o.ad(r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.HostnameVerifier r5 = r0.rg()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.if r6 = r0.m345if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r6 = r6.m338if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r3 != 0) goto L_0x00d8
            java.util.List r8 = r4.rg()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00b6
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.<init>()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.if r0 = r0.m345if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.m338if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = fe.th.de.fe.de(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r8 = fe.th.de.rrr.when.fe.qw(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            throw r2     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00b6:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.<init>()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.if r0 = r0.m345if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.m338if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            throw r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00d8:
            fe.th.de.fe r3 = r0.qw()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            fe.th.de.if r0 = r0.m345if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.m338if()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r5 = r4.rg()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r3.qw(r0, r5)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r8 = r8.th()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r8 == 0) goto L_0x00f9
            fe.th.de.rrr.if.yj r8 = fe.th.de.rrr.p019if.yj.m350switch()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r2 = r8.ggg(r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00f9:
            r7.f5499rg = r1     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.Source r8 = okio.Okio.source((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f5496i = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.net.Socket r8 = r7.f5499rg     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.Sink r8 = okio.Okio.sink((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f5497o = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f5500th = r4     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r2 == 0) goto L_0x011a
            com.duxiaoman.okhttp3.Protocol r8 = com.duxiaoman.okhttp3.Protocol.get(r2)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            goto L_0x011c
        L_0x011a:
            com.duxiaoman.okhttp3.Protocol r8 = com.duxiaoman.okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x011c:
            r7.f5502yj = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r1 == 0) goto L_0x0127
            fe.th.de.rrr.if.yj r8 = fe.th.de.rrr.p019if.yj.m350switch()
            r8.qw(r1)
        L_0x0127:
            return
        L_0x0128:
            r8 = move-exception
            r2 = r1
            goto L_0x013e
        L_0x012b:
            r8 = move-exception
            r2 = r1
            goto L_0x0131
        L_0x012e:
            r8 = move-exception
            goto L_0x013e
        L_0x0130:
            r8 = move-exception
        L_0x0131:
            boolean r0 = fe.th.de.rrr.fe.a(r8)     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x013d
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012e }
            r0.<init>(r8)     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ all -> 0x012e }
        L_0x013d:
            throw r8     // Catch:{ all -> 0x012e }
        L_0x013e:
            if (r2 == 0) goto L_0x0147
            fe.th.de.rrr.if.yj r0 = fe.th.de.rrr.p019if.yj.m350switch()
            r0.qw(r2)
        L_0x0147:
            fe.th.de.rrr.fe.uk(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.de.th(fe.th.de.rrr.yj.ad):void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5494de.qw().m345if().m338if());
        sb.append(":");
        sb.append(this.f5494de.qw().m345if().qqq());
        sb.append(", proxy=");
        sb.append(this.f5494de.ad());
        sb.append(" hostAddress=");
        sb.append(this.f5494de.fe());
        sb.append(" cipherSuite=");
        o oVar = this.f5500th;
        sb.append(oVar != null ? oVar.qw() : "none");
        sb.append(" protocol=");
        sb.append(this.f5502yj);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }

    public final ddd uk(int i2, int i3, ddd ddd, Cif ifVar) throws IOException {
        String str = "CONNECT " + fe.ddd(ifVar, true) + " HTTP/1.1";
        while (true) {
            fe.th.de.rrr.i.qw qwVar = new fe.th.de.rrr.i.qw((ggg) null, (th) null, this.f5496i, this.f5497o);
            this.f5496i.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            this.f5497o.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
            qwVar.m348if(ddd.fe(), str);
            qwVar.finishRequest();
            mmm.qw readResponseHeaders = qwVar.readResponseHeaders(false);
            readResponseHeaders.ggg(ddd);
            mmm de2 = readResponseHeaders.de();
            long ad2 = fe.th.de.rrr.uk.fe.ad(de2);
            if (ad2 == -1) {
                ad2 = 0;
            }
            Source uk2 = qwVar.uk(ad2);
            fe.d(uk2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            uk2.close();
            int rg2 = de2.rg();
            if (rg2 != 200) {
                if (rg2 == 407) {
                    ddd qw = this.f5494de.qw().uk().qw(this.f5494de, de2);
                    if (qw == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(de2.yj(HttpHeaders.CONNECTION))) {
                        return qw;
                    } else {
                        ddd = qw;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + de2.rg());
                }
            } else if (this.f5496i.buffer().exhausted() && this.f5497o.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    public boolean vvv(Cif ifVar) {
        if (ifVar.qqq() != this.f5494de.qw().m345if().qqq()) {
            return false;
        }
        if (ifVar.m338if().equals(this.f5494de.qw().m345if().m338if())) {
            return true;
        }
        if (this.f5500th == null || !fe.th.de.rrr.when.fe.qw.de(ifVar.m338if(), (X509Certificate) this.f5500th.rg().get(0))) {
            return false;
        }
        return true;
    }

    public HttpCodec when(ggg ggg, Interceptor.Chain chain, th thVar) throws SocketException {
        if (this.f5501uk != null) {
            return new fe.th.de.rrr.o.fe(ggg, chain, thVar, this.f5501uk);
        }
        this.f5499rg.setSoTimeout(chain.readTimeoutMillis());
        this.f5496i.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f5497o.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new fe.th.de.rrr.i.qw(ggg, thVar, this.f5496i, this.f5497o);
    }

    public final void yj(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException {
        ddd i5 = i();
        Cif uk2 = i5.uk();
        int i6 = 0;
        while (i6 < 21) {
            rg(i2, i3, call, eventListener);
            i5 = uk(i3, i4, i5, uk2);
            if (i5 != null) {
                fe.uk(this.f5495fe);
                this.f5495fe = null;
                this.f5497o = null;
                this.f5496i = null;
                eventListener.connectEnd(call, this.f5494de.fe(), this.f5494de.ad(), (Protocol) null);
                i6++;
            } else {
                return;
            }
        }
    }
}
