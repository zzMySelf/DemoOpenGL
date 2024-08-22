package com.meizu.c;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4822a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4823b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static b f4824c;

    private b(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a.a(context);
    }

    public static b a(Context context) {
        if (f4824c == null) {
            synchronized (f4823b) {
                if (f4824c == null) {
                    f4824c = new b(context);
                }
            }
        }
        return f4824c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.meizu.c.c} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0101, code lost:
        if (r1 != null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0125, code lost:
        if (r1 != null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012b, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0134 A[SYNTHETIC, Splitter:B:51:0x0134] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.c.c a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0141
            com.meizu.c.a r1 = com.meizu.c.a.e()
            byte[] r9 = r9.getBytes()
            byte[] r9 = r1.a((byte[]) r9)
            if (r9 == 0) goto L_0x001c
            java.lang.String r1 = new java.lang.String
            r2 = 2
            byte[] r9 = android.util.Base64.encode(r9, r2)
            r1.<init>(r9)
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x013d }
            java.lang.String r2 = "https://norma-external-collect.meizu.com/push/android/external/add.do"
            r9.<init>(r2)     // Catch:{ MalformedURLException -> 0x013d }
            java.net.URLConnection r9 = r9.openConnection()
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9
            r9.setRequestMethod(r7)
            r7 = 1
            r9.setDoInput(r7)
            r9.setDoOutput(r7)
            r7 = 0
            r9.setUseCaches(r7)
            r7 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r7)
            r9.setReadTimeout(r7)
            java.lang.String r7 = "Connection"
            java.lang.String r2 = "keep-alive"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Charset"
            java.lang.String r2 = "UTF-8"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r9.setRequestProperty(r7, r2)
            if (r8 == 0) goto L_0x0089
            int r7 = r8.size()
            if (r7 <= 0) goto L_0x0089
            java.util.Set r7 = r8.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x006d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0089
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r2 = r8.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            r9.setRequestProperty(r2, r8)
            goto L_0x006d
        L_0x0089:
            if (r1 == 0) goto L_0x0092
            byte[] r7 = r1.getBytes()     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            r6.a(r9, r7)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
        L_0x0092:
            int r7 = r9.getResponseCode()     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.lang.String r8 = f4822a     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            r1.<init>()     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.lang.String r2 = "code = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            com.meizu.cloud.pushinternal.DebugLogger.d(r8, r1)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            r6.b(r9)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            r6.a((java.net.URLConnection) r9)     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            java.io.InputStream r1 = r9.getInputStream()     // Catch:{ Exception -> 0x0106, all -> 0x0104 }
            if (r1 == 0) goto L_0x00ed
            byte[] r2 = r6.a((java.io.InputStream) r1)     // Catch:{ Exception -> 0x00eb }
            if (r2 == 0) goto L_0x00ee
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00eb }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb }
            r4.<init>()     // Catch:{ Exception -> 0x00eb }
            java.lang.String r5 = "body = "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00eb }
            com.meizu.cloud.pushinternal.DebugLogger.d(r8, r4)     // Catch:{ Exception -> 0x00eb }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e6 }
            r8.<init>(r3)     // Catch:{ JSONException -> 0x00e6 }
            java.lang.String r3 = "code"
            r8.getInt(r3)     // Catch:{ JSONException -> 0x00e6 }
            goto L_0x00ee
        L_0x00e6:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ Exception -> 0x00eb }
            goto L_0x00ee
        L_0x00eb:
            r7 = move-exception
            goto L_0x0108
        L_0x00ed:
            r2 = r0
        L_0x00ee:
            if (r2 == 0) goto L_0x00fb
            com.meizu.c.c r8 = new com.meizu.c.c     // Catch:{ Exception -> 0x00eb }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00eb }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00eb }
            r8.<init>(r7, r3)     // Catch:{ Exception -> 0x00eb }
            goto L_0x0100
        L_0x00fb:
            com.meizu.c.c r8 = new com.meizu.c.c     // Catch:{ Exception -> 0x00eb }
            r8.<init>(r7, r0)     // Catch:{ Exception -> 0x00eb }
        L_0x0100:
            r0 = r8
            if (r1 == 0) goto L_0x012c
            goto L_0x0127
        L_0x0104:
            r7 = move-exception
            goto L_0x0132
        L_0x0106:
            r7 = move-exception
            r1 = r0
        L_0x0108:
            java.lang.String r8 = f4822a     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r2.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "realStringPartRequest error "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r7 = r2.append(r7)     // Catch:{ all -> 0x0130 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0130 }
            com.meizu.cloud.pushinternal.DebugLogger.e(r8, r7)     // Catch:{ all -> 0x0130 }
            if (r1 == 0) goto L_0x012c
        L_0x0127:
            r1.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x012c
        L_0x012b:
            r7 = move-exception
        L_0x012c:
            r9.disconnect()
            goto L_0x0141
        L_0x0130:
            r7 = move-exception
            r0 = r1
        L_0x0132:
            if (r0 == 0) goto L_0x0139
            r0.close()     // Catch:{ IOException -> 0x0138 }
            goto L_0x0139
        L_0x0138:
            r8 = move-exception
        L_0x0139:
            r9.disconnect()
            throw r7
        L_0x013d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0141:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.c.b.a(java.lang.String, java.util.Map, java.lang.String):com.meizu.c.c");
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>(2);
        }
        byte[] g2 = a.e().g();
        if (g2 == null || g2.length <= 0) {
            byte[] f2 = a.e().f();
            if (f2 != null && f2.length > 0) {
                String str = new String(a.e().f());
                DebugLogger.d(f4822a, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str2 = new String(g2);
            DebugLogger.d(f4822a, "attach x_s_key: " + str2);
            map.put("X-S-Key", str2);
        }
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[SYNTHETIC, Splitter:B:11:0x001b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.net.HttpURLConnection r2, byte[] r3) throws java.io.IOException {
        /*
            r1 = this;
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0017 }
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch:{ all -> 0x0017 }
            r0.<init>(r2)     // Catch:{ all -> 0x0017 }
            r0.write(r3)     // Catch:{ all -> 0x0015 }
            r0.flush()     // Catch:{ all -> 0x0015 }
            r0.close()     // Catch:{ Exception -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r2 = move-exception
        L_0x0014:
            return
        L_0x0015:
            r2 = move-exception
            goto L_0x0019
        L_0x0017:
            r2 = move-exception
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x0020
            r0.close()     // Catch:{ Exception -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r3 = move-exception
        L_0x0020:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.c.b.a(java.net.HttpURLConnection, byte[]):void");
    }

    private void a(URLConnection uRLConnection) {
        try {
            DebugLogger.d(f4822a, "get keyTimeout = " + uRLConnection.getHeaderField("Key-Timeout"));
        } catch (NullPointerException e2) {
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void b(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            DebugLogger.d(f4822a, "get x_s_key = " + headerField);
            if (!TextUtils.isEmpty(headerField)) {
                a.e().c(headerField);
            }
        } catch (NullPointerException e2) {
        }
    }

    public c b(String str, Map<String, String> map, String str2) {
        try {
            return a(str, a(map), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
