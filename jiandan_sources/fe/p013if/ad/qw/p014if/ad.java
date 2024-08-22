package fe.p013if.ad.qw.p014if;

import android.content.Context;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* renamed from: fe.if.ad.qw.if.ad  reason: invalid package */
public class ad implements DocumentSource {
    public byte[] qw;

    public ad(byte[] bArr) {
        this.qw = bArr;
    }

    public PdfDocument qw(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(this.qw, str);
    }
}
