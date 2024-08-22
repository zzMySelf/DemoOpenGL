package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;
import kotlin.Pair;

/* compiled from: lambda */
public final /* synthetic */ class tt implements Observer {
    public final /* synthetic */ PdfSplitActivity qw;

    public /* synthetic */ tt(PdfSplitActivity pdfSplitActivity) {
        this.qw = pdfSplitActivity;
    }

    public final void onChanged(Object obj) {
        PdfSplitActivity.m866initData$lambda2(this.qw, (Pair) obj);
    }
}
