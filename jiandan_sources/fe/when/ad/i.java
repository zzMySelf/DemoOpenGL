package fe.when.ad;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IAlternateDescription;
import fe.when.ad.c.qw;
import fe.when.ad.f.l0;
import fe.when.ad.f.mmm;
import fe.when.ad.f.n2.ad;
import fe.when.ad.f.s0;
import fe.when.ad.f.x;
import fe.when.ad.f.y0;
import fe.when.ad.f.z1;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public abstract class i extends aaa implements Indentable, Spaceable, IAccessibleElement, IAlternateDescription {
    public static long W;
    public float A;
    public float B = 100.0f;
    public boolean C;
    public boolean D = true;
    public ad E = null;
    public PdfOCG F;
    public boolean G;
    public int H = 0;
    public byte[] I;
    public boolean J = false;
    public int K = 0;
    public int L = 0;
    public float M = 0.0f;
    public int N = -1;
    public int O = 1;
    public boolean P = false;
    public mmm Q = null;
    public x R = null;
    public boolean S = false;
    public i T;
    public boolean U;
    public int[] V;
    public z1[] e = new z1[1];
    public URL eee;
    public int f;
    public String g;
    public float h = Float.NaN;
    public float j = Float.NaN;
    public float k;
    public float l;
    public float m;
    public float n;
    public int p = -1;
    public Long q = U();
    public int qqq;
    public s0 r = s0.c1;
    public byte[] rrr;
    public HashMap<s0, y0> s = null;
    public qw t = null;
    public int tt = 1;
    public l0 u;
    public float v;
    public float w;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z;

    public i(URL url) {
        super(0.0f, 0.0f);
        this.eee = url;
        this.f = 0;
        this.v = 0.0f;
    }

    public static i E(int i2, int i3, int i4, int i5, byte[] bArr) throws BadElementException {
        return F(i2, i3, i4, i5, bArr, (int[]) null);
    }

    public static i F(int i2, int i3, int i4, int i5, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != i4 * 2) {
            throw new BadElementException(qw.ad("transparency.length.must.be.equal.to.componentes.2", new Object[0]));
        } else if (i4 == 1 && i5 == 1) {
            return H(i2, i3, false, 256, 1, ad.fe(bArr, i2, i3), iArr);
        } else {
            Cif ifVar = new Cif(i2, i3, i4, i5, bArr);
            ifVar.V = iArr;
            return ifVar;
        }
    }

    public static i G(int i2, int i3, boolean z2, int i4, int i5, byte[] bArr) throws BadElementException {
        return H(i2, i3, z2, i4, i5, bArr, (int[]) null);
    }

    public static i H(int i2, int i3, boolean z2, int i4, int i5, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr == null || iArr.length == 2) {
            o oVar = new o(i2, i3, z2, i4, i5, bArr);
            oVar.V = iArr;
            return oVar;
        }
        throw new BadElementException(qw.ad("transparency.length.must.be.equal.to.2.with.ccitt.images", new Object[0]));
    }

    public static i I(i iVar) {
        if (iVar == null) {
            return null;
        }
        try {
            return (i) iVar.getClass().getDeclaredConstructor(new Class[]{i.class}).newInstance(new Object[]{iVar});
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static i J(String str) throws BadElementException, MalformedURLException, IOException {
        return K(a.o(str));
    }

    public static i K(URL url) throws BadElementException, MalformedURLException, IOException {
        return L(url, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0167 A[Catch:{ all -> 0x0161, all -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0100 A[SYNTHETIC, Splitter:B:80:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010c A[SYNTHETIC, Splitter:B:86:0x010c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i L(java.net.URL r17, boolean r18) throws com.itextpdf.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            r1 = r17
            r2 = r18
            fe.when.ad.d.o r0 = new fe.when.ad.d.o
            r0.<init>()
            java.io.InputStream r4 = r17.openStream()     // Catch:{ all -> 0x0183 }
            int r5 = r4.read()     // Catch:{ all -> 0x0180 }
            int r6 = r4.read()     // Catch:{ all -> 0x0180 }
            int r7 = r4.read()     // Catch:{ all -> 0x0180 }
            int r8 = r4.read()     // Catch:{ all -> 0x0180 }
            int r9 = r4.read()     // Catch:{ all -> 0x0180 }
            int r10 = r4.read()     // Catch:{ all -> 0x0180 }
            int r11 = r4.read()     // Catch:{ all -> 0x0180 }
            int r12 = r4.read()     // Catch:{ all -> 0x0180 }
            r4.close()     // Catch:{ all -> 0x0180 }
            r4 = 71
            r13 = 73
            r14 = 1
            if (r5 != r4) goto L_0x0047
            if (r6 != r13) goto L_0x0047
            r4 = 70
            if (r7 != r4) goto L_0x0047
            fe.when.ad.f.n2.de r0 = new fe.when.ad.f.n2.de     // Catch:{ all -> 0x0183 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0183 }
            fe.when.ad.i r0 = r0.ad(r14)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0047:
            r4 = 255(0xff, float:3.57E-43)
            if (r5 != r4) goto L_0x0055
            r15 = 216(0xd8, float:3.03E-43)
            if (r6 != r15) goto L_0x0055
            fe.when.ad.when r0 = new fe.when.ad.when     // Catch:{ all -> 0x0183 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0055:
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r7 != 0) goto L_0x0065
            r15 = 12
            if (r8 != r15) goto L_0x0065
            com.itextpdf.text.Jpeg2000 r0 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0183 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0065:
            if (r5 != r4) goto L_0x0077
            r15 = 79
            if (r6 != r15) goto L_0x0077
            if (r7 != r4) goto L_0x0077
            r4 = 81
            if (r8 != r4) goto L_0x0077
            com.itextpdf.text.Jpeg2000 r0 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0183 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0077:
            int[] r4 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0183 }
            r15 = 0
            r4 = r4[r15]     // Catch:{ all -> 0x0183 }
            if (r5 != r4) goto L_0x0099
            int[] r4 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0183 }
            r4 = r4[r14]     // Catch:{ all -> 0x0183 }
            if (r6 != r4) goto L_0x0099
            int[] r4 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0183 }
            r16 = 2
            r4 = r4[r16]     // Catch:{ all -> 0x0183 }
            if (r7 != r4) goto L_0x0099
            int[] r4 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0183 }
            r16 = 3
            r4 = r4[r16]     // Catch:{ all -> 0x0183 }
            if (r8 != r4) goto L_0x0099
            fe.when.ad.i r0 = fe.when.ad.f.n2.th.pf(r17)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0099:
            r4 = 215(0xd7, float:3.01E-43)
            if (r5 != r4) goto L_0x00a7
            r4 = 205(0xcd, float:2.87E-43)
            if (r6 != r4) goto L_0x00a7
            fe.when.ad.switch r0 = new fe.when.ad.switch     // Catch:{ all -> 0x0183 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x00a7:
            r4 = 66
            r3 = 77
            if (r5 != r4) goto L_0x00b4
            if (r6 != r3) goto L_0x00b4
            fe.when.ad.i r0 = fe.when.ad.f.n2.qw.yj(r17)     // Catch:{ all -> 0x0183 }
            return r0
        L_0x00b4:
            java.lang.String r15 = "file"
            r4 = 42
            if (r5 != r3) goto L_0x00c0
            if (r6 != r3) goto L_0x00c0
            if (r7 != 0) goto L_0x00c0
            if (r8 == r4) goto L_0x00c8
        L_0x00c0:
            if (r5 != r13) goto L_0x0114
            if (r6 != r13) goto L_0x0114
            if (r7 != r4) goto L_0x0114
            if (r8 != 0) goto L_0x0114
        L_0x00c8:
            java.lang.String r3 = r17.getProtocol()     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            boolean r3 = r3.equals(r15)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            if (r3 == 0) goto L_0x00e4
            java.lang.String r3 = r17.getFile()     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            java.lang.String r3 = fe.when.ad.a.pf(r3)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            fe.when.ad.f.e2 r4 = new fe.when.ad.f.e2     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.qw(r3)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            r4.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            goto L_0x00ed
        L_0x00e4:
            fe.when.ad.f.e2 r4 = new fe.when.ad.f.e2     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.th(r1)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
            r4.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f9 }
        L_0x00ed:
            fe.when.ad.i r0 = fe.when.ad.f.n2.o.th(r4, r14)     // Catch:{ RuntimeException -> 0x00f7 }
            r0.eee = r1     // Catch:{ RuntimeException -> 0x00f7 }
            r4.close()     // Catch:{ all -> 0x0183 }
            return r0
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r4 = 0
            goto L_0x010e
        L_0x00fc:
            r0 = move-exception
            r4 = 0
        L_0x00fe:
            if (r2 == 0) goto L_0x010c
            fe.when.ad.i r0 = fe.when.ad.f.n2.o.uk(r4, r2, r14)     // Catch:{ all -> 0x010d }
            r0.eee = r1     // Catch:{ all -> 0x010d }
            if (r4 == 0) goto L_0x010b
            r4.close()     // Catch:{ all -> 0x0183 }
        L_0x010b:
            return r0
        L_0x010c:
            throw r0     // Catch:{ all -> 0x010d }
        L_0x010d:
            r0 = move-exception
        L_0x010e:
            if (r4 == 0) goto L_0x0113
            r4.close()     // Catch:{ all -> 0x0183 }
        L_0x0113:
            throw r0     // Catch:{ all -> 0x0183 }
        L_0x0114:
            r2 = 151(0x97, float:2.12E-43)
            if (r5 != r2) goto L_0x016b
            r2 = 74
            if (r6 != r2) goto L_0x016b
            r2 = 66
            if (r7 != r2) goto L_0x016b
            r2 = 50
            if (r8 != r2) goto L_0x016b
            r2 = 13
            if (r9 != r2) goto L_0x016b
            r2 = 10
            if (r10 != r2) goto L_0x016b
            r3 = 26
            if (r11 != r3) goto L_0x016b
            if (r12 != r2) goto L_0x016b
            java.lang.String r2 = r17.getProtocol()     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r15)     // Catch:{ all -> 0x0163 }
            if (r2 == 0) goto L_0x014e
            java.lang.String r2 = r17.getFile()     // Catch:{ all -> 0x0163 }
            java.lang.String r2 = fe.when.ad.a.pf(r2)     // Catch:{ all -> 0x0163 }
            fe.when.ad.f.e2 r3 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0163 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.qw(r2)     // Catch:{ all -> 0x0163 }
            r3.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x0163 }
            goto L_0x0157
        L_0x014e:
            fe.when.ad.f.e2 r3 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0163 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.th(r1)     // Catch:{ all -> 0x0163 }
            r3.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x0163 }
        L_0x0157:
            fe.when.ad.i r0 = fe.when.ad.f.n2.fe.qw(r3, r14)     // Catch:{ all -> 0x0161 }
            r0.eee = r1     // Catch:{ all -> 0x0161 }
            r3.close()     // Catch:{ all -> 0x0183 }
            return r0
        L_0x0161:
            r0 = move-exception
            goto L_0x0165
        L_0x0163:
            r0 = move-exception
            r3 = 0
        L_0x0165:
            if (r3 == 0) goto L_0x016a
            r3.close()     // Catch:{ all -> 0x0183 }
        L_0x016a:
            throw r0     // Catch:{ all -> 0x0183 }
        L_0x016b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = "unknown.image.format"
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = r17.toString()     // Catch:{ all -> 0x0183 }
            r4 = 0
            r3[r4] = r1     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r3)     // Catch:{ all -> 0x0183 }
            r0.<init>(r1)     // Catch:{ all -> 0x0183 }
            throw r0     // Catch:{ all -> 0x0183 }
        L_0x0180:
            r0 = move-exception
            r3 = r4
            goto L_0x0185
        L_0x0183:
            r0 = move-exception
            r3 = 0
        L_0x0185:
            if (r3 == 0) goto L_0x018a
            r3.close()
        L_0x018a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.i.L(java.net.URL, boolean):fe.when.ad.i");
    }

    public static i M(byte[] bArr) throws BadElementException, MalformedURLException, IOException {
        return N(bArr, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: fe.when.ad.f.e2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: fe.when.ad.f.e2} */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x014c A[SYNTHETIC, Splitter:B:126:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d5 A[SYNTHETIC, Splitter:B:79:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00e8 A[SYNTHETIC, Splitter:B:87:0x00e8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:132:0x0155=Splitter:B:132:0x0155, B:70:0x00c8=Splitter:B:70:0x00c8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i N(byte[] r12, boolean r13) throws com.itextpdf.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            fe.when.ad.d.o r0 = new fe.when.ad.d.o
            r0.<init>()
            r1 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0166 }
            r2.<init>(r12)     // Catch:{ all -> 0x0166 }
            int r3 = r2.read()     // Catch:{ all -> 0x0163 }
            int r4 = r2.read()     // Catch:{ all -> 0x0163 }
            int r5 = r2.read()     // Catch:{ all -> 0x0163 }
            int r6 = r2.read()     // Catch:{ all -> 0x0163 }
            r2.close()     // Catch:{ all -> 0x0163 }
            r2 = 71
            r7 = 73
            r8 = 1
            if (r3 != r2) goto L_0x0035
            if (r4 != r7) goto L_0x0035
            r2 = 70
            if (r5 != r2) goto L_0x0035
            fe.when.ad.f.n2.de r13 = new fe.when.ad.f.n2.de     // Catch:{ all -> 0x0166 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0166 }
            fe.when.ad.i r12 = r13.ad(r8)     // Catch:{ all -> 0x0166 }
            return r12
        L_0x0035:
            r2 = 255(0xff, float:3.57E-43)
            if (r3 != r2) goto L_0x0043
            r9 = 216(0xd8, float:3.03E-43)
            if (r4 != r9) goto L_0x0043
            fe.when.ad.when r13 = new fe.when.ad.when     // Catch:{ all -> 0x0166 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0166 }
            return r13
        L_0x0043:
            if (r3 != 0) goto L_0x0053
            if (r4 != 0) goto L_0x0053
            if (r5 != 0) goto L_0x0053
            r9 = 12
            if (r6 != r9) goto L_0x0053
            com.itextpdf.text.Jpeg2000 r13 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0166 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0166 }
            return r13
        L_0x0053:
            if (r3 != r2) goto L_0x0065
            r9 = 79
            if (r4 != r9) goto L_0x0065
            if (r5 != r2) goto L_0x0065
            r2 = 81
            if (r6 != r2) goto L_0x0065
            com.itextpdf.text.Jpeg2000 r13 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0166 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0166 }
            return r13
        L_0x0065:
            int[] r2 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0166 }
            r9 = 0
            r2 = r2[r9]     // Catch:{ all -> 0x0166 }
            if (r3 != r2) goto L_0x0085
            int[] r2 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0166 }
            r2 = r2[r8]     // Catch:{ all -> 0x0166 }
            if (r4 != r2) goto L_0x0085
            int[] r2 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0166 }
            r10 = 2
            r2 = r2[r10]     // Catch:{ all -> 0x0166 }
            if (r5 != r2) goto L_0x0085
            int[] r2 = fe.when.ad.f.n2.th.j     // Catch:{ all -> 0x0166 }
            r10 = 3
            r2 = r2[r10]     // Catch:{ all -> 0x0166 }
            if (r6 != r2) goto L_0x0085
            fe.when.ad.i r12 = fe.when.ad.f.n2.th.m1103if(r12)     // Catch:{ all -> 0x0166 }
            return r12
        L_0x0085:
            r2 = 215(0xd7, float:3.01E-43)
            if (r3 != r2) goto L_0x0093
            r2 = 205(0xcd, float:2.87E-43)
            if (r4 != r2) goto L_0x0093
            fe.when.ad.switch r13 = new fe.when.ad.switch     // Catch:{ all -> 0x0166 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0166 }
            return r13
        L_0x0093:
            r2 = 66
            r10 = 77
            if (r3 != r2) goto L_0x00a0
            if (r4 != r10) goto L_0x00a0
            fe.when.ad.i r12 = fe.when.ad.f.n2.qw.uk(r12)     // Catch:{ all -> 0x0166 }
            return r12
        L_0x00a0:
            r11 = 42
            if (r3 != r10) goto L_0x00aa
            if (r4 != r10) goto L_0x00aa
            if (r5 != 0) goto L_0x00aa
            if (r6 == r11) goto L_0x00b2
        L_0x00aa:
            if (r3 != r7) goto L_0x00f0
            if (r4 != r7) goto L_0x00f0
            if (r5 != r11) goto L_0x00f0
            if (r6 != 0) goto L_0x00f0
        L_0x00b2:
            fe.when.ad.f.e2 r2 = new fe.when.ad.f.e2     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.yj(r12)     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            fe.when.ad.i r0 = fe.when.ad.f.n2.o.th(r2, r8)     // Catch:{ RuntimeException -> 0x00cc }
            byte[] r3 = r0.Q()     // Catch:{ RuntimeException -> 0x00cc }
            if (r3 != 0) goto L_0x00c8
            r0.C0(r12)     // Catch:{ RuntimeException -> 0x00cc }
        L_0x00c8:
            r2.close()     // Catch:{ all -> 0x0166 }
            return r0
        L_0x00cc:
            r0 = move-exception
            goto L_0x00d3
        L_0x00ce:
            r12 = move-exception
            r2 = r1
            goto L_0x00ea
        L_0x00d1:
            r0 = move-exception
            r2 = r1
        L_0x00d3:
            if (r13 == 0) goto L_0x00e8
            fe.when.ad.i r13 = fe.when.ad.f.n2.o.uk(r2, r13, r8)     // Catch:{ all -> 0x00e9 }
            byte[] r0 = r13.Q()     // Catch:{ all -> 0x00e9 }
            if (r0 != 0) goto L_0x00e2
            r13.C0(r12)     // Catch:{ all -> 0x00e9 }
        L_0x00e2:
            if (r2 == 0) goto L_0x00e7
            r2.close()     // Catch:{ all -> 0x0166 }
        L_0x00e7:
            return r13
        L_0x00e8:
            throw r0     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r12 = move-exception
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef
            r2.close()     // Catch:{ all -> 0x0166 }
        L_0x00ef:
            throw r12     // Catch:{ all -> 0x0166 }
        L_0x00f0:
            r13 = 151(0x97, float:2.12E-43)
            if (r3 != r13) goto L_0x0155
            r13 = 74
            if (r4 != r13) goto L_0x0155
            if (r5 != r2) goto L_0x0155
            r13 = 50
            if (r6 != r13) goto L_0x0155
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0166 }
            r13.<init>(r12)     // Catch:{ all -> 0x0166 }
            r2 = 4
            r13.skip(r2)     // Catch:{ all -> 0x0152 }
            int r2 = r13.read()     // Catch:{ all -> 0x0152 }
            int r3 = r13.read()     // Catch:{ all -> 0x0152 }
            int r4 = r13.read()     // Catch:{ all -> 0x0152 }
            int r5 = r13.read()     // Catch:{ all -> 0x0152 }
            r13.close()     // Catch:{ all -> 0x0152 }
            r6 = 13
            if (r2 != r6) goto L_0x0150
            r2 = 10
            if (r3 != r2) goto L_0x0150
            r3 = 26
            if (r4 != r3) goto L_0x0150
            if (r5 != r2) goto L_0x0150
            fe.when.ad.f.e2 r2 = new fe.when.ad.f.e2     // Catch:{ all -> 0x0149 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.yj(r12)     // Catch:{ all -> 0x0149 }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x0149 }
            fe.when.ad.i r0 = fe.when.ad.f.n2.fe.qw(r2, r8)     // Catch:{ all -> 0x0146 }
            byte[] r1 = r0.Q()     // Catch:{ all -> 0x0146 }
            if (r1 != 0) goto L_0x013f
            r0.C0(r12)     // Catch:{ all -> 0x0146 }
        L_0x013f:
            r2.close()     // Catch:{ all -> 0x0152 }
            r13.close()
            return r0
        L_0x0146:
            r12 = move-exception
            r1 = r2
            goto L_0x014a
        L_0x0149:
            r12 = move-exception
        L_0x014a:
            if (r1 == 0) goto L_0x014f
            r1.close()     // Catch:{ all -> 0x0152 }
        L_0x014f:
            throw r12     // Catch:{ all -> 0x0152 }
        L_0x0150:
            r1 = r13
            goto L_0x0155
        L_0x0152:
            r12 = move-exception
            r1 = r13
            goto L_0x0167
        L_0x0155:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x0166 }
            java.lang.String r13 = "the.byte.array.is.not.a.recognized.imageformat"
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x0166 }
            java.lang.String r13 = fe.when.ad.c.qw.ad(r13, r0)     // Catch:{ all -> 0x0166 }
            r12.<init>(r13)     // Catch:{ all -> 0x0166 }
            throw r12     // Catch:{ all -> 0x0166 }
        L_0x0163:
            r12 = move-exception
            r1 = r2
            goto L_0x0167
        L_0x0166:
            r12 = move-exception
        L_0x0167:
            if (r1 == 0) goto L_0x016c
            r1.close()
        L_0x016c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.i.N(byte[], boolean):fe.when.ad.i");
    }

    public static synchronized Long U() {
        Long valueOf;
        synchronized (i.class) {
            long j2 = W + 1;
            W = j2;
            valueOf = Long.valueOf(j2);
        }
        return valueOf;
    }

    public i A() {
        return this.T;
    }

    public void A0(float f2) {
        this.w = f2;
        E0(this.v - this.w);
    }

    public float B() {
        float f2 = (float) (((double) (this.v - this.w)) % 6.283185307179586d);
        return f2 < 0.0f ? (float) (((double) f2) + 6.283185307179586d) : f2;
    }

    public void B0(boolean z2) {
        this.P = z2;
    }

    public float C() {
        return this.x;
    }

    public void C0(byte[] bArr) {
        this.I = bArr;
    }

    public float D() {
        return this.y;
    }

    public void D0(int i2) {
        this.H = i2;
    }

    public void E0(float f2) {
        float f3 = (float) (((double) (f2 + this.w)) % 6.283185307179586d);
        this.v = f3;
        if (f3 < 0.0f) {
            this.v = (float) (((double) f3) + 6.283185307179586d);
        }
        float[] o0 = o0();
        this.m = o0[6] - o0[4];
        this.n = o0[7] - o0[5];
    }

    public void F0(boolean z2) {
        this.C = z2;
    }

    public void G0(z1 z1Var) {
        this.e[0] = z1Var;
    }

    public void H0(int[] iArr) {
        this.V = iArr;
    }

    public void I0(URL url) {
        this.eee = url;
    }

    public void J0(float f2) {
        this.B = f2;
    }

    public void K0(float f2) {
        this.M = f2;
    }

    public void L0(mmm mmm) {
        this.Q = mmm;
    }

    public PdfOCG O() {
        return this.F;
    }

    public Long P() {
        return this.q;
    }

    public byte[] Q() {
        return this.I;
    }

    public byte[] R() {
        return this.rrr;
    }

    public float S() {
        return this.n;
    }

    public float T() {
        return this.m;
    }

    public float V() {
        return this.A;
    }

    public z1 W() {
        return this.e[0];
    }

    public int[] X() {
        return this.V;
    }

    public URL Y() {
        return this.eee;
    }

    public float Z() {
        return this.B;
    }

    public boolean a0() {
        return !Float.isNaN(this.h);
    }

    public boolean b0() {
        return !Float.isNaN(this.j);
    }

    public boolean c0() {
        return this.Q != null;
    }

    public boolean d0() {
        return this.J;
    }

    public boolean e0() {
        return this.qqq == 34;
    }

    public boolean f0() {
        return this.qqq == 35;
    }

    public boolean g0() {
        return this.G;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.s;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.s;
    }

    public qw getId() {
        if (this.t == null) {
            this.t = new qw();
        }
        return this.t;
    }

    public s0 getRole() {
        return this.r;
    }

    public float getSpacingBefore() {
        return this.z;
    }

    public boolean h0() {
        return this.P;
    }

    public boolean i0() {
        return this.S;
    }

    public boolean isInline() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean j0() {
        if ((this.qqq != 34 || this.tt <= 255) && this.N != 1) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        return this.D;
    }

    public boolean l0() {
        return this.C;
    }

    public boolean m0() {
        return this.U;
    }

    public void n0() throws DocumentException {
        if (j0()) {
            this.S = true;
            return;
        }
        throw new DocumentException(qw.ad("this.image.can.not.be.an.image.mask", new Object[0]));
    }

    public float[] o0() {
        return p0(1.0f);
    }

    public float p() {
        return this.h;
    }

    public float[] p0(float f2) {
        float[] fArr = new float[8];
        float cos = (float) Math.cos((double) this.v);
        float sin = (float) Math.sin((double) this.v);
        float f3 = this.k;
        fArr[0] = f3 * cos * f2;
        fArr[1] = f3 * sin * f2;
        float f4 = this.l;
        fArr[2] = (-f4) * sin * f2;
        fArr[3] = f4 * cos * f2;
        float f5 = this.v;
        if (((double) f5) < 1.5707963267948966d) {
            fArr[4] = fArr[2];
            fArr[5] = 0.0f;
            fArr[6] = fArr[0];
            fArr[7] = fArr[1] + fArr[3];
        } else if (((double) f5) < 3.141592653589793d) {
            fArr[4] = fArr[0] + fArr[2];
            fArr[5] = fArr[3];
            fArr[6] = 0.0f;
            fArr[7] = fArr[1];
        } else if (((double) f5) < 4.71238898038469d) {
            fArr[4] = fArr[0];
            fArr[5] = fArr[1] + fArr[3];
            fArr[6] = fArr[2];
            fArr[7] = 0.0f;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = fArr[1];
            fArr[6] = fArr[0] + fArr[2];
            fArr[7] = fArr[3];
        }
        return fArr;
    }

    public float q() {
        return this.j;
    }

    public void q0(float f2, float f3) {
        this.k = f2;
        this.l = f3;
        float[] o0 = o0();
        this.m = o0[6] - o0[4];
        this.n = o0[7] - o0[5];
        J0(0.0f);
    }

    public x r() {
        return this.R;
    }

    public void r0(float f2) {
        s0(f2, f2);
    }

    public int s() {
        return this.f;
    }

    public void s0(float f2, float f3) {
        this.k = (rrr() * f2) / 100.0f;
        this.l = (ggg() * f3) / 100.0f;
        float[] o0 = o0();
        this.m = o0[6] - o0[4];
        this.n = o0[7] - o0[5];
        J0(0.0f);
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.s == null) {
            this.s = new HashMap<>();
        }
        this.s.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.t = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.r = s0Var;
    }

    public ad t() {
        return this.E;
    }

    public void t0(float f2, float f3) {
        r0(100.0f);
        float T2 = (f2 * 100.0f) / T();
        float S2 = (f3 * 100.0f) / S();
        if (T2 >= S2) {
            T2 = S2;
        }
        r0(T2);
        J0(0.0f);
    }

    public int type() {
        return this.qqq;
    }

    public int u() {
        return this.tt;
    }

    public void u0(float f2, float f3) {
        this.h = f2;
        this.j = f3;
    }

    public int v() {
        return this.O;
    }

    public void v0(x xVar) {
        this.R = xVar;
    }

    public int w() {
        return this.N;
    }

    public void w0(int i2) {
        this.O = i2;
    }

    public int x() {
        return this.p;
    }

    public void x0(boolean z2) {
        this.J = z2;
    }

    public l0 y() {
        return this.u;
    }

    public void y0(int i2, int i3) {
        this.K = i2;
        this.L = i3;
    }

    public mmm z() {
        return this.Q;
    }

    public void z0(i iVar) throws DocumentException {
        boolean z2 = false;
        if (this.S) {
            throw new DocumentException(qw.ad("an.image.mask.cannot.contain.another.image.mask", new Object[0]));
        } else if (iVar.S) {
            this.T = iVar;
            int i2 = iVar.tt;
            if (i2 > 1 && i2 <= 8) {
                z2 = true;
            }
            this.U = z2;
        } else {
            throw new DocumentException(qw.ad("the.image.mask.is.not.a.mask.did.you.do.makemask", new Object[0]));
        }
    }

    public i(i iVar) {
        super(iVar);
        this.qqq = iVar.qqq;
        this.eee = iVar.eee;
        this.rrr = iVar.rrr;
        this.tt = iVar.tt;
        this.e = iVar.e;
        this.f = iVar.f;
        this.g = iVar.g;
        this.h = iVar.h;
        this.j = iVar.j;
        this.k = iVar.k;
        this.l = iVar.l;
        this.m = iVar.m;
        this.n = iVar.n;
        this.q = iVar.q;
        this.u = iVar.u;
        this.v = iVar.v;
        this.w = iVar.w;
        this.x = iVar.x;
        this.y = iVar.y;
        this.z = iVar.z;
        this.A = iVar.A;
        this.B = iVar.B;
        this.C = iVar.C;
        this.D = iVar.D;
        this.E = iVar.E;
        this.F = iVar.F;
        this.G = iVar.G;
        this.H = iVar.H;
        this.I = iVar.I;
        this.J = iVar.J;
        this.K = iVar.K;
        this.L = iVar.L;
        this.M = iVar.M;
        this.N = iVar.N;
        this.P = iVar.P;
        this.Q = iVar.Q;
        this.R = iVar.R;
        this.S = iVar.S;
        this.T = iVar.T;
        this.U = iVar.U;
        this.V = iVar.V;
        this.r = iVar.r;
        if (iVar.s != null) {
            this.s = new HashMap<>(iVar.s);
        }
        setId(iVar.getId());
    }
}
