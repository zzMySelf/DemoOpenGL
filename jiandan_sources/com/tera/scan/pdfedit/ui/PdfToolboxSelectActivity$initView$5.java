package com.tera.scan.pdfedit.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PdfToolboxSelectActivity$initView$5 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public PdfToolboxSelectActivity$initView$5(Object obj) {
        super(1, obj, PdfToolboxSelectActivity.class, "onItemClick", "onItemClick(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        ((PdfToolboxSelectActivity) this.receiver).onItemClick(i2);
    }
}
