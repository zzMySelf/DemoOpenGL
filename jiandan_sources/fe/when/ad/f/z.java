package fe.when.ad.f;

import java.io.InputStream;

public class z extends v1 {
    public z(InputStream inputStream, c2 c2Var) {
        super(inputStream, c2Var);
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
            if (r1 == 0) goto L_0x0089
            boolean r3 = r1.i()
            if (r3 == 0) goto L_0x0089
            fe.when.ad.f.k r3 = new fe.when.ad.f.k
            r3.<init>()
            fe.when.ad.f.k r4 = new fe.when.ad.f.k
            r4.<init>()
            fe.when.ad.f.x r5 = new fe.when.ad.f.x
            r5.<init>()
            fe.when.ad.f.s0 r6 = fe.when.ad.f.s0.c3
            fe.when.ad.f.s0 r7 = fe.when.ad.f.s0.T4
            r5.h(r6, r7)
            fe.when.ad.f.s0 r6 = fe.when.ad.f.s0.i0
            r3.qqq(r6)
            r4.qqq(r5)
            boolean r5 = r8.f462switch
            if (r5 == 0) goto L_0x007f
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.p1
            r3.qqq(r5)
            fe.when.ad.f.u0 r5 = new fe.when.ad.f.u0
            r5.<init>()
            r4.qqq(r5)
        L_0x007f:
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.e1
            r8.h(r5, r3)
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.p0
            r8.h(r3, r4)
        L_0x0089:
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.F2
            fe.when.ad.f.y0 r3 = r8.qqq(r3)
            if (r1 == 0) goto L_0x00b7
            if (r3 == 0) goto L_0x00b7
            boolean r4 = r3.ppp()
            if (r4 == 0) goto L_0x00b7
            r4 = r3
            fe.when.ad.f.v0 r4 = (fe.when.ad.f.v0) r4
            int r4 = r4.eee()
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.F2
            fe.when.ad.f.v0 r6 = new fe.when.ad.f.v0
            int r4 = r1.qw(r4)
            r6.<init>((int) r4)
            r8.h(r5, r6)
            r8.n(r9, r10)
            fe.when.ad.f.s0 r9 = fe.when.ad.f.s0.F2
            r8.h(r9, r3)
            goto L_0x00ba
        L_0x00b7:
            r8.n(r9, r10)
        L_0x00ba:
            byte[] r9 = fe.when.ad.f.v1.mmm
            r10.write(r9)
            java.io.InputStream r9 = r8.ggg
            if (r9 == 0) goto L_0x0117
            r8.nn = r2
            fe.when.ad.f.a r9 = new fe.when.ad.f.a
            r9.<init>(r10)
            if (r1 == 0) goto L_0x00d2
            fe.when.ad.f.b r1 = r1.yj(r9)
            r3 = r1
            goto L_0x00d4
        L_0x00d2:
            r1 = r9
            r3 = r0
        L_0x00d4:
            boolean r4 = r8.f462switch
            if (r4 == 0) goto L_0x00eb
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            int r4 = r8.when
            r0.<init>(r4)
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r5 = 32768(0x8000, float:4.5918E-41)
            r4.<init>(r1, r0, r5)
            r5 = r4
            r4 = r0
            r0 = r5
            goto L_0x00ed
        L_0x00eb:
            r4 = r0
            r5 = r1
        L_0x00ed:
            r1 = 4192(0x1060, float:5.874E-42)
            byte[] r6 = new byte[r1]
        L_0x00f1:
            java.io.InputStream r1 = r8.ggg
            int r1 = r1.read(r6)
            if (r1 > 0) goto L_0x010e
            if (r0 == 0) goto L_0x0101
            r0.finish()
            r4.end()
        L_0x0101:
            if (r3 == 0) goto L_0x0106
            r3.qw()
        L_0x0106:
            long r0 = r9.qw()
            int r9 = (int) r0
            r8.xxx = r9
            goto L_0x013d
        L_0x010e:
            r5.write(r6, r2, r1)
            int r7 = r8.nn
            int r7 = r7 + r1
            r8.nn = r7
            goto L_0x00f1
        L_0x0117:
            if (r1 != 0) goto L_0x0127
            java.io.ByteArrayOutputStream r9 = r8.ppp
            if (r9 == 0) goto L_0x0121
            r9.writeTo(r10)
            goto L_0x013d
        L_0x0121:
            byte[] r9 = r8.f9852ad
            r10.write(r9)
            goto L_0x013d
        L_0x0127:
            java.io.ByteArrayOutputStream r9 = r8.ppp
            if (r9 == 0) goto L_0x0134
            byte[] r9 = r9.toByteArray()
            byte[] r9 = r1.rg(r9)
            goto L_0x013a
        L_0x0134:
            byte[] r9 = r8.f9852ad
            byte[] r9 = r1.rg(r9)
        L_0x013a:
            r10.write(r9)
        L_0x013d:
            byte[] r9 = fe.when.ad.f.v1.aaa
            r10.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.z.nn(fe.when.ad.f.c2, java.io.OutputStream):void");
    }

    public z(byte[] bArr) {
        super(bArr);
    }
}
