package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class x extends y0 {

    /* renamed from: if  reason: not valid java name */
    public static final s0 f464if = s0.E;

    /* renamed from: o  reason: collision with root package name */
    public static final s0 f9836o = s0.A3;

    /* renamed from: pf  reason: collision with root package name */
    public static final s0 f9837pf = s0.G3;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<s0, y0> f9838i;

    /* renamed from: uk  reason: collision with root package name */
    public s0 f9839uk;

    static {
        s0 s0Var = s0.r1;
        s0 s0Var2 = s0.K3;
    }

    public x() {
        super(6);
        this.f9839uk = null;
        this.f9838i = new HashMap<>();
    }

    public s0 a(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.m1125switch()) {
            return null;
        }
        return (s0) d;
    }

    public boolean aaa(s0 s0Var) {
        return this.f9838i.containsKey(s0Var);
    }

    public v0 b(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.ppp()) {
            return null;
        }
        return (v0) d;
    }

    public w1 c(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.vvv()) {
            return null;
        }
        return (w1) d;
    }

    public y0 d(s0 s0Var) {
        return m1.ggg(qqq(s0Var));
    }

    public Set<s0> e() {
        return this.f9838i.keySet();
    }

    public k eee(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.i()) {
            return null;
        }
        return (k) d;
    }

    public void f(x xVar) {
        this.f9838i.putAll(xVar.f9838i);
    }

    public void g(x xVar) {
        for (s0 next : xVar.f9838i.keySet()) {
            if (!this.f9838i.containsKey(next)) {
                this.f9838i.put(next, xVar.f9838i.get(next));
            }
        }
    }

    public void h(s0 s0Var, y0 y0Var) {
        if (y0Var == null || y0Var.when()) {
            this.f9838i.remove(s0Var);
        } else {
            this.f9838i.put(s0Var, y0Var);
        }
    }

    public void j(x xVar) {
        this.f9838i.putAll(xVar.f9838i);
    }

    public void k(s0 s0Var) {
        this.f9838i.remove(s0Var);
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 11, this);
        outputStream.write(60);
        outputStream.write(60);
        for (Map.Entry next : this.f9838i.entrySet()) {
            ((s0) next.getKey()).nn(c2Var, outputStream);
            y0 y0Var = (y0) next.getValue();
            int mmm = y0Var.mmm();
            if (!(mmm == 5 || mmm == 6 || mmm == 4 || mmm == 3)) {
                outputStream.write(32);
            }
            y0Var.nn(c2Var, outputStream);
        }
        outputStream.write(62);
        outputStream.write(62);
    }

    public y0 qqq(s0 s0Var) {
        return this.f9838i.get(s0Var);
    }

    public l rrr(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.o()) {
            return null;
        }
        return (l) d;
    }

    public int size() {
        return this.f9838i.size();
    }

    public String toString() {
        if (qqq(s0.K5) == null) {
            return "Dictionary";
        }
        return "Dictionary of type: " + qqq(s0.K5);
    }

    public x tt(s0 s0Var) {
        y0 d = d(s0Var);
        if (d == null || !d.pf()) {
            return null;
        }
        return (x) d;
    }

    public x(s0 s0Var) {
        this();
        this.f9839uk = s0Var;
        h(s0.K5, s0Var);
    }
}
