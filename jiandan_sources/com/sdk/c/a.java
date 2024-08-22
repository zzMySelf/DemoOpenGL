package com.sdk.c;

public class a {
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
        r6 = r13;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r6.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
        if (r19 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        ((com.sdk.a.e) r19).a(r15, r4, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c7, code lost:
        if (r6 != null) goto L_0x00c9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c2 A[SYNTHETIC, Splitter:B:70:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File a(java.net.HttpURLConnection r18, com.sdk.c.b r19, java.lang.String r20, boolean r21, java.lang.String r22) {
        /*
            r17 = this;
            r0 = r20
            r1 = r22
            r2 = 0
            if (r18 == 0) goto L_0x011e
            boolean r3 = android.text.TextUtils.isEmpty(r20)
            if (r3 == 0) goto L_0x000f
            goto L_0x011e
        L_0x000f:
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002d
            java.io.File r4 = r3.getParentFile()
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x002a
            boolean r4 = r4.mkdirs()
            if (r4 == 0) goto L_0x002d
        L_0x002a:
            r3.createNewFile()
        L_0x002d:
            r4 = 0
            if (r21 == 0) goto L_0x003c
            long r4 = r3.length()     // Catch:{ all -> 0x00bb }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bb }
            r7 = 1
            r6.<init>(r0, r7)     // Catch:{ all -> 0x00bb }
            goto L_0x0041
        L_0x003c:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bb }
            r6.<init>(r0)     // Catch:{ all -> 0x00bb }
        L_0x0041:
            int r0 = r18.getContentLength()     // Catch:{ all -> 0x00bb }
            long r7 = (long) r0     // Catch:{ all -> 0x00bb }
            long r15 = r7 + r4
            java.io.BufferedInputStream r14 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00bb }
            java.io.InputStream r0 = r18.getInputStream()     // Catch:{ all -> 0x00bb }
            r14.<init>(r0)     // Catch:{ all -> 0x00bb }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00b6 }
            r13.<init>(r6)     // Catch:{ all -> 0x00b6 }
            if (r19 == 0) goto L_0x006c
            r12 = 1
            r7 = r19
            com.sdk.a.e r7 = (com.sdk.a.e) r7
            r8 = r15
            r10 = r4
            boolean r0 = r7.a(r8, r10, r12)     // Catch:{ all -> 0x00b2 }
            if (r0 != 0) goto L_0x006c
            r14.close()     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r13.close()     // Catch:{ all -> 0x006b }
        L_0x006b:
            return r3
        L_0x006c:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00b2 }
        L_0x0070:
            int r2 = r14.read(r0)     // Catch:{ all -> 0x00b2 }
            r6 = -1
            if (r2 == r6) goto L_0x009b
            r6 = 0
            r13.write(r0, r6, r2)     // Catch:{ all -> 0x00b2 }
            long r6 = (long) r2
            long r4 = r4 + r6
            if (r19 == 0) goto L_0x0096
            r2 = 0
            r9 = r19
            com.sdk.a.e r9 = (com.sdk.a.e) r9
            r10 = r15
            r6 = r13
            r12 = r4
            r7 = r14
            r14 = r2
            boolean r2 = r9.a(r10, r12, r14)     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x0098
            r7.close()     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r6.close()     // Catch:{ all -> 0x0095 }
        L_0x0095:
            return r3
        L_0x0096:
            r6 = r13
            r7 = r14
        L_0x0098:
            r13 = r6
            r14 = r7
            goto L_0x0070
        L_0x009b:
            r6 = r13
            r7 = r14
            r6.flush()     // Catch:{ all -> 0x00b0 }
            if (r19 == 0) goto L_0x00ac
            r14 = 1
            r9 = r19
            com.sdk.a.e r9 = (com.sdk.a.e) r9
            r10 = r15
            r12 = r4
            r9.a(r10, r12, r14)     // Catch:{ all -> 0x00b0 }
        L_0x00ac:
            r7.close()     // Catch:{ all -> 0x00c9 }
            goto L_0x00c9
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b2:
            r0 = move-exception
            r6 = r13
            r7 = r14
            goto L_0x00b9
        L_0x00b6:
            r0 = move-exception
            r7 = r14
            r6 = r2
        L_0x00b9:
            r2 = r7
            goto L_0x00bd
        L_0x00bb:
            r0 = move-exception
            r6 = r2
        L_0x00bd:
            r0.printStackTrace()     // Catch:{ all -> 0x010f }
            if (r2 == 0) goto L_0x00c7
            r2.close()     // Catch:{ all -> 0x00c6 }
            goto L_0x00c7
        L_0x00c6:
        L_0x00c7:
            if (r6 == 0) goto L_0x00cf
        L_0x00c9:
            r13 = r6
            r13.close()     // Catch:{ all -> 0x00ce }
            goto L_0x00cf
        L_0x00ce:
        L_0x00cf:
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x010e
            boolean r0 = android.text.TextUtils.isEmpty(r22)
            if (r0 != 0) goto L_0x010e
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r3.getParent()
            r0.<init>(r2, r1)
        L_0x00e4:
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0107
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r3.getParent()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r5 = java.lang.System.currentTimeMillis()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            r0.<init>(r2, r4)
            goto L_0x00e4
        L_0x0107:
            boolean r1 = r3.renameTo(r0)
            if (r1 == 0) goto L_0x010e
            r3 = r0
        L_0x010e:
            return r3
        L_0x010f:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L_0x0118
            r2.close()     // Catch:{ all -> 0x0117 }
            goto L_0x0118
        L_0x0117:
        L_0x0118:
            if (r6 == 0) goto L_0x011d
            r6.close()     // Catch:{ all -> 0x011d }
        L_0x011d:
            throw r1
        L_0x011e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.c.a.a(java.net.HttpURLConnection, com.sdk.c.b, java.lang.String, boolean, java.lang.String):java.io.File");
    }
}
