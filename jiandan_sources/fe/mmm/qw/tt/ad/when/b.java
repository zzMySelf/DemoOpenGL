package fe.mmm.qw.tt.ad.when;

import com.tera.scan.scanner.ocr.control.OCRToPDFControl;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRToPDFControl f8436ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f8437th;

    public /* synthetic */ b(OCRToPDFControl oCRToPDFControl, String str) {
        this.f8436ad = oCRToPDFControl;
        this.f8437th = str;
    }

    public final void run() {
        OCRToPDFControl.H(this.f8436ad, this.f8437th);
    }
}
