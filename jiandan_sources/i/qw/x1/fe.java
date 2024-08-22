package i.qw.x1;

import i.qw.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class fe<T> extends qqq {
    public static final /* synthetic */ AtomicReferenceFieldUpdater qw = AtomicReferenceFieldUpdater.newUpdater(fe.class, Object.class, "_consensus");
    @NotNull
    public volatile /* synthetic */ Object _consensus = de.qw;

    @Nullable
    public final Object de(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == de.qw) {
            obj2 = rg(i(obj));
        }
        fe(obj, obj2);
        return obj2;
    }

    public abstract void fe(T t, @Nullable Object obj);

    @Nullable
    public abstract Object i(T t);

    @NotNull
    public fe<?> qw() {
        return this;
    }

    @Nullable
    public final Object rg(@Nullable Object obj) {
        if (k.qw()) {
            if (!(obj != de.qw)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = de.qw;
        if (obj2 != obj3) {
            return obj2;
        }
        if (qw.compareAndSet(this, obj3, obj)) {
            return obj;
        }
        return this._consensus;
    }

    @Nullable
    public final Object th() {
        return this._consensus;
    }

    public final boolean uk() {
        return this._consensus != de.qw;
    }

    public long yj() {
        return 0;
    }
}
