package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfToolboxSelectActivity;

/* compiled from: lambda */
public final /* synthetic */ class uk implements Observer {
    public final /* synthetic */ PdfToolboxSelectActivity qw;

    public /* synthetic */ uk(PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        this.qw = pdfToolboxSelectActivity;
    }

    public final void onChanged(Object obj) {
        PdfToolboxSelectActivity.m873initData$lambda5(this.qw, (Boolean) obj);
    }
}
