package fe.mmm.qw.tt.ad;

import com.otaliastudios.cameraview.FileCallback;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import java.io.File;

/* compiled from: lambda */
public final /* synthetic */ class th implements FileCallback {
    public final /* synthetic */ OCRTakePhotoActivity qw;

    public /* synthetic */ th(OCRTakePhotoActivity oCRTakePhotoActivity) {
        this.qw = oCRTakePhotoActivity;
    }

    public final void qw(File file) {
        OCRTakePhotoActivity.m895callBackFile$lambda13(this.qw, file);
    }
}
