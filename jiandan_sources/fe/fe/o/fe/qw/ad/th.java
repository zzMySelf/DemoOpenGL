package fe.fe.o.fe.qw.ad;

import fe.fe.o.fe.qw.de.i;

public class th extends i {
    public th(long[] jArr) {
        super(jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ad(java.io.IOException r8, int r9, java.lang.String r10, int r11) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            if (r9 < r1) goto L_0x0020
            long[] r2 = r7.qw
            int r3 = r2.length
            if (r9 > r3) goto L_0x0020
            int r2 = r2.length
            int r2 = r2 * 3
            if (r11 <= r2) goto L_0x000f
            goto L_0x0020
        L_0x000f:
            java.util.HashSet r11 = fe.fe.o.fe.qw.de.i.f2527de
            boolean r11 = r7.qw(r11, r8)
            if (r11 == 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.util.HashSet r11 = fe.fe.o.fe.qw.de.i.f2526ad
            boolean r11 = r7.qw(r11, r8)
            r11 = 1
            goto L_0x0021
        L_0x0020:
            r11 = 0
        L_0x0021:
            boolean r2 = r8 instanceof org.apache.http.client.HttpResponseException
            if (r2 == 0) goto L_0x0035
            r2 = r8
            org.apache.http.client.HttpResponseException r2 = (org.apache.http.client.HttpResponseException) r2
            int r2 = r2.getStatusCode()
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 == r3) goto L_0x0034
            r3 = 412(0x19c, float:5.77E-43)
            if (r2 != r3) goto L_0x0035
        L_0x0034:
            return r0
        L_0x0035:
            if (r11 == 0) goto L_0x0076
            long[] r8 = r7.qw     // Catch:{ InterruptedException -> 0x0079 }
            int r9 = r9 - r1
            r0 = r8[r9]     // Catch:{ InterruptedException -> 0x0079 }
            r8 = 0
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0079
            fe.fe.o.th.qw.qw r2 = fe.fe.o.th.qw.qw.ad()     // Catch:{ InterruptedException -> 0x0079 }
            boolean r2 = r2.qw     // Catch:{ InterruptedException -> 0x0079 }
            if (r2 == 0) goto L_0x0072
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ InterruptedException -> 0x0079 }
            if (r2 != 0) goto L_0x0072
            fe.fe.o.th.qw.qw r2 = fe.fe.o.th.qw.qw.ad()     // Catch:{ InterruptedException -> 0x0079 }
            r3 = 5000(0x1388, double:2.4703E-320)
            boolean r2 = r2.de(r10, r3)     // Catch:{ InterruptedException -> 0x0079 }
            if (r2 != 0) goto L_0x0072
        L_0x005c:
            long r5 = r0 - r3
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0072
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0079 }
            fe.fe.o.th.qw.qw r0 = fe.fe.o.th.qw.qw.ad()     // Catch:{ InterruptedException -> 0x0079 }
            boolean r0 = r0.de(r10, r3)     // Catch:{ InterruptedException -> 0x0079 }
            if (r0 == 0) goto L_0x0070
            return r11
        L_0x0070:
            r0 = r5
            goto L_0x005c
        L_0x0072:
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0079 }
            goto L_0x0079
        L_0x0076:
            r8.printStackTrace()
        L_0x0079:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.fe.qw.ad.th.ad(java.io.IOException, int, java.lang.String, int):boolean");
    }
}
