package i.qw.x1;

import i.qw.k;
import i.qw.x1.yj;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class yj<N extends yj<N>> {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6291ad;
    public static final /* synthetic */ AtomicReferenceFieldUpdater qw;
    @NotNull
    public volatile /* synthetic */ Object _next = null;
    @NotNull
    public volatile /* synthetic */ Object _prev;

    static {
        Class<Object> cls = Object.class;
        Class<yj> cls2 = yj.class;
        qw = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f6291ad = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
    }

    public yj(@Nullable N n) {
        this._prev = n;
    }

    public final void ad() {
        f6291ad.lazySet(this, (Object) null);
    }

    public final N de() {
        N th2 = th();
        while (th2 != null && th2.yj()) {
            th2 = (yj) th2._prev;
        }
        return th2;
    }

    @Nullable
    public final N fe() {
        N qw2 = rg();
        if (qw2 == th.qw) {
            return null;
        }
        return (yj) qw2;
    }

    public final boolean i() {
        return fe() == null;
    }

    public final void o() {
        if (k.qw() && !yj()) {
            throw new AssertionError();
        } else if (!k.qw() || (!i())) {
            while (true) {
                yj de2 = de();
                yj uk2 = uk();
                uk2._prev = de2;
                if (de2 != null) {
                    de2._next = uk2;
                }
                if (!uk2.yj() && (de2 == null || !de2.yj())) {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final boolean pf(@NotNull N n) {
        return qw.compareAndSet(this, (Object) null, n);
    }

    public final Object rg() {
        return this._next;
    }

    @Nullable
    public final N th() {
        return (yj) this._prev;
    }

    public final N uk() {
        if (!k.qw() || (!i())) {
            N fe2 = fe();
            Intrinsics.checkNotNull(fe2);
            while (fe2.yj()) {
                fe2 = fe2.fe();
                Intrinsics.checkNotNull(fe2);
            }
            return fe2;
        }
        throw new AssertionError();
    }

    public abstract boolean yj();
}
