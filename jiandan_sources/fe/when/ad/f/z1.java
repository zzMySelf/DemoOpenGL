package fe.when.ad.f;

import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.aaa;
import fe.when.ad.qw;
import java.io.IOException;
import java.util.HashMap;

public class z1 extends q implements IAccessibleElement {
    public aaa aaa = new aaa(0.0f, 0.0f);
    public int ddd = 1;
    public boolean e = false;
    public b2 eee;
    public x f = null;
    public s0 g = s0.c1;
    public HashMap<s0, y0> h = null;
    public qw j = null;
    public e mmm;
    public l0 nn;
    public k qqq;
    public PdfOCG rrr;
    public l0 tt;

    public z1() {
        super((c2) null);
    }

    public static z1 a1(c2 c2Var, float f2, float f3) {
        return b1(c2Var, f2, f3, (s0) null);
    }

    public static z1 b1(c2 c2Var, float f2, float f3, s0 s0Var) {
        z1 z1Var = new z1(c2Var);
        z1Var.s1(f2);
        z1Var.q1(f3);
        c2Var.when(z1Var, s0Var);
        return z1Var;
    }

    public boolean F() {
        return super.F() && this.e;
    }

    public x c1() {
        return this.f;
    }

    public aaa d1() {
        return this.aaa;
    }

    public v1 e1(int i2) throws IOException {
        return new f0(this, i2);
    }

    public b2 f1() {
        return this.eee;
    }

    public float g1() {
        return this.aaa.ggg();
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.h;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.h;
    }

    public qw getId() {
        if (this.j == null) {
            this.j = new qw();
        }
        return this.j;
    }

    public s0 getRole() {
        return this.g;
    }

    public l0 h1() {
        if (this.nn == null) {
            this.nn = this.f9708yj.M();
        }
        return this.nn;
    }

    public PdfOCG i1() {
        return this.rrr;
    }

    public boolean isInline() {
        return true;
    }

    public k j1() {
        return this.qqq;
    }

    public l0 k1() {
        return this.tt;
    }

    public y0 l1() {
        return z().uk();
    }

    public int m1() {
        return this.ddd;
    }

    public float n1() {
        return this.aaa.rrr();
    }

    public boolean o1() {
        return this.e;
    }

    public void p1(boolean z) {
        this.e = z;
    }

    public void q1(float f2) {
        this.aaa.j(0.0f);
        this.aaa.n(f2);
    }

    public l0 r() {
        l0 l0Var = this.tt;
        return l0Var == null ? this.f9708yj.t() : l0Var;
    }

    public void r1(l0 l0Var) {
        this.tt = l0Var;
    }

    public q s() {
        z1 z1Var = new z1();
        z1Var.f9708yj = this.f9708yj;
        z1Var.f9707uk = this.f9707uk;
        z1Var.nn = this.nn;
        z1Var.mmm = this.mmm;
        z1Var.aaa = new aaa(this.aaa);
        z1Var.eee = this.eee;
        z1Var.rrr = this.rrr;
        k kVar = this.qqq;
        if (kVar != null) {
            z1Var.qqq = new k(kVar);
        }
        z1Var.f450if = this.f450if;
        z1Var.f = this.f;
        return z1Var;
    }

    public void s1(float f2) {
        this.aaa.k(0.0f);
        this.aaa.l(f2);
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.h == null) {
            this.h = new HashMap<>();
        }
        this.h.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.j = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.g = s0Var;
    }

    public e z() {
        return this.mmm;
    }

    public z1(c2 c2Var) {
        super(c2Var);
        e eVar = new e();
        this.mmm = eVar;
        eVar.ad(c2Var.v());
        this.nn = this.f9708yj.M();
    }
}
