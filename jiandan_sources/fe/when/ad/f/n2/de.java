package fe.when.ad.f.n2;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.Cif;
import fe.when.ad.f.k;
import fe.when.ad.f.s0;
import fe.when.ad.f.v0;
import fe.when.ad.f.w1;
import fe.when.ad.f.x;
import fe.when.ad.i;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class de {
    public int aaa;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f9561ad;
    public int ddd;

    /* renamed from: de  reason: collision with root package name */
    public boolean f9562de;
    public URL eee;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f9563fe;
    public byte[] ggg;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f9564i = new byte[256];

    /* renamed from: if  reason: not valid java name */
    public boolean f430if = false;
    public byte[] mmm;
    public byte[] nn;

    /* renamed from: o  reason: collision with root package name */
    public int f9565o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public int f9566pf = 0;
    public byte[] ppp;
    public byte[] qqq;
    public DataInputStream qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9567rg;
    public ArrayList<qw> rrr = new ArrayList<>();

    /* renamed from: switch  reason: not valid java name */
    public int f431switch;

    /* renamed from: th  reason: collision with root package name */
    public int f9568th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9569uk;
    public byte[] vvv;
    public short[] when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f9570yj;

    public static class qw {
        public i qw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public de(java.net.URL r7) throws java.io.IOException {
        /*
            r6 = this;
            r6.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r6.f9564i = r0
            r0 = 0
            r6.f9565o = r0
            r6.f9566pf = r0
            r6.f430if = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r6.rrr = r1
            r6.eee = r7
            java.io.InputStream r7 = r7.openStream()     // Catch:{ all -> 0x004e }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x004c }
            r1.<init>()     // Catch:{ all -> 0x004c }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x004c }
        L_0x0026:
            int r3 = r7.read(r2)     // Catch:{ all -> 0x004c }
            r4 = -1
            if (r3 == r4) goto L_0x0031
            r1.write(r2, r0, r3)     // Catch:{ all -> 0x004c }
            goto L_0x0026
        L_0x0031:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x004c }
            byte[] r2 = r1.toByteArray()     // Catch:{ all -> 0x004c }
            r0.<init>(r2)     // Catch:{ all -> 0x004c }
            r1.flush()     // Catch:{ all -> 0x0047 }
            r1.close()     // Catch:{ all -> 0x0047 }
            r6.fe(r0)     // Catch:{ all -> 0x0047 }
            r0.close()
            return
        L_0x0047:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            goto L_0x0050
        L_0x004e:
            r0 = move-exception
            r7 = 0
        L_0x0050:
            if (r7 == 0) goto L_0x0055
            r7.close()
        L_0x0055:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.de.<init>(java.net.URL):void");
    }

    public static int de(int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                return 4;
            }
            if (i2 != 4) {
                return 8;
            }
        }
        return i2;
    }

    public i ad(int i2) {
        return this.rrr.get(i2 - 1).qw;
    }

    public void fe(InputStream inputStream) throws IOException {
        this.qw = new DataInputStream(new BufferedInputStream(inputStream));
        i();
        yj();
        if (this.rrr.isEmpty()) {
            throw new IOException(fe.when.ad.c.qw.ad("the.file.does.not.contain.any.valid.image", new Object[0]));
        }
    }

    public void i() throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) this.qw.read());
        }
        if (sb.toString().startsWith("GIF8")) {
            pf();
            if (this.f9561ad) {
                this.nn = th(this.ddd);
                return;
            }
            return;
        }
        throw new IOException(fe.when.ad.c.qw.ad("gif.signature.nor.found", new Object[0]));
    }

    /* renamed from: if  reason: not valid java name */
    public int m1097if() throws IOException {
        return this.qw.read() | (this.qw.read() << 8);
    }

    public void o() throws IOException {
        this.f9567rg = m1097if();
        this.f9568th = m1097if();
        this.f9570yj = m1097if();
        this.f9569uk = m1097if();
        int read = this.qw.read();
        this.f9562de = (read & 128) != 0;
        this.f9563fe = (read & 64) != 0;
        int i2 = read & 7;
        this.xxx = de(this.ddd);
        if (this.f9562de) {
            int i3 = i2 + 1;
            this.mmm = th(i3);
            this.xxx = de(i3);
        } else {
            this.mmm = this.nn;
        }
        if (this.f430if && this.f431switch >= this.mmm.length / 3) {
            this.f430if = false;
        }
        if (this.f430if && this.xxx == 1) {
            byte[] bArr = new byte[12];
            System.arraycopy(this.mmm, 0, bArr, 0, 6);
            this.mmm = bArr;
            this.xxx = 2;
        }
        if (!qw()) {
            when();
        }
        try {
            Cif ifVar = new Cif(this.f9570yj, this.f9569uk, 1, this.xxx, this.vvv);
            k kVar = new k();
            kVar.qqq(s0.g2);
            kVar.qqq(s0.w0);
            kVar.qqq(new v0((this.mmm.length / 3) - 1));
            kVar.qqq(new w1(this.mmm));
            x xVar = new x();
            xVar.h(s0.T, kVar);
            ifVar.v0(xVar);
            if (this.f430if) {
                ifVar.H0(new int[]{this.f431switch, this.f431switch});
            }
            ifVar.D0(3);
            ifVar.C0(this.qqq);
            ifVar.I0(this.eee);
            qw qwVar = new qw();
            qwVar.qw = ifVar;
            this.rrr.add(qwVar);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void pf() throws IOException {
        m1097if();
        m1097if();
        int read = this.qw.read();
        this.f9561ad = (read & 128) != 0;
        this.ddd = (read & 7) + 1;
        this.qw.read();
        this.qw.read();
    }

    public boolean qw() throws IOException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        short s;
        int i7 = this.f9570yj * this.f9569uk;
        if (this.when == null) {
            this.when = new short[4096];
        }
        if (this.ppp == null) {
            this.ppp = new byte[4096];
        }
        if (this.ggg == null) {
            this.ggg = new byte[4097];
        }
        int i8 = 8;
        int i9 = ((this.f9570yj * this.xxx) + 7) / 8;
        this.aaa = i9;
        this.vvv = new byte[(i9 * this.f9569uk)];
        boolean z = true;
        if (!this.f9563fe) {
            i8 = 1;
        }
        int read = this.qw.read();
        int i10 = 1 << read;
        int i11 = i10 + 1;
        int i12 = i10 + 2;
        int i13 = read + 1;
        int i14 = (1 << i13) - 1;
        for (int i15 = 0; i15 < i10; i15++) {
            this.when[i15] = 0;
            this.ppp[i15] = (byte) i15;
        }
        int i16 = i13;
        int i17 = i12;
        int i18 = i14;
        byte b = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        byte b2 = 0;
        int i25 = 1;
        int i26 = 0;
        loop1:
        while (true) {
            int i27 = 0;
            while (i19 < i7) {
                if (i20 == 0) {
                    if (i21 >= i16) {
                        byte b3 = i22 & i18;
                        i22 >>= i16;
                        i21 -= i16;
                        if (b3 > i17 || b3 == i11) {
                            break loop1;
                        }
                        if (b3 == i10) {
                            i16 = i13;
                            i17 = i12;
                            i18 = i14;
                            b = -1;
                        } else if (b == -1) {
                            this.ggg[i20] = this.ppp[b3];
                            b = b3;
                            b2 = b;
                            i20++;
                            i7 = i7;
                        } else {
                            i4 = i7;
                            if (b3 == i17) {
                                i3 = i13;
                                this.ggg[i20] = (byte) b2;
                                s = b;
                                i20++;
                            } else {
                                i3 = i13;
                                s = b3;
                            }
                            while (s > i10) {
                                this.ggg[i20] = this.ppp[s];
                                s = this.when[s];
                                i20++;
                                b3 = b3;
                            }
                            byte b4 = b3;
                            byte[] bArr = this.ppp;
                            byte b5 = bArr[s] & 255;
                            if (i17 >= 4096) {
                                break loop1;
                            }
                            int i28 = i20 + 1;
                            i2 = i10;
                            byte b6 = (byte) b5;
                            this.ggg[i20] = b6;
                            this.when[i17] = (short) b;
                            bArr[i17] = b6;
                            i17++;
                            if ((i17 & i18) == 0 && i17 < 4096) {
                                i16++;
                                i18 += i17;
                            }
                            i20 = i28;
                            b = b4;
                            b2 = b5;
                        }
                        z = true;
                    } else {
                        if (i23 == 0) {
                            i23 = rg();
                            if (i23 <= 0) {
                                return z;
                            }
                            i24 = 0;
                        }
                        i22 += (this.f9564i[i24] & 255) << i21;
                        i21 += 8;
                        i24++;
                        i23--;
                    }
                } else {
                    i4 = i7;
                    i3 = i13;
                    i2 = i10;
                    byte b7 = b2;
                }
                i20--;
                i19++;
                int i29 = i26;
                int i30 = i27;
                m1098switch(i30, i29, this.ggg[i20]);
                int i31 = i30 + 1;
                if (i31 >= this.f9570yj) {
                    int i32 = i29 + i8;
                    int i33 = this.f9569uk;
                    if (i32 < i33) {
                        i26 = i32;
                    } else if (this.f9563fe) {
                        while (true) {
                            i5 = i25 + 1;
                            i6 = 2;
                            if (i5 == 2) {
                                i6 = 4;
                            } else if (i5 == 3) {
                                i8 = 4;
                            } else if (i5 != 4) {
                                i6 = this.f9569uk - 1;
                                i8 = 0;
                            } else {
                                i6 = 1;
                                i8 = 2;
                            }
                            if (i6 < this.f9569uk) {
                                break;
                            }
                            i25 = i5;
                        }
                        i26 = i6;
                        i25 = i5;
                    } else {
                        i26 = i33 - 1;
                        i7 = i4;
                        i13 = i3;
                        i10 = i2;
                        i8 = 0;
                        z = true;
                    }
                    i7 = i4;
                    i13 = i3;
                    i10 = i2;
                    z = true;
                } else {
                    i27 = i31;
                    i26 = i29;
                    i7 = i4;
                    i13 = i3;
                    i10 = i2;
                    z = true;
                }
            }
            break loop1;
        }
        return false;
    }

    public int rg() throws IOException {
        int read = this.qw.read();
        this.f9565o = read;
        if (read <= 0) {
            this.f9565o = 0;
            return 0;
        }
        int read2 = this.qw.read(this.f9564i, 0, read);
        this.f9565o = read2;
        return read2;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1098switch(int i2, int i3, int i4) {
        int i5 = this.xxx;
        if (i5 == 8) {
            this.vvv[i2 + (this.f9570yj * i3)] = (byte) i4;
            return;
        }
        int i6 = (this.aaa * i3) + (i2 / (8 / i5));
        byte[] bArr = this.vvv;
        bArr[i6] = (byte) ((i4 << ((8 - ((i2 % (8 / i5)) * i5)) - i5)) | bArr[i6]);
    }

    public byte[] th(int i2) throws IOException {
        byte[] bArr = new byte[((1 << de(i2)) * 3)];
        this.qw.readFully(bArr, 0, (1 << i2) * 3);
        return bArr;
    }

    public void uk() throws IOException {
        this.qw.read();
        int read = this.qw.read();
        int i2 = (read & 28) >> 2;
        this.f9566pf = i2;
        boolean z = true;
        if (i2 == 0) {
            this.f9566pf = 1;
        }
        if ((read & 1) == 0) {
            z = false;
        }
        this.f430if = z;
        m1097if();
        this.f431switch = this.qw.read();
        this.qw.read();
    }

    public void when() throws IOException {
        do {
            rg();
        } while (this.f9565o > 0);
    }

    public void yj() throws IOException {
        boolean z = false;
        while (!z) {
            int read = this.qw.read();
            if (read == 33) {
                int read2 = this.qw.read();
                if (read2 == 249) {
                    uk();
                } else if (read2 != 255) {
                    when();
                } else {
                    rg();
                    when();
                }
            } else if (read != 44) {
                z = true;
            } else {
                o();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public de(byte[] r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r2.f9564i = r0
            r0 = 0
            r2.f9565o = r0
            r2.f9566pf = r0
            r2.f430if = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.rrr = r0
            r2.qqq = r3
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0029 }
            r1.<init>(r3)     // Catch:{ all -> 0x0029 }
            r2.fe(r1)     // Catch:{ all -> 0x0026 }
            r1.close()
            return
        L_0x0026:
            r3 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0029:
            r3 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()
        L_0x002f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.de.<init>(byte[]):void");
    }
}
