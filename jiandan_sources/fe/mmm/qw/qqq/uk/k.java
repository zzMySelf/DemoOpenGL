package fe.mmm.qw.qqq.uk;

import android.view.View;
import com.tera.scan.pdfedit.ui.PDFMergeKt;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;

/* compiled from: lambda */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PdfSplitActivity f8234ad;

    public /* synthetic */ k(PdfSplitActivity pdfSplitActivity) {
        this.f8234ad = pdfSplitActivity;
    }

    public final void onClick(View view) {
        PDFMergeKt.i(this.f8234ad, view);
    }
}
