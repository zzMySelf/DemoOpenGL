package i.qw;

import i.qw.a0;
import java.util.concurrent.locks.LockSupport;
import org.jetbrains.annotations.NotNull;

public abstract class b0 extends z {
    @NotNull
    public abstract Thread j();

    public final void k(long j, @NotNull a0.de deVar) {
        if (k.qw()) {
            if (!(this != m.f6142o)) {
                throw new AssertionError();
            }
        }
        m.f6142o.v(j, deVar);
    }

    public final void l() {
        Thread j = j();
        if (Thread.currentThread() != j) {
            fe qw = rg.qw();
            if (qw == null) {
                LockSupport.unpark(j);
            } else {
                qw.th(j);
            }
        }
    }
}
