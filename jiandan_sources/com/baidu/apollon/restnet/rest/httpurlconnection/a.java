package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.restnet.b;
import com.baidu.apollon.restnet.c;
import com.baidu.apollon.restnet.http.OkHttpFactory;
import com.baidu.apollon.restnet.rest.c;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class a implements c {
    public static final String e = "appcache";

    /* renamed from: i  reason: collision with root package name */
    public static final int f712i = 2;
    public Context a;
    public String b;
    public RestUrlConnectionRequest c;
    public URLConnection d;
    public b f;
    public boolean g;
    public boolean h = false;

    public a(Context context, String str, boolean z) {
        this.a = DxmApplicationContextImpl.getApplicationContext(context);
        this.b = str;
        this.h = z;
    }

    private e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        a(this.d);
        return a(url, this.d, ShareTarget.METHOD_GET);
    }

    private void c() {
        ((HttpsURLConnection) this.d).setHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                try {
                    Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                    String v = a.this.c.a().v();
                    if (!TextUtils.isEmpty(v) && peerCertificates != null && peerCertificates.length > 0) {
                        X509Certificate x509Certificate = (X509Certificate) peerCertificates[0];
                        Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                        if (subjectAlternativeNames != null) {
                            for (List next : subjectAlternativeNames) {
                                if (((Integer) next.get(0)).intValue() == 2) {
                                    String str2 = (String) next.get(1);
                                    if (v.equals(str2)) {
                                        return true;
                                    }
                                    if (str2 != null && str2.startsWith("*") && Pattern.compile(str2.replace("*", "(\\w*-*\\w*)")).matcher(v).matches()) {
                                        return true;
                                    }
                                }
                            }
                        } else {
                            String name = x509Certificate.getSubjectDN().getName();
                            if (!TextUtils.isEmpty(name) && name.contains("CN=")) {
                                int indexOf = name.indexOf("CN=") + 3;
                                int indexOf2 = name.indexOf(",", indexOf);
                                if (v.equals(indexOf2 > indexOf ? name.substring(indexOf, indexOf2) : name.substring(indexOf))) {
                                    return true;
                                }
                            }
                        }
                    }
                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                } catch (CertificateParsingException e2) {
                    e2.printStackTrace();
                }
                return false;
            }
        });
    }

    private boolean d() {
        if (this.c == null) {
            return false;
        }
        c.a a2 = com.baidu.apollon.restnet.c.a();
        String h2 = this.c.h();
        if (TextUtils.isEmpty(h2) || a2 == null || !a2.a(h2)) {
            return false;
        }
        return true;
    }

    private void e() {
        try {
            File file = new File(this.a.getDir("appcache", 0), "http");
            Class.forName("android.net.http.HttpResponseCache").getMethod("install", new Class[]{File.class, Long.TYPE}).invoke((Object) null, new Object[]{file, 10485760L});
        } catch (Exception unused) {
        }
    }

    private void f() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("close", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public e a(d dVar) throws Exception {
        URL url;
        String str;
        String str2 = "";
        this.c = (RestUrlConnectionRequest) dVar;
        String c2 = dVar.c();
        if (this.c.k()) {
            c2 = a(c2);
        }
        URI create = URI.create(c2);
        boolean z = false;
        boolean z2 = RestDebugConfig.isEnableOkHttp() && RestDebugConfig.allowUseOkHttp(create.getPath());
        if (z2) {
            url = new URL((URL) null, c2, OkHttpFactory.getInstance().getURLStreamHandler(create.getScheme()));
        } else {
            url = new URL(c2);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.d = url.openConnection();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                if (!RestDebugConfig.getInstance().isQAEnv()) {
                    b((HttpsURLConnection) this.d);
                } else if (this.f != null) {
                    this.f.a(this.d);
                }
            }
            LogUtil.v("apollon_rest", "con url: " + url + ", host: " + this.d.getURL().getHost());
            if (this.c.j()) {
                e a2 = a(url);
                if (RestDebugConfig.isEnableNetworkStats()) {
                    int responseCode = ((HttpURLConnection) this.d).getResponseCode();
                    String requestProperty = this.d.getRequestProperty("X-Fallback-Connection");
                    if (!TextUtils.isEmpty(str2)) {
                        com.baidu.apollon.restnet.a a3 = com.baidu.apollon.restnet.a.a();
                        b.a c3 = new b.a().b(z2).a(SystemClock.uptimeMillis() - uptimeMillis).a(create).a(true).a(str2).b(str2).c("1".equals(requestProperty));
                        if (requestProperty != null) {
                            z = true;
                        }
                        a3.a(c3.d(z).a(responseCode).a());
                    }
                }
                return a2;
            } else if (this.c.k()) {
                e b2 = b(url);
                if (RestDebugConfig.isEnableNetworkStats()) {
                    int responseCode2 = ((HttpURLConnection) this.d).getResponseCode();
                    String requestProperty2 = this.d.getRequestProperty("X-Fallback-Connection");
                    if (!TextUtils.isEmpty(str2)) {
                        com.baidu.apollon.restnet.a a4 = com.baidu.apollon.restnet.a.a();
                        b.a c4 = new b.a().b(z2).a(SystemClock.uptimeMillis() - uptimeMillis).a(create).a(true).a(str2).b(str2).c("1".equals(requestProperty2));
                        if (requestProperty2 != null) {
                            z = true;
                        }
                        a4.a(c4.d(z).a(responseCode2).a());
                    }
                }
                return b2;
            } else {
                if (RestDebugConfig.isEnableNetworkStats()) {
                    int responseCode3 = ((HttpURLConnection) this.d).getResponseCode();
                    String requestProperty3 = this.d.getRequestProperty("X-Fallback-Connection");
                    if (!TextUtils.isEmpty(str2)) {
                        com.baidu.apollon.restnet.a a5 = com.baidu.apollon.restnet.a.a();
                        b.a c5 = new b.a().b(z2).a(SystemClock.uptimeMillis() - uptimeMillis).a(create).a(true).a(str2).b(str2).c("1".equals(requestProperty3));
                        if (requestProperty3 != null) {
                            z = true;
                        }
                        a5.a(c5.d(z).a(responseCode3).a());
                    }
                }
                return null;
            }
        } catch (Exception e2) {
            if (RestDebugConfig.isEnableNetworkStats()) {
                int i2 = -1;
                if (0 != 0) {
                    i2 = ((HttpURLConnection) this.d).getResponseCode();
                    str = str2;
                } else {
                    str = e2.getMessage();
                    if (URLUtil.isValidUrl(str)) {
                        str = CheckUtils.stripUrlParams(str);
                    }
                }
                String requestProperty4 = this.d.getRequestProperty("X-Fallback-Connection");
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.apollon.restnet.a a6 = com.baidu.apollon.restnet.a.a();
                    b.a a7 = new b.a().b(z2).a(SystemClock.uptimeMillis() - uptimeMillis).a(create).a(false);
                    if (0 == 0) {
                        str2 = e2.getClass().getName();
                    }
                    b.a c6 = a7.a(str2).b(str).c("1".equals(requestProperty4));
                    if (requestProperty4 != null) {
                        z = true;
                    }
                    a6.a(c6.d(z).a(i2).a());
                }
            }
            throw e2;
        } catch (Throwable th2) {
            if (RestDebugConfig.isEnableNetworkStats()) {
                int responseCode4 = ((HttpURLConnection) this.d).getResponseCode();
                String requestProperty5 = this.d.getRequestProperty("X-Fallback-Connection");
                if (!TextUtils.isEmpty(str2)) {
                    com.baidu.apollon.restnet.a a8 = com.baidu.apollon.restnet.a.a();
                    b.a c7 = new b.a().b(z2).a(SystemClock.uptimeMillis() - uptimeMillis).a(create).a(true).a(str2).b(str2).c("1".equals(requestProperty5));
                    if (requestProperty5 != null) {
                        z = true;
                    }
                    a8.a(c7.d(z).a(responseCode4).a());
                }
            }
            throw th2;
        }
    }

    private void b(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            httpsURLConnection.setHostnameVerifier(com.baidu.apollon.restnet.rest.a.a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[SYNTHETIC, Splitter:B:24:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[SYNTHETIC, Splitter:B:29:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.net.URLConnection r5) {
        /*
            r4 = this;
            com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r0 = r4.c
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r0.getProcessedParams()
            com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r1 = r4.c
            com.baidu.apollon.restnet.RestMultipartEntity r1 = r1.i()
            r2 = 1
            r5.setDoOutput(r2)
            r5.setDoInput(r2)
            if (r1 == 0) goto L_0x0031
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "multipart/form-data;boundary="
            r2.append(r3)
            java.lang.String r3 = r1.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Content-Type"
            r5.setRequestProperty(r3, r2)
        L_0x0031:
            r2 = 0
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0052 }
            java.io.OutputStream r5 = r5.getOutputStream()     // Catch:{ IOException -> 0x0052 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0052 }
            r3.writeBytes(r0)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            if (r1 == 0) goto L_0x0043
            r1.a(r3)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
        L_0x0043:
            r3.flush()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            r3.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006c
        L_0x004a:
            r5 = move-exception
            r2 = r3
            goto L_0x0061
        L_0x004d:
            r5 = move-exception
            r2 = r3
            goto L_0x0053
        L_0x0050:
            r5 = move-exception
            goto L_0x0061
        L_0x0052:
            r5 = move-exception
        L_0x0053:
            r5.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006c
        L_0x005c:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x006c
        L_0x0061:
            if (r2 == 0) goto L_0x006b
            r2.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006b:
            throw r5
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.restnet.rest.httpurlconnection.a.b(java.net.URLConnection):void");
    }

    public b b() {
        return this.f;
    }

    public void a() {
        URLConnection uRLConnection = this.d;
        if (uRLConnection != null) {
            if (uRLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) uRLConnection).disconnect();
            } else if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            this.d = null;
        }
        if (this.h) {
            f();
        }
    }

    private e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        a(this.d);
        b(this.d);
        return a(url, this.d, "POST");
    }

    private e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        Map headerFields = httpURLConnection.getHeaderFields();
        return new d(new BufferedInputStream(uRLConnection.getInputStream()), responseCode, httpURLConnection.getResponseMessage(), headerFields);
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        try {
            com.baidu.apollon.b.b bVar = new com.baidu.apollon.b.b(com.baidu.apollon.b.a.a().a(httpsURLConnection.getURL().getHost()));
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{bVar}, (SecureRandom) null);
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        } catch (KeyManagementException unused2) {
            throw new IllegalStateException("Should never happen");
        }
    }

    private void a(URLConnection uRLConnection) {
        int i2 = 30000;
        if (this.g) {
            uRLConnection.setConnectTimeout(this.c.g() > 0 ? this.c.g() : 30000);
            if (this.c.g() > 0) {
                i2 = this.c.g();
            }
            uRLConnection.setReadTimeout(i2);
        } else {
            uRLConnection.setConnectTimeout(this.c.g() > 0 ? this.c.g() : 30000);
            if (this.c.g() > 0) {
                i2 = this.c.g();
            }
            uRLConnection.setReadTimeout(i2);
        }
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
            System.setProperty("http.maxConnections ", String.valueOf(10));
            System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
        }
        if (d()) {
            uRLConnection.setRequestProperty("User-Agent", "");
            uRLConnection.setRequestProperty("Accept-Encoding", "");
            return;
        }
        uRLConnection.setRequestProperty("User-Agent", this.b);
        for (Map.Entry next : this.c.a().entrySet()) {
            uRLConnection.setRequestProperty((String) next.getKey(), (String) Collections.unmodifiableList((List) next.getValue()).get(0));
        }
        if (this.h) {
            e();
        }
    }

    private String a(String str) {
        RestUrlConnectionRequest restUrlConnectionRequest = this.c;
        if (restUrlConnectionRequest == null) {
            return str;
        }
        String processedParams = restUrlConnectionRequest.getProcessedParams();
        if (TextUtils.isEmpty(processedParams)) {
            return str;
        }
        if (str.contains("?")) {
            return str + com.alipay.sdk.m.s.a.n + processedParams;
        }
        return str + "?" + processedParams;
    }

    public void a(b bVar) {
        this.f = bVar;
    }
}
