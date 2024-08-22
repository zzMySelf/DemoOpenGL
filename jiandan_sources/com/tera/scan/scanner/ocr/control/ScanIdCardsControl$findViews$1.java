package com.tera.scan.scanner.ocr.control;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "category", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsControl$findViews$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ ScanIdCardsControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsControl$findViews$1(ScanIdCardsControl scanIdCardsControl) {
        super(1);
        this.this$0 = scanIdCardsControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        ScanIdCardsTakingControl a = this.this$0.a();
        if (a != null) {
            a.n(i2);
        }
        this.this$0.f(false);
    }
}
