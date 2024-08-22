package com.alipay.sdk.m.n;

public class b {
    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|(2:10|(1:12)(1:43))|13|14|15|16|17|(2:18|19)|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0052 A[SYNTHETIC, Splitter:B:35:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0059 A[SYNTHETIC, Splitter:B:39:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0045 }
            r1.<init>(r6)     // Catch:{ all -> 0x0045 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003f }
            r6.<init>()     // Catch:{ all -> 0x003f }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0039 }
            r2.<init>(r6)     // Catch:{ all -> 0x0039 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0034 }
        L_0x0014:
            int r3 = r1.read(r0)     // Catch:{ all -> 0x0034 }
            r4 = -1
            if (r3 == r4) goto L_0x0020
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ all -> 0x0034 }
            goto L_0x0014
        L_0x0020:
            r2.flush()     // Catch:{ all -> 0x0034 }
            r2.finish()     // Catch:{ all -> 0x0034 }
            byte[] r0 = r6.toByteArray()     // Catch:{ all -> 0x0034 }
            r1.close()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r6.close()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            r2.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return r0
        L_0x0034:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0049
        L_0x0039:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r1
            r1 = r5
            goto L_0x0049
        L_0x003f:
            r6 = move-exception
            r2 = r0
            r0 = r1
            r1 = r6
            r6 = r2
            goto L_0x0049
        L_0x0045:
            r6 = move-exception
            r1 = r6
            r6 = r0
            r2 = r6
        L_0x0049:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            if (r6 == 0) goto L_0x0057
            r6.close()     // Catch:{ Exception -> 0x0056 }
            goto L_0x0057
        L_0x0056:
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n.b.a(byte[]):byte[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(4:8|9|10|(1:12)(1:37))|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:22|23|29|30|31|32|33|34|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r7) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x003b }
            r1.<init>(r7)     // Catch:{ all -> 0x003b }
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0037 }
            r7.<init>(r1)     // Catch:{ all -> 0x0037 }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x0035 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0035 }
            r4.<init>()     // Catch:{ all -> 0x0035 }
        L_0x0014:
            r0 = 0
            int r5 = r7.read(r3, r0, r2)     // Catch:{ all -> 0x0031 }
            r6 = -1
            if (r5 == r6) goto L_0x0020
            r4.write(r3, r0, r5)     // Catch:{ all -> 0x0031 }
            goto L_0x0014
        L_0x0020:
            r4.flush()     // Catch:{ all -> 0x0031 }
            byte[] r0 = r4.toByteArray()     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            r7.close()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r1.close()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            return r0
        L_0x0031:
            r0 = move-exception
            r2 = r0
            r0 = r4
            goto L_0x003f
        L_0x0035:
            r2 = move-exception
            goto L_0x003f
        L_0x0037:
            r7 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x003f
        L_0x003b:
            r7 = move-exception
            r2 = r7
            r7 = r0
            r1 = r7
        L_0x003f:
            r0.close()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            r7.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r1.close()     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n.b.b(byte[]):byte[]");
    }
}
