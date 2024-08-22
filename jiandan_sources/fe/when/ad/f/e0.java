package fe.when.ad.f;

import fe.when.ad.aaa;
import java.util.ArrayList;
import java.util.Iterator;

public class e0 extends j {
    public static s0[] rrr = {s0.r1, s0.v6, s0.T, s0.R3};
    public ArrayList<e0> eee;
    public e0 qqq;

    static {
        s0 s0Var = s0.f9757i;
        s0 s0Var2 = s0.j;
        s0 s0Var3 = s0.D4;
        s0 s0Var4 = s0.b3;
        s0 s0Var5 = s0.f9757i;
        s0 s0Var6 = s0.F3;
    }

    public e0(c2 c2Var) {
        super(c2Var, (aaa) null);
        this.ggg = true;
        this.vvv = false;
        this.nn = s0.y1;
    }

    public static j A(j jVar) {
        e0 e0Var;
        if (jVar.s()) {
            e0 e0Var2 = new e0(jVar.f420switch);
            e0 e0Var3 = (e0) jVar;
            e0Var2.qqq = e0Var3.qqq;
            e0Var2.eee = e0Var3.eee;
            e0Var = e0Var2;
        } else {
            e0Var = new j(jVar.f420switch, (aaa) null);
        }
        e0Var.f(jVar);
        e0Var.ggg = jVar.ggg;
        e0Var.vvv = jVar.vvv;
        e0Var.ppp = jVar.ppp;
        return e0Var;
    }

    public static void y(x xVar, x xVar2) {
        z(xVar, xVar2, (u1) null);
    }

    public static void z(x xVar, x xVar2, u1 u1Var) {
        int i2 = 0;
        while (true) {
            s0[] s0VarArr = rrr;
            if (i2 < s0VarArr.length) {
                s0 s0Var = s0VarArr[i2];
                x tt = xVar2.tt(s0Var);
                if (tt != null) {
                    x xVar3 = (x) m1.vvv(xVar.qqq(s0Var), xVar);
                    if (xVar3 == null) {
                        xVar3 = new x();
                    }
                    xVar3.g(tt);
                    xVar.h(s0Var, xVar3);
                    if (u1Var != null) {
                        u1Var.i0(xVar3);
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void v() {
        this.xxx = true;
        e0 e0Var = this.qqq;
        if (e0Var != null) {
            h(s0.O3, e0Var.n());
        }
        if (this.eee != null) {
            k kVar = new k();
            for (int i2 = 0; i2 < this.eee.size(); i2++) {
                kVar.qqq(this.eee.get(i2).n());
            }
            h(s0.u2, kVar);
        }
        if (this.ppp != null) {
            x xVar = new x();
            Iterator<z1> it = this.ppp.iterator();
            while (it.hasNext()) {
                y(xVar, (x) it.next().l1());
            }
            h(s0.E0, xVar);
        }
    }

    public ArrayList<e0> w() {
        return this.eee;
    }

    public e0 x() {
        return this.qqq;
    }
}
