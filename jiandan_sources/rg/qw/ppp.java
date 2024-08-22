package rg.qw;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ppp {

    /* renamed from: ad  reason: collision with root package name */
    public static Executor f10445ad;
    public static ppp qw;

    public static ppp ad() {
        if (qw == null) {
            synchronized (ppp.class) {
                if (qw == null) {
                    qw = new ppp();
                    f10445ad = Executors.newFixedThreadPool(1);
                }
            }
        }
        return qw;
    }

    public void qw(Runnable runnable) {
        if (runnable != null) {
            try {
                f10445ad.execute(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
