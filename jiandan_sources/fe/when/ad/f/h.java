package fe.when.ad.f;

import fe.when.ad.c.qw;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class h extends x {
    public h() {
    }

    public static h l(String str, c2 c2Var) {
        return m(str, c2Var, false);
    }

    public static h m(String str, c2 c2Var, boolean z) {
        h hVar = new h();
        hVar.h(s0.D4, s0.m2);
        String str2 = "UnicodeBig";
        if (z && str.length() < 50) {
            hVar.h(s0.q2, new w1(str, str2));
        } else if (z || str.length() >= 100) {
            if (!z) {
                str2 = "PDF";
            }
            try {
                v1 v1Var = new v1(a0.de(str, str2));
                v1Var.l(c2Var.r());
                hVar.h(s0.q2, c2Var.eee(v1Var).qw());
            } catch (Exception unused) {
                hVar.h(s0.q2, new w1(str));
            }
        } else {
            hVar.h(s0.q2, new w1(str));
        }
        return hVar;
    }

    public static h n(String str, c0 c0Var, String str2, l0 l0Var) throws IOException {
        h hVar = new h();
        hVar.h(s0.D4, s0.r4);
        hVar.h(s0.i4, new p1(str, c0Var, str2));
        hVar.h(new s0("OP"), new v0(0));
        hVar.h(new s0("AN"), l0Var);
        return hVar;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 14, this);
        super.nn(c2Var, outputStream);
    }

    public h(URL url) {
        this(url.toExternalForm());
    }

    public h(String str) {
        this(str, false);
    }

    public h(String str, boolean z) {
        h(s0.D4, s0.S5);
        h(s0.S5, new w1(str));
        if (z) {
            h(s0.k2, l.f9519i);
        }
    }

    public h(l0 l0Var) {
        h(s0.D4, s0.D1);
        h(s0.k0, l0Var);
    }

    public h(String str, String str2) {
        h(s0.D4, s0.E1);
        h(s0.a1, new w1(str));
        h(s0.k0, new w1(str2));
    }

    public h(String str, int i2) {
        h(s0.D4, s0.E1);
        h(s0.a1, new w1(str));
        s0 s0Var = s0.k0;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i2 - 1);
        sb.append(" /FitH 10000]");
        h(s0Var, new q0(sb.toString()));
    }

    public h(int i2) {
        h(s0.D4, s0.d3);
        if (i2 == 1) {
            h(s0.b3, s0.h1);
        } else if (i2 == 2) {
            h(s0.b3, s0.Y3);
        } else if (i2 == 3) {
            h(s0.b3, s0.h3);
        } else if (i2 == 4) {
            h(s0.b3, s0.A2);
        } else if (i2 == 5) {
            h(s0.D4, s0.m2);
            h(s0.q2, new w1("this.print(true);\r"));
        } else {
            throw new RuntimeException(qw.ad("invalid.named.action", new Object[0]));
        }
    }

    public h(String str, String str2, String str3, String str4) {
        h(s0.D4, s0.B2);
        if (str2 == null && str3 == null && str4 == null) {
            h(s0.a1, new w1(str));
            return;
        }
        x xVar = new x();
        xVar.h(s0.a1, new w1(str));
        if (str2 != null) {
            xVar.h(s0.F3, new w1(str2));
        }
        if (str3 != null) {
            xVar.h(s0.o3, new w1(str3));
        }
        if (str4 != null) {
            xVar.h(s0.k0, new w1(str4));
        }
        h(s0.n6, xVar);
    }
}
