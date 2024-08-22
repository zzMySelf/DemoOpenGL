package fe.mmm.qw.k.uk.de;

import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.p030switch.rg.qw;

public final class fe extends ad {
    public fe() {
        super(qw.qw().getBduss(), qw.qw().getUid(), new fe.mmm.qw.nn.qw.qw.fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(this.f8092rg));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mars.kotlin.extension.fp.Either<kotlin.Pair<java.lang.String, java.lang.Integer>, com.tera.scan.vip.network.model.ReportGooglePayTokenResponse> i(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, boolean r11) {
        /*
            r6 = this;
            java.lang.String r0 = "googleOrderId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "productId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r2 = "purchaseToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "https://"
            r3.append(r4)
            java.lang.String r4 = fe.mmm.qw.rg.ad.ad.fe()
            r3.append(r4)
            java.lang.String r4 = "/google/receiptUpload"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            fe.mmm.qw.nn.de.o.ad r4 = new fe.mmm.qw.nn.de.o.ad
            r4.<init>()
            java.lang.String r5 = "orderId"
            r4.ad(r5, r7)
            r4.ad(r0, r8)
            r4.ad(r1, r9)
            r4.ad(r2, r10)
            java.lang.String r7 = java.lang.String.valueOf(r11)
            java.lang.String r8 = "isSub"
            r4.ad(r8, r7)
            r7 = 1
            fe.mmm.qw.nn.qw.qw.uk r8 = new fe.mmm.qw.nn.qw.qw.uk     // Catch:{ all -> 0x008e }
            r8.<init>()     // Catch:{ all -> 0x008e }
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x008e }
            fe.mmm.qw.nn.de.o.de[] r10 = new fe.mmm.qw.nn.de.o.de[r7]     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r11.<init>()     // Catch:{ all -> 0x008e }
            r11.append(r3)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "?app_key=SRH8TW"
            r11.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x008e }
            fe.mmm.qw.nn.de.o.de[] r11 = r6.de(r11, r4)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "buildPostRequest(\"$url?app_key=$APP_KEY\", params)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ all -> 0x008e }
            r0 = 0
            java.lang.Object r11 = kotlin.collections.ArraysKt___ArraysKt.getOrNull((T[]) r11, (int) r0)     // Catch:{ all -> 0x008e }
            fe.mmm.qw.nn.de.o.de r11 = (fe.mmm.qw.nn.de.o.de) r11     // Catch:{ all -> 0x008e }
            r10[r0] = r11     // Catch:{ all -> 0x008e }
            r9[r0] = r10     // Catch:{ all -> 0x008e }
            fe.mmm.qw.nn.qw.qw.pf.qw r10 = new fe.mmm.qw.nn.qw.qw.pf.qw     // Catch:{ all -> 0x008e }
            java.lang.Class<com.tera.scan.vip.network.model.ReportGooglePayTokenResponse> r11 = com.tera.scan.vip.network.model.ReportGooglePayTokenResponse.class
            r10.<init>(r11)     // Catch:{ all -> 0x008e }
            r9[r7] = r10     // Catch:{ all -> 0x008e }
            java.lang.Object r8 = r8.qw(r9)     // Catch:{ all -> 0x008e }
            com.tera.scan.vip.network.model.ReportGooglePayTokenResponse r8 = (com.tera.scan.vip.network.model.ReportGooglePayTokenResponse) r8     // Catch:{ all -> 0x008e }
            com.mars.kotlin.extension.fp.Either$Right r7 = com.mars.kotlin.extension.ExpectKt.success(r8)     // Catch:{ all -> 0x008e }
            goto L_0x0097
        L_0x008e:
            r8 = move-exception
            r9 = 0
            com.mars.kotlin.extension.LoggerKt.e$default(r8, r9, r7, r9)
            com.mars.kotlin.extension.fp.Either$Left r7 = com.mars.kotlin.extension.ExpectKt.failure(r8)
        L_0x0097:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r8 == 0) goto L_0x00d4
            com.mars.kotlin.extension.fp.Either$Left r7 = (com.mars.kotlin.extension.fp.Either.Left) r7
            java.lang.Object r7 = r7.getValue()
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r8 = r7 instanceof com.tera.scan.network.network.exception.RemoteException
            if (r8 == 0) goto L_0x00b6
            com.tera.scan.network.network.exception.RemoteException r7 = (com.tera.scan.network.network.exception.RemoteException) r7
            int r8 = r7.getErrorCode()
            java.lang.String r7 = r7.getErrorMessage()
            com.mars.kotlin.extension.fp.Either$Left r7 = fe.mmm.qw.nn.de.i.qw.de(r8, r7)
            goto L_0x00c9
        L_0x00b6:
            boolean r7 = r7 instanceof com.google.gson.JsonParseException
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x00c3
            r7 = -105(0xffffffffffffff97, float:NaN)
            com.mars.kotlin.extension.fp.Either$Left r7 = fe.mmm.qw.nn.de.i.qw.de(r7, r8)
            goto L_0x00c9
        L_0x00c3:
            r7 = -104(0xffffffffffffff98, float:NaN)
            com.mars.kotlin.extension.fp.Either$Left r7 = fe.mmm.qw.nn.de.i.qw.de(r7, r8)
        L_0x00c9:
            kotlin.Pair r7 = fe.mmm.qw.nn.de.i.qw.qw(r7)
            com.mars.kotlin.extension.fp.Either$Left r8 = new com.mars.kotlin.extension.fp.Either$Left
            r8.<init>(r7)
            r7 = r8
            goto L_0x00d8
        L_0x00d4:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r8 == 0) goto L_0x0116
        L_0x00d8:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r8 == 0) goto L_0x00e7
            com.mars.kotlin.extension.fp.Either$Right r7 = (com.mars.kotlin.extension.fp.Either.Right) r7
            java.lang.Object r7 = r7.getValue()
            com.mars.kotlin.extension.fp.Either$Right r7 = com.mars.kotlin.extension.ExpectKt.success(r7)
            goto L_0x00eb
        L_0x00e7:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r8 == 0) goto L_0x0110
        L_0x00eb:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r8 == 0) goto L_0x0105
            com.mars.kotlin.extension.fp.Either$Right r7 = (com.mars.kotlin.extension.fp.Either.Right) r7
            java.lang.Object r7 = r7.getValue()
            com.tera.scan.vip.network.model.ReportGooglePayTokenResponse r7 = (com.tera.scan.vip.network.model.ReportGooglePayTokenResponse) r7
            if (r7 != 0) goto L_0x00fe
            com.mars.kotlin.extension.fp.Either$Left r7 = fe.mmm.qw.nn.de.i.qw.ad()
            goto L_0x0109
        L_0x00fe:
            com.mars.kotlin.extension.fp.Either$Right r8 = new com.mars.kotlin.extension.fp.Either$Right
            r8.<init>(r7)
            r7 = r8
            goto L_0x0109
        L_0x0105:
            boolean r8 = r7 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r8 == 0) goto L_0x010a
        L_0x0109:
            return r7
        L_0x010a:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0110:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0116:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.k.uk.de.fe.i(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):com.mars.kotlin.extension.fp.Either");
    }
}
