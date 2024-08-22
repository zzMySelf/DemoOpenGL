package fe.fe.o.fe.qw.de;

import com.baidu.down.a.h;

public class th implements h {
    public final /* synthetic */ rg qw;

    public th(rg rgVar) {
        this.qw = rgVar;
    }

    public void a(boolean z) {
        if (z) {
            this.qw.ppp();
        } else {
            int unused = this.qw.nn = 3;
        }
        synchronized (this.qw.f2552ad.f2532uk) {
            this.qw.f2552ad.f2532uk.notify();
        }
    }
}
