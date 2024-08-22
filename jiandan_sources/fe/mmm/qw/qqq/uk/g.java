package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfWatermarkSelectActivity;
import java.util.ArrayList;

/* compiled from: lambda */
public final /* synthetic */ class g implements Observer {
    public final /* synthetic */ PdfWatermarkSelectActivity qw;

    public /* synthetic */ g(PdfWatermarkSelectActivity pdfWatermarkSelectActivity) {
        this.qw = pdfWatermarkSelectActivity;
    }

    public final void onChanged(Object obj) {
        PdfWatermarkSelectActivity.m882initData$lambda2(this.qw, (ArrayList) obj);
    }
}
