package com.tera.scan.pdfedit.ui;

import com.mars.kotlin.extension.IntentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/IntentScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAddActivity$initView$3$1 extends Lambda implements Function1<IntentScope, Unit> {
    public final /* synthetic */ PdfMergeAddActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAddActivity$initView$3$1(PdfMergeAddActivity pdfMergeAddActivity) {
        super(1);
        this.this$0 = pdfMergeAddActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntentScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntentScope intentScope) {
        Intrinsics.checkNotNullParameter(intentScope, "$this$Intent");
        intentScope.minus("extra_select_pdf_items", this.this$0.getImportViewModel().getSelectPdfItems());
    }
}
