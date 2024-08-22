package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.callback.IImageCropResult;
import com.tera.scan.scanner.ocr.control.OCRToPDFControl;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class qw implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRToPDFControl f8454ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ CropInfo f8455de;
    public final /* synthetic */ Function2 qw;

    public /* synthetic */ qw(Function2 function2, OCRToPDFControl oCRToPDFControl, CropInfo cropInfo) {
        this.qw = function2;
        this.f8454ad = oCRToPDFControl;
        this.f8455de = cropInfo;
    }

    public final void onResult(String str) {
        OCRToPDFControl.e(this.qw, this.f8454ad, this.f8455de, str);
    }
}
