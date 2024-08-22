package fe.when.ad.f;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.api.WriterOperation;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.draw.DrawInterface;
import fe.when.ad.aaa;
import fe.when.ad.b;
import fe.when.ad.ddd;
import fe.when.ad.i;
import fe.when.ad.nn;
import fe.when.ad.ppp;
import fe.when.ad.rrr;
import fe.when.ad.th;
import fe.when.ad.vvv;
import fe.when.ad.xxx;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class y extends th {
    public z0 A;
    public z0 B;
    public fe.when.ad.f.s2.de C;
    public i1 D;
    public TreeMap<String, qw> E;
    public HashMap<String, y0> F;
    public HashMap<String, y0> G;
    public String H;
    public h I;
    public x J;
    public fe.when.ad.f.o2.qw K;
    public fe.when.ad.f.s2.qw L;
    public w1 M;
    public aaa N;
    public HashMap<String, o1> O;
    public HashMap<String, o1> P;
    public boolean Q;
    public x R;
    public e S;
    public boolean T;
    public float U;
    public i V;
    public ArrayList<Element> W;
    public q e;
    public HashMap<fe.when.ad.qw, x1> eee = new HashMap<>();
    public q f;
    public float g;
    public int h;
    public float j;
    public boolean k;
    public h l;
    public rrr m;
    public Stack<Float> n;
    public int p;
    public float q;
    public c2 qqq;
    public float r;
    public boolean rrr = false;
    public float s;
    public float t;
    public HashMap<Object, int[]> tt = new HashMap<>();
    public boolean u;
    public p0 v;
    public ArrayList<p0> w;
    public int x;
    public ad y;
    public fe z;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public float f9842ad = 0.0f;

        /* renamed from: de  reason: collision with root package name */
        public float f9843de = 0.0f;

        /* renamed from: fe  reason: collision with root package name */
        public float f9844fe = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f9845i = 0.0f;
        public float qw = 0.0f;

        /* renamed from: rg  reason: collision with root package name */
        public float f9846rg = 0.0f;

        /* renamed from: th  reason: collision with root package name */
        public float f9847th = 0.0f;

        /* renamed from: uk  reason: collision with root package name */
        public float f9848uk = 0.0f;

        /* renamed from: yj  reason: collision with root package name */
        public float f9849yj = 0.0f;
    }

    public static class de extends x {

        /* renamed from: switch  reason: not valid java name */
        public c2 f466switch;

        public de(l0 l0Var, c2 c2Var) {
            super(x.f464if);
            this.f466switch = c2Var;
            h(s0.K3, l0Var);
        }

        public void l(TreeMap<String, qw> treeMap, HashMap<String, y0> hashMap, HashMap<String, y0> hashMap2, c2 c2Var) {
            if (!treeMap.isEmpty() || !hashMap.isEmpty() || !hashMap2.isEmpty()) {
                try {
                    x xVar = new x();
                    if (!treeMap.isEmpty()) {
                        k kVar = new k();
                        for (Map.Entry next : treeMap.entrySet()) {
                            String str = (String) next.getKey();
                            qw qwVar = (qw) next.getValue();
                            if (qwVar.f9851de != null) {
                                l0 l0Var = qwVar.f9850ad;
                                kVar.qqq(new w1(str, (String) null));
                                kVar.qqq(l0Var);
                            }
                        }
                        if (kVar.size() > 0) {
                            x xVar2 = new x();
                            xVar2.h(s0.e3, kVar);
                            xVar.h(s0.u0, c2Var.eee(xVar2).qw());
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        xVar.h(s0.m2, c2Var.eee(t0.qw(hashMap, c2Var)).qw());
                    }
                    if (!hashMap2.isEmpty()) {
                        xVar.h(s0.N0, c2Var.eee(t0.qw(hashMap2, c2Var)).qw());
                    }
                    if (xVar.size() > 0) {
                        h(s0.e3, c2Var.eee(xVar).qw());
                    }
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
        }

        public void m(x xVar) {
            try {
                h(s0.f9759pf, this.f466switch.eee(xVar).qw());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        public void n(h hVar) {
            h(s0.x3, hVar);
        }
    }

    public static class fe extends x {
        public fe() {
            q();
            m();
        }

        public void l(String str) {
            h(s0.h, new w1(str, "UnicodeBig"));
        }

        public void m() {
            u uVar = new u();
            h(s0.f0, uVar);
            h(s0.a3, uVar);
        }

        public void n(String str) {
            h(s0.g0, new w1(str, "UnicodeBig"));
        }

        public void p(String str) {
            h(s0.t2, new w1(str, "UnicodeBig"));
        }

        public void q() {
            h(s0.f4, new w1(b.qw().fe()));
        }

        public void r(String str) {
            h(s0.a5, new w1(str, "UnicodeBig"));
        }

        public void s(String str) {
            h(s0.y5, new w1(str, "UnicodeBig"));
        }

        public void t(String str, String str2) {
            if (!str.equals("Producer") && !str.equals("CreationDate")) {
                h(new s0(str), new w1(str2, "UnicodeBig"));
            }
        }
    }

    public class qw {

        /* renamed from: ad  reason: collision with root package name */
        public l0 f9850ad;

        /* renamed from: de  reason: collision with root package name */
        public v f9851de;
        public h qw;

        public qw(y yVar) {
        }
    }

    static {
        new DecimalFormat("0000000000000000");
    }

    public y() {
        new HashMap();
        this.g = 0.0f;
        this.h = 0;
        this.j = 0.0f;
        this.k = false;
        this.l = null;
        this.n = new Stack<>();
        this.u = true;
        this.v = null;
        this.w = new ArrayList<>();
        this.x = -1;
        this.y = new ad();
        this.z = new fe();
        this.C = new fe.when.ad.f.s2.de();
        this.E = new TreeMap<>();
        this.F = new HashMap<>();
        this.G = new HashMap<>();
        this.N = null;
        this.O = new HashMap<>();
        this.P = new HashMap<>();
        this.Q = true;
        this.R = null;
        this.T = false;
        this.U = -1.0f;
        this.V = null;
        this.W = new ArrayList<>();
        yj();
        rg();
    }

    public static boolean v(c2 c2Var) {
        return c2Var != null && c2Var.a0();
    }

    public void A() {
        this.g = this.n.pop().floatValue();
        if (this.n.size() > 0) {
            this.g = this.n.peek().floatValue();
        }
    }

    public void B() {
        this.n.push(Float.valueOf(this.g));
    }

    public void C(String str, int i2, float f2, float f3, float f4, float f5) {
        mmm(new j(this.qqq, f2, f3, f4, f5, new h(str, i2)));
    }

    public void D(String str, String str2, float f2, float f3, float f4, float f5) {
        this.L.de(new j(this.qqq, f2, f3, f4, f5, new h(str, str2)));
    }

    public void E(String str) {
        this.M = new w1(str);
    }

    public void F() {
        this.f9896uk = this.N;
        if (!this.f476switch || (o() & 1) != 0) {
            this.f9892i = this.q;
            this.f9893o = this.r;
        } else {
            this.f9893o = this.q;
            this.f9892i = this.r;
        }
        if (!this.when || (o() & 1) != 0) {
            this.f9894pf = this.s;
            this.f475if = this.t;
        } else {
            this.f9894pf = this.t;
            this.f475if = this.s;
        }
        if (!v(this.qqq)) {
            q qVar = new q(this.qqq);
            this.e = qVar;
            qVar.P();
        } else {
            this.e = this.f;
        }
        this.e.vvv();
        this.e.H(m1132if(), vvv());
        if (v(this.qqq)) {
            this.p = this.e.T0();
        }
    }

    public void G(z0 z0Var) {
        ArrayList<z0> m2 = z0Var.m();
        z0 s2 = z0Var.s();
        if (!m2.isEmpty()) {
            for (int i2 = 0; i2 < m2.size(); i2++) {
                G(m2.get(i2));
            }
            if (s2 == null) {
                return;
            }
            if (z0Var.q()) {
                s2.t(z0Var.getCount() + s2.getCount() + 1);
                return;
            }
            s2.t(s2.getCount() + 1);
            z0Var.t(-z0Var.getCount());
        } else if (s2 != null) {
            s2.t(s2.getCount() + 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:244:0x070f  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0751  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x075b  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0760  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0763  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0774  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0782  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0874  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x087a  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x087f  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0885  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x08a8  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0901  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float H(fe.when.ad.f.p0 r54, fe.when.ad.f.q r55, fe.when.ad.f.q r56, java.lang.Object[] r57, float r58) throws com.itextpdf.text.DocumentException {
        /*
            r53 = this;
            r7 = r53
            r8 = r54
            r9 = r55
            r15 = r56
            r14 = 0
            r0 = r57[r14]
            fe.when.ad.f.d0 r0 = (fe.when.ad.f.d0) r0
            r13 = 1
            r1 = r57[r13]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r2 = r55.D()
            float r3 = r54.o()
            float r2 = r2 + r3
            int r12 = r54.mmm()
            int r3 = r54.uk()
            boolean r4 = r54.m1109if()
            if (r4 == 0) goto L_0x0034
            if (r12 != 0) goto L_0x0031
            if (r3 <= r13) goto L_0x0034
        L_0x0031:
            r18 = 1
            goto L_0x0036
        L_0x0034:
            r18 = 0
        L_0x0036:
            int r4 = r54.pf()
            r11 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            if (r4 <= 0) goto L_0x0050
            float r3 = r54.tt()
            float r4 = (float) r4
            float r3 = r3 / r4
            r19 = r1
            r20 = r2
            r4 = r3
        L_0x004a:
            r5 = 0
            r6 = 0
        L_0x004c:
            r21 = 0
            goto L_0x00e9
        L_0x0050:
            if (r18 == 0) goto L_0x00d6
            if (r4 != 0) goto L_0x00d6
            boolean r4 = r54.ppp()
            if (r4 == 0) goto L_0x0082
            float r4 = r54.tt()
            float r5 = (float) r12
            float r5 = r5 * r58
            float r6 = (float) r3
            float r5 = r5 + r6
            float r5 = r5 - r11
            float r5 = r5 * r1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0082
            boolean r3 = r54.ggg()
            if (r3 == 0) goto L_0x0078
            float r3 = r54.tt()
            float r3 = r3 - r5
            r9.H(r3, r10)
        L_0x0078:
            float r3 = r58 * r1
            r6 = r1
            r19 = r6
            r20 = r2
            r5 = r3
            r4 = 0
            goto L_0x004c
        L_0x0082:
            float r1 = r54.tt()
            int r4 = r54.rrr()
            int r4 = r4 - r13
            fe.when.ad.f.n r4 = r8.rg(r4)
            if (r4 == 0) goto L_0x00c2
            java.lang.String r5 = r4.toString()
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x00c2
            int r6 = r5.length()
            int r6 = r6 - r13
            char r5 = r5.charAt(r6)
            java.lang.String r6 = ".,;:'"
            int r6 = r6.indexOf(r5)
            if (r6 < 0) goto L_0x00c2
            fe.when.ad.f.d0 r4 = r4.fe()
            float r4 = r4.o(r5)
            r5 = 1053609165(0x3ecccccd, float:0.4)
            float r4 = r4 * r5
            float r4 = r4 + r1
            float r1 = r4 - r1
            r52 = r4
            r4 = r1
            r1 = r52
            goto L_0x00c3
        L_0x00c2:
            r4 = 0
        L_0x00c3:
            float r5 = (float) r12
            float r5 = r5 * r58
            float r3 = (float) r3
            float r5 = r5 + r3
            float r5 = r5 - r11
            float r1 = r1 / r5
            float r3 = r58 * r1
            r6 = r1
            r19 = r6
            r20 = r2
            r5 = r3
            r21 = r4
            r4 = 0
            goto L_0x00e9
        L_0x00d6:
            int r3 = r8.f9678fe
            if (r3 == 0) goto L_0x00dd
            r4 = -1
            if (r3 != r4) goto L_0x00e2
        L_0x00dd:
            float r3 = r54.tt()
            float r2 = r2 - r3
        L_0x00e2:
            r19 = r1
            r20 = r2
            r4 = 0
            goto L_0x004a
        L_0x00e9:
            int r3 = r54.yj()
            float r22 = r55.D()
            float r2 = r55.E()
            java.util.Iterator r23 = r54.vvv()
            r1 = 2143289344(0x7fc00000, float:NaN)
            r1 = r0
            r16 = r22
            r0 = 0
            r17 = 0
            r24 = 2143289344(0x7fc00000, float:NaN)
            r25 = 0
        L_0x0105:
            boolean r26 = r23.hasNext()
            if (r26 == 0) goto L_0x08ea
            java.lang.Object r26 = r23.next()
            r11 = r26
            fe.when.ad.f.n r11 = (fe.when.ad.f.n) r11
            fe.when.ad.f.c2 r10 = r7.qqq
            boolean r10 = v(r10)
            if (r10 == 0) goto L_0x0122
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r10 = r11.ppp
            if (r10 == 0) goto L_0x0122
            r9.K(r10)
        L_0x0122:
            fe.when.ad.de r10 = r11.de()
            fe.when.ad.f.d0 r28 = r11.fe()
            float r14 = r28.uk()
            boolean r28 = r11.eee()
            if (r28 == 0) goto L_0x0140
            float r28 = r11.nn()
            r31 = r4
            r32 = r28
            r13 = 0
            r28 = r1
            goto L_0x0161
        L_0x0140:
            fe.when.ad.f.d0 r28 = r11.fe()
            fe.when.ad.f.ad r13 = r28.fe()
            r28 = r1
            r1 = 1
            float r13 = r13.m1066switch(r1, r14)
            fe.when.ad.f.d0 r1 = r11.fe()
            fe.when.ad.f.ad r1 = r1.fe()
            r31 = r4
            r4 = 3
            float r1 = r1.m1066switch(r4, r14)
            r32 = r13
            r13 = r1
        L_0x0161:
            java.lang.String r4 = "HSCALE"
            java.lang.String r1 = "SKEW"
            r33 = r12
            java.lang.String r12 = "WORD_SPACING"
            r34 = r10
            java.lang.String r10 = "CHAR_SPACING"
            r35 = r10
            if (r0 > r3) goto L_0x06b4
            if (r18 == 0) goto L_0x0178
            float r36 = r11.xxx(r6, r5)
            goto L_0x017c
        L_0x0178:
            float r36 = r11.p()
        L_0x017c:
            boolean r37 = r11.b()
            if (r37 == 0) goto L_0x068f
            int r10 = r0 + 1
            fe.when.ad.f.n r10 = r8.rg(r10)
            boolean r38 = r11.tt()
            if (r38 == 0) goto L_0x01f7
            r38 = r0
            java.lang.String r0 = "SEPARATOR"
            java.lang.Object r0 = r11.rg(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r29 = 0
            r36 = r0[r29]
            com.itextpdf.text.pdf.draw.DrawInterface r36 = (com.itextpdf.text.pdf.draw.DrawInterface) r36
            r30 = 1
            r0 = r0[r30]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01d5
            float r39 = r2 + r13
            float r0 = r54.o()
            float r40 = r22 + r0
            float r41 = r32 - r13
            r0 = r36
            r8 = r1
            r1 = r56
            r42 = r2
            r2 = r22
            r43 = r3
            r3 = r39
            r44 = r4
            r39 = r12
            r12 = r31
            r4 = r40
            r45 = r5
            r5 = r41
            r46 = r6
            r6 = r42
            r0.qw(r1, r2, r3, r4, r5, r6)
            goto L_0x01f4
        L_0x01d5:
            r8 = r1
            r43 = r3
            r44 = r4
            r45 = r5
            r46 = r6
            r39 = r12
            r12 = r31
            r6 = r2
            float r3 = r6 + r13
            float r4 = r16 + r12
            float r5 = r32 - r13
            r0 = r36
            r1 = r56
            r2 = r16
            r42 = r6
            r0.qw(r1, r2, r3, r4, r5, r6)
        L_0x01f4:
            r36 = r12
            goto L_0x0208
        L_0x01f7:
            r38 = r0
            r8 = r1
            r42 = r2
            r43 = r3
            r44 = r4
            r45 = r5
            r46 = r6
            r39 = r12
            r12 = r31
        L_0x0208:
            boolean r0 = r11.c()
            if (r0 == 0) goto L_0x027a
            java.lang.String r0 = "TABSETTINGS"
            boolean r0 = r11.mmm(r0)
            if (r0 == 0) goto L_0x023f
            com.itextpdf.text.TabStop r0 = r11.when()
            if (r0 == 0) goto L_0x023c
            float r1 = r0.fe()
            float r17 = r1 + r22
            com.itextpdf.text.pdf.draw.DrawInterface r1 = r0.de()
            if (r1 == 0) goto L_0x0275
            com.itextpdf.text.pdf.draw.DrawInterface r0 = r0.de()
            r6 = r42
            float r3 = r6 + r13
            float r5 = r32 - r13
            r1 = r56
            r2 = r16
            r4 = r17
            r0.qw(r1, r2, r3, r4, r5, r6)
            goto L_0x0275
        L_0x023c:
            r17 = r16
            goto L_0x0275
        L_0x023f:
            java.lang.String r0 = "TAB"
            java.lang.Object r0 = r11.rg(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r2 = r0[r1]
            r1 = r2
            com.itextpdf.text.pdf.draw.DrawInterface r1 = (com.itextpdf.text.pdf.draw.DrawInterface) r1
            r2 = 1
            r3 = r0[r2]
            java.lang.Float r3 = (java.lang.Float) r3
            float r2 = r3.floatValue()
            r3 = 3
            r0 = r0[r3]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r17 = r2 + r0
            int r0 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x0275
            r6 = r42
            float r3 = r6 + r13
            float r5 = r32 - r13
            r0 = r1
            r1 = r56
            r2 = r16
            r4 = r17
            r0.qw(r1, r2, r3, r4, r5, r6)
        L_0x0275:
            r31 = r16
            r6 = r17
            goto L_0x027e
        L_0x027a:
            r6 = r16
            r31 = r17
        L_0x027e:
            java.lang.String r0 = "BACKGROUND"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x0301
            boolean r1 = r56.v()
            if (r1 == 0) goto L_0x0297
            fe.when.ad.f.c2 r2 = r7.qqq
            boolean r2 = v(r2)
            if (r2 == 0) goto L_0x0297
            r56.j()
        L_0x0297:
            if (r10 == 0) goto L_0x02a1
            boolean r2 = r10.mmm(r0)
            if (r2 == 0) goto L_0x02a1
            r2 = 0
            goto L_0x02a3
        L_0x02a1:
            r2 = r19
        L_0x02a3:
            if (r10 != 0) goto L_0x02a7
            float r2 = r2 + r21
        L_0x02a7:
            java.lang.Object r0 = r11.rg(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r3 = 0
            r4 = r0[r3]
            fe.when.ad.de r4 = (fe.when.ad.de) r4
            r15.h0(r4)
            r4 = 1
            r0 = r0[r4]
            float[] r0 = (float[]) r0
            r5 = r0[r3]
            float r5 = r6 - r5
            r3 = r42
            float r16 = r3 + r13
            r17 = r0[r4]
            float r16 = r16 - r17
            float r17 = r11.ggg()
            float r4 = r16 + r17
            float r2 = r36 - r2
            r16 = 0
            r17 = r0[r16]
            float r2 = r2 + r17
            r16 = 2
            r17 = r0[r16]
            float r2 = r2 + r17
            float r16 = r32 - r13
            r40 = r12
            r12 = 1
            r17 = r0[r12]
            float r16 = r16 + r17
            r17 = 3
            r0 = r0[r17]
            float r0 = r16 + r0
            r15.N(r5, r4, r2, r0)
            r56.p()
            r0 = 0
            r15.q0(r0)
            if (r1 == 0) goto L_0x0305
            fe.when.ad.f.c2 r0 = r7.qqq
            boolean r0 = v(r0)
            if (r0 == 0) goto L_0x0305
            r15.xxx(r12)
            goto L_0x0305
        L_0x0301:
            r40 = r12
            r3 = r42
        L_0x0305:
            java.lang.String r0 = "UNDERLINE"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x03b1
            boolean r1 = r11.rrr()
            if (r1 != 0) goto L_0x03b1
            boolean r1 = r56.v()
            if (r1 == 0) goto L_0x0324
            fe.when.ad.f.c2 r2 = r7.qqq
            boolean r2 = v(r2)
            if (r2 == 0) goto L_0x0324
            r56.j()
        L_0x0324:
            if (r10 == 0) goto L_0x032e
            boolean r2 = r10.mmm(r0)
            if (r2 == 0) goto L_0x032e
            r2 = 0
            goto L_0x0330
        L_0x032e:
            r2 = r19
        L_0x0330:
            if (r10 != 0) goto L_0x0334
            float r2 = r2 + r21
        L_0x0334:
            java.lang.Object r0 = r11.rg(r0)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            r4 = 0
        L_0x033b:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x039b
            r5 = r0[r4]
            r16 = 0
            r17 = r5[r16]
            fe.when.ad.de r17 = (fe.when.ad.de) r17
            r30 = 1
            r5 = r5[r30]
            float[] r5 = (float[]) r5
            if (r17 != 0) goto L_0x0351
            r12 = r34
            goto L_0x0353
        L_0x0351:
            r12 = r17
        L_0x0353:
            if (r12 == 0) goto L_0x0358
            r15.l0(r12)
        L_0x0358:
            r17 = r5[r16]
            r16 = r5[r30]
            float r16 = r16 * r14
            r42 = r0
            float r0 = r17 + r16
            r15.x0(r0)
            r0 = 2
            r16 = r5[r0]
            r0 = 3
            r17 = r5[r0]
            float r17 = r17 * r14
            float r16 = r16 + r17
            r0 = 4
            r5 = r5[r0]
            int r0 = (int) r5
            if (r0 == 0) goto L_0x0378
            r15.s0(r0)
        L_0x0378:
            float r5 = r3 + r16
            r15.I(r6, r5)
            float r16 = r6 + r36
            r47 = r8
            float r8 = r16 - r2
            r15.G(r8, r5)
            r56.V0()
            if (r12 == 0) goto L_0x038e
            r56.S()
        L_0x038e:
            if (r0 == 0) goto L_0x0394
            r0 = 0
            r15.s0(r0)
        L_0x0394:
            int r4 = r4 + 1
            r0 = r42
            r8 = r47
            goto L_0x033b
        L_0x039b:
            r47 = r8
            r8 = 1065353216(0x3f800000, float:1.0)
            r15.x0(r8)
            if (r1 == 0) goto L_0x03b5
            fe.when.ad.f.c2 r0 = r7.qqq
            boolean r0 = v(r0)
            if (r0 == 0) goto L_0x03b5
            r0 = 1
            r15.xxx(r0)
            goto L_0x03b5
        L_0x03b1:
            r47 = r8
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03b5:
            java.lang.String r0 = "ACTION"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x0469
            if (r10 == 0) goto L_0x03c7
            boolean r1 = r10.mmm(r0)
            if (r1 == 0) goto L_0x03c7
            r1 = 0
            goto L_0x03c9
        L_0x03c7:
            r1 = r19
        L_0x03c9:
            if (r10 != 0) goto L_0x03cd
            float r1 = r1 + r21
        L_0x03cd:
            boolean r2 = r11.eee()
            if (r2 == 0) goto L_0x0401
            fe.when.ad.f.j r12 = new fe.when.ad.f.j
            fe.when.ad.f.c2 r2 = r7.qqq
            float r4 = r11.o()
            float r4 = r4 + r3
            float r5 = r6 + r36
            float r5 = r5 - r1
            float r1 = r11.uk()
            float r1 = r1 + r3
            float r16 = r11.o()
            float r16 = r1 + r16
            java.lang.Object r0 = r11.rg(r0)
            r17 = r0
            fe.when.ad.f.h r17 = (fe.when.ad.f.h) r17
            r0 = r12
            r1 = r2
            r2 = r6
            r8 = r3
            r3 = r4
            r4 = r5
            r5 = r16
            r15 = r6
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x0426
        L_0x0401:
            r8 = r3
            r15 = r6
            fe.when.ad.f.j r12 = new fe.when.ad.f.j
            fe.when.ad.f.c2 r2 = r7.qqq
            float r3 = r8 + r13
            float r4 = r11.ggg()
            float r3 = r3 + r4
            float r6 = r15 + r36
            float r4 = r6 - r1
            float r1 = r8 + r32
            float r5 = r11.ggg()
            float r5 = r5 + r1
            java.lang.Object r0 = r11.rg(r0)
            r6 = r0
            fe.when.ad.f.h r6 = (fe.when.ad.f.h) r6
            r0 = r12
            r1 = r2
            r2 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x0426:
            r0 = 1
            r9.rg(r12, r0)
            fe.when.ad.f.c2 r0 = r7.qqq
            boolean r0 = v(r0)
            if (r0 == 0) goto L_0x046b
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r0 = r11.ppp
            if (r0 == 0) goto L_0x046b
            java.util.HashMap<fe.when.ad.qw, fe.when.ad.f.x1> r1 = r7.eee
            fe.when.ad.qw r0 = r0.getId()
            java.lang.Object r0 = r1.get(r0)
            fe.when.ad.f.x1 r0 = (fe.when.ad.f.x1) r0
            if (r0 == 0) goto L_0x046b
            int r1 = r7.m(r12)
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.W4
            fe.when.ad.f.v0 r3 = new fe.when.ad.f.v0
            r3.<init>((int) r1)
            r12.h(r2, r3)
            fe.when.ad.f.c2 r2 = r7.qqq
            fe.when.ad.f.l0 r2 = r2.t()
            r0.r(r12, r2)
            fe.when.ad.f.c2 r2 = r7.qqq
            fe.when.ad.f.y1 r2 = r2.S()
            fe.when.ad.f.l0 r0 = r0.p()
            r2.r(r1, r0)
            goto L_0x046b
        L_0x0469:
            r8 = r3
            r15 = r6
        L_0x046b:
            java.lang.String r0 = "REMOTEGOTO"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x04da
            if (r10 == 0) goto L_0x047d
            boolean r1 = r10.mmm(r0)
            if (r1 == 0) goto L_0x047d
            r1 = 0
            goto L_0x047f
        L_0x047d:
            r1 = r19
        L_0x047f:
            if (r10 != 0) goto L_0x0483
            float r1 = r1 + r21
        L_0x0483:
            java.lang.Object r0 = r11.rg(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r2 = 0
            r3 = r0[r2]
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            r3 = 1
            r4 = r0[r3]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x04b7
            r0 = r0[r3]
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            float r0 = r8 + r13
            float r4 = r11.ggg()
            float r4 = r4 + r0
            float r6 = r15 + r36
            float r5 = r6 - r1
            float r0 = r8 + r32
            float r1 = r11.ggg()
            float r6 = r0 + r1
            r0 = r53
            r1 = r2
            r2 = r3
            r3 = r15
            r0.D(r1, r2, r3, r4, r5, r6)
            goto L_0x04da
        L_0x04b7:
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            float r0 = r8 + r13
            float r4 = r11.ggg()
            float r4 = r4 + r0
            float r6 = r15 + r36
            float r5 = r6 - r1
            float r0 = r8 + r32
            float r1 = r11.ggg()
            float r6 = r0 + r1
            r0 = r53
            r1 = r2
            r2 = r3
            r3 = r15
            r0.C(r1, r2, r3, r4, r5, r6)
        L_0x04da:
            java.lang.String r0 = "LOCALGOTO"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x0507
            if (r10 == 0) goto L_0x04ec
            boolean r1 = r10.mmm(r0)
            if (r1 == 0) goto L_0x04ec
            r1 = 0
            goto L_0x04ee
        L_0x04ec:
            r1 = r19
        L_0x04ee:
            if (r10 != 0) goto L_0x04f2
            float r1 = r1 + r21
        L_0x04f2:
            java.lang.Object r0 = r11.rg(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            float r6 = r15 + r36
            float r4 = r6 - r1
            float r5 = r8 + r14
            r0 = r53
            r1 = r2
            r2 = r15
            r3 = r8
            r0.x(r1, r2, r3, r4, r5)
        L_0x0507:
            java.lang.String r0 = "LOCALDESTINATION"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x0522
            java.lang.Object r0 = r11.rg(r0)
            java.lang.String r0 = (java.lang.String) r0
            fe.when.ad.f.v r1 = new fe.when.ad.f.v
            float r2 = r8 + r14
            r3 = 0
            r12 = 0
            r1.<init>(r3, r15, r2, r12)
            r7.w(r0, r1)
            goto L_0x0523
        L_0x0522:
            r12 = 0
        L_0x0523:
            java.lang.String r0 = "GENERICTAG"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x0558
            if (r10 == 0) goto L_0x0535
            boolean r1 = r10.mmm(r0)
            if (r1 == 0) goto L_0x0535
            r1 = 0
            goto L_0x0537
        L_0x0535:
            r1 = r19
        L_0x0537:
            if (r10 != 0) goto L_0x053b
            float r1 = r1 + r21
        L_0x053b:
            fe.when.ad.aaa r2 = new fe.when.ad.aaa
            float r6 = r15 + r36
            float r6 = r6 - r1
            float r1 = r8 + r14
            r2.<init>(r15, r8, r6, r1)
            fe.when.ad.f.c2 r1 = r7.qqq
            com.itextpdf.text.pdf.PdfPageEvent r1 = r1.J()
            if (r1 == 0) goto L_0x0558
            fe.when.ad.f.c2 r3 = r7.qqq
            java.lang.Object r0 = r11.rg(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.de(r3, r7, r2, r0)
        L_0x0558:
            java.lang.String r0 = "PDFANNOTATION"
            boolean r1 = r11.mmm(r0)
            if (r1 == 0) goto L_0x058f
            if (r10 == 0) goto L_0x056a
            boolean r1 = r10.mmm(r0)
            if (r1 == 0) goto L_0x056a
            r1 = 0
            goto L_0x056c
        L_0x056a:
            r1 = r19
        L_0x056c:
            if (r10 != 0) goto L_0x0570
            float r1 = r1 + r21
        L_0x0570:
            java.lang.Object r0 = r11.rg(r0)
            fe.when.ad.f.j r0 = (fe.when.ad.f.j) r0
            fe.when.ad.f.j r0 = fe.when.ad.f.e0.A(r0)
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.m4
            fe.when.ad.f.o1 r3 = new fe.when.ad.f.o1
            float r4 = r8 + r13
            float r6 = r15 + r36
            float r6 = r6 - r1
            float r1 = r8 + r32
            r3.<init>(r15, r4, r6, r1)
            r0.h(r2, r3)
            r1 = 1
            r9.rg(r0, r1)
        L_0x058f:
            r14 = r47
            java.lang.Object r0 = r11.rg(r14)
            float[] r0 = (float[]) r0
            r13 = r44
            java.lang.Object r1 = r11.rg(r13)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r0 != 0) goto L_0x05a7
            if (r1 == 0) goto L_0x05a4
            goto L_0x05a7
        L_0x05a4:
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x05c9
        L_0x05a7:
            if (r0 == 0) goto L_0x05b2
            r2 = 0
            r3 = r0[r2]
            r2 = 1
            r0 = r0[r2]
            r2 = r3
            r3 = r0
            goto L_0x05b4
        L_0x05b2:
            r2 = 0
            r3 = 0
        L_0x05b4:
            if (r1 == 0) goto L_0x05bc
            float r0 = r1.floatValue()
            r10 = r0
            goto L_0x05be
        L_0x05bc:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x05be:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = r55
            r1 = r10
            r5 = r15
            r6 = r8
            r0.M0(r1, r2, r3, r4, r5, r6)
            r0 = r10
        L_0x05c9:
            if (r18 != 0) goto L_0x05f6
            r1 = r39
            boolean r2 = r11.mmm(r1)
            if (r2 == 0) goto L_0x05e0
            java.lang.Object r2 = r11.rg(r1)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r9.P0(r2)
        L_0x05e0:
            r2 = r35
            boolean r3 = r11.mmm(r2)
            if (r3 == 0) goto L_0x05fa
            java.lang.Object r3 = r11.rg(r2)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r9.g0(r3)
            goto L_0x05fa
        L_0x05f6:
            r2 = r35
            r1 = r39
        L_0x05fa:
            boolean r3 = r11.eee()
            if (r3 == 0) goto L_0x0672
            fe.when.ad.i r3 = r11.yj()
            float r36 = r11.m1093if()
            float r4 = r11.pf()
            float[] r4 = r3.p0(r4)
            float r5 = r11.i()
            float r6 = r15 + r5
            r5 = 4
            r10 = r4[r5]
            float r6 = r6 - r10
            r4[r5] = r6
            float r6 = r11.o()
            float r6 = r6 + r8
            r10 = 5
            r16 = r4[r10]
            float r6 = r6 - r16
            r4[r10] = r6
            r6 = 0
            r16 = r4[r6]
            r17 = 1
            r26 = r4[r17]
            r29 = 2
            r30 = r4[r29]
            r32 = 3
            r35 = r4[r32]
            r5 = r4[r5]
            r4 = r4[r10]
            r58 = r0
            r6 = r2
            r2 = r34
            r0 = 2
            r10 = r56
            r27 = r11
            r11 = r3
            r49 = r1
            r1 = r33
            r3 = r40
            r0 = 0
            r12 = r16
            r50 = r13
            r13 = r26
            r51 = r14
            r14 = r30
            r26 = r15
            r15 = r35
            r16 = r5
            r17 = r4
            r10.yj(r11, r12, r13, r14, r15, r16, r17)
            float r4 = r26 + r19
            float r5 = r27.m1093if()
            float r4 = r4 + r5
            float r5 = r55.D()
            float r4 = r4 - r5
            r9.H(r4, r0)
            goto L_0x0688
        L_0x0672:
            r58 = r0
            r49 = r1
            r6 = r2
            r27 = r11
            r50 = r13
            r51 = r14
            r26 = r15
            r1 = r33
            r2 = r34
            r3 = r40
            r0 = 0
            r32 = 3
        L_0x0688:
            r11 = r58
            r16 = r26
            r17 = r31
            goto L_0x06ad
        L_0x068f:
            r38 = r0
            r51 = r1
            r8 = r2
            r43 = r3
            r50 = r4
            r45 = r5
            r46 = r6
            r27 = r11
            r49 = r12
            r3 = r31
            r1 = r33
            r2 = r34
            r6 = r35
            r0 = 0
            r32 = 3
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x06ad:
            float r16 = r16 + r36
            int r4 = r38 + 1
            r5 = r16
            goto L_0x06d6
        L_0x06b4:
            r38 = r0
            r51 = r1
            r8 = r2
            r43 = r3
            r50 = r4
            r45 = r5
            r46 = r6
            r27 = r11
            r49 = r12
            r3 = r31
            r1 = r33
            r2 = r34
            r6 = r35
            r0 = 0
            r32 = 3
            r5 = r16
            r4 = r38
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x06d6:
            boolean r10 = r27.eee()
            if (r10 != 0) goto L_0x06f8
            fe.when.ad.f.d0 r10 = r27.fe()
            r12 = r28
            int r10 = r10.compareTo(r12)
            if (r10 == 0) goto L_0x06fa
            fe.when.ad.f.d0 r10 = r27.fe()
            fe.when.ad.f.ad r12 = r10.fe()
            float r13 = r10.uk()
            r9.p0(r12, r13)
            goto L_0x06fb
        L_0x06f8:
            r12 = r28
        L_0x06fa:
            r10 = r12
        L_0x06fb:
            java.lang.String r12 = "TEXTRENDERMODE"
            r13 = r27
            java.lang.Object r12 = r13.rg(r12)
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            java.lang.String r15 = "SUBSUPSCRIPT"
            java.lang.Object r15 = r13.rg(r15)
            java.lang.Float r15 = (java.lang.Float) r15
            if (r12 == 0) goto L_0x0751
            r14 = 0
            r16 = r12[r14]
            java.lang.Integer r16 = (java.lang.Integer) r16
            int r16 = r16.intValue()
            r14 = r16 & 3
            if (r14 == 0) goto L_0x071f
            r9.N0(r14)
        L_0x071f:
            r0 = 1
            if (r14 == r0) goto L_0x072d
            r0 = 2
            if (r14 != r0) goto L_0x0727
            r0 = 1
            goto L_0x072d
        L_0x0727:
            r16 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            goto L_0x0757
        L_0x072d:
            r16 = r12[r0]
            java.lang.Float r16 = (java.lang.Float) r16
            float r0 = r16.floatValue()
            r16 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            int r27 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x0740
            r9.x0(r0)
        L_0x0740:
            r27 = 2
            r12 = r12[r27]
            fe.when.ad.de r12 = (fe.when.ad.de) r12
            if (r12 != 0) goto L_0x0749
            r12 = r2
        L_0x0749:
            if (r12 == 0) goto L_0x074e
            r9.l0(r12)
        L_0x074e:
            r48 = r0
            goto L_0x0759
        L_0x0751:
            r16 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r14 = 0
        L_0x0757:
            r48 = 1065353216(0x3f800000, float:1.0)
        L_0x0759:
            if (r15 == 0) goto L_0x0760
            float r0 = r15.floatValue()
            goto L_0x0761
        L_0x0760:
            r0 = 0
        L_0x0761:
            if (r2 == 0) goto L_0x0766
            r9.h0(r2)
        L_0x0766:
            r15 = 0
            int r27 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r27 == 0) goto L_0x076e
            r9.O0(r0)
        L_0x076e:
            boolean r0 = r13.eee()
            if (r0 == 0) goto L_0x0782
            r33 = r1
            r31 = r3
            r29 = r10
            r0 = r45
            r4 = r46
            r25 = 1
            goto L_0x0872
        L_0x0782:
            boolean r0 = r13.qqq()
            r15 = 1148846080(0x447a0000, float:1000.0)
            if (r0 == 0) goto L_0x07a1
            fe.when.ad.f.a2 r0 = new fe.when.ad.f.a2
            r0.<init>()
            float r4 = -r3
            float r4 = r4 * r15
            fe.when.ad.f.d0 r15 = r13.f9534de
            float r15 = r15.uk()
            float r4 = r4 / r15
            float r4 = r4 / r11
            r0.qw(r4)
            r9.Q0(r0)
            goto L_0x07c2
        L_0x07a1:
            boolean r0 = r13.c()
            if (r0 == 0) goto L_0x07ce
            int r0 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x07ce
            fe.when.ad.f.a2 r0 = new fe.when.ad.f.a2
            r0.<init>()
            float r4 = r17 - r5
            float r4 = r4 * r15
            fe.when.ad.f.d0 r15 = r13.f9534de
            float r15 = r15.uk()
            float r4 = r4 / r15
            float r4 = r4 / r11
            r0.qw(r4)
            r9.Q0(r0)
        L_0x07c2:
            r33 = r1
            r31 = r3
            r29 = r10
            r0 = r45
            r4 = r46
            goto L_0x0872
        L_0x07ce:
            if (r18 == 0) goto L_0x084a
            if (r1 <= 0) goto L_0x084a
            boolean r0 = r13.a()
            if (r0 == 0) goto L_0x084a
            int r0 = (r11 > r24 ? 1 : (r11 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x07f3
            r0 = r45
            float r4 = r0 / r11
            r9.P0(r4)
            r4 = r46
            float r24 = r4 / r11
            float r28 = r55.q()
            float r15 = r24 + r28
            r9.g0(r15)
            r24 = r11
            goto L_0x07f7
        L_0x07f3:
            r0 = r45
            r4 = r46
        L_0x07f7:
            java.lang.String r15 = r13.toString()
            r33 = r1
            r1 = 32
            r31 = r3
            int r3 = r15.indexOf(r1)
            if (r3 >= 0) goto L_0x080d
            r9.R0(r15)
            r29 = r10
            goto L_0x0872
        L_0x080d:
            float r1 = -r0
            r29 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r29
            r29 = r10
            fe.when.ad.f.d0 r10 = r13.f9534de
            float r10 = r10.uk()
            float r1 = r1 / r10
            float r1 = r1 / r11
            fe.when.ad.f.a2 r10 = new fe.when.ad.f.a2
            r11 = 0
            java.lang.String r7 = r15.substring(r11, r3)
            r10.<init>(r7)
        L_0x0826:
            int r7 = r3 + 1
            r11 = 32
            int r7 = r15.indexOf(r11, r7)
            if (r7 < 0) goto L_0x083c
            r10.qw(r1)
            java.lang.String r3 = r15.substring(r3, r7)
            r10.ad(r3)
            r3 = r7
            goto L_0x0826
        L_0x083c:
            r10.qw(r1)
            java.lang.String r1 = r15.substring(r3)
            r10.ad(r1)
            r9.Q0(r10)
            goto L_0x0872
        L_0x084a:
            r33 = r1
            r31 = r3
            r29 = r10
            r0 = r45
            r4 = r46
            if (r18 == 0) goto L_0x086b
            int r1 = (r11 > r24 ? 1 : (r11 == r24 ? 0 : -1))
            if (r1 == 0) goto L_0x086b
            float r1 = r0 / r11
            r9.P0(r1)
            float r1 = r4 / r11
            float r3 = r55.q()
            float r1 = r1 + r3
            r9.g0(r1)
            r24 = r11
        L_0x086b:
            java.lang.String r1 = r13.toString()
            r9.R0(r1)
        L_0x0872:
            if (r27 == 0) goto L_0x0878
            r1 = 0
            r9.O0(r1)
        L_0x0878:
            if (r2 == 0) goto L_0x087d
            r55.T()
        L_0x087d:
            if (r14 == 0) goto L_0x0883
            r1 = 0
            r9.N0(r1)
        L_0x0883:
            if (r12 == 0) goto L_0x0888
            r55.U()
        L_0x0888:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r48 > r1 ? 1 : (r48 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0891
            r9.x0(r1)
        L_0x0891:
            r2 = r51
            boolean r2 = r13.mmm(r2)
            if (r2 != 0) goto L_0x08a1
            r2 = r50
            boolean r2 = r13.mmm(r2)
            if (r2 == 0) goto L_0x08a6
        L_0x08a1:
            r9.L0(r5, r8)
            r25 = 1
        L_0x08a6:
            if (r18 != 0) goto L_0x08bc
            boolean r2 = r13.mmm(r6)
            if (r2 == 0) goto L_0x08b1
            r9.g0(r4)
        L_0x08b1:
            r2 = r49
            boolean r2 = r13.mmm(r2)
            if (r2 == 0) goto L_0x08bc
            r9.P0(r0)
        L_0x08bc:
            r2 = r53
            fe.when.ad.f.c2 r3 = r2.qqq
            boolean r3 = v(r3)
            if (r3 == 0) goto L_0x08cd
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r3 = r13.ppp
            if (r3 == 0) goto L_0x08cd
            r9.eee(r3)
        L_0x08cd:
            r15 = r56
            r7 = r2
            r6 = r4
            r2 = r8
            r1 = r29
            r4 = r31
            r12 = r33
            r3 = r43
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r13 = 1
            r14 = 0
            r8 = r54
            r52 = r5
            r5 = r0
            r0 = r16
            r16 = r52
            goto L_0x0105
        L_0x08ea:
            r12 = r1
            r2 = r7
            r0 = 0
            if (r18 == 0) goto L_0x08fd
            r9.P0(r0)
            r9.g0(r0)
            boolean r1 = r54.ppp()
            if (r1 == 0) goto L_0x08fd
            r10 = 0
            goto L_0x08ff
        L_0x08fd:
            r10 = r19
        L_0x08ff:
            if (r25 == 0) goto L_0x090a
            float r1 = r55.D()
            float r1 = r22 - r1
            r9.H(r1, r0)
        L_0x090a:
            r0 = 0
            r57[r0] = r12
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r10)
            r1 = 1
            r57[r1] = r0
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.y.H(fe.when.ad.f.p0, fe.when.ad.f.q, fe.when.ad.f.q, java.lang.Object[], float):float");
    }

    public void I() throws IOException {
        if (this.A.m().size() != 0) {
            z(this.A);
            c2 c2Var = this.qqq;
            z0 z0Var = this.A;
            c2Var.tt(z0Var, z0Var.n());
        }
    }

    public void a() {
        if (this.A.m().size() != 0) {
            G(this.A);
        }
    }

    public final void aaa(PdfDiv pdfDiv) throws DocumentException {
        if (this.W == null) {
            this.W = new ArrayList<>();
        }
        this.W.add(pdfDiv);
    }

    public boolean ad(Element element) throws DocumentException {
        xxx qw2;
        c2 c2Var = this.qqq;
        if (c2Var != null && c2Var.th()) {
            return false;
        }
        try {
            if (element.type() != 37) {
                e();
            }
            int type = element.type();
            if (type == 23) {
                d1 d1Var = (d1) element;
                if (d1Var.K() > d1Var.nn()) {
                    c();
                    f();
                    qqq(d1Var);
                    this.Q = false;
                    y();
                }
            } else if (type != 50) {
                float f2 = 0.0f;
                if (type == 55) {
                    DrawInterface drawInterface = (DrawInterface) element;
                    q qVar = this.f;
                    float q2 = q();
                    float p2 = p();
                    float r2 = r();
                    float s2 = s();
                    float s3 = s() - this.j;
                    if (this.n.size() > 0) {
                        f2 = this.g;
                    }
                    drawInterface.qw(qVar, q2, p2, r2, s2, s3 - f2);
                    this.Q = false;
                } else if (type != 666) {
                    if (type == 29) {
                        if (this.v == null) {
                            b();
                        }
                        fe.when.ad.ad adVar = (fe.when.ad.ad) element;
                        aaa aaa = new aaa(0.0f, 0.0f);
                        if (this.v != null) {
                            aaa = new aaa(adVar.rg(r() - this.v.tt()), adVar.m1064switch((s() - this.j) - 20.0f), adVar.pf((r() - this.v.tt()) + 20.0f), adVar.yj(s() - this.j));
                        }
                        this.L.de(fe.when.ad.f.s2.qw.fe(this.qqq, adVar, aaa));
                        this.Q = false;
                    } else if (type != 30) {
                        switch (type) {
                            case 0:
                                this.z.t(((nn) element).ad(), ((nn) element).qw());
                                break;
                            case 1:
                                this.z.s(((nn) element).qw());
                                break;
                            case 2:
                                this.z.r(((nn) element).qw());
                                break;
                            case 3:
                                this.z.p(((nn) element).qw());
                                break;
                            case 4:
                                this.z.l(((nn) element).qw());
                                break;
                            case 5:
                                this.z.q();
                                break;
                            case 6:
                                this.z.m();
                                break;
                            case 7:
                                this.z.n(((nn) element).qw());
                                break;
                            case 8:
                                E(((nn) element).qw());
                                break;
                            default:
                                switch (type) {
                                    case 10:
                                        if (this.v == null) {
                                            b();
                                        }
                                        n nVar = new n((fe.when.ad.fe) element, this.l, this.m);
                                        while (true) {
                                            n qw3 = this.v.qw(nVar);
                                            if (qw3 == null) {
                                                this.Q = false;
                                                if (nVar.mmm("NEWPAGE")) {
                                                    qw();
                                                    break;
                                                }
                                            } else {
                                                b();
                                                if (!nVar.rrr()) {
                                                    qw3.l();
                                                }
                                                nVar = qw3;
                                            }
                                        }
                                        break;
                                    case 11:
                                        rrr rrr2 = this.m;
                                        if (((Phrase) element).getTabSettings() != null) {
                                            this.m = ((Phrase) element).getTabSettings();
                                        }
                                        this.g = ((Phrase) element).getTotalLeading();
                                        B();
                                        element.process(this);
                                        this.m = rrr2;
                                        A();
                                        break;
                                    case 12:
                                        rrr rrr3 = this.m;
                                        if (((Phrase) element).getTabSettings() != null) {
                                            this.m = ((Phrase) element).getTabSettings();
                                        }
                                        Paragraph paragraph = (Paragraph) element;
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.K(paragraph);
                                        }
                                        eee(paragraph.getSpacingBefore(), this.g, paragraph.getFont());
                                        this.h = paragraph.getAlignment();
                                        this.g = paragraph.getTotalLeading();
                                        B();
                                        b();
                                        if (this.j + tt() > s() - p()) {
                                            qw();
                                        }
                                        this.y.qw += paragraph.getIndentationLeft();
                                        this.y.f9846rg += paragraph.getIndentationRight();
                                        b();
                                        PdfPageEvent J2 = this.qqq.J();
                                        if (J2 != null && !this.k) {
                                            J2.uk(this.qqq, this, s() - this.j);
                                        }
                                        if (paragraph.getKeepTogether()) {
                                            b();
                                            d1 d1Var2 = new d1(1);
                                            d1Var2.A(paragraph.getKeepTogether());
                                            d1Var2.I(100.0f);
                                            a1 a1Var = new a1();
                                            a1Var.p(paragraph);
                                            a1Var.f(0);
                                            a1Var.P(0.0f);
                                            d1Var2.qw(a1Var);
                                            this.y.qw -= paragraph.getIndentationLeft();
                                            this.y.f9846rg -= paragraph.getIndentationRight();
                                            ad(d1Var2);
                                            this.y.qw += paragraph.getIndentationLeft();
                                            this.y.f9846rg += paragraph.getIndentationRight();
                                        } else {
                                            this.v.qqq(paragraph.getFirstLineIndent());
                                            element.process(this);
                                            b();
                                            eee(paragraph.getSpacingAfter(), paragraph.getTotalLeading(), paragraph.getFont());
                                        }
                                        if (J2 != null && !this.k) {
                                            J2.pf(this.qqq, this, s() - this.j);
                                        }
                                        this.h = 0;
                                        this.y.qw -= paragraph.getIndentationLeft();
                                        this.y.f9846rg -= paragraph.getIndentationRight();
                                        b();
                                        this.m = rrr3;
                                        A();
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.eee(paragraph);
                                            break;
                                        }
                                        break;
                                    case 13:
                                    case 16:
                                        Section section = (Section) element;
                                        PdfPageEvent J3 = this.qqq.J();
                                        boolean z2 = section.isNotAddedYet() && section.getTitle() != null;
                                        if (section.isTriggerNewPage()) {
                                            qw();
                                        }
                                        if (z2) {
                                            float s4 = s() - this.j;
                                            int mmm = this.f9896uk.mmm();
                                            if (mmm == 90 || mmm == 180) {
                                                s4 = this.f9896uk.ggg() - s4;
                                            }
                                            v vVar = new v(2, s4);
                                            while (this.B.r() >= section.getDepth()) {
                                                this.B = this.B.s();
                                            }
                                            this.B = new z0(this.B, vVar, section.getBookmarkTitle(), section.isBookmarkOpen());
                                        }
                                        b();
                                        this.y.f9842ad += section.getIndentationLeft();
                                        this.y.f9847th += section.getIndentationRight();
                                        if (section.isNotAddedYet() && J3 != null) {
                                            if (element.type() == 16) {
                                                J3.rg(this.qqq, this, s() - this.j, section.getTitle());
                                            } else {
                                                J3.th(this.qqq, this, s() - this.j, section.getDepth(), section.getTitle());
                                            }
                                        }
                                        if (z2) {
                                            this.k = true;
                                            ad(section.getTitle());
                                            this.k = false;
                                        }
                                        this.y.f9842ad += section.getIndentation();
                                        element.process(this);
                                        f();
                                        this.y.f9842ad -= section.getIndentationLeft() + section.getIndentation();
                                        this.y.f9847th -= section.getIndentationRight();
                                        if (section.isComplete() && J3 != null) {
                                            if (element.type() != 16) {
                                                J3.o(this.qqq, this, s() - this.j);
                                                break;
                                            } else {
                                                J3.i(this.qqq, this, s() - this.j);
                                                break;
                                            }
                                        }
                                        break;
                                    case 14:
                                        ppp ppp = (ppp) element;
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.K(ppp);
                                        }
                                        if (ppp.th()) {
                                            ppp.pf();
                                        }
                                        this.y.f9843de += ppp.ad();
                                        this.y.f9846rg += ppp.de();
                                        element.process(this);
                                        this.y.f9843de -= ppp.ad();
                                        this.y.f9846rg -= ppp.de();
                                        b();
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.eee(ppp);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        ListItem listItem = (ListItem) element;
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.K(listItem);
                                        }
                                        eee(listItem.getSpacingBefore(), this.g, listItem.getFont());
                                        this.h = listItem.getAlignment();
                                        this.y.f9843de += listItem.getIndentationLeft();
                                        this.y.f9846rg += listItem.getIndentationRight();
                                        this.g = listItem.getTotalLeading();
                                        B();
                                        b();
                                        this.v.eee(listItem);
                                        element.process(this);
                                        eee(listItem.getSpacingAfter(), listItem.getTotalLeading(), listItem.getFont());
                                        if (this.v.m1109if()) {
                                            this.v.aaa();
                                        }
                                        b();
                                        this.y.f9843de -= listItem.getIndentationLeft();
                                        this.y.f9846rg -= listItem.getIndentationRight();
                                        A();
                                        if (v(this.qqq)) {
                                            f();
                                            this.e.eee(listItem.getListBody());
                                            this.e.eee(listItem);
                                            break;
                                        }
                                        break;
                                    case 17:
                                        Anchor anchor = (Anchor) element;
                                        String reference = anchor.getReference();
                                        this.g = anchor.getLeading();
                                        B();
                                        if (reference != null) {
                                            this.l = new h(reference);
                                        }
                                        element.process(this);
                                        this.l = null;
                                        A();
                                        break;
                                    default:
                                        switch (type) {
                                            case 32:
                                            case 33:
                                            case 34:
                                            case 35:
                                            case 36:
                                                if (v(this.qqq) && !((i) element).f0()) {
                                                    f();
                                                    this.e.K((i) element);
                                                }
                                                nn((i) element);
                                                if (v(this.qqq) && !((i) element).f0()) {
                                                    f();
                                                    this.e.eee((i) element);
                                                    break;
                                                }
                                            case 37:
                                                c();
                                                f();
                                                aaa((PdfDiv) element);
                                                this.Q = false;
                                                break;
                                            default:
                                                return false;
                                        }
                                }
                                break;
                        }
                    } else {
                        this.f.O((aaa) element);
                        this.Q = false;
                    }
                } else if (this.qqq != null) {
                    ((WriterOperation) element).qw(this.qqq, this);
                }
            } else {
                if ((element instanceof ddd) && (qw2 = ((ddd) element).qw()) != null) {
                    qw2.process(this);
                }
                ((xxx) element).process(this);
            }
            this.x = element.type();
            return true;
        } catch (Exception e2) {
            throw new DocumentException(e2);
        }
    }

    public void b() {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        p0 p0Var = this.v;
        if (p0Var != null && p0Var.rrr() > 0) {
            if (this.j + tt() > s() - p()) {
                p0 p0Var2 = this.v;
                this.v = null;
                qw();
                this.v = p0Var2;
                p0Var2.f9676ad = q();
            }
            this.j += this.v.m1110switch();
            this.w.add(this.v);
            this.Q = false;
        }
        float f2 = this.U;
        if (f2 > -1.0f && this.j > f2) {
            this.U = -1.0f;
            ad adVar = this.y;
            adVar.f9849yj = 0.0f;
            adVar.f9844fe = 0.0f;
        }
        this.v = new p0(q(), r(), this.h, this.g);
    }

    public void c() {
        try {
            if (this.x == 11 || this.x == 10) {
                y();
                f();
            }
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void close() {
        int size;
        if (!this.f9897yj) {
            try {
                boolean z2 = true;
                if (v(this.qqq)) {
                    e();
                    f();
                    this.qqq.w().eee(this);
                    this.qqq.m();
                    this.qqq.n();
                    if (u() && (size = this.qqq.ppp.size()) > 0 && this.qqq.ggg == size) {
                        this.qqq.ppp.remove(size - 1);
                    }
                } else {
                    this.qqq.m();
                }
                if (this.V == null) {
                    z2 = false;
                }
                qw();
                if (this.V != null || z2) {
                    qw();
                }
                if (!this.L.th()) {
                    PdfPageEvent J2 = this.qqq.J();
                    if (J2 != null) {
                        J2.yj(this.qqq, this);
                    }
                    super.close();
                    this.qqq.ppp(this.E);
                    a();
                    I();
                    this.qqq.close();
                    return;
                }
                throw new RuntimeException(fe.when.ad.c.qw.ad("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            } catch (Exception e2) {
                throw ExceptionConverter.convertException(e2);
            }
        }
    }

    public boolean d(d1 d1Var, float f2) {
        if (!d1Var.m()) {
            d1Var.H(((r() - q()) * d1Var.g()) / 100.0f);
        }
        c();
        float floatValue = Float.valueOf(d1Var.p() ? d1Var.e() - d1Var.ddd() : d1Var.e()).floatValue();
        float f3 = 0.0f;
        if (this.j > 0.0f) {
            f3 = d1Var.N();
        }
        return floatValue + f3 <= ((s() - this.j) - p()) - f2;
    }

    public boolean de(aaa aaa) {
        c2 c2Var = this.qqq;
        if (c2Var != null && c2Var.th()) {
            return false;
        }
        this.N = new aaa(aaa);
        return true;
    }

    public final void e() throws DocumentException {
        ArrayList<Element> arrayList = this.W;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<Element> arrayList2 = this.W;
            this.W = null;
            ggg ggg = new ggg(arrayList2, false);
            int i2 = 0;
            while (true) {
                ggg.rg(q(), p(), r(), s() - this.j);
                try {
                    if ((ggg.fe(v(this.qqq) ? this.e : this.qqq.w(), false) & 1) != 0) {
                        if (v(this.qqq)) {
                            this.e.L0(q(), ggg.de());
                        } else {
                            this.e.H(0.0f, (ggg.de() - s()) + this.j);
                        }
                        this.j = s() - ggg.de();
                        return;
                    }
                    i2 = (s() - this.j == ggg.de() || u()) ? i2 + 1 : 0;
                    if (i2 != 2) {
                        qw();
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public void eee(float f2, float f3, Font font) {
        if (f2 == 0.0f || this.Q) {
            return;
        }
        if (this.j + tt() > s() - p()) {
            qw();
            return;
        }
        this.g = f2;
        b();
        if (font.ggg() || font.ppp()) {
            Font font2 = new Font(font);
            font2.vvv(font2.m677switch() & -5 & -9);
            font = font2;
        }
        new fe.when.ad.fe(" ", font).process(this);
        b();
        this.g = f3;
    }

    public float f() throws DocumentException {
        vvv vvv;
        if (this.w == null) {
            return 0.0f;
        }
        p0 p0Var = this.v;
        if (p0Var != null && p0Var.rrr() > 0) {
            this.w.add(this.v);
            this.v = new p0(q(), r(), this.h, this.g);
        }
        if (this.w.isEmpty()) {
            return 0.0f;
        }
        Object[] objArr = new Object[2];
        objArr[1] = new Float(0.0f);
        Iterator<p0> it = this.w.iterator();
        d0 d0Var = null;
        float f2 = 0.0f;
        while (it.hasNext()) {
            p0 next = it.next();
            float when = next.when() - q();
            ad adVar = this.y;
            float f3 = when + adVar.qw + adVar.f9843de + adVar.f9842ad;
            this.e.H(f3, -next.m1110switch());
            next.de();
            if (next.nn() != null) {
                fe.when.ad.fe nn = next.nn();
                if (v(this.qqq)) {
                    vvv = next.ddd().getListLabel();
                    this.f.K(vvv);
                    fe.when.ad.fe feVar = new fe.when.ad.fe(nn);
                    feVar.setRole((s0) null);
                    nn = feVar;
                } else {
                    vvv = null;
                }
                pf.v(this.f, 0, new Phrase(nn), this.e.D() - next.xxx(), this.e.E(), 0.0f);
                if (vvv != null) {
                    this.f.eee(vvv);
                }
            }
            objArr[0] = d0Var;
            if (v(this.qqq) && next.ddd() != null) {
                this.e.K(next.ddd().getListBody());
            }
            H(next, this.e, this.f, objArr, this.qqq.Q());
            d0Var = (d0) objArr[0];
            f2 += next.m1110switch();
            this.e.H(-f3, 0.0f);
        }
        this.w = new ArrayList<>();
        return f2;
    }

    public boolean fe(float f2, float f3, float f4, float f5) {
        c2 c2Var = this.qqq;
        if (c2Var != null && c2Var.th()) {
            return false;
        }
        this.q = f2;
        this.r = f3;
        this.s = f4;
        this.t = f5;
        return true;
    }

    public de g(l0 l0Var) {
        de deVar = new de(l0Var, this.qqq);
        if (this.A.m().size() > 0) {
            deVar.h(s0.J3, s0.X5);
            deVar.h(s0.A3, this.A.n());
        }
        this.qqq.O().qw(deVar);
        this.C.qw(deVar);
        i1 i1Var = this.D;
        if (i1Var != null) {
            deVar.h(s0.H3, i1Var.qw(this.qqq));
        }
        deVar.l(this.E, h(), this.G, this.qqq);
        String str = this.H;
        if (str != null) {
            deVar.n(k(str));
        } else {
            h hVar = this.I;
            if (hVar != null) {
                deVar.n(hVar);
            }
        }
        x xVar = this.J;
        if (xVar != null) {
            deVar.m(xVar);
        }
        fe.when.ad.f.o2.qw qwVar = this.K;
        if (qwVar != null) {
            deVar.h(s0.V, qwVar);
        }
        if (this.L.yj()) {
            try {
                deVar.h(s0.f456switch, this.qqq.eee(this.L.rg()).qw());
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
        w1 w1Var = this.M;
        if (w1Var != null) {
            deVar.h(s0.x2, w1Var);
        }
        return deVar;
    }

    public HashMap<String, y0> h() {
        return this.F;
    }

    public fe j() {
        return this.z;
    }

    public h k(String str) {
        qw qwVar = this.E.get(str);
        if (qwVar == null) {
            qwVar = new qw(this);
        }
        h hVar = qwVar.qw;
        if (hVar != null) {
            return hVar;
        }
        if (qwVar.f9850ad == null) {
            qwVar.f9850ad = this.qqq.M();
        }
        h hVar2 = new h(qwVar.f9850ad);
        qwVar.qw = hVar2;
        this.E.put(str, qwVar);
        return hVar2;
    }

    public e l() {
        return this.S;
    }

    public int m(Object obj) {
        int[] iArr = this.tt.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.tt.size(), 0};
            this.tt.put(obj, iArr);
        }
        return iArr[0];
    }

    public void mmm(j jVar) {
        this.Q = false;
        this.L.qw(jVar);
    }

    public int[] n(Object obj) {
        int[] iArr = this.tt.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.tt.size(), 0};
            this.tt.put(obj, iArr);
        }
        int i2 = iArr[1];
        iArr[1] = iArr[1] + 1;
        return new int[]{iArr[0], i2};
    }

    public void nn(i iVar) throws PdfException, DocumentException {
        float f2;
        i iVar2 = iVar;
        if (iVar.b0()) {
            this.f.th(iVar2);
            this.Q = false;
            return;
        }
        if (this.j != 0.0f && (s() - this.j) - iVar.S() < p()) {
            if (this.T || this.V != null) {
                qw();
                if (this.j != 0.0f && (s() - this.j) - iVar.S() < p()) {
                    this.V = iVar2;
                    return;
                }
            } else {
                this.V = iVar2;
                return;
            }
        }
        this.Q = false;
        if (iVar2 == this.V) {
            this.V = null;
        }
        boolean z2 = (iVar.s() & 4) == 4 && (iVar.s() & 1) != 1;
        boolean z3 = (iVar.s() & 8) == 8;
        float f3 = this.g;
        float f4 = f3 / 2.0f;
        if (z2) {
            f4 += f3;
        }
        float f5 = f4;
        float s2 = ((s() - this.j) - iVar.S()) - f5;
        float[] o0 = iVar.o0();
        float q2 = q() - o0[4];
        if ((iVar.s() & 2) == 2) {
            q2 = (r() - iVar.T()) - o0[4];
        }
        if ((iVar.s() & 1) == 1) {
            q2 = (q() + (((r() - q()) - iVar.T()) / 2.0f)) - o0[4];
        }
        if (iVar.a0()) {
            q2 = iVar.p();
        }
        if (z2) {
            float f6 = this.U;
            if (f6 < 0.0f || f6 < this.j + iVar.S() + f5) {
                this.U = this.j + iVar.S() + f5;
            }
            if ((iVar.s() & 2) == 2) {
                this.y.f9849yj += iVar.T() + iVar.C();
            } else {
                this.y.f9844fe += iVar.T() + iVar.D();
            }
        } else if ((iVar.s() & 2) == 2) {
            q2 -= iVar.D();
        } else {
            if ((iVar.s() & 1) == 1) {
                f2 = iVar.C() - iVar.D();
            } else {
                f2 = iVar.C();
            }
            q2 += f2;
        }
        this.f.yj(iVar, o0[0], o0[1], o0[2], o0[3], q2, s2 - o0[5]);
        if (!z2 && !z3) {
            this.j += iVar.S() + f5;
            f();
            this.e.H(0.0f, -(iVar.S() + f5));
            y();
        }
    }

    public void open() {
        if (!this.f9895th) {
            super.open();
            this.qqq.open();
            z0 z0Var = new z0(this.qqq);
            this.A = z0Var;
            this.B = z0Var;
        }
        try {
            t();
            if (v(this.qqq)) {
                this.rrr = true;
            }
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public float p() {
        return uk(this.y.f9845i);
    }

    public float q() {
        ad adVar = this.y;
        return m1133switch(adVar.qw + adVar.f9843de + adVar.f9844fe + adVar.f9842ad);
    }

    public void qqq(d1 d1Var) throws DocumentException {
        pf pfVar = new pf(v(this.qqq) ? this.e : this.qqq.w());
        if (d1Var.aaa() && !d(d1Var, 0.0f) && this.j > 0.0f) {
            qw();
        }
        if (this.j == 0.0f) {
            pfVar.rrr(false);
        }
        pfVar.qw(d1Var);
        boolean l2 = d1Var.l();
        d1Var.y(true);
        int i2 = 0;
        while (true) {
            pfVar.n(q(), p(), r(), s() - this.j);
            if ((pfVar.xxx() & 1) != 0) {
                if (v(this.qqq)) {
                    this.e.L0(q(), pfVar.vvv());
                } else {
                    this.e.H(0.0f, (pfVar.vvv() - s()) + this.j);
                }
                this.j = s() - pfVar.vvv();
                d1Var.y(l2);
                return;
            }
            i2 = s() - this.j == pfVar.vvv() ? i2 + 1 : 0;
            if (i2 != 3) {
                qw();
                if (v(this.qqq)) {
                    pfVar.b(this.e);
                }
            } else {
                throw new DocumentException(fe.when.ad.c.qw.ad("infinite.table.loop", new Object[0]));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0171 A[Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017c A[Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0191 A[Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ae A[Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean qw() {
        /*
            r11 = this;
            java.lang.String r0 = "crop"
            java.lang.String r1 = "art"
            r11.e()     // Catch:{ DocumentException -> 0x01d5 }
            r2 = -1
            r11.x = r2
            boolean r2 = r11.u()
            r3 = 0
            if (r2 == 0) goto L_0x0015
            r11.F()
            return r3
        L_0x0015:
            boolean r2 = r11.f9895th
            if (r2 == 0) goto L_0x01c7
            boolean r2 = r11.f9897yj
            if (r2 != 0) goto L_0x01c7
            fe.when.ad.f.c2 r2 = r11.qqq
            com.itextpdf.text.pdf.PdfPageEvent r2 = r2.J()
            if (r2 == 0) goto L_0x002a
            fe.when.ad.f.c2 r4 = r11.qqq
            r2.ad(r4, r11)
        L_0x002a:
            super.qw()
            fe.when.ad.f.y$ad r2 = r11.y
            r4 = 0
            r2.f9844fe = r4
            r2.f9849yj = r4
            r11.f()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r2 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r2 = r2.mmm()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r4 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r4 = r4.X()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r4 == 0) goto L_0x009c
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r4 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r4 = r4.containsKey(r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.lang.String r5 = "trim"
            if (r4 == 0) goto L_0x0066
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r4 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r4 = r4.containsKey(r5)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r4 != 0) goto L_0x0058
            goto L_0x0066
        L_0x0058:
            com.itextpdf.text.pdf.PdfXConformanceException r0 = new com.itextpdf.text.pdf.PdfXConformanceException     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.lang.String r1 = "only.one.of.artbox.or.trimbox.can.exist.in.the.page"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r1, r2)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.<init>(r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            throw r0     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x0066:
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r3 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r1 = r3.containsKey(r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r1 != 0) goto L_0x009c
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r1 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r1 != 0) goto L_0x009c
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r1 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r1 == 0) goto L_0x008a
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r1 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r3 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.put(r5, r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            goto L_0x009c
        L_0x008a:
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r0 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.o1 r1 = new fe.when.ad.f.o1     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r3 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r4 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r4 = r4.mmm()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.<init>((fe.when.ad.aaa) r3, (int) r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.put(r5, r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x009c:
            fe.when.ad.f.e r0 = r11.S     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r1 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.x r1 = r1.v()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.de(r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = r0.Z()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x00c0
            fe.when.ad.f.x r0 = new fe.when.ad.f.x     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.<init>()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.s0 r1 = fe.when.ad.f.s0.j0     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.w0     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.h(r1, r3)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.e r1 = r11.S     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.de(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x00c0:
            fe.when.ad.f.e r0 = r11.S     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.x r0 = r0.uk()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.h1 r1 = new fe.when.ad.f.h1     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.o1 r3 = new fe.when.ad.f.o1     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r4 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r3.<init>((fe.when.ad.aaa) r4, (int) r2)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.util.HashMap<java.lang.String, fe.when.ad.f.o1> r4 = r11.O     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.<init>(r3, r4, r0, r2)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = v(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x00e4
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.g5     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.s0 r2 = fe.when.ad.f.s0.D4     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.h(r0, r2)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            goto L_0x00ef
        L_0x00e4:
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.g5     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r2 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.s0 r2 = r2.T()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.h(r0, r2)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x00ef:
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.x r0 = r0.I()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.j(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.e0()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.x r0 = r11.R     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r2 = 0
            if (r0 == 0) goto L_0x0115
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.f9759pf     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r3 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.x r4 = r11.R     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.k0 r3 = r3.eee(r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.l0 r3 = r3.qw()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.h(r0, r3)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r11.R = r2     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x0115:
            fe.when.ad.f.s2.qw r0 = r11.L     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = r0.th()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x0132
            fe.when.ad.f.s2.qw r0 = r11.L     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r3 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r4 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.k r0 = r0.i(r3, r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r3 = r0.size()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r3 == 0) goto L_0x0132
            fe.when.ad.f.s0 r3 = fe.when.ad.f.s0.nn     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.h(r3, r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x0132:
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = v(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x014e
            fe.when.ad.f.s0 r0 = fe.when.ad.f.s0.X4     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.v0 r3 = new fe.when.ad.f.v0     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r4 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.l0 r4 = r4.t()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r4 = r11.m(r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r3.<init>((int) r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.h(r0, r3)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x014e:
            fe.when.ad.f.q r0 = r11.e     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r0 = r0.T0()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            int r3 = r11.p     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 > r3) goto L_0x0164
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = v(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x0161
            goto L_0x0164
        L_0x0161:
            r11.e = r2     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            goto L_0x0169
        L_0x0164:
            fe.when.ad.f.q r0 = r11.e     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r0.j()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x0169:
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r0 = v(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x017c
            fe.when.ad.f.c2 r0 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.q r0 = r0.w()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            java.util.ArrayList r0 = r0.c0()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            goto L_0x017d
        L_0x017c:
            r0 = r2
        L_0x017d:
            fe.when.ad.f.c2 r3 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.s r10 = new fe.when.ad.f.s     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r4 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.q r5 = r4.x()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.q r6 = r11.f     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r4 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r4 = v(r4)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r4 != 0) goto L_0x0193
            fe.when.ad.f.q r2 = r11.e     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x0193:
            r7 = r2
            fe.when.ad.f.c2 r2 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.q r8 = r2.w()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.aaa r9 = r11.f9896uk     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r3.i(r1, r10)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r11.t()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.c2 r1 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            boolean r1 = v(r1)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            if (r1 == 0) goto L_0x01b7
            fe.when.ad.f.c2 r1 = r11.qqq     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            fe.when.ad.f.q r1 = r1.x()     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
            r1.X(r0)     // Catch:{ DocumentException -> 0x01c0, IOException -> 0x01b9 }
        L_0x01b7:
            r0 = 1
            return r0
        L_0x01b9:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x01c0:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x01c7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "the.document.is.not.open"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x01d5:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.y.qw():boolean");
    }

    public float r() {
        ad adVar = this.y;
        return ppp(adVar.f9846rg + adVar.f9847th + adVar.f9849yj);
    }

    public void rrr(c2 c2Var) throws DocumentException {
        if (this.qqq == null) {
            this.qqq = c2Var;
            this.L = new fe.when.ad.f.s2.qw(c2Var);
            return;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
    }

    public float s() {
        return xxx(this.y.f9848uk);
    }

    public void t() throws DocumentException {
        this.ppp++;
        this.L.uk();
        this.S = new e();
        this.qqq.d0();
        if (v(this.qqq)) {
            this.f = this.qqq.x().s();
            this.qqq.w().ggg = this.f;
        } else {
            this.f = new q(this.qqq);
        }
        F();
        this.U = -1.0f;
        ad adVar = this.y;
        adVar.f9849yj = 0.0f;
        adVar.f9844fe = 0.0f;
        adVar.f9845i = 0.0f;
        adVar.f9848uk = 0.0f;
        this.j = 0.0f;
        this.O = new HashMap<>(this.P);
        if (!(this.f9896uk.ad() == null && !this.f9896uk.a() && this.f9896uk.fe() == null)) {
            ad(this.f9896uk);
        }
        float f2 = this.g;
        int i2 = this.h;
        this.Q = true;
        try {
            if (this.V != null) {
                nn(this.V);
                this.V = null;
            }
            this.g = f2;
            this.h = i2;
            b();
            PdfPageEvent J2 = this.qqq.J();
            if (J2 != null) {
                if (this.u) {
                    J2.qw(this.qqq, this);
                }
                J2.fe(this.qqq, this);
            }
            this.u = false;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public float tt() {
        float f2 = this.v.m1110switch();
        float f3 = this.g;
        return f2 != f3 ? f2 + f3 : f2;
    }

    public boolean u() {
        if (v(this.qqq)) {
            c2 c2Var = this.qqq;
            if (c2Var == null) {
                return true;
            }
            if (c2Var.w().U0(false) == 0 && this.qqq.x().U0(false) == 0 && this.e.U0(false) - this.p == 0 && (this.Q || this.qqq.th())) {
                return true;
            }
            return false;
        }
        c2 c2Var2 = this.qqq;
        if (c2Var2 == null) {
            return true;
        }
        if (c2Var2.w().T0() == 0 && this.qqq.x().T0() == 0 && (this.Q || this.qqq.th())) {
            return true;
        }
        return false;
    }

    public boolean w(String str, v vVar) {
        qw qwVar = this.E.get(str);
        if (qwVar == null) {
            qwVar = new qw(this);
        }
        if (qwVar.f9851de != null) {
            return false;
        }
        qwVar.f9851de = vVar;
        this.E.put(str, qwVar);
        if (vVar.l()) {
            return true;
        }
        vVar.k(this.qqq.t());
        return true;
    }

    public void x(String str, float f2, float f3, float f4, float f5) {
        this.L.de(new j(this.qqq, f2, f3, f4, f5, k(str)));
    }

    public void y() throws DocumentException {
        this.x = -1;
        b();
        ArrayList<p0> arrayList = this.w;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.w.add(this.v);
            this.j += this.v.m1110switch();
        }
        this.v = new p0(q(), r(), this.h, this.g);
    }

    public void z(z0 z0Var) throws IOException {
        z0Var.v(this.qqq.M());
        if (z0Var.s() != null) {
            z0Var.h(s0.O3, z0Var.s().n());
        }
        ArrayList<z0> m2 = z0Var.m();
        int size = m2.size();
        for (int i2 = 0; i2 < size; i2++) {
            z(m2.get(i2));
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                m2.get(i3).h(s0.X3, m2.get(i3 - 1).n());
            }
            if (i3 < size - 1) {
                m2.get(i3).h(s0.g3, m2.get(i3 + 1).n());
            }
        }
        if (size > 0) {
            z0Var.h(s0.f1, m2.get(0).n());
            z0Var.h(s0.y2, m2.get(size - 1).n());
        }
        for (int i4 = 0; i4 < size; i4++) {
            z0 z0Var2 = m2.get(i4);
            this.qqq.tt(z0Var2, z0Var2.n());
        }
    }
}
