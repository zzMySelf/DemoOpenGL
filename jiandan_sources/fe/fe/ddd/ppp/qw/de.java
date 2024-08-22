package fe.fe.ddd.ppp.qw;

import android.content.Context;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import fe.p013if.de.qw.ad;

public class de implements ILooperMonitor {

    /* renamed from: de  reason: collision with root package name */
    public static ad f1553de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile boolean f1554fe = false;

    /* renamed from: ad  reason: collision with root package name */
    public fe.p013if.de.qw.de f1555ad;
    public boolean qw = false;

    public static void fe(Context context) {
        if (!f1554fe) {
            f1554fe = true;
            Track.fe().uk(context);
        }
    }

    public void ad(Context context, int i2) {
        if (f1553de == null) {
            f1553de = new ad();
        }
        ad.fe(context, f1553de, i2);
        fe.p013if.de.qw.de.o(ad.de());
        fe.p013if.de.qw.de rg2 = fe.p013if.de.qw.de.rg();
        this.f1555ad = rg2;
        rg2.ad(ad.de());
        de();
        fe(context);
    }

    public final void de() {
        if (!this.qw) {
            this.qw = true;
            f1553de.m75switch(this.f1555ad.yj());
        }
    }

    public boolean qw() {
        return rg.de().ad();
    }
}
