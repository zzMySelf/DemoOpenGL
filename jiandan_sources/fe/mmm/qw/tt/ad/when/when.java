package fe.mmm.qw.tt.ad.when;

import androidx.lifecycle.Observer;
import com.tera.scan.scanner.ocr.control.TakeSingleOrMultipleView;
import fe.mmm.qw.tt.ad.i;

/* compiled from: lambda */
public final /* synthetic */ class when implements Observer {
    public final /* synthetic */ TakeSingleOrMultipleView qw;

    public /* synthetic */ when(TakeSingleOrMultipleView takeSingleOrMultipleView) {
        this.qw = takeSingleOrMultipleView;
    }

    public final void onChanged(Object obj) {
        TakeSingleOrMultipleView.i(this.qw, (i) obj);
    }
}
