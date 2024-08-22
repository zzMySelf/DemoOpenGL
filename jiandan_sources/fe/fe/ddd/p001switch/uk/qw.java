package fe.fe.ddd.p001switch.uk;

import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.u.i;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

/* renamed from: fe.fe.ddd.switch.uk.qw  reason: invalid package */
public class qw implements Interceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static Method f1639ad;

    /* renamed from: de  reason: collision with root package name */
    public static ReferenceQueue<de> f1640de = new ReferenceQueue<>();

    /* renamed from: fe  reason: collision with root package name */
    public static ConcurrentHashMap<Long, fe> f1641fe = new ConcurrentHashMap<>();

    /* renamed from: rg  reason: collision with root package name */
    public static AtomicLong f1642rg = new AtomicLong(0);

    /* renamed from: th  reason: collision with root package name */
    public static volatile Thread f1643th;

    /* renamed from: yj  reason: collision with root package name */
    public static Runnable f1644yj = new C0087qw();
    public OkHttpClient qw;

    /* renamed from: fe.fe.ddd.switch.uk.qw$ad */
    public class ad extends ResponseBody {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1645ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f1646th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ byte[] f1647uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f1648yj;

        public ad(qw qwVar, String str, boolean z, long j, byte[] bArr) {
            this.f1645ad = str;
            this.f1646th = z;
            this.f1648yj = j;
            this.f1647uk = bArr;
        }

        public long contentLength() {
            if (this.f1646th) {
                return -1;
            }
            return this.f1648yj;
        }

        public MediaType contentType() {
            String str = this.f1645ad;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return new Buffer().write(this.f1647uk);
        }
    }

    /* renamed from: fe.fe.ddd.switch.uk.qw$fe */
    public static class fe extends WeakReference<de> {

        /* renamed from: ad  reason: collision with root package name */
        public final HttpURLConnection f1653ad;

        /* renamed from: de  reason: collision with root package name */
        public volatile boolean f1654de;
        public final long qw;

        public fe(long j, HttpURLConnection httpURLConnection, de deVar, ReferenceQueue<de> referenceQueue) {
            super(deVar, referenceQueue);
            this.qw = j;
            this.f1653ad = httpURLConnection;
        }

        public void de() {
            this.f1654de = true;
        }

        public boolean fe() {
            return this.f1654de;
        }
    }

    /* renamed from: fe.fe.ddd.switch.uk.qw$qw  reason: collision with other inner class name */
    public class C0087qw implements Runnable {
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:13:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                java.lang.ref.ReferenceQueue r0 = fe.fe.ddd.p001switch.uk.qw.f1640de     // Catch:{ InterruptedException -> 0x0041 }
                java.lang.ref.Reference r0 = r0.remove()     // Catch:{ InterruptedException -> 0x0041 }
                fe.fe.ddd.switch.uk.qw$fe r0 = (fe.fe.ddd.p001switch.uk.qw.fe) r0     // Catch:{ InterruptedException -> 0x0041 }
                if (r0 == 0) goto L_0x0045
                java.util.concurrent.ConcurrentHashMap r1 = fe.fe.ddd.p001switch.uk.qw.f1641fe     // Catch:{ InterruptedException -> 0x0041 }
                long r2 = r0.qw     // Catch:{ InterruptedException -> 0x0041 }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ InterruptedException -> 0x0041 }
                java.lang.Object r1 = r1.remove(r2)     // Catch:{ InterruptedException -> 0x0041 }
                if (r1 == 0) goto L_0x0000
                boolean r1 = r0.fe()     // Catch:{ InterruptedException -> 0x0041 }
                if (r1 != 0) goto L_0x0000
                java.net.HttpURLConnection r1 = r0.f1653ad     // Catch:{ Exception -> 0x0000 }
                if (r1 == 0) goto L_0x0000
                java.net.HttpURLConnection r1 = r0.f1653ad     // Catch:{ Exception -> 0x0000 }
                r1.disconnect()     // Catch:{ Exception -> 0x0000 }
                com.baidu.searchbox.http.cronet.ICronet r1 = fe.fe.ddd.p001switch.yj.qw.qw()     // Catch:{ Exception -> 0x0000 }
                java.net.HttpURLConnection r0 = r0.f1653ad     // Catch:{ Exception -> 0x0000 }
                java.net.URL r0 = r0.getURL()     // Catch:{ Exception -> 0x0000 }
                r1.de(r0)     // Catch:{ Exception -> 0x0000 }
                goto L_0x0000
            L_0x0041:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0045:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.p001switch.uk.qw.C0087qw.run():void");
        }
    }

    public final String fe(String str, List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str.trim());
            if (!str.trim().endsWith(i.b)) {
                sb.append("; ");
            } else {
                sb.append(" ");
            }
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Cookie cookie = list.get(i2);
            if (sb.indexOf(cookie.name() + a.h) < 0) {
                if (i2 > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.name());
                sb.append(a.h);
                sb.append(cookie.value());
            }
        }
        return sb.toString();
    }

    public final byte[] i(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return byteArray == null ? new byte[0] : byteArray;
        } finally {
            Util.closeQuietly((Closeable) inputStream);
            Util.closeQuietly((Closeable) byteArrayOutputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            com.baidu.searchbox.http.IHttpContext r0 = fe.fe.ddd.p001switch.fe.qw()
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r0 = f1643th
            if (r0 != 0) goto L_0x002a
            java.lang.Class<fe.fe.ddd.switch.uk.qw$de> r0 = fe.fe.ddd.p001switch.uk.qw.de.class
            monitor-enter(r0)
            java.lang.Thread r1 = f1643th     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0025
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x0027 }
            java.lang.Runnable r2 = f1644yj     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = "request_leak_monitor"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
            f1643th = r1     // Catch:{ all -> 0x0027 }
            java.lang.Thread r1 = f1643th     // Catch:{ all -> 0x0027 }
            r1.start()     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            goto L_0x002a
        L_0x0027:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r14
        L_0x002a:
            okhttp3.Request r0 = r14.request()
            com.baidu.searchbox.http.cronet.ICronet r1 = fe.fe.ddd.p001switch.yj.qw.qw()
            if (r1 == 0) goto L_0x0342
            boolean r2 = r1.qw()
            if (r2 != 0) goto L_0x003c
            goto L_0x0342
        L_0x003c:
            okhttp3.Call r2 = r14.call()
            okhttp3.Request r2 = r2.request()
            java.lang.Object r2 = r2.tag()
            boolean r2 = r2 instanceof fe.fe.ddd.p001switch.p002if.fe
            r3 = 0
            if (r2 == 0) goto L_0x0065
            okhttp3.Call r2 = r14.call()
            okhttp3.Request r2 = r2.request()
            java.lang.Object r2 = r2.tag()
            fe.fe.ddd.switch.if.fe r2 = (fe.fe.ddd.p001switch.p002if.fe) r2
            fe.fe.ddd.switch.when.qw r2 = r2.m80if()
            if (r2 == 0) goto L_0x0066
            r4 = 3
            r2.s = r4
            goto L_0x0066
        L_0x0065:
            r2 = r3
        L_0x0066:
            okhttp3.HttpUrl r4 = r0.url()
            java.net.URL r4 = r4.url()
            java.net.HttpURLConnection r1 = r1.ad(r4)
            okhttp3.Call r4 = r14.call()
            boolean r4 = r4.isCanceled()
            if (r4 == 0) goto L_0x0084
            r1.disconnect()
            okhttp3.Response r14 = r14.proceed(r0)
            return r14
        L_0x0084:
            if (r1 == 0) goto L_0x008f
            okhttp3.OkHttpClient r4 = r13.qw
            boolean r4 = r4.followRedirects()
            r1.setInstanceFollowRedirects(r4)
        L_0x008f:
            okhttp3.OkHttpClient r4 = r13.qw
            boolean r4 = r4.followSslRedirects()
            r5 = 0
            if (r4 == 0) goto L_0x00d0
            java.lang.reflect.Method r4 = f1639ad
            if (r4 != 0) goto L_0x00c1
            java.lang.Class r4 = r1.getClass()     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            java.lang.String r6 = "enableRedirectForDifferentProtocols"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r7)     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            f1639ad = r4     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            if (r4 == 0) goto L_0x00d0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            r4.invoke(r1, r6)     // Catch:{ InvocationTargetException -> 0x00bc, NoSuchMethodException -> 0x00b7, IllegalAccessException -> 0x00b2 }
            goto L_0x00d0
        L_0x00b2:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00d0
        L_0x00b7:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00d0
        L_0x00bc:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00d0
        L_0x00c1:
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x00cc, InvocationTargetException -> 0x00c7 }
            r4.invoke(r1, r6)     // Catch:{ IllegalAccessException -> 0x00cc, InvocationTargetException -> 0x00c7 }
            goto L_0x00d0
        L_0x00c7:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00d0
        L_0x00cc:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00d0:
            okhttp3.OkHttpClient r4 = r13.qw
            int r4 = r4.connectTimeoutMillis()
            if (r4 <= 0) goto L_0x00e1
            okhttp3.OkHttpClient r4 = r13.qw
            int r4 = r4.connectTimeoutMillis()
            r1.setConnectTimeout(r4)
        L_0x00e1:
            okhttp3.OkHttpClient r4 = r13.qw
            int r4 = r4.readTimeoutMillis()
            if (r4 <= 0) goto L_0x00f2
            okhttp3.OkHttpClient r4 = r13.qw
            int r4 = r4.readTimeoutMillis()
            r1.setReadTimeout(r4)
        L_0x00f2:
            okhttp3.Headers r4 = r0.headers()
            java.util.Set r6 = r4.names()
            java.util.Iterator r6 = r6.iterator()
        L_0x00fe:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x011f
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "Cookie"
            boolean r8 = r7.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0117
            java.lang.String r3 = r4.get(r7)
            goto L_0x00fe
        L_0x0117:
            java.lang.String r8 = r4.get(r7)
            r1.addRequestProperty(r7, r8)
            goto L_0x00fe
        L_0x011f:
            okhttp3.OkHttpClient r4 = r13.qw
            okhttp3.CookieJar r4 = r4.cookieJar()
            if (r4 == 0) goto L_0x013b
            okhttp3.HttpUrl r6 = r0.url()
            java.util.List r6 = r4.loadForRequest(r6)
            if (r6 == 0) goto L_0x013b
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x013b
            java.lang.String r3 = r13.fe(r3, r6)
        L_0x013b:
            if (r3 == 0) goto L_0x0142
            java.lang.String r6 = "Cookie"
            r1.addRequestProperty(r6, r3)
        L_0x0142:
            java.lang.String r3 = "Lib-Http-Req"
            java.lang.String r6 = "1"
            r1.addRequestProperty(r3, r6)
            java.lang.String r3 = r0.method()
            r1.setRequestMethod(r3)
            okhttp3.RequestBody r3 = r0.body()     // Catch:{ IOException -> 0x0329 }
            if (r3 == 0) goto L_0x018e
            okhttp3.RequestBody r3 = r0.body()     // Catch:{ IOException -> 0x0329 }
            okhttp3.MediaType r3 = r3.contentType()     // Catch:{ IOException -> 0x0329 }
            if (r3 == 0) goto L_0x0171
            java.lang.String r3 = "Content-Type"
            okhttp3.RequestBody r6 = r0.body()     // Catch:{ IOException -> 0x0329 }
            okhttp3.MediaType r6 = r6.contentType()     // Catch:{ IOException -> 0x0329 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0329 }
            r1.setRequestProperty(r3, r6)     // Catch:{ IOException -> 0x0329 }
        L_0x0171:
            r3 = 1
            r1.setDoOutput(r3)     // Catch:{ IOException -> 0x0329 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ IOException -> 0x0329 }
            okio.Sink r6 = okio.Okio.sink((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x0329 }
            okio.BufferedSink r6 = okio.Okio.buffer((okio.Sink) r6)     // Catch:{ IOException -> 0x0329 }
            okhttp3.RequestBody r7 = r0.body()     // Catch:{ IOException -> 0x0329 }
            r7.writeTo(r6)     // Catch:{ IOException -> 0x0329 }
            r6.flush()     // Catch:{ IOException -> 0x0329 }
            r3.close()     // Catch:{ IOException -> 0x0329 }
        L_0x018e:
            int r3 = r1.getResponseCode()     // Catch:{ IOException -> 0x0329 }
            okhttp3.Call r6 = r14.call()
            boolean r6 = r6.isCanceled()
            if (r6 == 0) goto L_0x01a4
            r1.disconnect()
            okhttp3.Response r14 = r14.proceed(r0)
            return r14
        L_0x01a4:
            r0.headers()
            java.util.Map r14 = r1.getHeaderFields()
            java.lang.String r6 = "protocol"
            java.lang.Object r14 = r14.get(r6)
            java.util.List r14 = (java.util.List) r14
            java.lang.String r6 = ""
            if (r14 == 0) goto L_0x01be
            java.lang.Object r14 = r14.get(r5)
            r6 = r14
            java.lang.String r6 = (java.lang.String) r6
        L_0x01be:
            okhttp3.Protocol r14 = okhttp3.Protocol.get(r6)     // Catch:{ IOException -> 0x01c3 }
            goto L_0x01d5
        L_0x01c3:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r5 = "Unexpected protocol: "
            r14.append(r5)
            r14.append(r6)
            r14.toString()
            okhttp3.Protocol r14 = okhttp3.Protocol.HTTP_1_1
        L_0x01d5:
            okhttp3.Response$Builder r5 = new okhttp3.Response$Builder
            r5.<init>()
            okhttp3.Response$Builder r6 = r5.request(r0)
            okhttp3.Response$Builder r6 = r6.protocol(r14)
            okhttp3.Response$Builder r6 = r6.code(r3)
            java.lang.String r7 = r1.getResponseMessage()
            r6.message(r7)
            java.util.Map r6 = r1.getHeaderFields()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
            okhttp3.Headers$Builder r7 = new okhttp3.Headers$Builder
            r7.<init>()
        L_0x01fe:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0263
            java.lang.Object r8 = r6.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getValue()
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0214:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01fe
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r8.getKey()
            if (r11 == 0) goto L_0x0214
            java.lang.Object r11 = r8.getKey()
            java.lang.String r11 = (java.lang.String) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0214
            java.lang.Object r11 = r8.getValue()
            if (r11 == 0) goto L_0x0214
            java.lang.Object r11 = r8.getKey()     // Catch:{ IllegalArgumentException -> 0x024b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IllegalArgumentException -> 0x024b }
            r5.addHeader(r11, r10)     // Catch:{ IllegalArgumentException -> 0x024b }
            java.lang.Object r11 = r8.getKey()     // Catch:{ IllegalArgumentException -> 0x024b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IllegalArgumentException -> 0x024b }
            r7.add((java.lang.String) r11, (java.lang.String) r10)     // Catch:{ IllegalArgumentException -> 0x024b }
            goto L_0x0214
        L_0x024b:
            if (r2 == 0) goto L_0x0214
            org.json.JSONObject r11 = r2.R
            if (r11 != 0) goto L_0x0257
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
        L_0x0257:
            java.lang.Object r12 = r8.getKey()     // Catch:{ JSONException -> 0x0261 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x0261 }
            r11.put(r12, r10)     // Catch:{ JSONException -> 0x0261 }
            goto L_0x0214
        L_0x0261:
            goto L_0x0214
        L_0x0263:
            okhttp3.Headers r6 = r7.build()
            okhttp3.CookieJar r7 = okhttp3.CookieJar.NO_COOKIES
            if (r4 == r7) goto L_0x0280
            okhttp3.HttpUrl r7 = r0.url()
            java.util.List r7 = okhttp3.Cookie.parseAll(r7, r6)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x0280
            okhttp3.HttpUrl r8 = r0.url()
            r4.saveFromResponse(r8, r7)
        L_0x0280:
            java.lang.String r4 = r1.getResponseMessage()
            if (r4 == 0) goto L_0x0287
            goto L_0x0289
        L_0x0287:
            java.lang.String r4 = ""
        L_0x0289:
            okhttp3.Response$Builder r4 = r5.message(r4)
            okhttp3.Response r4 = r4.build()
            okhttp3.ResponseBody r1 = r13.yj(r4, r6, r1)
            okhttp3.Response$Builder r1 = r5.body(r1)
            okhttp3.Response r1 = r1.build()
            if (r2 == 0) goto L_0x0328
            okhttp3.RequestBody r4 = r0.body()
            if (r4 != 0) goto L_0x02a8
            r7 = 0
            goto L_0x02b0
        L_0x02a8:
            okhttp3.RequestBody r0 = r0.body()
            long r7 = r0.contentLength()
        L_0x02b0:
            r2.d = r7
            r2.mmm = r3
            java.lang.String r14 = r14.toString()
            r2.tt = r14
            java.lang.String r14 = "X-Bfe-Svbbrers"
            java.lang.String r14 = r6.get(r14)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x02c9
            r2.e = r14
            goto L_0x02cf
        L_0x02c9:
            java.lang.String r14 = fe.fe.ddd.p001switch.qw.rg()
            r2.e = r14
        L_0x02cf:
            r13.uk(r6, r2)
            long r7 = java.lang.System.currentTimeMillis()
            r2.f1664yj = r7
            okhttp3.ResponseBody r14 = r1.body()
            long r9 = r14.contentLength()
            r2.c = r9
            okhttp3.ResponseBody r14 = r1.body()
            okhttp3.MediaType r14 = r14.contentType()
            if (r14 == 0) goto L_0x02f2
            java.lang.String r14 = r14.toString()
            r2.n = r14
        L_0x02f2:
            okhttp3.Response$Builder r14 = r5.headers(r6)
            r14.receivedResponseAtMillis(r7)
            boolean r14 = r1.isRedirect()
            if (r14 == 0) goto L_0x030d
            java.lang.String r14 = "Location"
            java.lang.String r14 = r1.header(r14)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x030d
            r2.eee = r14
        L_0x030d:
            r14 = 400(0x190, float:5.6E-43)
            if (r3 < r14) goto L_0x0316
            java.lang.String r14 = r13.rg(r1)
            goto L_0x0318
        L_0x0316:
            java.lang.String r14 = ""
        L_0x0318:
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x0320
            r2.b = r14
        L_0x0320:
            java.lang.String r14 = "bd-frame-bind4gstatus"
            java.lang.String r14 = r1.header(r14)
            r2.V = r14
        L_0x0328:
            return r1
        L_0x0329:
            r14 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Write data or build connection caught exception: "
            r0.append(r2)
            java.lang.String r2 = r14.toString()
            r0.append(r2)
            r0.toString()
            r1.disconnect()
            throw r14
        L_0x0342:
            okhttp3.Response r14 = r14.proceed(r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.p001switch.uk.qw.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public void o(OkHttpClient okHttpClient) {
        this.qw = okHttpClient;
    }

    public final long pf(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String rg(Response response) {
        Headers headers = response.headers();
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(headers.name(i2));
            sb.append(":");
            sb.append(headers.value(i2));
            sb.append(i.b);
        }
        return sb.toString();
    }

    public final ResponseBody th(String str, long j, HttpURLConnection httpURLConnection) throws IOException {
        MediaType mediaType = null;
        if (j > 16384) {
            httpURLConnection.disconnect();
            if (str != null) {
                mediaType = MediaType.parse(str);
            }
            return ResponseBody.create(mediaType, new byte[0]);
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            httpURLConnection.disconnect();
            if (str != null) {
                mediaType = MediaType.parse(str);
            }
            return ResponseBody.create(mediaType, new byte[0]);
        }
        if (str != null) {
            mediaType = MediaType.parse(str);
        }
        return ResponseBody.create(mediaType, i(errorStream));
    }

    public final void uk(Headers headers, fe.fe.ddd.p001switch.when.qw qwVar) {
        try {
            String str = headers.get("dns_start");
            String str2 = headers.get("dns_end");
            String str3 = headers.get("connect_start");
            String str4 = headers.get("ssl_start");
            String str5 = headers.get("ssl_end");
            String str6 = headers.get("connect_end");
            String str7 = headers.get("send_start");
            String str8 = headers.get("send_end");
            String str9 = headers.get("receive_headers_start");
            String str10 = headers.get("receive_headers_end");
            if (!TextUtils.isEmpty(str)) {
                qwVar.ppp = Long.parseLong(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                qwVar.ggg = Long.parseLong(str2);
            }
            if (qwVar.ppp > 0 && qwVar.ggg > 0) {
                qwVar.vvv = qwVar.ppp - qwVar.ggg;
            }
            if (!TextUtils.isEmpty(str3)) {
                qwVar.f1655ad = Long.parseLong(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                qwVar.f1657fe = Long.parseLong(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                qwVar.f1661rg = Long.parseLong(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                qwVar.f1662th = Long.parseLong(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                qwVar.f1660pf = Long.parseLong(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                qwVar.f38if = Long.parseLong(str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                qwVar.f39switch = Long.parseLong(str9);
            }
            if (!TextUtils.isEmpty(str10)) {
                qwVar.when = Long.parseLong(str10);
            }
            qwVar.g = TextUtils.equals(headers.get("socket-reused"), "1");
        } catch (Exception unused) {
        }
    }

    public ResponseBody yj(Response response, Headers headers, HttpURLConnection httpURLConnection) throws IOException {
        String str = headers.get(e.f);
        long pf2 = pf(headers.get("content-length"));
        boolean z = !TextUtils.isEmpty(headers.get("Origin-Content-Encoding"));
        if (response.code() >= 300) {
            return th(str, pf2, httpURLConnection);
        }
        MediaType mediaType = null;
        if (!HttpHeaders.hasBody(response)) {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                inputStream.read();
            }
            if (str != null) {
                mediaType = MediaType.parse(str);
            }
            return ResponseBody.create(mediaType, new byte[0]);
        }
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            if (str != null) {
                mediaType = MediaType.parse(str);
            }
            return ResponseBody.create(mediaType, new byte[0]);
        } else if (pf2 < 0 || pf2 > 8192) {
            BufferedSource buffer = Okio.buffer(Okio.source((InputStream) new de(inputStream2, httpURLConnection)));
            if (z) {
                pf2 = -1;
            }
            return new RealResponseBody(str, pf2, buffer);
        } else {
            return new ad(this, str, z, pf2, i(inputStream2));
        }
    }

    /* renamed from: fe.fe.ddd.switch.uk.qw$de */
    public static class de extends FilterInputStream {

        /* renamed from: ad  reason: collision with root package name */
        public volatile HttpURLConnection f1649ad;

        /* renamed from: th  reason: collision with root package name */
        public volatile boolean f1650th = false;

        /* renamed from: uk  reason: collision with root package name */
        public fe f1651uk;

        /* renamed from: yj  reason: collision with root package name */
        public long f1652yj;

        public de(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream);
            this.f1649ad = httpURLConnection;
            if (fe.fe.ddd.p001switch.fe.qw().o() && this.f1649ad != null) {
                this.f1652yj = qw.f1642rg.incrementAndGet();
                this.f1651uk = new fe(this.f1652yj, this.f1649ad, this, qw.f1640de);
                qw.f1641fe.put(Long.valueOf(this.f1652yj), this.f1651uk);
            }
        }

        public void close() throws IOException {
            fe feVar;
            this.in.close();
            if (!this.f1650th && this.f1649ad != null) {
                this.f1649ad.disconnect();
            }
            if (fe.fe.ddd.p001switch.fe.qw().o() && (feVar = this.f1651uk) != null) {
                feVar.de();
            }
        }

        public int read() throws IOException {
            int read = this.in.read();
            if (read < 0) {
                this.f1650th = true;
            }
            return read;
        }

        public int read(byte[] bArr) throws IOException {
            int read = read(bArr, 0, bArr.length);
            if (read < 0) {
                this.f1650th = true;
            }
            return read;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.in.read(bArr, i2, i3);
            if (read < 0) {
                this.f1650th = true;
            }
            return read;
        }
    }
}
