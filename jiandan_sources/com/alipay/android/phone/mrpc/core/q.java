package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alipay.sdk.m.u.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class q implements Callable<u> {
    public static final HttpRequestRetryHandler e = new ad();
    public l a;
    public Context b;
    public o c;
    public String d;
    public HttpUriRequest f;
    public HttpContext g = new BasicHttpContext();
    public CookieStore h = new BasicCookieStore();

    /* renamed from: i  reason: collision with root package name */
    public CookieManager f651i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public int m = 0;
    public boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f652o = false;
    public String p = null;
    public String q;

    public q(l lVar, o oVar) {
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    public static long a(String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("max-age".equalsIgnoreCase(strArr[i2])) {
                int i3 = i2 + 1;
                if (strArr[i3] != null) {
                    try {
                        return Long.parseLong(strArr[i3]);
                    } catch (Exception unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0 A[SYNTHETIC, Splitter:B:23:0x00c0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alipay.android.phone.mrpc.core.u a(org.apache.http.HttpResponse r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "ArrayOutputStream close error!"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "开始handle，handleResponse-1,"
            r1.<init>(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            long r2 = r2.getId()
            r1.append(r2)
            org.apache.http.HttpEntity r1 = r10.getEntity()
            r2 = 0
            if (r1 == 0) goto L_0x00d0
            org.apache.http.StatusLine r3 = r10.getStatusLine()
            int r3 = r3.getStatusCode()
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x00d0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "200，开始处理，handleResponse-2,threadid = "
            r3.<init>(r4)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            long r4 = r4.getId()
            r3.append(r4)
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00bd }
            r3.<init>()     // Catch:{ all -> 0x00bd }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
            r9.a(r1, r3)     // Catch:{ all -> 0x00ba }
            byte[] r1 = r3.toByteArray()     // Catch:{ all -> 0x00ba }
            r6 = 0
            r9.f652o = r6     // Catch:{ all -> 0x00ba }
            com.alipay.android.phone.mrpc.core.l r6 = r9.a     // Catch:{ all -> 0x00ba }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
            long r7 = r7 - r4
            r6.c(r7)     // Catch:{ all -> 0x00ba }
            com.alipay.android.phone.mrpc.core.l r4 = r9.a     // Catch:{ all -> 0x00ba }
            int r5 = r1.length     // Catch:{ all -> 0x00ba }
            long r5 = (long) r5     // Catch:{ all -> 0x00ba }
            r4.a((long) r5)     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = "res:"
            r4.<init>(r5)     // Catch:{ all -> 0x00ba }
            int r5 = r1.length     // Catch:{ all -> 0x00ba }
            r4.append(r5)     // Catch:{ all -> 0x00ba }
            com.alipay.android.phone.mrpc.core.p r4 = new com.alipay.android.phone.mrpc.core.p     // Catch:{ all -> 0x00ba }
            com.alipay.android.phone.mrpc.core.HttpUrlHeader r5 = a((org.apache.http.HttpResponse) r10)     // Catch:{ all -> 0x00ba }
            r4.<init>(r5, r11, r12, r1)     // Catch:{ all -> 0x00ba }
            long r11 = b(r10)     // Catch:{ all -> 0x00ba }
            org.apache.http.HttpEntity r10 = r10.getEntity()     // Catch:{ all -> 0x00ba }
            org.apache.http.Header r10 = r10.getContentType()     // Catch:{ all -> 0x00ba }
            if (r10 == 0) goto L_0x0099
            java.lang.String r10 = r10.getValue()     // Catch:{ all -> 0x00ba }
            java.util.HashMap r10 = a((java.lang.String) r10)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "charset"
            java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x00ba }
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "Content-Type"
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x00ba }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00ba }
            goto L_0x009a
        L_0x0099:
            r10 = r2
        L_0x009a:
            r4.b(r10)     // Catch:{ all -> 0x00ba }
            r4.a((java.lang.String) r2)     // Catch:{ all -> 0x00ba }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ba }
            r4.a((long) r1)     // Catch:{ all -> 0x00ba }
            r4.b(r11)     // Catch:{ all -> 0x00ba }
            r3.close()     // Catch:{ IOException -> 0x00af }
            r2 = r4
            goto L_0x00d9
        L_0x00af:
            r10 = move-exception
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.Throwable r10 = r10.getCause()
            r11.<init>(r0, r10)
            throw r11
        L_0x00ba:
            r10 = move-exception
            r2 = r3
            goto L_0x00be
        L_0x00bd:
            r10 = move-exception
        L_0x00be:
            if (r2 == 0) goto L_0x00cf
            r2.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00cf
        L_0x00c4:
            r10 = move-exception
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.Throwable r10 = r10.getCause()
            r11.<init>(r0, r10)
            throw r11
        L_0x00cf:
            throw r10
        L_0x00d0:
            if (r1 != 0) goto L_0x00d9
            org.apache.http.StatusLine r10 = r10.getStatusLine()
            r10.getStatusCode()
        L_0x00d9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.a(org.apache.http.HttpResponse, int, java.lang.String):com.alipay.android.phone.mrpc.core.u");
    }

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(i.b)) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a2 = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a2.read(bArr);
                if (read == -1 || this.c.h()) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    ac f2 = this.c.f();
                }
            }
            outputStream.flush();
            r.a(a2);
        } catch (Exception e2) {
            e2.getCause();
            throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
        } catch (Throwable th2) {
            r.a(a2);
            throw th2;
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0;
    }

    private URI b() {
        String a2 = this.c.a();
        String str = this.d;
        if (str != null) {
            a2 = str;
        }
        if (a2 != null) {
            return new URI(a2);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b2 = this.c.b();
            String b3 = this.c.b("gzip");
            if (b2 != null) {
                if (TextUtils.equals(b3, "true")) {
                    this.j = b.a(b2);
                } else {
                    this.j = new ByteArrayEntity(b2);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x022f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0256 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0106 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0109 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015c A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0169 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01de A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x020f A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0216 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alipay.android.phone.mrpc.core.u call() {
        /*
            r14 = this;
            java.lang.String r0 = "connectivity"
        L_0x0002:
            r1 = 3
            r2 = 6
            r3 = 2
            r4 = 0
            android.content.Context r5 = r14.b     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.net.NetworkInfo[] r5 = r5.getAllNetworkInfo()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r6 = 1
            if (r5 != 0) goto L_0x0017
        L_0x0015:
            r5 = 0
            goto L_0x0030
        L_0x0017:
            int r7 = r5.length     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r8 = 0
        L_0x0019:
            if (r8 >= r7) goto L_0x0015
            r9 = r5[r8]     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r9 == 0) goto L_0x002d
            boolean r10 = r9.isAvailable()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r10 == 0) goto L_0x002d
            boolean r9 = r9.isConnectedOrConnecting()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r9 == 0) goto L_0x002d
            r5 = 1
            goto L_0x0030
        L_0x002d:
            int r8 = r8 + 1
            goto L_0x0019
        L_0x0030:
            if (r5 == 0) goto L_0x0256
            com.alipay.android.phone.mrpc.core.o r5 = r14.c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.util.ArrayList r5 = r5.d()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r5 == 0) goto L_0x0058
            boolean r7 = r5.isEmpty()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r7 != 0) goto L_0x0058
            java.util.Iterator r5 = r5.iterator()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0044:
            boolean r7 = r5.hasNext()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r7 == 0) goto L_0x0058
            java.lang.Object r7 = r5.next()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.Header r7 = (org.apache.http.Header) r7     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.methods.HttpUriRequest r8 = r14.c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r8.addHeader(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            goto L_0x0044
        L_0x0058:
            org.apache.http.client.methods.HttpUriRequest r5 = r14.c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.b.a((org.apache.http.HttpRequest) r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.methods.HttpUriRequest r5 = r14.c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.b.b((org.apache.http.HttpRequest) r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.methods.HttpUriRequest r5 = r14.c()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r7 = "cookie"
            android.webkit.CookieManager r8 = r14.i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.o r9 = r14.c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = r9.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r8 = r8.getCookie(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.addHeader(r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.protocol.HttpContext r5 = r14.g     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r7 = "http.cookie-store"
            org.apache.http.client.CookieStore r8 = r14.h     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.setAttribute(r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.l r5 = r14.a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.b r5 = r5.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.HttpRequestRetryHandler r7 = e     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.a((org.apache.http.client.HttpRequestRetryHandler) r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = "By Http/Https to request. operationType="
            r5.<init>(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = r14.f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = " url="
            r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.methods.HttpUriRequest r9 = r14.f     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.net.URI r9 = r9.getURI()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = r9.toString()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.append(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.l r5 = r14.a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.b r5 = r5.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.params.HttpParams r5 = r5.getParams()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = "http.route.default-proxy"
            android.content.Context r10 = r14.b     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.Object r10 = r10.getSystemService(r0)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.net.ConnectivityManager r10 = (android.net.ConnectivityManager) r10     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.net.NetworkInfo r10 = r10.getActiveNetworkInfo()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r11 = 0
            if (r10 == 0) goto L_0x00e6
            boolean r10 = r10.isAvailable()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r10 == 0) goto L_0x00e6
            java.lang.String r10 = android.net.Proxy.getDefaultHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            int r12 = android.net.Proxy.getDefaultPort()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r10 == 0) goto L_0x00e6
            org.apache.http.HttpHost r13 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r13.<init>(r10, r12)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            goto L_0x00e7
        L_0x00e6:
            r13 = r11
        L_0x00e7:
            if (r13 == 0) goto L_0x00fe
            java.lang.String r10 = r13.getHostName()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r12 = "127.0.0.1"
            boolean r10 = android.text.TextUtils.equals(r10, r12)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r10 == 0) goto L_0x00fe
            int r10 = r13.getPort()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r12 = 8087(0x1f97, float:1.1332E-41)
            if (r10 != r12) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r11 = r13
        L_0x00ff:
            r5.setParameter(r9, r11)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.HttpHost r5 = r14.k     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r5 == 0) goto L_0x0109
            org.apache.http.HttpHost r5 = r14.k     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            goto L_0x0121
        L_0x0109:
            java.net.URL r5 = r14.h()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.HttpHost r9 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = r5.getHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            int r11 = r14.g()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r5 = r5.getProtocol()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.<init>(r10, r11, r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r14.k = r9     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5 = r9
        L_0x0121:
            int r9 = r14.g()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r10 = 80
            if (r9 != r10) goto L_0x0136
            org.apache.http.HttpHost r5 = new org.apache.http.HttpHost     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.net.URL r9 = r14.h()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = r9.getHost()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r5.<init>(r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0136:
            com.alipay.android.phone.mrpc.core.l r9 = r14.a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.b r9 = r9.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.methods.HttpUriRequest r10 = r14.f     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.protocol.HttpContext r11 = r14.g     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.HttpResponse r5 = r9.execute((org.apache.http.HttpHost) r5, (org.apache.http.HttpRequest) r10, (org.apache.http.protocol.HttpContext) r11)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.l r11 = r14.a     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            long r9 = r9 - r7
            r11.b((long) r9)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.client.CookieStore r7 = r14.h     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.util.List r7 = r7.getCookies()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.o r8 = r14.c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            boolean r8 = r8.e()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r8 == 0) goto L_0x0163
            android.webkit.CookieManager r8 = r14.i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r8.removeAllCookie()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0163:
            boolean r8 = r7.isEmpty()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r8 != 0) goto L_0x01ca
            java.util.Iterator r7 = r7.iterator()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x016d:
            boolean r8 = r7.hasNext()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r7.next()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.cookie.Cookie r8 = (org.apache.http.cookie.Cookie) r8     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r9 = r8.getDomain()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r9 == 0) goto L_0x016d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.<init>()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = r8.getName()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = "="
            r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = r8.getValue()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = "; domain="
            r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = r8.getDomain()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.append(r10)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            boolean r8 = r8.isSecure()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r8 == 0) goto L_0x01ac
            java.lang.String r8 = "; Secure"
            goto L_0x01ae
        L_0x01ac:
            java.lang.String r8 = ""
        L_0x01ae:
            r9.append(r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r8 = r9.toString()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.webkit.CookieManager r9 = r14.i()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.o r10 = r14.c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r10 = r10.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9.setCookie(r10, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            android.webkit.CookieSyncManager r8 = android.webkit.CookieSyncManager.getInstance()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r8.sync()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            goto L_0x016d
        L_0x01ca:
            org.apache.http.StatusLine r7 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            int r7 = r7.getStatusCode()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.StatusLine r8 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r8 = r8.getReasonPhrase()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r7 == r9) goto L_0x0201
            r9 = 304(0x130, float:4.26E-43)
            if (r7 != r9) goto L_0x01e3
            goto L_0x01e4
        L_0x01e3:
            r6 = 0
        L_0x01e4:
            if (r6 == 0) goto L_0x01e7
            goto L_0x0201
        L_0x01e7:
            com.alipay.android.phone.mrpc.core.HttpException r6 = new com.alipay.android.phone.mrpc.core.HttpException     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.StatusLine r7 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            int r7 = r7.getStatusCode()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            org.apache.http.StatusLine r5 = r5.getStatusLine()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r5 = r5.getReasonPhrase()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r6.<init>(r7, r5)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            throw r6     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0201:
            com.alipay.android.phone.mrpc.core.u r5 = r14.a(r5, r7, r8)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r6 = -1
            if (r5 == 0) goto L_0x0216
            byte[] r8 = r5.b()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r8 == 0) goto L_0x0216
            byte[] r8 = r5.b()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            int r8 = r8.length     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            long r8 = (long) r8     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            goto L_0x0217
        L_0x0216:
            r8 = r6
        L_0x0217:
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x022f
            boolean r6 = r5 instanceof com.alipay.android.phone.mrpc.core.p     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r6 == 0) goto L_0x022f
            r6 = r5
            com.alipay.android.phone.mrpc.core.p r6 = (com.alipay.android.phone.mrpc.core.p) r6     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            com.alipay.android.phone.mrpc.core.HttpUrlHeader r6 = r6.a()     // Catch:{ Exception -> 0x022f }
            java.lang.String r7 = "Content-Length"
            java.lang.String r6 = r6.getHead(r7)     // Catch:{ Exception -> 0x022f }
            java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x022f }
        L_0x022f:
            com.alipay.android.phone.mrpc.core.o r6 = r14.c     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r6 = r6.a()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r6 == 0) goto L_0x0255
            java.lang.String r7 = r14.f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            if (r7 != 0) goto L_0x0255
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r7.<init>()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r6 = "#"
            r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r6 = r14.f()     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            r7.append(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0255:
            return r5
        L_0x0256:
            com.alipay.android.phone.mrpc.core.HttpException r5 = new com.alipay.android.phone.mrpc.core.HttpException     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            java.lang.String r7 = "The network is not available"
            r5.<init>(r6, r7)     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
            throw r5     // Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }
        L_0x0262:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0276
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x0276:
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x0284:
            r1 = move-exception
            r14.e()
            int r2 = r14.m
            if (r2 > 0) goto L_0x0292
            int r2 = r2 + 1
            r14.m = r2
            goto L_0x0002
        L_0x0292:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            com.alipay.android.phone.mrpc.core.HttpException r0 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.<init>(r2, r1)
            throw r0
        L_0x02a8:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x02bc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x02bc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x02d2:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x02e6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x02e6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x02fe:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0312
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x0312:
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            r2 = 8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x0322:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0336
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x0336:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x034d:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0361
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x0361:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x0378:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r2 = r14.c
            com.alipay.android.phone.mrpc.core.ac r2 = r2.f()
            if (r2 == 0) goto L_0x038c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
        L_0x038c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r2 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.<init>(r1, r0)
            throw r2
        L_0x03a2:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r2 = r14.c
            com.alipay.android.phone.mrpc.core.ac r2 = r2.f()
            if (r2 == 0) goto L_0x03b6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
        L_0x03b6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r2 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.<init>(r1, r0)
            throw r2
        L_0x03cc:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x03e0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x03e0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x03f6:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x040a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x040a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x0420:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0434
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
        L_0x0434:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.alipay.android.phone.mrpc.core.HttpException r1 = new com.alipay.android.phone.mrpc.core.HttpException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r2, r0)
            throw r1
        L_0x044a:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r2 = "Url parser error!"
            r1.<init>(r2, r0)
            throw r1
        L_0x0457:
            r0 = move-exception
            r14.e()
            com.alipay.android.phone.mrpc.core.o r1 = r14.c
            com.alipay.android.phone.mrpc.core.ac r1 = r1.f()
            if (r1 == 0) goto L_0x0469
            r0.getCode()
            r0.getMsg()
        L_0x0469:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        String b2 = this.c.b("operationType");
        this.q = b2;
        return b2;
    }

    private int g() {
        URL h2 = h();
        return h2.getPort() == -1 ? h2.getDefaultPort() : h2.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.f651i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager instance = CookieManager.getInstance();
        this.f651i = instance;
        return instance;
    }

    public final o a() {
        return this.c;
    }
}
