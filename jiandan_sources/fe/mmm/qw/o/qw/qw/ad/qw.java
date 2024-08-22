package fe.mmm.qw.o.qw.qw.ad;

import android.app.Activity;
import android.os.SystemClock;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public long f8167ad;

    /* renamed from: de  reason: collision with root package name */
    public long f8168de;

    /* renamed from: fe  reason: collision with root package name */
    public long f8169fe;
    public boolean qw;

    public void ad(String str) {
    }

    public void de(Activity activity) {
    }

    public void fe() {
        if (this.qw) {
            long j = this.f8168de;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = this.f8169fe;
            if (j2 <= 0) {
                j2 = this.f8167ad;
            }
            this.f8168de = j + (elapsedRealtime - j2);
        }
    }

    public void i(String str) {
    }

    public void qw() {
    }

    public void rg() {
        if (this.qw) {
            this.f8169fe = SystemClock.elapsedRealtime();
        }
    }

    public void th() {
    }

    public void uk() {
    }

    public void yj() {
    }
}
