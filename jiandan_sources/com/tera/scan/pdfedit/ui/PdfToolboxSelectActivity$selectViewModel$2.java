package com.tera.scan.pdfedit.ui;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.pdfedit.viewmodel.PdfToolboxSelectViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/pdfedit/viewmodel/PdfToolboxSelectViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfToolboxSelectActivity$selectViewModel$2 extends Lambda implements Function0<PdfToolboxSelectViewModel> {
    public final /* synthetic */ PdfToolboxSelectActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfToolboxSelectActivity$selectViewModel$2(PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        super(0);
        this.this$0 = pdfToolboxSelectActivity;
    }

    @NotNull
    public final PdfToolboxSelectViewModel invoke() {
        return (PdfToolboxSelectViewModel) new ViewModelProvider(this.this$0).get(PdfToolboxSelectViewModel.class);
    }
}
