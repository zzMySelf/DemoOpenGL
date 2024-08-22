package fe.when.ad.f;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.aaa;
import fe.when.ad.qw;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;

public class j extends x implements IAccessibleElement {
    public qw aaa = null;
    public int ddd = -1;
    public boolean ggg = false;
    public HashMap<s0, y0> mmm = null;
    public s0 nn = null;
    public HashSet<z1> ppp;

    /* renamed from: switch  reason: not valid java name */
    public c2 f420switch;
    public boolean vvv = true;
    public l0 when;
    public boolean xxx = false;

    static {
        s0 s0Var = s0.b3;
        s0 s0Var2 = s0.Y1;
        s0 s0Var3 = s0.o3;
        s0 s0Var4 = s0.F3;
        s0 s0Var5 = s0.e5;
        s0 s0Var6 = s0.b3;
        s0 s0Var7 = s0.i4;
        s0 s0Var8 = s0.k0;
        s0 s0Var9 = s0.K0;
        s0 s0Var10 = s0.t6;
        s0 s0Var11 = s0.k0;
        s0 s0Var12 = s0.N5;
        s0 s0Var13 = s0.q1;
        s0 s0Var14 = s0.q;
        s0 s0Var15 = s0.s2;
        s0 s0Var16 = s0.a1;
        s0 s0Var17 = s0.a6;
        s0 s0Var18 = s0.x;
    }

    public j(c2 c2Var, aaa aaa2) {
        this.f420switch = c2Var;
        if (aaa2 != null) {
            h(s0.m4, new o1(aaa2));
        }
    }

    public static j m(c2 c2Var, aaa aaa2, String str, c0 c0Var, String str2, boolean z) throws IOException {
        j jVar = new j(c2Var, aaa2);
        jVar.h(s0.b5, s0.G4);
        jVar.h(s0.a1, new v0(4));
        jVar.h(s0.K5, s0.ddd);
        jVar.u();
        l0 qw = c2Var.eee(h.n(str, c0Var, str2, jVar.n())).qw();
        if (z) {
            x xVar = new x();
            xVar.h(new s0("PV"), qw);
            jVar.h(s0.f9759pf, xVar);
        }
        jVar.h(s0.f9757i, qw);
        return jVar;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.mmm;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.mmm;
    }

    public qw getId() {
        if (this.aaa == null) {
            this.aaa = new qw();
        }
        return this.aaa;
    }

    public s0 getRole() {
        return this.nn;
    }

    public boolean isInline() {
        return false;
    }

    public void l(AffineTransform affineTransform) {
        o1 o1Var;
        k eee = eee(s0.m4);
        if (eee != null) {
            if (eee.size() == 4) {
                o1Var = new o1(eee.e(0).qqq(), eee.e(1).qqq(), eee.e(2).qqq(), eee.e(3).qqq());
            } else {
                o1Var = new o1(eee.e(0).qqq(), eee.e(1).qqq());
            }
            h(s0.m4, o1Var.q(affineTransform));
        }
    }

    public l0 n() {
        if (this.when == null) {
            this.when = this.f420switch.M();
        }
        return this.when;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 13, this);
        super.nn(c2Var, outputStream);
    }

    public int p() {
        return this.ddd;
    }

    public HashSet<z1> q() {
        return this.ppp;
    }

    public boolean r() {
        return this.vvv;
    }

    public boolean s() {
        return this.ggg;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.mmm == null) {
            this.mmm = new HashMap<>();
        }
        this.mmm.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.aaa = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.nn = s0Var;
    }

    public boolean t() {
        return this.xxx;
    }

    public void u() {
        h(s0.F3, this.f420switch.t());
    }

    public void v() {
        this.xxx = true;
    }

    public j(c2 c2Var, float f, float f2, float f3, float f4, w1 w1Var, w1 w1Var2) {
        this.f420switch = c2Var;
        h(s0.b5, s0.k5);
        h(s0.e5, w1Var);
        h(s0.m4, new o1(f, f2, f3, f4));
        h(s0.Z, w1Var2);
    }

    public j(c2 c2Var, float f, float f2, float f3, float f4, h hVar) {
        this.f420switch = c2Var;
        h(s0.b5, s0.J2);
        h(s0.m4, new o1(f, f2, f3, f4));
        h(s0.f9757i, hVar);
        h(s0.v, new m(0.0f, 0.0f, 0.0f));
        h(s0.x, new p(0, 0, 255));
    }
}
