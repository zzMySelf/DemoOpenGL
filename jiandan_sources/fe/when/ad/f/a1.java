package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.tera.scan.ui.widget.RotateProgress;
import fe.when.ad.aaa;
import fe.when.ad.fe;
import fe.when.ad.i;
import fe.when.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class a1 extends aaa implements IAccessibleElement {
    public float e = 2.0f;
    public int eee = 4;
    public float f = 2.0f;
    public float g = 0.0f;
    public float h;
    public boolean j = false;
    public d1 k;
    public int l = 1;
    public int m = 1;
    public i n;
    public PdfPCellEvent p;
    public boolean q = false;
    public pf qqq = new pf((q) null);
    public boolean r = false;
    public float rrr = 2.0f;
    public Phrase s;
    public int t;
    public float tt = 2.0f;
    public s0 u = s0.i5;
    public HashMap<s0, y0> v = null;
    public qw w = new qw();
    public ArrayList<b1> x = null;

    public a1() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f400switch = 0.5f;
        this.f9301pf = 15;
        this.qqq.k(0.0f, 1.0f);
    }

    public i A() {
        return this.n;
    }

    public float B() {
        float f2;
        float f3;
        float f4;
        boolean z = mmm() == 90 || mmm() == 270;
        i A = A();
        float f5 = 0.0f;
        if (A != null) {
            A.r0(100.0f);
            A.r0(((((ddd() - v()) - u()) - vvv()) / (z ? A.S() : A.T())) * 100.0f);
            j(((aaa() - w()) - t()) - (z ? A.T() : A.S()));
        } else if ((!z || !G()) && s() != null) {
            pf fe2 = pf.fe(s());
            float f6 = 20000.0f;
            if (z) {
                f4 = ddd() - v();
                f2 = vvv() + u();
                f3 = 0.0f;
            } else {
                if (!I()) {
                    f6 = ddd() - v();
                }
                f4 = aaa() - w();
                f3 = vvv() + u();
                f2 = G() ? (aaa() + t()) - x() : -1.07374182E9f;
            }
            c1.ppp(fe2, f3, f2, f6, f4);
            try {
                fe2.ddd(true);
                if (z) {
                    j(((aaa() - w()) - t()) - fe2.m1111if());
                } else {
                    float vvv = fe2.vvv();
                    if (K()) {
                        vvv += fe2.pf();
                    }
                    j(vvv - t());
                }
            } catch (DocumentException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            j(aaa() - x());
        }
        float ggg = ggg();
        if (ggg != w() + t()) {
            f5 = ggg;
        }
        if (G()) {
            return x();
        }
        return (!H() || f5 >= C()) ? f5 : C();
    }

    public float C() {
        return this.h;
    }

    public int D() {
        return this.m;
    }

    public int E() {
        return this.qqq.ggg();
    }

    public int F() {
        return this.eee;
    }

    public boolean G() {
        return x() > 0.0f;
    }

    public boolean H() {
        return C() > 0.0f;
    }

    public boolean I() {
        return this.j;
    }

    public boolean J() {
        return this.r;
    }

    public boolean K() {
        return this.q;
    }

    public void L(int i2) {
        this.l = i2;
    }

    public void M(pf pfVar) {
        this.qqq = pfVar;
    }

    public void N(float f2) {
        this.g = f2;
        this.h = 0.0f;
    }

    public void O(float f2) {
        this.h = f2;
        this.g = 0.0f;
    }

    public void P(float f2) {
        this.f = f2;
        this.e = f2;
        this.rrr = f2;
        this.tt = f2;
    }

    public void Q(Phrase phrase) {
        this.k = null;
        this.n = null;
        pf pfVar = this.qqq;
        this.s = phrase;
        pfVar.t(phrase);
    }

    public void R(int i2) {
        this.m = i2;
    }

    public void S(int i2) {
        this.qqq.m(i2);
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.v;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.v;
    }

    public qw getId() {
        return this.w;
    }

    public s0 getRole() {
        return this.u;
    }

    public boolean isInline() {
        return false;
    }

    public void m(int i2) {
        int i3 = i2 % RotateProgress.FULL_DEGREE;
        if (i3 < 0) {
            i3 += RotateProgress.FULL_DEGREE;
        }
        if (i3 % 90 == 0) {
            this.t = i3;
            return;
        }
        throw new IllegalArgumentException(fe.when.ad.c.qw.ad("rotation.must.be.a.multiple.of.90", new Object[0]));
    }

    public int mmm() {
        return this.t;
    }

    public void p(Element element) {
        if (this.k != null) {
            this.k = null;
            this.qqq.t((Phrase) null);
        }
        if (element instanceof d1) {
            ((d1) element).G(false);
        } else if (element instanceof PdfDiv) {
            Iterator<Element> it = ((PdfDiv) element).fe().iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next instanceof d1) {
                    ((d1) next).G(false);
                }
            }
        }
        this.qqq.qw(element);
    }

    public PdfPCellEvent q() {
        return this.p;
    }

    public int r() {
        return this.l;
    }

    public pf s() {
        return this.qqq;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.v == null) {
            this.v = new HashMap<>();
        }
        this.v.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.w = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.u = s0Var;
    }

    public float t() {
        if (!J()) {
            return this.f;
        }
        return this.f + (o() / (b() ? 1.0f : 2.0f));
    }

    public float u() {
        if (!J()) {
            return this.rrr;
        }
        return this.rrr + (pf() / (b() ? 1.0f : 2.0f));
    }

    public float v() {
        if (!J()) {
            return this.tt;
        }
        return this.tt + (m1061if() / (b() ? 1.0f : 2.0f));
    }

    public float w() {
        if (!J()) {
            return this.e;
        }
        return this.e + (m1062switch() / (b() ? 1.0f : 2.0f));
    }

    public float x() {
        return this.g;
    }

    public ArrayList<b1> y() {
        return this.x;
    }

    public int z() {
        return this.qqq.uk();
    }

    public a1(Phrase phrase) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f400switch = 0.5f;
        this.f9301pf = 15;
        pf pfVar = this.qqq;
        this.s = phrase;
        pfVar.ad(phrase);
        this.qqq.k(0.0f, 1.0f);
    }

    public a1(i iVar, boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f400switch = 0.5f;
        this.f9301pf = 15;
        this.qqq.k(0.0f, 1.0f);
        if (z) {
            this.n = iVar;
            P(this.f400switch / 2.0f);
            return;
        }
        iVar.F0(false);
        pf pfVar = this.qqq;
        Phrase phrase = new Phrase(new fe(iVar, 0.0f, 0.0f, true));
        this.s = phrase;
        pfVar.ad(phrase);
        P(0.0f);
    }

    public a1(a1 a1Var) {
        super(a1Var.f9298ad, a1Var.f9302th, a1Var.f9304yj, a1Var.f9303uk);
        qw(a1Var);
        this.eee = a1Var.eee;
        this.rrr = a1Var.rrr;
        this.tt = a1Var.tt;
        this.e = a1Var.e;
        this.f = a1Var.f;
        this.s = a1Var.s;
        this.g = a1Var.g;
        this.h = a1Var.h;
        this.j = a1Var.j;
        this.l = a1Var.l;
        this.m = a1Var.m;
        if (a1Var.k != null) {
            this.k = new d1(a1Var.k);
        }
        this.n = i.I(a1Var.n);
        this.p = a1Var.p;
        this.q = a1Var.q;
        this.qqq = pf.fe(a1Var.qqq);
        this.r = a1Var.r;
        this.t = a1Var.t;
        this.w = a1Var.w;
        this.u = a1Var.u;
        if (a1Var.v != null) {
            this.v = new HashMap<>(a1Var.v);
        }
        this.x = a1Var.x;
    }
}
