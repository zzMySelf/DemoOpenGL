package fe.fe.ddd.pf.qw;

import android.content.Context;
import fe.fe.ddd.pf.qw.ad.ad;

public class qw {
    public static volatile boolean qw = false;

    public static void ad(fe.fe.ddd.pf.qw.ad.qw qwVar, Context context) {
        fe.fe.ddd.pf.qw.fe.qw.m73switch().nn(qwVar, context);
    }

    public static void de(ad adVar) {
        fe.fe.ddd.pf.qw.fe.qw.m73switch().mmm(adVar);
    }

    public static void fe(Context context) {
        fe.fe.ddd.pf.qw.fe.qw.m73switch().aaa(context);
    }

    public static void qw() {
        if (!qw) {
            synchronized (qw.class) {
                if (!qw) {
                    fe.fe.ddd.rg.qw.de(new fe.fe.ddd.pf.qw.fe.ad());
                    qw = true;
                }
            }
        }
    }
}
