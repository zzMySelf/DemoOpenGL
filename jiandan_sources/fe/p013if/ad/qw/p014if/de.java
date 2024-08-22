package fe.p013if.ad.qw.p014if;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;

/* renamed from: fe.if.ad.qw.if.de  reason: invalid package */
public class de implements DocumentSource {
    public File qw;

    public de(File file) {
        this.qw = file;
    }

    public PdfDocument qw(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(ParcelFileDescriptor.open(this.qw, 268435456), str);
    }
}
