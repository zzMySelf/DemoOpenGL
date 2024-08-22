package com.tera.scan.pdfedit.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PdfMergeAddActivity$initView$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public PdfMergeAddActivity$initView$4(Object obj) {
        super(1, obj, PdfMergeAddActivity.class, "onItemClick", "onItemClick(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        ((PdfMergeAddActivity) this.receiver).onItemClick(i2);
    }
}
