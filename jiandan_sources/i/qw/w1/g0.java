package i.qw.w1;

import i.qw.ggg;
import i.qw.k;
import i.qw.w1.i0.ad;
import i.qw.w1.i0.de;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g0 extends de<StateFlowImpl<?>> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater qw = AtomicReferenceFieldUpdater.newUpdater(g0.class, Object.class, "_state");
    @NotNull
    public volatile /* synthetic */ Object _state = null;

    /* renamed from: de */
    public boolean qw(@NotNull StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = f0.qw;
        return true;
    }

    @Nullable
    public final Object fe(@NotNull Continuation<? super Unit> continuation) {
        boolean z = true;
        ggg ggg = new ggg(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        ggg.eee();
        if (!k.qw() || Boxing.boxBoolean(!(this._state instanceof ggg)).booleanValue()) {
            if (!qw.compareAndSet(this, f0.qw, ggg)) {
                if (k.qw()) {
                    if (this._state != f0.f6228ad) {
                        z = false;
                    }
                    if (!Boxing.boxBoolean(z).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ggg.resumeWith(Result.m1155constructorimpl(unit));
            }
            Object mmm = ggg.mmm();
            if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
        }
        throw new AssertionError();
    }

    @NotNull
    /* renamed from: rg */
    public Continuation<Unit>[] ad(@NotNull StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return ad.qw;
    }

    public final void th() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != f0.f6228ad) {
                if (obj == f0.qw) {
                    if (qw.compareAndSet(this, obj, f0.f6228ad)) {
                        return;
                    }
                } else if (qw.compareAndSet(this, obj, f0.qw)) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion = Result.Companion;
                    ((ggg) obj).resumeWith(Result.m1155constructorimpl(unit));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean yj() {
        Object andSet = qw.getAndSet(this, f0.qw);
        Intrinsics.checkNotNull(andSet);
        if (k.qw() && !(!(andSet instanceof ggg))) {
            throw new AssertionError();
        } else if (andSet == f0.f6228ad) {
            return true;
        } else {
            return false;
        }
    }
}
