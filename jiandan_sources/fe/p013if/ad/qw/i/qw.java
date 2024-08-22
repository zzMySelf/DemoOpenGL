package fe.p013if.ad.qw.i;

import android.content.Intent;
import android.net.Uri;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.link.LinkHandler;

/* renamed from: fe.if.ad.qw.i.qw  reason: invalid package */
public class qw implements LinkHandler {
    public PDFView qw;

    public qw(PDFView pDFView) {
        this.qw = pDFView;
    }

    public final void ad(int i2) {
        this.qw.jumpTo(i2);
    }

    public final void de(String str) {
        try {
            this.qw.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            "No activity found for URI: " + str + " error : " + e.getMessage();
        }
    }

    public void qw(fe.p013if.ad.qw.pf.qw qwVar) {
        String uri = qwVar.qw().getUri();
        Integer destPageIdx = qwVar.qw().getDestPageIdx();
        if (uri != null && !uri.isEmpty()) {
            de(uri);
        } else if (destPageIdx != null) {
            ad(destPageIdx.intValue());
        }
    }
}
