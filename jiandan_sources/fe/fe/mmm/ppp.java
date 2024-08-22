package fe.fe.mmm;

public class ppp {

    /* renamed from: th  reason: collision with root package name */
    public static final boolean f2082th = (when.qw & true);

    /* renamed from: yj  reason: collision with root package name */
    public static String f2083yj = "ControlData";

    /* renamed from: ad  reason: collision with root package name */
    public final int f2084ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f2085de;

    /* renamed from: fe  reason: collision with root package name */
    public long f2086fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f2087rg;

    public ppp(String str, int i2, int i3) {
        this.qw = str;
        this.f2084ad = i2;
        this.f2085de = i3;
    }

    public boolean ad() {
        int i2 = this.f2087rg;
        return i2 != 0 && i2 == this.f2085de;
    }

    public boolean qw() {
        if (!(this.f2084ad == 0 || this.f2085de == 0)) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (f2082th) {
                "id " + this.qw + " mLimitUnit " + this.f2084ad + " mLimitCnt " + this.f2085de + "mCount =  " + this.f2087rg + " duration " + ((valueOf.longValue() - this.f2086fe) / 1000);
            }
            if (this.f2086fe == 0 || (valueOf.longValue() - this.f2086fe) / 1000 > ((long) this.f2084ad) || this.f2087rg < this.f2085de) {
                if (this.f2086fe == 0) {
                    this.f2086fe = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f2086fe) / 1000 > ((long) this.f2084ad)) {
                    this.f2086fe = valueOf.longValue();
                    this.f2087rg = 0;
                    boolean z = f2082th;
                }
                this.f2087rg++;
            } else {
                boolean z2 = f2082th;
                return true;
            }
        }
        return false;
    }
}
