package fe.mmm.qw.tt.ad;

import android.graphics.Bitmap;
import com.otaliastudios.cameraview.BitmapCallback;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ocr.control.OCRAutoScanControl;

/* compiled from: lambda */
public final /* synthetic */ class ad implements BitmapCallback {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRAutoScanControl f8390ad;
    public final /* synthetic */ OCRTakePhotoActivity qw;

    public /* synthetic */ ad(OCRTakePhotoActivity oCRTakePhotoActivity, OCRAutoScanControl oCRAutoScanControl) {
        this.qw = oCRTakePhotoActivity;
        this.f8390ad = oCRAutoScanControl;
    }

    public final void qw(Bitmap bitmap) {
        OCRTakePhotoActivity.m894callBackBitmap$lambda14(this.qw, this.f8390ad, bitmap);
    }
}
