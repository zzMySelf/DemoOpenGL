package i.qw.x1;

import androidx.core.internal.view.SupportMenu;
import i.qw.x1.tt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class tt<S extends tt<S>> extends yj<S> {

    /* renamed from: fe  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6288fe = AtomicIntegerFieldUpdater.newUpdater(tt.class, "cleanedAndPointers");
    @NotNull
    public volatile /* synthetic */ int cleanedAndPointers;

    /* renamed from: de  reason: collision with root package name */
    public final long f6289de;

    public tt(long j, @Nullable S s, int i2) {
        super(s);
        this.f6289de = j;
        this.cleanedAndPointers = i2 << 16;
    }

    public final boolean ggg() {
        int i2;
        do {
            i2 = this.cleanedAndPointers;
            if (!(i2 != when() || i())) {
                return false;
            }
        } while (!f6288fe.compareAndSet(this, i2, 65536 + i2));
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m422if() {
        return f6288fe.addAndGet(this, SupportMenu.CATEGORY_MASK) == when() && !i();
    }

    public final void ppp() {
        if (f6288fe.incrementAndGet(this) == when() && !i()) {
            o();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final long m423switch() {
        return this.f6289de;
    }

    public abstract int when();

    public boolean yj() {
        return this.cleanedAndPointers == when() && !i();
    }
}
