package fe.mmm.qw.tt.ad.when;

import androidx.lifecycle.Observer;
import com.tera.scan.scanner.ocr.control.OCRAutoScanControl;

/* compiled from: lambda */
public final /* synthetic */ class rg implements Observer {
    public final /* synthetic */ OCRAutoScanControl qw;

    public /* synthetic */ rg(OCRAutoScanControl oCRAutoScanControl) {
        this.qw = oCRAutoScanControl;
    }

    public final void onChanged(Object obj) {
        OCRAutoScanControl.nn(this.qw, (Boolean) obj);
    }
}
