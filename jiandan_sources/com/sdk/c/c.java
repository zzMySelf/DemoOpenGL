package com.sdk.c;

import com.sdk.f.f;

public class c {
    public static final Boolean a = Boolean.valueOf(f.a);

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bc A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.net.HttpURLConnection r18, com.sdk.c.b r19, java.lang.String r20) {
        /*
            r17 = this;
            r0 = r20
            r1 = 0
            if (r18 == 0) goto L_0x00b9
            r8 = 0
            int r2 = r18.getContentLength()     // Catch:{ Exception -> 0x00ab }
            long r13 = (long) r2
            if (r19 == 0) goto L_0x001c
            r7 = 1
            r2 = r19
            com.sdk.a.e r2 = (com.sdk.a.e) r2
            r3 = r13
            r5 = r8
            boolean r2 = r2.a(r3, r5, r7)     // Catch:{ Exception -> 0x00ab }
            if (r2 != 0) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
            r2.<init>()     // Catch:{ Exception -> 0x00ab }
            java.io.InputStream r3 = r18.getInputStream()     // Catch:{ Exception -> 0x00a5 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a5 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00a5 }
            r5.<init>(r3, r0)     // Catch:{ Exception -> 0x00a5 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a5 }
        L_0x002f:
            java.lang.String r3 = r4.readLine()     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x0090
            r2.append(r3)     // Catch:{ Exception -> 0x00a5 }
            r5 = 10
            r2.append(r5)     // Catch:{ Exception -> 0x00a5 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00a5 }
            r6 = 0
            if (r5 == 0) goto L_0x0048
        L_0x0045:
            r16 = r2
            goto L_0x0078
        L_0x0048:
            int r5 = r3.length()     // Catch:{ Exception -> 0x00a5 }
            r10 = 100
            if (r5 >= r10) goto L_0x0057
            byte[] r3 = r3.getBytes(r0)     // Catch:{ Exception -> 0x00a5 }
            int r3 = r3.length     // Catch:{ Exception -> 0x00a5 }
            long r6 = (long) r3     // Catch:{ Exception -> 0x00a5 }
            goto L_0x0045
        L_0x0057:
            r10 = 0
        L_0x0058:
            if (r10 >= r5) goto L_0x0045
            int r11 = r10 + 100
            if (r11 >= r5) goto L_0x0060
            r12 = r11
            goto L_0x0061
        L_0x0060:
            r12 = r5
        L_0x0061:
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r10 = r3.substring(r10, r12)     // Catch:{ Exception -> 0x00a5 }
            r15.<init>(r10)     // Catch:{ Exception -> 0x00a5 }
            byte[] r10 = r15.getBytes(r0)     // Catch:{ Exception -> 0x00a5 }
            int r10 = r10.length     // Catch:{ Exception -> 0x00a5 }
            r16 = r2
            long r1 = (long) r10
            long r6 = r6 + r1
            r10 = r11
            r2 = r16
            r1 = 0
            goto L_0x0058
        L_0x0078:
            long r8 = r8 + r6
            if (r19 == 0) goto L_0x008a
            r15 = 0
            r10 = r19
            com.sdk.a.e r10 = (com.sdk.a.e) r10
            r11 = r13
            r1 = r13
            r13 = r8
            boolean r3 = r10.a(r11, r13, r15)     // Catch:{ Exception -> 0x00a0 }
            if (r3 != 0) goto L_0x008b
            goto L_0x0093
        L_0x008a:
            r1 = r13
        L_0x008b:
            r13 = r1
            r2 = r16
            r1 = 0
            goto L_0x002f
        L_0x0090:
            r16 = r2
            r1 = r13
        L_0x0093:
            r13 = r8
            if (r19 == 0) goto L_0x00a2
            r15 = 1
            r10 = r19
            com.sdk.a.e r10 = (com.sdk.a.e) r10
            r11 = r1
            r10.a(r11, r13, r15)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a2
        L_0x00a0:
            r0 = move-exception
            goto L_0x00a8
        L_0x00a2:
            r2 = r16
            goto L_0x00ba
        L_0x00a5:
            r0 = move-exception
            r16 = r2
        L_0x00a8:
            r2 = r16
            goto L_0x00ad
        L_0x00ab:
            r0 = move-exception
            r2 = 0
        L_0x00ad:
            java.lang.String r0 = r0.getMessage()
            java.lang.Boolean r1 = a
            java.lang.String r3 = "StringDownloadHandler"
            com.sdk.o.a.a(r3, r0, r1)
            goto L_0x00ba
        L_0x00b9:
            r2 = 0
        L_0x00ba:
            if (r2 != 0) goto L_0x00be
            r1 = 0
            goto L_0x00c6
        L_0x00be:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = r0.trim()
        L_0x00c6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.c.c.a(java.net.HttpURLConnection, com.sdk.c.b, java.lang.String):java.lang.String");
    }
}
