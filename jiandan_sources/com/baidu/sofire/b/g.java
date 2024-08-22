package com.baidu.sofire.b;

import android.os.Bundle;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.CallArgs;
import java.util.concurrent.CountDownLatch;

public class g extends Callback {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ CallArgs b;
    public final /* synthetic */ CountDownLatch c;

    public g(Bundle bundle, CallArgs callArgs, CountDownLatch countDownLatch, String str) {
        this.a = bundle;
        this.b = callArgs;
        this.c = countDownLatch;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        r3.c.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object onEnd(java.lang.Object... r4) {
        /*
            r3 = this;
            android.os.Bundle r0 = r3.a     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "status"
            r2 = 0
            r0.putInt(r1, r2)     // Catch:{ all -> 0x000f }
            com.baidu.sofire.core.CallArgs r0 = r3.b     // Catch:{ all -> 0x000f }
            r4 = r4[r2]     // Catch:{ all -> 0x000f }
            r0.f = r4     // Catch:{ all -> 0x000f }
            goto L_0x0011
        L_0x000f:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0018 }
        L_0x0011:
            java.util.concurrent.CountDownLatch r4 = r3.c
            r4.countDown()
            r4 = 0
            return r4
        L_0x0018:
            r4 = move-exception
            java.util.concurrent.CountDownLatch r0 = r3.c
            r0.countDown()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.g.onEnd(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object onError(java.lang.Object... r4) {
        /*
            r3 = this;
            android.os.Bundle r0 = r3.a     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "status"
            r2 = 0
            r4 = r4[r2]     // Catch:{ all -> 0x0011 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0011 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0011 }
            r0.putInt(r1, r4)     // Catch:{ all -> 0x0011 }
            goto L_0x0013
        L_0x0011:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x001a }
        L_0x0013:
            java.util.concurrent.CountDownLatch r4 = r3.c
            r4.countDown()
            r4 = 0
            return r4
        L_0x001a:
            r4 = move-exception
            java.util.concurrent.CountDownLatch r0 = r3.c
            r0.countDown()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.g.onError(java.lang.Object[]):java.lang.Object");
    }
}
