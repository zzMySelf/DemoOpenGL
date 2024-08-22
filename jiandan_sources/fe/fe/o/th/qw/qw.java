package fe.fe.o.th.qw;

import java.io.IOException;
import java.util.HashMap;

public final class qw {

    /* renamed from: de  reason: collision with root package name */
    public static qw f2684de;

    /* renamed from: ad  reason: collision with root package name */
    public HashMap f2685ad;
    public boolean qw;

    public qw() {
        this.qw = true;
        this.f2685ad = null;
        this.f2685ad = new HashMap();
    }

    public static qw ad() {
        if (f2684de == null) {
            f2684de = new qw();
        }
        return f2684de;
    }

    public static int qw(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("ping -c 1 " + str);
            exec.waitFor();
            return exec.exitValue();
        } catch (IOException | InterruptedException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean de(java.lang.String r8, long r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0049 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r7)
            return r1
        L_0x000a:
            java.util.HashMap r0 = r7.f2685ad     // Catch:{ all -> 0x0049 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x0049 }
            r2 = 1
            if (r0 == 0) goto L_0x002d
            java.util.HashMap r0 = r7.f2685ad     // Catch:{ all -> 0x0049 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0049 }
            fe.fe.o.th.qw.de r0 = (fe.fe.o.th.qw.de) r0     // Catch:{ all -> 0x0049 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0049 }
            long r5 = r0.qw     // Catch:{ all -> 0x0049 }
            long r3 = r3 - r5
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x002d
            int r8 = r0.f2683ad     // Catch:{ all -> 0x0049 }
            if (r8 != 0) goto L_0x002b
            r1 = 1
        L_0x002b:
            monitor-exit(r7)
            return r1
        L_0x002d:
            int r9 = qw(r8)     // Catch:{ all -> 0x0049 }
            fe.fe.o.th.qw.de r10 = new fe.fe.o.th.qw.de     // Catch:{ all -> 0x0049 }
            r0 = 0
            r10.<init>()     // Catch:{ all -> 0x0049 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0049 }
            r10.qw = r3     // Catch:{ all -> 0x0049 }
            r10.f2683ad = r9     // Catch:{ all -> 0x0049 }
            java.util.HashMap r0 = r7.f2685ad     // Catch:{ all -> 0x0049 }
            r0.put(r8, r10)     // Catch:{ all -> 0x0049 }
            if (r9 != 0) goto L_0x0047
            r1 = 1
        L_0x0047:
            monitor-exit(r7)
            return r1
        L_0x0049:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.th.qw.qw.de(java.lang.String, long):boolean");
    }
}
