package fe.mmm.qw.n;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public long f8081ad;
    public long qw;

    public qw() {
        this(500);
    }

    public boolean qw() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f8081ad;
        if (0 < j && j < this.qw) {
            return true;
        }
        this.f8081ad = currentTimeMillis;
        return false;
    }

    public qw(long j) {
        this.qw = 500;
        this.qw = j;
    }
}
