package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;

public class k1 extends v1 {
    public k1(l1 l1Var, int i2) {
        v0 v0Var = new v0(1);
        k j1 = l1Var.j1();
        if (j1 != null) {
            h(s0.R2, j1);
        }
        h(s0.K5, s0.R3);
        h(s0.m, new o1(l1Var.d1()));
        h(s0.s4, l1Var.l1());
        h(s0.t5, v0Var);
        h(s0.S3, v0Var);
        if (l1Var.y1()) {
            h(s0.L3, new v0(2));
        } else {
            h(s0.L3, v0Var);
        }
        h(s0.x6, new v0(l1Var.w1()));
        h(s0.z6, new v0(l1Var.x1()));
        byte[] W0 = l1Var.W0((c2) null);
        this.f9852ad = W0;
        h(s0.F2, new v0(W0.length));
        try {
            l(i2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
