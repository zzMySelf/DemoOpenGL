package com.tera.scan.scanner.ocr.qrscan;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/scanner/ocr/qrscan/QrScanViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OcrScannerControl$viewModel$2 extends Lambda implements Function0<QrScanViewModel> {
    public final /* synthetic */ OcrScannerControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OcrScannerControl$viewModel$2(OcrScannerControl ocrScannerControl) {
        super(0);
        this.this$0 = ocrScannerControl;
    }

    @NotNull
    public final QrScanViewModel invoke() {
        return (QrScanViewModel) new ViewModelProvider(this.this$0.qw).get(QrScanViewModel.class);
    }
}
