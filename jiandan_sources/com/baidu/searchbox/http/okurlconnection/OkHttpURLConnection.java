package com.baidu.searchbox.http.okurlconnection;

import androidx.browser.trusted.sharing.ShareTarget;
import fe.fe.ddd.p001switch.pf.de;
import fe.fe.ddd.p001switch.pf.th;
import fe.fe.ddd.p001switch.pf.yj;
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
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    public static final String ggg = (Platform.get().getPrefix() + "-Selected-Protocol");
    public static final String vvv = (Platform.get().getPrefix() + "-Response-Source");
    public static final Set<String> xxx = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", ShareTarget.METHOD_GET, "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));

    /* renamed from: ad  reason: collision with root package name */
    public final qw f1044ad;

    /* renamed from: de  reason: collision with root package name */
    public Headers.Builder f1045de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f1046fe;

    /* renamed from: i  reason: collision with root package name */
    public final Object f1047i;

    /* renamed from: if  reason: not valid java name */
    public Response f15if;

    /* renamed from: o  reason: collision with root package name */
    public Response f1048o;

    /* renamed from: pf  reason: collision with root package name */
    public Throwable f1049pf;
    public Handshake ppp;
    public OkHttpClient qw;

    /* renamed from: rg  reason: collision with root package name */
    public Call f1050rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f16switch;

    /* renamed from: th  reason: collision with root package name */
    public URLFilter f1051th;

    /* renamed from: uk  reason: collision with root package name */
    public long f1052uk;
    public Proxy when;

    /* renamed from: yj  reason: collision with root package name */
    public Headers f1053yj;

    public static final class UnexpectedException extends IOException {
        public static final Interceptor INTERCEPTOR = new qw();

        public class qw implements Interceptor {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
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
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x008c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain r5) throws java.io.IOException {
            /*
                r4 = this;
                okhttp3.Request r0 = r5.request()
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r1 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this
                com.baidu.searchbox.http.okurlconnection.URLFilter r1 = r1.f1051th
                if (r1 == 0) goto L_0x0015
                okhttp3.HttpUrl r2 = r0.url()
                java.net.URL r2 = r2.url()
                r1.qw(r2)
            L_0x0015:
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r1 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this
                java.lang.Object r1 = r1.f1047i
                monitor-enter(r1)
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r2 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0099 }
                r3 = 0
                r2.f16switch = r3     // Catch:{ all -> 0x0099 }
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r2 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0099 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0099 }
                okhttp3.Route r3 = r3.route()     // Catch:{ all -> 0x0099 }
                java.net.Proxy r3 = r3.proxy()     // Catch:{ all -> 0x0099 }
                r2.when = r3     // Catch:{ all -> 0x0099 }
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r2 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0099 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0099 }
                okhttp3.Handshake r3 = r3.handshake()     // Catch:{ all -> 0x0099 }
                r2.ppp = r3     // Catch:{ all -> 0x0099 }
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r2 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0099 }
                java.lang.Object r2 = r2.f1047i     // Catch:{ all -> 0x0099 }
                r2.notifyAll()     // Catch:{ all -> 0x0099 }
            L_0x0046:
                boolean r2 = r4.qw     // Catch:{ InterruptedException -> 0x008c }
                if (r2 != 0) goto L_0x0054
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r2 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ InterruptedException -> 0x008c }
                java.lang.Object r2 = r2.f1047i     // Catch:{ InterruptedException -> 0x008c }
                r2.wait()     // Catch:{ InterruptedException -> 0x008c }
                goto L_0x0046
            L_0x0054:
                monitor-exit(r1)     // Catch:{ all -> 0x0099 }
                okhttp3.RequestBody r1 = r0.body()
                boolean r1 = r1 instanceof fe.fe.ddd.p001switch.pf.th
                if (r1 == 0) goto L_0x0067
                okhttp3.RequestBody r1 = r0.body()
                fe.fe.ddd.switch.pf.th r1 = (fe.fe.ddd.p001switch.pf.th) r1
                okhttp3.Request r0 = r1.fe(r0)
            L_0x0067:
                okhttp3.Response r5 = r5.proceed(r0)
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r0 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this
                java.lang.Object r0 = r0.f1047i
                monitor-enter(r0)
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r1 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0089 }
                r1.f15if = r5     // Catch:{ all -> 0x0089 }
                com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection r1 = com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.this     // Catch:{ all -> 0x0089 }
                okhttp3.Request r2 = r5.request()     // Catch:{ all -> 0x0089 }
                okhttp3.HttpUrl r2 = r2.url()     // Catch:{ all -> 0x0089 }
                java.net.URL r2 = r2.url()     // Catch:{ all -> 0x0089 }
                java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0089 }
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                return r5
            L_0x0089:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                throw r5
            L_0x008c:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0099 }
                r5.interrupt()     // Catch:{ all -> 0x0099 }
                java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0099 }
                r5.<init>()     // Catch:{ all -> 0x0099 }
                throw r5     // Catch:{ all -> 0x0099 }
            L_0x0099:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0099 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.qw.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
        }

        public void qw() {
            synchronized (OkHttpURLConnection.this.f1047i) {
                this.qw = true;
                OkHttpURLConnection.this.f1047i.notifyAll();
            }
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        this.f1044ad = new qw();
        this.f1045de = new Headers.Builder();
        this.f1052uk = -1;
        this.f1047i = new Object();
        this.f16switch = true;
        this.qw = okHttpClient;
    }

    public static String i(String str) {
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

    public static String uk(Response response) {
        if (response.networkResponse() == null) {
            if (response.cacheResponse() == null) {
                return "NONE";
            }
            return "CACHE " + response.code();
        } else if (response.cacheResponse() == null) {
            return "NETWORK " + response.code();
        } else {
            return "CONDITIONAL_CACHE " + response.networkResponse().code();
        }
    }

    public static IOException yj(Throwable th2) throws IOException {
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
            Platform platform = Platform.get();
            platform.log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f1045de.add(str, str2);
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
            boolean r0 = r2.f1046fe
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            okhttp3.Call r0 = r2.de()
            r1 = 1
            r2.f1046fe = r1
            r0.enqueue(r2)
            java.lang.Object r0 = r2.f1047i
            monitor-enter(r0)
        L_0x0012:
            boolean r1 = r2.f16switch     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            okhttp3.Response r1 = r2.f1048o     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Throwable r1 = r2.f1049pf     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Object r1 = r2.f1047i     // Catch:{ InterruptedException -> 0x0033 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0033 }
            goto L_0x0012
        L_0x0024:
            java.lang.Throwable r1 = r2.f1049pf     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x002a:
            java.lang.Throwable r1 = r2.f1049pf     // Catch:{ InterruptedException -> 0x0033 }
            yj(r1)     // Catch:{ InterruptedException -> 0x0033 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.connect():void");
    }

    public final Call de() throws IOException {
        th thVar;
        Call call = this.f1050rg;
        if (call != null) {
            return call;
        }
        boolean z = true;
        this.connected = true;
        if (this.doOutput) {
            if (ShareTarget.METHOD_GET.equals(this.method)) {
                this.method = "POST";
            } else if (!HttpMethod.permitsRequestBody(this.method)) {
                throw new ProtocolException(this.method + " does not support writing");
            }
        }
        if (this.f1045de.get("User-Agent") == null) {
            this.f1045de.add("User-Agent", fe());
        }
        if (HttpMethod.permitsRequestBody(this.method)) {
            if (this.f1045de.get("Content-Type") == null) {
                this.f1045de.add("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            }
            long j = -1;
            if (this.f1052uk == -1 && this.chunkLength <= 0) {
                z = false;
            }
            String str = this.f1045de.get("Content-Length");
            long j2 = this.f1052uk;
            if (j2 != -1) {
                j = j2;
            } else if (str != null) {
                j = Long.parseLong(str);
            }
            if (z) {
                thVar = new yj(j);
            } else {
                thVar = new fe.fe.ddd.p001switch.pf.qw(j);
            }
            thVar.rg().timeout((long) this.qw.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            thVar = null;
        }
        try {
            Request build = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.f1045de.build()).method(this.method, thVar).build();
            URLFilter uRLFilter = this.f1051th;
            if (uRLFilter != null) {
                uRLFilter.qw(build.url().url());
            }
            OkHttpClient.Builder newBuilder = this.qw.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
            newBuilder.networkInterceptors().clear();
            newBuilder.networkInterceptors().add(this.f1044ad);
            newBuilder.dispatcher(new Dispatcher(this.qw.dispatcher().executorService()));
            if (!getUseCaches()) {
                newBuilder.cache((Cache) null);
            }
            Call newCall = newBuilder.build().newCall(build);
            this.f1050rg = newCall;
            return newCall;
        } catch (IllegalArgumentException e) {
            if (Internal.instance.isInvalidHttpUrlHost(e)) {
                UnknownHostException unknownHostException = new UnknownHostException();
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
            MalformedURLException malformedURLException = new MalformedURLException();
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    public void disconnect() {
        if (this.f1050rg != null) {
            this.f1044ad.qw();
            this.f1050rg.cancel();
        }
    }

    public final String fe() {
        String property = System.getProperty("http.agent");
        return property != null ? i(property) : Version.userAgent();
    }

    public int getConnectTimeout() {
        return this.qw.connectTimeoutMillis();
    }

    public InputStream getErrorStream() {
        try {
            Response th2 = th(true);
            if (HttpHeaders.hasBody(th2) && th2.code() >= 400) {
                return th2.body().byteStream();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(int i2) {
        try {
            Headers rg2 = rg();
            if (i2 >= 0) {
                if (i2 < rg2.size()) {
                    return rg2.value(i2);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderFieldKey(int i2) {
        try {
            Headers rg2 = rg();
            if (i2 >= 0) {
                if (i2 < rg2.size()) {
                    return rg2.name(i2);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return de.qw(rg(), StatusLine.get(th(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public InputStream getInputStream() throws IOException {
        if (this.doInput) {
            Response th2 = th(false);
            if (th2.code() < 400) {
                return th2.body().byteStream();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public boolean getInstanceFollowRedirects() {
        return this.qw.followRedirects();
    }

    public OutputStream getOutputStream() throws IOException {
        th thVar = (th) de().request().body();
        if (thVar != null) {
            if (thVar instanceof yj) {
                connect();
                this.f1044ad.qw();
            }
            if (!thVar.ad()) {
                return thVar.de();
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
            i2 = HttpUrl.defaultPort(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.qw.proxy().address();
            host = inetSocketAddress.getHostName();
            i2 = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + i2, "connect, resolve");
    }

    public int getReadTimeout() {
        return this.qw.readTimeoutMillis();
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return de.qw(this.f1045de.build(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.f1045de.get(str);
    }

    public int getResponseCode() throws IOException {
        return th(true).code();
    }

    public String getResponseMessage() throws IOException {
        return th(true).message();
    }

    public void onFailure(Call call, IOException iOException) {
        synchronized (this.f1047i) {
            boolean z = iOException instanceof UnexpectedException;
            Throwable th2 = iOException;
            if (z) {
                th2 = iOException.getCause();
            }
            this.f1049pf = th2;
            this.f1047i.notifyAll();
        }
    }

    public void onResponse(Call call, Response response) {
        synchronized (this.f1047i) {
            this.f1048o = response;
            this.ppp = response.handshake();
            this.url = response.request().url().url();
            this.f1047i.notifyAll();
        }
    }

    public final Headers rg() throws IOException {
        if (this.f1053yj == null) {
            Response th2 = th(true);
            this.f1053yj = th2.headers().newBuilder().add(ggg, th2.protocol().toString()).add(vvv, uk(th2)).build();
        }
        return this.f1053yj;
    }

    public void setConnectTimeout(int i2) {
        this.qw = this.qw.newBuilder().connectTimeout((long) i2, TimeUnit.MILLISECONDS).build();
    }

    public void setFixedLengthStreamingMode(int i2) {
        setFixedLengthStreamingMode((long) i2);
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.f1045de.set("If-Modified-Since", HttpDate.format(new Date(this.ifModifiedSince)));
        } else {
            this.f1045de.removeAll("If-Modified-Since");
        }
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.qw = this.qw.newBuilder().followRedirects(z).build();
    }

    public void setReadTimeout(int i2) {
        this.qw = this.qw.newBuilder().readTimeout((long) i2, TimeUnit.MILLISECONDS).build();
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
            Platform platform = Platform.get();
            platform.log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
        } else {
            this.f1045de.set(str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        r4 = de();
        r3.f1044ad.qw();
        r0 = (fe.fe.ddd.p001switch.pf.th) r4.request().body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r0 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r0.de().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r3.f1046fe == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r0 = r3.f1047i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        if (r3.f1048o != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
        if (r3.f1049pf != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r3.f1047i.wait();
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
        r3.f1046fe = true;
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
    public final okhttp3.Response th(boolean r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1047i
            monitor-enter(r0)
            okhttp3.Response r1 = r3.f1048o     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x000b
            okhttp3.Response r4 = r3.f1048o     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r4
        L_0x000b:
            java.lang.Throwable r1 = r3.f1049pf     // Catch:{ all -> 0x0093 }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r4 == 0) goto L_0x001a
            okhttp3.Response r4 = r3.f15if     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x001a
            okhttp3.Response r4 = r3.f15if     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r4
        L_0x001a:
            java.lang.Throwable r4 = r3.f1049pf     // Catch:{ all -> 0x0093 }
            yj(r4)     // Catch:{ all -> 0x0093 }
            throw r2
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            okhttp3.Call r4 = r3.de()
            com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection$qw r0 = r3.f1044ad
            r0.qw()
            okhttp3.Request r0 = r4.request()
            okhttp3.RequestBody r0 = r0.body()
            fe.fe.ddd.switch.pf.th r0 = (fe.fe.ddd.p001switch.pf.th) r0
            if (r0 == 0) goto L_0x003d
            java.io.OutputStream r0 = r0.de()
            r0.close()
        L_0x003d:
            boolean r0 = r3.f1046fe
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r3.f1047i
            monitor-enter(r0)
        L_0x0044:
            okhttp3.Response r4 = r3.f1048o     // Catch:{ InterruptedException -> 0x0056 }
            if (r4 != 0) goto L_0x0052
            java.lang.Throwable r4 = r3.f1049pf     // Catch:{ InterruptedException -> 0x0056 }
            if (r4 != 0) goto L_0x0052
            java.lang.Object r4 = r3.f1047i     // Catch:{ InterruptedException -> 0x0056 }
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
            r3.f1046fe = r0
            okhttp3.Response r0 = r4.execute()     // Catch:{ IOException -> 0x0070 }
            r3.onResponse(r4, r0)     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r3.onFailure(r4, r0)
        L_0x0074:
            java.lang.Object r4 = r3.f1047i
            monitor-enter(r4)
            java.lang.Throwable r0 = r3.f1049pf     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x008a
            okhttp3.Response r0 = r3.f1048o     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0083
            okhttp3.Response r0 = r3.f1048o     // Catch:{ all -> 0x0090 }
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return r0
        L_0x0083:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x008a:
            java.lang.Throwable r0 = r3.f1049pf     // Catch:{ all -> 0x0090 }
            yj(r0)     // Catch:{ all -> 0x0090 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.th(boolean):okhttp3.Response");
    }

    public boolean usingProxy() {
        if (this.when != null) {
            return true;
        }
        Proxy proxy = this.qw.proxy();
        if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
            return false;
        }
        return true;
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j >= 0) {
            this.f1052uk = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public String getHeaderField(String str) {
        if (str != null) {
            return rg().get(str);
        }
        try {
            return StatusLine.get(th(true)).toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(url, okHttpClient);
        this.f1051th = uRLFilter;
    }
}
