package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfWatermarkCreateActivity;
import fe.mmm.qw.qqq.o.de;

/* compiled from: lambda */
public final /* synthetic */ class f implements Observer {
    public final /* synthetic */ PdfWatermarkCreateActivity qw;

    public /* synthetic */ f(PdfWatermarkCreateActivity pdfWatermarkCreateActivity) {
        this.qw = pdfWatermarkCreateActivity;
    }

    public final void onChanged(Object obj) {
        PdfWatermarkCreateActivity.m880initData$lambda2(this.qw, (de) obj);
    }
}
