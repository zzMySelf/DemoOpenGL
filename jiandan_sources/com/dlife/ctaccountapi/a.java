package com.dlife.ctaccountapi;

public class a {
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0097, code lost:
        if (r6 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ad, code lost:
        if (r6 != null) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7 A[SYNTHETIC, Splitter:B:33:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r6 = "UTF-8"
            java.lang.String r0 = ""
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x009d }
            r2.<init>(r7)     // Catch:{ all -> 0x009d }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ all -> 0x009d }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x009d }
            java.lang.String r2 = "accept"
            java.lang.String r3 = "*/*"
            r7.setRequestProperty(r2, r3)     // Catch:{ all -> 0x009d }
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch:{ all -> 0x009d }
            r2 = 1
            r7.setDoOutput(r2)     // Catch:{ all -> 0x009d }
            r7.setDoInput(r2)     // Catch:{ all -> 0x009d }
            r2 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r2)     // Catch:{ all -> 0x009d }
            r7.setReadTimeout(r2)     // Catch:{ all -> 0x009d }
            r2 = 0
            r7.setUseCaches(r2)     // Catch:{ all -> 0x009d }
            java.lang.String r2 = "Accept-Charset"
            r7.addRequestProperty(r2, r6)     // Catch:{ all -> 0x009d }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x009d }
            if (r2 != 0) goto L_0x0056
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x009d }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x009d }
            java.io.OutputStream r4 = r7.getOutputStream()     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            r2.<init>(r3)     // Catch:{ all -> 0x009d }
            byte[] r6 = r8.getBytes(r6)     // Catch:{ all -> 0x009d }
            r2.write(r6)     // Catch:{ all -> 0x009d }
            r2.flush()     // Catch:{ all -> 0x009d }
            r2.close()     // Catch:{ all -> 0x009d }
            goto L_0x0059
        L_0x0056:
            r7.connect()     // Catch:{ all -> 0x009d }
        L_0x0059:
            int r6 = r7.getResponseCode()     // Catch:{ all -> 0x009d }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 != r8) goto L_0x0091
            java.io.InputStream r6 = r7.getInputStream()     // Catch:{ all -> 0x009d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x008c }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x008c }
            r2.<init>(r6)     // Catch:{ all -> 0x008c }
            r8.<init>(r2)     // Catch:{ all -> 0x008c }
        L_0x0074:
            java.lang.String r1 = r8.readLine()     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0083
            r7.append(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "\n"
            r7.append(r1)     // Catch:{ all -> 0x0089 }
            goto L_0x0074
        L_0x0083:
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0089 }
            r1 = r8
            goto L_0x0092
        L_0x0089:
            r7 = move-exception
            r1 = r8
            goto L_0x00a2
        L_0x008c:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x009f
        L_0x0091:
            r6 = r1
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ Exception -> 0x00ab }
        L_0x0097:
            if (r6 == 0) goto L_0x00b3
        L_0x0099:
            r6.close()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00b3
        L_0x009d:
            r6 = move-exception
            r7 = r1
        L_0x009f:
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x00a2:
            r7.printStackTrace()     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00ad
            r1.close()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r6 = move-exception
            goto L_0x00b0
        L_0x00ad:
            if (r6 == 0) goto L_0x00b3
            goto L_0x0099
        L_0x00b0:
            r6.printStackTrace()
        L_0x00b3:
            return r0
        L_0x00b4:
            r7 = move-exception
            if (r1 == 0) goto L_0x00bd
            r1.close()     // Catch:{ Exception -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            r6 = move-exception
            goto L_0x00c3
        L_0x00bd:
            if (r6 == 0) goto L_0x00c6
            r6.close()     // Catch:{ Exception -> 0x00bb }
            goto L_0x00c6
        L_0x00c3:
            r6.printStackTrace()
        L_0x00c6:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.a.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
