package fe.when.ad.f;

public class v extends k {

    /* renamed from: i  reason: collision with root package name */
    public boolean f9820i = false;

    public v(int i2, float f) {
        super((y0) new v0(f));
        if (i2 == 3) {
            tt(s0.j1);
        } else if (i2 == 6) {
            tt(s0.k1);
        } else if (i2 != 7) {
            tt(s0.i1);
        } else {
            tt(s0.l1);
        }
    }

    public boolean k(l0 l0Var) {
        if (this.f9820i) {
            return false;
        }
        tt(l0Var);
        this.f9820i = true;
        return true;
    }

    public boolean l() {
        return this.f9820i;
    }

    public v(int i2, float f, float f2, float f3) {
        super((y0) s0.y6);
        if (f < 0.0f) {
            qqq(u0.f9819uk);
        } else {
            qqq(new v0(f));
        }
        if (f2 < 0.0f) {
            qqq(u0.f9819uk);
        } else {
            qqq(new v0(f2));
        }
        qqq(new v0(f3));
    }
}
