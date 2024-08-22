package com.dlife.ctaccountapi;

public class a {
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0098, code lost:
        if (r6 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (r6 != null) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8 A[SYNTHETIC, Splitter:B:33:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r6 = "UTF-8"
            java.lang.String r0 = ""
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x009e }
            r2.<init>(r7)     // Catch:{ all -> 0x009e }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ all -> 0x009e }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "accept"
            java.lang.String r3 = "*/*"
            r7.setRequestProperty(r2, r3)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch:{ all -> 0x009e }
            r2 = 1
            r7.setDoOutput(r2)     // Catch:{ all -> 0x009e }
            r7.setDoInput(r2)     // Catch:{ all -> 0x009e }
            r2 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r2)     // Catch:{ all -> 0x009e }
            r7.setReadTimeout(r2)     // Catch:{ all -> 0x009e }
            r2 = 0
            r7.setUseCaches(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "Accept-Charset"
            r7.addRequestProperty(r2, r6)     // Catch:{ all -> 0x009e }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x009e }
            if (r2 != 0) goto L_0x0056
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x009e }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x009e }
            java.io.OutputStream r4 = r7.getOutputStream()     // Catch:{ all -> 0x009e }
            r3.<init>(r4)     // Catch:{ all -> 0x009e }
            r2.<init>(r3)     // Catch:{ all -> 0x009e }
            byte[] r6 = r8.getBytes(r6)     // Catch:{ all -> 0x009e }
            r2.write(r6)     // Catch:{ all -> 0x009e }
            r2.flush()     // Catch:{ all -> 0x009e }
            r2.close()     // Catch:{ all -> 0x009e }
            goto L_0x0059
        L_0x0056:
            r7.connect()     // Catch:{ all -> 0x009e }
        L_0x0059:
            int r6 = r7.getResponseCode()     // Catch:{ all -> 0x009e }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 != r8) goto L_0x0092
            java.io.InputStream r6 = r7.getInputStream()     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r7.<init>()     // Catch:{ all -> 0x008d }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x008d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x008d }
            r2.<init>(r6)     // Catch:{ all -> 0x008d }
            r8.<init>(r2)     // Catch:{ all -> 0x008d }
        L_0x0074:
            java.lang.String r1 = r8.readLine()     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0084
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ all -> 0x008a }
            goto L_0x0074
        L_0x0084:
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x008a }
            r1 = r8
            goto L_0x0093
        L_0x008a:
            r7 = move-exception
            r1 = r8
            goto L_0x00a3
        L_0x008d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00a0
        L_0x0092:
            r6 = r1
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ Exception -> 0x00ac }
        L_0x0098:
            if (r6 == 0) goto L_0x00b4
        L_0x009a:
            r6.close()     // Catch:{ Exception -> 0x00ac }
            goto L_0x00b4
        L_0x009e:
            r6 = move-exception
            r7 = r1
        L_0x00a0:
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x00a3:
            r7.printStackTrace()     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00ae
            r1.close()     // Catch:{ Exception -> 0x00ac }
            goto L_0x00ae
        L_0x00ac:
            r6 = move-exception
            goto L_0x00b1
        L_0x00ae:
            if (r6 == 0) goto L_0x00b4
            goto L_0x009a
        L_0x00b1:
            r6.printStackTrace()
        L_0x00b4:
            return r0
        L_0x00b5:
            r7 = move-exception
            if (r1 == 0) goto L_0x00be
            r1.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            r6 = move-exception
            goto L_0x00c4
        L_0x00be:
            if (r6 == 0) goto L_0x00c7
            r6.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c7
        L_0x00c4:
            r6.printStackTrace()
        L_0x00c7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.a.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
