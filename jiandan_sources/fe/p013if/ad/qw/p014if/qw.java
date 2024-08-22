package fe.p013if.ad.qw.p014if;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* renamed from: fe.if.ad.qw.if.qw  reason: invalid package */
public class qw implements DocumentSource {
    public final String qw;

    public qw(String str) {
        this.qw = str;
    }

    public PdfDocument qw(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(ParcelFileDescriptor.open(fe.p013if.ad.qw.p015switch.qw.ad(context, this.qw), 268435456), str);
    }
}
