package i.qw.x1;

import i.qw.k;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class j<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    @NotNull
    public volatile /* synthetic */ int _size = 0;
    @Nullable
    public T[] qw;

    @Nullable
    @PublishedApi
    public final T ad() {
        T[] tArr = this.qw;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int de() {
        return this._size;
    }

    public final boolean fe() {
        return de() == 0;
    }

    @Nullable
    public final T i() {
        T uk2;
        synchronized (this) {
            uk2 = de() > 0 ? uk(0) : null;
        }
        return uk2;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m420if(int i2) {
        while (i2 > 0) {
            T[] tArr = this.qw;
            Intrinsics.checkNotNull(tArr);
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i2];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                m421switch(i2, i3);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public final void o(int i2) {
        this._size = i2;
    }

    public final void pf(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 < de()) {
                T[] tArr = this.qw;
                Intrinsics.checkNotNull(tArr);
                int i4 = i3 + 1;
                if (i4 < de()) {
                    T t = tArr[i4];
                    Intrinsics.checkNotNull(t);
                    T t2 = tArr[i3];
                    Intrinsics.checkNotNull(t2);
                    if (((Comparable) t).compareTo(t2) < 0) {
                        i3 = i4;
                    }
                }
                T t3 = tArr[i2];
                Intrinsics.checkNotNull(t3);
                T t4 = tArr[i3];
                Intrinsics.checkNotNull(t4);
                if (((Comparable) t3).compareTo(t4) > 0) {
                    m421switch(i2, i3);
                    i2 = i3;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @PublishedApi
    public final void qw(@NotNull T t) {
        if (k.qw()) {
            if (!(t.ad() == null)) {
                throw new AssertionError();
            }
        }
        t.qw(this);
        ThreadSafeHeapNode[] th2 = th();
        int de2 = de();
        o(de2 + 1);
        th2[de2] = t;
        t.rg(de2);
        m420if(de2);
    }

    @Nullable
    public final T rg() {
        T ad2;
        synchronized (this) {
            ad2 = ad();
        }
        return ad2;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m421switch(int i2, int i3) {
        T[] tArr = this.qw;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i3];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i2];
        Intrinsics.checkNotNull(t2);
        tArr[i2] = t;
        tArr[i3] = t2;
        t.rg(i2);
        t2.rg(i3);
    }

    public final T[] th() {
        T[] tArr = this.qw;
        if (tArr == null) {
            T[] tArr2 = new ThreadSafeHeapNode[4];
            this.qw = tArr2;
            return tArr2;
        } else if (de() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, de() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.qw = tArr3;
            return tArr3;
        }
    }

    @NotNull
    @PublishedApi
    public final T uk(int i2) {
        boolean z = false;
        if (k.qw()) {
            if (!(de() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.qw;
        Intrinsics.checkNotNull(tArr);
        o(de() - 1);
        if (i2 < de()) {
            m421switch(i2, de());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i3];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m421switch(i2, i3);
                    m420if(i3);
                }
            }
            pf(i2);
        }
        T t3 = tArr[de()];
        Intrinsics.checkNotNull(t3);
        if (k.qw()) {
            if (t3.ad() == this) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t3.qw((j<?>) null);
        t3.rg(-1);
        tArr[de()] = null;
        return t3;
    }

    public final boolean yj(@NotNull T t) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (t.ad() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (k.qw()) {
                    if (index >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                uk(index);
            }
        }
        return z;
    }
}
