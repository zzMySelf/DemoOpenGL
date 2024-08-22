package com.tera.scan.pdfedit.ui;

import com.tera.scan.pdfedit.ui.PdfMergingActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "fileName", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAdjustFileActivity$showRenameDialog$1$1 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ boolean $replaceOldDocFile;
    public final /* synthetic */ PdfMergeAdjustFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAdjustFileActivity$showRenameDialog$1$1(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, boolean z) {
        super(1);
        this.this$0 = pdfMergeAdjustFileActivity;
        this.$replaceOldDocFile = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        PdfMergingActivity.qw qwVar = PdfMergingActivity.Companion;
        PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity = this.this$0;
        qwVar.qw(pdfMergeAdjustFileActivity, pdfMergeAdjustFileActivity.getMergeViewModel().getPdfList(), this.$replaceOldDocFile, str);
    }
}
