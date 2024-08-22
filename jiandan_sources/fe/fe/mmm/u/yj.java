package fe.fe.mmm.u;

import android.os.Process;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final String f2207ad;

    /* renamed from: de  reason: collision with root package name */
    public String f2208de;
    public final int qw;

    public static final class ad {
        public static final yj qw = new yj();
    }

    public static yj ad() {
        return ad.qw;
    }

    public String de() {
        return this.qw + "-" + this.f2207ad;
    }

    public void fe(String str) {
        this.f2208de = str;
    }

    public String qw() {
        return this.f2208de;
    }

    public yj() {
        this.qw = Process.myPid();
        this.f2207ad = fe.fe.vvv.ad.qw.qw.ad();
    }
}
