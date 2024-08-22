package fe.when.ad.f.p2;

import fe.when.ad.de;
import fe.when.ad.f.q;

public class qw extends ad {

    /* renamed from: i  reason: collision with root package name */
    public int f9687i = 6;

    /* renamed from: th  reason: collision with root package name */
    public float f9688th = 1.0f;

    /* renamed from: uk  reason: collision with root package name */
    public de f9689uk;

    /* renamed from: yj  reason: collision with root package name */
    public float f9690yj = 100.0f;

    public void ad(q qVar, float f, float f2, float f3) {
        float f4;
        float f5 = 0.0f;
        if (th() < 0.0f) {
            f4 = -th();
        } else {
            f4 = ((f2 - f) * th()) / 100.0f;
        }
        int de2 = de();
        if (de2 != 0) {
            f5 = de2 != 2 ? ((f2 - f) - f4) / 2.0f : (f2 - f) - f4;
        }
        qVar.x0(rg());
        if (fe() != null) {
            qVar.l0(fe());
        }
        qVar.I(f5 + f, this.f9686ad + f3);
        qVar.G(f5 + f4 + f, f3 + this.f9686ad);
        qVar.V0();
    }

    public int de() {
        return this.f9687i;
    }

    public de fe() {
        return this.f9689uk;
    }

    public void qw(q qVar, float f, float f2, float f3, float f4, float f5) {
        qVar.d0();
        ad(qVar, f, f3, f5);
        qVar.Y();
    }

    public float rg() {
        return this.f9688th;
    }

    public float th() {
        return this.f9690yj;
    }
}
