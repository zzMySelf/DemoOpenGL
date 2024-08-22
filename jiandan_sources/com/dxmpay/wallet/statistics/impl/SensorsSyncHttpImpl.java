package com.dxmpay.wallet.statistics.impl;

import com.alipay.sdk.m.s.a;
import com.duxiaoman.dxmpay.statistics.internal.ISyncHttpImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;

public class SensorsSyncHttpImpl implements ISyncHttpImpl {
    public static String ad(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static InputStream qw(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public final String de(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                String encode = URLEncoder.encode((String) next.getKey());
                String encode2 = URLEncoder.encode((String) next.getValue());
                sb.append(encode);
                sb.append("=");
                sb.append(encode2);
                sb.append(a.n);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb A[SYNTHETIC, Splitter:B:56:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0112 A[SYNTHETIC, Splitter:B:72:0x0112] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean send(android.content.Context r6, int r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            r5 = this;
            java.lang.String r6 = "ret"
            java.lang.String r0 = "SensorsSyncHttpImpl"
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00f8, all -> 0x00d0 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00d0 }
            java.net.URLConnection r8 = r3.openConnection()     // Catch:{ Exception -> 0x00f8, all -> 0x00d0 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x00f8, all -> 0x00d0 }
            r8.setUseCaches(r2)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r3 = 1
            if (r3 != r7) goto L_0x0019
            r4 = 1
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            r8.setDoOutput(r4)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            if (r3 != r7) goto L_0x0025
            java.lang.String r7 = "POST"
            r8.setRequestMethod(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            goto L_0x002c
        L_0x0025:
            if (r7 != 0) goto L_0x00b2
            java.lang.String r7 = "GET"
            r8.setRequestMethod(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
        L_0x002c:
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r8.setRequestProperty(r7, r4)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.String r7 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r8.setRequestProperty(r7, r4)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.String r7 = r5.de(r9)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            int r9 = r7.length()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r8.setFixedLengthStreamingMode(r9)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r9 = 30000(0x7530, float:4.2039E-41)
            r8.setConnectTimeout(r9)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r8.setReadTimeout(r9)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r8.connect()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            int r9 = r7.length()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            if (r9 <= 0) goto L_0x0064
            java.io.OutputStream r1 = r8.getOutputStream()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r1.write(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r1.flush()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
        L_0x0064:
            int r7 = r8.getResponseCode()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r9 > r7) goto L_0x008a
            r9 = 300(0x12c, float:4.2E-43)
            if (r9 <= r7) goto L_0x008a
            java.io.InputStream r7 = r8.getInputStream()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.String r7 = ad(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            boolean r7 = r9.has(r6)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            if (r7 == 0) goto L_0x008a
            int r6 = r9.optInt(r6)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            if (r6 != r3) goto L_0x008a
            r2 = 1
        L_0x008a:
            if (r8 == 0) goto L_0x00a1
            java.io.InputStream r6 = qw(r8)
            if (r6 == 0) goto L_0x009e
            r6.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r7, r6)
        L_0x009e:
            r8.disconnect()
        L_0x00a1:
            if (r1 == 0) goto L_0x0115
            r1.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x0115
        L_0x00a8:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r7, r6)
            goto L_0x0115
        L_0x00b2:
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r9.<init>()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.String r3 = "not support http method:"
            r9.append(r3)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r9.append(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            throw r6     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
        L_0x00c9:
            r6 = move-exception
            r7 = r1
            r1 = r8
            goto L_0x00d2
        L_0x00cd:
            r6 = r1
            r1 = r8
            goto L_0x00f9
        L_0x00d0:
            r6 = move-exception
            r7 = r1
        L_0x00d2:
            if (r1 == 0) goto L_0x00e9
            java.io.InputStream r8 = qw(r1)
            if (r8 == 0) goto L_0x00e6
            r8.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e6
        L_0x00de:
            r8 = move-exception
            java.lang.String r9 = r8.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r9, r8)
        L_0x00e6:
            r1.disconnect()
        L_0x00e9:
            if (r7 == 0) goto L_0x00f7
            r7.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x00f7
        L_0x00ef:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r8, r7)
        L_0x00f7:
            throw r6
        L_0x00f8:
            r6 = r1
        L_0x00f9:
            if (r1 == 0) goto L_0x0110
            java.io.InputStream r7 = qw(r1)
            if (r7 == 0) goto L_0x010d
            r7.close()     // Catch:{ IOException -> 0x0105 }
            goto L_0x010d
        L_0x0105:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r8, r7)
        L_0x010d:
            r1.disconnect()
        L_0x0110:
            if (r6 == 0) goto L_0x0115
            r6.close()     // Catch:{ IOException -> 0x00a8 }
        L_0x0115:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl.send(android.content.Context, int, java.lang.String, java.util.Map):boolean");
    }
}
