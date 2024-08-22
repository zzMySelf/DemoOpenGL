package fe.when.ad.f;

import fe.when.ad.de;
import java.io.IOException;

public class r1 {

    /* renamed from: ad  reason: collision with root package name */
    public c2 f9737ad;

    /* renamed from: de  reason: collision with root package name */
    public o f9738de;

    /* renamed from: fe  reason: collision with root package name */
    public l0 f9739fe;
    public x qw;

    /* renamed from: rg  reason: collision with root package name */
    public de f9740rg;

    /* renamed from: th  reason: collision with root package name */
    public float[] f9741th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9742yj;

    public o ad() {
        return this.f9738de;
    }

    public de de() {
        return this.f9740rg;
    }

    public l0 fe() {
        if (this.f9739fe == null) {
            this.f9739fe = this.f9737ad.M();
        }
        return this.f9739fe;
    }

    public void qw() throws IOException {
        float[] fArr = this.f9741th;
        if (fArr != null) {
            this.qw.h(s0.m, new k(fArr));
        }
        if (this.f9742yj) {
            this.qw.h(s0.mmm, l.f9519i);
        }
        this.f9737ad.tt(this.qw, fe());
    }

    public void rg(int i2) {
        new s0("Sh" + i2);
    }
}
