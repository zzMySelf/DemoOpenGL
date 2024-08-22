package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfMergeAdjustFileActivity;
import java.util.ArrayList;

/* compiled from: lambda */
public final /* synthetic */ class o implements Observer {
    public final /* synthetic */ PdfMergeAdjustFileActivity qw;

    public /* synthetic */ o(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        this.qw = pdfMergeAdjustFileActivity;
    }

    public final void onChanged(Object obj) {
        PdfMergeAdjustFileActivity.m857initData$lambda4(this.qw, (ArrayList) obj);
    }
}
