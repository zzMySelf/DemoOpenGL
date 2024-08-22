package fe.when.ad.f.s2;

import com.itextpdf.text.pdf.interfaces.PdfVersion;
import fe.when.ad.f.a;
import fe.when.ad.f.c2;
import fe.when.ad.f.s0;
import fe.when.ad.f.x;
import fe.when.ad.rg;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class ad implements PdfVersion {

    /* renamed from: o  reason: collision with root package name */
    public static final byte[][] f9761o = {rg.rg(StringUtils.LF), rg.rg("%PDF-"), rg.rg("\n%âãÏÓ\n")};

    /* renamed from: ad  reason: collision with root package name */
    public boolean f9762ad = false;

    /* renamed from: i  reason: collision with root package name */
    public x f9763i = null;

    /* renamed from: th  reason: collision with root package name */
    public char f9764th = '4';

    /* renamed from: uk  reason: collision with root package name */
    public char f9765uk = '4';

    /* renamed from: yj  reason: collision with root package name */
    public s0 f9766yj = null;

    public char ad() {
        return this.f9765uk;
    }

    public byte[] de(char c) {
        return rg.rg(fe(c).toString().substring(1));
    }

    public s0 fe(char c) {
        switch (c) {
            case '2':
                return c2.T;
            case '3':
                return c2.U;
            case '4':
                return c2.V;
            case '5':
                return c2.W;
            case '6':
                return c2.X;
            case '7':
                return c2.Y;
            default:
                return c2.V;
        }
    }

    public void qw(x xVar) {
        s0 s0Var = this.f9766yj;
        if (s0Var != null) {
            xVar.h(s0.b6, s0Var);
        }
        x xVar2 = this.f9763i;
        if (xVar2 != null) {
            xVar.h(s0.W0, xVar2);
        }
    }

    public void rg(a aVar) throws IOException {
        if (this.f9762ad) {
            aVar.write(f9761o[0]);
            return;
        }
        aVar.write(f9761o[1]);
        aVar.write(de(this.f9764th));
        aVar.write(f9761o[2]);
    }
}
