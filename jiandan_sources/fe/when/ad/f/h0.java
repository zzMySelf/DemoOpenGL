package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.PdfException;
import fe.when.ad.c.qw;

public class h0 extends v1 {
    public h0(mmm mmm, int i2) {
        try {
            int fe2 = mmm.fe();
            if (fe2 == 1) {
                h(s0.xxx, s0.v0);
            } else if (fe2 == 3) {
                h(s0.xxx, s0.w0);
            } else if (fe2 == 4) {
                h(s0.xxx, s0.x0);
            } else {
                throw new PdfException(qw.qw("1.component.s.is.not.supported", fe2));
            }
            h(s0.b3, new v0(fe2));
            byte[] qw = mmm.qw();
            this.f9852ad = qw;
            h(s0.F2, new v0(qw.length));
            l(i2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
