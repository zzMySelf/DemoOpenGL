package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.th;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class d extends v1 {
    public int e = 0;
    public long eee;
    public m1 qqq;
    public int rrr;
    public int tt = 0;

    public d(d dVar, x xVar) {
        this.qqq = dVar.qqq;
        this.eee = dVar.eee;
        this.rrr = dVar.rrr;
        this.f462switch = dVar.f462switch;
        this.when = dVar.when;
        this.ppp = dVar.ppp;
        this.f9852ad = dVar.f9852ad;
        this.tt = dVar.tt;
        this.e = dVar.e;
        if (xVar != null) {
            j(xVar);
        } else {
            this.f9838i.putAll(dVar.f9838i);
        }
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        byte[] qqq2 = m1.qqq(this);
        b0 y = c2Var != null ? c2Var.y() : null;
        y0 qqq3 = qqq(s0.F2);
        int length = qqq2.length;
        if (y != null) {
            length = y.qw(length);
        }
        h(s0.F2, new v0(length));
        n(c2Var, outputStream);
        h(s0.F2, qqq3);
        outputStream.write(v1.mmm);
        if (this.rrr > 0) {
            if (y != null && !y.i()) {
                qqq2 = y.rg(qqq2);
            }
            outputStream.write(qqq2);
        }
        outputStream.write(v1.aaa);
    }

    public int r() {
        return this.rrr;
    }

    public int s() {
        return this.e;
    }

    public int t() {
        return this.tt;
    }

    public byte[] th() {
        return this.f9852ad;
    }

    public long u() {
        return this.eee;
    }

    public m1 v() {
        return this.qqq;
    }

    public void w(int i2) {
        this.rrr = i2;
        h(s0.F2, new v0(i2));
    }

    public void x(int i2, int i3) {
        this.tt = i2;
        this.e = i3;
    }

    public d(m1 m1Var, long j) {
        this.qqq = m1Var;
        this.eee = j;
    }

    public d(m1 m1Var, byte[] bArr, int i2) {
        this.qqq = m1Var;
        this.eee = -1;
        if (th.nn) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i2);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                this.f9852ad = byteArrayOutputStream.toByteArray();
                h(s0.e1, s0.p1);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            this.f9852ad = bArr;
        }
        w(this.f9852ad.length);
    }
}
