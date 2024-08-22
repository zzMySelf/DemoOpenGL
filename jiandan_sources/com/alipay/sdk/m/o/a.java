package com.alipay.sdk.m.o;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

public final class a {
    public static final String a = "msp";
    public static final String b = "application/octet-stream;binary/octet-stream";
    public static final CookieManager c = new CookieManager();

    /* renamed from: com.alipay.sdk.m.o.a$a  reason: collision with other inner class name */
    public static final class C0012a {
        public final String a;
        public final byte[] b;
        public final Map<String, String> c;

        public C0012a(String str, Map<String, String> map, byte[] bArr) {
            this.a = str;
            this.b = bArr;
            this.c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", new Object[]{this.a, this.c});
        }
    }

    public static final class b {
        public final Map<String, List<String>> a;
        public final String b;
        public final byte[] c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.a = map;
            this.b = str;
            this.c = bArr;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0189 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ca A[SYNTHETIC, Splitter:B:109:0x01ca] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2 A[Catch:{ all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fc A[Catch:{ all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0109 A[Catch:{ all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011b A[Catch:{ all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0142 A[Catch:{ all -> 0x0194 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014d A[Catch:{ all -> 0x0194 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0186 A[SYNTHETIC, Splitter:B:67:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0190 A[SYNTHETIC, Splitter:B:73:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a7 A[SYNTHETIC, Splitter:B:87:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ae A[SYNTHETIC, Splitter:B:91:0x01ae] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b5 A[SYNTHETIC, Splitter:B:95:0x01b5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.sdk.m.o.a.b a(android.content.Context r11, com.alipay.sdk.m.o.a.C0012a r12) {
        /*
            java.lang.String r0 = "Keep-Alive"
            java.lang.String r1 = "mspl"
            r2 = 0
            if (r11 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r3.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r4 = "conn config: "
            r3.append(r4)     // Catch:{ all -> 0x019c }
            r3.append(r12)     // Catch:{ all -> 0x019c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019c }
            com.alipay.sdk.m.u.e.d(r1, r3)     // Catch:{ all -> 0x019c }
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r12.a     // Catch:{ all -> 0x019c }
            r3.<init>(r4)     // Catch:{ all -> 0x019c }
            java.net.Proxy r11 = b(r11)     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r4.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r5 = "conn proxy: "
            r4.append(r5)     // Catch:{ all -> 0x019c }
            r4.append(r11)     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x019c }
            com.alipay.sdk.m.u.e.d(r1, r4)     // Catch:{ all -> 0x019c }
            if (r11 == 0) goto L_0x0044
            java.net.URLConnection r11 = r3.openConnection(r11)     // Catch:{ all -> 0x019c }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x019c }
            goto L_0x004a
        L_0x0044:
            java.net.URLConnection r11 = r3.openConnection()     // Catch:{ all -> 0x019c }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x019c }
        L_0x004a:
            java.lang.String r1 = "http.keepAlive"
            java.lang.String r4 = "false"
            java.lang.System.setProperty(r1, r4)     // Catch:{ all -> 0x019a }
            boolean r1 = r11 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x0058
            r1 = r11
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x019a }
        L_0x0058:
            java.net.CookieManager r1 = c     // Catch:{ all -> 0x019a }
            java.net.CookieStore r1 = r1.getCookieStore()     // Catch:{ all -> 0x019a }
            java.util.List r1 = r1.getCookies()     // Catch:{ all -> 0x019a }
            int r1 = r1.size()     // Catch:{ all -> 0x019a }
            if (r1 <= 0) goto L_0x007d
            java.lang.String r1 = "Cookie"
            java.lang.String r4 = ";"
            java.net.CookieManager r5 = c     // Catch:{ all -> 0x019a }
            java.net.CookieStore r5 = r5.getCookieStore()     // Catch:{ all -> 0x019a }
            java.util.List r5 = r5.getCookies()     // Catch:{ all -> 0x019a }
            java.lang.String r4 = android.text.TextUtils.join(r4, r5)     // Catch:{ all -> 0x019a }
            r11.setRequestProperty(r1, r4)     // Catch:{ all -> 0x019a }
        L_0x007d:
            r1 = 20000(0x4e20, float:2.8026E-41)
            r11.setConnectTimeout(r1)     // Catch:{ all -> 0x019a }
            r1 = 30000(0x7530, float:4.2039E-41)
            r11.setReadTimeout(r1)     // Catch:{ all -> 0x019a }
            r1 = 1
            r11.setInstanceFollowRedirects(r1)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "msp"
            r11.setRequestProperty(r4, r5)     // Catch:{ all -> 0x019a }
            byte[] r4 = r12.b     // Catch:{ all -> 0x019a }
            java.lang.String r5 = "POST"
            if (r4 == 0) goto L_0x00b9
            byte[] r4 = r12.b     // Catch:{ all -> 0x019a }
            int r4 = r4.length     // Catch:{ all -> 0x019a }
            if (r4 <= 0) goto L_0x00b9
            r11.setRequestMethod(r5)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "Content-Type"
            java.lang.String r6 = "application/octet-stream;binary/octet-stream"
            r11.setRequestProperty(r4, r6)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "Accept-Charset"
            java.lang.String r6 = "UTF-8"
            r11.setRequestProperty(r4, r6)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "Connection"
            r11.setRequestProperty(r4, r0)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "timeout=180, max=100"
            r11.setRequestProperty(r0, r4)     // Catch:{ all -> 0x019a }
            goto L_0x00be
        L_0x00b9:
            java.lang.String r0 = "GET"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x019a }
        L_0x00be:
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.c     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x00ef
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.c     // Catch:{ all -> 0x019a }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x019a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x019a }
        L_0x00cc:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x00ef
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x019a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x019a }
            java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x019a }
            if (r6 != 0) goto L_0x00df
            goto L_0x00cc
        L_0x00df:
            java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x019a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x019a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x019a }
            r11.setRequestProperty(r6, r4)     // Catch:{ all -> 0x019a }
            goto L_0x00cc
        L_0x00ef:
            r11.setDoInput(r1)     // Catch:{ all -> 0x019a }
            java.lang.String r0 = r11.getRequestMethod()     // Catch:{ all -> 0x019a }
            boolean r0 = r5.equals(r0)     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x00ff
            r11.setDoOutput(r1)     // Catch:{ all -> 0x019a }
        L_0x00ff:
            java.lang.String r0 = r11.getRequestMethod()     // Catch:{ all -> 0x019a }
            boolean r0 = r5.equals(r0)     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x011b
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x019a }
            java.io.OutputStream r1 = r11.getOutputStream()     // Catch:{ all -> 0x019a }
            r0.<init>(r1)     // Catch:{ all -> 0x019a }
            byte[] r12 = r12.b     // Catch:{ all -> 0x0196 }
            r0.write(r12)     // Catch:{ all -> 0x0196 }
            r0.flush()     // Catch:{ all -> 0x0196 }
            goto L_0x011c
        L_0x011b:
            r0 = r2
        L_0x011c:
            java.io.BufferedInputStream r12 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0196 }
            java.io.InputStream r1 = r11.getInputStream()     // Catch:{ all -> 0x0196 }
            r12.<init>(r1)     // Catch:{ all -> 0x0196 }
            byte[] r1 = a((java.io.InputStream) r12)     // Catch:{ all -> 0x0194 }
            java.util.Map r4 = r11.getHeaderFields()     // Catch:{ all -> 0x0194 }
            if (r4 == 0) goto L_0x0142
            java.lang.Object r5 = r4.get(r2)     // Catch:{ all -> 0x0194 }
            if (r5 == 0) goto L_0x0142
            java.lang.String r5 = ","
            java.lang.Object r6 = r4.get(r2)     // Catch:{ all -> 0x0194 }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x0194 }
            java.lang.String r5 = android.text.TextUtils.join(r5, r6)     // Catch:{ all -> 0x0194 }
            goto L_0x0143
        L_0x0142:
            r5 = r2
        L_0x0143:
            java.lang.String r6 = "Set-Cookie"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x0194 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0194 }
            if (r6 == 0) goto L_0x017f
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0194 }
        L_0x0151:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0194 }
            if (r7 == 0) goto L_0x017f
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0194 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0194 }
            java.util.List r7 = java.net.HttpCookie.parse(r7)     // Catch:{ all -> 0x0194 }
            if (r7 == 0) goto L_0x0151
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0194 }
            if (r8 == 0) goto L_0x016a
            goto L_0x0151
        L_0x016a:
            java.net.CookieManager r8 = c     // Catch:{ all -> 0x0194 }
            java.net.CookieStore r8 = r8.getCookieStore()     // Catch:{ all -> 0x0194 }
            java.net.URI r9 = r3.toURI()     // Catch:{ all -> 0x0194 }
            r10 = 0
            java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x0194 }
            java.net.HttpCookie r7 = (java.net.HttpCookie) r7     // Catch:{ all -> 0x0194 }
            r8.add(r9, r7)     // Catch:{ all -> 0x0194 }
            goto L_0x0151
        L_0x017f:
            com.alipay.sdk.m.o.a$b r3 = new com.alipay.sdk.m.o.a$b     // Catch:{ all -> 0x0194 }
            r3.<init>(r4, r5, r1)     // Catch:{ all -> 0x0194 }
            if (r11 == 0) goto L_0x0189
            r11.disconnect()     // Catch:{ all -> 0x0189 }
        L_0x0189:
            r12.close()     // Catch:{ all -> 0x018d }
            goto L_0x018e
        L_0x018d:
        L_0x018e:
            if (r0 == 0) goto L_0x0193
            r0.close()     // Catch:{ all -> 0x0193 }
        L_0x0193:
            return r3
        L_0x0194:
            r1 = move-exception
            goto L_0x01a2
        L_0x0196:
            r12 = move-exception
            r1 = r12
            r12 = r2
            goto L_0x01a2
        L_0x019a:
            r12 = move-exception
            goto L_0x019f
        L_0x019c:
            r11 = move-exception
            r12 = r11
            r11 = r2
        L_0x019f:
            r1 = r12
            r12 = r2
            r0 = r12
        L_0x01a2:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x01b9 }
            if (r11 == 0) goto L_0x01ac
            r11.disconnect()     // Catch:{ all -> 0x01ab }
            goto L_0x01ac
        L_0x01ab:
        L_0x01ac:
            if (r12 == 0) goto L_0x01b3
            r12.close()     // Catch:{ all -> 0x01b2 }
            goto L_0x01b3
        L_0x01b2:
        L_0x01b3:
            if (r0 == 0) goto L_0x01b8
            r0.close()     // Catch:{ all -> 0x01b8 }
        L_0x01b8:
            return r2
        L_0x01b9:
            r1 = move-exception
            if (r11 == 0) goto L_0x01c1
            r11.disconnect()     // Catch:{ all -> 0x01c0 }
            goto L_0x01c1
        L_0x01c0:
        L_0x01c1:
            if (r12 == 0) goto L_0x01c8
            r12.close()     // Catch:{ all -> 0x01c7 }
            goto L_0x01c8
        L_0x01c7:
        L_0x01c8:
            if (r0 == 0) goto L_0x01cd
            r0.close()     // Catch:{ all -> 0x01cd }
        L_0x01cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.o.a.a(android.content.Context, com.alipay.sdk.m.o.a$a):com.alipay.sdk.m.o.a$b");
    }

    public static Proxy b(Context context) {
        String a2 = a(context);
        if (a2 != null && !a2.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            NetworkInfo a2 = com.alipay.sdk.m.w.b.a((com.alipay.sdk.m.s.a) null, context);
            if (a2 != null && a2.isAvailable()) {
                if (a2.getType() == 1) {
                    return "wifi";
                }
                return a2.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
