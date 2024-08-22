package fe.rg.qw.o.fe.mmm;

import fe.rg.qw.ggg.i;
import fe.rg.qw.o.fe.mmm.pf;
import java.util.Queue;

public abstract class de<T extends pf> {
    public final Queue<T> qw = i.rg(20);

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
