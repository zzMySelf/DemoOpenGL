package fe.mmm.qw.tt.ad.when;

import com.tera.scan.scanner.ocr.control.OCRRemoveWatermarkControl;

/* compiled from: lambda */
public final /* synthetic */ class vvv implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRRemoveWatermarkControl f8462ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f8463th;

    public /* synthetic */ vvv(OCRRemoveWatermarkControl oCRRemoveWatermarkControl, String str) {
        this.f8462ad = oCRRemoveWatermarkControl;
        this.f8463th = str;
    }

    public final void run() {
        OCRRemoveWatermarkControl.G(this.f8462ad, this.f8463th);
    }
}
