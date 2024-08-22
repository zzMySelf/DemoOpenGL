package com.tera.scan.business.textrecognition.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "idxList", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OcrResultData$transformText$1$2 extends Lambda implements Function1<List<? extends Integer>, String> {
    public final /* synthetic */ OcrResultData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OcrResultData$transformText$1$2(OcrResultData ocrResultData) {
        super(1);
        this.this$0 = ocrResultData;
    }

    @NotNull
    public final String invoke(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "idxList");
        final OcrResultData ocrResultData = this.this$0;
        return CollectionsKt___CollectionsKt.joinToString$default(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Integer, CharSequence>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
                r2 = (r2 = (com.tera.scan.business.textrecognition.model.OcrCombineRetItem) kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r2)).getWord();
             */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.CharSequence invoke(int r2) {
                /*
                    r1 = this;
                    com.tera.scan.business.textrecognition.model.OcrResultData r0 = r0
                    java.util.List r0 = r0.getCombineRet()
                    if (r0 == 0) goto L_0x0017
                    java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r2)
                    com.tera.scan.business.textrecognition.model.OcrCombineRetItem r2 = (com.tera.scan.business.textrecognition.model.OcrCombineRetItem) r2
                    if (r2 == 0) goto L_0x0017
                    java.lang.String r2 = r2.getWord()
                    if (r2 == 0) goto L_0x0017
                    goto L_0x0019
                L_0x0017:
                    java.lang.String r2 = ""
                L_0x0019:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.textrecognition.model.OcrResultData$transformText$1$2.AnonymousClass1.invoke(int):java.lang.CharSequence");
            }
        }, 30, (Object) null);
    }
}
