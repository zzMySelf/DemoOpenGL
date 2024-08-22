package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.callback.IImageCropResult;
import com.tera.scan.scanner.ocr.control.OCRToPaperRemoveHandWrittenControl;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class ggg implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRToPaperRemoveHandWrittenControl f8444ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ CropInfo f8445de;
    public final /* synthetic */ Function2 qw;

    public /* synthetic */ ggg(Function2 function2, OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, CropInfo cropInfo) {
        this.qw = function2;
        this.f8444ad = oCRToPaperRemoveHandWrittenControl;
        this.f8445de = cropInfo;
    }

    public final void onResult(String str) {
        OCRToPaperRemoveHandWrittenControl.h(this.qw, this.f8444ad, this.f8445de, str);
    }
}
