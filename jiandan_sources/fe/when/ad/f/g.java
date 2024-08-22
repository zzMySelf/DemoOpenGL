package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class g extends x {
    public k ggg = new k();
    public k ppp = new k();

    /* renamed from: switch  reason: not valid java name */
    public c2 f415switch;
    public int vvv = 0;
    public HashSet<z1> when = new HashSet<>();

    public g(c2 c2Var) {
        this.f415switch = c2Var;
    }

    public void l(l0 l0Var) {
        this.ppp.qqq(l0Var);
    }

    public void m(HashSet<z1> hashSet) {
        this.when.addAll(hashSet);
    }

    public boolean n() {
        if (this.ppp.size() == 0) {
            return false;
        }
        h(s0.b1, this.ppp);
        int i2 = this.vvv;
        if (i2 != 0) {
            h(s0.J4, new v0(i2));
        }
        if (this.ggg.size() > 0) {
            h(s0.P, this.ggg);
        }
        if (this.when.isEmpty()) {
            return true;
        }
        x xVar = new x();
        Iterator<z1> it = this.when.iterator();
        while (it.hasNext()) {
            e0.y(xVar, (x) it.next().l1());
        }
        h(s0.E0, xVar);
        h(s0.l0, new w1("/Helv 0 Tf 0 g "));
        x xVar2 = (x) xVar.qqq(s0.r1);
        if (xVar2 != null) {
            this.f415switch.k(xVar2);
        }
        return true;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 15, this);
        super.nn(c2Var, outputStream);
    }
}
