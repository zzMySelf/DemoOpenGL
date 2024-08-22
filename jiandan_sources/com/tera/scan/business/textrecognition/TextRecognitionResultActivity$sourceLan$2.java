package com.tera.scan.business.textrecognition;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$sourceLan$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$sourceLan$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.this$0 = textRecognitionResultActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getStringExtra(com.tera.scan.business.textrecognition.TextRecognitionResultActivity.KEY_SOURCE_LAN);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke() {
        /*
            r2 = this;
            com.tera.scan.business.textrecognition.TextRecognitionResultActivity r0 = r2.this$0
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0010
            java.lang.String r1 = "KEY_SOURCE_LAN"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = ""
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.textrecognition.TextRecognitionResultActivity$sourceLan$2.invoke():java.lang.String");
    }
}
