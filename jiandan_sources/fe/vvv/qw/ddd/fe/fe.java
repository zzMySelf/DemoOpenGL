package fe.vvv.qw.ddd.fe;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public long f8893ad;

    /* renamed from: de  reason: collision with root package name */
    public long f8894de;

    /* renamed from: fe  reason: collision with root package name */
    public long f8895fe;
    public int qw;

    public fe(int i2) {
        this.qw = i2;
    }

    public static long ad(long j, int i2) {
        return (j * 1000000) / ((long) i2);
    }

    public static long qw(long j, int i2) {
        return (j * 1000) / ((long) i2);
    }

    public int de(int i2) {
        if (this.f8895fe == 0) {
            return 0;
        }
        return (int) (this.f8895fe / ad((long) i2, this.qw));
    }

    public long fe(long j) {
        return j - this.f8895fe;
    }

    public long rg(int i2) {
        long j = (long) i2;
        long ad2 = ad(j, this.qw);
        long nanoTime = (System.nanoTime() / 1000) - ad2;
        if (this.f8894de == 0) {
            this.f8893ad = nanoTime;
        }
        long ad3 = this.f8893ad + ad(this.f8894de, this.qw);
        long j2 = nanoTime - ad3;
        if (j2 >= ad2 * 2) {
            this.f8893ad = nanoTime;
            this.f8894de = j;
            this.f8895fe = j2;
            return nanoTime;
        }
        this.f8895fe = 0;
        this.f8894de += j;
        return ad3;
    }
}
