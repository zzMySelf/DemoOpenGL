package fe.when.ad.f;

import java.util.HashMap;
import java.util.HashSet;

public class e {

    /* renamed from: ad  reason: collision with root package name */
    public x f9424ad = new x();

    /* renamed from: de  reason: collision with root package name */
    public x f9425de = new x();

    /* renamed from: fe  reason: collision with root package name */
    public x f9426fe = new x();

    /* renamed from: i  reason: collision with root package name */
    public x f9427i;

    /* renamed from: o  reason: collision with root package name */
    public int[] f9428o = {0};

    /* renamed from: pf  reason: collision with root package name */
    public HashMap<s0, s0> f9429pf;
    public x qw = new x();

    /* renamed from: rg  reason: collision with root package name */
    public x f9430rg = new x();

    /* renamed from: th  reason: collision with root package name */
    public x f9431th = new x();

    /* renamed from: uk  reason: collision with root package name */
    public HashSet<s0> f9432uk;

    /* renamed from: yj  reason: collision with root package name */
    public x f9433yj = new x();

    public void ad(x xVar) {
        this.f9425de.f(xVar);
    }

    public void de(x xVar) {
        this.f9425de.g(xVar);
    }

    public s0 fe(s0 s0Var, l0 l0Var) {
        s0 i2 = i(s0Var);
        this.qw.h(i2, l0Var);
        return i2;
    }

    public s0 i(s0 s0Var) {
        if (this.f9432uk == null) {
            return s0Var;
        }
        s0 s0Var2 = this.f9429pf.get(s0Var);
        if (s0Var2 == null) {
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Xi");
                int[] iArr = this.f9428o;
                int i2 = iArr[0];
                iArr[0] = i2 + 1;
                sb.append(i2);
                s0Var2 = new s0(sb.toString());
            } while (this.f9432uk.contains(s0Var2));
            this.f9429pf.put(s0Var, s0Var2);
        }
        return s0Var2;
    }

    public s0 qw(s0 s0Var, l0 l0Var) {
        s0 i2 = i(s0Var);
        this.f9425de.h(i2, l0Var);
        return i2;
    }

    public s0 rg(s0 s0Var, l0 l0Var) {
        s0 i2 = i(s0Var);
        this.f9426fe.h(i2, l0Var);
        return i2;
    }

    public s0 th(s0 s0Var, l0 l0Var) {
        s0 i2 = i(s0Var);
        this.f9433yj.h(i2, l0Var);
        return i2;
    }

    public x uk() {
        q1 q1Var = new q1();
        x xVar = this.f9427i;
        if (xVar != null) {
            q1Var.j(xVar);
        }
        q1Var.l(s0.r1, this.qw);
        q1Var.l(s0.v6, this.f9424ad);
        q1Var.l(s0.T, this.f9425de);
        q1Var.l(s0.R3, this.f9426fe);
        q1Var.l(s0.I4, this.f9430rg);
        q1Var.l(s0.X0, this.f9431th);
        q1Var.l(s0.g4, this.f9433yj);
        return q1Var;
    }

    public s0 yj(s0 s0Var, l0 l0Var) {
        s0 i2 = i(s0Var);
        this.f9424ad.h(i2, l0Var);
        return i2;
    }
}
