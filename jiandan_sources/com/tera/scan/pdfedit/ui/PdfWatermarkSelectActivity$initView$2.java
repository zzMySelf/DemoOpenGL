package com.tera.scan.pdfedit.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class PdfWatermarkSelectActivity$initView$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public PdfWatermarkSelectActivity$initView$2(Object obj) {
        super(1, obj, PdfWatermarkSelectActivity.class, "onItemClick", "onItemClick(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ((PdfWatermarkSelectActivity) this.receiver).onItemClick(str);
    }
}
