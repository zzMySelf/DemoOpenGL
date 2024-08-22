package fe.when.ad.f.n2;

import fe.when.ad.a;
import fe.when.ad.f.k;
import fe.when.ad.f.m1;
import fe.when.ad.f.mmm;
import fe.when.ad.f.q0;
import fe.when.ad.f.rg;
import fe.when.ad.f.s0;
import fe.when.ad.f.v0;
import fe.when.ad.f.w1;
import fe.when.ad.f.x;
import fe.when.ad.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class th {
    public static final int[] j = {137, 80, 78, 71, 13, 10, 26, 10};
    public static final s0[] k = {s0.T3, s0.q4, s0.E4, s0.f455if};
    public float a;
    public int aaa;

    /* renamed from: ad  reason: collision with root package name */
    public DataInputStream f9640ad;
    public float b;
    public float c;
    public float d;
    public int ddd = -1;

    /* renamed from: de  reason: collision with root package name */
    public int f9641de;
    public float e;
    public boolean eee = false;
    public float f;

    /* renamed from: fe  reason: collision with root package name */
    public int f9642fe;
    public s0 g;
    public boolean ggg;
    public mmm h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f9643i;

    /* renamed from: if  reason: not valid java name */
    public qw f439if = new qw();
    public int mmm;
    public int nn = -1;

    /* renamed from: o  reason: collision with root package name */
    public byte[] f9644o;

    /* renamed from: pf  reason: collision with root package name */
    public byte[] f9645pf;
    public float ppp;
    public float qqq = 1.0f;
    public InputStream qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9646rg;
    public float rrr;

    /* renamed from: switch  reason: not valid java name */
    public int f440switch;

    /* renamed from: th  reason: collision with root package name */
    public int f9647th;
    public float tt;

    /* renamed from: uk  reason: collision with root package name */
    public x f9648uk = new x();
    public boolean vvv;
    public int when;
    public int xxx = -1;

    /* renamed from: yj  reason: collision with root package name */
    public int f9649yj;

    public static class qw extends ByteArrayOutputStream {
        public byte[] qw() {
            return this.buf;
        }
    }

    public th(InputStream inputStream) {
        this.qw = inputStream;
    }

    public static void ad(byte[] bArr, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + ((bArr2[i4] & 255) / 2));
        }
        for (int i5 = i3; i5 < i2; i5++) {
            bArr[i5] = (byte) ((bArr[i5] & 255) + (((bArr[i5 - i3] & 255) + (bArr2[i5] & 255)) / 2));
        }
    }

    public static void fe(byte[] bArr, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (bArr2[i4] & 255));
        }
        for (int i5 = i3; i5 < i2; i5++) {
            int i6 = i5 - i3;
            bArr[i5] = (byte) ((bArr[i5] & 255) + vvv(bArr[i6] & 255, bArr2[i5] & 255, bArr2[i6] & 255));
        }
    }

    public static final int ggg(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    /* renamed from: if  reason: not valid java name */
    public static i m1103if(byte[] bArr) throws IOException {
        i o2 = o(new ByteArrayInputStream(bArr));
        o2.C0(bArr);
        return o2;
    }

    public static void nn(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        if (i6 == 8) {
            int i9 = (i7 * i5) + (i4 * i3);
            while (i8 < i3) {
                bArr[i9 + i8] = (byte) iArr[i8 + i2];
                i8++;
            }
        } else if (i6 == 16) {
            int i10 = (i7 * i5) + (i4 * i3);
            while (i8 < i3) {
                bArr[i10 + i8] = (byte) (iArr[i8 + i2] >>> 8);
                i8++;
            }
        } else {
            int i11 = 8 / i6;
            int i12 = (i7 * i5) + (i4 / i11);
            bArr[i12] = (byte) ((iArr[i2] << ((8 - ((i4 % i11) * i6)) - i6)) | bArr[i12]);
        }
    }

    public static i o(InputStream inputStream) throws IOException {
        return new th(inputStream).i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i pf(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            fe.when.ad.i r1 = o(r0)     // Catch:{ all -> 0x0011 }
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
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.th.pf(java.net.URL):fe.when.ad.i");
    }

    public static final String ppp(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }

    /* renamed from: switch  reason: not valid java name */
    public static final int m1104switch(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    public static void th(byte[] bArr, int i2, int i3) {
        for (int i4 = i3; i4 < i2; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (bArr[i4 - i3] & 255));
        }
    }

    public static int vvv(int i2, int i3, int i4) {
        int i5 = (i2 + i3) - i4;
        int abs = Math.abs(i5 - i2);
        int abs2 = Math.abs(i5 - i3);
        int abs3 = Math.abs(i5 - i4);
        if (abs > abs2 || abs > abs3) {
            return abs2 <= abs3 ? i3 : i4;
        }
        return i2;
    }

    public static void yj(byte[] bArr, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr2[i3] & 255));
        }
    }

    public void ddd() throws IOException {
        int i2 = 0;
        while (true) {
            int[] iArr = j;
            if (i2 >= iArr.length) {
                int i3 = 4096;
                byte[] bArr = new byte[4096];
                while (true) {
                    int i4 = m1104switch(this.qw);
                    String ppp2 = ppp(this.qw);
                    if (i4 >= 0 && qw(ppp2)) {
                        if ("IDAT".equals(ppp2)) {
                            while (i4 != 0) {
                                int read = this.qw.read(bArr, 0, Math.min(i4, i3));
                                if (read >= 0) {
                                    this.f439if.write(bArr, 0, read);
                                    i4 -= read;
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else if ("tRNS".equals(ppp2)) {
                            int i5 = this.f9647th;
                            if (i5 != 0) {
                                if (i5 != 2) {
                                    if (i5 == 3 && i4 > 0) {
                                        this.f9645pf = new byte[i4];
                                        for (int i6 = 0; i6 < i4; i6++) {
                                            this.f9645pf[i6] = (byte) this.qw.read();
                                        }
                                        i4 = 0;
                                    }
                                } else if (i4 >= 6) {
                                    i4 -= 6;
                                    int ggg2 = ggg(this.qw);
                                    int ggg3 = ggg(this.qw);
                                    int ggg4 = ggg(this.qw);
                                    if (this.f9646rg == 16) {
                                        this.xxx = ggg2;
                                        this.ddd = ggg3;
                                        this.nn = ggg4;
                                    } else {
                                        this.f9648uk.h(s0.V2, new q0("[" + ggg2 + " " + ggg2 + " " + ggg3 + " " + ggg3 + " " + ggg4 + " " + ggg4 + "]"));
                                    }
                                }
                            } else if (i4 >= 2) {
                                i4 -= 2;
                                int ggg5 = ggg(this.qw);
                                if (this.f9646rg == 16) {
                                    this.xxx = ggg5;
                                } else {
                                    this.f9648uk.h(s0.V2, new q0("[" + ggg5 + " " + ggg5 + "]"));
                                }
                            }
                            a.i(this.qw, i4);
                        } else if ("IHDR".equals(ppp2)) {
                            this.f9641de = m1104switch(this.qw);
                            this.f9642fe = m1104switch(this.qw);
                            this.f9646rg = this.qw.read();
                            this.f9647th = this.qw.read();
                            this.qw.read();
                            this.qw.read();
                            this.f9649yj = this.qw.read();
                        } else {
                            boolean z = true;
                            if ("PLTE".equals(ppp2)) {
                                if (this.f9647th == 3) {
                                    k kVar = new k();
                                    kVar.qqq(s0.g2);
                                    kVar.qqq(uk());
                                    kVar.qqq(new v0((i4 / 3) - 1));
                                    rg rgVar = new rg();
                                    while (true) {
                                        int i7 = i4 - 1;
                                        if (i4 <= 0) {
                                            break;
                                        }
                                        rgVar.ppp(this.qw.read());
                                        i4 = i7;
                                    }
                                    kVar.qqq(new w1(rgVar.mmm()));
                                    this.f9648uk.h(s0.T, kVar);
                                } else {
                                    a.i(this.qw, i4);
                                }
                            } else if ("pHYs".equals(ppp2)) {
                                int i8 = m1104switch(this.qw);
                                int i9 = m1104switch(this.qw);
                                if (this.qw.read() == 1) {
                                    this.f440switch = (int) ((((float) i8) * 0.0254f) + 0.5f);
                                    this.when = (int) ((((float) i9) * 0.0254f) + 0.5f);
                                } else if (i9 != 0) {
                                    this.ppp = ((float) i8) / ((float) i9);
                                }
                            } else if ("cHRM".equals(ppp2)) {
                                this.rrr = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.tt = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.a = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.b = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.c = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.d = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.e = ((float) m1104switch(this.qw)) / 100000.0f;
                                this.f = ((float) m1104switch(this.qw)) / 100000.0f;
                                if (Math.abs(this.rrr) < 1.0E-4f || Math.abs(this.tt) < 1.0E-4f || Math.abs(this.a) < 1.0E-4f || Math.abs(this.b) < 1.0E-4f || Math.abs(this.c) < 1.0E-4f || Math.abs(this.d) < 1.0E-4f || Math.abs(this.e) < 1.0E-4f || Math.abs(this.f) < 1.0E-4f) {
                                    z = false;
                                }
                                this.eee = z;
                            } else if ("sRGB".equals(ppp2)) {
                                this.g = k[this.qw.read()];
                                this.qqq = 2.2f;
                                this.rrr = 0.3127f;
                                this.tt = 0.329f;
                                this.a = 0.64f;
                                this.b = 0.33f;
                                this.c = 0.3f;
                                this.d = 0.6f;
                                this.e = 0.15f;
                                this.f = 0.06f;
                                this.eee = true;
                            } else if ("gAMA".equals(ppp2)) {
                                int i10 = m1104switch(this.qw);
                                if (i10 != 0) {
                                    this.qqq = 100000.0f / ((float) i10);
                                    if (!this.eee) {
                                        this.rrr = 0.3127f;
                                        this.tt = 0.329f;
                                        this.a = 0.64f;
                                        this.b = 0.33f;
                                        this.c = 0.3f;
                                        this.d = 0.6f;
                                        this.e = 0.15f;
                                        this.f = 0.06f;
                                        this.eee = true;
                                    }
                                }
                            } else if ("iCCP".equals(ppp2)) {
                                do {
                                    i4--;
                                } while (this.qw.read() != 0);
                                this.qw.read();
                                int i11 = i4 - 1;
                                byte[] bArr2 = new byte[i11];
                                int i12 = 0;
                                while (i11 > 0) {
                                    int read2 = this.qw.read(bArr2, i12, i11);
                                    if (read2 >= 0) {
                                        i12 += read2;
                                        i11 -= read2;
                                    } else {
                                        throw new IOException(fe.when.ad.c.qw.ad("premature.end.of.file", new Object[0]));
                                    }
                                }
                                try {
                                    this.h = mmm.ad(m1.fe(bArr2, true));
                                } catch (RuntimeException unused) {
                                    this.h = null;
                                }
                            } else if (!"IEND".equals(ppp2)) {
                                a.i(this.qw, i4);
                            } else {
                                return;
                            }
                        }
                        a.i(this.qw, 4);
                        i3 = 4096;
                    }
                }
                throw new IOException(fe.when.ad.c.qw.ad("corrupted.png.file", new Object[0]));
            } else if (iArr[i2] == this.qw.read()) {
                i2++;
            } else {
                throw new IOException(fe.when.ad.c.qw.ad("file.is.not.a.valid.png", new Object[0]));
            }
        }
    }

    public void de() {
        int i2 = this.f9646rg;
        if (i2 == 16) {
            i2 = 8;
        }
        int i3 = -1;
        int i4 = this.f9646rg == 16 ? 2 : 1;
        this.aaa = i4;
        int i5 = this.f9647th;
        if (i5 == 0) {
            i3 = (((i2 * this.f9641de) + 7) / 8) * this.f9642fe;
        } else if (i5 == 6) {
            i3 = this.f9642fe * this.f9641de * 3;
            this.aaa = i4 * 4;
        } else if (i5 == 2) {
            i3 = this.f9642fe * this.f9641de * 3;
            this.aaa = i4 * 3;
        } else if (i5 == 3) {
            if (this.f9649yj == 1) {
                i3 = (((i2 * this.f9641de) + 7) / 8) * this.f9642fe;
            }
            this.aaa = 1;
        } else if (i5 == 4) {
            i3 = this.f9642fe * this.f9641de;
            this.aaa = i4 * 2;
        }
        if (i3 >= 0) {
            this.f9643i = new byte[i3];
        }
        if (this.vvv) {
            this.f9644o = new byte[(this.f9641de * this.f9642fe)];
        } else if (this.ggg) {
            this.f9644o = new byte[(((this.f9641de + 7) / 8) * this.f9642fe)];
        }
        this.f9640ad = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.f439if.qw(), 0, this.f439if.size()), new Inflater()));
        if (this.f9649yj != 1) {
            rg(0, 0, 1, 1, this.f9641de, this.f9642fe);
            return;
        }
        rg(0, 0, 8, 8, (this.f9641de + 7) / 8, (this.f9642fe + 7) / 8);
        rg(4, 0, 8, 8, (this.f9641de + 3) / 8, (this.f9642fe + 7) / 8);
        rg(0, 4, 4, 8, (this.f9641de + 3) / 4, (this.f9642fe + 3) / 8);
        rg(2, 0, 4, 4, (this.f9641de + 1) / 4, (this.f9642fe + 3) / 4);
        rg(0, 2, 2, 4, (this.f9641de + 1) / 2, (this.f9642fe + 1) / 4);
        rg(1, 0, 2, 2, this.f9641de / 2, (this.f9642fe + 1) / 2);
        rg(0, 1, 1, 2, this.f9641de, this.f9642fe / 2);
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [fe.when.ad.i] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.i i() throws java.io.IOException {
        /*
            r13 = this;
            r13.ddd()
            r0 = 0
            r13.vvv = r0     // Catch:{ Exception -> 0x01aa }
            byte[] r1 = r13.f9645pf     // Catch:{ Exception -> 0x01aa }
            r2 = 1
            if (r1 == 0) goto L_0x0029
            r1 = 0
            r3 = 0
            r4 = 0
        L_0x000e:
            byte[] r5 = r13.f9645pf     // Catch:{ Exception -> 0x01aa }
            int r5 = r5.length     // Catch:{ Exception -> 0x01aa }
            if (r1 >= r5) goto L_0x002b
            byte[] r5 = r13.f9645pf     // Catch:{ Exception -> 0x01aa }
            byte r5 = r5[r1]     // Catch:{ Exception -> 0x01aa }
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x001f
            int r3 = r3 + 1
            r4 = r1
        L_0x001f:
            if (r5 == 0) goto L_0x0026
            if (r5 == r6) goto L_0x0026
            r13.vvv = r2     // Catch:{ Exception -> 0x01aa }
            goto L_0x002b
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x0029:
            r3 = 0
            r4 = 0
        L_0x002b:
            int r1 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            r5 = 4
            r1 = r1 & r5
            if (r1 == 0) goto L_0x0033
            r13.vvv = r2     // Catch:{ Exception -> 0x01aa }
        L_0x0033:
            boolean r1 = r13.vvv     // Catch:{ Exception -> 0x01aa }
            if (r1 != 0) goto L_0x003f
            if (r3 > r2) goto L_0x003d
            int r1 = r13.xxx     // Catch:{ Exception -> 0x01aa }
            if (r1 < 0) goto L_0x003f
        L_0x003d:
            r1 = 1
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            r13.ggg = r1     // Catch:{ Exception -> 0x01aa }
            boolean r6 = r13.vvv     // Catch:{ Exception -> 0x01aa }
            if (r6 != 0) goto L_0x0074
            if (r1 != 0) goto L_0x0074
            if (r3 != r2) goto L_0x0074
            fe.when.ad.f.x r1 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.V2     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.q0 r6 = new fe.when.ad.f.q0     // Catch:{ Exception -> 0x01aa }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01aa }
            r7.<init>()     // Catch:{ Exception -> 0x01aa }
            java.lang.String r8 = "["
            r7.append(r8)     // Catch:{ Exception -> 0x01aa }
            r7.append(r4)     // Catch:{ Exception -> 0x01aa }
            java.lang.String r8 = " "
            r7.append(r8)     // Catch:{ Exception -> 0x01aa }
            r7.append(r4)     // Catch:{ Exception -> 0x01aa }
            java.lang.String r4 = "]"
            r7.append(r4)     // Catch:{ Exception -> 0x01aa }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x01aa }
            r6.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x01aa }
            r1.h(r3, r6)     // Catch:{ Exception -> 0x01aa }
        L_0x0074:
            int r1 = r13.f9649yj     // Catch:{ Exception -> 0x01aa }
            r3 = 16
            if (r1 == r2) goto L_0x008b
            int r1 = r13.f9646rg     // Catch:{ Exception -> 0x01aa }
            if (r1 == r3) goto L_0x008b
            int r1 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            r1 = r1 & r5
            if (r1 != 0) goto L_0x008b
            boolean r1 = r13.vvv     // Catch:{ Exception -> 0x01aa }
            if (r1 != 0) goto L_0x008b
            boolean r1 = r13.ggg     // Catch:{ Exception -> 0x01aa }
            if (r1 == 0) goto L_0x008c
        L_0x008b:
            r0 = 1
        L_0x008c:
            int r1 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            r4 = 2
            r6 = 3
            if (r1 == 0) goto L_0x00a8
            r7 = 6
            if (r1 == r7) goto L_0x00a5
            if (r1 == r4) goto L_0x00a2
            if (r1 == r6) goto L_0x009f
            if (r1 == r5) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            r13.mmm = r4     // Catch:{ Exception -> 0x01aa }
            goto L_0x00aa
        L_0x009f:
            r13.mmm = r2     // Catch:{ Exception -> 0x01aa }
            goto L_0x00aa
        L_0x00a2:
            r13.mmm = r6     // Catch:{ Exception -> 0x01aa }
            goto L_0x00aa
        L_0x00a5:
            r13.mmm = r5     // Catch:{ Exception -> 0x01aa }
            goto L_0x00aa
        L_0x00a8:
            r13.mmm = r2     // Catch:{ Exception -> 0x01aa }
        L_0x00aa:
            if (r0 == 0) goto L_0x00af
            r13.de()     // Catch:{ Exception -> 0x01aa }
        L_0x00af:
            int r0 = r13.mmm     // Catch:{ Exception -> 0x01aa }
            int r1 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            r1 = r1 & r5
            if (r1 == 0) goto L_0x00b8
            int r0 = r0 + -1
        L_0x00b8:
            r10 = r0
            int r0 = r13.f9646rg     // Catch:{ Exception -> 0x01aa }
            r1 = 8
            if (r0 != r3) goto L_0x00c2
            r11 = 8
            goto L_0x00c3
        L_0x00c2:
            r11 = r0
        L_0x00c3:
            byte[] r0 = r13.f9643i     // Catch:{ Exception -> 0x01aa }
            if (r0 == 0) goto L_0x00e3
            int r0 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            if (r0 != r6) goto L_0x00d8
            fe.when.ad.if r0 = new fe.when.ad.if     // Catch:{ Exception -> 0x01aa }
            int r8 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            int r9 = r13.f9642fe     // Catch:{ Exception -> 0x01aa }
            byte[] r12 = r13.f9643i     // Catch:{ Exception -> 0x01aa }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01aa }
            goto L_0x013a
        L_0x00d8:
            int r0 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            int r3 = r13.f9642fe     // Catch:{ Exception -> 0x01aa }
            byte[] r5 = r13.f9643i     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.i r0 = fe.when.ad.i.E(r0, r3, r10, r11, r5)     // Catch:{ Exception -> 0x01aa }
            goto L_0x013a
        L_0x00e3:
            fe.when.ad.if r0 = new fe.when.ad.if     // Catch:{ Exception -> 0x01aa }
            int r8 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            int r9 = r13.f9642fe     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.n2.th$qw r3 = r13.f439if     // Catch:{ Exception -> 0x01aa }
            byte[] r12 = r3.toByteArray()     // Catch:{ Exception -> 0x01aa }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01aa }
            r0.x0(r2)     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.x r3 = new fe.when.ad.f.x     // Catch:{ Exception -> 0x01aa }
            r3.<init>()     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.p     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0     // Catch:{ Exception -> 0x01aa }
            int r8 = r13.f9646rg     // Catch:{ Exception -> 0x01aa }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r7)     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.W3     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0     // Catch:{ Exception -> 0x01aa }
            r8 = 15
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r7)     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.Y     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0     // Catch:{ Exception -> 0x01aa }
            int r8 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r7)     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.S     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0     // Catch:{ Exception -> 0x01aa }
            int r8 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            if (r8 == r6) goto L_0x012c
            int r8 = r13.f9647th     // Catch:{ Exception -> 0x01aa }
            r8 = r8 & r4
            if (r8 != 0) goto L_0x012d
        L_0x012c:
            r6 = 1
        L_0x012d:
            r7.<init>((int) r6)     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r7)     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.x r5 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r6 = fe.when.ad.f.s0.p0     // Catch:{ Exception -> 0x01aa }
            r5.h(r6, r3)     // Catch:{ Exception -> 0x01aa }
        L_0x013a:
            fe.when.ad.f.x r3 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.T     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.y0 r3 = r3.qqq(r5)     // Catch:{ Exception -> 0x01aa }
            if (r3 != 0) goto L_0x014f
            fe.when.ad.f.x r3 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.T     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.y0 r6 = r13.uk()     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r6)     // Catch:{ Exception -> 0x01aa }
        L_0x014f:
            fe.when.ad.f.s0 r3 = r13.g     // Catch:{ Exception -> 0x01aa }
            if (r3 == 0) goto L_0x015c
            fe.when.ad.f.x r3 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.i2     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.f.s0 r6 = r13.g     // Catch:{ Exception -> 0x01aa }
            r3.h(r5, r6)     // Catch:{ Exception -> 0x01aa }
        L_0x015c:
            fe.when.ad.f.x r3 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            int r3 = r3.size()     // Catch:{ Exception -> 0x01aa }
            if (r3 <= 0) goto L_0x0169
            fe.when.ad.f.x r3 = r13.f9648uk     // Catch:{ Exception -> 0x01aa }
            r0.v0(r3)     // Catch:{ Exception -> 0x01aa }
        L_0x0169:
            fe.when.ad.f.mmm r3 = r13.h     // Catch:{ Exception -> 0x01aa }
            if (r3 == 0) goto L_0x0172
            fe.when.ad.f.mmm r3 = r13.h     // Catch:{ Exception -> 0x01aa }
            r0.L0(r3)     // Catch:{ Exception -> 0x01aa }
        L_0x0172:
            boolean r3 = r13.vvv     // Catch:{ Exception -> 0x01aa }
            if (r3 == 0) goto L_0x0186
            int r3 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            int r5 = r13.f9642fe     // Catch:{ Exception -> 0x01aa }
            byte[] r6 = r13.f9644o     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.i r1 = fe.when.ad.i.E(r3, r5, r2, r1, r6)     // Catch:{ Exception -> 0x01aa }
            r1.n0()     // Catch:{ Exception -> 0x01aa }
            r0.z0(r1)     // Catch:{ Exception -> 0x01aa }
        L_0x0186:
            boolean r1 = r13.ggg     // Catch:{ Exception -> 0x01aa }
            if (r1 == 0) goto L_0x019a
            int r1 = r13.f9641de     // Catch:{ Exception -> 0x01aa }
            int r3 = r13.f9642fe     // Catch:{ Exception -> 0x01aa }
            byte[] r5 = r13.f9644o     // Catch:{ Exception -> 0x01aa }
            fe.when.ad.i r1 = fe.when.ad.i.E(r1, r3, r2, r2, r5)     // Catch:{ Exception -> 0x01aa }
            r1.n0()     // Catch:{ Exception -> 0x01aa }
            r0.z0(r1)     // Catch:{ Exception -> 0x01aa }
        L_0x019a:
            int r1 = r13.f440switch     // Catch:{ Exception -> 0x01aa }
            int r2 = r13.when     // Catch:{ Exception -> 0x01aa }
            r0.y0(r1, r2)     // Catch:{ Exception -> 0x01aa }
            float r1 = r13.ppp     // Catch:{ Exception -> 0x01aa }
            r0.K0(r1)     // Catch:{ Exception -> 0x01aa }
            r0.D0(r4)     // Catch:{ Exception -> 0x01aa }
            return r0
        L_0x01aa:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.th.i():fe.when.ad.i");
    }

    public boolean qw(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public void rg(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = i7;
        if (i6 != 0 && i9 != 0) {
            int i10 = (((this.mmm * i6) * this.f9646rg) + 7) / 8;
            int i11 = i3;
            byte[] bArr = new byte[i10];
            byte[] bArr2 = new byte[i10];
            int i12 = 0;
            while (i12 < i9) {
                try {
                    i8 = this.f9640ad.read();
                    try {
                        this.f9640ad.readFully(bArr, 0, i10);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i8 = 0;
                }
                if (i8 != 0) {
                    if (i8 == 1) {
                        th(bArr, i10, this.aaa);
                    } else if (i8 == 2) {
                        yj(bArr, bArr2, i10);
                    } else if (i8 == 3) {
                        ad(bArr, bArr2, i10, this.aaa);
                    } else if (i8 == 4) {
                        fe(bArr, bArr2, i10, this.aaa);
                    } else {
                        throw new RuntimeException(fe.when.ad.c.qw.ad("png.filter.unknown", new Object[0]));
                    }
                }
                xxx(bArr, i2, i4, i11, i6);
                i12++;
                i11 += i5;
                byte[] bArr3 = bArr2;
                bArr2 = bArr;
                bArr = bArr3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: fe.when.ad.f.q0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: fe.when.ad.f.q0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: fe.when.ad.f.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: fe.when.ad.f.q0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.f.y0 uk() {
        /*
            r19 = this;
            r0 = r19
            fe.when.ad.f.mmm r1 = r0.h
            if (r1 == 0) goto L_0x0012
            int r1 = r0.f9647th
            r1 = r1 & 2
            if (r1 != 0) goto L_0x000f
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.v0
            return r1
        L_0x000f:
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.w0
            return r1
        L_0x0012:
            float r1 = r0.qqq
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002a
            boolean r1 = r0.eee
            if (r1 != 0) goto L_0x002a
            int r1 = r0.f9647th
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0027
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.v0
            return r1
        L_0x0027:
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.w0
            return r1
        L_0x002a:
            fe.when.ad.f.k r1 = new fe.when.ad.f.k
            r1.<init>()
            fe.when.ad.f.x r3 = new fe.when.ad.f.x
            r3.<init>()
            int r4 = r0.f9647th
            r4 = r4 & 2
            java.lang.String r5 = "[1 1 1]"
            if (r4 != 0) goto L_0x0065
            float r4 = r0.qqq
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0045
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.v0
            return r1
        L_0x0045:
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.A
            r1.qqq(r2)
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.C1
            fe.when.ad.f.v0 r4 = new fe.when.ad.f.v0
            float r6 = r0.qqq
            r4.<init>((float) r6)
            r3.h(r2, r4)
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.p6
            fe.when.ad.f.q0 r4 = new fe.when.ad.f.q0
            r4.<init>((java.lang.String) r5)
            r3.h(r2, r4)
            r1.qqq(r3)
            goto L_0x018c
        L_0x0065:
            fe.when.ad.f.q0 r4 = new fe.when.ad.f.q0
            r4.<init>((java.lang.String) r5)
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.B
            r1.qqq(r5)
            float r5 = r0.qqq
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x008f
            fe.when.ad.f.k r5 = new fe.when.ad.f.k
            r5.<init>()
            fe.when.ad.f.v0 r6 = new fe.when.ad.f.v0
            float r7 = r0.qqq
            r6.<init>((float) r7)
            r5.qqq(r6)
            r5.qqq(r6)
            r5.qqq(r6)
            fe.when.ad.f.s0 r6 = fe.when.ad.f.s0.C1
            r3.h(r6, r5)
        L_0x008f:
            boolean r5 = r0.eee
            if (r5 == 0) goto L_0x0184
            float r4 = r0.tt
            float r5 = r0.c
            float r6 = r0.e
            float r7 = r5 - r6
            float r8 = r0.b
            float r7 = r7 * r8
            float r9 = r0.a
            float r10 = r9 - r6
            float r11 = r0.d
            float r10 = r10 * r11
            float r7 = r7 - r10
            float r10 = r9 - r5
            float r12 = r0.f
            float r10 = r10 * r12
            float r7 = r7 + r10
            float r7 = r7 * r4
            float r10 = r5 - r6
            float r10 = r10 * r4
            float r13 = r0.rrr
            float r14 = r13 - r6
            float r14 = r14 * r11
            float r10 = r10 - r14
            float r14 = r13 - r5
            float r14 = r14 * r12
            float r10 = r10 + r14
            float r10 = r10 * r8
            float r10 = r10 / r7
            float r14 = r10 * r9
            float r14 = r14 / r8
            float r15 = r2 - r9
            float r15 = r15 / r8
            float r15 = r15 - r2
            float r15 = r15 * r10
            float r2 = -r11
            float r17 = r9 - r6
            float r17 = r17 * r4
            float r18 = r13 - r6
            float r18 = r18 * r8
            float r17 = r17 - r18
            float r8 = r13 - r9
            float r8 = r8 * r12
            float r17 = r17 + r8
            float r2 = r2 * r17
            float r2 = r2 / r7
            float r8 = r2 * r5
            float r8 = r8 / r11
            r16 = 1065353216(0x3f800000, float:1.0)
            float r17 = r16 - r5
            float r17 = r17 / r11
            float r17 = r17 - r16
            float r0 = r2 * r17
            float r17 = r9 - r5
            float r17 = r17 * r4
            float r5 = r13 - r5
            float r5 = r5 * r4
            float r17 = r17 - r5
            float r13 = r13 - r9
            float r13 = r13 * r11
            float r17 = r17 + r13
            float r17 = r17 * r12
            float r4 = r17 / r7
            float r5 = r4 * r6
            float r5 = r5 / r12
            r7 = 1065353216(0x3f800000, float:1.0)
            float r6 = r7 - r6
            float r6 = r6 / r12
            float r6 = r6 - r7
            float r6 = r6 * r4
            float r7 = r14 + r8
            float r7 = r7 + r5
            float r9 = r15 + r0
            float r9 = r9 + r6
            fe.when.ad.f.k r11 = new fe.when.ad.f.k
            r11.<init>()
            fe.when.ad.f.v0 r12 = new fe.when.ad.f.v0
            r12.<init>((float) r7)
            r11.qqq(r12)
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0
            r12 = 1065353216(0x3f800000, float:1.0)
            r7.<init>((float) r12)
            r11.qqq(r7)
            fe.when.ad.f.v0 r7 = new fe.when.ad.f.v0
            r7.<init>((float) r9)
            r11.qqq(r7)
            fe.when.ad.f.k r7 = new fe.when.ad.f.k
            r7.<init>()
            fe.when.ad.f.v0 r9 = new fe.when.ad.f.v0
            r9.<init>((float) r14)
            r7.qqq(r9)
            fe.when.ad.f.v0 r9 = new fe.when.ad.f.v0
            r9.<init>((float) r10)
            r7.qqq(r9)
            fe.when.ad.f.v0 r9 = new fe.when.ad.f.v0
            r9.<init>((float) r15)
            r7.qqq(r9)
            fe.when.ad.f.v0 r9 = new fe.when.ad.f.v0
            r9.<init>((float) r8)
            r7.qqq(r9)
            fe.when.ad.f.v0 r8 = new fe.when.ad.f.v0
            r8.<init>((float) r2)
            r7.qqq(r8)
            fe.when.ad.f.v0 r2 = new fe.when.ad.f.v0
            r2.<init>((float) r0)
            r7.qqq(r2)
            fe.when.ad.f.v0 r0 = new fe.when.ad.f.v0
            r0.<init>((float) r5)
            r7.qqq(r0)
            fe.when.ad.f.v0 r0 = new fe.when.ad.f.v0
            r0.<init>((float) r4)
            r7.qqq(r0)
            fe.when.ad.f.v0 r0 = new fe.when.ad.f.v0
            r0.<init>((float) r6)
            r7.qqq(r0)
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.R2
            r3.h(r0, r7)
            r4 = r11
        L_0x0184:
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.p6
            r3.h(r0, r4)
            r1.qqq(r3)
        L_0x018c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.th.uk():fe.when.ad.f.y0");
    }

    public int[] when(byte[] bArr) {
        int i2 = this.f9646rg;
        int i3 = 0;
        if (i2 == 8) {
            int length = bArr.length;
            int[] iArr = new int[length];
            while (i3 < length) {
                iArr[i3] = bArr[i3] & 255;
                i3++;
            }
            return iArr;
        } else if (i2 != 16) {
            int[] iArr2 = new int[((bArr.length * 8) / i2)];
            int i4 = 8 / i2;
            int i5 = (1 << i2) - 1;
            int i6 = 0;
            while (i3 < bArr.length) {
                int i7 = i4 - 1;
                while (i7 >= 0) {
                    iArr2[i6] = (bArr[i3] >>> (this.f9646rg * i7)) & i5;
                    i7--;
                    i6++;
                }
                i3++;
            }
            return iArr2;
        } else {
            int length2 = bArr.length / 2;
            int[] iArr3 = new int[length2];
            while (i3 < length2) {
                int i8 = i3 * 2;
                iArr3[i3] = ((bArr[i8] & 255) << 8) + (bArr[i8 + 1] & 255);
                i3++;
            }
            return iArr3;
        }
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v19, types: [byte] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void xxx(byte[] r27, int r28, int r29, int r30, int r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r31
            int[] r10 = r26.when(r27)
            int r2 = r0.f9647th
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            r15 = 0
            if (r2 == 0) goto L_0x0020
            r3 = 6
            if (r2 == r3) goto L_0x001d
            if (r2 == r13) goto L_0x001d
            if (r2 == r12) goto L_0x0020
            if (r2 == r11) goto L_0x0020
            r16 = 0
            goto L_0x0022
        L_0x001d:
            r16 = 3
            goto L_0x0022
        L_0x0020:
            r16 = 1
        L_0x0022:
            byte[] r2 = r0.f9643i
            r9 = 16
            r17 = 8
            if (r2 == 0) goto L_0x0063
            int r2 = r0.f9641de
            int r2 = r2 * r16
            int r3 = r0.f9646rg
            if (r3 != r9) goto L_0x0034
            r3 = 8
        L_0x0034:
            int r2 = r2 * r3
            int r2 = r2 + 7
            int r18 = r2 / 8
            r19 = r28
            r8 = 0
        L_0x003d:
            if (r8 >= r1) goto L_0x0063
            byte[] r2 = r0.f9643i
            int r3 = r0.mmm
            int r4 = r3 * r8
            int r7 = r0.f9646rg
            r3 = r10
            r5 = r16
            r6 = r19
            r20 = r7
            r7 = r30
            r21 = r8
            r8 = r20
            r12 = 16
            r9 = r18
            nn(r2, r3, r4, r5, r6, r7, r8, r9)
            int r19 = r19 + r29
            int r8 = r21 + 1
            r9 = 16
            r12 = 3
            goto L_0x003d
        L_0x0063:
            r12 = 16
            boolean r2 = r0.vvv
            if (r2 == 0) goto L_0x00ce
            int r2 = r0.f9647th
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a2
            int r2 = r0.f9646rg
            if (r2 != r12) goto L_0x0084
            r2 = 0
        L_0x0073:
            if (r2 >= r1) goto L_0x0084
            int r3 = r0.mmm
            int r3 = r3 * r2
            int r3 = r3 + r16
            r4 = r10[r3]
            int r4 = r4 >>> 8
            r10[r3] = r4
            int r2 = r2 + 1
            goto L_0x0073
        L_0x0084:
            int r11 = r0.f9641de
            r12 = r28
        L_0x0088:
            if (r15 >= r1) goto L_0x018c
            byte[] r2 = r0.f9644o
            int r3 = r0.mmm
            int r3 = r3 * r15
            int r4 = r3 + r16
            r5 = 1
            r8 = 8
            r3 = r10
            r6 = r12
            r7 = r30
            r9 = r11
            nn(r2, r3, r4, r5, r6, r7, r8, r9)
            int r12 = r12 + r29
            int r15 = r15 + 1
            goto L_0x0088
        L_0x00a2:
            int r11 = r0.f9641de
            int[] r12 = new int[r14]
            r13 = r28
            r14 = 0
        L_0x00a9:
            if (r14 >= r1) goto L_0x018c
            r2 = r10[r14]
            byte[] r3 = r0.f9645pf
            int r4 = r3.length
            if (r2 >= r4) goto L_0x00b7
            byte r2 = r3[r2]
            r12[r15] = r2
            goto L_0x00bb
        L_0x00b7:
            r2 = 255(0xff, float:3.57E-43)
            r12[r15] = r2
        L_0x00bb:
            byte[] r2 = r0.f9644o
            r4 = 0
            r5 = 1
            r8 = 8
            r3 = r12
            r6 = r13
            r7 = r30
            r9 = r11
            nn(r2, r3, r4, r5, r6, r7, r8, r9)
            int r13 = r13 + r29
            int r14 = r14 + 1
            goto L_0x00a9
        L_0x00ce:
            boolean r2 = r0.ggg
            if (r2 == 0) goto L_0x018c
            int r2 = r0.f9647th
            if (r2 == 0) goto L_0x015a
            if (r2 == r13) goto L_0x0114
            r3 = 3
            if (r2 == r3) goto L_0x00dd
            goto L_0x018c
        L_0x00dd:
            int r2 = r0.f9641de
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x00e8:
            if (r5 >= r1) goto L_0x018c
            r6 = r10[r5]
            byte[] r7 = r0.f9645pf
            int r8 = r7.length
            if (r6 >= r8) goto L_0x00f7
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x00f7
            r6 = 1
            goto L_0x00f8
        L_0x00f7:
            r6 = 0
        L_0x00f8:
            r3[r15] = r6
            byte[] r6 = r0.f9644o
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            nn(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x00e8
        L_0x0114:
            int r2 = r0.f9641de
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x011f:
            if (r5 >= r1) goto L_0x018c
            int r6 = r0.mmm
            int r6 = r6 * r5
            r7 = r10[r6]
            int r8 = r0.xxx
            if (r7 != r8) goto L_0x013d
            int r7 = r6 + 1
            r7 = r10[r7]
            int r8 = r0.ddd
            if (r7 != r8) goto L_0x013d
            int r6 = r6 + 2
            r6 = r10[r6]
            int r7 = r0.nn
            if (r6 != r7) goto L_0x013d
            r6 = 1
            goto L_0x013e
        L_0x013d:
            r6 = 0
        L_0x013e:
            r3[r15] = r6
            byte[] r6 = r0.f9644o
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            nn(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x011f
        L_0x015a:
            int r2 = r0.f9641de
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x0165:
            if (r5 >= r1) goto L_0x018c
            r6 = r10[r5]
            int r7 = r0.xxx
            if (r6 != r7) goto L_0x016f
            r6 = 1
            goto L_0x0170
        L_0x016f:
            r6 = 0
        L_0x0170:
            r3[r15] = r6
            byte[] r6 = r0.f9644o
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            nn(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x0165
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.th.xxx(byte[], int, int, int, int):void");
    }
}
