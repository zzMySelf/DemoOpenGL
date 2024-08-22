package fe.when.ad.f;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.ICachedColorSpace;
import com.itextpdf.text.pdf.IPdfSpecialColorSpace;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.PdfAnnotations;
import com.itextpdf.text.pdf.interfaces.PdfDocumentActions;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfIsoConformance;
import com.itextpdf.text.pdf.interfaces.PdfPageActions;
import com.itextpdf.text.pdf.interfaces.PdfRunDirection;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;
import fe.when.ad.Cswitch;
import fe.when.ad.b;
import fe.when.ad.de;
import fe.when.ad.f.s2.fe;
import fe.when.ad.f.y;
import fe.when.ad.i;
import fe.when.ad.pf;
import fe.when.ad.rg;
import fe.when.ad.th;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class c2 extends rg implements PdfViewerPreferences, PdfEncryptionSettings, PdfVersion, PdfDocumentActions, PdfPageActions, PdfRunDirection, PdfAnnotations {
    public static Counter S = fe.when.ad.e.qw.qw(c2.class);
    public static final s0 T = new s0("1.2");
    public static final s0 U = new s0("1.3");
    public static final s0 V = new s0("1.4");
    public static final s0 W = new s0("1.5");
    public static final s0 X = new s0("1.6");
    public static final s0 Y = new s0("1.7");
    public static final List<s0> Z = Arrays.asList(new s0[]{s0.C0, s0.Q3, s0.qqq, s0.H4, s0.B0, s0.s, s0.D, s0.z5, s0.A5, s0.f2, s0.k3, s0.e4, s0.F3, s0.I1, s0.J1, s0.K1, s0.L1, s0.M1, s0.N1, s0.O1, s0.v2, s0.D2, s0.G2, s0.E2, s0.f5, s0.j5, s0.r5, s0.i5, s0.Q4, s0.h4, s0.l3, s0.n4, s0.n, s0.Q, s0.J2, s0.c1, s0.A1, s0.y1});
    public static final List<s0> a0 = Arrays.asList(new s0[]{s0.C0, s0.Q3, s0.qqq, s0.H4, s0.B0, s0.s, s0.D, s0.z5, s0.A5, s0.f2, s0.k3, s0.e4, s0.F3, s0.I1, s0.J1, s0.K1, s0.L1, s0.M1, s0.N1, s0.O1, s0.v2, s0.D2, s0.G2, s0.E2, s0.f5, s0.j5, s0.r5, s0.i5, s0.s5, s0.h5, s0.q5, s0.Q4, s0.h4, s0.l3, s0.n4, s0.n, s0.Q, s0.J2, s0.ddd, s0.B4, s0.k4, s0.A4, s0.z4, s0.j6, s0.s6, s0.q6, s0.c1, s0.A1, s0.y1});
    public HashSet<PdfOCG> A = new HashSet<>();
    public ArrayList<PdfOCG> B = new ArrayList<>();
    public x0 C;
    public k D = new k();
    public k E = new k();
    public x F;
    public float G = 2.5f;
    public x H = new x();
    public HashMap<o, o> I = new HashMap<>();
    public o J;
    public o K;
    public o L;
    public x M = new x();
    public final HashMap<Long, s0> N = new HashMap<>();
    public HashMap<v1, l0> O = new HashMap<>();
    public boolean P;
    public boolean Q;
    public l2 R = null;
    public List<HashMap<String, Object>> aaa;
    public PdfPageEvent ddd;
    public b0 e;
    public byte[] eee = null;
    public boolean f = false;
    public int g = -1;
    public int ggg = 1;
    public LinkedHashMap<ad, vvv> h = new LinkedHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public y f9374i;

    /* renamed from: if  reason: not valid java name */
    public qw f406if;
    public int j = 1;
    public HashMap<l0, Object[]> k = new HashMap<>();
    public int l = 1;
    public HashMap<m1, n1> m = new HashMap<>();
    public byte[] mmm = null;
    public n1 n;
    public long nn = 0;

    /* renamed from: o  reason: collision with root package name */
    public q f9375o;
    public HashMap<ICachedColorSpace, o> p = new HashMap<>();

    /* renamed from: pf  reason: collision with root package name */
    public q f9376pf;
    public ArrayList<l0> ppp = new ArrayList<>();
    public int q = 1;
    public fe.when.ad.f.s2.ad qqq = new fe.when.ad.f.s2.ad();
    public HashMap<l1, s0> r = new HashMap<>();
    public fe.when.ad.g.de.qw rrr = null;
    public int s = 1;

    /* renamed from: switch  reason: not valid java name */
    public x f407switch;
    public HashSet<s1> t = new HashSet<>();
    public PdfIsoConformance tt = V();
    public HashSet<r1> u = new HashSet<>();
    public HashMap<x, y0[]> v = new HashMap<>();
    public s0 vvv = null;
    public HashMap<Object, y0[]> w = new HashMap<>();
    public j1 when = new j1(this);
    public boolean x = false;
    public x xxx = new x();
    public int y = 1;
    public y1 z;

    public static class ad extends x {

        /* renamed from: switch  reason: not valid java name */
        public long f408switch;

        public ad(int i2, long j, l0 l0Var, l0 l0Var2, l0 l0Var3, y0 y0Var, long j2) {
            this.f408switch = j;
            h(s0.M4, new v0(i2));
            h(s0.u4, l0Var);
            if (l0Var2 != null) {
                h(s0.h2, l0Var2);
            }
            if (l0Var3 != null) {
                h(s0.Q0, l0Var3);
            }
            if (y0Var != null) {
                h(s0.a2, y0Var);
            }
            if (j2 > 0) {
                h(s0.X3, new v0(j2));
            }
        }

        public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
            c2.g(c2Var, 8, this);
            outputStream.write(rg.rg("trailer\n"));
            super.nn((c2) null, outputStream);
            outputStream.write(10);
            c2.g0(outputStream);
            outputStream.write(rg.rg("startxref\n"));
            outputStream.write(rg.rg(String.valueOf(this.f408switch)));
            outputStream.write(rg.rg("\n%%EOF\n"));
        }
    }

    static {
        s0 s0Var = s0.k6;
        s0 s0Var2 = s0.r6;
        s0 s0Var3 = s0.F0;
        s0 s0Var4 = s0.q6;
        s0 s0Var5 = s0.D0;
        s0 s0Var6 = s0.o3;
        s0 s0Var7 = s0.x;
    }

    public c2() {
    }

    public static c2 D(th thVar, OutputStream outputStream) throws DocumentException {
        y yVar = new y();
        thVar.th(yVar);
        c2 c2Var = new c2(yVar, outputStream);
        yVar.rrr(c2Var);
        return c2Var;
    }

    public static void F(k kVar, n0 n0Var) {
        if (n0Var.q()) {
            if (n0Var.n() == null) {
                kVar.qqq(n0Var.fe());
            }
            ArrayList<n0> l2 = n0Var.l();
            if (l2 != null) {
                k kVar2 = new k();
                if (n0Var.n() != null) {
                    kVar2.qqq(new w1(n0Var.n(), "UnicodeBig"));
                }
                for (int i2 = 0; i2 < l2.size(); i2++) {
                    F(kVar2, l2.get(i2));
                }
                if (kVar2.size() > 0) {
                    kVar.qqq(kVar2);
                }
            }
        }
    }

    public static void g(c2 c2Var, int i2, Object obj) {
        if (c2Var != null) {
            c2Var.f(i2, obj);
        }
    }

    public static void g0(OutputStream outputStream) throws IOException {
        b qw2 = b.qw();
        String ad2 = qw2.ad();
        if (ad2 == null) {
            ad2 = "iText";
        }
        outputStream.write(rg.rg(String.format("%%%s-%s\n", new Object[]{ad2, qw2.de()})));
    }

    public l0 A(s0 s0Var) {
        return (l0) this.M.qqq(s0Var);
    }

    public int B() {
        return this.f406if.i();
    }

    public x C() {
        return this.f9374i.j();
    }

    public int E(m1 m1Var, int i2, int i3) {
        if (this.n == null) {
            this.n = N(m1Var);
        }
        return this.n.ad(i2, i3);
    }

    public a G() {
        return this.f9886ad;
    }

    public int H() {
        PdfIsoConformance pdfIsoConformance = this.tt;
        if (pdfIsoConformance instanceof fe) {
            return ((PdfXConformance) pdfIsoConformance).de();
        }
        return 0;
    }

    public x I() {
        return this.xxx;
    }

    public PdfPageEvent J() {
        return this.ddd;
    }

    public l0 K(int i2) {
        int i3 = i2 - 1;
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(fe.when.ad.c.qw.ad("the.page.number.must.be.gt.eq.1", new Object[0]));
        } else if (i3 < this.ppp.size()) {
            l0 l0Var = this.ppp.get(i3);
            if (l0Var != null) {
                return l0Var;
            }
            l0 o2 = this.f406if.o();
            this.ppp.set(i3, o2);
            return o2;
        } else {
            int size = i3 - this.ppp.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.ppp.add((Object) null);
            }
            l0 o3 = this.f406if.o();
            this.ppp.add(o3);
            return o3;
        }
    }

    public y L() {
        return this.f9374i;
    }

    public l0 M() {
        return this.f406if.o();
    }

    public n1 N(m1 m1Var) {
        n1 n1Var = this.m.get(m1Var);
        if (n1Var != null) {
            return n1Var;
        }
        n1 nn2 = m1Var.nn(this);
        this.m.put(m1Var, nn2);
        return nn2;
    }

    public fe.when.ad.f.s2.ad O() {
        return this.qqq;
    }

    public l0 P(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (v1 next : this.O.keySet()) {
            if (Arrays.equals(bArr, next.th())) {
                return this.O.get(next);
            }
        }
        v1 v1Var = new v1(bArr);
        try {
            k0 eee2 = eee(v1Var);
            this.O.put(v1Var, eee2.qw());
            return eee2.qw();
        } catch (IOException unused) {
            return null;
        }
    }

    public float Q() {
        return this.G;
    }

    public List<s0> R() {
        if (this.qqq.ad() < '7') {
            return Z;
        }
        return a0;
    }

    public y1 S() {
        if (this.x && this.z == null) {
            this.z = new y1(this);
        }
        return this.z;
    }

    public s0 T() {
        return this.vvv;
    }

    public l2 U() {
        if (this.R == null) {
            this.R = new l2(this);
        }
        return this.R;
    }

    public PdfIsoConformance V() {
        return new fe(this);
    }

    public boolean W() {
        return this.f;
    }

    public boolean X() {
        return this.tt.fe();
    }

    public boolean Y() {
        PdfIsoConformance pdfIsoConformance = this.tt;
        if (pdfIsoConformance instanceof fe) {
            return ((PdfXConformance) pdfIsoConformance).qw();
        }
        return false;
    }

    public boolean Z() {
        return this.Q;
    }

    public k0 a(y0 y0Var, l0 l0Var, boolean z2) throws IOException {
        return this.f406if.rg(y0Var, l0Var, z2);
    }

    public boolean a0() {
        return this.x;
    }

    public void aaa(r1 r1Var) {
        if (!this.u.contains(r1Var)) {
            this.u.add(r1Var);
            r1Var.rg(this.u.size());
        }
    }

    public k0 b(y0 y0Var, boolean z2) throws IOException {
        return this.f406if.th(y0Var, z2);
    }

    public boolean b0(IAccessibleElement iAccessibleElement) {
        if ((this.y & 1) == 0 || iAccessibleElement.isInline() || s0.rrr.equals(iAccessibleElement.getRole())) {
            return true;
        }
        return false;
    }

    public void c() throws IOException {
        for (Object[] objArr : this.k.values()) {
            z1 z1Var = (z1) objArr[1];
            if ((z1Var == null || !(z1Var.h1() instanceof c)) && z1Var != null && z1Var.m1() == 1) {
                tt(z1Var.e1(this.g), z1Var.h1());
            }
        }
    }

    public boolean c0(Object obj) {
        return this.w.containsKey(obj);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r15 = this;
            boolean r0 = r15.f9887th
            if (r0 == 0) goto L_0x01b4
            int r0 = r15.ggg
            r1 = 1
            int r0 = r0 - r1
            java.util.ArrayList<fe.when.ad.f.l0> r2 = r15.ppp
            int r2 = r2.size()
            if (r0 != r2) goto L_0x0187
            fe.when.ad.f.y r0 = r15.f9374i
            r0.close()
            r15.ggg()     // Catch:{ IOException -> 0x0180 }
            java.util.HashSet<com.itextpdf.text.pdf.PdfOCG> r0 = r15.A     // Catch:{ IOException -> 0x0180 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0180 }
        L_0x001e:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0180 }
            com.itextpdf.text.pdf.PdfOCG r2 = (com.itextpdf.text.pdf.PdfOCG) r2     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.y0 r3 = r2.ad()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r2 = r2.fe()     // Catch:{ IOException -> 0x0180 }
            r15.tt(r3, r2)     // Catch:{ IOException -> 0x0180 }
            goto L_0x001e
        L_0x0036:
            fe.when.ad.f.j1 r0 = r15.when     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r0 = r0.ad()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.x r0 = r15.p(r0)     // Catch:{ IOException -> 0x0180 }
            java.util.HashSet<com.itextpdf.text.pdf.PdfOCG> r2 = r15.A     // Catch:{ IOException -> 0x0180 }
            boolean r2 = r2.isEmpty()     // Catch:{ IOException -> 0x0180 }
            if (r2 != 0) goto L_0x004e
            r2 = 7
            fe.when.ad.f.x0 r3 = r15.C     // Catch:{ IOException -> 0x0180 }
            g(r15, r2, r3)     // Catch:{ IOException -> 0x0180 }
        L_0x004e:
            byte[] r2 = r15.eee     // Catch:{ IOException -> 0x0180 }
            r3 = 0
            if (r2 != 0) goto L_0x0072
            fe.when.ad.g.de.qw r2 = r15.rrr     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x0072
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            r2.<init>()     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            fe.when.ad.g.de.qw r4 = r15.rrr     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            r4.ad(r2)     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            fe.when.ad.g.de.qw r4 = r15.rrr     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            r4.qw()     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            r15.eee = r2     // Catch:{ IOException -> 0x0070, XMPException -> 0x006d }
            goto L_0x0072
        L_0x006d:
            r15.rrr = r3     // Catch:{ IOException -> 0x0180 }
            goto L_0x0072
        L_0x0070:
            r15.rrr = r3     // Catch:{ IOException -> 0x0180 }
        L_0x0072:
            byte[] r2 = r15.eee     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x00b5
            fe.when.ad.f.v1 r2 = new fe.when.ad.f.v1     // Catch:{ IOException -> 0x0180 }
            byte[] r4 = r15.eee     // Catch:{ IOException -> 0x0180 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.K5     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.Z2     // Catch:{ IOException -> 0x0180 }
            r2.h(r4, r5)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.b5     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.u6     // Catch:{ IOException -> 0x0180 }
            r2.h(r4, r5)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.b0 r4 = r15.e     // Catch:{ IOException -> 0x0180 }
            if (r4 == 0) goto L_0x00a6
            fe.when.ad.f.b0 r4 = r15.e     // Catch:{ IOException -> 0x0180 }
            boolean r4 = r4.o()     // Catch:{ IOException -> 0x0180 }
            if (r4 != 0) goto L_0x00a6
            fe.when.ad.f.k r4 = new fe.when.ad.f.k     // Catch:{ IOException -> 0x0180 }
            r4.<init>()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.i0     // Catch:{ IOException -> 0x0180 }
            r4.qqq(r5)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.e1     // Catch:{ IOException -> 0x0180 }
            r2.h(r5, r4)     // Catch:{ IOException -> 0x0180 }
        L_0x00a6:
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.Z2     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.c2$qw r5 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.k0 r2 = r5.qw(r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r2 = r2.qw()     // Catch:{ IOException -> 0x0180 }
            r0.h(r4, r2)     // Catch:{ IOException -> 0x0180 }
        L_0x00b5:
            boolean r2 = r15.Y()     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x00c9
            fe.when.ad.f.x r2 = r15.C()     // Catch:{ IOException -> 0x0180 }
            r15.j(r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.x r2 = r15.z()     // Catch:{ IOException -> 0x0180 }
            r15.h(r2)     // Catch:{ IOException -> 0x0180 }
        L_0x00c9:
            fe.when.ad.f.x r2 = r15.f407switch     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x00d2
            fe.when.ad.f.x r2 = r15.f407switch     // Catch:{ IOException -> 0x0180 }
            r0.g(r2)     // Catch:{ IOException -> 0x0180 }
        L_0x00d2:
            r2 = 0
            r15.h0(r0, r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.k0 r0 = r15.b(r0, r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.x r4 = r15.C()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.k0 r4 = r15.b(r4, r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.c2$qw r5 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            r5.uk()     // Catch:{ IOException -> 0x0180 }
            byte[] r5 = r15.mmm     // Catch:{ IOException -> 0x0180 }
            if (r5 == 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r1 = 0
        L_0x00ed:
            fe.when.ad.f.b0 r5 = r15.e     // Catch:{ IOException -> 0x0180 }
            if (r5 == 0) goto L_0x0106
            fe.when.ad.f.b0 r3 = r15.e     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.x r3 = r3.th()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.k0 r2 = r15.b(r3, r2)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r3 = r2.qw()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.b0 r2 = r15.e     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.y0 r1 = r2.uk(r1)     // Catch:{ IOException -> 0x0180 }
            goto L_0x0113
        L_0x0106:
            if (r1 == 0) goto L_0x010b
            byte[] r2 = r15.mmm     // Catch:{ IOException -> 0x0180 }
            goto L_0x010f
        L_0x010b:
            byte[] r2 = fe.when.ad.f.b0.ad()     // Catch:{ IOException -> 0x0180 }
        L_0x010f:
            fe.when.ad.f.y0 r1 = fe.when.ad.f.b0.de(r2, r1)     // Catch:{ IOException -> 0x0180 }
        L_0x0113:
            fe.when.ad.f.c2$qw r5 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.a r6 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r7 = r0.qw()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r8 = r4.qw()     // Catch:{ IOException -> 0x0180 }
            long r11 = r15.nn     // Catch:{ IOException -> 0x0180 }
            r9 = r3
            r10 = r1
            r5.ppp(r6, r7, r8, r9, r10, r11)     // Catch:{ IOException -> 0x0180 }
            boolean r2 = r15.f     // Catch:{ IOException -> 0x0180 }
            if (r2 == 0) goto L_0x0159
            fe.when.ad.f.a r0 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            g0(r0)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.a r0 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            java.lang.String r1 = "startxref\n"
            byte[] r1 = fe.when.ad.rg.rg(r1)     // Catch:{ IOException -> 0x0180 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.a r0 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.c2$qw r1 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            long r1 = r1.pf()     // Catch:{ IOException -> 0x0180 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0180 }
            byte[] r1 = fe.when.ad.rg.rg(r1)     // Catch:{ IOException -> 0x0180 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.a r0 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            java.lang.String r1 = "\n%%EOF\n"
            byte[] r1 = fe.when.ad.rg.rg(r1)     // Catch:{ IOException -> 0x0180 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0180 }
            goto L_0x017c
        L_0x0159:
            fe.when.ad.f.c2$ad r2 = new fe.when.ad.f.c2$ad     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.c2$qw r5 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            int r6 = r5.m1071if()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.c2$qw r5 = r15.f406if     // Catch:{ IOException -> 0x0180 }
            long r7 = r5.pf()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r9 = r0.qw()     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.l0 r10 = r4.qw()     // Catch:{ IOException -> 0x0180 }
            long r13 = r15.nn     // Catch:{ IOException -> 0x0180 }
            r5 = r2
            r11 = r3
            r12 = r1
            r5.<init>(r6, r7, r9, r10, r11, r12, r13)     // Catch:{ IOException -> 0x0180 }
            fe.when.ad.f.a r0 = r15.f9886ad     // Catch:{ IOException -> 0x0180 }
            r2.nn(r15, r0)     // Catch:{ IOException -> 0x0180 }
        L_0x017c:
            super.close()     // Catch:{ IOException -> 0x0180 }
            goto L_0x01b4
        L_0x0180:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x0187:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The page "
            r2.append(r3)
            java.util.ArrayList<fe.when.ad.f.l0> r3 = r15.ppp
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r3 = " was requested but the document has only "
            r2.append(r3)
            int r3 = r15.ggg
            int r3 = r3 - r1
            r2.append(r3)
            java.lang.String r1 = " pages."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x01b4:
            com.itextpdf.text.log.Counter r0 = r15.s()
            fe.when.ad.f.a r1 = r15.f9886ad
            long r1 = r1.qw()
            r0.qw(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.c2.close():void");
    }

    public void d(x xVar) {
        if (this.x) {
            try {
                S().l();
                xVar.h(s0.Y4, this.z.n());
                x xVar2 = new x();
                xVar2.h(s0.T2, l.f9519i);
                if (this.P) {
                    xVar2.h(s0.Y5, l.f9519i);
                }
                xVar.h(s0.U2, xVar2);
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    public void d0() {
        this.f9375o.P();
        this.f9376pf.P();
    }

    public s0 ddd(l1 l1Var) {
        s0 s0Var = this.r.get(l1Var);
        if (s0Var != null) {
            return s0Var;
        }
        try {
            s0 s0Var2 = new s0("P" + this.s);
            this.s = this.s + 1;
            this.r.put(l1Var, s0Var2);
            return s0Var2;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void e(IAccessibleElement iAccessibleElement, IAccessibleElement iAccessibleElement2) {
        if (iAccessibleElement2 != null && (iAccessibleElement2.getRole() == null || s0.rrr.equals(iAccessibleElement2.getRole()))) {
            iAccessibleElement.setRole((s0) null);
        } else if ((this.y & 1) != 0 && iAccessibleElement.isInline() && iAccessibleElement.getRole() == null) {
            if (iAccessibleElement2 == null || !iAccessibleElement2.isInline()) {
                throw new IllegalArgumentException(fe.when.ad.c.qw.ad("inline.elements.with.role.null.are.not.allowed", new Object[0]));
            }
        }
    }

    public void e0() {
        this.xxx = new x();
    }

    public k0 eee(y0 y0Var) throws IOException {
        return this.f406if.qw(y0Var);
    }

    public void f(int i2, Object obj) {
        this.tt.ad(i2, obj);
    }

    public void f0(s0 s0Var, y0 y0Var) {
        if (y0Var == null || y0Var.when()) {
            this.H.k(s0Var);
        }
        this.H.h(s0Var, y0Var);
    }

    public void ggg() throws IOException {
        for (vvv i2 : this.h.values()) {
            i2.i(this);
        }
        c();
        for (n1 next : this.m.values()) {
            this.n = next;
            next.rg();
        }
        this.n = null;
        for (o next2 : this.p.values()) {
            tt(next2.de(this), next2.ad());
        }
        for (l1 next3 : this.r.keySet()) {
            tt(next3.v1(this.g), next3.h1());
        }
        Iterator<s1> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
        Iterator<r1> it2 = this.u.iterator();
        while (it2.hasNext()) {
            it2.next().qw();
        }
        for (Map.Entry next4 : this.v.entrySet()) {
            tt((x) next4.getKey(), (l0) ((y0[]) next4.getValue())[1]);
        }
        for (Map.Entry next5 : this.w.entrySet()) {
            Object key = next5.getKey();
            y0[] y0VarArr = (y0[]) next5.getValue();
            if (key instanceof o0) {
                o0 o0Var = (o0) key;
                o0Var.ad();
                tt(o0Var, o0Var.fe());
            } else if ((key instanceof x) && !(key instanceof n0)) {
                tt((x) key, (l0) y0VarArr[1]);
            }
        }
    }

    public final void h(x xVar) {
        if (Y() && xVar.qqq(s0.E3) == null) {
            x xVar2 = new x(s0.D3);
            xVar2.h(s0.B3, new w1("SWOP CGATS TR 001-1995"));
            xVar2.h(s0.C3, new w1("CGATS TR 001"));
            xVar2.h(s0.p4, new w1("http://www.color.org"));
            xVar2.h(s0.h2, new w1(""));
            xVar2.h(s0.D4, s0.G1);
            xVar.h(s0.E3, new k((y0) xVar2));
        }
    }

    public void h0(x xVar, boolean z2) throws IOException {
        List<HashMap<String, Object>> list = this.aaa;
        if (list != null && !list.isEmpty()) {
            x xVar2 = new x();
            l0 M2 = M();
            Object[] yj2 = g2.yj(this, M2, this.aaa, z2);
            xVar2.h(s0.f1, (l0) yj2[0]);
            xVar2.h(s0.y2, (l0) yj2[1]);
            xVar2.h(s0.a0, new v0(((Integer) yj2[2]).intValue()));
            tt(xVar2, M2);
            xVar.h(s0.A3, M2);
        }
    }

    public l0 i(h1 h1Var, s sVar) throws PdfException {
        if (this.f9887th) {
            try {
                h1Var.l(eee(sVar).qw());
                x xVar = this.F;
                if (xVar != null) {
                    h1Var.h(s0.F1, xVar);
                    this.F = null;
                } else if (this.Q) {
                    x xVar2 = new x();
                    xVar2.h(s0.K5, s0.F1);
                    xVar2.h(s0.D4, s0.C5);
                    xVar2.h(s0.j0, s0.w0);
                    h1Var.h(s0.F1, xVar2);
                }
                this.when.qw(h1Var);
                this.ggg++;
                return null;
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new PdfException(fe.when.ad.c.qw.ad("the.document.is.not.open", new Object[0]));
        }
    }

    /* renamed from: if  reason: not valid java name */
    public s0 m1069if(i iVar) throws PdfException, DocumentException {
        return m1070switch(iVar, (l0) null);
    }

    public final void j(x xVar) {
        if (Y()) {
            if (xVar.qqq(s0.H1) == null) {
                if (((fe) this.tt).rg()) {
                    xVar.h(s0.H1, new w1("PDF/X-1:2001"));
                    xVar.h(new s0("GTS_PDFXConformance"), new w1("PDF/X-1a:2001"));
                } else if (((fe) this.tt).th()) {
                    xVar.h(s0.H1, new w1("PDF/X-3:2002"));
                }
            }
            if (xVar.qqq(s0.y5) == null) {
                xVar.h(s0.y5, new w1("Pdf document"));
            }
            if (xVar.qqq(s0.g0) == null) {
                xVar.h(s0.g0, new w1("Unknown"));
            }
            if (xVar.qqq(s0.D5) == null) {
                xVar.h(s0.D5, new s0("False"));
            }
        }
    }

    public void k(x xVar) {
        for (vvv next : this.h.values()) {
            if (xVar.qqq(next.rg()) != null) {
                next.uk(false);
            }
        }
    }

    public void l(boolean z2) {
        w1 c;
        if (this.C == null) {
            this.C = new x0();
        }
        if (z2) {
            this.C.k(s0.t3);
            this.C.k(s0.k0);
        }
        if (this.C.qqq(s0.t3) == null) {
            k kVar = new k();
            Iterator<PdfOCG> it = this.A.iterator();
            while (it.hasNext()) {
                kVar.qqq(((n0) it.next()).fe());
            }
            this.C.h(s0.t3, kVar);
        }
        if (this.C.qqq(s0.k0) == null) {
            ArrayList arrayList = new ArrayList(this.B);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((n0) it2.next()).m() != null) {
                    it2.remove();
                }
            }
            k kVar2 = new k();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                F(kVar2, (n0) ((PdfOCG) it3.next()));
            }
            x xVar = new x();
            this.C.h(s0.k0, xVar);
            xVar.h(s0.y3, kVar2);
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof n0) && (c = ((n0) arrayList.get(0)).c(s0.c3)) != null) {
                xVar.h(s0.c3, c);
            }
            k kVar3 = new k();
            Iterator<PdfOCG> it4 = this.A.iterator();
            while (it4.hasNext()) {
                n0 n0Var = (n0) it4.next();
                if (!n0Var.p()) {
                    kVar3.qqq(n0Var.fe());
                }
            }
            if (kVar3.size() > 0) {
                xVar.h(s0.v3, kVar3);
            }
            if (this.D.size() > 0) {
                xVar.h(s0.l4, this.D);
            }
            if (this.E.size() > 0) {
                xVar.h(s0.N2, this.E);
            }
            o(s0.c6, s0.B6);
            s0 s0Var = s0.c6;
            o(s0Var, s0Var);
            s0 s0Var2 = s0.Z3;
            o(s0Var2, s0Var2);
            s0 s0Var3 = s0.Y0;
            o(s0Var3, s0Var3);
            xVar.h(s0.L2, s0.g6);
        }
    }

    public void m() throws IOException, BadPdfFormatException {
    }

    public y0[] mmm(Object obj, l0 l0Var) {
        if (!this.w.containsKey(obj)) {
            if (obj instanceof PdfOCG) {
                g(this, 7, obj);
            }
            HashMap<Object, y0[]> hashMap = this.w;
            hashMap.put(obj, new y0[]{new s0("Pr" + (this.w.size() + 1)), l0Var});
        }
        return this.w.get(obj);
    }

    public void n() throws IOException {
    }

    public o nn(de deVar) {
        int uk2 = ppp.uk(deVar);
        if (uk2 == 4 || uk2 == 5) {
            throw new RuntimeException(fe.when.ad.c.qw.ad("an.uncolored.tile.pattern.can.not.have.another.pattern.or.shading.as.color", new Object[0]));
        } else if (uk2 == 0) {
            if (this.J == null) {
                this.J = new o(q(), this.f406if.o(), (ICachedColorSpace) null);
                k kVar = new k((y0) s0.R3);
                kVar.qqq(s0.w0);
                tt(kVar, this.J.ad());
            }
            return this.J;
        } else if (uk2 == 1) {
            if (this.K == null) {
                this.K = new o(q(), this.f406if.o(), (ICachedColorSpace) null);
                k kVar2 = new k((y0) s0.R3);
                kVar2.qqq(s0.v0);
                tt(kVar2, this.K.ad());
            }
            return this.K;
        } else if (uk2 == 2) {
            if (this.L == null) {
                this.L = new o(q(), this.f406if.o(), (ICachedColorSpace) null);
                k kVar3 = new k((y0) s0.R3);
                kVar3.qqq(s0.x0);
                tt(kVar3, this.L.ad());
            }
            return this.L;
        } else if (uk2 == 3) {
            try {
                o vvv2 = vvv(((h2) deVar).o());
                o oVar = this.I.get(vvv2);
                if (oVar != null) {
                    return oVar;
                }
                o oVar2 = new o(q(), this.f406if.o(), (ICachedColorSpace) null);
                k kVar4 = new k((y0) s0.R3);
                kVar4.qqq(vvv2.ad());
                tt(kVar4, oVar2.ad());
                this.I.put(vvv2, oVar2);
                return oVar2;
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage());
            }
        } else {
            throw new RuntimeException(fe.when.ad.c.qw.ad("invalid.color.type", new Object[0]));
        }
    }

    public final void o(s0 s0Var, s0 s0Var2) {
        k kVar = new k();
        Iterator<PdfOCG> it = this.A.iterator();
        while (it.hasNext()) {
            n0 n0Var = (n0) it.next();
            x tt2 = n0Var.tt(s0.T5);
            if (!(tt2 == null || tt2.qqq(s0Var2) == null)) {
                kVar.qqq(n0Var.fe());
            }
        }
        if (kVar.size() != 0) {
            x tt3 = this.C.tt(s0.k0);
            k eee2 = tt3.eee(s0.e);
            if (eee2 == null) {
                eee2 = new k();
                tt3.h(s0.e, eee2);
            }
            x xVar = new x();
            xVar.h(s0.Z0, s0Var);
            xVar.h(s0.F, new k((y0) s0Var2));
            xVar.h(s0.t3, kVar);
            eee2.qqq(xVar);
        }
    }

    public void open() {
        super.open();
        try {
            this.qqq.rg(this.f9886ad);
            this.f406if = new qw(this);
            if (Y() && ((fe) this.tt).th()) {
                x xVar = new x();
                xVar.h(s0.C1, new k(new float[]{2.2f, 2.2f, 2.2f}));
                xVar.h(s0.R2, new k(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                xVar.h(s0.p6, new k(new float[]{0.9505f, 1.0f, 1.089f}));
                k kVar = new k((y0) s0.B);
                kVar.qqq(xVar);
                f0(s0.q0, eee(kVar).qw());
            }
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public x p(l0 l0Var) {
        y.de g2 = this.f9374i.g(l0Var);
        d(g2);
        if (!this.A.isEmpty()) {
            l(false);
            g2.h(s0.u3, this.C);
        }
        return g2;
    }

    public void pf(j jVar) {
        this.f9374i.mmm(jVar);
    }

    public void ppp(TreeMap<String, y.qw> treeMap) throws IOException {
        for (Map.Entry next : treeMap.entrySet()) {
            String str = (String) next.getKey();
            y.qw qwVar = (y.qw) next.getValue();
            v vVar = qwVar.f9851de;
            if (qwVar.f9850ad == null) {
                qwVar.f9850ad = M();
            }
            if (vVar == null) {
                tt(new w1("invalid_" + str), qwVar.f9850ad);
            } else {
                tt(vVar, qwVar.f9850ad);
            }
        }
    }

    public s0 q() {
        StringBuilder sb = new StringBuilder();
        sb.append("CS");
        int i2 = this.q;
        this.q = i2 + 1;
        sb.append(i2);
        return new s0(sb.toString());
    }

    public void qqq(s1 s1Var) {
        if (!this.t.contains(s1Var)) {
            s1Var.s(this.s);
            this.s++;
            this.t.add(s1Var);
            aaa(s1Var.q());
        }
    }

    public int r() {
        return this.g;
    }

    public k0 rrr(y0 y0Var, int i2) throws IOException {
        return this.f406if.ad(y0Var, i2);
    }

    public Counter s() {
        return S;
    }

    /* renamed from: switch  reason: not valid java name */
    public s0 m1070switch(i iVar, l0 l0Var) throws PdfException, DocumentException {
        s0 s0Var;
        byte[] M0;
        if (this.N.containsKey(iVar.P())) {
            return this.N.get(iVar.P());
        }
        if (iVar.f0()) {
            s0Var = new s0("img" + this.N.size());
            if (iVar instanceof Cswitch) {
                try {
                    ((Cswitch) iVar).N0(z1.a1(this, 0.0f, 0.0f));
                } catch (Exception e2) {
                    throw new DocumentException(e2);
                }
            }
        } else {
            l0 y2 = iVar.y();
            if (y2 != null) {
                s0 s0Var2 = new s0("img" + this.N.size());
                this.N.put(iVar.P(), s0Var2);
                this.M.h(s0Var2, y2);
                return s0Var2;
            }
            i A2 = iVar.A();
            l0 l0Var2 = null;
            if (A2 != null) {
                l0Var2 = A(this.N.get(A2.P()));
            }
            i0 i0Var = new i0(iVar, "img" + this.N.size(), l0Var2);
            if ((iVar instanceof pf) && (M0 = ((pf) iVar).M0()) != null) {
                x xVar = new x();
                xVar.h(s0.o2, P(M0));
                i0Var.h(s0.p0, xVar);
            }
            if (iVar.c0()) {
                l0 yj2 = yj(new h0(iVar.z(), iVar.x()));
                k kVar = new k();
                kVar.qqq(s0.Z1);
                kVar.qqq(yj2);
                k eee2 = i0Var.eee(s0.T);
                if (eee2 == null) {
                    i0Var.h(s0.T, kVar);
                } else if (eee2.size() <= 1 || !s0.g2.equals(eee2.g(0))) {
                    i0Var.h(s0.T, kVar);
                } else {
                    eee2.j(1, kVar);
                }
            }
            uk(i0Var, l0Var);
            s0Var = i0Var.s();
        }
        this.N.put(iVar.P(), s0Var);
        return s0Var;
    }

    public l0 t() {
        return K(this.ggg);
    }

    public k0 tt(y0 y0Var, l0 l0Var) throws IOException {
        return this.f406if.fe(y0Var, l0Var);
    }

    public int u() {
        return this.ggg;
    }

    public l0 uk(i0 i0Var, l0 l0Var) throws PdfException {
        if (this.M.aaa(i0Var.s())) {
            return (l0) this.M.qqq(i0Var.s());
        }
        g(this, 5, i0Var);
        if (l0Var instanceof c) {
            c cVar = (c) l0Var;
            l0Var = new l0(0, E(cVar.qqq(), cVar.getNumber(), cVar.aaa()));
        }
        if (l0Var == null) {
            try {
                l0Var = eee(i0Var).qw();
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            tt(i0Var, l0Var);
        }
        this.M.h(i0Var.s(), l0Var);
        return l0Var;
    }

    public x v() {
        return this.H;
    }

    public o vvv(ICachedColorSpace iCachedColorSpace) {
        o oVar = this.p.get(iCachedColorSpace);
        if (oVar == null) {
            oVar = new o(q(), this.f406if.o(), iCachedColorSpace);
            if (iCachedColorSpace instanceof IPdfSpecialColorSpace) {
                ((IPdfSpecialColorSpace) iCachedColorSpace).qw(this);
            }
            this.p.put(iCachedColorSpace, oVar);
        }
        return oVar;
    }

    public q w() {
        if (this.f9887th) {
            return this.f9375o;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("the.document.is.not.open", new Object[0]));
    }

    public s0 when(z1 z1Var, s0 s0Var) {
        l0 h1 = z1Var.h1();
        Object[] objArr = this.k.get(h1);
        if (objArr != null) {
            return (s0) objArr[0];
        }
        if (s0Var == null) {
            try {
                s0Var = new s0("Xf" + this.l);
                this.l = this.l + 1;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        if (z1Var.m1() == 2) {
            j0 j0Var = (j0) z1Var;
            m1 de2 = j0Var.t1().de();
            if (!this.m.containsKey(de2)) {
                this.m.put(de2, j0Var.t1());
            }
            z1Var = null;
        }
        this.k.put(h1, new Object[]{s0Var, z1Var});
        return s0Var;
    }

    public q x() {
        if (this.f9887th) {
            return this.f9376pf;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("the.document.is.not.open", new Object[0]));
    }

    public vvv xxx(ad adVar) {
        vvv vvv2 = this.h.get(adVar);
        if (vvv2 == null) {
            g(this, 4, adVar);
            if (adVar.when() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("F");
                int i2 = this.j;
                this.j = i2 + 1;
                sb.append(i2);
                vvv2 = new vvv(new s0(sb.toString()), ((when) adVar).g(), adVar);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("F");
                int i3 = this.j;
                this.j = i3 + 1;
                sb2.append(i3);
                vvv2 = new vvv(new s0(sb2.toString()), this.f406if.o(), adVar);
            }
            this.h.put(adVar, vvv2);
        }
        return vvv2;
    }

    public b0 y() {
        return this.e;
    }

    public l0 yj(h0 h0Var) {
        try {
            return eee(h0Var).qw();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public x z() {
        if (this.f407switch == null) {
            this.f407switch = new x();
        }
        return this.f407switch;
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f9377ad;

        /* renamed from: de  reason: collision with root package name */
        public long f9378de;

        /* renamed from: fe  reason: collision with root package name */
        public final c2 f9379fe;
        public final TreeSet<C0328qw> qw;

        /* renamed from: rg  reason: collision with root package name */
        public rg f9380rg;

        /* renamed from: th  reason: collision with root package name */
        public rg f9381th;

        /* renamed from: uk  reason: collision with root package name */
        public int f9382uk = 0;

        /* renamed from: yj  reason: collision with root package name */
        public int f9383yj;

        public qw(c2 c2Var) {
            TreeSet<C0328qw> treeSet = new TreeSet<>();
            this.qw = treeSet;
            treeSet.add(new C0328qw(0, 0, 65535));
            this.f9378de = c2Var.G().qw();
            this.f9377ad = 1;
            this.f9379fe = c2Var;
        }

        public k0 ad(y0 y0Var, int i2) throws IOException {
            return de(y0Var, i2, 0, true);
        }

        public k0 de(y0 y0Var, int i2, int i3, boolean z) throws IOException {
            if (z && y0Var.rg() && this.f9379fe.W()) {
                C0328qw yj2 = yj(y0Var, i2);
                k0 k0Var = new k0(i2, y0Var, this.f9379fe);
                if (!this.qw.add(yj2)) {
                    this.qw.remove(yj2);
                    this.qw.add(yj2);
                }
                return k0Var;
            } else if (this.f9379fe.W()) {
                k0 k0Var2 = new k0(i2, y0Var, this.f9379fe);
                m1072switch(k0Var2, i2);
                return k0Var2;
            } else {
                k0 k0Var3 = new k0(i2, i3, y0Var, this.f9379fe);
                when(k0Var3, i2, i3);
                return k0Var3;
            }
        }

        public k0 fe(y0 y0Var, l0 l0Var) throws IOException {
            return rg(y0Var, l0Var, true);
        }

        public int i() {
            int i2 = this.f9377ad;
            this.f9377ad = i2 + 1;
            this.qw.add(new C0328qw(i2, 0, 65535));
            return i2;
        }

        /* renamed from: if  reason: not valid java name */
        public int m1071if() {
            return Math.max(this.qw.last().ad() + 1, this.f9377ad);
        }

        public l0 o() {
            return new l0(0, i());
        }

        public long pf() {
            return this.f9378de;
        }

        public void ppp(OutputStream outputStream, l0 l0Var, l0 l0Var2, l0 l0Var3, y0 y0Var, long j) throws IOException {
            int i2;
            int i3;
            OutputStream outputStream2 = outputStream;
            l0 l0Var4 = l0Var2;
            l0 l0Var5 = l0Var3;
            y0 y0Var2 = y0Var;
            long j2 = j;
            if (this.f9379fe.W()) {
                uk();
                i2 = i();
                this.qw.add(new C0328qw(i2, this.f9378de));
            } else {
                i2 = 0;
            }
            int ad2 = this.qw.first().ad();
            ArrayList arrayList = new ArrayList();
            Iterator<C0328qw> it = this.qw.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0328qw next = it.next();
                if (ad2 + i4 == next.ad()) {
                    i4++;
                } else {
                    arrayList.add(Integer.valueOf(ad2));
                    arrayList.add(Integer.valueOf(i4));
                    ad2 = next.ad();
                    i4 = 1;
                }
            }
            arrayList.add(Integer.valueOf(ad2));
            arrayList.add(Integer.valueOf(i4));
            if (this.f9379fe.W()) {
                int i5 = 5;
                long j3 = 1095216660480L;
                for (i3 = 1; i5 > i3 && (this.f9378de & j3) == 0; i3 = 1) {
                    j3 >>>= 8;
                    i5--;
                }
                rg rgVar = new rg();
                Iterator<C0328qw> it2 = this.qw.iterator();
                while (it2.hasNext()) {
                    it2.next().fe(i5, rgVar);
                }
                v1 v1Var = new v1(rgVar.mmm());
                v1Var.l(this.f9379fe.r());
                v1Var.h(s0.M4, new v0(m1071if()));
                v1Var.h(s0.u4, l0Var);
                if (l0Var4 != null) {
                    v1Var.h(s0.h2, l0Var4);
                }
                if (l0Var5 != null) {
                    v1Var.h(s0.Q0, l0Var5);
                }
                if (y0Var2 != null) {
                    v1Var.h(s0.a2, y0Var2);
                }
                v1Var.h(s0.h6, new k(new int[]{1, i5, 2}));
                v1Var.h(s0.K5, s0.w6);
                k kVar = new k();
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    kVar.qqq(new v0(((Integer) arrayList.get(i6)).intValue()));
                }
                v1Var.h(s0.f2, kVar);
                if (j2 > 0) {
                    v1Var.h(s0.X3, new v0(j2));
                }
                c2 c2Var = this.f9379fe;
                b0 b0Var = c2Var.e;
                c2Var.e = null;
                new k0(i2, v1Var, this.f9379fe).ad(this.f9379fe.G());
                this.f9379fe.e = b0Var;
                return;
            }
            outputStream2.write(rg.rg("xref\n"));
            Iterator<C0328qw> it3 = this.qw.iterator();
            for (int i7 = 0; i7 < arrayList.size(); i7 += 2) {
                int intValue = ((Integer) arrayList.get(i7)).intValue();
                int intValue2 = ((Integer) arrayList.get(i7 + 1)).intValue();
                outputStream2.write(rg.rg(String.valueOf(intValue)));
                outputStream2.write(rg.rg(" "));
                outputStream2.write(rg.rg(String.valueOf(intValue2)));
                outputStream2.write(10);
                while (true) {
                    int i8 = intValue2 - 1;
                    if (intValue2 <= 0) {
                        break;
                    }
                    it3.next().rg(outputStream2);
                    intValue2 = i8;
                }
            }
        }

        public k0 qw(y0 y0Var) throws IOException {
            return ad(y0Var, i());
        }

        public k0 rg(y0 y0Var, l0 l0Var, boolean z) throws IOException {
            return de(y0Var, l0Var.getNumber(), l0Var.aaa(), z);
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1072switch(k0 k0Var, int i2) throws IOException {
            C0328qw qwVar = new C0328qw(i2, this.f9378de);
            if (!this.qw.add(qwVar)) {
                this.qw.remove(qwVar);
                this.qw.add(qwVar);
            }
            k0Var.ad(this.f9379fe.G());
            this.f9378de = this.f9379fe.G().qw();
        }

        public k0 th(y0 y0Var, boolean z) throws IOException {
            return de(y0Var, i(), 0, z);
        }

        public void uk() throws IOException {
            if (this.f9382uk != 0) {
                int nn = this.f9380rg.nn();
                this.f9380rg.yj(this.f9381th);
                v1 v1Var = new v1(this.f9380rg.mmm());
                v1Var.l(this.f9379fe.r());
                v1Var.h(s0.K5, s0.r3);
                v1Var.h(s0.b3, new v0(this.f9382uk));
                v1Var.h(s0.f1, new v0(nn));
                ad(v1Var, this.f9383yj);
                this.f9380rg = null;
                this.f9381th = null;
                this.f9382uk = 0;
            }
        }

        public void when(k0 k0Var, int i2, int i3) throws IOException {
            C0328qw qwVar = new C0328qw(i2, this.f9378de, i3);
            if (!this.qw.add(qwVar)) {
                this.qw.remove(qwVar);
                this.qw.add(qwVar);
            }
            k0Var.ad(this.f9379fe.G());
            this.f9378de = this.f9379fe.G().qw();
        }

        public C0328qw yj(y0 y0Var, int i2) throws IOException {
            if (this.f9382uk >= 200) {
                uk();
            }
            if (this.f9380rg == null) {
                this.f9380rg = new rg();
                this.f9381th = new rg();
                this.f9383yj = i();
                this.f9382uk = 0;
            }
            int nn = this.f9381th.nn();
            int i3 = this.f9382uk;
            this.f9382uk = i3 + 1;
            c2 c2Var = this.f9379fe;
            b0 b0Var = c2Var.e;
            c2Var.e = null;
            y0Var.nn(c2Var, this.f9381th);
            this.f9379fe.e = b0Var;
            this.f9381th.de(Ascii.CASE_MASK);
            rg rgVar = this.f9380rg;
            rgVar.th(i2);
            rgVar.de(Ascii.CASE_MASK);
            rgVar.th(nn);
            rgVar.de(Ascii.CASE_MASK);
            return new C0328qw(2, i2, (long) this.f9383yj, i3);
        }

        /* renamed from: fe.when.ad.f.c2$qw$qw  reason: collision with other inner class name */
        public static class C0328qw implements Comparable<C0328qw> {

            /* renamed from: ad  reason: collision with root package name */
            public final int f9384ad;

            /* renamed from: th  reason: collision with root package name */
            public final long f9385th;

            /* renamed from: uk  reason: collision with root package name */
            public final int f9386uk;

            /* renamed from: yj  reason: collision with root package name */
            public final int f9387yj;

            public C0328qw(int i2, long j, int i3) {
                this.f9384ad = 0;
                this.f9385th = j;
                this.f9387yj = i2;
                this.f9386uk = i3;
            }

            public int ad() {
                return this.f9387yj;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0328qw) || this.f9387yj != ((C0328qw) obj).f9387yj) {
                    return false;
                }
                return true;
            }

            public void fe(int i2, OutputStream outputStream) throws IOException {
                outputStream.write((byte) this.f9384ad);
                while (true) {
                    i2--;
                    if (i2 >= 0) {
                        outputStream.write((byte) ((int) ((this.f9385th >>> (i2 * 8)) & 255)));
                    } else {
                        outputStream.write((byte) ((this.f9386uk >>> 8) & 255));
                        outputStream.write((byte) (this.f9386uk & 255));
                        return;
                    }
                }
            }

            public int hashCode() {
                return this.f9387yj;
            }

            /* renamed from: qw */
            public int compareTo(C0328qw qwVar) {
                int i2 = this.f9387yj;
                int i3 = qwVar.f9387yj;
                if (i2 < i3) {
                    return -1;
                }
                return i2 == i3 ? 0 : 1;
            }

            public void rg(OutputStream outputStream) throws IOException {
                StringBuffer stringBuffer = new StringBuffer("0000000000");
                stringBuffer.append(this.f9385th);
                stringBuffer.delete(0, stringBuffer.length() - 10);
                StringBuffer stringBuffer2 = new StringBuffer("00000");
                stringBuffer2.append(this.f9386uk);
                stringBuffer2.delete(0, stringBuffer2.length() - 5);
                stringBuffer.append(Ascii.CASE_MASK);
                stringBuffer.append(stringBuffer2);
                stringBuffer.append(this.f9386uk == 65535 ? " f \n" : " n \n");
                outputStream.write(rg.rg(stringBuffer.toString()));
            }

            public C0328qw(int i2, long j) {
                this.f9384ad = 1;
                this.f9385th = j;
                this.f9387yj = i2;
                this.f9386uk = 0;
            }

            public C0328qw(int i2, int i3, long j, int i4) {
                this.f9384ad = i2;
                this.f9385th = j;
                this.f9387yj = i3;
                this.f9386uk = i4;
            }
        }
    }

    public c2(y yVar, OutputStream outputStream) {
        super(yVar, outputStream);
        this.f9374i = yVar;
        q qVar = new q(this);
        this.f9376pf = qVar;
        this.f9375o = qVar.s();
    }
}
