package fe.p013if.ad.qw;

import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;

/* renamed from: fe.if.ad.qw.de  reason: invalid package */
public class de extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: ad  reason: collision with root package name */
    public WeakReference<PDFView> f4513ad;

    /* renamed from: de  reason: collision with root package name */
    public PdfiumCore f4514de;

    /* renamed from: fe  reason: collision with root package name */
    public String f4515fe;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public DocumentSource f4516rg;

    /* renamed from: th  reason: collision with root package name */
    public int[] f4517th;

    /* renamed from: yj  reason: collision with root package name */
    public th f4518yj;

    public de(DocumentSource documentSource, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f4516rg = documentSource;
        this.f4517th = iArr;
        this.f4513ad = new WeakReference<>(pDFView);
        this.f4515fe = str;
        this.f4514de = pdfiumCore;
    }

    public final Size ad(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* renamed from: de */
    public void onPostExecute(Throwable th2) {
        PDFView pDFView = (PDFView) this.f4513ad.get();
        if (pDFView == null) {
            return;
        }
        if (th2 != null) {
            pDFView.loadError(th2);
        } else if (!this.qw) {
            pDFView.loadComplete(this.f4518yj);
        }
    }

    public void onCancelled() {
        this.qw = true;
    }

    /* renamed from: qw */
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = (PDFView) this.f4513ad.get();
            if (pDFView == null) {
                return new NullPointerException("pdfView == null");
            }
            this.f4518yj = new th(this.f4514de, this.f4516rg.qw(pDFView.getContext(), this.f4514de, this.f4515fe), pDFView.getPageFitPolicy(), ad(pDFView), this.f4517th, pDFView.isSwipeVertical(), pDFView.getSpacingPx(), pDFView.isAutoSpacingEnabled(), pDFView.isFitEachPage());
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }
}
