package fe.mmm.qw.tt.ad.ddd;

import android.view.View;
import com.tera.scan.scanner.ocr.qrscan.OcrScannerControl;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OcrScannerControl f8393ad;

    public /* synthetic */ qw(OcrScannerControl ocrScannerControl) {
        this.f8393ad = ocrScannerControl;
    }

    public final void onClick(View view) {
        OcrScannerControl.nn(this.f8393ad, view);
    }
}
