package fe.mmm.qw.tt.ad.when;

import com.tera.scan.scanner.ocr.control.OCRToPaperRemoveHandWrittenControl;

/* compiled from: lambda */
public final /* synthetic */ class yj implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRToPaperRemoveHandWrittenControl f8465ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f8466th;

    public /* synthetic */ yj(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, String str) {
        this.f8465ad = oCRToPaperRemoveHandWrittenControl;
        this.f8466th = str;
    }

    public final void run() {
        OCRToPaperRemoveHandWrittenControl.C(this.f8465ad, this.f8466th);
    }
}
