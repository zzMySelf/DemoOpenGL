package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfToolboxSelectActivity;
import java.util.ArrayList;

/* compiled from: lambda */
public final /* synthetic */ class b implements Observer {
    public final /* synthetic */ PdfToolboxSelectActivity qw;

    public /* synthetic */ b(PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        this.qw = pdfToolboxSelectActivity;
    }

    public final void onChanged(Object obj) {
        PdfToolboxSelectActivity.m874initData$lambda7(this.qw, (ArrayList) obj);
    }
}
