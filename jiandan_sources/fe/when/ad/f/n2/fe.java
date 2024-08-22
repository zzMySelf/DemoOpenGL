package fe.when.ad.f.n2;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import fe.when.ad.f.e2;
import fe.when.ad.f.n2.rg;
import fe.when.ad.i;
import fe.when.ad.pf;

public class fe {
    public static i qw(e2 e2Var, int i2) {
        if (i2 >= 1) {
            try {
                rg rgVar = new rg(e2Var);
                rgVar.rg();
                rg.qw de2 = rgVar.de(i2);
                return new pf(de2.f9638ad, de2.f9639de, de2.ad(true), rgVar.ad(true));
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new IllegalArgumentException(qw.ad("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
    }
}
