package fe.fe.mmm;

public class e {

    /* renamed from: ad  reason: collision with root package name */
    public int f2013ad;

    /* renamed from: de  reason: collision with root package name */
    public long f2014de;
    public int qw;

    public static final class ad {
        public static final e qw = new e();
    }

    public static e de() {
        return ad.qw;
    }

    public boolean ad() {
        return this.f2013ad > 0 && System.currentTimeMillis() < this.f2014de;
    }

    public boolean qw() {
        return this.qw > 0 && System.currentTimeMillis() < this.f2014de;
    }

    public e() {
        this.qw = 0;
        this.f2013ad = 0;
        this.f2014de = 0;
        k qw2 = k.qw();
        long de2 = qw2.de("ubc_log_verify_timeout", 0);
        if (System.currentTimeMillis() > de2) {
            qw2.rg("ubc_log_verify_pvall", 0);
            qw2.rg("ubc_log_verify_uvall", 0);
            qw2.th("ubc_log_verify_timeout", 0);
            return;
        }
        this.qw = qw2.ad("ubc_log_verify_pvall", 0);
        this.f2013ad = qw2.ad("ubc_log_verify_uvall", 0);
        this.f2014de = de2;
    }
}
