package fe.when.ad.f;

import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class y1 extends x implements IPdfStructureElement {
    public HashMap<s0, y0> ggg = null;
    public x ppp = null;

    /* renamed from: switch  reason: not valid java name */
    public HashMap<Integer, y0> f467switch = new HashMap<>();
    public HashMap<Integer, l0> vvv = null;
    public l0 when;
    public c2 xxx;

    public y1(c2 c2Var) {
        super(s0.Y4);
        this.xxx = c2Var;
        this.when = c2Var.M();
    }

    public void l() throws IOException {
        m();
        x qw = w0.qw(this.vvv, this.xxx);
        if (qw != null) {
            h(s0.P3, this.xxx.eee(qw).qw());
        }
        if (this.ppp != null && !this.ggg.isEmpty()) {
            for (Map.Entry next : this.ggg.entrySet()) {
                y0 y0Var = (y0) next.getValue();
                if (y0Var.pf()) {
                    this.ppp.h((s0) next.getKey(), this.xxx.eee(y0Var).qw());
                } else if (y0Var.i()) {
                    k kVar = new k();
                    k kVar2 = (k) y0Var;
                    for (int i2 = 0; i2 < kVar2.size(); i2++) {
                        if (kVar2.g(i2).pf()) {
                            kVar.qqq(this.xxx.eee(kVar2.c(i2)).qw());
                        }
                    }
                    this.ppp.h((s0) next.getKey(), kVar);
                }
            }
            h(s0.O, this.xxx.eee(this.ppp).qw());
        }
        q(this, this.when);
    }

    public final void m() throws IOException {
        if (this.vvv == null) {
            this.vvv = new HashMap<>();
            for (Integer next : this.f467switch.keySet()) {
                y0 y0Var = this.f467switch.get(next);
                if (y0Var.i()) {
                    this.vvv.put(next, this.xxx.eee((k) y0Var).qw());
                } else if (y0Var instanceof l0) {
                    this.vvv.put(next, (l0) y0Var);
                }
            }
        }
    }

    public l0 n() {
        return this.when;
    }

    public c2 p() {
        return this.xxx;
    }

    public final void q(x xVar, l0 l0Var) throws IOException {
        y0 qqq = xVar.qqq(s0.s2);
        if (qqq != null && qqq.i()) {
            k kVar = (k) qqq;
            for (int i2 = 0; i2 < kVar.size(); i2++) {
                x c = kVar.c(i2);
                if (c != null && s0.V4.equals(c.qqq(s0.K5)) && (kVar.g(i2) instanceof x1)) {
                    x1 x1Var = (x1) c;
                    kVar.j(i2, x1Var.p());
                    q(x1Var, x1Var.p());
                }
            }
        }
        if (l0Var != null) {
            this.xxx.tt(xVar, l0Var);
        }
    }

    public y0 qw(s0 s0Var) {
        x tt = tt(s0.f9757i);
        if (tt == null || !tt.aaa(s0Var)) {
            return null;
        }
        return tt.qqq(s0Var);
    }

    public void r(int i2, l0 l0Var) {
        this.f467switch.put(Integer.valueOf(i2), l0Var);
    }

    public void s(int i2, l0 l0Var) {
        Integer valueOf = Integer.valueOf(i2);
        k kVar = (k) this.f467switch.get(valueOf);
        if (kVar == null) {
            kVar = new k();
            this.f467switch.put(valueOf, kVar);
        }
        kVar.qqq(l0Var);
    }
}
