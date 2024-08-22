package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.s.a;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestDebugConfig;
import com.dxmpay.apollon.restnet.a;
import com.dxmpay.apollon.restnet.rest.c;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import fe.i.qw.th.de.qw;
import fe.i.qw.th.de.rg.ad;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class RestUrlConnection implements c {
    public static HttpsURLConnectionCallback mCallback;

    /* renamed from: ad  reason: collision with root package name */
    public String f4030ad;

    /* renamed from: de  reason: collision with root package name */
    public RestUrlConnectionRequest f4031de;

    /* renamed from: fe  reason: collision with root package name */
    public URLConnection f4032fe;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f4033rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f4034th = false;

    public interface HttpsURLConnectionCallback {
        void callback(HttpsURLConnection httpsURLConnection);
    }

    public RestUrlConnection(Context context, String str, boolean z) {
        this.qw = context.getApplicationContext();
        this.f4030ad = str;
        this.f4034th = z;
    }

    public final e ad(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        Map headerFields = httpURLConnection.getHeaderFields();
        String responseMessage = httpURLConnection.getResponseMessage();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(uRLConnection.getInputStream());
        NetStepStatManager.getInstance().recordReadCost(this.f4031de.h(), this.f4031de.g(), currentTimeMillis, System.currentTimeMillis() - currentTimeMillis);
        return new ad(bufferedInputStream, responseCode, responseMessage, headerFields);
    }

    public void close() {
        URLConnection uRLConnection = this.f4032fe;
        if (uRLConnection != null) {
            if (uRLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) uRLConnection).disconnect();
            } else if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            this.f4032fe = null;
        }
        if (this.f4034th) {
            pf();
        }
    }

    public final String de(String str) {
        RestUrlConnectionRequest restUrlConnectionRequest = this.f4031de;
        if (restUrlConnectionRequest == null) {
            return str;
        }
        String processedParams = restUrlConnectionRequest.getProcessedParams();
        if (TextUtils.isEmpty(processedParams)) {
            return str;
        }
        if (str.contains("?")) {
            return str + a.n + processedParams;
        }
        return str + "?" + processedParams;
    }

    public final void fe(URLConnection uRLConnection) {
        int i2 = 30000;
        if (this.f4033rg) {
            uRLConnection.setConnectTimeout(this.f4031de.rg() > 0 ? this.f4031de.rg() : 30000);
            if (this.f4031de.rg() > 0) {
                i2 = this.f4031de.rg();
            }
            uRLConnection.setReadTimeout(i2);
        } else {
            uRLConnection.setConnectTimeout(this.f4031de.rg() > 0 ? this.f4031de.rg() : 30000);
            if (this.f4031de.rg() > 0) {
                i2 = this.f4031de.rg();
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
        if (th()) {
            uRLConnection.setRequestProperty("User-Agent", "");
            uRLConnection.setRequestProperty("Accept-Encoding", "");
            uRLConnection.setRequestProperty("ua", "");
            return;
        }
        uRLConnection.setRequestProperty("User-Agent", this.f4030ad);
        uRLConnection.setRequestProperty("ua", this.f4030ad);
        for (Map.Entry next : this.f4031de.a().entrySet()) {
            uRLConnection.setRequestProperty((String) next.getKey(), (String) Collections.unmodifiableList((List) next.getValue()).get(0));
        }
        if (this.f4034th) {
            uk();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[SYNTHETIC, Splitter:B:28:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc A[SYNTHETIC, Splitter:B:32:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.net.URLConnection r14) {
        /*
            r13 = this;
            java.lang.String r0 = "RestUrlConnection"
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r1 = r13.f4031de
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = r1.getProcessedParams()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r2 = r13.f4031de
            com.dxmpay.apollon.restnet.RestMultipartEntity r2 = r2.de()
            r3 = 1
            r14.setDoOutput(r3)
            r14.setDoInput(r3)
            if (r2 == 0) goto L_0x0033
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "multipart/form-data;boundary="
            r3.append(r4)
            java.lang.String r4 = r2.qw()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Content-Type"
            r14.setRequestProperty(r4, r3)
        L_0x0033:
            r3 = 0
            long r8 = java.lang.System.currentTimeMillis()
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x007a }
            java.io.OutputStream r14 = r14.getOutputStream()     // Catch:{ IOException -> 0x007a }
            r12.<init>(r14)     // Catch:{ IOException -> 0x007a }
            r12.writeBytes(r1)     // Catch:{ IOException -> 0x0075, all -> 0x0072 }
            if (r2 == 0) goto L_0x0049
            r2.ad(r12)     // Catch:{ IOException -> 0x0075, all -> 0x0072 }
        L_0x0049:
            r12.flush()     // Catch:{ IOException -> 0x0075, all -> 0x0072 }
            long r1 = java.lang.System.currentTimeMillis()
            long r10 = r1 - r8
            com.dxmpay.wallet.statistics.NetStepStatManager r4 = com.dxmpay.wallet.statistics.NetStepStatManager.getInstance()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r14 = r13.f4031de
            java.lang.String r5 = r14.h()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r14 = r13.f4031de
            long r6 = r14.g()
            r4.recordWriteCost(r5, r6, r8, r10)
            r12.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x00c9
        L_0x0069:
            r14 = move-exception
            java.lang.String r1 = r14.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r1, r14)
            goto L_0x00c9
        L_0x0072:
            r14 = move-exception
            r3 = r12
            goto L_0x00a1
        L_0x0075:
            r14 = move-exception
            r3 = r12
            goto L_0x007b
        L_0x0078:
            r14 = move-exception
            goto L_0x00a1
        L_0x007a:
            r14 = move-exception
        L_0x007b:
            java.lang.String r1 = r14.getMessage()     // Catch:{ all -> 0x0078 }
            com.dxmpay.apollon.utils.LogUtil.e(r0, r1, r14)     // Catch:{ all -> 0x0078 }
            long r1 = java.lang.System.currentTimeMillis()
            long r10 = r1 - r8
            com.dxmpay.wallet.statistics.NetStepStatManager r4 = com.dxmpay.wallet.statistics.NetStepStatManager.getInstance()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r14 = r13.f4031de
            java.lang.String r5 = r14.h()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r14 = r13.f4031de
            long r6 = r14.g()
            r4.recordWriteCost(r5, r6, r8, r10)
            if (r3 == 0) goto L_0x00c9
            r3.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x00c9
        L_0x00a1:
            long r1 = java.lang.System.currentTimeMillis()
            long r10 = r1 - r8
            com.dxmpay.wallet.statistics.NetStepStatManager r4 = com.dxmpay.wallet.statistics.NetStepStatManager.getInstance()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r1 = r13.f4031de
            java.lang.String r5 = r1.h()
            com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest r1 = r13.f4031de
            long r6 = r1.g()
            r4.recordWriteCost(r5, r6, r8, r10)
            if (r3 == 0) goto L_0x00c8
            r3.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c8
        L_0x00c0:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r1)
        L_0x00c8:
            throw r14
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnection.i(java.net.URLConnection):void");
    }

    public final void o(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            httpsURLConnection.setHostnameVerifier(qw.qw);
        }
    }

    public e performRequest(d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.f4031de = (RestUrlConnectionRequest) dVar;
        String b = dVar.b();
        if (this.f4031de.yj()) {
            b = de(b);
        }
        URL url = new URL(b);
        this.f4032fe = url.openConnection();
        if ("https".equalsIgnoreCase(url.getProtocol())) {
            if (RestDebugConfig.getInstance().isQAEnv()) {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                ((HttpsURLConnection) this.f4032fe).setSSLSocketFactory(instance.getSocketFactory());
                HttpsURLConnectionCallback httpsURLConnectionCallback = mCallback;
                if (httpsURLConnectionCallback != null) {
                    httpsURLConnectionCallback.callback((HttpsURLConnection) this.f4032fe);
                }
            } else {
                rg((HttpsURLConnection) this.f4032fe);
                o((HttpsURLConnection) this.f4032fe);
            }
        }
        LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "con url: " + url + ", host: " + this.f4032fe.getURL().getHost());
        if (this.f4031de.th()) {
            return qw(url);
        }
        if (this.f4031de.yj()) {
            return yj(url);
        }
        return null;
    }

    public final void pf() {
        try {
            Class.forName("android.net.http.HttpResponseCache").getMethod("close", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public final e qw(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        fe(this.f4032fe);
        i(this.f4032fe);
        return ad(url, this.f4032fe, "POST");
    }

    public final void rg(HttpsURLConnection httpsURLConnection) {
        try {
            fe.i.qw.qw.ad adVar = new fe.i.qw.qw.ad(fe.i.qw.qw.qw.qw().ad(httpsURLConnection.getURL().getHost()));
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{adVar}, (SecureRandom) null);
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        } catch (KeyManagementException unused2) {
            throw new IllegalStateException("Should never happen");
        }
    }

    public final boolean th() {
        if (this.f4031de == null) {
            return false;
        }
        a.C0182a qw2 = com.dxmpay.apollon.restnet.a.qw();
        String f = this.f4031de.f();
        if (TextUtils.isEmpty(f) || qw2 == null || !qw2.a(f)) {
            return false;
        }
        return true;
    }

    public final void uk() {
        try {
            File file = new File(this.qw.getDir("appcache", 0), "http");
            Class.forName("android.net.http.HttpResponseCache").getMethod("install", new Class[]{File.class, Long.TYPE}).invoke((Object) null, new Object[]{file, 10485760L});
        } catch (Exception unused) {
        }
    }

    public final e yj(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        fe(this.f4032fe);
        return ad(url, this.f4032fe, ShareTarget.METHOD_GET);
    }
}
