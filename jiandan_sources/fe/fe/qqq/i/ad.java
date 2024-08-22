package fe.fe.qqq.i;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public float f4425ad;

    /* renamed from: de  reason: collision with root package name */
    public long f4426de;
    public boolean qw;

    public ad(String str, long j, boolean z, float f) {
        this.f4426de = j;
        this.qw = z;
        this.f4425ad = f;
    }

    public boolean ad() {
        return this.qw;
    }

    public long de() {
        return this.f4426de;
    }

    public boolean fe(boolean z, float f) {
        return z && Math.abs(this.f4425ad - f) < 0.001f;
    }

    public float qw() {
        return this.f4425ad;
    }
}
