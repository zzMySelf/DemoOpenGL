package fe.when.ad.f;

public class l extends y0 {

    /* renamed from: i  reason: collision with root package name */
    public static final l f9519i = new l(true);

    /* renamed from: o  reason: collision with root package name */
    public static final l f9520o = new l(false);

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9521uk;

    public l(boolean z) {
        super(1);
        if (z) {
            xxx("true");
        } else {
            xxx("false");
        }
        this.f9521uk = z;
    }

    public boolean aaa() {
        return this.f9521uk;
    }

    public String toString() {
        return this.f9521uk ? "true" : "false";
    }
}
