package fe.mmm.qw.tt.ad.when;

import com.tera.scan.scanner.ocr.control.PhotoToWordControl;

/* compiled from: lambda */
public final /* synthetic */ class tt implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PhotoToWordControl f8459ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f8460th;

    public /* synthetic */ tt(PhotoToWordControl photoToWordControl, String str) {
        this.f8459ad = photoToWordControl;
        this.f8460th = str;
    }

    public final void run() {
        PhotoToWordControl.B(this.f8459ad, this.f8460th);
    }
}
