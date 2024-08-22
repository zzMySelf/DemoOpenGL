package i.qw;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class de<T> extends v0 implements Job, Continuation<T>, CoroutineScope {
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final CoroutineContext f6119th;

    public de(@NotNull CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            L((Job) coroutineContext.get(Job.f6325fe));
        }
        this.f6119th = coroutineContext.plus(this);
    }

    public final void K(@NotNull Throwable th2) {
        f.qw(this.f6119th, th2);
    }

    @NotNull
    public String T() {
        String ad2 = d.ad(this.f6119th);
        if (ad2 == null) {
            return super.T();
        }
        return '\"' + ad2 + "\":" + super.T();
    }

    public final void Y(@Nullable Object obj) {
        if (obj instanceof tt) {
            tt ttVar = (tt) obj;
            r0(ttVar.qw, ttVar.qw());
            return;
        }
        s0(obj);
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.f6119th;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f6119th;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public void q0(@Nullable Object obj) {
        m(obj);
    }

    public void r0(@NotNull Throwable th2, boolean z) {
    }

    public final void resumeWith(@NotNull Object obj) {
        Object R = R(c.fe(obj, (Function1) null, 1, (Object) null));
        if (R != w0.f6218ad) {
            q0(R);
        }
    }

    public void s0(T t) {
    }

    public final <R> void t0(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r, this);
    }

    @NotNull
    public String v() {
        return Intrinsics.stringPlus(l.qw(this), " was cancelled");
    }
}
