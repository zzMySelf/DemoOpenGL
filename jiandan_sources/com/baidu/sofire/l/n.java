package com.baidu.sofire.l;

import com.baidu.helios.OnGetIdResultCallback;

public class n implements OnGetIdResultCallback<String> {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ boolean[] b;

    public n(String[] strArr, boolean[] zArr) {
        this.a = strArr;
        this.b = zArr;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(int r1, java.lang.Throwable r2, android.os.Bundle r3) {
        /*
            r0 = this;
            boolean[] r1 = r0.b     // Catch:{ all -> 0x0018 }
            r2 = 0
            r3 = 1
            r1[r2] = r3     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = com.baidu.sofire.l.p.a     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = com.baidu.sofire.l.p.a
            monitor-enter(r1)     // Catch:{ all -> 0x0018 }
            java.lang.Object r2 = com.baidu.sofire.l.p.a
            r2.notifyAll()     // Catch:{ all -> 0x0011 }
            goto L_0x0013
        L_0x0011:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x0015 }
            goto L_0x001a
        L_0x0015:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            int r1 = com.baidu.sofire.a.a.a
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.n.onError(int, java.lang.Throwable, android.os.Bundle):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(java.lang.Object r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String[] r3 = r1.a     // Catch:{ all -> 0x001e }
            r0 = 0
            r3[r0] = r2     // Catch:{ all -> 0x001e }
            boolean[] r2 = r1.b     // Catch:{ all -> 0x001e }
            r3 = 1
            r2[r0] = r3     // Catch:{ all -> 0x001e }
            java.lang.Object r2 = com.baidu.sofire.l.p.a     // Catch:{ all -> 0x001e }
            java.lang.Object r2 = com.baidu.sofire.l.p.a
            monitor-enter(r2)     // Catch:{ all -> 0x001e }
            java.lang.Object r3 = com.baidu.sofire.l.p.a
            r3.notifyAll()     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            goto L_0x0020
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3     // Catch:{ all -> 0x001e }
        L_0x001e:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.n.onResult(java.lang.Object, android.os.Bundle):void");
    }
}
