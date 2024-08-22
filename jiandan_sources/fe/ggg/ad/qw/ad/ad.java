package fe.ggg.ad.qw.ad;

import com.mars.kotlin.extension.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    public static final void ad(@NotNull Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(th2, "<this>");
        Intrinsics.checkNotNullParameter(str, "prefix");
        if (Logger.INSTANCE.getEnable()) {
            Intrinsics.stringPlus("DevelopException ", str);
            th2.getMessage();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ba A[LOOP:0: B:1:0x0015->B:13:0x00ba, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String qw(@org.jetbrains.annotations.NotNull java.lang.String r14) {
        /*
            java.lang.String r0 = "log"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r1 = "stackTraceList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00be
            r4 = r0[r3]
            java.lang.String r5 = r4.getClassName()
            java.lang.String r6 = "it.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r7 = "dalvik"
            r8 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r7, r2, r8, r9)
            r7 = 1
            if (r5 != 0) goto L_0x004d
            java.lang.String r5 = r4.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r10 = "java"
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r10, r2, r8, r9)
            if (r5 != 0) goto L_0x004d
            java.lang.String r5 = r4.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = "com.mars.united.core.debug.Mars"
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r6, r2, r8, r9)
            if (r5 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            if (r5 == 0) goto L_0x00ba
            java.lang.String r0 = r4.getClassName()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "fullClassName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.lang.String r9 = "."
            r8 = r0
            int r2 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r8, (java.lang.String) r9, (int) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r2 = r2 + r7
            java.lang.String r0 = r0.substring(r2)
            java.lang.String r2 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r2 = r4.getMethodName()
            java.lang.String r3 = r4.getFileName()
            int r4 = r4.getLineNumber()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r14 = " ["
            r5.append(r14)
            r5.append(r1)
            r14 = 58
            r5.append(r14)
            r5.append(r0)
            r0 = 46
            r5.append(r0)
            r5.append(r2)
            r0 = 40
            r5.append(r0)
            r5.append(r3)
            r5.append(r14)
            r5.append(r4)
            java.lang.String r14 = ")]"
            r5.append(r14)
            java.lang.String r14 = r5.toString()
            return r14
        L_0x00ba:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00be:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
            java.lang.String r0 = "Array contains no element matching the predicate."
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ggg.ad.qw.ad.ad.qw(java.lang.String):java.lang.String");
    }
}
