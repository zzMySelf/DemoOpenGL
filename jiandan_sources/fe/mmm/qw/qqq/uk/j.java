package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PDFMergeKt;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;

/* compiled from: lambda */
public final /* synthetic */ class j implements Observer {
    public final /* synthetic */ PdfSplitActivity qw;

    public /* synthetic */ j(PdfSplitActivity pdfSplitActivity) {
        this.qw = pdfSplitActivity;
    }

    public final void onChanged(Object obj) {
        PDFMergeKt.o(this.qw, (Boolean) obj);
    }
}
