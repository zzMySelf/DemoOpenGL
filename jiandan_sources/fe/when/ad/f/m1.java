package fe.when.ad.f;

import androidx.core.graphics.drawable.IconCompat;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.zip.InflaterInputStream;

public class m1 implements PdfViewerPreferences {
    public static final Logger ddd;
    public static final byte[] mmm = a0.de("endobj", (String) null);
    public static final byte[] nn = a0.de("endstream", (String) null);
    public static boolean xxx = false;

    /* renamed from: ad  reason: collision with root package name */
    public PRTokeniser f9524ad;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public ad f9525i;

    /* renamed from: if  reason: not valid java name */
    public int f423if;

    /* renamed from: o  reason: collision with root package name */
    public b0 f9526o;

    /* renamed from: pf  reason: collision with root package name */
    public ArrayList<w1> f9527pf;
    public boolean ppp;

    /* renamed from: switch  reason: not valid java name */
    public int f424switch;

    /* renamed from: th  reason: collision with root package name */
    public long[] f9528th;

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<y0> f9529uk;
    public int vvv;
    public int when;

    /* renamed from: yj  reason: collision with root package name */
    public rrr f9530yj;

    public static class ad {
        public abstract c ad(int i2);

        public abstract void de(int i2);

        public abstract x qw(int i2);
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.itextpdf.text.pdf.PRTokeniser$TokenType[] r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.REF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.ENDOFFILE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.m1.qw.<clinit>():void");
        }
    }

    static {
        Class<m1> cls = m1.class;
        ddd = fe.when.ad.e.ad.qw(cls);
        s0 s0Var = s0.W2;
        s0 s0Var2 = s0.v4;
        s0 s0Var3 = s0.s4;
        s0 s0Var4 = s0.h0;
        fe.when.ad.e.qw.qw(cls);
    }

    public static byte[] aaa(d dVar, e2 e2Var) throws IOException {
        return yj(eee(dVar, e2Var), dVar);
    }

    public static byte[] ad(byte[] bArr) {
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && (b = bArr[i2] & 255) != 62) {
            if (!PRTokeniser.m678switch(b)) {
                int th2 = PRTokeniser.th(b);
                if (th2 != -1) {
                    if (z) {
                        i3 = th2;
                    } else {
                        byteArrayOutputStream.write((byte) ((i3 << 4) + th2));
                    }
                    z = !z;
                } else {
                    throw new RuntimeException(fe.when.ad.c.qw.ad("illegal.character.in.asciihexdecode", new Object[0]));
                }
            }
            i2++;
        }
        if (!z) {
            byteArrayOutputStream.write((byte) (i3 << 4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static y0 ddd(y0 y0Var) {
        y0 ggg2 = ggg(y0Var);
        g(y0Var);
        return ggg2;
    }

    public static byte[] de(byte[] bArr) {
        byte[] fe2 = fe(bArr, true);
        return fe2 == null ? fe(bArr, false) : fe2;
    }

    public static byte[] eee(d dVar, e2 e2Var) throws IOException {
        m1 v = dVar.v();
        if (dVar.u() < 0) {
            return dVar.th();
        }
        byte[] bArr = new byte[dVar.r()];
        e2Var.when(dVar.u());
        e2Var.readFully(bArr);
        b0 pf2 = v.pf();
        if (pf2 != null) {
            y0 ddd2 = ddd(dVar.qqq(s0.e1));
            ArrayList<y0> arrayList = new ArrayList<>();
            if (ddd2 != null) {
                if (ddd2.m1125switch()) {
                    arrayList.add(ddd2);
                } else if (ddd2.i()) {
                    arrayList = ((k) ddd2).b();
                }
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 < arrayList.size()) {
                    y0 ddd3 = ddd(arrayList.get(i2));
                    if (ddd3 != null && ddd3.toString().equals("/Crypt")) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (!z) {
                pf2.pf(dVar.t(), dVar.s());
                return pf2.fe(bArr);
            }
        }
        return bArr;
    }

    public static byte[] fe(byte[] bArr, boolean z) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[(z ? 4092 : 1)];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Exception unused) {
                if (z) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void g(y0 y0Var) {
        int i2;
        if (y0Var != null && y0Var.m1124if() && (y0Var instanceof c)) {
            c cVar = (c) y0Var;
            m1 qqq = cVar.qqq();
            if (qqq.ppp && (i2 = qqq.when) != -1 && i2 == cVar.getNumber()) {
                qqq.f9529uk.set(qqq.when, (Object) null);
            }
            qqq.when = -1;
        }
    }

    public static y0 ggg(y0 y0Var) {
        y0 lVar;
        if (y0Var == null) {
            return null;
        }
        if (!y0Var.m1124if()) {
            return y0Var;
        }
        try {
            c cVar = (c) y0Var;
            int number = cVar.getNumber();
            boolean z = cVar.qqq().ggg;
            y0 ppp2 = cVar.qqq().ppp(number);
            if (ppp2 == null) {
                return null;
            }
            if (z) {
                int mmm2 = ppp2.mmm();
                if (mmm2 == 1) {
                    lVar = new l(((l) ppp2).aaa());
                } else if (mmm2 == 4) {
                    lVar = new s0(ppp2.th());
                } else if (mmm2 != 8) {
                    ppp2.ddd(cVar);
                } else {
                    lVar = new u0();
                }
                ppp2 = lVar;
                ppp2.ddd(cVar);
            }
            return ppp2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] i(byte[] bArr, y0 y0Var) {
        byte[] bArr2 = bArr;
        if (y0Var == null || !y0Var.pf()) {
            return bArr2;
        }
        x xVar = (x) y0Var;
        y0 ggg2 = ggg(xVar.qqq(s0.W3));
        if (ggg2 == null || !ggg2.ppp()) {
            return bArr2;
        }
        int eee = ((v0) ggg2).eee();
        if (eee < 10 && eee != 2) {
            return bArr2;
        }
        y0 ggg3 = ggg(xVar.qqq(s0.Y));
        int eee2 = (ggg3 == null || !ggg3.ppp()) ? 1 : ((v0) ggg3).eee();
        y0 ggg4 = ggg(xVar.qqq(s0.S));
        int eee3 = (ggg4 == null || !ggg4.ppp()) ? 1 : ((v0) ggg4).eee();
        y0 ggg5 = ggg(xVar.qqq(s0.p));
        int eee4 = (ggg5 == null || !ggg5.ppp()) ? 8 : ((v0) ggg5).eee();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr2.length);
        int i2 = (eee3 * eee4) / 8;
        int i3 = (((eee3 * eee2) * eee4) + 7) / 8;
        byte[] bArr3 = new byte[i3];
        byte[] bArr4 = new byte[i3];
        if (eee == 2) {
            if (eee4 == 8) {
                int length = bArr2.length / i3;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * i3;
                    for (int i6 = i2 + 0; i6 < i3; i6++) {
                        int i7 = i5 + i6;
                        bArr2[i7] = (byte) (bArr2[i7] + bArr2[i7 - i2]);
                    }
                }
            }
            return bArr2;
        }
        while (true) {
            try {
                int read = dataInputStream.read();
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                dataInputStream.readFully(bArr3, 0, i3);
                if (read != 0) {
                    if (read == 1) {
                        for (int i8 = i2; i8 < i3; i8++) {
                            bArr3[i8] = (byte) (bArr3[i8] + bArr3[i8 - i2]);
                        }
                    } else if (read == 2) {
                        for (int i9 = 0; i9 < i3; i9++) {
                            bArr3[i9] = (byte) (bArr3[i9] + bArr4[i9]);
                        }
                    } else if (read == 3) {
                        for (int i10 = 0; i10 < i2; i10++) {
                            bArr3[i10] = (byte) (bArr3[i10] + (bArr4[i10] / 2));
                        }
                        for (int i11 = i2; i11 < i3; i11++) {
                            bArr3[i11] = (byte) (bArr3[i11] + (((bArr3[i11 - i2] & 255) + (bArr4[i11] & 255)) / 2));
                        }
                    } else if (read == 4) {
                        for (int i12 = 0; i12 < i2; i12++) {
                            bArr3[i12] = (byte) (bArr3[i12] + bArr4[i12]);
                        }
                        for (int i13 = i2; i13 < i3; i13++) {
                            int i14 = i13 - i2;
                            byte b = bArr3[i14] & 255;
                            byte b2 = bArr4[i13] & 255;
                            byte b3 = bArr4[i14] & 255;
                            int i15 = (b + b2) - b3;
                            int abs = Math.abs(i15 - b);
                            int abs2 = Math.abs(i15 - b2);
                            int abs3 = Math.abs(i15 - b3);
                            if (abs > abs2 || abs > abs3) {
                                b = abs2 <= abs3 ? b2 : b3;
                            }
                            bArr3[i13] = (byte) (bArr3[i13] + ((byte) b));
                        }
                    } else {
                        throw new RuntimeException(fe.when.ad.c.qw.ad("png.filter.unknown", new Object[0]));
                    }
                }
                try {
                    byteArrayOutputStream.write(bArr3);
                } catch (IOException unused) {
                }
                byte[] bArr5 = bArr4;
                bArr4 = bArr3;
                bArr3 = bArr5;
            } catch (Exception unused2) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean o(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] qqq(d dVar) throws IOException {
        e2 mmm2 = dVar.v().mmm();
        try {
            mmm2.fe();
            return eee(dVar, mmm2);
        } finally {
            try {
                mmm2.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] qw(byte[] bArr) {
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int[] iArr = new int[5];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && (b = bArr[i2] & 255) != 126) {
            if (!PRTokeniser.m678switch(b)) {
                if (b == 122 && i3 == 0) {
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                } else if (b < 33 || b > 117) {
                    throw new RuntimeException(fe.when.ad.c.qw.ad("illegal.character.in.ascii85decode", new Object[0]));
                } else {
                    iArr[i3] = b - 33;
                    i3++;
                    if (i3 == 5) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < 5; i5++) {
                            i4 = (i4 * 85) + iArr[i5];
                        }
                        byteArrayOutputStream.write((byte) (i4 >> 24));
                        byteArrayOutputStream.write((byte) (i4 >> 16));
                        byteArrayOutputStream.write((byte) (i4 >> 8));
                        byteArrayOutputStream.write((byte) i4);
                        i3 = 0;
                    }
                }
            }
            i2++;
        }
        if (i3 == 2) {
            byteArrayOutputStream.write((byte) (((((((((iArr[0] * 85) * 85) * 85) * 85) + (((iArr[1] * 85) * 85) * 85)) + 614125) + 7225) + 85) >> 24));
        } else if (i3 == 3) {
            int i6 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + 7225 + 85;
            byteArrayOutputStream.write((byte) (i6 >> 24));
            byteArrayOutputStream.write((byte) (i6 >> 16));
        } else if (i3 == 4) {
            int i7 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + (iArr[3] * 85) + 85;
            byteArrayOutputStream.write((byte) (i7 >> 24));
            byteArrayOutputStream.write((byte) (i7 >> 16));
            byteArrayOutputStream.write((byte) (i7 >> 8));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] rg(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new qqq().fe(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] uk(byte[] bArr, x xVar, Map<s0, FilterHandlers.FilterHandler> map) throws IOException {
        y0 ddd2 = ddd(xVar.qqq(s0.e1));
        ArrayList<y0> arrayList = new ArrayList<>();
        if (ddd2 != null) {
            if (ddd2.m1125switch()) {
                arrayList.add(ddd2);
            } else if (ddd2.i()) {
                arrayList = ((k) ddd2).b();
            }
        }
        ArrayList<y0> arrayList2 = new ArrayList<>();
        y0 ddd3 = ddd(xVar.qqq(s0.p0));
        if (ddd3 == null || (!ddd3.pf() && !ddd3.i())) {
            ddd3 = ddd(xVar.qqq(s0.D0));
        }
        if (ddd3 != null) {
            if (ddd3.pf()) {
                arrayList2.add(ddd3);
            } else if (ddd3.i()) {
                arrayList2 = ((k) ddd3).b();
            }
        }
        int i2 = 0;
        while (i2 < arrayList.size()) {
            s0 s0Var = (s0) arrayList.get(i2);
            FilterHandlers.FilterHandler filterHandler = map.get(s0Var);
            if (filterHandler != null) {
                x xVar2 = null;
                if (i2 < arrayList2.size()) {
                    y0 ggg2 = ggg(arrayList2.get(i2));
                    if (ggg2 instanceof x) {
                        xVar2 = (x) ggg2;
                    } else if (ggg2 != null && !(ggg2 instanceof u0)) {
                        throw new UnsupportedPdfException(fe.when.ad.c.qw.ad("the.decode.parameter.type.1.is.not.supported", ggg2.getClass().toString()));
                    }
                }
                bArr = filterHandler.qw(bArr, s0Var, xVar2, xVar);
                i2++;
            } else {
                throw new UnsupportedPdfException(fe.when.ad.c.qw.ad("the.filter.1.is.not.supported", s0Var));
            }
        }
        return bArr;
    }

    public static y0 vvv(y0 y0Var, y0 y0Var2) {
        c uk2;
        y0 y0Var3;
        if (y0Var == null) {
            return null;
        }
        if (y0Var.m1124if()) {
            return ggg(y0Var);
        }
        if (!(y0Var2 == null || (uk2 = y0Var2.uk()) == null || !uk2.qqq().tt())) {
            int mmm2 = y0Var.mmm();
            if (mmm2 == 1) {
                y0Var3 = new l(((l) y0Var).aaa());
            } else if (mmm2 != 4) {
                if (mmm2 == 8) {
                    y0Var = new u0();
                }
                y0Var.ddd(uk2);
            } else {
                y0Var3 = new s0(y0Var.th());
            }
            y0Var = y0Var3;
            y0Var.ddd(uk2);
        }
        return y0Var;
    }

    public static byte[] yj(byte[] bArr, x xVar) throws IOException {
        return uk(bArr, xVar, FilterHandlers.qw());
    }

    public k a() throws IOException {
        k kVar = new k();
        while (true) {
            y0 d = d();
            int i2 = -d.mmm();
            if (i2 == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return kVar;
            }
            if (i2 != PRTokeniser.TokenType.END_DIC.ordinal()) {
                kVar.qqq(d);
            } else {
                this.f9524ad.aaa(fe.when.ad.c.qw.ad("unexpected.gt.gt", new Object[0]));
                throw null;
            }
        }
    }

    public x b() throws IOException {
        x xVar = new x();
        while (true) {
            this.f9524ad.vvv();
            if (this.f9524ad.o() == PRTokeniser.TokenType.END_DIC) {
                return xVar;
            }
            if (this.f9524ad.o() == PRTokeniser.TokenType.NAME) {
                s0 s0Var = new s0(this.f9524ad.i(), false);
                y0 d = d();
                int i2 = -d.mmm();
                if (i2 == PRTokeniser.TokenType.END_DIC.ordinal()) {
                    this.f9524ad.aaa(fe.when.ad.c.qw.ad("unexpected.gt.gt", new Object[0]));
                    throw null;
                } else if (i2 != PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                    xVar.h(s0Var, d);
                } else {
                    this.f9524ad.aaa(fe.when.ad.c.qw.ad("unexpected.close.bracket", new Object[0]));
                    throw null;
                }
            } else {
                PRTokeniser pRTokeniser = this.f9524ad;
                pRTokeniser.aaa(fe.when.ad.c.qw.ad("dictionary.key.1.is.not.a.name", pRTokeniser.i()));
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r8 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.f.y0 c(fe.when.ad.f.d r8, int r9) throws java.io.IOException {
        /*
            r7 = this;
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.f1
            fe.when.ad.f.v0 r0 = r8.b(r0)
            int r0 = r0.eee()
            com.itextpdf.text.pdf.PRTokeniser r1 = r7.f9524ad
            fe.when.ad.f.e2 r1 = r1.de()
            byte[] r8 = aaa(r8, r1)
            com.itextpdf.text.pdf.PRTokeniser r1 = r7.f9524ad
            com.itextpdf.text.pdf.PRTokeniser r2 = new com.itextpdf.text.pdf.PRTokeniser
            fe.when.ad.f.e2 r3 = new fe.when.ad.f.e2
            fe.when.ad.d.o r4 = new fe.when.ad.d.o
            r4.<init>()
            com.itextpdf.text.io.RandomAccessSource r8 = r4.yj(r8)
            r3.<init>((com.itextpdf.text.io.RandomAccessSource) r8)
            r2.<init>(r3)
            r7.f9524ad = r2
            r8 = 1
            int r9 = r9 + r8
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0030:
            if (r3 >= r9) goto L_0x0067
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            boolean r8 = r8.ggg()     // Catch:{ all -> 0x0065 }
            if (r8 != 0) goto L_0x003b
            goto L_0x0067
        L_0x003b:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = r8.o()     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r5 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x0065 }
            if (r8 == r5) goto L_0x0047
        L_0x0045:
            r8 = 0
            goto L_0x0067
        L_0x0047:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            boolean r8 = r8.ggg()     // Catch:{ all -> 0x0065 }
            if (r8 != 0) goto L_0x0050
            goto L_0x0067
        L_0x0050:
            com.itextpdf.text.pdf.PRTokeniser r5 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r5 = r5.o()     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r6 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x0065 }
            if (r5 == r6) goto L_0x005b
            goto L_0x0045
        L_0x005b:
            com.itextpdf.text.pdf.PRTokeniser r4 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            int r4 = r4.pf()     // Catch:{ all -> 0x0065 }
            int r4 = r4 + r0
            int r3 = r3 + 1
            goto L_0x0030
        L_0x0065:
            r8 = move-exception
            goto L_0x00a4
        L_0x0067:
            if (r8 == 0) goto L_0x0096
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            long r2 = (long) r4     // Catch:{ all -> 0x0065 }
            r8.mmm(r2)     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            r8.ggg()     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = r8.o()     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r9 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x0065 }
            if (r8 != r9) goto L_0x008a
            fe.when.ad.f.v0 r8 = new fe.when.ad.f.v0     // Catch:{ all -> 0x0065 }
            com.itextpdf.text.pdf.PRTokeniser r9 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            java.lang.String r9 = r9.i()     // Catch:{ all -> 0x0065 }
            r8.<init>((java.lang.String) r9)     // Catch:{ all -> 0x0065 }
            goto L_0x0093
        L_0x008a:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.f9524ad     // Catch:{ all -> 0x0065 }
            r8.mmm(r2)     // Catch:{ all -> 0x0065 }
            fe.when.ad.f.y0 r8 = r7.d()     // Catch:{ all -> 0x0065 }
        L_0x0093:
            r7.f9524ad = r1
            return r8
        L_0x0096:
            com.itextpdf.text.exceptions.InvalidPdfException r8 = new com.itextpdf.text.exceptions.InvalidPdfException     // Catch:{ all -> 0x0065 }
            java.lang.String r9 = "error.reading.objstm"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0065 }
            java.lang.String r9 = fe.when.ad.c.qw.ad(r9, r0)     // Catch:{ all -> 0x0065 }
            r8.<init>(r9)     // Catch:{ all -> 0x0065 }
            throw r8     // Catch:{ all -> 0x0065 }
        L_0x00a4:
            r7.f9524ad = r1
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.m1.c(fe.when.ad.f.d, int):fe.when.ad.f.y0");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e6 A[LOOP:1: B:34:0x00e6->B:72:0x00e6, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.when.ad.f.y0 d() throws java.io.IOException {
        /*
            r6 = this;
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.f9524ad
            r0.vvv()
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.f9524ad
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = r0.o()
            int[] r1 = fe.when.ad.f.m1.qw.qw
            int r2 = r0.ordinal()
            r1 = r1[r2]
            r2 = 0
            r3 = 1
            switch(r1) {
                case 1: goto L_0x00b0;
                case 2: goto L_0x00a1;
                case 3: goto L_0x0095;
                case 4: goto L_0x0071;
                case 5: goto L_0x0050;
                case 6: goto L_0x003e;
                case 7: goto L_0x0030;
                default: goto L_0x0018;
            }
        L_0x0018:
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            java.lang.String r1 = r1.i()
            java.lang.String r4 = "null"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x012a
            int r0 = r6.vvv
            if (r0 != 0) goto L_0x0127
            fe.when.ad.f.u0 r0 = new fe.when.ad.f.u0
            r0.<init>()
            return r0
        L_0x0030:
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "unexpected.end.of.file"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x003e:
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.f9524ad
            int r0 = r0.yj()
            fe.when.ad.f.c r1 = new fe.when.ad.f.c
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.f9524ad
            int r2 = r2.rg()
            r1.<init>(r6, r0, r2)
            return r1
        L_0x0050:
            java.util.Map<java.lang.String, fe.when.ad.f.s0> r0 = fe.when.ad.f.s0.C6
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            java.lang.String r1 = r1.i()
            java.lang.Object r0 = r0.get(r1)
            fe.when.ad.f.s0 r0 = (fe.when.ad.f.s0) r0
            int r1 = r6.vvv
            if (r1 <= 0) goto L_0x0065
            if (r0 == 0) goto L_0x0065
            return r0
        L_0x0065:
            fe.when.ad.f.s0 r0 = new fe.when.ad.f.s0
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            java.lang.String r1 = r1.i()
            r0.<init>(r1, r2)
            return r0
        L_0x0071:
            fe.when.ad.f.w1 r0 = new fe.when.ad.f.w1
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            java.lang.String r1 = r1.i()
            r2 = 0
            r0.<init>(r1, r2)
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            boolean r1 = r1.m679if()
            r0.eee(r1)
            int r1 = r6.f423if
            int r2 = r6.f424switch
            r0.rrr(r1, r2)
            java.util.ArrayList<fe.when.ad.f.w1> r1 = r6.f9527pf
            if (r1 == 0) goto L_0x0094
            r1.add(r0)
        L_0x0094:
            return r0
        L_0x0095:
            fe.when.ad.f.v0 r0 = new fe.when.ad.f.v0
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            java.lang.String r1 = r1.i()
            r0.<init>((java.lang.String) r1)
            return r0
        L_0x00a1:
            int r0 = r6.vvv
            int r0 = r0 + r3
            r6.vvv = r0
            fe.when.ad.f.k r0 = r6.a()
            int r1 = r6.vvv
            int r1 = r1 - r3
            r6.vvv = r1
            return r0
        L_0x00b0:
            int r0 = r6.vvv
            int r0 = r0 + r3
            r6.vvv = r0
            fe.when.ad.f.x r0 = r6.b()
            int r1 = r6.vvv
            int r1 = r1 - r3
            r6.vvv = r1
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            long r1 = r1.fe()
        L_0x00c4:
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.f9524ad
            boolean r3 = r3.ggg()
            if (r3 == 0) goto L_0x00d6
            com.itextpdf.text.pdf.PRTokeniser r4 = r6.f9524ad
            com.itextpdf.text.pdf.PRTokeniser$TokenType r4 = r4.o()
            com.itextpdf.text.pdf.PRTokeniser$TokenType r5 = com.itextpdf.text.pdf.PRTokeniser.TokenType.COMMENT
            if (r4 == r5) goto L_0x00c4
        L_0x00d6:
            if (r3 == 0) goto L_0x0121
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.f9524ad
            java.lang.String r3 = r3.i()
            java.lang.String r4 = "stream"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0121
        L_0x00e6:
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            int r1 = r1.xxx()
            r2 = 32
            if (r1 == r2) goto L_0x00e6
            r2 = 9
            if (r1 == r2) goto L_0x00e6
            if (r1 == 0) goto L_0x00e6
            r2 = 12
            if (r1 == r2) goto L_0x00e6
            r2 = 10
            if (r1 == r2) goto L_0x0104
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.f9524ad
            int r1 = r1.xxx()
        L_0x0104:
            if (r1 == r2) goto L_0x010b
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.f9524ad
            r2.qw(r1)
        L_0x010b:
            fe.when.ad.f.d r1 = new fe.when.ad.f.d
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.f9524ad
            long r2 = r2.fe()
            r1.<init>((fe.when.ad.f.m1) r6, (long) r2)
            r1.j(r0)
            int r0 = r6.f423if
            int r2 = r6.f424switch
            r1.x(r0, r2)
            return r1
        L_0x0121:
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.f9524ad
            r3.mmm(r1)
            return r0
        L_0x0127:
            fe.when.ad.f.u0 r0 = fe.when.ad.f.u0.f9819uk
            return r0
        L_0x012a:
            java.lang.String r4 = "true"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x013f
            int r0 = r6.vvv
            if (r0 != 0) goto L_0x013c
            fe.when.ad.f.l r0 = new fe.when.ad.f.l
            r0.<init>(r3)
            return r0
        L_0x013c:
            fe.when.ad.f.l r0 = fe.when.ad.f.l.f9519i
            return r0
        L_0x013f:
            java.lang.String r3 = "false"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0154
            int r0 = r6.vvv
            if (r0 != 0) goto L_0x0151
            fe.when.ad.f.l r0 = new fe.when.ad.f.l
            r0.<init>(r2)
            return r0
        L_0x0151:
            fe.when.ad.f.l r0 = fe.when.ad.f.l.f9520o
            return r0
        L_0x0154:
            fe.when.ad.f.q0 r1 = new fe.when.ad.f.q0
            int r0 = r0.ordinal()
            int r0 = -r0
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.f9524ad
            java.lang.String r2 = r2.i()
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.m1.d():fe.when.ad.f.y0");
    }

    public y0 e(int i2) throws IOException {
        this.f9527pf.clear();
        int i3 = i2 * 2;
        long[] jArr = this.f9528th;
        long j = jArr[i3];
        y0 y0Var = null;
        if (j < 0) {
            return null;
        }
        int i4 = i3 + 1;
        if (jArr[i4] > 0) {
            j = this.f9530yj.ad(jArr[i4]);
        }
        if (j == 0) {
            return null;
        }
        this.f9524ad.mmm(j);
        this.f9524ad.vvv();
        if (this.f9524ad.o() == PRTokeniser.TokenType.NUMBER) {
            this.f423if = this.f9524ad.pf();
            this.f9524ad.vvv();
            if (this.f9524ad.o() == PRTokeniser.TokenType.NUMBER) {
                this.f424switch = this.f9524ad.pf();
                this.f9524ad.vvv();
                if (this.f9524ad.i().equals(IconCompat.EXTRA_OBJ)) {
                    try {
                        y0 d = d();
                        for (int i5 = 0; i5 < this.f9527pf.size(); i5++) {
                            this.f9527pf.get(i5).aaa(this);
                        }
                        if (d.ggg()) {
                            th((d) d);
                        }
                        y0Var = d;
                    } catch (IOException e) {
                        if (!xxx) {
                            throw e;
                        } else if (ddd.qw(Level.ERROR)) {
                            ddd.ad(e.getMessage(), e);
                        }
                    }
                    long[] jArr2 = this.f9528th;
                    if (jArr2[i4] > 0) {
                        y0Var = c((d) y0Var, (int) jArr2[i3]);
                    }
                    this.f9529uk.set(i2, y0Var);
                    return y0Var;
                }
                this.f9524ad.aaa(fe.when.ad.c.qw.ad("token.obj.expected", new Object[0]));
                throw null;
            }
            this.f9524ad.aaa(fe.when.ad.c.qw.ad("invalid.generation.number", new Object[0]));
            throw null;
        }
        this.f9524ad.aaa(fe.when.ad.c.qw.ad("invalid.object.number", new Object[0]));
        throw null;
    }

    public void f() {
        int i2;
        if (this.ppp && (i2 = this.when) != -1) {
            this.f9529uk.set(i2, (Object) null);
            this.when = -1;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public byte[] m1089if(int i2, e2 e2Var) throws IOException {
        x when2 = when(i2);
        if (when2 == null) {
            return null;
        }
        y0 ddd2 = ddd(when2.qqq(s0.Z));
        if (ddd2 == null) {
            return new byte[0];
        }
        if (ddd2.ggg()) {
            return aaa((d) ddd2, e2Var);
        }
        if (!ddd2.i()) {
            return new byte[0];
        }
        k kVar = (k) ddd2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < kVar.size(); i3++) {
            y0 ddd3 = ddd(kVar.g(i3));
            if (ddd3 != null && ddd3.ggg()) {
                byteArrayOutputStream.write(aaa((d) ddd3, e2Var));
                if (i3 != kVar.size() - 1) {
                    byteArrayOutputStream.write(10);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public e2 mmm() {
        return this.f9524ad.uk();
    }

    public n1 nn(c2 c2Var) {
        return new n1(this, c2Var);
    }

    public b0 pf() {
        return this.f9526o;
    }

    public y0 ppp(int i2) {
        try {
            this.when = -1;
            if (i2 >= 0) {
                if (i2 < this.f9529uk.size()) {
                    y0 y0Var = this.f9529uk.get(i2);
                    if (this.ppp) {
                        if (y0Var == null) {
                            if (i2 * 2 >= this.f9528th.length) {
                                return null;
                            }
                            y0 e = e(i2);
                            this.when = -1;
                            if (e != null) {
                                this.when = i2;
                            }
                            return e;
                        }
                    }
                    return y0Var;
                }
            }
            return null;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public int rrr() {
        return this.f9529uk.size();
    }

    /* renamed from: switch  reason: not valid java name */
    public x m1090switch(int i2) {
        x qw2 = this.f9525i.qw(i2);
        if (qw2 == null) {
            return null;
        }
        if (this.ggg) {
            qw2.ddd(this.f9525i.ad(i2));
        }
        return qw2;
    }

    public final void th(d dVar) throws IOException {
        long j;
        long fe2;
        long ppp2 = this.f9524ad.ppp();
        long u = dVar.u();
        y0 ddd2 = ddd(dVar.qqq(s0.F2));
        boolean z = true;
        if (ddd2 == null || ddd2.mmm() != 2) {
            j = 0;
        } else {
            j = (long) ((v0) ddd2).eee();
            long j2 = j + u;
            if (j2 <= ppp2 - 20) {
                this.f9524ad.mmm(j2);
                String nn2 = this.f9524ad.nn(20);
                if (nn2.startsWith("\nendstream") || nn2.startsWith("\r\nendstream") || nn2.startsWith("\rendstream") || nn2.startsWith("endstream")) {
                    z = false;
                }
            }
        }
        if (z) {
            byte[] bArr = new byte[16];
            this.f9524ad.mmm(u);
            while (true) {
                fe2 = this.f9524ad.fe();
                if (this.f9524ad.ddd(bArr, false)) {
                    if (o(bArr, nn)) {
                        break;
                    } else if (o(bArr, mmm)) {
                        long j3 = fe2 - 16;
                        this.f9524ad.mmm(j3);
                        int indexOf = this.f9524ad.nn(16).indexOf("endstream");
                        if (indexOf >= 0) {
                            fe2 = j3 + ((long) indexOf);
                        }
                    }
                } else {
                    break;
                }
            }
            j = fe2 - u;
            this.f9524ad.mmm(fe2 - 2);
            if (this.f9524ad.xxx() == 13) {
                j--;
            }
            this.f9524ad.mmm(fe2 - 1);
            if (this.f9524ad.xxx() == 10) {
                j--;
            }
        }
        dVar.w((int) j);
    }

    public boolean tt() {
        return this.ggg;
    }

    public x when(int i2) {
        x xVar = m1090switch(i2);
        this.f9525i.de(i2);
        return xVar;
    }

    public y0 xxx(int i2) {
        y0 ppp2 = ppp(i2);
        f();
        return ppp2;
    }
}
