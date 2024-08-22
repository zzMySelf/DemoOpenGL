package fe.when.ad;

import com.itextpdf.text.BadElementException;
import fe.when.ad.c.qw;
import fe.when.ad.f.n2.yj;
import java.net.URL;

public class o extends i {
    public o(int i2, int i3, boolean z, int i4, int i5, byte[] bArr) throws BadElementException {
        super((URL) null);
        if (i4 == 256 || i4 == 257 || i4 == 258) {
            if (z) {
                yj.m1107if(bArr);
            }
            this.qqq = 34;
            float f = (float) i3;
            this.n = f;
            n(f);
            float f2 = (float) i2;
            this.m = f2;
            l(f2);
            this.N = i5;
            this.tt = i4;
            this.rrr = bArr;
            this.k = rrr();
            this.l = ggg();
            return;
        }
        throw new BadElementException(qw.ad("the.ccitt.compression.type.must.be.ccittg4.ccittg3.1d.or.ccittg3.2d", new Object[0]));
    }
}
