package com.mars.kotlin.service.extension;

import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "client", "Lkotlin/Function1;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
public final class ResultReceiverKt$invoke$1 extends Lambda implements Function1<Function1<? super T, ? extends Object>, Unit> {
    public final /* synthetic */ Function0 $server;
    public final /* synthetic */ ResultReceiver $this_invoke;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResultReceiverKt$invoke$1(ResultReceiver resultReceiver, Function0 function0) {
        super(1);
        this.$this_invoke = resultReceiver;
        this.$server = function0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ Exception -> 0x007a }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit invoke(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            kotlin.jvm.functions.Function0 r2 = r7.$server     // Catch:{ Exception -> 0x007a }
            java.lang.Object r2 = r2.invoke()     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x0073
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x007a }
            kotlin.Pair r4 = com.mars.kotlin.service.extension.ResultReceiverKt.findErrorNumber(r3, r2)     // Catch:{ Exception -> 0x007a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
            r5.<init>()     // Catch:{ Exception -> 0x007a }
            r5.append(r2)     // Catch:{ Exception -> 0x007a }
            java.lang.String r6 = " 的错误码"
            r5.append(r6)     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x007a }
            com.mars.kotlin.extension.LoggerKt.d(r4, r5)     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x002f
            java.lang.Object r5 = r4.getFirst()     // Catch:{ Exception -> 0x007a }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x007a }
            goto L_0x0030
        L_0x002f:
            r5 = r1
        L_0x0030:
            if (r5 == 0) goto L_0x0053
            java.lang.Object r4 = r4.getSecond()     // Catch:{ Exception -> 0x007a }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x007a }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x007a }
            int r6 = r5.intValue()     // Catch:{ Exception -> 0x007a }
            if (r6 == r4) goto L_0x0053
            java.lang.String r8 = com.mars.kotlin.service.extension.ResultReceiverKt.findErrorMessage(r3, r2)     // Catch:{ Exception -> 0x007a }
            android.os.ResultReceiver r2 = r7.$this_invoke     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x006f
            int r3 = r5.intValue()     // Catch:{ Exception -> 0x007a }
            kotlin.Unit r8 = com.mars.kotlin.service.extension.ResultReceiverKt.serverWrong(r2, r3, r8)     // Catch:{ Exception -> 0x007a }
            goto L_0x0070
        L_0x0053:
            java.lang.Object r8 = r8.invoke(r2)     // Catch:{ Exception -> 0x007a }
            if (r8 == 0) goto L_0x0066
            android.os.ResultReceiver r2 = r7.$this_invoke     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x0062
            kotlin.Unit r8 = com.mars.kotlin.service.extension.ResultReceiverKt.right(r2, r8)     // Catch:{ Exception -> 0x007a }
            goto L_0x0063
        L_0x0062:
            r8 = r1
        L_0x0063:
            if (r8 == 0) goto L_0x0066
            goto L_0x0070
        L_0x0066:
            android.os.ResultReceiver r8 = r7.$this_invoke     // Catch:{ Exception -> 0x007a }
            if (r8 == 0) goto L_0x006f
            kotlin.Unit r8 = com.mars.kotlin.service.extension.ResultReceiverKt.right$default(r8, r1, r0, r1)     // Catch:{ Exception -> 0x007a }
            goto L_0x0070
        L_0x006f:
            r8 = r1
        L_0x0070:
            if (r8 == 0) goto L_0x0073
            goto L_0x0097
        L_0x0073:
            android.os.ResultReceiver r8 = r7.$this_invoke     // Catch:{ Exception -> 0x007a }
            kotlin.Unit r8 = com.mars.kotlin.service.extension.ResultReceiverKt.wrong(r8)     // Catch:{ Exception -> 0x007a }
            goto L_0x0097
        L_0x007a:
            r8 = move-exception
            java.lang.Object r8 = com.mars.kotlin.extension.LoggerKt.e$default(r8, r1, r0, r1)
            java.lang.Exception r8 = (java.lang.Exception) r8
            boolean r8 = r8 instanceof java.io.IOException
            if (r8 == 0) goto L_0x008e
            android.os.ResultReceiver r8 = r7.$this_invoke
            if (r8 == 0) goto L_0x0096
            kotlin.Unit r1 = com.mars.kotlin.service.extension.ResultReceiverKt.networkWrong(r8)
            goto L_0x0096
        L_0x008e:
            android.os.ResultReceiver r8 = r7.$this_invoke
            if (r8 == 0) goto L_0x0096
            kotlin.Unit r1 = com.mars.kotlin.service.extension.ResultReceiverKt.wrong(r8)
        L_0x0096:
            r8 = r1
        L_0x0097:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.service.extension.ResultReceiverKt$invoke$1.invoke(kotlin.jvm.functions.Function1):kotlin.Unit");
    }
}
