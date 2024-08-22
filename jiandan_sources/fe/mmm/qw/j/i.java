package fe.mmm.qw.j;

import android.os.SystemClock;
import java.net.HttpURLConnection;

public class i {

    /* renamed from: ad  reason: collision with root package name */
    public static long f7966ad = -1;
    public static boolean qw;

    public static long ad() {
        return qw ? SystemClock.elapsedRealtime() + f7966ad : System.currentTimeMillis();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void de(java.net.HttpURLConnection r6) {
        /*
            java.lang.Class<fe.mmm.qw.j.i> r0 = fe.mmm.qw.j.i.class
            monitor-enter(r0)
            boolean r1 = qw     // Catch:{ all -> 0x003e }
            if (r1 != 0) goto L_0x003c
            long r1 = qw(r6)     // Catch:{ all -> 0x003e }
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0016
            r6 = 0
            qw = r6     // Catch:{ all -> 0x003e }
            monitor-exit(r0)
            return
        L_0x0016:
            java.lang.String r6 = "RealTimeUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r3.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Server 时间和本地时间差值为："
            r3.append(r4)     // Catch:{ all -> 0x003e }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003e }
            long r4 = r1 - r4
            r3.append(r4)     // Catch:{ all -> 0x003e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003e }
            fe.mmm.qw.i.qw.uk(r6, r3)     // Catch:{ all -> 0x003e }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x003e }
            long r1 = r1 - r3
            f7966ad = r1     // Catch:{ all -> 0x003e }
            r6 = 1
            qw = r6     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r0)
            return
        L_0x003e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.i.de(java.net.HttpURLConnection):void");
    }

    public static long qw(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            return httpURLConnection.getHeaderFieldDate("Date", 0);
        }
        return -1;
    }
}
