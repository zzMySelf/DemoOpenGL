package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.c.qw;
import fe.when.ad.e.ad;
import fe.when.ad.fe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class pf {
    public boolean a = true;
    public float aaa = 0.0f;

    /* renamed from: ad  reason: collision with root package name */
    public int f9691ad = 0;
    public int b;
    public float c;
    public boolean d = false;
    public float ddd = 0.0f;

    /* renamed from: de  reason: collision with root package name */
    public float f9692de;
    public int e = 0;
    public boolean eee = false;
    public float f;

    /* renamed from: fe  reason: collision with root package name */
    public float f9693fe;
    public boolean g = false;
    public q ggg;
    public pf h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<float[]> f9694i;

    /* renamed from: if  reason: not valid java name */
    public float f448if;
    public LinkedList<Element> j;
    public int k = 0;
    public int l = 0;
    public int m = -1;
    public float mmm = 0.0f;
    public Phrase n;
    public float nn = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public de f9695o;
    public boolean p = false;

    /* renamed from: pf  reason: collision with root package name */
    public float f9696pf;
    public float ppp = 0.0f;
    public float q;
    public float qqq = -1.0f;
    public final Logger qw = ad.qw(pf.class);
    public boolean r = true;

    /* renamed from: rg  reason: collision with root package name */
    public float f9697rg;
    public float rrr = 0.0f;
    public boolean s = false;

    /* renamed from: switch  reason: not valid java name */
    public float f449switch = 16.0f;

    /* renamed from: th  reason: collision with root package name */
    public float f9698th;
    public boolean tt = true;

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<float[]> f9699uk;
    public q[] vvv;
    public float when = 16.0f;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f9700yj = 0;

    public pf(q qVar) {
        this.ggg = qVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r1 = r1.f9708yj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean aaa(fe.when.ad.f.q r1) {
        /*
            if (r1 == 0) goto L_0x0012
            fe.when.ad.f.y r0 = r1.f9707uk
            if (r0 == 0) goto L_0x0012
            fe.when.ad.f.c2 r1 = r1.f9708yj
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.a0()
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.pf.aaa(fe.when.ad.f.q):boolean");
    }

    public static pf fe(pf pfVar) {
        pf pfVar2 = new pf((q) null);
        pfVar2.eee(pfVar);
        return pfVar2;
    }

    public static void v(q qVar, int i2, Phrase phrase, float f2, float f3, float f4) {
        w(qVar, i2, phrase, f2, f3, f4, 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r3 == 2) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void w(fe.when.ad.f.q r18, int r19, com.itextpdf.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x0011
            r2 = 1
            if (r0 == r2) goto L_0x0011
            if (r0 == r9) goto L_0x0011
            r15 = 0
            goto L_0x0012
        L_0x0011:
            r15 = r0
        L_0x0012:
            r18.d0()
            fe.when.ad.f.pf r14 = new fe.when.ad.f.pf
            r13 = r18
            r14.<init>(r13)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 1073741824(0x40000000, float:2.0)
            r0 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r2 = 1184645120(0x469c4000, float:20000.0)
            r3 = 0
            if (r15 == 0) goto L_0x0035
            if (r15 == r9) goto L_0x002f
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            goto L_0x0036
        L_0x002f:
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r16 = 0
            goto L_0x0039
        L_0x0035:
            r12 = 0
        L_0x0036:
            r16 = 1184645120(0x469c4000, float:20000.0)
        L_0x0039:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0046
            float r12 = r12 + r21
            float r0 = r22 + r10
            float r16 = r16 + r21
            float r1 = r22 + r11
            goto L_0x006d
        L_0x0046:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.e(r1, r2, r3, r4, r5, r6)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x006d:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r0
            r0 = r14
            r14 = r16
            r3 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r10.q(r11, r12, r13, r14, r15, r16, r17)
            r1 = 3
            if (r7 != r1) goto L_0x0089
            if (r3 != 0) goto L_0x0086
            r8 = 2
            goto L_0x008a
        L_0x0086:
            if (r3 != r9) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r8 = r3
        L_0x008a:
            r0.tt(r8)
            r1 = r25
            r0.a(r1)
            r0.m(r7)
            r0.xxx()     // Catch:{ DocumentException -> 0x009c }
            r18.Y()
            return
        L_0x009c:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.pf.w(fe.when.ad.f.q, int, com.itextpdf.text.Phrase, float, float, float, int, int):void");
    }

    public void a(int i2) {
        this.e = i2;
    }

    public void ad(Phrase phrase) {
        if (phrase != null && !this.g) {
            de();
            if (this.f9695o == null) {
                this.n = phrase;
                return;
            }
            for (fe nVar : phrase.getChunks()) {
                this.f9695o.qw(new n(nVar, (h) null, phrase.getTabSettings()));
            }
        }
    }

    public void b(q qVar) {
        this.ggg = qVar;
        this.vvv = null;
        pf pfVar = this.h;
        if (pfVar != null) {
            pfVar.b(qVar);
        }
    }

    public void c(q[] qVarArr) {
        this.vvv = qVarArr;
        this.ggg = qVarArr[3];
        pf pfVar = this.h;
        if (pfVar != null) {
            pfVar.c(qVarArr);
        }
    }

    public void d(float f2) {
        this.aaa = f2;
    }

    public int ddd(boolean z) throws DocumentException {
        return nn(z, (IAccessibleElement) null);
    }

    public final void de() {
        if (this.f9695o == null && this.n != null) {
            this.f9695o = new de();
            for (fe nVar : this.n.getChunks()) {
                this.f9695o.qw(new n(nVar, (h) null, this.n.getTabSettings()));
            }
            this.n = null;
        }
    }

    public void e(float f2) {
        this.q = f2;
    }

    public pf eee(pf pfVar) {
        r(pfVar);
        if (pfVar.f9695o != null) {
            this.f9695o = new de(pfVar.f9695o);
        }
        return this;
    }

    public void f(float f2) {
        this.nn = f2;
        this.tt = true;
    }

    public void g(float f2, boolean z) {
        this.ddd = f2;
        this.tt = true;
        this.a = z;
    }

    public int ggg() {
        return this.f9691ad;
    }

    public void h(boolean z) {
        this.s = z;
    }

    public q i() {
        return this.ggg;
    }

    /* renamed from: if  reason: not valid java name */
    public float m1111if() {
        return this.q;
    }

    public void j(float f2) {
        this.when = f2;
        this.ppp = 0.0f;
    }

    public void k(float f2, float f3) {
        this.when = f2;
        this.ppp = f3;
    }

    public void l(float f2) {
        this.mmm = f2;
        this.tt = true;
    }

    public void m(int i2) {
        if (i2 < 0 || i2 > 3) {
            throw new RuntimeException(qw.qw("invalid.run.direction.1", i2));
        }
        this.f9691ad = i2;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0392, code lost:
        r5 = r0.h;
        r0.f9696pf = r5.f9696pf;
        r0.b += r5.b;
        r0.f = r5.f;
        r0.f449switch = r5.f449switch;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03ad, code lost:
        if (aaa(r0.ggg) != false) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03b7, code lost:
        if (java.lang.Float.isNaN(r0.h.c) != false) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03bd, code lost:
        if (r0.h.d != false) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03bf, code lost:
        if (r1 != false) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03c1, code lost:
        r5 = r0.ggg;
        r6 = new com.itextpdf.text.Phrase(r7.getListSymbol());
        r9 = r0.h;
        v(r5, 0, r6, r9.f9697rg + r8, r9.c, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03e1, code lost:
        r0.h.d = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03e7, code lost:
        if ((r11 & 1) == 0) goto L_0x03fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03e9, code lost:
        r0.h = null;
        r0.k += r4;
        r0.f9696pf -= r7.getSpacingAfter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03fc, code lost:
        if ((r11 & 2) == 0) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03fe, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0504, code lost:
        if (r6.n() != false) goto L_0x0506;
     */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0745  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x077f A[LOOP:6: B:358:0x0769->B:364:0x077f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0788  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x080f  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0819  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x07b0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mmm(boolean r27) throws com.itextpdf.text.DocumentException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            fe.when.ad.f.q r2 = r0.ggg
            if (r2 == 0) goto L_0x000a
            fe.when.ad.f.y r2 = r2.f9707uk
        L_0x000a:
            boolean r2 = r0.eee
            r3 = 0
            if (r2 == 0) goto L_0x0855
            r0.b = r3
            r2 = 0
            r0.f = r2
            r4 = 1
            r5 = 1
        L_0x0016:
            java.util.LinkedList<com.itextpdf.text.Element> r6 = r0.j
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x001f
            return r4
        L_0x001f:
            java.util.LinkedList<com.itextpdf.text.Element> r6 = r0.j
            java.lang.Object r6 = r6.getFirst()
            com.itextpdf.text.Element r6 = (com.itextpdf.text.Element) r6
            int r7 = r6.type()
            r8 = 12
            r9 = 0
            r10 = 2
            if (r7 != r8) goto L_0x0190
            com.itextpdf.text.Paragraph r6 = (com.itextpdf.text.Paragraph) r6
            r7 = 0
            r8 = 0
        L_0x0035:
            if (r7 >= r10) goto L_0x0153
            float r8 = r0.f9696pf
            fe.when.ad.f.pf r11 = r0.h
            if (r11 != 0) goto L_0x00ae
            fe.when.ad.f.pf r11 = new fe.when.ad.f.pf
            fe.when.ad.f.q r12 = r0.ggg
            r11.<init>(r12)
            r0.h = r11
            int r12 = r6.getAlignment()
            r11.tt(r12)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r6.getIndentationLeft()
            float r13 = r6.getFirstLineIndent()
            float r12 = r12 + r13
            r11.g(r12, r3)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r6.getExtraParagraphSpace()
            r11.d(r12)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r6.getIndentationLeft()
            r11.f(r12)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r6.getIndentationRight()
            r11.l(r12)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r6.getLeading()
            float r13 = r6.getMultipliedLeading()
            r11.k(r12, r13)
            fe.when.ad.f.pf r11 = r0.h
            int r12 = r0.f9691ad
            r11.m(r12)
            fe.when.ad.f.pf r11 = r0.h
            int r12 = r0.e
            r11.a(r12)
            fe.when.ad.f.pf r11 = r0.h
            float r12 = r0.rrr
            r11.s(r12)
            fe.when.ad.f.pf r11 = r0.h
            r11.ad(r6)
            if (r5 == 0) goto L_0x00a3
            boolean r11 = r0.r
            if (r11 != 0) goto L_0x00ac
        L_0x00a3:
            float r11 = r0.f9696pf
            float r12 = r6.getSpacingBefore()
            float r11 = r11 - r12
            r0.f9696pf = r11
        L_0x00ac:
            r11 = 1
            goto L_0x00af
        L_0x00ae:
            r11 = 0
        L_0x00af:
            fe.when.ad.f.pf r12 = r0.h
            if (r5 != 0) goto L_0x00b9
            float r13 = r0.f
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x00c0
        L_0x00b9:
            boolean r13 = r0.r
            if (r13 == 0) goto L_0x00c0
            boolean r13 = r0.p
            goto L_0x00c1
        L_0x00c0:
            r13 = 0
        L_0x00c1:
            r12.u(r13)
            fe.when.ad.f.pf r12 = r0.h
            boolean r13 = r0.s
            r12.h(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r0.f9697rg
            r12.f9697rg = r13
            float r13 = r0.f9698th
            r12.f9698th = r13
            float r13 = r0.f9696pf
            r12.f9696pf = r13
            float r13 = r0.qqq
            r12.qqq = r13
            boolean r13 = r0.eee
            r12.eee = r13
            float r13 = r0.f9693fe
            r12.f9693fe = r13
            float r13 = r0.f9692de
            r12.f9692de = r13
            boolean r12 = r6.getKeepTogether()
            if (r12 == 0) goto L_0x00f9
            if (r11 == 0) goto L_0x00f9
            if (r5 == 0) goto L_0x00f7
            boolean r11 = r0.r
            if (r11 != 0) goto L_0x00f9
        L_0x00f7:
            r11 = 1
            goto L_0x00fa
        L_0x00f9:
            r11 = 0
        L_0x00fa:
            if (r1 != 0) goto L_0x0103
            if (r11 == 0) goto L_0x0101
            if (r7 != 0) goto L_0x0101
            goto L_0x0103
        L_0x0101:
            r12 = 0
            goto L_0x0104
        L_0x0103:
            r12 = 1
        L_0x0104:
            fe.when.ad.f.q r13 = r0.ggg
            boolean r13 = aaa(r13)
            if (r13 == 0) goto L_0x0113
            if (r12 != 0) goto L_0x0113
            fe.when.ad.f.q r13 = r0.ggg
            r13.K(r6)
        L_0x0113:
            fe.when.ad.f.pf r13 = r0.h
            int r13 = r13.ddd(r12)
            fe.when.ad.f.q r14 = r0.ggg
            boolean r14 = aaa(r14)
            if (r14 == 0) goto L_0x0128
            if (r12 != 0) goto L_0x0128
            fe.when.ad.f.q r12 = r0.ggg
            r12.eee(r6)
        L_0x0128:
            fe.when.ad.f.pf r12 = r0.h
            float r12 = r12.when()
            r0.f448if = r12
            fe.when.ad.f.pf r12 = r0.h
            float r12 = r12.q
            r0.x(r12)
            r12 = r13 & 1
            if (r12 != 0) goto L_0x0142
            if (r11 == 0) goto L_0x0142
            r0.h = r9
            r0.f9696pf = r8
            return r10
        L_0x0142:
            if (r1 != 0) goto L_0x0152
            if (r11 != 0) goto L_0x0147
            goto L_0x0152
        L_0x0147:
            if (r7 != 0) goto L_0x014d
            r0.h = r9
            r0.f9696pf = r8
        L_0x014d:
            int r7 = r7 + 1
            r8 = r13
            goto L_0x0035
        L_0x0152:
            r8 = r13
        L_0x0153:
            fe.when.ad.f.pf r5 = r0.h
            int r5 = r5.ppp()
            if (r5 <= 0) goto L_0x016c
            fe.when.ad.f.pf r5 = r0.h
            float r7 = r5.f9696pf
            r0.f9696pf = r7
            int r7 = r0.b
            int r11 = r5.b
            int r7 = r7 + r11
            r0.b = r7
            float r5 = r5.f
            r0.f = r5
        L_0x016c:
            fe.when.ad.f.pf r5 = r0.h
            float r5 = r5.f449switch
            r0.f449switch = r5
            r5 = r8 & 1
            if (r5 == 0) goto L_0x0186
            r0.h = r9
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.j
            r5.removeFirst()
            float r5 = r0.f9696pf
            float r6 = r6.getSpacingAfter()
            float r5 = r5 - r6
            r0.f9696pf = r5
        L_0x0186:
            r5 = r8 & 2
            if (r5 == 0) goto L_0x018b
            return r10
        L_0x018b:
            r3 = 0
            r5 = 0
            r8 = 1
            goto L_0x0550
        L_0x0190:
            int r7 = r6.type()
            r8 = 14
            r11 = 3
            if (r7 != r8) goto L_0x03ff
            fe.when.ad.ppp r6 = (fe.when.ad.ppp) r6
            java.util.ArrayList r7 = r6.fe()
            float r8 = r6.ad()
            java.util.Stack r13 = new java.util.Stack
            r13.<init>()
            r14 = 0
            r15 = 0
        L_0x01aa:
            int r12 = r7.size()
            if (r14 >= r12) goto L_0x021e
            java.lang.Object r12 = r7.get(r14)
            boolean r9 = r12 instanceof com.itextpdf.text.ListItem
            if (r9 == 0) goto L_0x01c3
            int r9 = r0.k
            if (r15 != r9) goto L_0x01c0
            r7 = r12
            com.itextpdf.text.ListItem r7 = (com.itextpdf.text.ListItem) r7
            goto L_0x021f
        L_0x01c0:
            int r15 = r15 + 1
            goto L_0x01ea
        L_0x01c3:
            boolean r9 = r12 instanceof fe.when.ad.ppp
            if (r9 == 0) goto L_0x01ea
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r3] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            r7[r4] = r6
            java.lang.Float r6 = new java.lang.Float
            r6.<init>(r8)
            r7[r10] = r6
            r13.push(r7)
            fe.when.ad.ppp r12 = (fe.when.ad.ppp) r12
            java.util.ArrayList r6 = r12.fe()
            float r7 = r12.ad()
            float r8 = r8 + r7
            r7 = r6
            r6 = r12
            r14 = -1
            goto L_0x021b
        L_0x01ea:
            int r9 = r7.size()
            int r9 = r9 - r4
            if (r14 != r9) goto L_0x021b
            boolean r9 = r13.isEmpty()
            if (r9 != 0) goto L_0x021b
            java.lang.Object r6 = r13.pop()
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r7 = r6[r3]
            fe.when.ad.ppp r7 = (fe.when.ad.ppp) r7
            java.util.ArrayList r8 = r7.fe()
            r9 = r6[r4]
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r14 = r9.intValue()
            r6 = r6[r10]
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            r25 = r8
            r8 = r6
            r6 = r7
            r7 = r25
        L_0x021b:
            int r14 = r14 + r4
            r9 = 0
            goto L_0x01aa
        L_0x021e:
            r7 = 0
        L_0x021f:
            r9 = 0
            r11 = 0
        L_0x0221:
            if (r9 >= r10) goto L_0x0392
            float r11 = r0.f9696pf
            fe.when.ad.f.pf r12 = r0.h
            if (r12 != 0) goto L_0x02c7
            if (r7 != 0) goto L_0x0234
            r0.k = r3
            java.util.LinkedList<com.itextpdf.text.Element> r6 = r0.j
            r6.removeFirst()
            goto L_0x0418
        L_0x0234:
            fe.when.ad.f.pf r12 = new fe.when.ad.f.pf
            fe.when.ad.f.q r13 = r0.ggg
            r12.<init>(r13)
            r0.h = r12
            if (r5 != 0) goto L_0x0245
            float r13 = r0.f
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x024c
        L_0x0245:
            boolean r13 = r0.r
            if (r13 == 0) goto L_0x024c
            boolean r13 = r0.p
            goto L_0x024d
        L_0x024c:
            r13 = 0
        L_0x024d:
            r12.u(r13)
            fe.when.ad.f.pf r12 = r0.h
            boolean r13 = r0.s
            r12.h(r13)
            fe.when.ad.f.pf r12 = r0.h
            int r13 = r7.getAlignment()
            r12.tt(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r7.getIndentationLeft()
            float r13 = r13 + r8
            float r14 = r7.getFirstLineIndent()
            float r13 = r13 + r14
            r12.g(r13, r3)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r7.getExtraParagraphSpace()
            r12.d(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r12.m1112switch()
            r12.f(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r7.getIndentationRight()
            float r14 = r6.de()
            float r13 = r13 + r14
            r12.l(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r7.getLeading()
            float r14 = r7.getMultipliedLeading()
            r12.k(r13, r14)
            fe.when.ad.f.pf r12 = r0.h
            int r13 = r0.f9691ad
            r12.m(r13)
            fe.when.ad.f.pf r12 = r0.h
            int r13 = r0.e
            r12.a(r13)
            fe.when.ad.f.pf r12 = r0.h
            float r13 = r0.rrr
            r12.s(r13)
            fe.when.ad.f.pf r12 = r0.h
            r12.ad(r7)
            if (r5 == 0) goto L_0x02bc
            boolean r12 = r0.r
            if (r12 != 0) goto L_0x02c5
        L_0x02bc:
            float r12 = r0.f9696pf
            float r13 = r7.getSpacingBefore()
            float r12 = r12 - r13
            r0.f9696pf = r12
        L_0x02c5:
            r12 = 1
            goto L_0x02c8
        L_0x02c7:
            r12 = 0
        L_0x02c8:
            fe.when.ad.f.pf r13 = r0.h
            float r14 = r0.f9697rg
            r13.f9697rg = r14
            float r14 = r0.f9698th
            r13.f9698th = r14
            float r14 = r0.f9696pf
            r13.f9696pf = r14
            float r14 = r0.qqq
            r13.qqq = r14
            boolean r14 = r0.eee
            r13.eee = r14
            float r14 = r0.f9693fe
            r13.f9693fe = r14
            float r14 = r0.f9692de
            r13.f9692de = r14
            boolean r13 = r7.getKeepTogether()
            if (r13 == 0) goto L_0x02f6
            if (r12 == 0) goto L_0x02f6
            if (r5 == 0) goto L_0x02f4
            boolean r12 = r0.r
            if (r12 != 0) goto L_0x02f6
        L_0x02f4:
            r12 = 1
            goto L_0x02f7
        L_0x02f6:
            r12 = 0
        L_0x02f7:
            if (r1 != 0) goto L_0x0300
            if (r12 == 0) goto L_0x02fe
            if (r9 != 0) goto L_0x02fe
            goto L_0x0300
        L_0x02fe:
            r13 = 0
            goto L_0x0301
        L_0x0300:
            r13 = 1
        L_0x0301:
            fe.when.ad.f.q r14 = r0.ggg
            boolean r14 = aaa(r14)
            if (r14 == 0) goto L_0x032a
            if (r13 != 0) goto L_0x032a
            fe.when.ad.vvv r14 = r7.getListLabel()
            r14.ad(r8)
            com.itextpdf.text.ListItem r14 = r6.qw()
            if (r14 == r7) goto L_0x0320
            fe.when.ad.f.pf r14 = r0.h
            if (r14 == 0) goto L_0x0325
            fe.when.ad.f.de r14 = r14.f9695o
            if (r14 == 0) goto L_0x0325
        L_0x0320:
            fe.when.ad.f.q r14 = r0.ggg
            r14.K(r6)
        L_0x0325:
            fe.when.ad.f.q r14 = r0.ggg
            r14.K(r7)
        L_0x032a:
            fe.when.ad.f.pf r14 = r0.h
            if (r1 != 0) goto L_0x0335
            if (r12 == 0) goto L_0x0333
            if (r9 != 0) goto L_0x0333
            goto L_0x0335
        L_0x0333:
            r15 = 0
            goto L_0x0336
        L_0x0335:
            r15 = 1
        L_0x0336:
            int r14 = r14.nn(r15, r7)
            fe.when.ad.f.q r15 = r0.ggg
            boolean r15 = aaa(r15)
            if (r15 == 0) goto L_0x0365
            if (r13 != 0) goto L_0x0365
            fe.when.ad.f.q r13 = r0.ggg
            fe.when.ad.ggg r15 = r7.getListBody()
            r13.eee(r15)
            fe.when.ad.f.q r13 = r0.ggg
            r13.eee(r7)
            com.itextpdf.text.ListItem r13 = r6.rg()
            if (r13 != r7) goto L_0x035c
            r13 = r14 & 1
            if (r13 != 0) goto L_0x0360
        L_0x035c:
            r13 = r14 & 2
            if (r13 == 0) goto L_0x0365
        L_0x0360:
            fe.when.ad.f.q r13 = r0.ggg
            r13.eee(r6)
        L_0x0365:
            fe.when.ad.f.pf r13 = r0.h
            float r13 = r13.when()
            r0.f448if = r13
            fe.when.ad.f.pf r13 = r0.h
            float r13 = r13.q
            r0.x(r13)
            r13 = r14 & 1
            if (r13 != 0) goto L_0x0380
            if (r12 == 0) goto L_0x0380
            r13 = 0
            r0.h = r13
            r0.f9696pf = r11
            return r10
        L_0x0380:
            r13 = 0
            if (r1 != 0) goto L_0x0391
            if (r12 != 0) goto L_0x0386
            goto L_0x0391
        L_0x0386:
            if (r9 != 0) goto L_0x038c
            r0.h = r13
            r0.f9696pf = r11
        L_0x038c:
            int r9 = r9 + 1
            r11 = r14
            goto L_0x0221
        L_0x0391:
            r11 = r14
        L_0x0392:
            fe.when.ad.f.pf r5 = r0.h
            float r6 = r5.f9696pf
            r0.f9696pf = r6
            int r6 = r0.b
            int r9 = r5.b
            int r6 = r6 + r9
            r0.b = r6
            float r6 = r5.f
            r0.f = r6
            float r5 = r5.f449switch
            r0.f449switch = r5
            fe.when.ad.f.q r5 = r0.ggg
            boolean r5 = aaa(r5)
            if (r5 != 0) goto L_0x03e5
            fe.when.ad.f.pf r5 = r0.h
            float r5 = r5.c
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x03e5
            fe.when.ad.f.pf r5 = r0.h
            boolean r5 = r5.d
            if (r5 != 0) goto L_0x03e5
            if (r1 != 0) goto L_0x03e1
            fe.when.ad.f.q r5 = r0.ggg
            r17 = 0
            com.itextpdf.text.Phrase r6 = new com.itextpdf.text.Phrase
            fe.when.ad.fe r9 = r7.getListSymbol()
            r6.<init>((fe.when.ad.fe) r9)
            fe.when.ad.f.pf r9 = r0.h
            float r12 = r9.f9697rg
            float r19 = r12 + r8
            float r8 = r9.c
            r21 = 0
            r16 = r5
            r18 = r6
            r20 = r8
            v(r16, r17, r18, r19, r20, r21)
        L_0x03e1:
            fe.when.ad.f.pf r5 = r0.h
            r5.d = r4
        L_0x03e5:
            r5 = r11 & 1
            if (r5 == 0) goto L_0x03fa
            r5 = 0
            r0.h = r5
            int r5 = r0.k
            int r5 = r5 + r4
            r0.k = r5
            float r5 = r0.f9696pf
            float r6 = r7.getSpacingAfter()
            float r5 = r5 - r6
            r0.f9696pf = r5
        L_0x03fa:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x018b
            return r10
        L_0x03ff:
            int r7 = r6.type()
            r8 = 23
            if (r7 != r8) goto L_0x07ca
            fe.when.ad.f.d1 r6 = (fe.when.ad.f.d1) r6
            int r7 = r6.K()
            int r8 = r6.nn()
            if (r7 > r8) goto L_0x041c
            java.util.LinkedList<com.itextpdf.text.Element> r6 = r0.j
            r6.removeFirst()
        L_0x0418:
            r16 = r5
            goto L_0x054e
        L_0x041c:
            float r7 = r0.f9696pf
            float r8 = r0.f
            float r7 = r7 + r8
            int r8 = r0.l
            if (r8 != 0) goto L_0x042e
            boolean r8 = r0.r
            if (r8 == 0) goto L_0x042e
            float r8 = r6.N()
            float r7 = r7 - r8
        L_0x042e:
            r22 = r7
            float r7 = r0.f9693fe
            int r7 = (r22 > r7 ? 1 : (r22 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x07c8
            float r7 = r0.f9692de
            int r7 = (r22 > r7 ? 1 : (r22 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x043e
            goto L_0x07c8
        L_0x043e:
            float r7 = r0.f9697rg
            r0.f449switch = r2
            boolean r8 = r6.m()
            if (r8 == 0) goto L_0x0450
            float r8 = r6.f()
            r0.x(r8)
            goto L_0x045e
        L_0x0450:
            float r8 = r0.qqq
            float r9 = r6.g()
            float r8 = r8 * r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 / r9
            r6.H(r8)
        L_0x045e:
            r6.t()
            int r9 = r6.nn()
            int r12 = r6.vvv()
            int r13 = r9 - r12
            float r14 = r6.ddd()
            float r15 = r6.ggg()
            boolean r16 = r6.p()
            if (r16 == 0) goto L_0x0489
            int r2 = r0.l
            if (r2 > r13) goto L_0x0489
            boolean r2 = r6.isComplete()
            if (r2 != 0) goto L_0x0487
            int r2 = r0.l
            if (r2 == r13) goto L_0x0489
        L_0x0487:
            r2 = 1
            goto L_0x048a
        L_0x0489:
            r2 = 0
        L_0x048a:
            if (r2 != 0) goto L_0x049b
            float r14 = r22 - r14
            float r11 = r0.f9693fe
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 < 0) goto L_0x049a
            float r11 = r0.f9692de
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x049d
        L_0x049a:
            return r10
        L_0x049b:
            r14 = r22
        L_0x049d:
            int r11 = r0.l
            if (r11 >= r9) goto L_0x04a3
            r0.l = r9
        L_0x04a3:
            boolean r11 = r6.isComplete()
            if (r11 != 0) goto L_0x04aa
            float r14 = r14 - r15
        L_0x04aa:
            float r11 = r0.f9693fe
            float r11 = r14 - r11
            int r10 = r0.l
            fe.when.ad.f.d1$ad r10 = r6.when(r11, r10)
            int r11 = r10.qw
            int r11 = r11 + r4
            float r4 = r10.f9398ad
            float r14 = r14 - r4
            com.itextpdf.text.log.Logger r4 = r0.qw
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r16 = r5
            java.lang.String r5 = "Want to split at row "
            r3.append(r5)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r4.fe(r3)
            r3 = r11
        L_0x04d3:
            int r4 = r0.l
            if (r3 <= r4) goto L_0x04ea
            int r4 = r6.K()
            if (r3 >= r4) goto L_0x04ea
            fe.when.ad.f.c1 r4 = r6.eee(r3)
            boolean r4 = r4.o()
            if (r4 == 0) goto L_0x04ea
            int r3 = r3 + -1
            goto L_0x04d3
        L_0x04ea:
            int r4 = r0.l
            if (r3 <= r4) goto L_0x04f3
            if (r3 < r11) goto L_0x04f1
            goto L_0x04f3
        L_0x04f1:
            r4 = 0
            goto L_0x0506
        L_0x04f3:
            if (r3 != 0) goto L_0x050c
            r4 = 0
            fe.when.ad.f.c1 r5 = r6.eee(r4)
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x050c
            boolean r5 = r6.n()
            if (r5 == 0) goto L_0x050c
        L_0x0506:
            float r14 = r0.f9693fe
            r6.C(r4)
            r11 = r3
        L_0x050c:
            com.itextpdf.text.log.Logger r3 = r0.qw
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Will split at row "
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            r3.fe(r4)
            boolean r3 = r6.r()
            if (r3 == 0) goto L_0x052f
            if (r11 <= 0) goto L_0x052f
            int r3 = r11 + -1
            r10.qw(r6, r3)
        L_0x052f:
            boolean r3 = r6.isComplete()
            if (r3 != 0) goto L_0x0536
            float r14 = r14 + r15
        L_0x0536:
            boolean r3 = r6.s()
            if (r3 != 0) goto L_0x055e
            r3 = -1
            r0.m = r3
            int r3 = r0.l
            if (r11 != r3) goto L_0x05da
            int r2 = r6.K()
            if (r11 != r2) goto L_0x0555
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.j
            r2.removeFirst()
        L_0x054e:
            r5 = r16
        L_0x0550:
            r2 = 0
            r3 = 0
            r4 = 1
            goto L_0x0016
        L_0x0555:
            java.util.ArrayList r1 = r6.a()
            r1.remove(r11)
        L_0x055c:
            r1 = 2
            return r1
        L_0x055e:
            boolean r3 = r6.r()
            if (r3 == 0) goto L_0x056c
            int r3 = r0.l
            if (r3 >= r11) goto L_0x056c
            r3 = -1
            r0.m = r3
            goto L_0x05da
        L_0x056c:
            int r3 = r6.K()
            if (r11 >= r3) goto L_0x05da
            float r3 = r10.f9399de
            float r4 = r10.f9398ad
            float r3 = r3 - r4
            float r14 = r14 - r3
            float r3 = r0.f9693fe
            float r3 = r14 - r3
            fe.when.ad.f.c1 r4 = r6.eee(r11)
            fe.when.ad.f.c1 r3 = r4.nn(r6, r11, r3)
            if (r3 != 0) goto L_0x0596
            com.itextpdf.text.log.Logger r3 = r0.qw
            java.lang.String r4 = "Didn't split row!"
            r3.fe(r4)
            r3 = -1
            r0.m = r3
            int r3 = r0.l
            if (r3 != r11) goto L_0x05da
            r3 = 2
            return r3
        L_0x0596:
            int r4 = r0.m
            if (r11 == r4) goto L_0x05b9
            int r4 = r11 + 1
            r0.m = r4
            fe.when.ad.f.d1 r4 = new fe.when.ad.f.d1
            r4.<init>((fe.when.ad.f.d1) r6)
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.j
            r6 = 0
            r5.set(r6, r4)
            java.util.ArrayList r5 = r4.a()
        L_0x05ad:
            int r6 = r0.l
            if (r9 >= r6) goto L_0x05b8
            r6 = 0
            r5.set(r9, r6)
            int r9 = r9 + 1
            goto L_0x05ad
        L_0x05b8:
            r6 = r4
        L_0x05b9:
            float r14 = r0.f9693fe
            java.util.ArrayList r4 = r6.a()
            int r11 = r11 + 1
            r4.add(r11, r3)
            com.itextpdf.text.log.Logger r3 = r0.qw
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Inserting row at position "
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            r3.fe(r4)
        L_0x05da:
            if (r1 != 0) goto L_0x0745
            int r3 = r6.mmm()
            if (r3 == 0) goto L_0x05f0
            r4 = 2
            if (r3 == r4) goto L_0x05ec
            float r3 = r0.qqq
            float r3 = r3 - r8
            r4 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r4
            goto L_0x05ef
        L_0x05ec:
            float r3 = r0.qqq
            float r3 = r3 - r8
        L_0x05ef:
            float r7 = r7 + r3
        L_0x05f0:
            r21 = r7
            fe.when.ad.f.d1 r3 = fe.when.ad.f.d1.J(r6)
            java.util.ArrayList r4 = r3.a()
            if (r2 != 0) goto L_0x0615
            if (r13 <= 0) goto L_0x0615
            r5 = 0
            java.util.ArrayList r7 = r6.b(r5, r13)
            fe.when.ad.f.q r5 = r0.ggg
            boolean r5 = aaa(r5)
            if (r5 == 0) goto L_0x0611
            fe.when.ad.f.g1 r5 = r3.xxx()
            r5.f9435th = r7
        L_0x0611:
            r4.addAll(r7)
            goto L_0x0618
        L_0x0615:
            r3.x(r12)
        L_0x0618:
            int r5 = r0.l
            java.util.ArrayList r5 = r6.b(r5, r11)
            fe.when.ad.f.q r7 = r0.ggg
            boolean r7 = aaa(r7)
            if (r7 == 0) goto L_0x062c
            fe.when.ad.f.e1 r7 = r3.pf()
            r7.f9435th = r5
        L_0x062c:
            r4.addAll(r5)
            boolean r5 = r6.q()
            r7 = 1
            r5 = r5 ^ r7
            int r8 = r6.K()
            if (r11 >= r8) goto L_0x0641
            r3.w(r7)
            r5 = 1
            r7 = 1
            goto L_0x0643
        L_0x0641:
            r7 = r5
            r5 = 0
        L_0x0643:
            if (r12 <= 0) goto L_0x0665
            boolean r8 = r3.isComplete()
            if (r8 == 0) goto L_0x0665
            if (r7 == 0) goto L_0x0665
            int r7 = r13 + r12
            java.util.ArrayList r7 = r6.b(r13, r7)
            fe.when.ad.f.q r8 = r0.ggg
            boolean r8 = aaa(r8)
            if (r8 == 0) goto L_0x0661
            fe.when.ad.f.f1 r8 = r3.ppp()
            r8.f9435th = r7
        L_0x0661:
            r4.addAll(r7)
            goto L_0x0666
        L_0x0665:
            r12 = 0
        L_0x0666:
            int r7 = r4.size()
            r8 = 1
            int r7 = r7 - r8
            int r7 = r7 - r12
            java.lang.Object r4 = r4.get(r7)
            fe.when.ad.f.c1 r4 = (fe.when.ad.f.c1) r4
            boolean r9 = r6.k(r5)
            if (r9 == 0) goto L_0x0688
            float r9 = r4.rg()
            float r10 = r0.f9693fe
            float r14 = r14 - r10
            float r14 = r14 + r9
            r4.xxx(r14)
            float r10 = r0.f9693fe
            r14 = r10
            goto L_0x0689
        L_0x0688:
            r9 = 0
        L_0x0689:
            if (r5 == 0) goto L_0x0698
            com.itextpdf.text.pdf.PdfPTableEvent r10 = r6.d()
            boolean r12 = r10 instanceof com.itextpdf.text.pdf.PdfPTableEventSplit
            if (r12 == 0) goto L_0x0698
            com.itextpdf.text.pdf.PdfPTableEventSplit r10 = (com.itextpdf.text.pdf.PdfPTableEventSplit) r10
            r10.ad(r6)
        L_0x0698:
            fe.when.ad.f.q[] r10 = r0.vvv
            if (r10 == 0) goto L_0x06d2
            r12 = 3
            r10 = r10[r12]
            boolean r10 = aaa(r10)
            if (r10 == 0) goto L_0x06ac
            fe.when.ad.f.q[] r10 = r0.vvv
            r10 = r10[r12]
            r10.K(r6)
        L_0x06ac:
            r17 = 0
            r18 = -1
            r19 = 0
            r20 = -1
            fe.when.ad.f.q[] r10 = r0.vvv
            r24 = 0
            r16 = r3
            r23 = r10
            r16.P(r17, r18, r19, r20, r21, r22, r23, r24)
            fe.when.ad.f.q[] r10 = r0.vvv
            r12 = 3
            r10 = r10[r12]
            boolean r10 = aaa(r10)
            if (r10 == 0) goto L_0x06ff
            fe.when.ad.f.q[] r10 = r0.vvv
            r10 = r10[r12]
            r10.eee(r6)
            goto L_0x06ff
        L_0x06d2:
            fe.when.ad.f.q r10 = r0.ggg
            boolean r10 = aaa(r10)
            if (r10 == 0) goto L_0x06df
            fe.when.ad.f.q r10 = r0.ggg
            r10.K(r6)
        L_0x06df:
            r17 = 0
            r18 = -1
            r19 = 0
            r20 = -1
            fe.when.ad.f.q r10 = r0.ggg
            r24 = 0
            r16 = r3
            r23 = r10
            r16.O(r17, r18, r19, r20, r21, r22, r23, r24)
            fe.when.ad.f.q r10 = r0.ggg
            boolean r10 = aaa(r10)
            if (r10 == 0) goto L_0x06ff
            fe.when.ad.f.q r10 = r0.ggg
            r10.eee(r6)
        L_0x06ff:
            int r10 = r0.m
            if (r10 != r11) goto L_0x0717
            int r10 = r6.K()
            if (r11 >= r10) goto L_0x0717
            java.util.ArrayList r10 = r6.a()
            java.lang.Object r10 = r10.get(r11)
            fe.when.ad.f.c1 r10 = (fe.when.ad.f.c1) r10
            r10.ad(r3, r7)
            goto L_0x0728
        L_0x0717:
            if (r11 <= 0) goto L_0x0728
            int r10 = r6.K()
            if (r11 >= r10) goto L_0x0728
            fe.when.ad.f.c1 r10 = r6.eee(r11)
            int r12 = r11 + -1
            r10.mmm(r6, r12, r3, r7)
        L_0x0728:
            boolean r3 = r6.k(r5)
            if (r3 == 0) goto L_0x0731
            r4.xxx(r9)
        L_0x0731:
            if (r5 == 0) goto L_0x0755
            com.itextpdf.text.pdf.PdfPTableEvent r3 = r6.d()
            boolean r4 = r3 instanceof com.itextpdf.text.pdf.PdfPTableEventAfterSplit
            if (r4 == 0) goto L_0x0755
            fe.when.ad.f.c1 r4 = r6.eee(r11)
            com.itextpdf.text.pdf.PdfPTableEventAfterSplit r3 = (com.itextpdf.text.pdf.PdfPTableEventAfterSplit) r3
            r3.qw(r6, r4, r11)
            goto L_0x0755
        L_0x0745:
            r8 = 1
            boolean r3 = r6.j()
            if (r3 == 0) goto L_0x0755
            float r3 = r0.f9693fe
            r4 = -830472192(0xffffffffce800000, float:-1.07374182E9)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0755
            r14 = r3
        L_0x0755:
            r0.f9696pf = r14
            r3 = 0
            r0.f = r3
            r0.f449switch = r3
            if (r2 != 0) goto L_0x0769
            boolean r2 = r6.isComplete()
            if (r2 != 0) goto L_0x0769
            float r2 = r0.f9696pf
            float r2 = r2 + r15
            r0.f9696pf = r2
        L_0x0769:
            int r2 = r6.K()
            if (r11 >= r2) goto L_0x0782
            float r2 = r6.rrr(r11)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0782
            boolean r2 = r6.h(r11)
            if (r2 == 0) goto L_0x077f
            goto L_0x0782
        L_0x077f:
            int r11 = r11 + 1
            goto L_0x0769
        L_0x0782:
            int r2 = r6.K()
            if (r11 < r2) goto L_0x07b0
            float r2 = r0.f9696pf
            float r3 = r6.M()
            float r2 = r2 - r3
            float r3 = r0.f9693fe
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0798
            r0.f9696pf = r3
            goto L_0x07a1
        L_0x0798:
            float r2 = r0.f9696pf
            float r3 = r6.M()
            float r2 = r2 - r3
            r0.f9696pf = r2
        L_0x07a1:
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.j
            r2.removeFirst()
            r2 = -1
            r0.m = r2
            r2 = 0
            r0.l = r2
            r3 = 0
            r5 = 0
            goto L_0x0550
        L_0x07b0:
            r2 = -1
            int r1 = r0.m
            if (r1 == r2) goto L_0x07c4
            java.util.ArrayList r1 = r6.a()
            int r2 = r0.l
        L_0x07bb:
            if (r2 >= r11) goto L_0x07c4
            r3 = 0
            r1.set(r2, r3)
            int r2 = r2 + 1
            goto L_0x07bb
        L_0x07c4:
            r0.l = r11
            goto L_0x055c
        L_0x07c8:
            r1 = 2
            return r1
        L_0x07ca:
            r16 = r5
            r3 = 0
            r8 = 1
            int r2 = r6.type()
            r4 = 55
            if (r2 != r4) goto L_0x07f2
            if (r1 != 0) goto L_0x07ea
            r9 = r6
            com.itextpdf.text.pdf.draw.DrawInterface r9 = (com.itextpdf.text.pdf.draw.DrawInterface) r9
            fe.when.ad.f.q r10 = r0.ggg
            float r11 = r0.f9697rg
            float r12 = r0.f9693fe
            float r13 = r0.f9698th
            float r14 = r0.f9692de
            float r15 = r0.f9696pf
            r9.qw(r10, r11, r12, r13, r14, r15)
        L_0x07ea:
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.j
            r2.removeFirst()
            r3 = 0
            goto L_0x054e
        L_0x07f2:
            int r2 = r6.type()
            r4 = 37
            if (r2 != r4) goto L_0x084d
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x07ff:
            r2.add(r6)
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.j
            r5.removeFirst()
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.j
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0819
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.j
            java.lang.Object r5 = r5.getFirst()
            com.itextpdf.text.Element r5 = (com.itextpdf.text.Element) r5
            r6 = r5
            goto L_0x081a
        L_0x0819:
            r6 = r3
        L_0x081a:
            if (r6 == 0) goto L_0x0822
            int r5 = r6.type()
            if (r5 == r4) goto L_0x07ff
        L_0x0822:
            fe.when.ad.f.ggg r3 = new fe.when.ad.f.ggg
            boolean r4 = r0.p
            r3.<init>(r2, r4)
            float r4 = r0.f9697rg
            float r5 = r0.f9693fe
            float r6 = r0.f9698th
            float r7 = r0.f9696pf
            r3.rg(r4, r5, r6, r7)
            fe.when.ad.f.q r4 = r0.ggg
            int r4 = r3.fe(r4, r1)
            float r3 = r3.de()
            r0.f9696pf = r3
            r3 = 0
            r0.f = r3
            r5 = r4 & 1
            if (r5 != 0) goto L_0x054e
            java.util.LinkedList<com.itextpdf.text.Element> r1 = r0.j
            r1.addAll(r2)
            return r4
        L_0x084d:
            r3 = 0
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.j
            r2.removeFirst()
            goto L_0x054e
        L_0x0855:
            com.itextpdf.text.DocumentException r1 = new com.itextpdf.text.DocumentException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "irregular.columns.are.not.supported.in.composite.mode"
            java.lang.String r2 = fe.when.ad.c.qw.ad(r3, r2)
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.pf.mmm(boolean):int");
    }

    public void n(float f2, float f3, float f4, float f5) {
        this.f9697rg = Math.min(f2, f4);
        this.f9692de = Math.max(f3, f5);
        this.f9693fe = Math.min(f3, f5);
        float max = Math.max(f2, f4);
        this.f9698th = max;
        this.f9696pf = this.f9692de;
        float f6 = max - this.f9697rg;
        this.qqq = f6;
        if (f6 < 0.0f) {
            this.qqq = 0.0f;
        }
        this.eee = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dc, code lost:
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017c, code lost:
        r0.f9695o.ppp();
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int nn(boolean r30, com.itextpdf.text.pdf.interfaces.IAccessibleElement r31) throws com.itextpdf.text.DocumentException {
        /*
            r29 = this;
            r0 = r29
            r1 = r31
            boolean r2 = r0.g
            if (r2 == 0) goto L_0x000d
            int r1 = r29.mmm(r30)
            return r1
        L_0x000d:
            fe.when.ad.f.q r2 = r0.ggg
            boolean r2 = aaa(r2)
            if (r2 == 0) goto L_0x0021
            boolean r2 = r1 instanceof com.itextpdf.text.ListItem
            if (r2 == 0) goto L_0x0021
            r2 = r1
            com.itextpdf.text.ListItem r2 = (com.itextpdf.text.ListItem) r2
            fe.when.ad.ggg r2 = r2.getListBody()
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            r29.de()
            fe.when.ad.f.de r4 = r0.f9695o
            r5 = 1
            if (r4 != 0) goto L_0x002b
            return r5
        L_0x002b:
            r4 = 0
            r0.f = r4
            r6 = 0
            r0.b = r6
            r0.f448if = r4
            float r7 = r0.rrr
            r8 = 2
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r4)
            r15[r5] = r9
            r9 = 2143289344(0x7fc00000, float:NaN)
            r0.c = r9
            int r9 = r0.f9691ad
            if (r9 == 0) goto L_0x004a
            r25 = r9
            goto L_0x004c
        L_0x004a:
            r25 = 1
        L_0x004c:
            fe.when.ad.f.q r9 = r0.ggg
            if (r9 == 0) goto L_0x006d
            fe.when.ad.f.y r10 = r9.B()
            fe.when.ad.f.q r11 = r0.ggg
            boolean r11 = aaa(r11)
            if (r11 != 0) goto L_0x0065
            fe.when.ad.f.q r11 = r0.ggg
            boolean r12 = r0.s
            fe.when.ad.f.q r11 = r11.t(r12)
            goto L_0x0067
        L_0x0065:
            fe.when.ad.f.q r11 = r0.ggg
        L_0x0067:
            r26 = r9
            r27 = r10
            r14 = r11
            goto L_0x0074
        L_0x006d:
            if (r30 == 0) goto L_0x02d1
            r14 = 0
            r26 = 0
            r27 = 0
        L_0x0074:
            r9 = 981668463(0x3a83126f, float:0.001)
            if (r30 != 0) goto L_0x008d
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0086
            fe.when.ad.f.c2 r7 = r14.C()
            float r7 = r7.Q()
            goto L_0x008d
        L_0x0086:
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 >= 0) goto L_0x008d
            r7 = 981668463(0x3a83126f, float:0.001)
        L_0x008d:
            boolean r9 = r0.eee
            if (r9 != 0) goto L_0x00b8
            fe.when.ad.f.de r9 = r0.f9695o
            java.util.ArrayList<fe.when.ad.f.n> r9 = r9.f9422uk
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x009a:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00af
            java.lang.Object r11 = r9.next()
            fe.when.ad.f.n r11 = (fe.when.ad.f.n) r11
            float r11 = r11.nn()
            float r10 = java.lang.Math.max(r10, r11)
            goto L_0x009a
        L_0x00af:
            float r9 = r0.when
            float r11 = r0.ppp
            float r10 = r10 * r11
            float r9 = r9 + r10
            r0.f449switch = r9
        L_0x00b8:
            r9 = 0
            r10 = 0
        L_0x00ba:
            boolean r11 = r0.tt
            if (r11 == 0) goto L_0x00c1
            float r11 = r0.ddd
            goto L_0x00c3
        L_0x00c1:
            float r11 = r0.nn
        L_0x00c3:
            boolean r12 = r0.eee
            r13 = 3
            if (r12 == 0) goto L_0x0183
            float r12 = r0.qqq
            float r4 = r0.mmm
            float r4 = r4 + r11
            int r4 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00df
            fe.when.ad.f.de r1 = r0.f9695o
            boolean r1 = r1.o()
            if (r1 == 0) goto L_0x00dc
            r5 = 3
            goto L_0x01ff
        L_0x00dc:
            r5 = 2
            goto L_0x01ff
        L_0x00df:
            fe.when.ad.f.de r4 = r0.f9695o
            boolean r4 = r4.o()
            if (r4 == 0) goto L_0x00e9
            goto L_0x01ff
        L_0x00e9:
            fe.when.ad.f.de r4 = r0.f9695o
            float r12 = r0.f9697rg
            float r13 = r0.qqq
            float r13 = r13 - r11
            float r3 = r0.mmm
            float r18 = r13 - r3
            int r3 = r0.f9700yj
            int r13 = r0.e
            float r8 = r0.f9693fe
            float r5 = r0.f9696pf
            float r6 = r0.f
            r16 = r4
            r17 = r12
            r19 = r3
            r20 = r25
            r21 = r13
            r22 = r8
            r23 = r5
            r24 = r6
            fe.when.ad.f.p0 r3 = r16.m1076switch(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r3 != 0) goto L_0x0116
            goto L_0x01a6
        L_0x0116:
            float r4 = r0.when
            float r5 = r0.ppp
            float[] r4 = r3.i(r4, r5)
            boolean r5 = r29.qqq()
            if (r5 == 0) goto L_0x0133
            float r5 = r0.c
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 == 0) goto L_0x0133
            float r4 = r3.fe()
            r0.f449switch = r4
            goto L_0x0142
        L_0x0133:
            r5 = 0
            r6 = r4[r5]
            r5 = 1
            r4 = r4[r5]
            float r5 = r0.f
            float r4 = r4 - r5
            float r4 = java.lang.Math.max(r6, r4)
            r0.f449switch = r4
        L_0x0142:
            float r4 = r0.f9696pf
            float r5 = r0.f9692de
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x017c
            float r5 = r0.f449switch
            float r6 = r4 - r5
            float r8 = r0.f9693fe
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0155
            goto L_0x017c
        L_0x0155:
            float r4 = r4 - r5
            r0.f9696pf = r4
            if (r30 != 0) goto L_0x0160
            if (r9 != 0) goto L_0x0160
            r14.vvv()
            r9 = 1
        L_0x0160:
            float r4 = r0.c
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x016c
            float r4 = r0.f9696pf
            r0.c = r4
        L_0x016c:
            float r4 = r0.qqq
            float r5 = r3.tt()
            float r4 = r4 - r5
            r0.x(r4)
            float r4 = r0.f9697rg
            r28 = r9
            goto L_0x020e
        L_0x017c:
            fe.when.ad.f.de r1 = r0.f9695o
            r1.ppp()
            goto L_0x00dc
        L_0x0183:
            float r3 = r0.f9696pf
            float r4 = r0.f449switch
            float r3 = r3 - r4
            float[] r4 = r29.yj()
            if (r4 != 0) goto L_0x019c
            fe.when.ad.f.de r1 = r0.f9695o
            boolean r1 = r1.o()
            if (r1 == 0) goto L_0x0198
            r5 = 3
            goto L_0x0199
        L_0x0198:
            r5 = 2
        L_0x0199:
            r0.f9696pf = r3
            goto L_0x01ff
        L_0x019c:
            fe.when.ad.f.de r5 = r0.f9695o
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x01a8
            r0.f9696pf = r3
        L_0x01a6:
            r5 = 1
            goto L_0x01ff
        L_0x01a8:
            r5 = 0
            r6 = r4[r5]
            r5 = 2
            r8 = r4[r5]
            float r6 = java.lang.Math.max(r6, r8)
            r8 = 1
            r12 = r4[r8]
            r4 = r4[r13]
            float r4 = java.lang.Math.min(r12, r4)
            float r4 = r4 - r6
            float r8 = r0.mmm
            float r8 = r8 + r11
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x01c9
        L_0x01c3:
            r4 = 0
            r5 = 1
            r6 = 0
            r8 = 2
            goto L_0x00ba
        L_0x01c9:
            if (r30 != 0) goto L_0x01d1
            if (r9 != 0) goto L_0x01d1
            r14.vvv()
            r9 = 1
        L_0x01d1:
            fe.when.ad.f.de r8 = r0.f9695o
            float r4 = r4 - r11
            float r12 = r0.mmm
            float r18 = r4 - r12
            int r4 = r0.f9700yj
            int r12 = r0.e
            float r13 = r0.f9693fe
            float r5 = r0.f9696pf
            r28 = r9
            float r9 = r0.f
            r16 = r8
            r17 = r6
            r19 = r4
            r20 = r25
            r21 = r12
            r22 = r13
            r23 = r5
            r24 = r9
            fe.when.ad.f.p0 r4 = r16.m1076switch(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r4 != 0) goto L_0x020c
            r0.f9696pf = r3
            r9 = r28
            goto L_0x01a6
        L_0x01ff:
            if (r9 == 0) goto L_0x020b
            r14.j()
            fe.when.ad.f.q r1 = r0.ggg
            if (r1 == r14) goto L_0x020b
            r1.de(r14)
        L_0x020b:
            return r5
        L_0x020c:
            r3 = r4
            r4 = r6
        L_0x020e:
            fe.when.ad.f.q r5 = r0.ggg
            boolean r5 = aaa(r5)
            if (r5 == 0) goto L_0x026a
            boolean r5 = r1 instanceof com.itextpdf.text.ListItem
            if (r5 == 0) goto L_0x026a
            float r5 = r0.c
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x026a
            boolean r5 = r0.d
            if (r5 != 0) goto L_0x026a
            if (r30 != 0) goto L_0x0265
            r5 = r1
            com.itextpdf.text.ListItem r5 = (com.itextpdf.text.ListItem) r5
            fe.when.ad.vvv r6 = r5.getListLabel()
            fe.when.ad.f.q r8 = r0.ggg
            r8.K(r6)
            fe.when.ad.fe r8 = new fe.when.ad.fe
            fe.when.ad.fe r5 = r5.getListSymbol()
            r8.<init>((fe.when.ad.fe) r5)
            r5 = 0
            r8.setRole(r5)
            fe.when.ad.f.q r9 = r0.ggg
            r17 = 0
            com.itextpdf.text.Phrase r12 = new com.itextpdf.text.Phrase
            r12.<init>((fe.when.ad.fe) r8)
            float r8 = r0.f9697rg
            float r13 = r6.qw()
            float r19 = r8 + r13
            float r8 = r0.c
            r21 = 0
            r16 = r9
            r18 = r12
            r20 = r8
            v(r16, r17, r18, r19, r20, r21)
            fe.when.ad.f.q r8 = r0.ggg
            r8.eee(r6)
            goto L_0x0266
        L_0x0265:
            r5 = 0
        L_0x0266:
            r6 = 1
            r0.d = r6
            goto L_0x026b
        L_0x026a:
            r5 = 0
        L_0x026b:
            if (r30 != 0) goto L_0x02a1
            if (r2 == 0) goto L_0x0275
            fe.when.ad.f.q r6 = r0.ggg
            r6.K(r2)
            r2 = r5
        L_0x0275:
            r6 = 0
            r15[r6] = r10
            boolean r6 = r3.ggg()
            if (r6 == 0) goto L_0x0280
            float r11 = r0.mmm
        L_0x0280:
            float r4 = r4 + r11
            float r6 = r3.when()
            float r4 = r4 + r6
            float r6 = r0.f9696pf
            r14.L0(r4, r6)
            r9 = r27
            r10 = r3
            r11 = r14
            r12 = r26
            r13 = r15
            r4 = r14
            r14 = r7
            float r6 = r9.H(r10, r11, r12, r13, r14)
            r0.f448if = r6
            r6 = 0
            r8 = r15[r6]
            r10 = r8
            fe.when.ad.f.d0 r10 = (fe.when.ad.f.d0) r10
            goto L_0x02a2
        L_0x02a1:
            r4 = r14
        L_0x02a2:
            boolean r6 = r0.a
            if (r6 == 0) goto L_0x02ae
            boolean r6 = r3.ppp()
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r0.tt = r6
            float r6 = r0.f9696pf
            boolean r8 = r3.ppp()
            if (r8 == 0) goto L_0x02bc
            float r8 = r0.aaa
            goto L_0x02bd
        L_0x02bc:
            r8 = 0
        L_0x02bd:
            float r6 = r6 - r8
            r0.f9696pf = r6
            int r6 = r0.b
            r8 = 1
            int r6 = r6 + r8
            r0.b = r6
            float r3 = r3.th()
            r0.f = r3
            r14 = r4
            r9 = r28
            goto L_0x01c3
        L_0x02d1:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null"
            java.lang.String r2 = fe.when.ad.c.qw.ad(r3, r2)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.pf.nn(boolean, com.itextpdf.text.pdf.interfaces.IAccessibleElement):int");
    }

    public List<Element> o() {
        return this.j;
    }

    public void p(float f2, float f3, float f4, float f5, float f6, int i2) {
        j(f6);
        this.f9700yj = i2;
        n(f2, f3, f4, f5);
    }

    public float pf() {
        return this.f;
    }

    public int ppp() {
        return this.b;
    }

    public void q(Phrase phrase, float f2, float f3, float f4, float f5, float f6, int i2) {
        ad(phrase);
        p(f2, f3, f4, f5, f6, i2);
    }

    public boolean qqq() {
        return this.p;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void qw(com.itextpdf.text.Paragraph r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r7 instanceof fe.when.ad.i
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0071
            fe.when.ad.i r7 = (fe.when.ad.i) r7
            fe.when.ad.f.d1 r0 = new fe.when.ad.f.d1
            r0.<init>((int) r2)
            float r3 = r7.Z()
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
            float r3 = r7.T()
            r0.H(r3)
            r0.B(r2)
            goto L_0x0027
        L_0x0024:
            r0.I(r3)
        L_0x0027:
            float r3 = r7.V()
            r0.E(r3)
            float r3 = r7.getSpacingBefore()
            r0.F(r3)
            int r3 = r7.s()
            if (r3 == 0) goto L_0x0046
            r5 = 2
            if (r3 == r5) goto L_0x0042
            r0.z(r2)
            goto L_0x0049
        L_0x0042:
            r0.z(r5)
            goto L_0x0049
        L_0x0046:
            r0.z(r1)
        L_0x0049:
            fe.when.ad.f.a1 r3 = new fe.when.ad.f.a1
            r3.<init>(r7, r2)
            r3.P(r4)
            int r4 = r7.de()
            r3.f(r4)
            fe.when.ad.de r4 = r7.fe()
            r3.g(r4)
            float r4 = r7.i()
            r3.h(r4)
            fe.when.ad.de r7 = r7.ad()
            r3.e(r7)
            r0.qw(r3)
            r7 = r0
        L_0x0071:
            int r0 = r7.type()
            r3 = 10
            if (r0 != r3) goto L_0x0082
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            fe.when.ad.fe r7 = (fe.when.ad.fe) r7
            r0.<init>((fe.when.ad.fe) r7)
        L_0x0080:
            r7 = r0
            goto L_0x0092
        L_0x0082:
            int r0 = r7.type()
            r3 = 11
            if (r0 != r3) goto L_0x0092
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Phrase r7 = (com.itextpdf.text.Phrase) r7
            r0.<init>((com.itextpdf.text.Phrase) r7)
            goto L_0x0080
        L_0x0092:
            int r0 = r7.type()
            r3 = 12
            if (r0 == r3) goto L_0x00c9
            int r0 = r7.type()
            r4 = 14
            if (r0 == r4) goto L_0x00c9
            int r0 = r7.type()
            r4 = 23
            if (r0 == r4) goto L_0x00c9
            int r0 = r7.type()
            r4 = 55
            if (r0 == r4) goto L_0x00c9
            int r0 = r7.type()
            r4 = 37
            if (r0 != r4) goto L_0x00bb
            goto L_0x00c9
        L_0x00bb:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "element.not.allowed"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r7.<init>(r0)
            throw r7
        L_0x00c9:
            boolean r0 = r6.g
            if (r0 != 0) goto L_0x00db
            r6.g = r2
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r6.j = r0
            r0 = 0
            r6.f9695o = r0
            r6.n = r0
        L_0x00db:
            int r0 = r7.type()
            if (r0 != r3) goto L_0x00ed
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.j
            java.util.List r7 = r7.breakUp()
            r0.addAll(r7)
            return
        L_0x00ed:
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.j
            r0.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.pf.qw(com.itextpdf.text.Element):void");
    }

    public void r(pf pfVar) {
        this.f9692de = pfVar.f9692de;
        this.f9693fe = pfVar.f9693fe;
        this.f9700yj = pfVar.f9700yj;
        this.f9699uk = null;
        if (pfVar.f9699uk != null) {
            this.f9699uk = new ArrayList<>(pfVar.f9699uk);
        }
        this.f9694i = null;
        if (pfVar.f9694i != null) {
            this.f9694i = new ArrayList<>(pfVar.f9694i);
        }
        this.f9696pf = pfVar.f9696pf;
        this.f449switch = pfVar.f449switch;
        this.when = pfVar.when;
        this.ppp = pfVar.ppp;
        this.ggg = pfVar.ggg;
        this.vvv = pfVar.vvv;
        this.xxx = pfVar.xxx;
        this.ddd = pfVar.ddd;
        this.nn = pfVar.nn;
        this.mmm = pfVar.mmm;
        this.aaa = pfVar.aaa;
        this.qqq = pfVar.qqq;
        this.eee = pfVar.eee;
        this.rrr = pfVar.rrr;
        this.tt = pfVar.tt;
        this.a = pfVar.a;
        this.b = pfVar.b;
        this.e = pfVar.e;
        this.f9691ad = pfVar.f9691ad;
        this.f = pfVar.f;
        this.g = pfVar.g;
        this.m = pfVar.m;
        if (pfVar.g) {
            this.j = new LinkedList<>();
            Iterator it = pfVar.j.iterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                if (element instanceof d1) {
                    this.j.add(new d1((d1) element));
                } else {
                    this.j.add(element);
                }
            }
            pf pfVar2 = pfVar.h;
            if (pfVar2 != null) {
                this.h = fe(pfVar2);
            }
        }
        this.k = pfVar.k;
        this.l = pfVar.l;
        this.c = pfVar.c;
        this.f9697rg = pfVar.f9697rg;
        this.f9698th = pfVar.f9698th;
        this.d = pfVar.d;
        this.n = pfVar.n;
        this.p = pfVar.p;
        this.q = pfVar.q;
        this.r = pfVar.r;
        this.s = pfVar.s;
    }

    public float[] rg() {
        float th2 = th(this.f9699uk);
        int i2 = this.xxx;
        if (i2 == 1 || i2 == 2) {
            return null;
        }
        float th3 = th(this.f9694i);
        if (this.xxx == 2) {
            return null;
        }
        return new float[]{th2, th3};
    }

    public void rrr(boolean z) {
        this.r = z;
    }

    public void s(float f2) {
        this.rrr = f2;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1112switch() {
        return this.ddd;
    }

    public void t(Phrase phrase) {
        this.f9695o = null;
        this.g = false;
        this.h = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = -1;
        this.n = phrase;
    }

    public float th(ArrayList<float[]> arrayList) {
        this.xxx = 0;
        float f2 = this.f9696pf;
        if (f2 < this.f9693fe || f2 > this.f9692de) {
            this.xxx = 1;
            return 0.0f;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float[] fArr = arrayList.get(i2);
            float f3 = this.f9696pf;
            if (f3 >= fArr[0] && f3 <= fArr[1]) {
                return (fArr[2] * f3) + fArr[3];
            }
        }
        this.xxx = 2;
        return 0.0f;
    }

    public void tt(int i2) {
        this.f9700yj = i2;
    }

    public void u(boolean z) {
        this.p = z;
    }

    public int uk() {
        return this.f9700yj;
    }

    public float vvv() {
        return this.f9696pf;
    }

    public float when() {
        return this.f448if;
    }

    public void x(float f2) {
        if (f2 > this.q) {
            this.q = f2;
        }
    }

    public int xxx() throws DocumentException {
        return ddd(false);
    }

    public boolean y() {
        return this.g && !this.j.isEmpty() && this.j.getFirst().type() == 55;
    }

    public float[] yj() {
        boolean z = false;
        while (true) {
            if (z && this.f449switch == 0.0f) {
                return null;
            }
            float[] rg2 = rg();
            int i2 = this.xxx;
            if (i2 == 1) {
                return null;
            }
            this.f9696pf -= this.f449switch;
            if (i2 != 2) {
                float[] rg3 = rg();
                int i3 = this.xxx;
                if (i3 == 1) {
                    return null;
                }
                if (i3 == 2) {
                    this.f9696pf -= this.f449switch;
                } else if (rg2[0] < rg3[1] && rg3[0] < rg2[1]) {
                    return new float[]{rg2[0], rg2[1], rg3[0], rg3[1]};
                }
            }
            z = true;
        }
    }
}
