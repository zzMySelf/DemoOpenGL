package fe.qw.qw.ggg;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public int f3259ad;
    public float qw;

    public void qw(float f) {
        float f2 = this.qw + f;
        this.qw = f2;
        int i2 = this.f3259ad + 1;
        this.f3259ad = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.qw = f2 / 2.0f;
            this.f3259ad = i2 / 2;
        }
    }
}
