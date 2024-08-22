package fe.when.qw.qw.uk;

public final class qw {
    public int qw = 1;

    public static int ad(int i2, double d) {
        return fe(i2, Double.doubleToLongBits(d));
    }

    public static int de(int i2, int i3) {
        return (i2 * 31) + i3;
    }

    public static int fe(int i2, long j) {
        return de(i2, (int) (j ^ (j >>> 32)));
    }

    public final int hashCode() {
        return this.qw;
    }

    public final qw qw(double d) {
        this.qw = ad(this.qw, d);
        return this;
    }
}
