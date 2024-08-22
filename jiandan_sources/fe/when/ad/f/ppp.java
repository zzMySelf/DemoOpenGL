package fe.when.ad.f;

import fe.when.ad.de;

public abstract class ppp extends de {

    /* renamed from: fe  reason: collision with root package name */
    public int f9701fe;

    public ppp(int i2) {
        super(0, 0, 0);
        this.f9701fe = i2;
    }

    public static final float i(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static int uk(de deVar) {
        if (deVar instanceof ppp) {
            return ((ppp) deVar).yj();
        }
        return 0;
    }

    public int yj() {
        return this.f9701fe;
    }

    public ppp(int i2, float f, float f2, float f3) {
        super(i(f), i(f2), i(f3));
        this.f9701fe = i2;
    }
}
