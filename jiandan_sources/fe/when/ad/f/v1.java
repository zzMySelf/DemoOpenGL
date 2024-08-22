package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import fe.when.ad.rg;
import fe.when.ad.th;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class v1 extends x {
    public static final byte[] aaa;
    public static final byte[] mmm = rg.rg("stream\n");
    public c2 ddd;
    public InputStream ggg;
    public int nn;
    public ByteArrayOutputStream ppp = null;

    /* renamed from: switch  reason: not valid java name */
    public boolean f462switch = false;
    public l0 vvv;
    public int when = 0;
    public int xxx = -1;

    static {
        byte[] rg2 = rg.rg("\nendstream");
        aaa = rg2;
        int length = mmm.length;
        int length2 = rg2.length;
    }

    public v1(byte[] bArr) {
        this.f9853th = 7;
        this.f9852ad = bArr;
        this.nn = bArr.length;
        h(s0.F2, new v0(bArr.length));
    }

    public void l(int i2) {
        if (th.nn && !this.f462switch) {
            this.when = i2;
            if (this.ggg != null) {
                this.f462switch = true;
                return;
            }
            y0 ggg2 = m1.ggg(qqq(s0.e1));
            if (ggg2 != null) {
                if (ggg2.m1125switch()) {
                    if (s0.p1.equals(ggg2)) {
                        return;
                    }
                } else if (!ggg2.i()) {
                    throw new RuntimeException(qw.ad("stream.could.not.be.compressed.filter.is.not.a.name.or.array", new Object[0]));
                } else if (((k) ggg2).a(s0.p1)) {
                    return;
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i2);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                if (this.ppp != null) {
                    this.ppp.writeTo(deflaterOutputStream);
                } else {
                    deflaterOutputStream.write(this.f9852ad);
                }
                deflaterOutputStream.close();
                deflater.end();
                this.ppp = byteArrayOutputStream;
                this.f9852ad = null;
                h(s0.F2, new v0(byteArrayOutputStream.size()));
                if (ggg2 == null) {
                    h(s0.e1, s0.p1);
                } else {
                    k kVar = new k(ggg2);
                    kVar.aaa(0, s0.p1);
                    h(s0.e1, kVar);
                }
                this.f462switch = true;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public int m() {
        return this.nn;
    }

    public void n(c2 c2Var, OutputStream outputStream) throws IOException {
        super.nn(c2Var, outputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: fe.when.ad.f.b} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (fe.when.ad.f.s0.i0.equals(r3.g(0)) != false) goto L_0x002b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void nn(fe.when.ad.f.c2 r9, java.io.OutputStream r10) throws java.io.IOException {
        /*
            r8 = this;
            java.io.InputStream r0 = r8.ggg
            if (r0 == 0) goto L_0x000f
            boolean r0 = r8.f462switch
            if (r0 == 0) goto L_0x000f
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.e1
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.p1
            r8.h(r0, r1)
        L_0x000f:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            fe.when.ad.f.b0 r1 = r9.y()
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            r2 = 0
            if (r1 == 0) goto L_0x0048
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.e1
            fe.when.ad.f.y0 r3 = r8.qqq(r3)
            if (r3 == 0) goto L_0x0048
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.i0
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x002d
        L_0x002b:
            r1 = r0
            goto L_0x0048
        L_0x002d:
            boolean r4 = r3.i()
            if (r4 == 0) goto L_0x0048
            fe.when.ad.f.k r3 = (fe.when.ad.f.k) r3
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0048
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.i0
            fe.when.ad.f.y0 r3 = r3.g(r2)
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0048
            goto L_0x002b
        L_0x0048:
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.F2
            fe.when.ad.f.y0 r3 = r8.qqq(r3)
            if (r1 == 0) goto L_0x0076
            if (r3 == 0) goto L_0x0076
            boolean r4 = r3.ppp()
            if (r4 == 0) goto L_0x0076
            r4 = r3
            fe.when.ad.f.v0 r4 = (fe.when.ad.f.v0) r4
            int r4 = r4.eee()
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.F2
            fe.when.ad.f.v0 r6 = new fe.when.ad.f.v0
            int r4 = r1.qw(r4)
            r6.<init>((int) r4)
            r8.h(r5, r6)
            r8.n(r9, r10)
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.F2
            r8.h(r4, r3)
            goto L_0x0079
        L_0x0076:
            r8.n(r9, r10)
        L_0x0079:
            r3 = 9
            fe.when.ad.f.c2.g(r9, r3, r8)
            byte[] r9 = mmm
            r10.write(r9)
            java.io.InputStream r9 = r8.ggg
            if (r9 == 0) goto L_0x00e1
            r8.nn = r2
            fe.when.ad.f.a r9 = new fe.when.ad.f.a
            r9.<init>(r10)
            if (r1 == 0) goto L_0x009c
            boolean r3 = r1.i()
            if (r3 != 0) goto L_0x009c
            fe.when.ad.f.b r1 = r1.yj(r9)
            r3 = r1
            goto L_0x009e
        L_0x009c:
            r1 = r9
            r3 = r0
        L_0x009e:
            boolean r4 = r8.f462switch
            if (r4 == 0) goto L_0x00b5
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            int r4 = r8.when
            r0.<init>(r4)
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r5 = 32768(0x8000, float:4.5918E-41)
            r4.<init>(r1, r0, r5)
            r5 = r4
            r4 = r0
            r0 = r5
            goto L_0x00b7
        L_0x00b5:
            r4 = r0
            r5 = r1
        L_0x00b7:
            r1 = 4192(0x1060, float:5.874E-42)
            byte[] r6 = new byte[r1]
        L_0x00bb:
            java.io.InputStream r1 = r8.ggg
            int r1 = r1.read(r6)
            if (r1 > 0) goto L_0x00d8
            if (r0 == 0) goto L_0x00cb
            r0.finish()
            r4.end()
        L_0x00cb:
            if (r3 == 0) goto L_0x00d0
            r3.qw()
        L_0x00d0:
            long r0 = r9.qw()
            int r9 = (int) r0
            r8.xxx = r9
            goto L_0x010d
        L_0x00d8:
            r5.write(r6, r2, r1)
            int r7 = r8.nn
            int r7 = r7 + r1
            r8.nn = r7
            goto L_0x00bb
        L_0x00e1:
            if (r1 == 0) goto L_0x0100
            boolean r9 = r1.i()
            if (r9 != 0) goto L_0x0100
            java.io.ByteArrayOutputStream r9 = r8.ppp
            if (r9 == 0) goto L_0x00f6
            byte[] r9 = r9.toByteArray()
            byte[] r9 = r1.rg(r9)
            goto L_0x00fc
        L_0x00f6:
            byte[] r9 = r8.f9852ad
            byte[] r9 = r1.rg(r9)
        L_0x00fc:
            r10.write(r9)
            goto L_0x010d
        L_0x0100:
            java.io.ByteArrayOutputStream r9 = r8.ppp
            if (r9 == 0) goto L_0x0108
            r9.writeTo(r10)
            goto L_0x010d
        L_0x0108:
            byte[] r9 = r8.f9852ad
            r10.write(r9)
        L_0x010d:
            byte[] r9 = aaa
            r10.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.v1.nn(fe.when.ad.f.c2, java.io.OutputStream):void");
    }

    public void p(OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.ppp;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.writeTo(outputStream);
            return;
        }
        byte[] bArr = this.f9852ad;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public void q() throws IOException {
        if (this.ggg != null) {
            int i2 = this.xxx;
            if (i2 != -1) {
                this.ddd.a(new v0(i2), this.vvv, false);
                return;
            }
            throw new IOException(qw.ad("writelength.can.only.be.called.after.output.of.the.stream.body", new Object[0]));
        }
        throw new UnsupportedOperationException(qw.ad("writelength.can.only.be.called.in.a.contructed.pdfstream.inputstream.pdfwriter", new Object[0]));
    }

    public String toString() {
        if (qqq(s0.K5) == null) {
            return "Stream";
        }
        return "Stream of type: " + qqq(s0.K5);
    }

    public v1(InputStream inputStream, c2 c2Var) {
        this.f9853th = 7;
        this.ggg = inputStream;
        this.ddd = c2Var;
        l0 M = c2Var.M();
        this.vvv = M;
        h(s0.F2, M);
    }

    public v1() {
        this.f9853th = 7;
    }
}
