package com.tera.scan.scanner.ocr.control;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TakeSingleOrMultipleView$takePhotoViewModel$2 extends Lambda implements Function0<OCRTakePhotoViewModel> {
    public final /* synthetic */ TakeSingleOrMultipleView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TakeSingleOrMultipleView$takePhotoViewModel$2(TakeSingleOrMultipleView takeSingleOrMultipleView) {
        super(0);
        this.this$0 = takeSingleOrMultipleView;
    }

    @NotNull
    public final OCRTakePhotoViewModel invoke() {
        return (OCRTakePhotoViewModel) new ViewModelProvider(this.this$0.qw).get(OCRTakePhotoViewModel.class);
    }
}
