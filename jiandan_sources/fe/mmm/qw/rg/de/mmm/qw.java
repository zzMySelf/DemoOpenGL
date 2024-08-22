package fe.mmm.qw.rg.de.mmm;

import com.tera.scan.flutter.route.IPageHandler;

public final class qw implements IPageHandler {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: android.content.Intent} */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean qw(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> r12, int r13) {
        /*
            r9 = this;
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            java.lang.String r2 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "native://"
            r8 = 0
            r3 = 2
            r4 = 0
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r11, r2, r8, r3, r4)
            if (r2 != 0) goto L_0x001b
            return r8
        L_0x001b:
            java.lang.String r2 = "native://textRecognition"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            java.lang.String r3 = "path"
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.String"
            if (r2 == 0) goto L_0x006b
            java.lang.Object r0 = r12.get(r3)
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "from"
            java.lang.Object r2 = r12.get(r2)
            if (r2 == 0) goto L_0x005f
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r2 = "ubcSource"
            java.lang.Object r1 = r12.get(r2)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0047
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
        L_0x0047:
            if (r4 != 0) goto L_0x004d
            java.lang.String r1 = ""
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r4
        L_0x004e:
            com.tera.scan.business.textrecognition.TextRecognitionActivity$qw r1 = com.tera.scan.business.textrecognition.TextRecognitionActivity.Companion
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0)
            r4 = 0
            r6 = 8
            r7 = 0
            r0 = r1
            r1 = r10
            android.content.Intent r4 = com.tera.scan.business.textrecognition.TextRecognitionActivity.qw.ad(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0088
        L_0x005f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x0065:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x006b:
            java.lang.String r2 = "native://documentPreviewPage"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r12.get(r3)
            if (r0 == 0) goto L_0x0082
            java.lang.String r0 = (java.lang.String) r0
            com.tera.scan.business.textrecognition.PreViewActivity$qw r1 = com.tera.scan.business.textrecognition.PreViewActivity.Companion
            android.content.Intent r4 = r1.qw(r10, r0)
            goto L_0x0088
        L_0x0082:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x0088:
            if (r4 == 0) goto L_0x0099
            boolean r0 = r10 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0095
            r0 = r10
            android.app.Activity r0 = (android.app.Activity) r0
            r0.startActivityForResult(r4, r13)
            goto L_0x0098
        L_0x0095:
            r10.startActivity(r4)
        L_0x0098:
            r8 = 1
        L_0x0099:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rg.de.mmm.qw.qw(android.content.Context, java.lang.String, java.util.Map, int):boolean");
    }
}
