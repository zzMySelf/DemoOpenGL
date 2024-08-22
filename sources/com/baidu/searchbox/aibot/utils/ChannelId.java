package com.baidu.searchbox.aibot.utils;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/aibot/utils/ChannelId;", "", "()V", "INCREMENT_CARRY", "", "INCREMENT_MAX", "MAX", "RANDOM_MAX", "RANDOM_MIN", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "genNext", "", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelId.kt */
public final class ChannelId {
    public static final int INCREMENT_CARRY = 10000;
    public static final int INCREMENT_MAX = 9999;
    public static final ChannelId INSTANCE = new ChannelId();
    public static final int MAX = 99999999;
    public static final int RANDOM_MAX = 9999;
    public static final int RANDOM_MIN = 1000;
    private static AtomicInteger counter;

    private ChannelId() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String genNext() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.util.concurrent.atomic.AtomicInteger r1 = counter     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x002a
            int r1 = r1.getAndIncrement()     // Catch:{ all -> 0x0057 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0057 }
            r2 = r1
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x0057 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0057 }
            r3 = 0
            r4 = 99999999(0x5f5e0ff, float:2.312234E-35)
            if (r2 >= r4) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r1 == 0) goto L_0x002a
            int r1 = r1.intValue()     // Catch:{ all -> 0x0057 }
            goto L_0x002b
        L_0x002a:
            r1 = -1
        L_0x002b:
            if (r1 >= 0) goto L_0x0051
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0057 }
            kotlin.random.Random r2 = kotlin.random.RandomKt.Random((long) r2)     // Catch:{ all -> 0x0057 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r4 = 9999(0x270f, float:1.4012E-41)
            int r2 = r2.nextInt(r3, r4)     // Catch:{ all -> 0x0057 }
            r3 = 0
            java.util.concurrent.atomic.AtomicInteger r4 = new java.util.concurrent.atomic.AtomicInteger     // Catch:{ all -> 0x0057 }
            int r5 = r2 * 10000
            r4.<init>(r5)     // Catch:{ all -> 0x0057 }
            r2 = r4
            r3 = 0
            counter = r2     // Catch:{ all -> 0x0057 }
            int r2 = r4.getAndIncrement()     // Catch:{ all -> 0x0057 }
            r1 = r2
        L_0x0051:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0057 }
            monitor-exit(r6)
            return r2
        L_0x0057:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aibot.utils.ChannelId.genNext():java.lang.String");
    }
}
