package fe.p013if.ad.qw.p014if;

import android.content.Context;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: fe.if.ad.qw.if.fe  reason: invalid package */
public class fe implements DocumentSource {
    public InputStream qw;

    public fe(InputStream inputStream) {
        this.qw = inputStream;
    }

    public PdfDocument qw(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(fe.p013if.ad.qw.p015switch.fe.ad(this.qw), str);
    }
}
