package fe.when.ad.f;

import com.itextpdf.text.Paragraph;
import fe.when.ad.de;
import fe.when.ad.fe;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class z0 extends x {
    public int aaa;
    public c2 ddd;
    public v ggg;
    public de mmm;
    public boolean nn;
    public z0 ppp;

    /* renamed from: switch  reason: not valid java name */
    public l0 f468switch;
    public h vvv;
    public int when;
    public ArrayList<z0> xxx;

    public z0(c2 c2Var) {
        super(x.f9836o);
        this.when = 0;
        this.xxx = new ArrayList<>();
        this.aaa = 0;
        this.nn = true;
        this.ppp = null;
        this.ddd = c2Var;
    }

    public int getCount() {
        return this.when;
    }

    public void l(z0 z0Var) {
        this.xxx.add(z0Var);
    }

    public ArrayList<z0> m() {
        return this.xxx;
    }

    public l0 n() {
        return this.f468switch;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        de deVar = this.mmm;
        int i2 = 0;
        if (deVar != null && !deVar.equals(de.f9336de)) {
            h(s0.x, new k(new float[]{((float) this.mmm.fe()) / 255.0f, ((float) this.mmm.ad()) / 255.0f, ((float) this.mmm.qw()) / 255.0f}));
        }
        if ((this.aaa & 1) != 0) {
            i2 = 2;
        }
        if ((this.aaa & 2) != 0) {
            i2 |= 1;
        }
        if (i2 != 0) {
            h(s0.a1, new v0(i2));
        }
        z0 z0Var = this.ppp;
        if (z0Var != null) {
            h(s0.O3, z0Var.n());
        }
        v vVar = this.ggg;
        if (vVar != null && vVar.l()) {
            h(s0.t0, this.ggg);
        }
        h hVar = this.vvv;
        if (hVar != null) {
            h(s0.f9757i, hVar);
        }
        int i3 = this.when;
        if (i3 != 0) {
            h(s0.a0, new v0(i3));
        }
        super.nn(c2Var, outputStream);
    }

    public void p(z0 z0Var, String str, boolean z) {
        this.nn = z;
        this.ppp = z0Var;
        this.ddd = z0Var.ddd;
        h(s0.y5, new w1(str, "UnicodeBig"));
        z0Var.l(this);
        v vVar = this.ggg;
        if (vVar != null && !vVar.l()) {
            u(this.ddd.t());
        }
    }

    public boolean q() {
        return this.nn;
    }

    public int r() {
        z0 z0Var = this.ppp;
        if (z0Var == null) {
            return 0;
        }
        return z0Var.r() + 1;
    }

    public z0 s() {
        return this.ppp;
    }

    public void t(int i2) {
        this.when = i2;
    }

    public boolean u(l0 l0Var) {
        v vVar = this.ggg;
        if (vVar == null) {
            return false;
        }
        return vVar.k(l0Var);
    }

    public void v(l0 l0Var) {
        this.f468switch = l0Var;
    }

    public z0(z0 z0Var, v vVar, Paragraph paragraph, boolean z) {
        this.when = 0;
        this.xxx = new ArrayList<>();
        this.aaa = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (fe de2 : paragraph.getChunks()) {
            stringBuffer.append(de2.de());
        }
        this.ggg = vVar;
        p(z0Var, stringBuffer.toString(), z);
    }
}
