package i.qw;

import i.qw.x1.ddd;
import i.qw.x1.j;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class a0 extends b0 implements Delay {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6078i;

    /* renamed from: uk  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6079uk;
    @NotNull
    public volatile /* synthetic */ Object _delayed = null;
    @NotNull
    public volatile /* synthetic */ int _isCompleted = 0;
    @NotNull
    public volatile /* synthetic */ Object _queue = null;

    public static final class ad extends de {
        @NotNull

        /* renamed from: uk  reason: collision with root package name */
        public final Runnable f6080uk;

        public ad(long j, @NotNull Runnable runnable) {
            super(j);
            this.f6080uk = runnable;
        }

        public void run() {
            this.f6080uk.run();
        }

        @NotNull
        public String toString() {
            return Intrinsics.stringPlus(super.toString(), this.f6080uk);
        }
    }

    public static abstract class de implements Runnable, Comparable<de>, DisposableHandle, ThreadSafeHeapNode {
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public long f6081ad;
        @Nullable

        /* renamed from: th  reason: collision with root package name */
        public Object f6082th;

        /* renamed from: yj  reason: collision with root package name */
        public int f6083yj = -1;

        public de(long j) {
            this.f6081ad = j;
        }

        @Nullable
        public j<?> ad() {
            Object obj = this.f6082th;
            if (obj instanceof j) {
                return (j) obj;
            }
            return null;
        }

        public final synchronized void dispose() {
            Object obj = this.f6082th;
            if (obj != d0.qw) {
                fe feVar = obj instanceof fe ? (fe) obj : null;
                if (feVar != null) {
                    feVar.yj(this);
                }
                this.f6082th = d0.qw;
            }
        }

        public int getIndex() {
            return this.f6083yj;
        }

        public final boolean i(long j) {
            return j - this.f6081ad >= 0;
        }

        public void qw(@Nullable j<?> jVar) {
            if (this.f6082th != d0.qw) {
                this.f6082th = jVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public void rg(int i2) {
            this.f6083yj = i2;
        }

        /* renamed from: th */
        public int compareTo(@NotNull de deVar) {
            int i2 = ((this.f6081ad - deVar.f6081ad) > 0 ? 1 : ((this.f6081ad - deVar.f6081ad) == 0 ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f6081ad + ']';
        }

        public final synchronized int uk(long j, @NotNull fe feVar, @NotNull a0 a0Var) {
            if (this.f6082th == d0.qw) {
                return 2;
            }
            synchronized (feVar) {
                de deVar = (de) feVar.ad();
                if (a0Var.nn()) {
                    return 1;
                }
                if (deVar == null) {
                    feVar.f6084ad = j;
                } else {
                    long j2 = deVar.f6081ad;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - feVar.f6084ad > 0) {
                        feVar.f6084ad = j;
                    }
                }
                if (this.f6081ad - feVar.f6084ad < 0) {
                    this.f6081ad = feVar.f6084ad;
                }
                feVar.qw(this);
                return 0;
            }
        }
    }

    public static final class fe extends j<de> {
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public long f6084ad;

        public fe(long j) {
            this.f6084ad = j;
        }
    }

    public final class qw extends de {
        @NotNull

        /* renamed from: uk  reason: collision with root package name */
        public final CancellableContinuation<Unit> f6086uk;

        public qw(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.f6086uk = cancellableContinuation;
        }

        public void run() {
            this.f6086uk.b(a0.this, Unit.INSTANCE);
        }

        @NotNull
        public String toString() {
            return Intrinsics.stringPlus(super.toString(), this.f6086uk);
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<a0> cls2 = a0.class;
        f6079uk = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        f6078i = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long d() {
        /*
            r9 = this;
            boolean r0 = r9.g()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            i.qw.a0$fe r0 = (i.qw.a0.fe) r0
            if (r0 == 0) goto L_0x004d
            boolean r3 = r0.fe()
            if (r3 != 0) goto L_0x004d
            i.qw.fe r3 = i.qw.rg.qw()
            if (r3 != 0) goto L_0x0020
            long r3 = java.lang.System.nanoTime()
            goto L_0x0024
        L_0x0020:
            long r3 = r3.qw()
        L_0x0024:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.ad()     // Catch:{ all -> 0x004a }
            r6 = 0
            if (r5 != 0) goto L_0x002e
            monitor-exit(r0)
            goto L_0x0045
        L_0x002e:
            i.qw.a0$de r5 = (i.qw.a0.de) r5     // Catch:{ all -> 0x004a }
            boolean r7 = r5.i(r3)     // Catch:{ all -> 0x004a }
            r8 = 0
            if (r7 == 0) goto L_0x003c
            boolean r5 = r9.r(r5)     // Catch:{ all -> 0x004a }
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            if (r5 == 0) goto L_0x0044
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.uk(r8)     // Catch:{ all -> 0x004a }
            r6 = r5
        L_0x0044:
            monitor-exit(r0)
        L_0x0045:
            i.qw.a0$de r6 = (i.qw.a0.de) r6
            if (r6 != 0) goto L_0x0024
            goto L_0x004d
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x004d:
            java.lang.Runnable r0 = r9.p()
            if (r0 == 0) goto L_0x0057
            r0.run()
            return r1
        L_0x0057:
            long r0 = r9.rrr()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.a0.d():long");
    }

    public void de(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        long fe2 = d0.fe(j);
        if (fe2 < DurationKt.MAX_MILLIS) {
            fe qw2 = rg.qw();
            long nanoTime = qw2 == null ? System.nanoTime() : qw2.qw();
            qw qwVar = new qw(fe2 + nanoTime, cancellableContinuation);
            xxx.qw(cancellableContinuation, qwVar);
            v(nanoTime, qwVar);
        }
    }

    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        q(runnable);
    }

    public final void n() {
        if (!k.qw() || nn()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (f6079uk.compareAndSet(this, (Object) null, d0.f6116ad)) {
                        return;
                    }
                } else if (obj instanceof ddd) {
                    ((ddd) obj).fe();
                    return;
                } else if (obj != d0.f6116ad) {
                    ddd ddd = new ddd(8, true);
                    if (obj != null) {
                        ddd.qw((Runnable) obj);
                        if (f6079uk.compareAndSet(this, obj, ddd)) {
                            return;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean nn() {
        return this._isCompleted;
    }

    public final Runnable p() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof ddd) {
                if (obj != null) {
                    ddd ddd = (ddd) obj;
                    Object o2 = ddd.o();
                    if (o2 != ddd.f6254uk) {
                        return (Runnable) o2;
                    }
                    f6079uk.compareAndSet(this, obj, ddd.i());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
            } else if (obj == d0.f6116ad) {
                return null;
            } else {
                if (f6079uk.compareAndSet(this, obj, (Object) null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
            }
        }
    }

    public final void q(@NotNull Runnable runnable) {
        if (r(runnable)) {
            l();
        } else {
            m.f6142o.q(runnable);
        }
    }

    public final boolean r(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (nn()) {
                return false;
            }
            if (obj == null) {
                if (f6079uk.compareAndSet(this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof ddd) {
                if (obj != null) {
                    ddd ddd = (ddd) obj;
                    int qw2 = ddd.qw(runnable);
                    if (qw2 == 0) {
                        return true;
                    }
                    if (qw2 == 1) {
                        f6079uk.compareAndSet(this, obj, ddd.i());
                    } else if (qw2 == 2) {
                        return false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
            } else if (obj == d0.f6116ad) {
                return false;
            } else {
                ddd ddd2 = new ddd(8, true);
                if (obj != null) {
                    ddd2.qw((Runnable) obj);
                    ddd2.qw(runnable);
                    if (f6079uk.compareAndSet(this, obj, ddd2)) {
                        return true;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
            }
        }
    }

    public long rrr() {
        if (super.rrr() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof ddd) {
                if (!((ddd) obj).yj()) {
                    return 0;
                }
            } else if (obj == d0.f6116ad) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        fe feVar = (fe) this._delayed;
        de deVar = feVar == null ? null : (de) feVar.rg();
        if (deVar == null) {
            return Long.MAX_VALUE;
        }
        long j = deVar.f6081ad;
        fe qw2 = rg.qw();
        return RangesKt___RangesKt.coerceAtLeast(j - (qw2 == null ? System.nanoTime() : qw2.qw()), 0);
    }

    public boolean s() {
        if (!c()) {
            return false;
        }
        fe feVar = (fe) this._delayed;
        if (feVar != null && !feVar.fe()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof ddd) {
                return ((ddd) obj).yj();
            }
            if (obj == d0.f6116ad) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void shutdown() {
        l1.qw.de();
        y(true);
        n();
        do {
        } while (d() <= 0);
        t();
    }

    public final void t() {
        fe qw2 = rg.qw();
        long nanoTime = qw2 == null ? System.nanoTime() : qw2.qw();
        while (true) {
            fe feVar = (fe) this._delayed;
            de deVar = feVar == null ? null : (de) feVar.i();
            if (deVar != null) {
                k(nanoTime, deVar);
            } else {
                return;
            }
        }
    }

    public final void u() {
        this._queue = null;
        this._delayed = null;
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.qw.qw(this, j, runnable, coroutineContext);
    }

    public final void v(long j, @NotNull de deVar) {
        int w = w(j, deVar);
        if (w != 0) {
            if (w == 1) {
                k(j, deVar);
            } else if (w != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (z(deVar)) {
            l();
        }
    }

    public final int w(long j, de deVar) {
        if (nn()) {
            return 1;
        }
        fe feVar = (fe) this._delayed;
        if (feVar == null) {
            f6078i.compareAndSet(this, (Object) null, new fe(j));
            feVar = (fe) this._delayed;
            Intrinsics.checkNotNull(feVar);
        }
        return deVar.uk(j, feVar, this);
    }

    @NotNull
    public final DisposableHandle x(long j, @NotNull Runnable runnable) {
        long fe2 = d0.fe(j);
        if (fe2 >= DurationKt.MAX_MILLIS) {
            return b1.f6105ad;
        }
        fe qw2 = rg.qw();
        long nanoTime = qw2 == null ? System.nanoTime() : qw2.qw();
        ad adVar = new ad(fe2 + nanoTime, runnable);
        v(nanoTime, adVar);
        return adVar;
    }

    public final void y(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    public final boolean z(de deVar) {
        fe feVar = (fe) this._delayed;
        return (feVar == null ? null : (de) feVar.rg()) == deVar;
    }
}
