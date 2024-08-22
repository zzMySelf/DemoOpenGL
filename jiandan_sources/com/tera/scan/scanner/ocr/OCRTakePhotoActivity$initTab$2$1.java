package com.tera.scan.scanner.ocr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$initTab$2$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ OCRTakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoActivity$initTab$2$1(OCRTakePhotoActivity oCRTakePhotoActivity) {
        super(1);
        this.this$0 = oCRTakePhotoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        this.this$0.onItemClick(i2);
    }
}
