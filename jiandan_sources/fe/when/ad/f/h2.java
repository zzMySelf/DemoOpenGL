package fe.when.ad.f;

public class h2 extends ppp {

    /* renamed from: rg  reason: collision with root package name */
    public t1 f9467rg;

    /* renamed from: th  reason: collision with root package name */
    public float f9468th;

    public h2(t1 t1Var, float f) {
        super(3, (((((float) t1Var.de().fe()) / 255.0f) - 1.0f) * f) + 1.0f, (((((float) t1Var.de().ad()) / 255.0f) - 1.0f) * f) + 1.0f, (((((float) t1Var.de().qw()) / 255.0f) - 1.0f) * f) + 1.0f);
        this.f9467rg = t1Var;
        this.f9468th = f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h2) {
            h2 h2Var = (h2) obj;
            return h2Var.f9467rg.equals(this.f9467rg) && h2Var.f9468th == this.f9468th;
        }
    }

    public int hashCode() {
        return this.f9467rg.hashCode() ^ Float.floatToIntBits(this.f9468th);
    }

    public t1 o() {
        return this.f9467rg;
    }

    public float pf() {
        return this.f9468th;
    }
}
