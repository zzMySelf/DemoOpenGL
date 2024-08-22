package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.callback.IImageCropResult;
import com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl;

/* compiled from: lambda */
public final /* synthetic */ class aaa implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f8432ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ CropInfo f8433de;
    public final /* synthetic */ ScanIdCardsTakingControl qw;

    public /* synthetic */ aaa(ScanIdCardsTakingControl scanIdCardsTakingControl, String str, CropInfo cropInfo) {
        this.qw = scanIdCardsTakingControl;
        this.f8432ad = str;
        this.f8433de = cropInfo;
    }

    public final void onResult(String str) {
        ScanIdCardsTakingControl.m(this.qw, this.f8432ad, this.f8433de, str);
    }
}
