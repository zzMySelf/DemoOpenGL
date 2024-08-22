package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;
import fe.mmm.qw.qqq.o.rg;

/* compiled from: lambda */
public final /* synthetic */ class l implements Observer {
    public final /* synthetic */ PdfSplitActivity qw;

    public /* synthetic */ l(PdfSplitActivity pdfSplitActivity) {
        this.qw = pdfSplitActivity;
    }

    public final void onChanged(Object obj) {
        PdfSplitActivity.m870initData$lambda6(this.qw, (rg) obj);
    }
}
