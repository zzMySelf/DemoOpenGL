package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import fe.when.ad.f.ad;
import fe.when.ad.f.q2.qw;
import fe.when.ad.th;
import java.io.IOException;
import java.util.HashMap;

public class m2 extends ad {
    public static qw x;
    public static final int[] y = {1, 2, 1};
    public float e = 0.0f;
    public String eee;
    public boolean f = false;
    public int g = -50;
    public int h = -200;
    public int j = 1000;
    public int k = 900;
    public int l = -100;
    public int m = 50;
    public String n = "FontSpecific";
    public int p = 700;
    public int q = 800;
    public byte[] qqq;
    public int r = -200;
    public String rrr;
    public int s = 80;
    public HashMap<Object, Object[]> t = new HashMap<>();
    public String tt = "";
    public HashMap<String, Object[]> u = new HashMap<>();
    public String v;
    public boolean w = false;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: fe.when.ad.f.e2} */
    /* JADX WARNING: type inference failed for: r1v5, types: [fe.when.ad.f.e2] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d7 A[SYNTHETIC, Splitter:B:37:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa A[SYNTHETIC, Splitter:B:49:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0194 A[SYNTHETIC, Splitter:B:94:0x0194] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m2(java.lang.String r4, java.lang.String r5, boolean r6, byte[] r7, byte[] r8, boolean r9) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            java.lang.String r0 = ""
            r3.tt = r0
            r0 = 0
            r3.e = r0
            r0 = 0
            r3.f = r0
            r1 = -50
            r3.g = r1
            r1 = -200(0xffffffffffffff38, float:NaN)
            r3.h = r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.j = r2
            r2 = 900(0x384, float:1.261E-42)
            r3.k = r2
            r2 = -100
            r3.l = r2
            r2 = 50
            r3.m = r2
            java.lang.String r2 = "FontSpecific"
            r3.n = r2
            r2 = 700(0x2bc, float:9.81E-43)
            r3.p = r2
            r2 = 800(0x320, float:1.121E-42)
            r3.q = r2
            r3.r = r1
            r1 = 80
            r3.s = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.t = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.u = r1
            r3.w = r0
            if (r6 == 0) goto L_0x005c
            if (r7 == 0) goto L_0x005c
            if (r8 == 0) goto L_0x004e
            goto L_0x005c
        L_0x004e:
            com.itextpdf.text.DocumentException r4 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "two.byte.arrays.are.needed.if.the.type1.font.is.embedded"
            java.lang.String r5 = fe.when.ad.c.qw.ad(r6, r5)
            r4.<init>((java.lang.String) r5)
            throw r4
        L_0x005c:
            if (r6 == 0) goto L_0x0062
            if (r7 == 0) goto L_0x0062
            r3.qqq = r8
        L_0x0062:
            r3.f9362pf = r5
            r3.f401if = r6
            r3.v = r4
            r3.f9363th = r0
            java.util.HashMap<java.lang.String, fe.when.ad.f.s0> r6 = fe.when.ad.f.ad.aaa
            boolean r6 = r6.containsKey(r4)
            java.lang.String r8 = ".afm"
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x00fe
            r3.f401if = r0
            r3.w = r2
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]
            fe.when.ad.f.q2.qw r7 = x     // Catch:{ all -> 0x00f7 }
            if (r7 != 0) goto L_0x0089
            fe.when.ad.f.q2.qw r7 = new fe.when.ad.f.q2.qw     // Catch:{ all -> 0x00f7 }
            r7.<init>()     // Catch:{ all -> 0x00f7 }
            x = r7     // Catch:{ all -> 0x00f7 }
        L_0x0089:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r7.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = "com/itextpdf/text/pdf/fonts/"
            r7.append(r9)     // Catch:{ all -> 0x00f7 }
            r7.append(r4)     // Catch:{ all -> 0x00f7 }
            r7.append(r8)     // Catch:{ all -> 0x00f7 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f7 }
            fe.when.ad.f.q2.qw r8 = x     // Catch:{ all -> 0x00f7 }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00f7 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00f7 }
            java.io.InputStream r7 = fe.when.ad.d.pf.ad(r7, r8)     // Catch:{ all -> 0x00f7 }
            if (r7 == 0) goto L_0x00e2
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00df }
            r4.<init>()     // Catch:{ all -> 0x00df }
        L_0x00b2:
            int r8 = r7.read(r6)     // Catch:{ all -> 0x00df }
            if (r8 >= 0) goto L_0x00db
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x00c1
            r7.close()     // Catch:{ Exception -> 0x00c1 }
        L_0x00c1:
            fe.when.ad.f.e2 r6 = new fe.when.ad.f.e2     // Catch:{ all -> 0x00d4 }
            r6.<init>((byte[]) r4)     // Catch:{ all -> 0x00d4 }
            r3.j(r6)     // Catch:{ all -> 0x00d1 }
            r6.close()     // Catch:{ Exception -> 0x00ce }
            goto L_0x015e
        L_0x00ce:
            goto L_0x015e
        L_0x00d1:
            r4 = move-exception
            r1 = r6
            goto L_0x00d5
        L_0x00d4:
            r4 = move-exception
        L_0x00d5:
            if (r1 == 0) goto L_0x00da
            r1.close()     // Catch:{ Exception -> 0x00da }
        L_0x00da:
            throw r4
        L_0x00db:
            r4.write(r6, r0, r8)     // Catch:{ all -> 0x00df }
            goto L_0x00b2
        L_0x00df:
            r4 = move-exception
            r1 = r7
            goto L_0x00f8
        L_0x00e2:
            java.lang.String r5 = "1.not.found.as.resource"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x00df }
            r6[r0] = r4     // Catch:{ all -> 0x00df }
            java.lang.String r4 = fe.when.ad.c.qw.ad(r5, r6)     // Catch:{ all -> 0x00df }
            java.io.PrintStream r5 = java.lang.System.err     // Catch:{ all -> 0x00df }
            r5.println(r4)     // Catch:{ all -> 0x00df }
            com.itextpdf.text.DocumentException r5 = new com.itextpdf.text.DocumentException     // Catch:{ all -> 0x00df }
            r5.<init>((java.lang.String) r4)     // Catch:{ all -> 0x00df }
            throw r5     // Catch:{ all -> 0x00df }
        L_0x00f7:
            r4 = move-exception
        L_0x00f8:
            if (r1 == 0) goto L_0x00fd
            r1.close()     // Catch:{ Exception -> 0x00fd }
        L_0x00fd:
            throw r4
        L_0x00fe:
            java.lang.String r6 = r4.toLowerCase()
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x0127
            if (r7 != 0) goto L_0x0113
            fe.when.ad.f.e2 r6 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0120 }
            boolean r7 = fe.when.ad.th.mmm     // Catch:{ all -> 0x0120 }
            r6.<init>(r4, r9, r7)     // Catch:{ all -> 0x0120 }
            r1 = r6
            goto L_0x0119
        L_0x0113:
            fe.when.ad.f.e2 r4 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0120 }
            r4.<init>((byte[]) r7)     // Catch:{ all -> 0x0120 }
            r1 = r4
        L_0x0119:
            r3.j(r1)     // Catch:{ all -> 0x0120 }
            r1.close()     // Catch:{ Exception -> 0x00ce }
            goto L_0x015e
        L_0x0120:
            r4 = move-exception
            if (r1 == 0) goto L_0x0126
            r1.close()     // Catch:{ Exception -> 0x0126 }
        L_0x0126:
            throw r4
        L_0x0127:
            java.lang.String r6 = r4.toLowerCase()
            java.lang.String r8 = ".pfm"
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x0198
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0191 }
            r6.<init>()     // Catch:{ all -> 0x0191 }
            if (r7 != 0) goto L_0x0143
            fe.when.ad.f.e2 r7 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0191 }
            boolean r8 = fe.when.ad.th.mmm     // Catch:{ all -> 0x0191 }
            r7.<init>(r4, r9, r8)     // Catch:{ all -> 0x0191 }
            r1 = r7
            goto L_0x0149
        L_0x0143:
            fe.when.ad.f.e2 r4 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0191 }
            r4.<init>((byte[]) r7)     // Catch:{ all -> 0x0191 }
            r1 = r4
        L_0x0149:
            fe.when.ad.f.d2.qw(r1, r6)     // Catch:{ all -> 0x0191 }
            r1.close()     // Catch:{ all -> 0x0191 }
            fe.when.ad.f.e2 r4 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0191 }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0191 }
            r4.<init>((byte[]) r6)     // Catch:{ all -> 0x0191 }
            r3.j(r4)     // Catch:{ all -> 0x018d }
            r4.close()     // Catch:{ Exception -> 0x00ce }
        L_0x015e:
            java.lang.String r4 = r3.n
            java.lang.String r4 = r4.trim()
            r3.n = r4
            java.lang.String r6 = "AdobeStandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0178
            java.lang.String r4 = r3.n
            java.lang.String r6 = "StandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x017a
        L_0x0178:
            r3.when = r0
        L_0x017a:
            java.lang.String r4 = r3.f9362pf
            java.lang.String r6 = "#"
            boolean r4 = r4.startsWith(r6)
            if (r4 != 0) goto L_0x0189
            java.lang.String r4 = " "
            fe.when.ad.f.a0.de(r4, r5)
        L_0x0189:
            r3.de()
            return
        L_0x018d:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x0192
        L_0x0191:
            r4 = move-exception
        L_0x0192:
            if (r1 == 0) goto L_0x0197
            r1.close()     // Catch:{ Exception -> 0x0197 }
        L_0x0197:
            throw r4
        L_0x0198:
            com.itextpdf.text.DocumentException r5 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r0] = r4
            java.lang.String r4 = "1.is.not.an.afm.or.pfm.font.file"
            java.lang.String r4 = fe.when.ad.c.qw.ad(r4, r6)
            r5.<init>((java.lang.String) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.m2.<init>(java.lang.String, java.lang.String, boolean, byte[], byte[], boolean):void");
    }

    public void e(c2 c2Var, l0 l0Var, Object[] objArr) throws DocumentException, IOException {
        int i2 = 0;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        byte[] bArr = objArr[2];
        if (!(objArr[3].booleanValue() && this.vvv)) {
            intValue2 = bArr.length - 1;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = 1;
            }
        } else {
            i2 = intValue;
        }
        l0 l0Var2 = null;
        v1 h2 = h();
        if (h2 != null) {
            l0Var2 = c2Var.eee(h2).qw();
        }
        x g2 = g(l0Var2);
        if (g2 != null) {
            l0Var2 = c2Var.eee(g2).qw();
        }
        c2Var.tt(f(l0Var2, i2, intValue2, bArr), l0Var);
    }

    public final x f(l0 l0Var, int i2, int i3, byte[] bArr) {
        x xVar = new x(s0.r1);
        xVar.h(s0.b5, s0.M5);
        xVar.h(s0.l, new s0(this.eee));
        boolean z = this.f9362pf.equals("Cp1252") || this.f9362pf.equals("MacRoman");
        if (!this.when || this.ddd != null) {
            int i4 = i2;
            while (true) {
                if (i4 > i3) {
                    break;
                } else if (!this.f9364uk[i4].equals(".notdef")) {
                    i2 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                xVar.h(s0.P0, this.f9362pf.equals("Cp1252") ? s0.o6 : s0.S2);
            } else {
                x xVar2 = new x(s0.P0);
                k kVar = new k();
                boolean z2 = true;
                for (int i5 = i2; i5 <= i3; i5++) {
                    if (bArr[i5] != 0) {
                        if (z2) {
                            kVar.qqq(new v0(i5));
                            z2 = false;
                        }
                        kVar.qqq(new s0(this.f9364uk[i5]));
                    } else {
                        z2 = true;
                    }
                }
                xVar2.h(s0.y0, kVar);
                xVar.h(s0.P0, xVar2);
            }
        }
        if (this.ddd != null || this.ppp || !this.w || (!this.when && !z)) {
            xVar.h(s0.g1, new v0(i2));
            xVar.h(s0.z2, new v0(i3));
            k kVar2 = new k();
            while (i2 <= i3) {
                if (bArr[i2] == 0) {
                    kVar2.qqq(new v0(0));
                } else {
                    kVar2.qqq(new v0(this.f9365yj[i2]));
                }
                i2++;
            }
            xVar.h(s0.m6, kVar2);
        }
        if (!this.w && l0Var != null) {
            xVar.h(s0.t1, l0Var);
        }
        return xVar;
    }

    public final x g(l0 l0Var) {
        if (this.w) {
            return null;
        }
        x xVar = new x(s0.t1);
        xVar.h(s0.tt, new v0(this.q));
        xVar.h(s0.C, new v0(this.p));
        xVar.h(s0.s0, new v0(this.r));
        xVar.h(s0.s1, new o1((float) this.g, (float) this.h, (float) this.j, (float) this.k));
        xVar.h(s0.x1, new s0(this.eee));
        xVar.h(s0.l2, new v0(this.e));
        xVar.h(s0.U4, new v0(this.s));
        if (l0Var != null) {
            xVar.h(s0.u1, l0Var);
        }
        int i2 = 0;
        if (this.f) {
            i2 = 1;
        }
        int i3 = i2 | (this.when ? 4 : 32);
        if (this.e < 0.0f) {
            i3 |= 64;
        }
        if (this.eee.indexOf("Caps") >= 0 || this.eee.endsWith("SC")) {
            i3 |= 131072;
        }
        if (this.tt.equals("Bold")) {
            i3 |= 262144;
        }
        xVar.h(s0.o1, new v0(i3));
        return xVar;
    }

    public String ggg() {
        return this.eee;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [fe.when.ad.f.v1, fe.when.ad.f.e2] */
    public v1 h() throws DocumentException {
        e2 e2Var;
        ? r1 = 0;
        if (this.w || !this.f401if) {
            return r1;
        }
        try {
            String str = this.v.substring(0, this.v.length() - 3) + "pfb";
            if (this.qqq == null) {
                e2Var = new e2(str, true, th.mmm);
            } else {
                e2Var = new e2(this.qqq);
            }
            e2 e2Var2 = e2Var;
            byte[] bArr = new byte[(((int) e2Var2.ad()) - 18)];
            int[] iArr = new int[3];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 3) {
                if (e2Var2.read() != 128) {
                    throw new DocumentException(fe.when.ad.c.qw.ad("start.marker.missing.in.1", str));
                } else if (e2Var2.read() == y[i2]) {
                    int read = e2Var2.read() + (e2Var2.read() << 8) + (e2Var2.read() << 16) + (e2Var2.read() << 24);
                    iArr[i2] = read;
                    while (read != 0) {
                        int read2 = e2Var2.read(bArr, i3, read);
                        if (read2 >= 0) {
                            i3 += read2;
                            read -= read2;
                        } else {
                            throw new DocumentException(fe.when.ad.c.qw.ad("premature.end.in.1", str));
                        }
                    }
                    i2++;
                } else {
                    throw new DocumentException(fe.when.ad.c.qw.ad("incorrect.segment.type.in.1", str));
                }
            }
            ad.qw qwVar = new ad.qw(bArr, iArr, this.f402switch);
            try {
                e2Var2.close();
            } catch (Exception unused) {
            }
            return qwVar;
        } catch (Exception e2) {
            throw new DocumentException(e2);
        } catch (Throwable th2) {
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public String[][] m1091if() {
        return new String[][]{new String[]{"", "", "", this.rrr}};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(fe.when.ad.f.e2 r15) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r14 = this;
        L_0x0000:
            java.lang.String r0 = r15.readLine()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0193
            java.util.StringTokenizer r3 = new java.util.StringTokenizer
            java.lang.String r4 = " ,\n\r\t\f"
            r3.<init>(r0, r4)
            boolean r0 = r3.hasMoreTokens()
            if (r0 != 0) goto L_0x0016
            goto L_0x0000
        L_0x0016:
            java.lang.String r0 = r3.nextToken()
            java.lang.String r4 = "FontName"
            boolean r4 = r0.equals(r4)
            java.lang.String r5 = "ÿ"
            if (r4 == 0) goto L_0x002f
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.eee = r0
            goto L_0x0000
        L_0x002f:
            java.lang.String r4 = "FullName"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x003f
            java.lang.String r0 = r3.nextToken(r5)
            r0.substring(r2)
            goto L_0x0000
        L_0x003f:
            java.lang.String r4 = "FamilyName"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0052
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.rrr = r0
            goto L_0x0000
        L_0x0052:
            java.lang.String r4 = "Weight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0065
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.tt = r0
            goto L_0x0000
        L_0x0065:
            java.lang.String r4 = "ItalicAngle"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0078
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            r14.e = r0
            goto L_0x0000
        L_0x0078:
            java.lang.String r4 = "IsFixedPitch"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x008e
            java.lang.String r0 = r3.nextToken()
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)
            r14.f = r0
            goto L_0x0000
        L_0x008e:
            java.lang.String r4 = "CharacterSet"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x009f
            java.lang.String r0 = r3.nextToken(r5)
            r0.substring(r2)
            goto L_0x0000
        L_0x009f:
            java.lang.String r4 = "FontBBox"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00d5
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.g = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.h = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.j = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.k = r0
            goto L_0x0000
        L_0x00d5:
            java.lang.String r4 = "UnderlinePosition"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00ea
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.l = r0
            goto L_0x0000
        L_0x00ea:
            java.lang.String r4 = "UnderlineThickness"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00ff
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.m = r0
            goto L_0x0000
        L_0x00ff:
            java.lang.String r4 = "EncodingScheme"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0113
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.n = r0
            goto L_0x0000
        L_0x0113:
            java.lang.String r4 = "CapHeight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0128
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.p = r0
            goto L_0x0000
        L_0x0128:
            java.lang.String r4 = "XHeight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0139
            java.lang.String r0 = r3.nextToken()
            java.lang.Float.parseFloat(r0)
            goto L_0x0000
        L_0x0139:
            java.lang.String r4 = "Ascender"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x014e
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.q = r0
            goto L_0x0000
        L_0x014e:
            java.lang.String r4 = "Descender"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0163
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.r = r0
            goto L_0x0000
        L_0x0163:
            java.lang.String r4 = "StdHW"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0174
            java.lang.String r0 = r3.nextToken()
            java.lang.Float.parseFloat(r0)
            goto L_0x0000
        L_0x0174:
            java.lang.String r4 = "StdVW"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0189
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.s = r0
            goto L_0x0000
        L_0x0189:
            java.lang.String r3 = "StartCharMetrics"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0000
            r0 = 1
            goto L_0x0194
        L_0x0193:
            r0 = 0
        L_0x0194:
            if (r0 == 0) goto L_0x0355
        L_0x0196:
            java.lang.String r3 = r15.readLine()
            r4 = 2
            if (r3 == 0) goto L_0x026d
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r6 = r5.hasMoreTokens()
            if (r6 != 0) goto L_0x01a9
            goto L_0x0196
        L_0x01a9:
            java.lang.String r5 = r5.nextToken()
            java.lang.String r6 = "EndCharMetrics"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x01b8
            r0 = 0
            goto L_0x026d
        L_0x01b8:
            r5 = -1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 250(0xfa, float:3.5E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = 0
            java.util.StringTokenizer r8 = new java.util.StringTokenizer
            java.lang.String r9 = ";"
            r8.<init>(r3, r9)
            java.lang.String r3 = ""
        L_0x01cd:
            boolean r9 = r8.hasMoreTokens()
            r10 = 3
            r11 = 4
            if (r9 == 0) goto L_0x0251
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            java.lang.String r12 = r8.nextToken()
            r9.<init>(r12)
            boolean r12 = r9.hasMoreTokens()
            if (r12 != 0) goto L_0x01e5
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r12 = r9.nextToken()
            java.lang.String r13 = "C"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x01fa
            java.lang.String r5 = r9.nextToken()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x01fa:
            java.lang.String r13 = "WX"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x0210
            java.lang.String r6 = r9.nextToken()
            float r6 = java.lang.Float.parseFloat(r6)
            int r6 = (int) r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x01cd
        L_0x0210:
            java.lang.String r13 = "N"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x021d
            java.lang.String r3 = r9.nextToken()
            goto L_0x01cd
        L_0x021d:
            java.lang.String r13 = "B"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x01cd
            int[] r7 = new int[r11]
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r1] = r11
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r2] = r11
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r4] = r11
            java.lang.String r9 = r9.nextToken()
            int r9 = java.lang.Integer.parseInt(r9)
            r7[r10] = r9
            goto L_0x01cd
        L_0x0251:
            java.lang.Object[] r8 = new java.lang.Object[r11]
            r8[r1] = r5
            r8[r2] = r6
            r8[r4] = r3
            r8[r10] = r7
            int r4 = r5.intValue()
            if (r4 < 0) goto L_0x0266
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r4 = r14.t
            r4.put(r5, r8)
        L_0x0266:
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r4 = r14.t
            r4.put(r3, r8)
            goto L_0x0196
        L_0x026d:
            if (r0 != 0) goto L_0x0343
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r3 = r14.t
            java.lang.String r5 = "nonbreakingspace"
            boolean r3 = r3.containsKey(r5)
            if (r3 != 0) goto L_0x028a
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r3 = r14.t
            java.lang.String r6 = "space"
            java.lang.Object r3 = r3.get(r6)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            if (r3 == 0) goto L_0x028a
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r6 = r14.t
            r6.put(r5, r3)
        L_0x028a:
            java.lang.String r3 = r15.readLine()
            if (r3 == 0) goto L_0x02b2
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r3 = r5.hasMoreTokens()
            if (r3 != 0) goto L_0x029c
            goto L_0x028a
        L_0x029c:
            java.lang.String r3 = r5.nextToken()
            java.lang.String r5 = "EndFontMetrics"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x02a9
            return
        L_0x02a9:
            java.lang.String r5 = "StartKernPairs"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x028a
            r0 = 1
        L_0x02b2:
            if (r0 == 0) goto L_0x0331
        L_0x02b4:
            java.lang.String r3 = r15.readLine()
            if (r3 == 0) goto L_0x0319
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r3 = r5.hasMoreTokens()
            if (r3 != 0) goto L_0x02c6
            goto L_0x02b4
        L_0x02c6:
            java.lang.String r3 = r5.nextToken()
            java.lang.String r6 = "KPX"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x0310
            java.lang.String r3 = r5.nextToken()
            java.lang.String r6 = r5.nextToken()
            java.lang.String r5 = r5.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.util.HashMap<java.lang.String, java.lang.Object[]> r7 = r14.u
            java.lang.Object r7 = r7.get(r3)
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            if (r7 != 0) goto L_0x02fd
            java.util.HashMap<java.lang.String, java.lang.Object[]> r7 = r14.u
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r1] = r6
            r8[r2] = r5
            r7.put(r3, r8)
            goto L_0x02b4
        L_0x02fd:
            int r8 = r7.length
            int r9 = r8 + 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.System.arraycopy(r7, r1, r9, r1, r8)
            r9[r8] = r6
            int r8 = r8 + r2
            r9[r8] = r5
            java.util.HashMap<java.lang.String, java.lang.Object[]> r5 = r14.u
            r5.put(r3, r9)
            goto L_0x02b4
        L_0x0310:
            java.lang.String r5 = "EndKernPairs"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x02b4
            r0 = 0
        L_0x0319:
            if (r0 != 0) goto L_0x031f
            r15.close()
            return
        L_0x031f:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = r14.v
            r0[r1] = r2
            java.lang.String r1 = "missing.endkernpairs.in.1"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0331:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = r14.v
            r0[r1] = r2
            java.lang.String r1 = "missing.endfontmetrics.in.1"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0343:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = r14.v
            r0[r1] = r2
            java.lang.String r1 = "missing.endcharmetrics.in.1"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0355:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = r14.v
            r0[r1] = r2
            java.lang.String r1 = "missing.startcharmetrics.in.1"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r15.<init>((java.lang.String) r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.m2.j(fe.when.ad.f.e2):void");
    }

    public int ppp(int i2, int i3) {
        String ad2;
        Object[] objArr;
        String ad3 = ddd.ad(i2);
        if (ad3 == null || (ad2 = ddd.ad(i3)) == null || (objArr = this.u.get(ad3)) == null) {
            return 0;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (ad2.equals(objArr[i4])) {
                return ((Integer) objArr[i4 + 1]).intValue();
            }
        }
        return 0;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1092switch(int i2, float f2) {
        int i3;
        switch (i2) {
            case 1:
            case 9:
                i3 = this.q;
                break;
            case 2:
                i3 = this.p;
                break;
            case 3:
            case 10:
                i3 = this.r;
                break;
            case 4:
                return this.e;
            case 5:
                i3 = this.g;
                break;
            case 6:
                i3 = this.h;
                break;
            case 7:
                i3 = this.j;
                break;
            case 8:
                i3 = this.k;
                break;
            case 12:
                i3 = this.j - this.g;
                break;
            case 13:
                i3 = this.l;
                break;
            case 14:
                i3 = this.m;
                break;
            default:
                return 0.0f;
        }
        return (((float) i3) * f2) / 1000.0f;
    }

    public boolean tt() {
        return !this.u.isEmpty();
    }

    public int[] vvv(int i2, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.t.get(Integer.valueOf(i2));
        } else if (str.equals(".notdef")) {
            return null;
        } else {
            objArr = this.t.get(str);
        }
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }

    public int xxx(int i2, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.t.get(Integer.valueOf(i2));
        } else if (str.equals(".notdef")) {
            return 0;
        } else {
            objArr = this.t.get(str);
        }
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }
}
