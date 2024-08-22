package fe.when.ad.f;

public class f0 extends v1 {
    public static final q0 eee = new q0("[1 0 0 1 0 0]");
    public static final v0 qqq = new v0(1);

    static {
        new v0(0);
    }

    public f0(z1 z1Var, int i2) {
        h(s0.K5, s0.v6);
        h(s0.b5, s0.y1);
        h(s0.s4, z1Var.l1());
        h(s0.m, new o1(z1Var.d1()));
        h(s0.z1, qqq);
        if (z1Var.i1() != null) {
            h(s0.s3, z1Var.i1().fe());
        }
        if (z1Var.f1() != null) {
            h(s0.F1, z1Var.f1());
        }
        k j1 = z1Var.j1();
        if (j1 == null) {
            h(s0.R2, eee);
        } else {
            h(s0.R2, j1);
        }
        byte[] W0 = z1Var.W0((c2) null);
        this.f9852ad = W0;
        h(s0.F2, new v0(W0.length));
        if (z1Var.c1() != null) {
            j(z1Var.c1());
        }
        l(i2);
    }
}
