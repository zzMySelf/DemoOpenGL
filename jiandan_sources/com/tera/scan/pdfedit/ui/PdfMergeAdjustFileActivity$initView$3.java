package com.tera.scan.pdfedit.ui;

import fe.mmm.qw.qqq.rg.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PdfMergeAdjustFileActivity$initView$3 extends FunctionReferenceImpl implements Function2<Integer, qw, Unit> {
    public PdfMergeAdjustFileActivity$initView$3(Object obj) {
        super(2, obj, PdfMergeAdjustFileActivity.class, "onItemDeleteClick", "onItemDeleteClick(ILcom/tera/scan/pdfedit/data/MergePdfItemData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (qw) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, @NotNull qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "p1");
        ((PdfMergeAdjustFileActivity) this.receiver).onItemDeleteClick(i2, qwVar);
    }
}
