package fe.mmm.qw.tt.ad.ddd;

import androidx.lifecycle.Observer;
import com.tera.scan.scanner.ocr.qrscan.OcrScannerControl;
import fe.mmm.qw.tt.ad.xxx.qw;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ OcrScannerControl qw;

    public /* synthetic */ ad(OcrScannerControl ocrScannerControl) {
        this.qw = ocrScannerControl;
    }

    public final void onChanged(Object obj) {
        OcrScannerControl.vvv(this.qw, (qw) obj);
    }
}
