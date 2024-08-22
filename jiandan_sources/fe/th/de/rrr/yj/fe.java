package fe.th.de.rrr.yj;

import fe.th.de.qqq;
import java.util.LinkedHashSet;
import java.util.Set;

public final class fe {
    public final Set<qqq> qw = new LinkedHashSet();

    public synchronized void ad(qqq qqq) {
        this.qw.add(qqq);
    }

    public synchronized boolean de(qqq qqq) {
        return this.qw.contains(qqq);
    }

    public synchronized void qw(qqq qqq) {
        this.qw.remove(qqq);
    }
}
