package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfMergeAddActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class ddd implements Observer {
    public final /* synthetic */ PdfMergeAddActivity qw;

    public /* synthetic */ ddd(PdfMergeAddActivity pdfMergeAddActivity) {
        this.qw = pdfMergeAddActivity;
    }

    public final void onChanged(Object obj) {
        PdfMergeAddActivity.m852initData$lambda5(this.qw, (List) obj);
    }
}
