package fe.mmm.qw.th.qw.fe;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    public static /* synthetic */ void fe(ad adVar, String str, qw qwVar, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            qwVar = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        adVar.de(str, qwVar, num, function1);
    }

    public final void ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        fe(this, str, (qw) null, (Integer) null, (Function1) null, 12, (Object) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void de(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.Nullable fe.mmm.qw.th.qw.fe.qw r12, @org.jetbrains.annotations.Nullable java.lang.Integer r13, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super com.alibaba.android.arouter.facade.Postcard, kotlin.Unit> r14) {
        /*
            r10 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r10.qw(r11)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.net.Uri r11 = android.net.Uri.parse(r11)
            if (r11 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = r11.getAuthority()
            com.tera.scan.component.base.router.Authority r1 = com.tera.scan.component.base.router.Authority.ROUTER
            java.lang.String r1 = r1.name()
            r2 = 1
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r1, r2)
            if (r0 != 0) goto L_0x0025
            return
        L_0x0025:
            fe.ad.qw.qw.ad.qw r0 = fe.ad.qw.qw.ad.qw.de()
            java.lang.String r1 = r11.getPath()
            com.alibaba.android.arouter.facade.Postcard r0 = r0.qw(r1)
            java.util.Set r1 = r11.getQueryParameterNames()
            if (r1 != 0) goto L_0x0039
            goto L_0x0162
        L_0x0039:
            java.lang.String r3 = "uri.queryParameterNames ?: return@with"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0047:
            boolean r4 = r1.hasNext()
            java.lang.String r5 = "RType"
            r6 = 0
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r1.next()
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r8 = 0
            r9 = 2
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r7, r5, r8, r9, r6)
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0047
            r3.add(r4)
            goto L_0x0047
        L_0x0069:
            java.util.Iterator r1 = r3.iterator()
        L_0x006d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x014a
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = r11.getQueryParameter(r3)
            if (r4 != 0) goto L_0x0080
            goto L_0x006d
        L_0x0080:
            java.lang.String r7 = "uri.getQueryParameter(key) ?: return@forEach"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r11.getQueryParameter(r7)
            if (r7 == 0) goto L_0x0112
            int r8 = r7.hashCode()
            switch(r8) {
                case 48: goto L_0x00fa;
                case 49: goto L_0x00e2;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00be;
                case 52: goto L_0x00ad;
                case 53: goto L_0x00a3;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            goto L_0x0112
        L_0x00a3:
            java.lang.String r8 = "5"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x006d
            goto L_0x0112
        L_0x00ad:
            java.lang.String r8 = "4"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00b6
            goto L_0x0112
        L_0x00b6:
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            r0.withBoolean(r3, r4)
            goto L_0x006d
        L_0x00be:
            java.lang.String r8 = "3"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00c7
            goto L_0x0112
        L_0x00c7:
            r0.withString(r3, r4)
            goto L_0x006d
        L_0x00cb:
            java.lang.String r8 = "2"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00d4
            goto L_0x0112
        L_0x00d4:
            java.lang.Long r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4)
            if (r4 == 0) goto L_0x006d
            long r7 = r4.longValue()
            r0.withLong(r3, r7)
            goto L_0x006d
        L_0x00e2:
            java.lang.String r8 = "1"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00eb
            goto L_0x0112
        L_0x00eb:
            java.lang.Float r4 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r4)
            if (r4 == 0) goto L_0x006d
            float r4 = r4.floatValue()
            r0.withFloat(r3, r4)
            goto L_0x006d
        L_0x00fa:
            java.lang.String r8 = "0"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0103
            goto L_0x0112
        L_0x0103:
            java.lang.Integer r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4)
            if (r4 == 0) goto L_0x006d
            int r4 = r4.intValue()
            r0.withInt(r3, r4)
            goto L_0x006d
        L_0x0112:
            int r7 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x011f }
            com.alibaba.android.arouter.facade.Postcard r7 = r0.withInt(r3, r7)     // Catch:{ all -> 0x011f }
            com.mars.kotlin.extension.fp.Either$Right r7 = com.mars.kotlin.extension.ExpectKt.success(r7)     // Catch:{ all -> 0x011f }
            goto L_0x0127
        L_0x011f:
            r7 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r7, r6, r2, r6)
            com.mars.kotlin.extension.fp.Either$Left r7 = com.mars.kotlin.extension.ExpectKt.failure(r7)
        L_0x0127:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r8 == 0) goto L_0x013e
            com.mars.kotlin.extension.fp.Either$Left r7 = (com.mars.kotlin.extension.fp.Either.Left) r7
            java.lang.Object r7 = r7.getValue()
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            com.alibaba.android.arouter.facade.Postcard r3 = r0.withString(r3, r4)
            com.mars.kotlin.extension.fp.Either$Left r4 = new com.mars.kotlin.extension.fp.Either$Left
            r4.<init>(r3)
            goto L_0x006d
        L_0x013e:
            boolean r3 = r7 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r3 == 0) goto L_0x0144
            goto L_0x006d
        L_0x0144:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x014a:
            if (r14 == 0) goto L_0x0154
            java.lang.String r11 = "this"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)
            r14.invoke(r0)
        L_0x0154:
            if (r13 == 0) goto L_0x015d
            int r11 = r13.intValue()
            r0.withFlags(r11)
        L_0x015d:
            if (r12 != 0) goto L_0x0163
            r0.navigation()
        L_0x0162:
            return
        L_0x0163:
            r12.qw()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.th.qw.fe.ad.de(java.lang.String, fe.mmm.qw.th.qw.fe.qw, java.lang.Integer, kotlin.jvm.functions.Function1):void");
    }

    public final boolean qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return StringsKt__StringsJVMKt.startsWith$default(str, "aiscan://router", false, 2, (Object) null);
    }
}
