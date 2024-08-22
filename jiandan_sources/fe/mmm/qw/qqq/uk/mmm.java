package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;
import kotlin.Pair;

/* compiled from: lambda */
public final /* synthetic */ class mmm implements Observer {
    public final /* synthetic */ PdfSplitActivity qw;

    public /* synthetic */ mmm(PdfSplitActivity pdfSplitActivity) {
        this.qw = pdfSplitActivity;
    }

    public final void onChanged(Object obj) {
        PdfSplitActivity.m867initData$lambda3(this.qw, (Pair) obj);
    }
}
