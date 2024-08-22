package i.qw.z1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe extends ExecutorCoroutineDispatcher implements TaskContext, Executor {

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6302o = AtomicIntegerFieldUpdater.newUpdater(fe.class, "inFlightTasks");
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ad f6303ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f6304i = new ConcurrentLinkedQueue<>();
    @NotNull
    public volatile /* synthetic */ int inFlightTasks = 0;

    /* renamed from: th  reason: collision with root package name */
    public final int f6305th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f6306uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final String f6307yj;

    public fe(@NotNull ad adVar, int i2, @Nullable String str, int i3) {
        this.f6303ad = adVar;
        this.f6305th = i2;
        this.f6307yj = str;
        this.f6306uk = i3;
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        mmm(runnable, false);
    }

    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        mmm(runnable, true);
    }

    public void execute(@NotNull Runnable runnable) {
        mmm(runnable, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mmm(java.lang.Runnable r3, boolean r4) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f6302o
            int r0 = r0.incrementAndGet(r2)
            int r1 = r2.f6305th
            if (r0 > r1) goto L_0x0010
            i.qw.z1.ad r0 = r2.f6303ad
            r0.qqq(r3, r2, r4)
            return
        L_0x0010:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r2.f6304i
            r0.add(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = f6302o
            int r3 = r3.decrementAndGet(r2)
            int r0 = r2.f6305th
            if (r3 < r0) goto L_0x0020
            return
        L_0x0020:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r3 = r2.f6304i
            java.lang.Object r3 = r3.poll()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            if (r3 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.z1.fe.mmm(java.lang.Runnable, boolean):void");
    }

    public void ppp() {
        Runnable poll = this.f6304i.poll();
        if (poll != null) {
            this.f6303ad.qqq(poll, this, true);
            return;
        }
        f6302o.decrementAndGet(this);
        Runnable poll2 = this.f6304i.poll();
        if (poll2 != null) {
            mmm(poll2, true);
        }
    }

    @NotNull
    public String toString() {
        String str = this.f6307yj;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f6303ad + ']';
    }

    public int vvv() {
        return this.f6306uk;
    }

    @NotNull
    public Executor xxx() {
        return this;
    }
}
