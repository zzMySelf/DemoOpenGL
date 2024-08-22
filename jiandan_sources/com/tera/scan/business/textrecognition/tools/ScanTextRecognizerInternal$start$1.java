package com.tera.scan.business.textrecognition.tools;

import com.tera.scan.business.textrecognition.model.OcrResultData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ocrResult", "Lcom/tera/scan/business/textrecognition/model/OcrResultData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanTextRecognizerInternal$start$1 extends Lambda implements Function1<OcrResultData, Unit> {
    public final /* synthetic */ Function1<List<String>, Unit> $resultCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanTextRecognizerInternal$start$1(Function1<? super List<String>, Unit> function1) {
        super(1);
        this.$resultCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OcrResultData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable OcrResultData ocrResultData) {
        List list;
        String transformText = ocrResultData != null ? ocrResultData.transformText() : null;
        Function1<List<String>, Unit> function1 = this.$resultCallback;
        if (transformText == null || transformText.length() == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = CollectionsKt__CollectionsJVMKt.listOf(transformText);
        }
        function1.invoke(list);
    }
}
