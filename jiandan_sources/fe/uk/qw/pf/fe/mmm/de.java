package fe.uk.qw.pf.fe.mmm;

import fe.uk.qw.pf.fe.mmm.pf;
import fe.uk.qw.vvv.o;
import java.util.Queue;

public abstract class de<T extends pf> {
    public final Queue<T> qw = o.rg(20);

    public T ad() {
        T t = (pf) this.qw.poll();
        return t == null ? qw() : t;
    }

    public void de(T t) {
        if (this.qw.size() < 20) {
            this.qw.offer(t);
        }
    }

    public abstract T qw();
}
