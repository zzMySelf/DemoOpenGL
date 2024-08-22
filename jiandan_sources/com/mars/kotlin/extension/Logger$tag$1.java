package com.mars.kotlin.extension;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/StackTraceElement;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Logger$tag$1 extends Lambda implements Function1<StackTraceElement, Boolean> {
    public static final Logger$tag$1 INSTANCE = new Logger$tag$1();

    public Logger$tag$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, "com.android.", false, 2, (java.lang.Object) null) != false) goto L_0x0041;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(java.lang.StackTraceElement r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getClassName()
            java.lang.String r1 = "it.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "android."
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = r7.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "java."
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = r7.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "dalvik."
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0041
            java.lang.String r7 = r7.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.String r0 = "com.android."
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r0, r3, r4, r5)
            if (r7 == 0) goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.Logger$tag$1.invoke(java.lang.StackTraceElement):java.lang.Boolean");
    }
}
