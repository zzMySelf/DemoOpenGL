package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import fe.when.ad.c.qw;
import java.util.HashMap;

public class h1 extends x {

    /* renamed from: switch  reason: not valid java name */
    public static final String[] f417switch = {"crop", "trim", "art", "bleed"};
    public static final s0[] when = {s0.h0, s0.E5, s0.eee, s0.t};

    static {
        new v0(0);
        new v0(90);
        new v0(180);
        new v0(270);
    }

    public h1(o1 o1Var, HashMap<String, o1> hashMap, x xVar, int i2) throws DocumentException {
        super(x.f9837pf);
        int i3 = 0;
        if (o1Var == null || (o1Var.r() <= 14400.0f && o1Var.l() <= 14400.0f)) {
            h(s0.W2, o1Var);
            h(s0.s4, xVar);
            if (i2 != 0) {
                h(s0.v4, new v0(i2));
            }
            while (true) {
                String[] strArr = f417switch;
                if (i3 < strArr.length) {
                    y0 y0Var = hashMap.get(strArr[i3]);
                    if (y0Var != null) {
                        h(when[i3], y0Var);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            throw new DocumentException(qw.ad("the.page.size.must.be.smaller.than.14400.by.14400.its.1.by.2", Float.valueOf(o1Var.r()), Float.valueOf(o1Var.l())));
        }
    }

    public void l(l0 l0Var) {
        h(s0.Z, l0Var);
    }
}
