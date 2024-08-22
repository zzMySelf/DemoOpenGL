package fe.when.ad.f;

public class nn extends ppp {

    /* renamed from: rg  reason: collision with root package name */
    public float f9670rg;

    static {
        new nn(0.0f);
        new nn(1.0f);
    }

    public nn(int i2) {
        this(((float) i2) / 255.0f);
    }

    public boolean equals(Object obj) {
        return (obj instanceof nn) && ((nn) obj).f9670rg == this.f9670rg;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f9670rg);
    }

    public float o() {
        return this.f9670rg;
    }

    public nn(float f) {
        super(1, f, f, f);
        this.f9670rg = ppp.i(f);
    }
}
