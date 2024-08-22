package fe.mmm.qw.tt.ad.when;

import com.tera.scan.scanner.ocr.control.OCRAutoScanControl;
import com.tera.scan.scanner.ui.cameranew.AutoScanRectView;
import java.util.ArrayList;

/* compiled from: lambda */
public final /* synthetic */ class eee implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ AutoScanRectView f8442ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ ArrayList f8443th;

    public /* synthetic */ eee(AutoScanRectView autoScanRectView, ArrayList arrayList) {
        this.f8442ad = autoScanRectView;
        this.f8443th = arrayList;
    }

    public final void run() {
        OCRAutoScanControl.qw.ad(this.f8442ad, this.f8443th);
    }
}
