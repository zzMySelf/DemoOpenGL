package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.callback.IImageCropResult;
import com.tera.scan.scanner.ocr.control.OCRRemoveWatermarkControl;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class c implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRRemoveWatermarkControl f8438ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ CropInfo f8439de;
    public final /* synthetic */ Function2 qw;

    public /* synthetic */ c(Function2 function2, OCRRemoveWatermarkControl oCRRemoveWatermarkControl, CropInfo cropInfo) {
        this.qw = function2;
        this.f8438ad = oCRRemoveWatermarkControl;
        this.f8439de = cropInfo;
    }

    public final void onResult(String str) {
        OCRRemoveWatermarkControl.m(this.qw, this.f8438ad, this.f8439de, str);
    }
}
