package i.qw.z1;

import i.qw.m;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

public class ad extends ExecutorCoroutineDispatcher {

    /* renamed from: ad  reason: collision with root package name */
    public final int f6297ad;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public CoroutineScheduler f6298i;

    /* renamed from: th  reason: collision with root package name */
    public final int f6299th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final String f6300uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f6301yj;

    public ad(int i2, int i3, long j, @NotNull String str) {
        this.f6297ad = i2;
        this.f6299th = i3;
        this.f6301yj = j;
        this.f6300uk = str;
        this.f6298i = mmm();
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.yj(this.f6298i, runnable, (TaskContext) null, false, 6, (Object) null);
        } catch (RejectedExecutionException unused) {
            m.f6142o.dispatch(coroutineContext, runnable);
        }
    }

    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.yj(this.f6298i, runnable, (TaskContext) null, true, 2, (Object) null);
        } catch (RejectedExecutionException unused) {
            m.f6142o.dispatchYield(coroutineContext, runnable);
        }
    }

    public final CoroutineScheduler mmm() {
        return new CoroutineScheduler(this.f6297ad, this.f6299th, this.f6301yj, this.f6300uk);
    }

    public final void qqq(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        try {
            this.f6298i.th(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            m.f6142o.q(this.f6298i.fe(runnable, taskContext));
        }
    }

    @NotNull
    public Executor xxx() {
        return this.f6298i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? o.f6309ad : i2, (i4 & 2) != 0 ? o.f6310de : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public ad(int i2, int i3, @NotNull String str) {
        this(i2, i3, o.f6311fe, str);
    }
}
