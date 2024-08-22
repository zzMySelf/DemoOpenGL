package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsTakingControl$takePhotoViewModel$2 extends Lambda implements Function0<OCRTakePhotoViewModel> {
    public final /* synthetic */ ScanIdCardsTakingControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsTakingControl$takePhotoViewModel$2(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        super(0);
        this.this$0 = scanIdCardsTakingControl;
    }

    @Nullable
    public final OCRTakePhotoViewModel invoke() {
        Activity ggg = this.this$0.ggg();
        ViewModelStoreOwner viewModelStoreOwner = ggg instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) ggg : null;
        if (viewModelStoreOwner != null) {
            return (OCRTakePhotoViewModel) new ViewModelProvider(viewModelStoreOwner).get(OCRTakePhotoViewModel.class);
        }
        return null;
    }
}
