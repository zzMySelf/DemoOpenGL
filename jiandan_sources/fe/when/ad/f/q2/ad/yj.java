package fe.when.ad.f.q2.ad;

import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocation;
import fe.when.ad.c.qw;
import fe.when.ad.d.o;
import fe.when.ad.d.pf;
import fe.when.ad.f.e2;
import java.io.IOException;
import java.io.InputStream;

public class yj implements CidLocation {
    public PRTokeniser qw(String str) throws IOException {
        String str2 = "com/itextpdf/text/pdf/fonts/cmaps/" + str;
        InputStream qw = pf.qw(str2);
        if (qw != null) {
            return new PRTokeniser(new e2(new o().rg(qw)));
        }
        throw new IOException(qw.ad("the.cmap.1.was.not.found", str2));
    }
}
