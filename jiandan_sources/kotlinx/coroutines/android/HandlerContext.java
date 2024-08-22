package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HandlerContext extends i.qw.t1.qw implements Delay {
    @Nullable
    public volatile HandlerContext _immediate;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f6327ad;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f6328th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final HandlerContext f6329uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f6330yj;

    public static final class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f6331ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ HandlerContext f6332th;

        public ad(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
            this.f6331ad = cancellableContinuation;
            this.f6332th = handlerContext;
        }

        public final void run() {
            this.f6331ad.b(this.f6332th, Unit.INSTANCE);
        }
    }

    public static final class qw implements DisposableHandle {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ HandlerContext f6333ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Runnable f6334th;

        public qw(HandlerContext handlerContext, Runnable runnable) {
            this.f6333ad = handlerContext;
            this.f6334th = runnable;
        }

        public void dispose() {
            this.f6333ad.f6327ad.removeCallbacks(this.f6334th);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerContext(Handler handler, String str, boolean z) {
        super((DefaultConstructorMarker) null);
        HandlerContext handlerContext = null;
        this.f6327ad = handler;
        this.f6328th = str;
        this.f6330yj = z;
        this._immediate = z ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(this.f6327ad, this.f6328th, true);
            this._immediate = handlerContext2;
            Unit unit = Unit.INSTANCE;
        }
        this.f6329uk = handlerContext2;
    }

    public void de(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        ad adVar = new ad(cancellableContinuation, this);
        this.f6327ad.postDelayed(adVar, RangesKt___RangesKt.coerceAtMost(j, (long) DurationKt.MAX_MILLIS));
        cancellableContinuation.i(new HandlerContext$scheduleResumeAfterDelay$1(this, adVar));
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        this.f6327ad.post(runnable);
    }

    @NotNull
    /* renamed from: eee */
    public HandlerContext xxx() {
        return this.f6329uk;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f6327ad == this.f6327ad;
    }

    public int hashCode() {
        return System.identityHashCode(this.f6327ad);
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return !this.f6330yj || !Intrinsics.areEqual((Object) Looper.myLooper(), (Object) this.f6327ad.getLooper());
    }

    @NotNull
    public String toString() {
        String mmm = mmm();
        if (mmm != null) {
            return mmm;
        }
        String str = this.f6328th;
        if (str == null) {
            str = this.f6327ad.toString();
        }
        return this.f6330yj ? Intrinsics.stringPlus(str, ".immediate") : str;
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        this.f6327ad.postDelayed(runnable, RangesKt___RangesKt.coerceAtMost(j, (long) DurationKt.MAX_MILLIS));
        return new qw(this, runnable);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
