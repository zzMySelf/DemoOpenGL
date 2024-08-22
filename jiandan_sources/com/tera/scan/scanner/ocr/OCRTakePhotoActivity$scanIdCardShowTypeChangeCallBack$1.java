package com.tera.scan.scanner.ocr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guideType", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$scanIdCardShowTypeChangeCallBack$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ OCRTakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoActivity$scanIdCardShowTypeChangeCallBack$1(OCRTakePhotoActivity oCRTakePhotoActivity) {
        super(1);
        this.this$0 = oCRTakePhotoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            OCRTakePhotoActivity.exitTakingModeWithConfirm$default(this.this$0, false, AnonymousClass1.INSTANCE, 1, (Object) null);
        } else {
            this.this$0.enterTakingMode();
        }
        this.this$0.refreshTitleBar();
    }
}
