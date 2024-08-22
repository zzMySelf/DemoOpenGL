package rg.qw;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public long f10434ad = SystemClock.elapsedRealtime();

    /* renamed from: de  reason: collision with root package name */
    public long f10435de;
    public final TimeUnit qw;

    public fe(TimeUnit timeUnit) {
        this.qw = timeUnit;
        this.f10435de = 0;
    }

    public long ad() {
        return this.f10435de;
    }

    public long de() {
        return this.f10434ad;
    }

    public void fe(long j) {
        this.f10435de = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[Catch:{ Exception -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c A[Catch:{ Exception -> 0x0063 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String qw() {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r7.f10434ad
            long r0 = r0 - r2
            long r2 = r7.f10435de
            long r0 = r0 + r2
            r2 = 0
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x005e
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0019
            goto L_0x005e
        L_0x0019:
            java.util.concurrent.TimeUnit r2 = r7.qw     // Catch:{ Exception -> 0x0063 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0063 }
            if (r2 != r3) goto L_0x0021
        L_0x001f:
            float r0 = (float) r0     // Catch:{ Exception -> 0x0063 }
            goto L_0x0042
        L_0x0021:
            java.util.concurrent.TimeUnit r2 = r7.qw     // Catch:{ Exception -> 0x0063 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0063 }
            r5 = 1148846080(0x447a0000, float:1000.0)
            if (r2 != r3) goto L_0x002c
            float r0 = (float) r0     // Catch:{ Exception -> 0x0063 }
            float r0 = r0 / r5
            goto L_0x0042
        L_0x002c:
            java.util.concurrent.TimeUnit r2 = r7.qw     // Catch:{ Exception -> 0x0063 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x0063 }
            r6 = 1114636288(0x42700000, float:60.0)
            if (r2 != r3) goto L_0x0038
            float r0 = (float) r0     // Catch:{ Exception -> 0x0063 }
            float r0 = r0 / r5
        L_0x0036:
            float r0 = r0 / r6
            goto L_0x0042
        L_0x0038:
            java.util.concurrent.TimeUnit r2 = r7.qw     // Catch:{ Exception -> 0x0063 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ Exception -> 0x0063 }
            if (r2 != r3) goto L_0x001f
            float r0 = (float) r0     // Catch:{ Exception -> 0x0063 }
            float r0 = r0 / r5
            float r0 = r0 / r6
            goto L_0x0036
        L_0x0042:
            r1 = 0
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x004c
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0063 }
            goto L_0x005d
        L_0x004c:
            java.util.Locale r1 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x0063 }
            java.lang.String r2 = "%.3f"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0063 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x0063 }
            r3[r4] = r0     // Catch:{ Exception -> 0x0063 }
            java.lang.String r0 = java.lang.String.format(r1, r2, r3)     // Catch:{ Exception -> 0x0063 }
        L_0x005d:
            return r0
        L_0x005e:
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0063 }
            return r0
        L_0x0063:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = java.lang.String.valueOf(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rg.qw.fe.qw():java.lang.String");
    }

    public void rg(long j) {
        this.f10434ad = j;
    }
}
