package fe.when.ad.f;

public class i extends ppp {

    /* renamed from: rg  reason: collision with root package name */
    public float f9469rg;

    /* renamed from: th  reason: collision with root package name */
    public float f9470th;

    /* renamed from: uk  reason: collision with root package name */
    public float f9471uk;

    /* renamed from: yj  reason: collision with root package name */
    public float f9472yj;

    public i(float f, float f2, float f3, float f4) {
        super(2, (1.0f - f) - f4, (1.0f - f2) - f4, (1.0f - f3) - f4);
        this.f9469rg = ppp.i(f);
        this.f9470th = ppp.i(f2);
        this.f9472yj = ppp.i(f3);
        this.f9471uk = ppp.i(f4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f9469rg == iVar.f9469rg && this.f9470th == iVar.f9470th && this.f9472yj == iVar.f9472yj && this.f9471uk == iVar.f9471uk) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.f9469rg) ^ Float.floatToIntBits(this.f9470th)) ^ Float.floatToIntBits(this.f9472yj)) ^ Float.floatToIntBits(this.f9471uk);
    }

    /* renamed from: if  reason: not valid java name */
    public float m1083if() {
        return this.f9470th;
    }

    public float o() {
        return this.f9471uk;
    }

    public float pf() {
        return this.f9469rg;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1084switch() {
        return this.f9472yj;
    }
}
