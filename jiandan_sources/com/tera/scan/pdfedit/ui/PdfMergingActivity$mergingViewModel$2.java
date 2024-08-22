package com.tera.scan.pdfedit.ui;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.pdfedit.viewmodel.PdfMergingViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/pdfedit/viewmodel/PdfMergingViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfMergingActivity$mergingViewModel$2 extends Lambda implements Function0<PdfMergingViewModel> {
    public final /* synthetic */ PdfMergingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergingActivity$mergingViewModel$2(PdfMergingActivity pdfMergingActivity) {
        super(0);
        this.this$0 = pdfMergingActivity;
    }

    @NotNull
    public final PdfMergingViewModel invoke() {
        return (PdfMergingViewModel) new ViewModelProvider(this.this$0).get(PdfMergingViewModel.class);
    }
}
