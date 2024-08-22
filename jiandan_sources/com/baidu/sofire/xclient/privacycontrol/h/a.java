package com.baidu.sofire.xclient.privacycontrol.h;

import android.os.Handler;
import android.os.HandlerThread;

public class a extends HandlerThread {
    public static a a;
    public static Handler b;

    public a() {
        super("BackgroundThread", 10);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Handler a() {
        /*
            java.lang.Class<com.baidu.sofire.xclient.privacycontrol.h.a> r0 = com.baidu.sofire.xclient.privacycontrol.h.a.class
            monitor-enter(r0)
            com.baidu.sofire.xclient.privacycontrol.h.a r1 = a     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x001e
            com.baidu.sofire.xclient.privacycontrol.h.a r1 = new com.baidu.sofire.xclient.privacycontrol.h.a     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            a = r1     // Catch:{ all -> 0x001e }
            r1.start()     // Catch:{ all -> 0x001e }
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x001e }
            com.baidu.sofire.xclient.privacycontrol.h.a r2 = a     // Catch:{ all -> 0x001e }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ all -> 0x001e }
            r1.<init>(r2)     // Catch:{ all -> 0x001e }
            b = r1     // Catch:{ all -> 0x001e }
        L_0x001e:
            android.os.Handler r1 = b     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.h.a.a():android.os.Handler");
    }
}
