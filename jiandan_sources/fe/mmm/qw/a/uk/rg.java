package fe.mmm.qw.a.uk;

import java.util.concurrent.Future;

public abstract class rg extends ad {
    public volatile Runnable ggg;
    public volatile Future<?> vvv;

    public rg(String str) {
        super(1, 5000, true, str);
    }

    public synchronized boolean ddd(boolean z) {
        ad();
        if (this.vvv != null) {
            if (!this.vvv.isCancelled()) {
                return this.vvv.cancel(z);
            }
        } else if (this.ggg != null) {
            fe.qw().removeCallbacks(this.ggg);
            return true;
        }
        return false;
    }

    public synchronized void mmm() {
        this.vvv = fe.mmm.qw.a.yj.de.rg.th().rg(this);
    }

    public void nn() {
        ddd(true);
    }
}
