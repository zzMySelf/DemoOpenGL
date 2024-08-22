package i.qw.x1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class xxx<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater qw = AtomicReferenceFieldUpdater.newUpdater(xxx.class, Object.class, "_cur");
    @NotNull
    public volatile /* synthetic */ Object _cur;

    public xxx(boolean z) {
        this._cur = new ddd(8, z);
    }

    public final void ad() {
        while (true) {
            ddd ddd = (ddd) this._cur;
            if (!ddd.fe()) {
                qw.compareAndSet(this, ddd, ddd.i());
            } else {
                return;
            }
        }
    }

    public final int de() {
        return ((ddd) this._cur).th();
    }

    @Nullable
    public final E fe() {
        while (true) {
            ddd ddd = (ddd) this._cur;
            E o2 = ddd.o();
            if (o2 != ddd.f6254uk) {
                return o2;
            }
            qw.compareAndSet(this, ddd, ddd.i());
        }
    }

    public final boolean qw(@NotNull E e) {
        while (true) {
            ddd ddd = (ddd) this._cur;
            int qw2 = ddd.qw(e);
            if (qw2 == 0) {
                return true;
            }
            if (qw2 == 1) {
                qw.compareAndSet(this, ddd, ddd.i());
            } else if (qw2 == 2) {
                return false;
            }
        }
    }
}
