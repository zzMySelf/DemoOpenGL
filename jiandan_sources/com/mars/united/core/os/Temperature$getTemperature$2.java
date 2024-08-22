package com.mars.united.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Temperature$getTemperature$2 extends Lambda implements Function1<String, Double> {
    public static final Temperature$getTemperature$2 INSTANCE = new Temperature$getTemperature$2();

    public Temperature$getTemperature$2() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Double invoke(@org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "r"
            r1.<init>(r7, r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0021 }
            if (r2 != 0) goto L_0x0015
            r2 = r0
            goto L_0x001d
        L_0x0015:
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ all -> 0x0021 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0021 }
        L_0x001d:
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0028 }
            goto L_0x002e
        L_0x0021:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ Exception -> 0x0028 }
            throw r3     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            r1 = move-exception
            r2 = 1
            com.mars.kotlin.extension.LoggerKt.w$default(r1, r0, r2, r0)
            r2 = r0
        L_0x002e:
            if (r2 != 0) goto L_0x0031
            return r0
        L_0x0031:
            double r1 = r2.doubleValue()
            kotlin.ranges.ClosedFloatingPointRange r3 = fe.ggg.ad.qw.de.ad.qw
            java.lang.Double r4 = java.lang.Double.valueOf(r1)
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x004b
            fe.ggg.ad.qw.de.ad.ad(r7)
            java.lang.Double r0 = java.lang.Double.valueOf(r1)
            goto L_0x0064
        L_0x004b:
            kotlin.ranges.ClosedFloatingPointRange r3 = fe.ggg.ad.qw.de.ad.qw
            r4 = 1000(0x3e8, float:1.401E-42)
            double r4 = (double) r4
            double r1 = r1 / r4
            java.lang.Double r4 = java.lang.Double.valueOf(r1)
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0064
            fe.ggg.ad.qw.de.ad.ad(r7)
            java.lang.Double r0 = java.lang.Double.valueOf(r1)
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.united.core.os.Temperature$getTemperature$2.invoke(java.lang.String):java.lang.Double");
    }
}
