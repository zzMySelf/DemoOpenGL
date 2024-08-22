package com.tera.scan.pdfedit.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PdfSplitActivity$initView$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public PdfSplitActivity$initView$2(Object obj) {
        super(1, obj, PdfSplitActivity.class, "onItemSelect", "onItemSelect(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        ((PdfSplitActivity) this.receiver).onItemSelect(i2);
    }
}
