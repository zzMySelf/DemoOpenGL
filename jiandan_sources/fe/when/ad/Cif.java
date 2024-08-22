package fe.when.ad;

import com.itextpdf.text.BadElementException;
import fe.when.ad.c.qw;
import java.net.URL;

/* renamed from: fe.when.ad.if  reason: invalid class name */
public class Cif extends i {
    public Cif(int i2, int i3, int i4, int i5, byte[] bArr) throws BadElementException {
        super((URL) null);
        this.qqq = 34;
        float f = (float) i3;
        this.n = f;
        n(f);
        float f2 = (float) i2;
        this.m = f2;
        l(f2);
        if (i4 != 1 && i4 != 3 && i4 != 4) {
            throw new BadElementException(qw.ad("components.must.be.1.3.or.4", new Object[0]));
        } else if (i5 == 1 || i5 == 2 || i5 == 4 || i5 == 8) {
            this.N = i4;
            this.tt = i5;
            this.rrr = bArr;
            this.k = rrr();
            this.l = ggg();
        } else {
            throw new BadElementException(qw.ad("bits.per.component.must.be.1.2.4.or.8", new Object[0]));
        }
    }
}
