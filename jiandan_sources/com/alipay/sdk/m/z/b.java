package com.alipay.sdk.m.z;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[SYNTHETIC, Splitter:B:17:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            boolean r4 = r2.exists()     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            if (r4 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            java.lang.String r2 = "UTF-8"
            r5.<init>(r3, r2)     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x003a, all -> 0x0032 }
        L_0x0023:
            java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            if (r5 == 0) goto L_0x003e
            r0.append(r5)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            goto L_0x0023
        L_0x002d:
            r5 = move-exception
            r1 = r4
            goto L_0x0034
        L_0x0030:
            r1 = r4
            goto L_0x003b
        L_0x0032:
            r4 = move-exception
            r5 = r4
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            throw r5
        L_0x003a:
        L_0x003b:
            if (r1 == 0) goto L_0x0041
            r4 = r1
        L_0x003e:
            r4.close()     // Catch:{ all -> 0x0041 }
        L_0x0041:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.z.b.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
