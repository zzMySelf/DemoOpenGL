package fe.mmm.qw.a.yj.de;

import java.util.concurrent.Future;

public class rg extends fe {

    /* renamed from: yj  reason: collision with root package name */
    public static volatile rg f7639yj;

    public rg() {
        super(32, "TaskSchedulerSingleIns");
    }

    public static rg th() {
        if (f7639yj == null) {
            synchronized (rg.class) {
                if (f7639yj == null) {
                    f7639yj = new rg();
                    f7639yj.ad();
                }
            }
        }
        return f7639yj;
    }

    public Future<?> rg(ad adVar) {
        if (adVar == null) {
            return null;
        }
        adVar.ggg(1);
        return fe(adVar);
    }
}
