package com.duxiaoman.okhttp3.internal.huc;

import androidx.browser.trusted.sharing.ShareTarget;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Callback;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.URLFilter;
import fe.th.de.Cif;
import fe.th.de.ad;
import fe.th.de.ddd;
import fe.th.de.ggg;
import fe.th.de.i;
import fe.th.de.mmm;
import fe.th.de.o;
import fe.th.de.pf;
import fe.th.de.rrr.p019if.yj;
import fe.th.de.rrr.pf.fe;
import fe.th.de.rrr.uk.de;
import fe.th.de.rrr.uk.rg;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.Buffer;

public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    public static final String ggg = (yj.m350switch().when() + "-Selected-Protocol");
    public static final String vvv = (yj.m350switch().when() + "-Response-Source");
    public static final Set<String> xxx = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", ShareTarget.METHOD_GET, "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));

    /* renamed from: ad  reason: collision with root package name */
    public final qw f3796ad;

    /* renamed from: de  reason: collision with root package name */
    public pf.qw f3797de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f3798fe;

    /* renamed from: i  reason: collision with root package name */
    public final Object f3799i;

    /* renamed from: if  reason: not valid java name */
    public mmm f141if;

    /* renamed from: o  reason: collision with root package name */
    public mmm f3800o;

    /* renamed from: pf  reason: collision with root package name */
    public Throwable f3801pf;
    public o ppp;
    public ggg qw;

    /* renamed from: rg  reason: collision with root package name */
    public Call f3802rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f142switch;

    /* renamed from: th  reason: collision with root package name */
    public URLFilter f3803th;

    /* renamed from: uk  reason: collision with root package name */
    public long f3804uk;
    public Proxy when;

    /* renamed from: yj  reason: collision with root package name */
    public pf f3805yj;

    public static final class UnexpectedException extends IOException {
        public static final Interceptor INTERCEPTOR = new qw();

        public class qw implements Interceptor {
            public mmm intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.qw(chain.request());
                } catch (Error | RuntimeException e) {
                    throw new UnexpectedException(e);
                }
            }
        }

        public UnexpectedException(Throwable th2) {
            super(th2);
        }
    }

    public final class qw implements Interceptor {
        public boolean qw;

        public qw() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0099 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public fe.th.de.mmm intercept(com.duxiaoman.okhttp3.Interceptor.Chain r5) throws java.io.IOException {
            /*
                r4 = this;
                fe.th.de.ddd r0 = r5.request()
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r1 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this
                fe.th.de.pf r2 = r0.fe()
                fe.th.de.pf$qw r2 = r2.th()
                fe.th.de.pf.qw unused = r1.f3797de = r2
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r1 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this
                com.duxiaoman.okhttp3.internal.URLFilter r1 = r1.f3803th
                if (r1 == 0) goto L_0x0022
                fe.th.de.if r2 = r0.uk()
                java.net.URL r2 = r2.d()
                r1.qw(r2)
            L_0x0022:
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r1 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r1 = r1.f3799i
                monitor-enter(r1)
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r2 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x00a6 }
                r3 = 0
                r2.f142switch = r3     // Catch:{ all -> 0x00a6 }
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r2 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x00a6 }
                com.duxiaoman.okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x00a6 }
                fe.th.de.qqq r3 = r3.route()     // Catch:{ all -> 0x00a6 }
                java.net.Proxy r3 = r3.ad()     // Catch:{ all -> 0x00a6 }
                r2.when = r3     // Catch:{ all -> 0x00a6 }
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r2 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x00a6 }
                com.duxiaoman.okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x00a6 }
                fe.th.de.o r3 = r3.handshake()     // Catch:{ all -> 0x00a6 }
                r2.ppp = r3     // Catch:{ all -> 0x00a6 }
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r2 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x00a6 }
                java.lang.Object r2 = r2.f3799i     // Catch:{ all -> 0x00a6 }
                r2.notifyAll()     // Catch:{ all -> 0x00a6 }
            L_0x0053:
                boolean r2 = r4.qw     // Catch:{ InterruptedException -> 0x0099 }
                if (r2 != 0) goto L_0x0061
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r2 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ InterruptedException -> 0x0099 }
                java.lang.Object r2 = r2.f3799i     // Catch:{ InterruptedException -> 0x0099 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0099 }
                goto L_0x0053
            L_0x0061:
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                fe.th.de.nn r1 = r0.qw()
                boolean r1 = r1 instanceof fe.th.de.rrr.pf.fe
                if (r1 == 0) goto L_0x0074
                fe.th.de.nn r1 = r0.qw()
                fe.th.de.rrr.pf.fe r1 = (fe.th.de.rrr.pf.fe) r1
                fe.th.de.ddd r0 = r1.pf(r0)
            L_0x0074:
                fe.th.de.mmm r5 = r5.qw(r0)
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r0 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r0 = r0.f3799i
                monitor-enter(r0)
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r1 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0096 }
                r1.f141if = r5     // Catch:{ all -> 0x0096 }
                com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection r1 = com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0096 }
                fe.th.de.ddd r2 = r5.nn()     // Catch:{ all -> 0x0096 }
                fe.th.de.if r2 = r2.uk()     // Catch:{ all -> 0x0096 }
                java.net.URL r2 = r2.d()     // Catch:{ all -> 0x0096 }
                java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0096 }
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                return r5
            L_0x0096:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                throw r5
            L_0x0099:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00a6 }
                r5.interrupt()     // Catch:{ all -> 0x00a6 }
                java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x00a6 }
                r5.<init>()     // Catch:{ all -> 0x00a6 }
                throw r5     // Catch:{ all -> 0x00a6 }
            L_0x00a6:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.qw.intercept(com.duxiaoman.okhttp3.Interceptor$Chain):fe.th.de.mmm");
        }

        public void qw() {
            synchronized (OkHttpURLConnection.this.f3799i) {
                this.qw = true;
                OkHttpURLConnection.this.f3799i.notifyAll();
            }
        }
    }

    public OkHttpURLConnection(URL url, ggg ggg2) {
        super(url);
        this.f3796ad = new qw();
        this.f3797de = new pf.qw();
        this.f3804uk = -1;
        this.f3799i = new Object();
        this.f142switch = true;
        this.qw = ggg2;
    }

    public static String i(mmm mmm) {
        if (mmm.ppp() == null) {
            if (mmm.fe() == null) {
                return "NONE";
            }
            return "CACHE " + mmm.rg();
        } else if (mmm.fe() == null) {
            return "NETWORK " + mmm.rg();
        } else {
            return "CONDITIONAL_CACHE " + mmm.ppp().rg();
        }
    }

    public static String o(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt <= 31 || codePointAt >= 127) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i2);
                buffer.writeUtf8CodePoint(63);
                while (true) {
                    i2 += Character.charCount(codePointAt);
                    if (i2 >= length) {
                        return buffer.readUtf8();
                    }
                    codePointAt = str.codePointAt(i2);
                    buffer.writeUtf8CodePoint((codePointAt <= 31 || codePointAt >= 127) ? 63 : codePointAt);
                }
            } else {
                i2 += Character.charCount(codePointAt);
            }
        }
        return str;
    }

    public static IOException uk(Throwable th2) throws IOException {
        if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else {
            throw new AssertionError();
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            yj yjVar = yj.m350switch();
            yjVar.mmm(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f3797de.qw(str, str2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.f3798fe
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.duxiaoman.okhttp3.Call r0 = r2.fe()
            r1 = 1
            r2.f3798fe = r1
            r0.qw(r2)
            java.lang.Object r0 = r2.f3799i
            monitor-enter(r0)
        L_0x0012:
            boolean r1 = r2.f142switch     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            fe.th.de.mmm r1 = r2.f3800o     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Throwable r1 = r2.f3801pf     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Object r1 = r2.f3799i     // Catch:{ InterruptedException -> 0x0033 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0033 }
            goto L_0x0012
        L_0x0024:
            java.lang.Throwable r1 = r2.f3801pf     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x002a:
            java.lang.Throwable r1 = r2.f3801pf     // Catch:{ InterruptedException -> 0x0033 }
            uk(r1)     // Catch:{ InterruptedException -> 0x0033 }
            r0 = 0
            throw r0
        L_0x0031:
            r1 = move-exception
            goto L_0x0040
        L_0x0033:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r1.interrupt()     // Catch:{ all -> 0x0031 }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0031 }
            r1.<init>()     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.connect():void");
    }

    public void disconnect() {
        if (this.f3802rg != null) {
            this.f3796ad.qw();
            this.f3802rg.cancel();
        }
    }

    public final Call fe() throws IOException {
        fe feVar;
        Call call = this.f3802rg;
        if (call != null) {
            return call;
        }
        boolean z = true;
        this.connected = true;
        if (this.doOutput) {
            if (this.method.equals(ShareTarget.METHOD_GET)) {
                this.method = "POST";
            } else if (!rg.ad(this.method)) {
                throw new ProtocolException(this.method + " does not support writing");
            }
        }
        if (this.f3797de.th("User-Agent") == null) {
            this.f3797de.qw("User-Agent", rg());
        }
        if (rg.ad(this.method)) {
            if (this.f3797de.th("Content-Type") == null) {
                this.f3797de.qw("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            }
            long j = -1;
            if (this.f3804uk == -1 && this.chunkLength <= 0) {
                z = false;
            }
            String th2 = this.f3797de.th("Content-Length");
            long j2 = this.f3804uk;
            if (j2 != -1) {
                j = j2;
            } else if (th2 != null) {
                j = Long.parseLong(th2);
            }
            if (z) {
                feVar = new fe.th.de.rrr.pf.rg(j);
            } else {
                feVar = new fe.th.de.rrr.pf.qw(j);
            }
            feVar.m358if().timeout((long) this.qw.f(), TimeUnit.MILLISECONDS);
        } else {
            feVar = null;
        }
        try {
            Cif pf2 = Cif.pf(getURL().toString());
            ddd.qw qwVar = new ddd.qw();
            qwVar.yj(pf2);
            qwVar.fe(this.f3797de.rg());
            qwVar.rg(this.method, feVar);
            ddd ad2 = qwVar.ad();
            URLFilter uRLFilter = this.f3803th;
            if (uRLFilter != null) {
                uRLFilter.qw(ad2.uk().d());
            }
            ggg.ad nn = this.qw.nn();
            nn.m336switch().clear();
            nn.m336switch().add(UnexpectedException.INTERCEPTOR);
            nn.when().clear();
            nn.when().add(this.f3796ad);
            nn.yj(new i(this.qw.i().de()));
            if (!getUseCaches()) {
                nn.de((ad) null);
            }
            Call mmm = nn.ad().mmm(ad2);
            this.f3802rg = mmm;
            return mmm;
        } catch (IllegalArgumentException e) {
            if (fe.th.de.rrr.qw.qw.i(e)) {
                UnknownHostException unknownHostException = new UnknownHostException();
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
            MalformedURLException malformedURLException = new MalformedURLException();
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    public int getConnectTimeout() {
        return this.qw.rg();
    }

    public InputStream getErrorStream() {
        try {
            mmm yj2 = yj(true);
            if (fe.th.de.rrr.uk.fe.de(yj2) && yj2.rg() >= 400) {
                return yj2.qw().qw();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(int i2) {
        try {
            pf th2 = th();
            if (i2 >= 0) {
                if (i2 < th2.yj()) {
                    return th2.uk(i2);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderFieldKey(int i2) {
        try {
            pf th2 = th();
            if (i2 >= 0) {
                if (i2 < th2.yj()) {
                    return th2.rg(i2);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return fe.th.de.rrr.ad.qw(th(), fe.th.de.rrr.uk.o.qw(yj(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public InputStream getInputStream() throws IOException {
        if (this.doInput) {
            mmm yj2 = yj(false);
            if (yj2.rg() < 400) {
                return yj2.qw().qw();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public boolean getInstanceFollowRedirects() {
        return this.qw.m333if();
    }

    public OutputStream getOutputStream() throws IOException {
        fe feVar = (fe) fe().request().qw();
        if (feVar != null) {
            if (feVar instanceof fe.th.de.rrr.pf.rg) {
                connect();
                this.f3796ad.qw();
            }
            if (!feVar.i()) {
                return feVar.o();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        throw new ProtocolException("method does not support a request body: " + this.method);
    }

    public Permission getPermission() throws IOException {
        int i2;
        URL url = getURL();
        String host = url.getHost();
        if (url.getPort() != -1) {
            i2 = url.getPort();
        } else {
            i2 = Cif.fe(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.qw.rrr().address();
            host = inetSocketAddress.getHostName();
            i2 = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + i2, "connect, resolve");
    }

    public int getReadTimeout() {
        return this.qw.b();
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return fe.th.de.rrr.ad.qw(this.f3797de.rg(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.f3797de.th(str);
    }

    public int getResponseCode() throws IOException {
        return yj(true).rg();
    }

    public String getResponseMessage() throws IOException {
        return yj(true).when();
    }

    public void onFailure(Call call, IOException iOException) {
        synchronized (this.f3799i) {
            boolean z = iOException instanceof UnexpectedException;
            Throwable th2 = iOException;
            if (z) {
                th2 = iOException.getCause();
            }
            this.f3801pf = th2;
            this.f3799i.notifyAll();
        }
    }

    public void onResponse(Call call, mmm mmm) {
        synchronized (this.f3799i) {
            this.f3800o = mmm;
            this.ppp = mmm.th();
            this.url = mmm.nn().uk().d();
            this.f3799i.notifyAll();
        }
    }

    public final String rg() {
        String property = System.getProperty("http.agent");
        return property != null ? o(property) : fe.th.de.rrr.rg.qw();
    }

    public void setConnectTimeout(int i2) {
        ggg.ad nn = this.qw.nn();
        nn.fe((long) i2, TimeUnit.MILLISECONDS);
        this.qw = nn.ad();
    }

    public void setFixedLengthStreamingMode(int i2) {
        setFixedLengthStreamingMode((long) i2);
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.f3797de.uk("If-Modified-Since", de.qw(new Date(this.ifModifiedSince)));
        } else {
            this.f3797de.yj("If-Modified-Since");
        }
    }

    public void setInstanceFollowRedirects(boolean z) {
        ggg.ad nn = this.qw.nn();
        nn.pf(z);
        this.qw = nn.ad();
    }

    public void setReadTimeout(int i2) {
        ggg.ad nn = this.qw.nn();
        nn.ggg((long) i2, TimeUnit.MILLISECONDS);
        this.qw = nn.ad();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        if (xxx.contains(str)) {
            this.method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + xxx + " but was " + str);
    }

    public void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            yj yjVar = yj.m350switch();
            yjVar.mmm(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f3797de.uk(str, str2);
        }
    }

    public final pf th() throws IOException {
        if (this.f3805yj == null) {
            mmm yj2 = yj(true);
            pf.qw th2 = yj2.pf().th();
            th2.qw(ggg, yj2.xxx().toString());
            th2.qw(vvv, i(yj2));
            this.f3805yj = th2.rg();
        }
        return this.f3805yj;
    }

    public boolean usingProxy() {
        if (this.when != null) {
            return true;
        }
        Proxy rrr = this.qw.rrr();
        if (rrr == null || rrr.type() == Proxy.Type.DIRECT) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        r4 = fe();
        r3.f3796ad.qw();
        r0 = (fe.th.de.rrr.pf.fe) r4.request().qw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r0 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r0.o().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r3.f3798fe == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r0 = r3.f3799i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        if (r3.f3800o != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
        if (r3.f3801pf != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r3.f3799i.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0054, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0064, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0065, code lost:
        r3.f3798fe = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        onResponse(r4, r4.execute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0070, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0071, code lost:
        onFailure(r4, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.th.de.mmm yj(boolean r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3799i
            monitor-enter(r0)
            fe.th.de.mmm r1 = r3.f3800o     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x000b
            fe.th.de.mmm r4 = r3.f3800o     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r4
        L_0x000b:
            java.lang.Throwable r1 = r3.f3801pf     // Catch:{ all -> 0x0093 }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r4 == 0) goto L_0x001a
            fe.th.de.mmm r4 = r3.f141if     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x001a
            fe.th.de.mmm r4 = r3.f141if     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r4
        L_0x001a:
            java.lang.Throwable r4 = r3.f3801pf     // Catch:{ all -> 0x0093 }
            uk(r4)     // Catch:{ all -> 0x0093 }
            throw r2
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            com.duxiaoman.okhttp3.Call r4 = r3.fe()
            com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection$qw r0 = r3.f3796ad
            r0.qw()
            fe.th.de.ddd r0 = r4.request()
            fe.th.de.nn r0 = r0.qw()
            fe.th.de.rrr.pf.fe r0 = (fe.th.de.rrr.pf.fe) r0
            if (r0 == 0) goto L_0x003d
            java.io.OutputStream r0 = r0.o()
            r0.close()
        L_0x003d:
            boolean r0 = r3.f3798fe
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r3.f3799i
            monitor-enter(r0)
        L_0x0044:
            fe.th.de.mmm r4 = r3.f3800o     // Catch:{ InterruptedException -> 0x0056 }
            if (r4 != 0) goto L_0x0052
            java.lang.Throwable r4 = r3.f3801pf     // Catch:{ InterruptedException -> 0x0056 }
            if (r4 != 0) goto L_0x0052
            java.lang.Object r4 = r3.f3799i     // Catch:{ InterruptedException -> 0x0056 }
            r4.wait()     // Catch:{ InterruptedException -> 0x0056 }
            goto L_0x0044
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0074
        L_0x0054:
            r4 = move-exception
            goto L_0x0063
        L_0x0056:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0054 }
            r4.interrupt()     // Catch:{ all -> 0x0054 }
            java.io.InterruptedIOException r4 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0063:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r4
        L_0x0065:
            r0 = 1
            r3.f3798fe = r0
            fe.th.de.mmm r0 = r4.execute()     // Catch:{ IOException -> 0x0070 }
            r3.onResponse(r4, r0)     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r3.onFailure(r4, r0)
        L_0x0074:
            java.lang.Object r4 = r3.f3799i
            monitor-enter(r4)
            java.lang.Throwable r0 = r3.f3801pf     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x008a
            fe.th.de.mmm r0 = r3.f3800o     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0083
            fe.th.de.mmm r0 = r3.f3800o     // Catch:{ all -> 0x0090 }
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return r0
        L_0x0083:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x008a:
            java.lang.Throwable r0 = r3.f3801pf     // Catch:{ all -> 0x0090 }
            uk(r0)     // Catch:{ all -> 0x0090 }
            throw r2
        L_0x0090:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            throw r0
        L_0x0093:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection.yj(boolean):fe.th.de.mmm");
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j >= 0) {
            this.f3804uk = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public String getHeaderField(String str) {
        if (str != null) {
            return th().de(str);
        }
        try {
            return fe.th.de.rrr.uk.o.qw(yj(true)).toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public OkHttpURLConnection(URL url, ggg ggg2, URLFilter uRLFilter) {
        this(url, ggg2);
        this.f3803th = uRLFilter;
    }
}
