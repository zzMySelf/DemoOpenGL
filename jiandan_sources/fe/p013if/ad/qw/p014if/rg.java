package fe.p013if.ad.qw.p014if;

import android.content.Context;
import android.net.Uri;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* renamed from: fe.if.ad.qw.if.rg  reason: invalid package */
public class rg implements DocumentSource {
    public Uri qw;

    public rg(Uri uri) {
        this.qw = uri;
    }

    public PdfDocument qw(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(context.getContentResolver().openFileDescriptor(this.qw, "r"), str);
    }
}
