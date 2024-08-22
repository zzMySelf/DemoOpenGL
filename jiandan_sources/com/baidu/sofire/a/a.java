package com.baidu.sofire.a;

public class a {
    public static final /* synthetic */ int a = 0;

    static {
        new ThreadLocal();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0033 A[SYNTHETIC, Splitter:B:25:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
            java.lang.String r0 = ""
            if (r3 != 0) goto L_0x0005
            return r0
        L_0x0005:
            r1 = r3
        L_0x0006:
            if (r1 == 0) goto L_0x0012
            boolean r2 = r1 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x000d
            return r0
        L_0x000d:
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x003c }
            goto L_0x0006
        L_0x0012:
            r1 = 0
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ all -> 0x0030 }
            r2.<init>()     // Catch:{ all -> 0x0030 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x002d }
            r1.<init>(r2)     // Catch:{ all -> 0x002d }
            r3.printStackTrace(r1)     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x002d }
            r2.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x003c }
        L_0x002c:
            return r3
        L_0x002d:
            r3 = move-exception
            r1 = r2
            goto L_0x0031
        L_0x0030:
            r3 = move-exception
        L_0x0031:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x003c }
        L_0x003b:
            throw r3     // Catch:{ all -> 0x003c }
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.a(java.lang.Throwable):java.lang.String");
    }
}
