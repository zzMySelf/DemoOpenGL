package com.baidu.sofire.l;

import com.bun.miitmdid.interfaces.IIdentifierListener;

public class o implements IIdentifierListener {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ boolean[] b;

    public o(String[] strArr, boolean[] zArr) {
        this.a = strArr;
        this.b = zArr;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSupport(com.bun.miitmdid.interfaces.IdSupplier r3) {
        /*
            r2 = this;
            boolean r0 = r3.isSupported()
            r1 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String[] r0 = r2.a
            java.lang.String r3 = com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper.getOaid((com.bun.miitmdid.interfaces.IdSupplier) r3)
            r0[r1] = r3
        L_0x000f:
            boolean[] r3 = r2.b
            r0 = 1
            r3[r1] = r0
            java.lang.Object r3 = com.baidu.sofire.l.p.a
            java.lang.Object r3 = com.baidu.sofire.l.p.b
            monitor-enter(r3)
            java.lang.Object r0 = com.baidu.sofire.l.p.b
            r0.notifyAll()     // Catch:{ all -> 0x001f }
            goto L_0x0021
        L_0x001f:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.o.onSupport(com.bun.miitmdid.interfaces.IdSupplier):void");
    }
}
