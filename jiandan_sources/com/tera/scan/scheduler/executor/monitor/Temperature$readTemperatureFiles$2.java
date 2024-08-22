package com.tera.scan.scheduler.executor.monitor;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Double;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Temperature$readTemperatureFiles$2 extends Lambda implements Function1<String, Double> {
    public final /* synthetic */ Context $arg0;
    public final /* synthetic */ boolean $isCpu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Temperature$readTemperatureFiles$2(Context context, boolean z) {
        super(1);
        this.$arg0 = context;
        this.$isCpu = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Double invoke(@org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0038 }
            java.lang.String r2 = "r"
            r1.<init>(r5, r2)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x002b
            java.lang.String r3 = "readLine()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "第一行"
            java.lang.Object r2 = com.mars.kotlin.extension.LoggerKt.d(r2, r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x002b
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ all -> 0x0031 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0031 }
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0038 }
            r0 = r2
            goto L_0x003d
        L_0x0031:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ Exception -> 0x0038 }
            throw r3     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            r2 = 1
            com.mars.kotlin.extension.LoggerKt.w$default(r1, r0, r2, r0)
        L_0x003d:
            android.content.Context r1 = r4.$arg0
            boolean r2 = r4.$isCpu
            java.lang.Double r5 = fe.mmm.qw.a.yj.ad.qw.ad(r1, r2, r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scheduler.executor.monitor.Temperature$readTemperatureFiles$2.invoke(java.lang.String):java.lang.Double");
    }
}
