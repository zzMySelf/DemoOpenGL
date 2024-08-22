package com.tera.scan.pdfedit.ui;

import com.tera.scan.pdfedit.adapter.PdfListMergeAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAdjustFileActivity$pdfMergeAdapter$2 extends Lambda implements Function0<PdfListMergeAdapter> {
    public final /* synthetic */ PdfMergeAdjustFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAdjustFileActivity$pdfMergeAdapter$2(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        super(0);
        this.this$0 = pdfMergeAdjustFileActivity;
    }

    @NotNull
    public final PdfListMergeAdapter invoke() {
        return new PdfListMergeAdapter(!PDFMergeKt.qw(this.this$0));
    }
}
