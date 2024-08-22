package fe.when.ad.f;

import fe.when.ad.c.qw;

public class v0 extends y0 {

    /* renamed from: uk  reason: collision with root package name */
    public double f9821uk;

    public v0(String str) {
        super(2);
        try {
            this.f9821uk = Double.parseDouble(str.trim());
            xxx(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(qw.ad("1.is.not.a.valid.number.2", str, e.toString()));
        }
    }

    public double aaa() {
        return this.f9821uk;
    }

    public int eee() {
        return (int) this.f9821uk;
    }

    public float qqq() {
        return (float) this.f9821uk;
    }

    public v0(int i2) {
        super(2);
        this.f9821uk = (double) i2;
        xxx(String.valueOf(i2));
    }

    public v0(long j) {
        super(2);
        this.f9821uk = (double) j;
        xxx(String.valueOf(j));
    }

    public v0(double d) {
        super(2);
        this.f9821uk = d;
        xxx(rg.ggg(d));
    }

    public v0(float f) {
        this((double) f);
    }
}
