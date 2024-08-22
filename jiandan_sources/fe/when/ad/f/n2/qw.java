package fe.when.ad.f.n2;

import com.google.common.base.Ascii;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.Cif;
import fe.when.ad.f.k;
import fe.when.ad.f.s0;
import fe.when.ad.f.v0;
import fe.when.ad.f.w1;
import fe.when.ad.f.x;
import fe.when.ad.i;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public long f9615ad;

    /* renamed from: de  reason: collision with root package name */
    public long f9616de;

    /* renamed from: fe  reason: collision with root package name */
    public long f9617fe;
    public long ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f9618i;

    /* renamed from: if  reason: not valid java name */
    public int f436if;

    /* renamed from: o  reason: collision with root package name */
    public int f9619o;

    /* renamed from: pf  reason: collision with root package name */
    public int f9620pf;
    public long ppp;
    public InputStream qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f9621rg;

    /* renamed from: switch  reason: not valid java name */
    public int f437switch;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f9622th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9623uk;
    public int vvv;
    public HashMap<String, Object> when = new HashMap<>();
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f9624yj;

    public qw(InputStream inputStream, boolean z, int i2) throws IOException {
        this.f9615ad = (long) i2;
        this.f9616de = 0;
        pf(inputStream, z);
    }

    public static i rg(InputStream inputStream) throws IOException {
        return th(inputStream, false, 0);
    }

    public static i th(InputStream inputStream, boolean z, int i2) throws IOException {
        qw qwVar = new qw(inputStream, z, i2);
        try {
            i fe2 = qwVar.fe();
            fe2.y0((int) ((((double) qwVar.ppp) * 0.0254d) + 0.5d), (int) ((((double) qwVar.ggg) * 0.0254d) + 0.5d));
            fe2.D0(4);
            return fe2;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static i uk(byte[] bArr) throws IOException {
        i rg2 = rg(new ByteArrayInputStream(bArr));
        rg2.C0(bArr);
        return rg2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i yj(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            fe.when.ad.i r1 = rg(r0)     // Catch:{ all -> 0x0011 }
            r1.I0(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.qw.yj(java.net.URL):fe.when.ad.i");
    }

    public final i aaa() throws IOException, BadElementException {
        int i2 = (int) this.f9621rg;
        if (i2 == 0) {
            i2 = (int) (this.f9615ad - this.f9616de);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            i4 += this.qw.read(bArr, i4, i2 - i4);
        }
        byte[] qw2 = qw(true, bArr);
        int i5 = this.vvv;
        int i6 = this.xxx * i5;
        if (this.f9623uk) {
            byte[] bArr2 = new byte[qw2.length];
            while (i3 < this.xxx) {
                int i7 = i3 + 1;
                System.arraycopy(qw2, i6 - (i7 * i5), bArr2, i3 * i5, i5);
                i3 = i7;
            }
            qw2 = bArr2;
        }
        return o(qw2, 8, 4);
    }

    public final int ad(int i2) {
        for (int i3 = 0; i3 < 32 && (i2 & 1) != 1; i3++) {
            i2 >>>= 1;
        }
        return i2;
    }

    public final int ddd(InputStream inputStream) throws IOException {
        return xxx(inputStream);
    }

    public final int de(int i2) {
        int i3 = 0;
        while (i3 < 32 && (i2 & 1) != 1) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    public final long eee(InputStream inputStream) throws IOException {
        int qqq = qqq(inputStream);
        int qqq2 = qqq(inputStream);
        return ((long) ((qqq(inputStream) << 24) | (qqq(inputStream) << 16) | (qqq2 << 8) | qqq)) & -1;
    }

    public final i fe() throws IOException, BadElementException {
        switch (this.f9624yj) {
            case 0:
                return m1102switch(3);
            case 1:
                return ppp(3);
            case 2:
                return ggg(3);
            case 3:
                byte[] bArr = new byte[(this.vvv * this.xxx * 3)];
                when(bArr);
                return new Cif(this.vvv, this.xxx, 3, 8, bArr);
            case 4:
                return m1102switch(4);
            case 5:
                int i2 = (int) this.f9617fe;
                if (i2 == 0) {
                    return ppp(4);
                }
                if (i2 == 2) {
                    return mmm();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i3 = (int) this.f9617fe;
                if (i3 == 0) {
                    return ggg(4);
                }
                if (i3 == 1) {
                    return aaa();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[(this.vvv * this.xxx * 3)];
                when(bArr2);
                return new Cif(this.vvv, this.xxx, 3, 8, bArr2);
            case 8:
                return m1101if(false);
            case 9:
                return m1101if(true);
            case 10:
                return m1102switch(4);
            case 11:
                int i4 = (int) this.f9617fe;
                if (i4 == 0) {
                    return ppp(4);
                }
                if (i4 == 2) {
                    return mmm();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i5 = (int) this.f9617fe;
                if (i5 == 0) {
                    return ggg(4);
                }
                if (i5 == 1) {
                    return aaa();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return m1101if(false);
            case 14:
                byte[] bArr3 = new byte[(this.vvv * this.xxx * 3)];
                when(bArr3);
                return new Cif(this.vvv, this.xxx, 3, 8, bArr3);
            case 15:
                return m1101if(true);
            default:
                return null;
        }
    }

    public final i ggg(int i2) throws IOException, BadElementException {
        int i3 = this.vvv;
        byte[] bArr = new byte[(this.xxx * i3)];
        int i4 = i3 * 8;
        int i5 = 0;
        int ceil = i4 % 32 != 0 ? (int) Math.ceil(((double) ((((i4 / 32) + 1) * 32) - i4)) / 8.0d) : 0;
        int i6 = (this.vvv + ceil) * this.xxx;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.qw.read(bArr2, i7, i6 - i7);
        }
        if (this.f9623uk) {
            while (i5 < this.xxx) {
                int i8 = i5 + 1;
                int i9 = this.vvv;
                System.arraycopy(bArr2, i6 - ((i9 + ceil) * i8), bArr, i5 * i9, i9);
                i5 = i8;
            }
        } else {
            while (i5 < this.xxx) {
                int i10 = this.vvv;
                System.arraycopy(bArr2, (i10 + ceil) * i5, bArr, i5 * i10, i10);
                i5++;
            }
        }
        return o(bArr, 8, i2);
    }

    public final byte[] i(int i2) {
        byte[] bArr = this.f9622th;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[((bArr.length / i2) * 3)];
        int length = bArr.length / i2;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * i2;
            int i5 = i3 * 3;
            byte[] bArr3 = this.f9622th;
            int i6 = i4 + 1;
            bArr2[i5 + 2] = bArr3[i4];
            bArr2[i5 + 1] = bArr3[i6];
            bArr2[i5] = bArr3[i6 + 1];
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.when.ad.i m1101if(boolean r21) throws java.io.IOException, com.itextpdf.text.BadElementException {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.f9619o
            int r1 = r0.ad(r1)
            int r2 = r0.f9619o
            int r2 = r0.de(r2)
            int r3 = r1 + 1
            int r4 = r0.f9620pf
            int r4 = r0.ad(r4)
            int r5 = r0.f9620pf
            int r5 = r0.de(r5)
            int r6 = r4 + 1
            int r7 = r0.f436if
            int r7 = r0.ad(r7)
            int r8 = r0.f436if
            int r8 = r0.de(r8)
            int r9 = r7 + 1
            int r10 = r0.vvv
            int r11 = r0.xxx
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            if (r21 != 0) goto L_0x004f
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x004f
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r13 = (double) r13
            r15 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r13 = r13 / r15
            double r13 = java.lang.Math.ceil(r13)
            int r10 = (int) r13
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            long r13 = r0.f9621rg
            int r14 = (int) r13
            boolean r13 = r0.f9623uk
            if (r13 == 0) goto L_0x00bb
            int r13 = r0.xxx
            int r13 = r13 + -1
        L_0x005b:
            if (r13 < 0) goto L_0x0111
            int r14 = r0.vvv
            int r14 = r14 * 3
            int r14 = r14 * r13
            r15 = 0
        L_0x0064:
            int r12 = r0.vvv
            if (r15 >= r12) goto L_0x00a7
            if (r21 == 0) goto L_0x0074
            java.io.InputStream r12 = r0.qw
            r17 = r13
            long r12 = r0.vvv(r12)
            int r13 = (int) r12
            goto L_0x007c
        L_0x0074:
            r17 = r13
            java.io.InputStream r12 = r0.qw
            int r13 = r0.tt(r12)
        L_0x007c:
            int r12 = r14 + 1
            int r18 = r13 >>> r2
            r19 = r2
            r2 = r18 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r14] = r2
            int r2 = r12 + 1
            int r14 = r13 >>> r5
            r14 = r14 & r4
            int r14 = r14 * 256
            int r14 = r14 / r6
            byte r14 = (byte) r14
            r11[r12] = r14
            int r14 = r2 + 1
            int r12 = r13 >>> r8
            r12 = r12 & r7
            int r12 = r12 * 256
            int r12 = r12 / r9
            byte r12 = (byte) r12
            r11[r2] = r12
            int r15 = r15 + 1
            r13 = r17
            r2 = r19
            goto L_0x0064
        L_0x00a7:
            r19 = r2
            r17 = r13
            r2 = 0
        L_0x00ac:
            if (r2 >= r10) goto L_0x00b6
            java.io.InputStream r12 = r0.qw
            r12.read()
            int r2 = r2 + 1
            goto L_0x00ac
        L_0x00b6:
            int r13 = r17 + -1
            r2 = r19
            goto L_0x005b
        L_0x00bb:
            r19 = r2
            r2 = 0
            r12 = 0
        L_0x00bf:
            int r13 = r0.xxx
            if (r2 >= r13) goto L_0x0111
            r13 = 0
        L_0x00c4:
            int r14 = r0.vvv
            if (r13 >= r14) goto L_0x0101
            if (r21 == 0) goto L_0x00d2
            java.io.InputStream r14 = r0.qw
            long r14 = r0.vvv(r14)
            int r15 = (int) r14
            goto L_0x00d8
        L_0x00d2:
            java.io.InputStream r14 = r0.qw
            int r15 = r0.tt(r14)
        L_0x00d8:
            int r14 = r12 + 1
            int r17 = r15 >>> r19
            r18 = r2
            r2 = r17 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r12] = r2
            int r2 = r14 + 1
            int r12 = r15 >>> r5
            r12 = r12 & r4
            int r12 = r12 * 256
            int r12 = r12 / r6
            byte r12 = (byte) r12
            r11[r14] = r12
            int r12 = r2 + 1
            int r14 = r15 >>> r8
            r14 = r14 & r7
            int r14 = r14 * 256
            int r14 = r14 / r9
            byte r14 = (byte) r14
            r11[r2] = r14
            int r13 = r13 + 1
            r2 = r18
            goto L_0x00c4
        L_0x0101:
            r18 = r2
            r2 = 0
        L_0x0104:
            if (r2 >= r10) goto L_0x010e
            java.io.InputStream r13 = r0.qw
            r13.read()
            int r2 = r2 + 1
            goto L_0x0104
        L_0x010e:
            int r2 = r18 + 1
            goto L_0x00bf
        L_0x0111:
            fe.when.ad.if r1 = new fe.when.ad.if
            int r13 = r0.vvv
            int r14 = r0.xxx
            r15 = 3
            r16 = 8
            r12 = r1
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.qw.m1101if(boolean):fe.when.ad.i");
    }

    public final i mmm() throws IOException, BadElementException {
        int i2 = (int) this.f9621rg;
        if (i2 == 0) {
            i2 = (int) (this.f9615ad - this.f9616de);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            i3 += this.qw.read(bArr, i3, i2 - i3);
        }
        byte[] qw2 = qw(false, bArr);
        if (this.f9623uk) {
            int i4 = this.vvv;
            int i5 = this.xxx;
            byte[] bArr2 = new byte[(i4 * i5)];
            int i6 = 0;
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                int i8 = this.vvv;
                int i9 = i7 * i8;
                int i10 = i8 + i6;
                while (i6 != i10) {
                    bArr2[i6] = qw2[i9];
                    i6++;
                    i9++;
                }
            }
            qw2 = bArr2;
        }
        int i11 = (this.vvv + 1) / 2;
        byte[] bArr3 = new byte[(this.xxx * i11)];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < this.xxx; i14++) {
            for (int i15 = 0; i15 < this.vvv; i15++) {
                if ((i15 & 1) == 0) {
                    bArr3[(i15 / 2) + i13] = (byte) (qw2[i12] << 4);
                    i12++;
                } else {
                    int i16 = (i15 / 2) + i13;
                    bArr3[i16] = (byte) (((byte) (qw2[i12] & Ascii.SI)) | bArr3[i16]);
                    i12++;
                }
            }
            i13 += i11;
        }
        return o(bArr3, 4, 4);
    }

    public final void nn(int i2) throws IOException {
        if (i2 != 0) {
            this.f9622th = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = this.qw.read(this.f9622th, i3, i2 - i3);
                if (read >= 0) {
                    i3 += read;
                } else {
                    throw new RuntimeException(fe.when.ad.c.qw.ad("incomplete.palette", new Object[0]));
                }
            }
            this.when.put("palette", this.f9622th);
        }
    }

    public final i o(byte[] bArr, int i2, int i3) throws BadElementException {
        Cif ifVar = new Cif(this.vvv, this.xxx, 1, i2, bArr);
        k kVar = new k();
        kVar.qqq(s0.g2);
        kVar.qqq(s0.w0);
        byte[] i4 = i(i3);
        kVar.qqq(new v0((i4.length / 3) - 1));
        kVar.qqq(new w1(i4));
        x xVar = new x();
        xVar.h(s0.T, kVar);
        ifVar.v0(xVar);
        return ifVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f5, code lost:
        r1 = ((int) r9) * 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02f8, code lost:
        r0.f9616de = r2 + ((long) r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pf(java.io.InputStream r33, boolean r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            if (r34 != 0) goto L_0x0013
            boolean r2 = r1 instanceof java.io.BufferedInputStream
            if (r2 == 0) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r1)
            r0.qw = r2
            goto L_0x0015
        L_0x0013:
            r0.qw = r1
        L_0x0015:
            r1 = 0
            if (r34 != 0) goto L_0x0055
            java.io.InputStream r2 = r0.qw
            int r2 = r0.qqq(r2)
            r3 = 66
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.qw
            int r2 = r0.qqq(r2)
            r3 = 77
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.qw
            long r2 = r0.vvv(r2)
            r0.f9615ad = r2
            java.io.InputStream r2 = r0.qw
            r0.tt(r2)
            java.io.InputStream r2 = r0.qw
            r0.tt(r2)
            java.io.InputStream r2 = r0.qw
            long r2 = r0.vvv(r2)
            r0.f9616de = r2
            goto L_0x0055
        L_0x0047:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "invalid.magic.value.for.bmp.file"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r3, r1)
            r2.<init>(r1)
            throw r2
        L_0x0055:
            java.io.InputStream r2 = r0.qw
            long r2 = r0.vvv(r2)
            r4 = 12
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0072
            java.io.InputStream r4 = r0.qw
            int r4 = r0.tt(r4)
            r0.vvv = r4
            java.io.InputStream r4 = r0.qw
            int r4 = r0.tt(r4)
            r0.xxx = r4
            goto L_0x0082
        L_0x0072:
            java.io.InputStream r4 = r0.qw
            int r4 = r0.ddd(r4)
            r0.vvv = r4
            java.io.InputStream r4 = r0.qw
            int r4 = r0.ddd(r4)
            r0.xxx = r4
        L_0x0082:
            java.io.InputStream r4 = r0.qw
            int r4 = r0.tt(r4)
            java.io.InputStream r5 = r0.qw
            int r5 = r0.tt(r5)
            r0.f9618i = r5
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.when
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "color_planes"
            r5.put(r7, r4)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.when
            int r5 = r0.f9618i
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "bits_per_pixel"
            r4.put(r7, r5)
            long r4 = r0.f9616de
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00b2
            r0.f9616de = r2
        L_0x00b2:
            r5 = 24
            r9 = 14
            java.lang.String r13 = "bmp_version"
            r14 = 8
            r15 = 3
            r4 = 2
            r7 = 1
            r8 = 4
            if (r6 != 0) goto L_0x010b
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.when
            java.lang.String r11 = "BMP v. 2.x"
            r6.put(r13, r11)
            int r6 = r0.f9618i
            if (r6 != r7) goto L_0x00ce
            r0.f9624yj = r1
            goto L_0x00dc
        L_0x00ce:
            if (r6 != r8) goto L_0x00d3
            r0.f9624yj = r7
            goto L_0x00dc
        L_0x00d3:
            if (r6 != r14) goto L_0x00d8
            r0.f9624yj = r4
            goto L_0x00dc
        L_0x00d8:
            if (r6 != r5) goto L_0x00dc
            r0.f9624yj = r15
        L_0x00dc:
            long r5 = r0.f9616de
            long r9 = r5 - r9
            long r9 = r9 - r2
            r16 = 3
            long r9 = r9 / r16
            int r10 = (int) r9
            int r10 = r10 * 3
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x0106
            int r5 = r0.f9624yj
            if (r5 == 0) goto L_0x0100
            if (r5 == r7) goto L_0x00fd
            if (r5 == r4) goto L_0x00fa
            if (r5 == r15) goto L_0x00f8
            r5 = r10
            goto L_0x0101
        L_0x00f8:
            r5 = 0
            goto L_0x0101
        L_0x00fa:
            r5 = 768(0x300, float:1.076E-42)
            goto L_0x0101
        L_0x00fd:
            r5 = 48
            goto L_0x0101
        L_0x0100:
            r5 = 6
        L_0x0101:
            long r9 = (long) r5
            long r2 = r2 + r9
            r0.f9616de = r2
            r10 = r5
        L_0x0106:
            r0.nn(r10)
            goto L_0x057f
        L_0x010b:
            java.io.InputStream r6 = r0.qw
            long r9 = r0.vvv(r6)
            r0.f9617fe = r9
            java.io.InputStream r6 = r0.qw
            long r9 = r0.vvv(r6)
            r0.f9621rg = r9
            java.io.InputStream r6 = r0.qw
            int r6 = r0.ddd(r6)
            long r9 = (long) r6
            r0.ppp = r9
            java.io.InputStream r6 = r0.qw
            int r6 = r0.ddd(r6)
            long r9 = (long) r6
            r0.ggg = r9
            java.io.InputStream r6 = r0.qw
            long r9 = r0.vvv(r6)
            java.io.InputStream r6 = r0.qw
            long r20 = r0.vvv(r6)
            long r5 = r0.f9617fe
            int r6 = (int) r5
            java.lang.String r5 = "compression"
            if (r6 == 0) goto L_0x015f
            if (r6 == r7) goto L_0x0157
            if (r6 == r4) goto L_0x014f
            if (r6 == r15) goto L_0x0147
            goto L_0x0166
        L_0x0147:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.when
            java.lang.String r11 = "BI_BITFIELDS"
            r6.put(r5, r11)
            goto L_0x0166
        L_0x014f:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.when
            java.lang.String r11 = "BI_RLE4"
            r6.put(r5, r11)
            goto L_0x0166
        L_0x0157:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.when
            java.lang.String r11 = "BI_RLE8"
            r6.put(r5, r11)
            goto L_0x0166
        L_0x015f:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.when
            java.lang.String r11 = "BI_RGB"
            r6.put(r5, r11)
        L_0x0166:
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.when
            long r14 = r0.ppp
            java.lang.Long r11 = java.lang.Long.valueOf(r14)
            java.lang.String r14 = "x_pixels_per_meter"
            r5.put(r14, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.when
            long r14 = r0.ggg
            java.lang.Long r11 = java.lang.Long.valueOf(r14)
            java.lang.String r14 = "y_pixels_per_meter"
            r5.put(r14, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.when
            java.lang.Long r11 = java.lang.Long.valueOf(r9)
            java.lang.String r14 = "colors_used"
            r5.put(r14, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.when
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            java.lang.String r14 = "colors_important"
            r5.put(r14, r11)
            r14 = 40
            r20 = 52
            java.lang.String r5 = "alpha_mask"
            r22 = 56
            java.lang.String r11 = "blue_mask"
            java.lang.String r6 = "green_mask"
            java.lang.String r1 = "red_mask"
            int r24 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r24 == 0) goto L_0x03c6
            int r14 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r14 == 0) goto L_0x03c6
            int r14 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r14 != 0) goto L_0x01b2
            goto L_0x03c6
        L_0x01b2:
            r14 = 108(0x6c, double:5.34E-322)
            int r20 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r20 != 0) goto L_0x03b7
            java.util.HashMap<java.lang.String, java.lang.Object> r14 = r0.when
            java.lang.String r15 = "BMP v. 4.x"
            r14.put(r13, r15)
            java.io.InputStream r13 = r0.qw
            long r13 = r0.vvv(r13)
            int r14 = (int) r13
            r0.f9619o = r14
            java.io.InputStream r13 = r0.qw
            long r13 = r0.vvv(r13)
            int r14 = (int) r13
            r0.f9620pf = r14
            java.io.InputStream r13 = r0.qw
            long r13 = r0.vvv(r13)
            int r14 = (int) r13
            r0.f436if = r14
            java.io.InputStream r13 = r0.qw
            long r13 = r0.vvv(r13)
            int r14 = (int) r13
            r0.f437switch = r14
            java.io.InputStream r13 = r0.qw
            long r13 = r0.vvv(r13)
            java.io.InputStream r15 = r0.qw
            int r15 = r0.ddd(r15)
            java.io.InputStream r4 = r0.qw
            int r4 = r0.ddd(r4)
            java.io.InputStream r12 = r0.qw
            int r12 = r0.ddd(r12)
            java.io.InputStream r8 = r0.qw
            int r8 = r0.ddd(r8)
            java.io.InputStream r7 = r0.qw
            int r7 = r0.ddd(r7)
            r33 = r7
            java.io.InputStream r7 = r0.qw
            int r7 = r0.ddd(r7)
            r20 = r7
            java.io.InputStream r7 = r0.qw
            int r7 = r0.ddd(r7)
            r21 = r7
            java.io.InputStream r7 = r0.qw
            int r7 = r0.ddd(r7)
            r22 = r7
            java.io.InputStream r7 = r0.qw
            int r7 = r0.ddd(r7)
            r23 = r7
            java.io.InputStream r7 = r0.qw
            long r25 = r0.vvv(r7)
            java.io.InputStream r7 = r0.qw
            long r27 = r0.vvv(r7)
            java.io.InputStream r7 = r0.qw
            long r29 = r0.vvv(r7)
            int r7 = r0.f9618i
            r31 = r8
            r8 = 1
            if (r7 != r8) goto L_0x0247
            r7 = 10
            r0.f9624yj = r7
            goto L_0x0295
        L_0x0247:
            r8 = 4
            if (r7 != r8) goto L_0x024f
            r7 = 11
            r0.f9624yj = r7
            goto L_0x0295
        L_0x024f:
            r8 = 8
            if (r7 != r8) goto L_0x0258
            r7 = 12
            r0.f9624yj = r7
            goto L_0x0295
        L_0x0258:
            r8 = 16
            if (r7 != r8) goto L_0x0272
            r7 = 13
            r0.f9624yj = r7
            long r7 = r0.f9617fe
            int r8 = (int) r7
            if (r8 != 0) goto L_0x0295
            r7 = 31744(0x7c00, float:4.4483E-41)
            r0.f9619o = r7
            r7 = 992(0x3e0, float:1.39E-42)
            r0.f9620pf = r7
            r7 = 31
            r0.f436if = r7
            goto L_0x0295
        L_0x0272:
            r8 = 24
            if (r7 != r8) goto L_0x027b
            r7 = 14
            r0.f9624yj = r7
            goto L_0x0295
        L_0x027b:
            r8 = 32
            if (r7 != r8) goto L_0x0295
            r7 = 15
            r0.f9624yj = r7
            long r7 = r0.f9617fe
            int r8 = (int) r7
            if (r8 != 0) goto L_0x0295
            r7 = 16711680(0xff0000, float:2.3418052E-38)
            r0.f9619o = r7
            r7 = 65280(0xff00, float:9.1477E-41)
            r0.f9620pf = r7
            r7 = 255(0xff, float:3.57E-43)
            r0.f436if = r7
        L_0x0295:
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r8 = r0.f9619o
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.put(r1, r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r7 = r0.f9620pf
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r1.put(r6, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r6 = r0.f436if
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.put(r11, r6)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r6 = r0.f437switch
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.put(r5, r6)
            long r5 = r0.f9616de
            r7 = 14
            long r7 = r5 - r7
            long r7 = r7 - r2
            r18 = 4
            long r7 = r7 / r18
            int r1 = (int) r7
            r7 = 4
            int r1 = r1 * 4
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x02fc
            int r1 = r0.f9624yj
            switch(r1) {
                case 10: goto L_0x02ed;
                case 11: goto L_0x02e4;
                case 12: goto L_0x02db;
                default: goto L_0x02d9;
            }
        L_0x02d9:
            r1 = 0
            goto L_0x02f8
        L_0x02db:
            r5 = 0
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x02f5
            r9 = 256(0x100, double:1.265E-321)
            goto L_0x02f5
        L_0x02e4:
            r5 = 0
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x02f5
            r9 = 16
            goto L_0x02f5
        L_0x02ed:
            r5 = 0
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x02f5
            r9 = 2
        L_0x02f5:
            int r1 = (int) r9
            int r1 = r1 * 4
        L_0x02f8:
            long r5 = (long) r1
            long r2 = r2 + r5
            r0.f9616de = r2
        L_0x02fc:
            r0.nn(r1)
            int r1 = (int) r13
            java.lang.String r2 = "color_space"
            if (r1 == 0) goto L_0x0324
            r3 = 1
            if (r1 == r3) goto L_0x031b
            r3 = 2
            if (r1 == r3) goto L_0x030c
            goto L_0x057f
        L_0x030c:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r3 = "LCS_CMYK"
            r1.put(r2, r3)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x031b:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r3 = "LCS_sRGB"
            r1.put(r2, r3)
            goto L_0x057f
        L_0x0324:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r3 = "LCS_CALIBRATED_RGB"
            r1.put(r2, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            java.lang.String r3 = "redX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.String r3 = "redY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            java.lang.String r3 = "redZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r31)
            java.lang.String r3 = "greenX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r33)
            java.lang.String r3 = "greenY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            java.lang.String r3 = "greenZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)
            java.lang.String r3 = "blueX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r22)
            java.lang.String r3 = "blueY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Integer r2 = java.lang.Integer.valueOf(r23)
            java.lang.String r3 = "blueZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Long r2 = java.lang.Long.valueOf(r25)
            java.lang.String r3 = "gamma_red"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Long r2 = java.lang.Long.valueOf(r27)
            java.lang.String r3 = "gamma_green"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.Long r2 = java.lang.Long.valueOf(r29)
            java.lang.String r3 = "gamma_blue"
            r1.put(r3, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03b7:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r2 = "BMP v. 5.x"
            r1.put(r13, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "BMP version 5 not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03c6:
            r4 = r11
            long r7 = r0.f9617fe
            int r8 = (int) r7
            if (r8 == 0) goto L_0x0458
            r7 = 1
            if (r8 == r7) goto L_0x0458
            r7 = 2
            if (r8 == r7) goto L_0x0458
            r7 = 3
            if (r8 != r7) goto L_0x0450
            int r7 = r0.f9618i
            r8 = 16
            if (r7 != r8) goto L_0x03e0
            r8 = 8
            r0.f9624yj = r8
            goto L_0x03e8
        L_0x03e0:
            r11 = 32
            if (r7 != r11) goto L_0x03e8
            r7 = 9
            r0.f9624yj = r7
        L_0x03e8:
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f9619o = r7
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f9620pf = r7
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f436if = r7
            int r7 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r7 != 0) goto L_0x0419
            java.io.InputStream r2 = r0.qw
            long r2 = r0.vvv(r2)
            int r3 = (int) r2
            r0.f437switch = r3
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.when
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r5, r3)
        L_0x0419:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.when
            int r3 = r0.f9619o
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r1, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r2 = r0.f9620pf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r6, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r2 = r0.f436if
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r4, r2)
            r1 = 0
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0447
            int r1 = (int) r9
            r2 = 4
            int r1 = r1 * 4
            r0.nn(r1)
        L_0x0447:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r2 = "BMP v. 3.x NT"
            r1.put(r13, r2)
            goto L_0x057f
        L_0x0450:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Invalid compression specified in BMP file."
            r1.<init>(r2)
            throw r1
        L_0x0458:
            int r7 = r0.f9618i
            r12 = 1
            if (r7 != r12) goto L_0x0462
            r12 = 4
            r0.f9624yj = r12
            goto L_0x04e0
        L_0x0462:
            r12 = 4
            if (r7 != r12) goto L_0x046a
            r7 = 5
            r0.f9624yj = r7
            goto L_0x04e0
        L_0x046a:
            r8 = 8
            if (r7 != r8) goto L_0x0472
            r12 = 6
            r0.f9624yj = r12
            goto L_0x04e0
        L_0x0472:
            r11 = 24
            if (r7 != r11) goto L_0x047a
            r7 = 7
            r0.f9624yj = r7
            goto L_0x04e0
        L_0x047a:
            r11 = 16
            if (r7 != r11) goto L_0x04ac
            r0.f9624yj = r8
            r7 = 31744(0x7c00, float:4.4483E-41)
            r0.f9619o = r7
            r11 = 992(0x3e0, float:1.39E-42)
            r0.f9620pf = r11
            r11 = 31
            r0.f436if = r11
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.when
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r11.put(r1, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r11 = r0.f9620pf
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.put(r6, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r11 = r0.f436if
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.put(r4, r11)
            goto L_0x04e0
        L_0x04ac:
            r11 = 32
            if (r7 != r11) goto L_0x04e0
            r7 = 9
            r0.f9624yj = r7
            r7 = 16711680(0xff0000, float:2.3418052E-38)
            r0.f9619o = r7
            r11 = 65280(0xff00, float:9.1477E-41)
            r0.f9620pf = r11
            r11 = 255(0xff, float:3.57E-43)
            r0.f436if = r11
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.when
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r11.put(r1, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r11 = r0.f9620pf
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.put(r6, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r11 = r0.f436if
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.put(r4, r11)
        L_0x04e0:
            int r7 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r7 < 0) goto L_0x0520
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f9619o = r7
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f9620pf = r7
            java.io.InputStream r7 = r0.qw
            long r11 = r0.vvv(r7)
            int r7 = (int) r11
            r0.f436if = r7
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.when
            int r11 = r0.f9619o
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.put(r1, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r7 = r0.f9620pf
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r1.put(r6, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            int r6 = r0.f436if
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.put(r4, r6)
        L_0x0520:
            int r1 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x0536
            java.io.InputStream r1 = r0.qw
            long r6 = r0.vvv(r1)
            int r1 = (int) r6
            r0.f437switch = r1
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.when
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.put(r5, r1)
        L_0x0536:
            long r4 = r0.f9616de
            r6 = 14
            long r6 = r4 - r6
            long r6 = r6 - r2
            r11 = 4
            long r6 = r6 / r11
            int r1 = (int) r6
            r6 = 4
            int r1 = r1 * 4
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0575
            int r1 = r0.f9624yj
            if (r1 == r6) goto L_0x0566
            r4 = 5
            if (r1 == r4) goto L_0x055d
            r4 = 6
            if (r1 == r4) goto L_0x0554
            r1 = 0
            goto L_0x0571
        L_0x0554:
            r4 = 0
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x056e
            r9 = 256(0x100, double:1.265E-321)
            goto L_0x056e
        L_0x055d:
            r4 = 0
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x056e
            r9 = 16
            goto L_0x056e
        L_0x0566:
            r4 = 0
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x056e
            r9 = 2
        L_0x056e:
            int r1 = (int) r9
            int r1 = r1 * 4
        L_0x0571:
            long r4 = (long) r1
            long r2 = r2 + r4
            r0.f9616de = r2
        L_0x0575:
            r0.nn(r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.when
            java.lang.String r2 = "BMP v. 3.x"
            r1.put(r13, r2)
        L_0x057f:
            int r1 = r0.xxx
            if (r1 <= 0) goto L_0x0588
            r2 = 1
            r0.f9623uk = r2
            r3 = 0
            goto L_0x0592
        L_0x0588:
            r2 = 1
            r3 = 0
            r0.f9623uk = r3
            int r1 = java.lang.Math.abs(r1)
            r0.xxx = r1
        L_0x0592:
            int r1 = r0.f9618i
            if (r1 == r2) goto L_0x05aa
            r2 = 4
            if (r1 == r2) goto L_0x05aa
            r2 = 8
            if (r1 != r2) goto L_0x059e
            goto L_0x05aa
        L_0x059e:
            r2 = 16
            if (r1 != r2) goto L_0x05a3
            goto L_0x0607
        L_0x05a3:
            r2 = 32
            if (r1 != r2) goto L_0x0607
            int r1 = r0.f437switch
            goto L_0x0607
        L_0x05aa:
            int r1 = r0.f9624yj
            r2 = 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x05df
            r4 = 1
            if (r1 == r4) goto L_0x05df
            r4 = 2
            if (r1 != r4) goto L_0x05b7
            goto L_0x05df
        L_0x05b7:
            byte[] r1 = r0.f9622th
            int r1 = r1.length
            r4 = 4
            int r1 = r1 / r4
            if (r1 <= r2) goto L_0x05bf
            goto L_0x05c0
        L_0x05bf:
            r2 = r1
        L_0x05c0:
            byte[] r1 = new byte[r2]
            byte[] r4 = new byte[r2]
            byte[] r5 = new byte[r2]
        L_0x05c6:
            if (r3 >= r2) goto L_0x0607
            int r6 = r3 * 4
            byte[] r7 = r0.f9622th
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r4[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x05c6
        L_0x05df:
            byte[] r1 = r0.f9622th
            int r1 = r1.length
            r4 = 3
            int r1 = r1 / r4
            if (r1 <= r2) goto L_0x05e7
            goto L_0x05e8
        L_0x05e7:
            r2 = r1
        L_0x05e8:
            byte[] r1 = new byte[r2]
            byte[] r4 = new byte[r2]
            byte[] r5 = new byte[r2]
        L_0x05ee:
            if (r3 >= r2) goto L_0x0607
            int r6 = r3 * 3
            byte[] r7 = r0.f9622th
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r4[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x05ee
        L_0x0607:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.qw.pf(java.io.InputStream, boolean):void");
    }

    public final i ppp(int i2) throws IOException, BadElementException {
        int i3 = this.vvv;
        byte[] bArr = new byte[(((i3 + 1) / 2) * this.xxx)];
        int ceil = (int) Math.ceil(((double) i3) / 2.0d);
        int i4 = ceil % 4;
        int i5 = 0;
        int i6 = (i4 != 0 ? 4 - i4 : 0) + ceil;
        int i7 = this.xxx * i6;
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            i8 += this.qw.read(bArr2, i8, i7 - i8);
        }
        if (this.f9623uk) {
            while (i5 < this.xxx) {
                int i9 = i5 + 1;
                System.arraycopy(bArr2, i7 - (i9 * i6), bArr, i5 * ceil, ceil);
                i5 = i9;
            }
        } else {
            while (i5 < this.xxx) {
                System.arraycopy(bArr2, i5 * i6, bArr, i5 * ceil, ceil);
                i5++;
            }
        }
        return o(bArr, 4, i2);
    }

    public final int qqq(InputStream inputStream) throws IOException {
        return inputStream.read() & 255;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] qw(boolean r17, byte[] r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r0.vvv
            int r3 = r0.xxx
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            int r8 = r0.xxx     // Catch:{ RuntimeException -> 0x00c7 }
            if (r4 >= r8) goto L_0x00c7
            int r8 = r1.length     // Catch:{ RuntimeException -> 0x00c7 }
            if (r5 >= r8) goto L_0x00c7
            int r8 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r9 = 1
            if (r5 == 0) goto L_0x004f
            int r10 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00c7 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r17 == 0) goto L_0x0035
            r9 = r5
        L_0x002a:
            if (r9 == 0) goto L_0x004c
            int r11 = r7 + 1
            byte r12 = (byte) r8     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r12     // Catch:{ RuntimeException -> 0x00c7 }
            int r9 = r9 + -1
            r7 = r11
            goto L_0x002a
        L_0x0035:
            r11 = 0
        L_0x0036:
            if (r11 >= r5) goto L_0x004c
            int r12 = r7 + 1
            r13 = r11 & 1
            if (r13 != r9) goto L_0x0041
            r13 = r8 & 15
            goto L_0x0045
        L_0x0041:
            int r13 = r8 >>> 4
            r13 = r13 & 15
        L_0x0045:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r13     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + 1
            r7 = r12
            goto L_0x0036
        L_0x004c:
            int r6 = r6 + r5
            r5 = r10
            goto L_0x0011
        L_0x004f:
            int r5 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00c7 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r8 != r9) goto L_0x0059
            goto L_0x00c7
        L_0x0059:
            if (r8 == 0) goto L_0x00bd
            r10 = 2
            if (r8 == r10) goto L_0x00a8
            if (r17 == 0) goto L_0x0073
            r11 = r8
        L_0x0061:
            if (r11 == 0) goto L_0x0096
            int r12 = r7 + 1
            int r13 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r5     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + -1
            r7 = r12
            r5 = r13
            goto L_0x0061
        L_0x0073:
            r11 = 0
            r12 = 0
        L_0x0075:
            if (r11 >= r8) goto L_0x0096
            r13 = r11 & 1
            if (r13 != 0) goto L_0x0084
            int r12 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r15 = r12
            r12 = r5
            r5 = r15
        L_0x0084:
            int r14 = r7 + 1
            if (r13 != r9) goto L_0x008b
            r13 = r12 & 15
            goto L_0x008f
        L_0x008b:
            int r13 = r12 >>> 4
            r13 = r13 & 15
        L_0x008f:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r13     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + 1
            r7 = r14
            goto L_0x0075
        L_0x0096:
            int r6 = r6 + r8
            if (r17 == 0) goto L_0x009e
            r8 = r8 & 1
            if (r8 != r9) goto L_0x0011
            goto L_0x00a4
        L_0x009e:
            r8 = r8 & 3
            if (r8 == r9) goto L_0x00a4
            if (r8 != r10) goto L_0x0011
        L_0x00a4:
            int r5 = r5 + 1
            goto L_0x0011
        L_0x00a8:
            int r7 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r6 + r5
            int r5 = r7 + 1
            byte r7 = r1[r7]     // Catch:{ RuntimeException -> 0x00c7 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r7
            int r7 = r0.vvv     // Catch:{ RuntimeException -> 0x00c7 }
            int r7 = r7 * r4
            int r7 = r7 + r6
            goto L_0x0011
        L_0x00bd:
            int r4 = r4 + 1
            int r6 = r0.vvv     // Catch:{ RuntimeException -> 0x00c7 }
            int r6 = r6 * r4
            r7 = r6
            r6 = 0
            goto L_0x0011
        L_0x00c7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.qw.qw(boolean, byte[]):byte[]");
    }

    public final int rrr(InputStream inputStream) throws IOException {
        return ((qqq(inputStream) << 8) | qqq(inputStream)) & 65535;
    }

    /* renamed from: switch  reason: not valid java name */
    public final i m1102switch(int i2) throws IOException, BadElementException {
        int i3 = this.vvv;
        byte[] bArr = new byte[(((i3 + 7) / 8) * this.xxx)];
        int ceil = (int) Math.ceil(((double) i3) / 8.0d);
        int i4 = ceil % 4;
        int i5 = 0;
        int i6 = (i4 != 0 ? 4 - i4 : 0) + ceil;
        int i7 = this.xxx * i6;
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            i8 += this.qw.read(bArr2, i8, i7 - i8);
        }
        if (this.f9623uk) {
            while (i5 < this.xxx) {
                int i9 = i5 + 1;
                System.arraycopy(bArr2, i7 - (i9 * i6), bArr, i5 * ceil, ceil);
                i5 = i9;
            }
        } else {
            while (i5 < this.xxx) {
                System.arraycopy(bArr2, i5 * i6, bArr, i5 * ceil, ceil);
                i5++;
            }
        }
        return o(bArr, 1, i2);
    }

    public final int tt(InputStream inputStream) throws IOException {
        return rrr(inputStream);
    }

    public final long vvv(InputStream inputStream) throws IOException {
        return eee(inputStream);
    }

    public final void when(byte[] bArr) {
        int i2 = this.vvv * 24;
        int ceil = i2 % 32 != 0 ? (int) Math.ceil(((double) ((((i2 / 32) + 1) * 32) - i2)) / 8.0d) : 0;
        int i3 = (((this.vvv * 3) + 3) / 4) * 4 * this.xxx;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            try {
                int read = this.qw.read(bArr2, i4, i3 - i4);
                if (read < 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.f9623uk) {
            int i5 = ((this.vvv * this.xxx) * 3) - 1;
            int i6 = -ceil;
            int i7 = 0;
            while (i7 < this.xxx) {
                i7++;
                int i8 = (i5 - ((this.vvv * i7) * 3)) + 1;
                i6 += ceil;
                for (int i9 = 0; i9 < this.vvv; i9++) {
                    int i10 = i6 + 1;
                    bArr[i8 + 2] = bArr2[i6];
                    int i11 = i10 + 1;
                    bArr[i8 + 1] = bArr2[i10];
                    i6 = i11 + 1;
                    bArr[i8] = bArr2[i11];
                    i8 += 3;
                }
            }
            return;
        }
        int i12 = -ceil;
        int i13 = 0;
        for (int i14 = 0; i14 < this.xxx; i14++) {
            i12 += ceil;
            for (int i15 = 0; i15 < this.vvv; i15++) {
                int i16 = i12 + 1;
                bArr[i13 + 2] = bArr2[i12];
                int i17 = i16 + 1;
                bArr[i13 + 1] = bArr2[i16];
                i12 = i17 + 1;
                bArr[i13] = bArr2[i17];
                i13 += 3;
            }
        }
    }

    public final int xxx(InputStream inputStream) throws IOException {
        int qqq = qqq(inputStream);
        int qqq2 = qqq(inputStream);
        return (qqq(inputStream) << 24) | (qqq(inputStream) << 16) | (qqq2 << 8) | qqq;
    }
}
