package fe.mmm.qw.tt.ad.when;

import androidx.lifecycle.Observer;
import com.tera.scan.scanner.ocr.control.TakeSingleOrMultipleView;

/* compiled from: lambda */
public final /* synthetic */ class fe implements Observer {
    public final /* synthetic */ TakeSingleOrMultipleView qw;

    public /* synthetic */ fe(TakeSingleOrMultipleView takeSingleOrMultipleView) {
        this.qw = takeSingleOrMultipleView;
    }

    public final void onChanged(Object obj) {
        TakeSingleOrMultipleView.uk(this.qw, (Boolean) obj);
    }
}
