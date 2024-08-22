package fe.when.ad.f;

import com.itextpdf.text.pdf.BadPdfFormatException;
import fe.when.ad.aaa;
import fe.when.ad.rg;
import fe.when.ad.th;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class s extends v1 {
    public static final byte[] e = rg.rg("0 -1 1 0 ");
    public static final byte[] eee = rg.rg("Q\n");
    public static final byte[] f = rg.rg(" cm\n");
    public static final byte[] qqq = rg.rg("q\n");
    public static final byte[] rrr = rg.rg("0 1 -1 0 ");
    public static final byte[] tt = rg.rg("-1 0 0 -1 ");

    public s(q qVar, q qVar2, q qVar3, q qVar4, aaa aaa) throws BadPdfFormatException {
        Deflater deflater = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.ppp = byteArrayOutputStream;
            OutputStream outputStream = byteArrayOutputStream;
            if (th.nn) {
                this.f462switch = true;
                if (qVar3 != null) {
                    this.when = qVar3.C().r();
                } else if (qVar2 != null) {
                    this.when = qVar2.C().r();
                }
                deflater = new Deflater(this.when);
                outputStream = new DeflaterOutputStream(this.ppp, deflater);
            }
            int mmm = aaa.mmm();
            if (mmm == 90) {
                outputStream.write(rrr);
                outputStream.write(rg.rg(rg.ggg((double) aaa.aaa())));
                outputStream.write(32);
                outputStream.write(48);
                outputStream.write(f);
            } else if (mmm == 180) {
                outputStream.write(tt);
                outputStream.write(rg.rg(rg.ggg((double) aaa.ddd())));
                outputStream.write(32);
                outputStream.write(rg.rg(rg.ggg((double) aaa.aaa())));
                outputStream.write(f);
            } else if (mmm == 270) {
                outputStream.write(e);
                outputStream.write(48);
                outputStream.write(32);
                outputStream.write(rg.rg(rg.ggg((double) aaa.ddd())));
                outputStream.write(f);
            }
            if (qVar.T0() > 0) {
                outputStream.write(qqq);
                qVar.w().aaa(outputStream);
                outputStream.write(eee);
            }
            if (qVar2.T0() > 0) {
                outputStream.write(qqq);
                qVar2.w().aaa(outputStream);
                outputStream.write(eee);
            }
            if (qVar3 != null) {
                outputStream.write(qqq);
                qVar3.w().aaa(outputStream);
                outputStream.write(eee);
            }
            if (qVar4.T0() > 0) {
                qVar4.w().aaa(outputStream);
            }
            outputStream.close();
            if (deflater != null) {
                deflater.end();
            }
            h(s0.F2, new v0(this.ppp.size()));
            if (this.f462switch) {
                h(s0.e1, s0.p1);
            }
        } catch (Exception e2) {
            throw new BadPdfFormatException(e2.getMessage());
        }
    }
}
