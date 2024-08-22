package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.callback.IImageCropResult;
import com.tera.scan.scanner.ocr.control.PhotoToWordControl;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class ad implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PhotoToWordControl f8434ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ CropInfo f8435de;
    public final /* synthetic */ Function2 qw;

    public /* synthetic */ ad(Function2 function2, PhotoToWordControl photoToWordControl, CropInfo cropInfo) {
        this.qw = function2;
        this.f8434ad = photoToWordControl;
        this.f8435de = cropInfo;
    }

    public final void onResult(String str) {
        PhotoToWordControl.l(this.qw, this.f8434ad, this.f8435de, str);
    }
}
