package i.qw.x1;

import i.qw.z0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaa extends z0 implements Delay {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final Throwable f6249ad;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f6250th;

    public aaa(@Nullable Throwable th2, @Nullable String str) {
        this.f6249ad = th2;
        this.f6250th = str;
    }

    public /* bridge */ /* synthetic */ void de(long j, CancellableContinuation cancellableContinuation) {
        rrr(j, cancellableContinuation);
        throw null;
    }

    public /* bridge */ /* synthetic */ void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        qqq(coroutineContext, runnable);
        throw null;
    }

    public final Void eee() {
        String stringPlus;
        if (this.f6249ad != null) {
            String str = this.f6250th;
            String str2 = "";
            if (!(str == null || (stringPlus = Intrinsics.stringPlus(". ", str)) == null)) {
                str2 = stringPlus;
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Module with the Main dispatcher had failed to initialize", str2), this.f6249ad);
        }
        mmm.de();
        throw null;
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        eee();
        throw null;
    }

    @NotNull
    public Void qqq(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        eee();
        throw null;
    }

    @NotNull
    public Void rrr(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        eee();
        throw null;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th2 = this.f6249ad;
        sb.append(th2 != null ? Intrinsics.stringPlus(", cause=", th2) : "");
        sb.append(']');
        return sb.toString();
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        eee();
        throw null;
    }

    @NotNull
    public z0 xxx() {
        return this;
    }
}
