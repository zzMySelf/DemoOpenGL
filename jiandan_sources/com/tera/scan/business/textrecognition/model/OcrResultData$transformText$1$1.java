package com.tera.scan.business.textrecognition.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "item", "Lcom/tera/scan/business/textrecognition/model/OcrParagraphItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OcrResultData$transformText$1$1 extends Lambda implements Function1<OcrParagraphItem, List<? extends Integer>> {
    public static final OcrResultData$transformText$1$1 INSTANCE = new OcrResultData$transformText$1$1();

    public OcrResultData$transformText$1$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r2 = r2.getIdx();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Integer> invoke(@org.jetbrains.annotations.NotNull com.tera.scan.business.textrecognition.model.OcrParagraphItem r2) {
        /*
            r1 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.tera.scan.business.textrecognition.model.OcrParaIdx r2 = r2.getParaIdx()
            if (r2 == 0) goto L_0x0011
            java.util.List r2 = r2.getIdx()
            if (r2 != 0) goto L_0x0015
        L_0x0011:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.textrecognition.model.OcrResultData$transformText$1$1.invoke(com.tera.scan.business.textrecognition.model.OcrParagraphItem):java.util.List");
    }
}
