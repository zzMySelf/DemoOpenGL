package com.tera.scan.business.textrecognition;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionActivity$imagePathList$2 extends Lambda implements Function0<List<String>> {
    public final /* synthetic */ TextRecognitionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionActivity$imagePathList$2(TextRecognitionActivity textRecognitionActivity) {
        super(0);
        this.this$0 = textRecognitionActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) (r3 = r1.getStringExtra(com.tera.scan.business.textrecognition.TextRecognitionActivity.KEY_IMAGE_URI_LIST)), new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> invoke() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.tera.scan.business.textrecognition.TextRecognitionActivity r1 = r9.this$0
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L_0x002a
            java.lang.String r2 = "KEY_IMAGE_URI_LIST"
            java.lang.String r3 = r1.getStringExtra(r2)
            if (r3 == 0) goto L_0x002a
            java.lang.String r1 = ","
            java.lang.String[] r4 = new java.lang.String[]{r1}
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r3, (java.lang.String[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            if (r1 == 0) goto L_0x002a
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            if (r1 == 0) goto L_0x0036
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = 0
            goto L_0x0037
        L_0x0036:
            r2 = 1
        L_0x0037:
            if (r2 != 0) goto L_0x003c
            r0.addAll(r1)
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.textrecognition.TextRecognitionActivity$imagePathList$2.invoke():java.util.List");
    }
}
