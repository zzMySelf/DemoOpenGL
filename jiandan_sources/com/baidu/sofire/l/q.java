package com.baidu.sofire.l;

import android.accounts.NetworkErrorException;
import android.content.Context;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class q {
    public static final byte[] b = new byte[1024];
    public static OkHttpClient c;
    public Context a;

    public class a implements Interceptor {
        public a() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            System.currentTimeMillis();
            Request request = chain.request();
            Context context = q.this.a;
            Response proceed = chain.proceed(request);
            System.currentTimeMillis();
            return proceed;
        }
    }

    public q(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.OkHttpClient a() {
        /*
            r5 = this;
            okhttp3.OkHttpClient r0 = c
            if (r0 != 0) goto L_0x0033
            java.lang.Class<com.baidu.sofire.l.q> r0 = com.baidu.sofire.l.q.class
            monitor-enter(r0)
            okhttp3.OkHttpClient r1 = c     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            okhttp3.OkHttpClient$Builder r1 = new okhttp3.OkHttpClient$Builder     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            org.apache.http.conn.ssl.X509HostnameVerifier r2 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x0016 }
            r1.hostnameVerifier(r2)     // Catch:{ all -> 0x0016 }
            goto L_0x0018
        L_0x0016:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0030 }
        L_0x0018:
            r2 = 120000(0x1d4c0, double:5.9288E-319)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0030 }
            r1.connectTimeout(r2, r4)     // Catch:{ all -> 0x0030 }
            com.baidu.sofire.l.q$a r2 = new com.baidu.sofire.l.q$a     // Catch:{ all -> 0x0030 }
            r2.<init>()     // Catch:{ all -> 0x0030 }
            r1.addInterceptor(r2)     // Catch:{ all -> 0x0030 }
            okhttp3.OkHttpClient r1 = r1.build()     // Catch:{ all -> 0x0030 }
            c = r1     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            okhttp3.OkHttpClient r0 = c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.q.a():okhttp3.OkHttpClient");
    }

    public String b(String str, byte[] bArr, Map<String, String> map) {
        try {
            if (r.a(this.a)) {
                Response execute = a().newCall(a(str, bArr, map)).execute();
                int code = execute.code();
                if (code == 200) {
                    return execute.body().string();
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return "";
        }
    }

    public final Request a(String str, byte[] bArr, Map<String, String> map) {
        try {
            MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
            String str2 = c.p(this.a)[0];
            Request.Builder url = new Request.Builder().url(str);
            if (bArr != null) {
                url.post(RequestBody.create(parse, bArr));
            }
            Request.Builder addHeader = url.addHeader("User-Agent", "eos" + "/" + str2 + "/" + y.a(this.a) + "/" + "3.6.7.0").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
            addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", k.a(e.a(this.a)));
            if (map != null && map.size() > 0) {
                for (Map.Entry next : map.entrySet()) {
                    url.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
            return url.build();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public String a(String str, Map<String, String> map) {
        try {
            if (r.a(this.a)) {
                Response execute = a().newCall(a(str, (byte[]) null, map)).execute();
                int code = execute.code();
                if (code == 200) {
                    return execute.body().string();
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r5, java.io.File r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.a     // Catch:{ all -> 0x0070 }
            boolean r1 = com.baidu.sofire.l.r.a((android.content.Context) r1)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0068
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            okhttp3.Request$Builder r5 = r1.url((java.lang.String) r5)     // Catch:{ all -> 0x0070 }
            okhttp3.Request r5 = r5.build()     // Catch:{ all -> 0x0070 }
            okhttp3.OkHttpClient r1 = r4.a()     // Catch:{ all -> 0x0070 }
            okhttp3.Call r5 = r1.newCall(r5)     // Catch:{ all -> 0x0070 }
            okhttp3.Response r5 = r5.execute()     // Catch:{ all -> 0x0070 }
            int r1 = r5.code()     // Catch:{ all -> 0x0070 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x005e
            okhttp3.ResponseBody r5 = r5.body()     // Catch:{ all -> 0x0070 }
            java.io.InputStream r5 = r5.byteStream()     // Catch:{ all -> 0x0070 }
            if (r5 != 0) goto L_0x0035
            goto L_0x0059
        L_0x0035:
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0057 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0057 }
            r2.<init>(r6)     // Catch:{ all -> 0x0057 }
            r1.<init>(r2)     // Catch:{ all -> 0x0057 }
        L_0x003f:
            byte[] r6 = b     // Catch:{ all -> 0x0057 }
            int r2 = r5.read(r6)     // Catch:{ all -> 0x0057 }
            r3 = -1
            if (r2 == r3) goto L_0x004f
            r1.write(r6, r0, r2)     // Catch:{ all -> 0x0057 }
            r1.flush()     // Catch:{ all -> 0x0057 }
            goto L_0x003f
        L_0x004f:
            r1.flush()     // Catch:{ all -> 0x0057 }
            r1.close()     // Catch:{ all -> 0x0057 }
            r6 = 1
            goto L_0x005a
        L_0x0057:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0070 }
        L_0x0059:
            r6 = 0
        L_0x005a:
            r5.close()     // Catch:{ all -> 0x0070 }
            return r6
        L_0x005e:
            android.accounts.NetworkErrorException r5 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0070 }
            r5.<init>(r6)     // Catch:{ all -> 0x0070 }
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0068:
            android.accounts.NetworkErrorException r5 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = "Not allow background connect."
            r5.<init>(r6)     // Catch:{ all -> 0x0070 }
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            int r5 = com.baidu.sofire.a.a.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.q.a(java.lang.String, java.io.File):boolean");
    }

    public static boolean a(Context context) {
        boolean z;
        if (context.getPackageName().contains("com.baidu.searchbox")) {
            try {
                OkHttpClient.class.toString();
                z = true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
