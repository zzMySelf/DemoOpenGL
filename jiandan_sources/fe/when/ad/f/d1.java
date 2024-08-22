package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.LargeElement;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfArtifact;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.fe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d1 implements LargeElement, Spaceable, IAccessibleElement {
    public boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final Logger f9391ad;
    public boolean ddd;
    public boolean e;
    public float eee;
    public boolean f;
    public boolean g;
    public float ggg;
    public boolean h;

    /* renamed from: i  reason: collision with root package name */
    public int f9392i;

    /* renamed from: if  reason: not valid java name */
    public float[] f409if;
    public int j;
    public boolean k;
    public boolean l;
    public s0 m;
    public int mmm;
    public HashMap<s0, y0> n;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public a1 f9393o;
    public fe.when.ad.qw p;

    /* renamed from: pf  reason: collision with root package name */
    public float f9394pf;
    public int ppp;
    public g1 q;
    public boolean qqq;
    public e1 r;
    public float rrr;
    public f1 s;

    /* renamed from: switch  reason: not valid java name */
    public float[] f410switch;

    /* renamed from: th  reason: collision with root package name */
    public ArrayList<c1> f9395th;
    public boolean[] tt;

    /* renamed from: uk  reason: collision with root package name */
    public a1[] f9396uk;
    public int vvv;
    public PdfPTableEvent when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public float f9397yj;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final float f9398ad;

        /* renamed from: de  reason: collision with root package name */
        public final float f9399de;

        /* renamed from: fe  reason: collision with root package name */
        public final Map<Integer, Float> f9400fe;
        public final int qw;

        public ad(int i2, int i3, float f, float f2, Map<Integer, Float> map) {
            this.qw = i3;
            this.f9398ad = f;
            this.f9399de = f2;
            this.f9400fe = map;
        }

        public void qw(d1 d1Var, int i2) {
            c1 eee = d1Var.eee(i2);
            Float f = this.f9400fe.get(Integer.valueOf(i2));
            if (f != null) {
                eee.vvv(f.floatValue());
            }
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f9401ad = 1;

        /* renamed from: de  reason: collision with root package name */
        public int f9402de = 1;
        public float qw = 0.0f;

        public boolean ad() {
            return this.f9401ad == 1;
        }

        public void de(float f, float f2) {
            this.f9401ad--;
        }

        public void qw(a1 a1Var, float f, float f2) {
            this.f9401ad = a1Var.D();
            this.f9402de = a1Var.r();
            this.qw = f + Math.max(a1Var.B(), f2);
        }
    }

    public d1() {
        this.f9391ad = fe.when.ad.e.ad.qw(d1.class);
        this.f9395th = new ArrayList<>();
        this.f9397yj = 0.0f;
        this.f9392i = 0;
        this.f9393o = new a1((Phrase) null);
        this.f9394pf = 0.0f;
        this.ggg = 80.0f;
        this.vvv = 1;
        this.xxx = false;
        this.ddd = false;
        this.nn = false;
        this.mmm = 0;
        this.aaa = false;
        this.qqq = true;
        this.tt = new boolean[]{false, false};
        this.f = true;
        this.h = true;
        this.k = true;
        this.l = true;
        this.m = s0.f5;
        this.n = null;
        this.p = new fe.when.ad.qw();
        this.q = null;
        this.r = null;
        this.s = null;
    }

    public static d1 J(d1 d1Var) {
        d1 d1Var2 = new d1();
        d1Var2.uk(d1Var);
        return d1Var2;
    }

    public static q[] de(q qVar) {
        return new q[]{qVar, qVar.s(), qVar.s(), qVar.s()};
    }

    public static void o(q[] qVarArr) {
        q qVar = qVarArr[0];
        PdfArtifact pdfArtifact = new PdfArtifact();
        qVar.K(pdfArtifact);
        qVar.d0();
        qVar.de(qVarArr[1]);
        qVar.Y();
        qVar.d0();
        qVar.s0(2);
        qVar.U();
        qVar.de(qVarArr[2]);
        qVar.Y();
        qVar.eee(pdfArtifact);
        qVar.de(qVarArr[3]);
    }

    public void A(boolean z) {
        this.g = z;
    }

    public void B(boolean z) {
        this.aaa = z;
    }

    public void C(boolean z) {
        this.k = z;
    }

    public void D(boolean z) {
        this.xxx = z;
    }

    public void E(float f2) {
        this.rrr = f2;
    }

    public void F(float f2) {
        this.eee = f2;
    }

    public void G(boolean z) {
        this.f = z;
    }

    public void H(float f2) {
        if (this.f9394pf != f2) {
            this.f9394pf = f2;
            this.f9397yj = 0.0f;
            rg();
            fe();
        }
    }

    public void I(float f2) {
        this.ggg = f2;
    }

    public int K() {
        return this.f9395th.size();
    }

    public final void L() {
        int i2 = this.mmm == 3 ? -1 : 1;
        while (v(this.f9395th.size(), this.f9392i)) {
            this.f9392i += i2;
        }
    }

    public float M() {
        return this.rrr;
    }

    public float N() {
        return this.eee;
    }

    public float O(int i2, int i3, int i4, int i5, float f2, float f3, q qVar, boolean z) {
        int i6;
        int i7;
        int i8 = i2;
        int i9 = i3;
        int qqq2 = qqq();
        boolean z2 = false;
        if (i8 < 0) {
            i6 = 0;
        } else {
            i6 = Math.min(i8, qqq2);
        }
        if (i9 < 0) {
            i7 = qqq2;
        } else {
            i7 = Math.min(i9, qqq2);
        }
        if (!(i6 == 0 && i7 == qqq2)) {
            z2 = true;
        }
        if (z2) {
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (int i10 = i6; i10 < i7; i10++) {
                f5 += this.f410switch[i10];
            }
            qVar.d0();
            float f6 = i6 == 0 ? 10000.0f : 0.0f;
            if (i7 == qqq2) {
                f4 = 10000.0f;
            }
            qVar.N(f2 - f6, -10000.0f, f5 + f6 + f4, 20000.0f);
            qVar.qqq();
            qVar.J();
        } else {
            q qVar2 = qVar;
        }
        q[] de2 = de(qVar);
        float P = P(i6, i7, i4, i5, f2, f3, de2, z);
        o(de2);
        if (z2) {
            qVar.Y();
        }
        return P;
    }

    public float P(int i2, int i3, int i4, int i5, float f2, float f3, q[] qVarArr, boolean z) {
        int i6;
        int i7;
        c1 c1Var;
        ArrayList<c1> arrayList;
        int i8;
        c1 c1Var2;
        int i9 = i2;
        int i10 = i3;
        int i11 = i5;
        if (this.f9394pf > 0.0f) {
            int size = this.f9395th.size();
            int i12 = i4 < 0 ? 0 : i4;
            if (i11 >= 0) {
                size = Math.min(i11, size);
            }
            int i13 = size;
            if (i12 >= i13) {
                return f3;
            }
            int qqq2 = qqq();
            if (i9 < 0) {
                i6 = 0;
            } else {
                i6 = Math.min(i9, qqq2);
            }
            if (i10 < 0) {
                i7 = qqq2;
            } else {
                i7 = Math.min(i10, qqq2);
            }
            this.f9391ad.fe(String.format("Writing row %s to %s; column %s to %s", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i6), Integer.valueOf(i7)}));
            e1 e1Var = null;
            if (this.l) {
                when(Float.MAX_VALUE, i12);
            }
            ArrayList<c1> b = b(i12, i13);
            float f4 = f3;
            int i14 = i12;
            for (c1 next : b) {
                if (xxx().f9435th != null && xxx().f9435th.contains(next) && e1Var == null) {
                    e1Var = u(xxx(), qVarArr[3]);
                } else if (pf().f9435th != null && pf().f9435th.contains(next) && e1Var == null) {
                    e1Var = u(pf(), qVarArr[3]);
                } else if (ppp().f9435th != null && ppp().f9435th.contains(next) && e1Var == null) {
                    e1Var = u(ppp(), qVarArr[3]);
                }
                e1 e1Var2 = e1Var;
                if (next != null) {
                    c1Var = next;
                    i8 = i14;
                    arrayList = b;
                    next.qqq(i6, i7, f2, f4, qVarArr, z);
                    f4 -= c1Var.rg();
                } else {
                    c1Var = next;
                    i8 = i14;
                    arrayList = b;
                }
                if (xxx().f9435th != null) {
                    c1Var2 = c1Var;
                    if (xxx().f9435th.contains(c1Var2) && (i8 == i13 - 1 || !xxx().f9435th.contains(arrayList.get(i8 + 1)))) {
                        e1Var = yj(xxx(), qVarArr[3]);
                        i14 = i8 + 1;
                        b = arrayList;
                    }
                } else {
                    c1Var2 = c1Var;
                }
                if (pf().f9435th != null && pf().f9435th.contains(c1Var2) && (i8 == i13 - 1 || !pf().f9435th.contains(arrayList.get(i8 + 1)))) {
                    e1Var = yj(pf(), qVarArr[3]);
                    i14 = i8 + 1;
                    b = arrayList;
                } else if (ppp().f9435th == null || !ppp().f9435th.contains(c1Var2) || (i8 != i13 - 1 && ppp().f9435th.contains(arrayList.get(i8 + 1)))) {
                    e1Var = e1Var2;
                    i14 = i8 + 1;
                    b = arrayList;
                } else {
                    e1Var = yj(ppp(), qVarArr[3]);
                    i14 = i8 + 1;
                    b = arrayList;
                }
            }
            ArrayList<c1> arrayList2 = b;
            if (this.when != null && i6 == 0 && i7 == qqq2) {
                float[] fArr = new float[((i13 - i12) + 1)];
                fArr[0] = f3;
                for (int i15 = i12; i15 < i13; i15++) {
                    c1 c1Var3 = arrayList2.get(i15);
                    int i16 = i15 - i12;
                    fArr[i16 + 1] = fArr[i16] - (c1Var3 != null ? c1Var3.rg() : 0.0f);
                }
                this.when.de(this, m1074switch(f2, i12, i13, this.e), fArr, this.e ? this.ppp : 0, i12, qVarArr);
            }
            return f4;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("the.table.width.must.be.greater.than.zero", new Object[0]));
    }

    public ArrayList<c1> a() {
        return this.f9395th;
    }

    public boolean aaa() {
        return this.g;
    }

    public c1 ad(int i2, int i3) {
        c1 eee2 = eee(i2);
        if (eee2.i()) {
            return eee2;
        }
        c1 c1Var = new c1(eee2);
        a1[] de2 = c1Var.de();
        for (int i4 = 0; i4 < de2.length; i4++) {
            a1 a1Var = de2[i4];
            if (!(a1Var == null || a1Var.D() == 1)) {
                int min = Math.min(i3, a1Var.D() + i2);
                float f2 = 0.0f;
                for (int i5 = 1 + i2; i5 < min; i5++) {
                    f2 += eee(i5).rg();
                }
                c1Var.ggg(i4, f2);
            }
        }
        c1Var.when(true);
        return c1Var;
    }

    public ArrayList<c1> b(int i2, int i3) {
        ArrayList<c1> arrayList = new ArrayList<>();
        if (i2 >= 0 && i3 <= K()) {
            while (i2 < i3) {
                arrayList.add(ad(i2, i3));
                i2++;
            }
        }
        return arrayList;
    }

    public float c() {
        return this.rrr;
    }

    public PdfPTableEvent d() {
        return this.when;
    }

    public float ddd() {
        int min = Math.min(this.f9395th.size(), this.ppp);
        float f2 = 0.0f;
        for (int i2 = 0; i2 < min; i2++) {
            c1 c1Var = this.f9395th.get(i2);
            if (c1Var != null) {
                f2 += c1Var.rg();
            }
        }
        return f2;
    }

    public float e() {
        return this.f9397yj;
    }

    public c1 eee(int i2) {
        return this.f9395th.get(i2);
    }

    public float f() {
        return this.f9394pf;
    }

    public float fe() {
        if (this.f9394pf <= 0.0f) {
            return 0.0f;
        }
        this.f9397yj = 0.0f;
        for (int i2 = 0; i2 < this.f9395th.size(); i2++) {
            this.f9397yj += tt(i2, true);
        }
        return this.f9397yj;
    }

    public void flushContent() {
        i();
        D(true);
    }

    public float g() {
        return this.ggg;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.n;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.n;
    }

    public List<fe> getChunks() {
        return new ArrayList();
    }

    public fe.when.ad.qw getId() {
        return this.p;
    }

    public s0 getRole() {
        return this.m;
    }

    public float getSpacingBefore() {
        return this.eee;
    }

    public float ggg() {
        int min = Math.min(this.f9395th.size(), this.ppp);
        float f2 = 0.0f;
        for (int max = Math.max(0, this.ppp - this.j); max < min; max++) {
            c1 c1Var = this.f9395th.get(max);
            if (c1Var != null) {
                f2 += c1Var.rg();
            }
        }
        return f2;
    }

    public boolean h(int i2) {
        if (i2 < this.f9395th.size() && eee(i2).yj()) {
            return true;
        }
        c1 eee2 = i2 > 0 ? eee(i2 - 1) : null;
        if (eee2 != null && eee2.yj()) {
            return true;
        }
        for (int i3 = 0; i3 < qqq(); i3++) {
            if (v(i2 - 1, i3)) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<c1> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.ppp; i2++) {
            arrayList.add(this.f9395th.get(i2));
        }
        this.f9395th = arrayList;
        this.f9397yj = 0.0f;
        if (this.f9394pf > 0.0f) {
            this.f9397yj = ddd();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public int m1073if(int i2, int i3) {
        while (eee(i2).de()[i3] == null && i2 > 0) {
            i2--;
        }
        return i2;
    }

    public boolean isComplete() {
        return this.h;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean j() {
        return this.tt[0];
    }

    public boolean k(boolean z) {
        if (z) {
            return this.tt[0];
        }
        return this.tt[1];
    }

    public boolean l() {
        return this.e;
    }

    public boolean m() {
        return this.aaa;
    }

    public int mmm() {
        return this.vvv;
    }

    public boolean n() {
        return this.k;
    }

    public int nn() {
        return this.ppp;
    }

    public boolean p() {
        return this.xxx;
    }

    public e1 pf() {
        if (this.r == null) {
            this.r = new e1();
        }
        return this.r;
    }

    public f1 ppp() {
        if (this.s == null) {
            this.s = new f1();
        }
        return this.s;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public boolean q() {
        return this.ddd;
    }

    public int qqq() {
        return this.f409if.length;
    }

    public a1 qw(a1 a1Var) {
        a1 a1Var2;
        boolean z;
        int i2;
        a1[] a1VarArr;
        if (a1Var instanceof b1) {
            a1Var2 = new b1((b1) a1Var);
        } else {
            a1Var2 = new a1(a1Var);
        }
        int min = Math.min(Math.max(a1Var2.r(), 1), this.f9396uk.length - this.f9392i);
        a1Var2.L(min);
        if (min != 1) {
            this.nn = true;
        }
        if (a1Var2.E() == 0) {
            a1Var2.S(this.mmm);
        }
        L();
        int i3 = this.f9392i;
        a1[] a1VarArr2 = this.f9396uk;
        if (i3 < a1VarArr2.length) {
            a1VarArr2[i3] = a1Var2;
            this.f9392i = i3 + min;
            z = true;
        } else {
            z = false;
        }
        L();
        while (true) {
            i2 = this.f9392i;
            a1VarArr = this.f9396uk;
            if (i2 < a1VarArr.length) {
                break;
            }
            int qqq2 = qqq();
            if (this.mmm == 3) {
                a1[] a1VarArr3 = new a1[qqq2];
                int length = this.f9396uk.length;
                int i4 = 0;
                while (true) {
                    a1[] a1VarArr4 = this.f9396uk;
                    if (i4 >= a1VarArr4.length) {
                        break;
                    }
                    a1 a1Var3 = a1VarArr4[i4];
                    int r2 = a1Var3.r();
                    length -= r2;
                    a1VarArr3[length] = a1Var3;
                    i4 = i4 + (r2 - 1) + 1;
                }
                this.f9396uk = a1VarArr3;
            }
            c1 c1Var = new c1(this.f9396uk);
            if (this.f9394pf > 0.0f) {
                c1Var.ddd(this.f410switch);
                this.f9397yj += c1Var.rg();
            }
            this.f9395th.add(c1Var);
            this.f9396uk = new a1[qqq2];
            this.f9392i = 0;
            L();
        }
        if (!z) {
            a1VarArr[i2] = a1Var2;
            this.f9392i = i2 + min;
        }
        return a1Var2;
    }

    public boolean r() {
        return this.f;
    }

    public void rg() {
        float f2 = 0.0f;
        if (this.f9394pf > 0.0f) {
            int qqq2 = qqq();
            for (int i2 = 0; i2 < qqq2; i2++) {
                f2 += this.f409if[i2];
            }
            for (int i3 = 0; i3 < qqq2; i3++) {
                this.f410switch[i3] = (this.f9394pf * this.f409if[i3]) / f2;
            }
        }
    }

    public float rrr(int i2) {
        return tt(i2, false);
    }

    public boolean s() {
        return this.qqq;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.n == null) {
            this.n = new HashMap<>();
        }
        this.n.put(s0Var, y0Var);
    }

    public void setId(fe.when.ad.qw qwVar) {
        this.p = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.m = s0Var;
    }

    /* renamed from: switch  reason: not valid java name */
    public float[][] m1074switch(float f2, int i2, int i3, boolean z) {
        int i4;
        if (z) {
            i2 = Math.max(i2, this.ppp);
            i3 = Math.max(i3, this.ppp);
        }
        int i5 = 0;
        int i6 = ((z ? this.ppp : 0) + i3) - i2;
        float[][] fArr = new float[i6][];
        if (this.nn) {
            if (z) {
                int i7 = 0;
                while (i5 < this.ppp) {
                    c1 c1Var = this.f9395th.get(i5);
                    if (c1Var == null) {
                        i7++;
                    } else {
                        fArr[i7] = c1Var.fe(f2, this.f410switch);
                        i7++;
                    }
                    i5++;
                }
                i5 = i7;
            }
            while (i2 < i3) {
                c1 c1Var2 = this.f9395th.get(i2);
                if (c1Var2 == null) {
                    i4++;
                } else {
                    fArr[i4] = c1Var2.fe(f2, this.f410switch);
                    i4++;
                }
                i2++;
            }
        } else {
            int qqq2 = qqq();
            float[] fArr2 = new float[(qqq2 + 1)];
            fArr2[0] = f2;
            int i8 = 0;
            while (i8 < qqq2) {
                int i9 = i8 + 1;
                fArr2[i9] = fArr2[i8] + this.f410switch[i8];
                i8 = i9;
            }
            while (i5 < i6) {
                fArr[i5] = fArr2;
                i5++;
            }
        }
        return fArr;
    }

    public void t() {
        int i2 = this.j;
        int i3 = this.ppp;
        if (i2 > i3) {
            this.j = i3;
        }
    }

    public a1 th(int i2, int i3) {
        a1[] de2 = this.f9395th.get(i2).de();
        for (int i4 = 0; i4 < de2.length; i4++) {
            if (de2[i4] != null && i3 >= i4 && i3 < de2[i4].r() + i4) {
                return de2[i4];
            }
        }
        return null;
    }

    public float tt(int i2, boolean z) {
        c1 c1Var;
        int i3;
        float f2;
        if (this.f9394pf <= 0.0f || i2 < 0 || i2 >= this.f9395th.size() || (c1Var = this.f9395th.get(i2)) == null) {
            return 0.0f;
        }
        if (z) {
            c1Var.ddd(this.f410switch);
        }
        float rg2 = c1Var.rg();
        for (int i4 = 0; i4 < this.f409if.length; i4++) {
            if (v(i2, i4)) {
                int i5 = 1;
                while (true) {
                    i3 = i2 - i5;
                    if (!v(i3, i4)) {
                        break;
                    }
                    i5++;
                }
                a1 a1Var = this.f9395th.get(i3).de()[i4];
                if (a1Var == null || a1Var.D() != i5 + 1) {
                    f2 = 0.0f;
                } else {
                    f2 = a1Var.B();
                    while (i5 > 0) {
                        f2 -= rrr(i2 - i5);
                        i5--;
                    }
                }
                if (f2 > rg2) {
                    rg2 = f2;
                }
            }
        }
        c1Var.xxx(rg2);
        return rg2;
    }

    public int type() {
        return 23;
    }

    public final e1 u(e1 e1Var, q qVar) {
        if (!qVar.f9708yj.R().contains(e1Var.getRole())) {
            return null;
        }
        qVar.K(e1Var);
        return e1Var;
    }

    public void uk(d1 d1Var) {
        this.l = d1Var.l;
        this.f409if = new float[d1Var.qqq()];
        this.f410switch = new float[d1Var.qqq()];
        System.arraycopy(d1Var.f409if, 0, this.f409if, 0, qqq());
        System.arraycopy(d1Var.f410switch, 0, this.f410switch, 0, qqq());
        this.f9394pf = d1Var.f9394pf;
        this.f9397yj = d1Var.f9397yj;
        this.f9392i = 0;
        this.when = d1Var.when;
        this.mmm = d1Var.mmm;
        a1 a1Var = d1Var.f9393o;
        if (a1Var instanceof b1) {
            this.f9393o = new b1((b1) a1Var);
        } else {
            this.f9393o = new a1(a1Var);
        }
        this.f9396uk = new a1[d1Var.f9396uk.length];
        this.nn = d1Var.nn;
        this.qqq = d1Var.qqq;
        this.rrr = d1Var.rrr;
        this.eee = d1Var.eee;
        this.ppp = d1Var.ppp;
        this.j = d1Var.j;
        this.aaa = d1Var.aaa;
        this.tt = d1Var.tt;
        this.e = d1Var.e;
        this.ggg = d1Var.ggg;
        this.f = d1Var.f;
        this.xxx = d1Var.xxx;
        this.ddd = d1Var.ddd;
        this.vvv = d1Var.vvv;
        this.g = d1Var.g;
        this.h = d1Var.h;
        this.k = d1Var.k;
        this.p = d1Var.p;
        this.m = d1Var.m;
        if (d1Var.n != null) {
            this.n = new HashMap<>(d1Var.n);
        }
        this.q = d1Var.xxx();
        this.r = d1Var.pf();
        this.s = d1Var.ppp();
    }

    public boolean v(int i2, int i3) {
        a1 a1Var;
        if (i3 >= qqq() || i3 < 0 || i2 < 1) {
            return false;
        }
        int i4 = i2 - 1;
        if (this.f9395th.get(i4) == null) {
            return false;
        }
        a1 th2 = th(i4, i3);
        while (a1Var == null && i4 > 0) {
            i4--;
            if (this.f9395th.get(i4) == null) {
                return false;
            }
            th2 = th(i4, i3);
        }
        int i5 = i2 - i4;
        if (a1Var.D() == 1 && i5 > 1) {
            int i6 = i3 - 1;
            c1 c1Var = this.f9395th.get(i4 + 1);
            i5--;
            a1Var = c1Var.de()[i6];
            while (a1Var == null && i6 > 0) {
                i6--;
                a1Var = c1Var.de()[i6];
            }
        }
        if (a1Var == null || a1Var.D() <= i5) {
            return false;
        }
        return true;
    }

    public int vvv() {
        return this.j;
    }

    public void w(boolean z) {
        this.h = z;
    }

    public ad when(float f2, int i2) {
        int i3;
        int qqq2 = qqq();
        qw[] qwVarArr = new qw[qqq2];
        for (int i4 = 0; i4 < qqq2; i4++) {
            qwVarArr[i4] = new qw();
        }
        HashMap hashMap = new HashMap();
        int i5 = i2;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i5 < K()) {
            c1 eee2 = eee(i5);
            float th2 = eee2.th();
            int i6 = 0;
            float f5 = 0.0f;
            while (i6 < qqq2) {
                a1 a1Var = eee2.de()[i6];
                qw qwVar = qwVarArr[i6];
                if (a1Var == null) {
                    qwVar.de(f4, th2);
                } else {
                    qwVar.qw(a1Var, f4, th2);
                }
                if (qwVar.ad()) {
                    float f6 = qwVar.qw;
                    if (f6 > f5) {
                        f5 = f6;
                    }
                }
                int i7 = 1;
                while (true) {
                    i3 = qwVar.f9402de;
                    if (i7 >= i3) {
                        break;
                    }
                    qwVarArr[i6 + i7].qw = qwVar.qw;
                    i7++;
                }
                i6 += i3;
            }
            float f7 = 0.0f;
            for (int i8 = 0; i8 < qqq2; i8++) {
                float f8 = qwVarArr[i8].qw;
                if (f8 > f7) {
                    f7 = f8;
                }
            }
            eee2.vvv(f5 - f4);
            if (f2 - (r() ? f7 : f5) < 0.0f) {
                break;
            }
            hashMap.put(Integer.valueOf(i5), Float.valueOf(f7 - f4));
            i5++;
            f3 = f7;
            f4 = f5;
        }
        this.l = false;
        return new ad(i2, i5 - 1, f3, f4, hashMap);
    }

    public void x(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.ppp = i2;
    }

    public g1 xxx() {
        if (this.q == null) {
            this.q = new g1();
        }
        return this.q;
    }

    public void y(boolean z) {
        this.e = z;
    }

    public final e1 yj(e1 e1Var, q qVar) {
        if (!qVar.f9708yj.R().contains(e1Var.getRole())) {
            return null;
        }
        qVar.eee(e1Var);
        return null;
    }

    public void z(int i2) {
        this.vvv = i2;
    }

    public d1(int i2) {
        this.f9391ad = fe.when.ad.e.ad.qw(d1.class);
        this.f9395th = new ArrayList<>();
        this.f9397yj = 0.0f;
        this.f9392i = 0;
        this.f9393o = new a1((Phrase) null);
        this.f9394pf = 0.0f;
        this.ggg = 80.0f;
        this.vvv = 1;
        this.xxx = false;
        this.ddd = false;
        this.nn = false;
        this.mmm = 0;
        this.aaa = false;
        this.qqq = true;
        this.tt = new boolean[]{false, false};
        this.f = true;
        this.h = true;
        this.k = true;
        this.l = true;
        this.m = s0.f5;
        this.n = null;
        this.p = new fe.when.ad.qw();
        this.q = null;
        this.r = null;
        this.s = null;
        if (i2 > 0) {
            this.f409if = new float[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f409if[i3] = 1.0f;
            }
            this.f410switch = new float[this.f409if.length];
            rg();
            this.f9396uk = new a1[this.f410switch.length];
            this.g = false;
            return;
        }
        throw new IllegalArgumentException(fe.when.ad.c.qw.ad("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
    }

    public d1(d1 d1Var) {
        this.f9391ad = fe.when.ad.e.ad.qw(d1.class);
        this.f9395th = new ArrayList<>();
        this.f9397yj = 0.0f;
        this.f9392i = 0;
        this.f9393o = new a1((Phrase) null);
        this.f9394pf = 0.0f;
        this.ggg = 80.0f;
        this.vvv = 1;
        this.xxx = false;
        this.ddd = false;
        this.nn = false;
        this.mmm = 0;
        this.aaa = false;
        this.qqq = true;
        this.tt = new boolean[]{false, false};
        this.f = true;
        this.h = true;
        this.k = true;
        this.l = true;
        this.m = s0.f5;
        this.n = null;
        this.p = new fe.when.ad.qw();
        this.q = null;
        this.r = null;
        this.s = null;
        uk(d1Var);
        int i2 = 0;
        while (true) {
            a1[] a1VarArr = this.f9396uk;
            if (i2 >= a1VarArr.length) {
                break;
            }
            a1[] a1VarArr2 = d1Var.f9396uk;
            if (a1VarArr2[i2] == null) {
                break;
            }
            a1VarArr[i2] = new a1(a1VarArr2[i2]);
            i2++;
        }
        for (int i3 = 0; i3 < d1Var.f9395th.size(); i3++) {
            c1 c1Var = d1Var.f9395th.get(i3);
            if (c1Var != null) {
                c1Var = new c1(c1Var);
            }
            this.f9395th.add(c1Var);
        }
    }
}
