package fe.mmm.qw.a.yj.qw;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f7640ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7641de;
    public String qw;

    public ad(String str, int i2, boolean z) {
        this.f7640ad = 2;
        this.qw = str;
        this.f7640ad = i2;
        this.f7641de = z;
    }

    public boolean ad() {
        return false;
    }

    public void de() {
        if (this.f7641de) {
            int i2 = this.f7640ad;
            if (i2 == 1) {
                this.f7640ad = 2;
            } else if (i2 == 2) {
                this.f7640ad = 3;
            } else if (i2 == 3) {
                this.f7640ad = 4;
            }
        }
    }

    public int qw() {
        return this.f7640ad;
    }

    public String toString() {
        return "Priority name=" + this.qw + ", value=" + this.f7640ad;
    }

    public ad(int i2, boolean z) {
        this("anonymity", i2, z);
    }
}
