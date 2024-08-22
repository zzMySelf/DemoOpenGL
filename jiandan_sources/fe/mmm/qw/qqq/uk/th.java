package fe.mmm.qw.qqq.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.pdfedit.ui.PdfWatermarkSelectActivity;
import kotlin.Pair;

/* compiled from: lambda */
public final /* synthetic */ class th implements Observer {
    public final /* synthetic */ PdfWatermarkSelectActivity qw;

    public /* synthetic */ th(PdfWatermarkSelectActivity pdfWatermarkSelectActivity) {
        this.qw = pdfWatermarkSelectActivity;
    }

    public final void onChanged(Object obj) {
        PdfWatermarkSelectActivity.m883initData$lambda3(this.qw, (Pair) obj);
    }
}
