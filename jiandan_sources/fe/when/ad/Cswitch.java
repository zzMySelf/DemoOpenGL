package fe.when.ad;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import fe.when.ad.f.n2.pf.de;
import fe.when.ad.f.n2.pf.qw;
import fe.when.ad.f.z1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* renamed from: fe.when.ad.switch  reason: invalid class name */
public class Cswitch extends i {
    public Cswitch(URL url) throws BadElementException, IOException {
        super(url);
        M0();
    }

    public final void M0() throws BadElementException, IOException {
        String str;
        this.qqq = 35;
        this.H = 6;
        InputStream inputStream = null;
        try {
            if (this.rrr == null) {
                inputStream = this.eee.openStream();
                str = this.eee.toString();
            } else {
                str = "Byte array";
                inputStream = new ByteArrayInputStream(this.rrr);
            }
            qw qwVar = new qw(inputStream);
            if (qwVar.fe() == -1698247209) {
                qwVar.th();
                int rg2 = qwVar.rg();
                int rg3 = qwVar.rg();
                int rg4 = qwVar.rg();
                int rg5 = qwVar.rg();
                int th2 = qwVar.th();
                this.K = 72;
                this.L = 72;
                float f = (float) th2;
                float f2 = (((float) (rg5 - rg3)) / f) * 72.0f;
                this.n = f2;
                n(f2);
                float f3 = (((float) (rg4 - rg2)) / f) * 72.0f;
                this.m = f3;
                l(f3);
                return;
            }
            throw new BadElementException(fe.when.ad.c.qw.ad("1.is.not.a.valid.placeable.windows.metafile", str));
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            this.k = rrr();
            this.l = ggg();
        }
    }

    public void N0(z1 z1Var) throws IOException, DocumentException {
        InputStream byteArrayInputStream;
        G0(z1Var);
        z1Var.s1(rrr());
        z1Var.q1(ggg());
        InputStream inputStream = null;
        try {
            if (this.rrr == null) {
                byteArrayInputStream = this.eee.openStream();
            } else {
                byteArrayInputStream = new ByteArrayInputStream(this.rrr);
            }
            new de(inputStream, z1Var).fe();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public Cswitch(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rrr = bArr;
        this.I = bArr;
        M0();
    }
}
