package com.itextpdf.text;

import fe.when.ad.c.qw;
import fe.when.ad.i;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Jpeg2000 extends i {
    public InputStream X;
    public int Y;
    public int Z;
    public ArrayList<ColorSpecBox> a0 = null;
    public byte[] b0;

    public static class ColorSpecBox extends ArrayList<Integer> {
        public byte[] colorProfile;

        public int getApprox() {
            return ((Integer) get(2)).intValue();
        }

        public byte[] getColorProfile() {
            return this.colorProfile;
        }

        public int getEnumCs() {
            return ((Integer) get(3)).intValue();
        }

        public int getMeth() {
            return ((Integer) get(0)).intValue();
        }

        public int getPrec() {
            return ((Integer) get(1)).intValue();
        }

        public void setColorProfile(byte[] bArr) {
            this.colorProfile = bArr;
        }
    }

    public Jpeg2000(URL url) throws BadElementException, IOException {
        super(url);
        P0();
    }

    public final int M0(int i2) throws IOException {
        int i3 = 0;
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            i3 += this.X.read() << (i4 << 3);
        }
        return i3;
    }

    public void N0() throws IOException {
        this.Y = M0(4);
        this.Z = M0(4);
        int i2 = this.Y;
        if (i2 == 1) {
            if (M0(4) == 0) {
                int M0 = M0(4);
                this.Y = M0;
                if (M0 == 0) {
                    throw new IOException(qw.ad("unsupported.box.size.eq.eq.0", new Object[0]));
                }
                return;
            }
            throw new IOException(qw.ad("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
        } else if (i2 == 0) {
            throw new ZeroBoxSizeException(qw.ad("unsupported.box.size.eq.eq.0", new Object[0]));
        }
    }

    public final ColorSpecBox O0() throws IOException {
        ColorSpecBox colorSpecBox = new ColorSpecBox();
        int i2 = 8;
        for (int i3 = 0; i3 < 3; i3++) {
            colorSpecBox.add(Integer.valueOf(M0(1)));
            i2++;
        }
        if (colorSpecBox.getMeth() == 1) {
            colorSpecBox.add(Integer.valueOf(M0(4)));
            i2 += 4;
        } else {
            colorSpecBox.add(0);
        }
        int i4 = this.Y;
        if (i4 - i2 > 0) {
            byte[] bArr = new byte[(i4 - i2)];
            this.X.read(bArr, 0, i4 - i2);
            colorSpecBox.setColorProfile(bArr);
        }
        return colorSpecBox;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|(1:33)|34|35|36|37|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P0() throws java.io.IOException {
        /*
            r9 = this;
            r0 = 33
            r9.qqq = r0
            r0 = 8
            r9.H = r0
            r1 = 0
            r9.X = r1
            byte[] r2 = r9.rrr     // Catch:{ all -> 0x0185 }
            if (r2 != 0) goto L_0x0018
            java.net.URL r2 = r9.eee     // Catch:{ all -> 0x0185 }
            java.io.InputStream r2 = r2.openStream()     // Catch:{ all -> 0x0185 }
            r9.X = r2     // Catch:{ all -> 0x0185 }
            goto L_0x0021
        L_0x0018:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0185 }
            byte[] r3 = r9.rrr     // Catch:{ all -> 0x0185 }
            r2.<init>(r3)     // Catch:{ all -> 0x0185 }
            r9.X = r2     // Catch:{ all -> 0x0185 }
        L_0x0021:
            r2 = 4
            int r3 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            r9.Y = r3     // Catch:{ all -> 0x0185 }
            r4 = 12
            r5 = 2
            r6 = 0
            if (r3 != r4) goto L_0x012a
            int r3 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            r9.Z = r3     // Catch:{ all -> 0x0185 }
            r4 = 1783636000(0x6a502020, float:6.290207E25)
            if (r4 != r3) goto L_0x011c
            r3 = 218793738(0xd0a870a, float:4.268708E-31)
            int r4 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            if (r3 != r4) goto L_0x010e
            r9.N0()     // Catch:{ all -> 0x0185 }
            r3 = 1718909296(0x66747970, float:2.8862439E23)
            int r4 = r9.Z     // Catch:{ all -> 0x0185 }
            if (r3 != r4) goto L_0x0100
            java.io.InputStream r3 = r9.X     // Catch:{ all -> 0x0185 }
            int r4 = r9.Y     // Catch:{ all -> 0x0185 }
            int r4 = r4 - r0
            fe.when.ad.a.i(r3, r4)     // Catch:{ all -> 0x0185 }
            r9.N0()     // Catch:{ all -> 0x0185 }
        L_0x0057:
            int r3 = r9.Z     // Catch:{ all -> 0x0185 }
            r4 = 1785737832(0x6a703268, float:7.259506E25)
            if (r4 == r3) goto L_0x007f
            int r3 = r9.Z     // Catch:{ all -> 0x0185 }
            r7 = 1785737827(0x6a703263, float:7.2595035E25)
            if (r3 == r7) goto L_0x0071
            java.io.InputStream r3 = r9.X     // Catch:{ all -> 0x0185 }
            int r7 = r9.Y     // Catch:{ all -> 0x0185 }
            int r7 = r7 - r0
            fe.when.ad.a.i(r3, r7)     // Catch:{ all -> 0x0185 }
            r9.N0()     // Catch:{ all -> 0x0185 }
            goto L_0x007f
        L_0x0071:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "expected.jp2h.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x007f:
            int r3 = r9.Z     // Catch:{ all -> 0x0185 }
            if (r4 != r3) goto L_0x0057
            r9.N0()     // Catch:{ all -> 0x0185 }
            r3 = 1768449138(0x69686472, float:1.7559071E25)
            int r4 = r9.Z     // Catch:{ all -> 0x0185 }
            if (r3 != r4) goto L_0x00f2
            int r3 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            float r3 = (float) r3     // Catch:{ all -> 0x0185 }
            r9.n = r3     // Catch:{ all -> 0x0185 }
            r9.n(r3)     // Catch:{ all -> 0x0185 }
            int r2 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            float r2 = (float) r2     // Catch:{ all -> 0x0185 }
            r9.m = r2     // Catch:{ all -> 0x0185 }
            r9.l(r2)     // Catch:{ all -> 0x0185 }
            r9.M0(r5)     // Catch:{ all -> 0x0185 }
            r2 = -1
            r9.tt = r2     // Catch:{ all -> 0x0185 }
            r2 = 1
            int r2 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            r9.tt = r2     // Catch:{ all -> 0x0185 }
            java.io.InputStream r2 = r9.X     // Catch:{ all -> 0x0185 }
            r3 = 3
            fe.when.ad.a.i(r2, r3)     // Catch:{ all -> 0x0185 }
            r9.N0()     // Catch:{ all -> 0x0185 }
            int r2 = r9.Z     // Catch:{ all -> 0x0185 }
            r3 = 1651532643(0x62706363, float:1.10859504E21)
            if (r2 != r3) goto L_0x00cf
            int r2 = r9.Y     // Catch:{ all -> 0x0185 }
            int r2 = r2 - r0
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0185 }
            r9.b0 = r2     // Catch:{ all -> 0x0185 }
            java.io.InputStream r3 = r9.X     // Catch:{ all -> 0x0185 }
            int r4 = r9.Y     // Catch:{ all -> 0x0185 }
            int r4 = r4 - r0
            r3.read(r2, r6, r4)     // Catch:{ all -> 0x0185 }
            goto L_0x0161
        L_0x00cf:
            int r0 = r9.Z     // Catch:{ all -> 0x0185 }
            r2 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r0 != r2) goto L_0x0161
        L_0x00d6:
            java.util.ArrayList<com.itextpdf.text.Jpeg2000$ColorSpecBox> r0 = r9.a0     // Catch:{ all -> 0x0185 }
            if (r0 != 0) goto L_0x00e1
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0185 }
            r0.<init>()     // Catch:{ all -> 0x0185 }
            r9.a0 = r0     // Catch:{ all -> 0x0185 }
        L_0x00e1:
            java.util.ArrayList<com.itextpdf.text.Jpeg2000$ColorSpecBox> r0 = r9.a0     // Catch:{ all -> 0x0185 }
            com.itextpdf.text.Jpeg2000$ColorSpecBox r3 = r9.O0()     // Catch:{ all -> 0x0185 }
            r0.add(r3)     // Catch:{ all -> 0x0185 }
            r9.N0()     // Catch:{ ZeroBoxSizeException -> 0x00ed }
        L_0x00ed:
            int r0 = r9.Z     // Catch:{ all -> 0x0185 }
            if (r2 == r0) goto L_0x00d6
            goto L_0x0161
        L_0x00f2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "expected.ihdr.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x0100:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "expected.ftyp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x010e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "error.with.jp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x011c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "expected.jp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x012a:
            r4 = -11534511(0xffffffffff4fff51, float:-2.7647587E38)
            if (r3 != r4) goto L_0x0177
            java.io.InputStream r3 = r9.X     // Catch:{ all -> 0x0185 }
            fe.when.ad.a.i(r3, r2)     // Catch:{ all -> 0x0185 }
            int r3 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            int r4 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            int r6 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            int r2 = r9.M0(r2)     // Catch:{ all -> 0x0185 }
            java.io.InputStream r7 = r9.X     // Catch:{ all -> 0x0185 }
            r8 = 16
            fe.when.ad.a.i(r7, r8)     // Catch:{ all -> 0x0185 }
            int r5 = r9.M0(r5)     // Catch:{ all -> 0x0185 }
            r9.N = r5     // Catch:{ all -> 0x0185 }
            r9.tt = r0     // Catch:{ all -> 0x0185 }
            int r4 = r4 - r2
            float r0 = (float) r4     // Catch:{ all -> 0x0185 }
            r9.n = r0     // Catch:{ all -> 0x0185 }
            r9.n(r0)     // Catch:{ all -> 0x0185 }
            int r3 = r3 - r6
            float r0 = (float) r3     // Catch:{ all -> 0x0185 }
            r9.m = r0     // Catch:{ all -> 0x0185 }
            r9.l(r0)     // Catch:{ all -> 0x0185 }
        L_0x0161:
            java.io.InputStream r0 = r9.X
            if (r0 == 0) goto L_0x016a
            r0.close()     // Catch:{ Exception -> 0x0168 }
        L_0x0168:
            r9.X = r1
        L_0x016a:
            float r0 = r9.rrr()
            r9.k = r0
            float r0 = r9.ggg()
            r9.l = r0
            return
        L_0x0177:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "not.a.valid.jpeg2000.file"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0185 }
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x0185:
            r0 = move-exception
            java.io.InputStream r2 = r9.X
            if (r2 == 0) goto L_0x018f
            r2.close()     // Catch:{ Exception -> 0x018d }
        L_0x018d:
            r9.X = r1
        L_0x018f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Jpeg2000.P0():void");
    }

    public class ZeroBoxSizeException extends IOException {
        public ZeroBoxSizeException() {
        }

        public ZeroBoxSizeException(String str) {
            super(str);
        }
    }

    public Jpeg2000(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rrr = bArr;
        this.I = bArr;
        P0();
    }
}
