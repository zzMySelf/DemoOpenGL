package i.qw.x1;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.a;
import i.qw.c;
import i.qw.ggg;
import i.qw.k;
import i.qw.l;
import i.qw.l1;
import i.qw.r;
import i.qw.z;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i<T> extends r<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: if  reason: not valid java name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f252if = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    @NotNull
    public volatile /* synthetic */ Object _reusableCancellableContinuation = null;
    @NotNull
    @JvmField

    /* renamed from: i  reason: collision with root package name */
    public final Continuation<T> f6274i;
    @Nullable
    @JvmField

    /* renamed from: o  reason: collision with root package name */
    public Object f6275o = o.qw;
    @NotNull
    @JvmField

    /* renamed from: pf  reason: collision with root package name */
    public final Object f6276pf = ThreadContextKt.ad(getContext());
    @NotNull
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public final CoroutineDispatcher f6277uk;

    public i(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.f6277uk = coroutineDispatcher;
        this.f6274i = continuation;
    }

    @Nullable
    public final Throwable ddd(@NotNull CancellableContinuation<?> cancellableContinuation) {
        c cVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            cVar = o.f6283ad;
            if (obj != cVar) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Inconsistent state ", obj).toString());
                } else if (f252if.compareAndSet(this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!f252if.compareAndSet(this, cVar, cancellableContinuation));
        return null;
    }

    @NotNull
    public Continuation<T> de() {
        return this;
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f6274i;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.f6274i.getContext();
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean ggg(@NotNull Throwable th2) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (Intrinsics.areEqual(obj, (Object) o.f6283ad)) {
                if (f252if.compareAndSet(this, o.f6283ad, th2)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f252if.compareAndSet(this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m418if(@NotNull CoroutineContext coroutineContext, T t) {
        this.f6275o = t;
        this.f6162yj = 1;
        this.f6277uk.dispatchYield(coroutineContext, this);
    }

    @Nullable
    public final ggg<T> pf() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = o.f6283ad;
                return null;
            } else if (obj instanceof ggg) {
                if (f252if.compareAndSet(this, obj, o.f6283ad)) {
                    return (ggg) obj;
                }
            } else if (obj != o.f6283ad && !(obj instanceof Throwable)) {
                throw new IllegalStateException(Intrinsics.stringPlus("Inconsistent state ", obj).toString());
            }
        }
    }

    public void qw(@Nullable Object obj, @NotNull Throwable th2) {
        if (obj instanceof a) {
            ((a) obj).f6077ad.invoke(th2);
        }
    }

    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context;
        Object de2;
        CoroutineContext context2 = this.f6274i.getContext();
        Object fe2 = c.fe(obj, (Function1) null, 1, (Object) null);
        if (this.f6277uk.isDispatchNeeded(context2)) {
            this.f6275o = fe2;
            this.f6162yj = 0;
            this.f6277uk.dispatch(context2, this);
            return;
        }
        boolean qw = k.qw();
        z ad2 = l1.qw.ad();
        if (ad2.b()) {
            this.f6275o = fe2;
            this.f6162yj = 0;
            ad2.eee(this);
            return;
        }
        ad2.tt(true);
        try {
            context = getContext();
            de2 = ThreadContextKt.de(context, this.f6276pf);
            this.f6274i.resumeWith(obj);
            Unit unit = Unit.INSTANCE;
            ThreadContextKt.qw(context, de2);
            do {
            } while (ad2.g());
        } catch (Throwable th2) {
            try {
                th(th2, (Throwable) null);
            } catch (Throwable th3) {
                ad2.xxx(true);
                throw th3;
            }
        }
        ad2.xxx(true);
    }

    @Nullable
    /* renamed from: switch  reason: not valid java name */
    public final ggg<?> m419switch() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof ggg) {
            return (ggg) obj;
        }
        return null;
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f6277uk + StringUtil.ARRAY_ELEMENT_SEPARATOR + l.de(this.f6274i) + ']';
    }

    public final void uk() {
        do {
        } while (this._reusableCancellableContinuation == o.f6283ad);
    }

    public final boolean when(@NotNull ggg<?> ggg) {
        Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ggg) || obj == ggg) {
            return true;
        }
        return false;
    }

    public final void xxx() {
        uk();
        ggg<?> ggg = m419switch();
        if (ggg != null) {
            ggg.ggg();
        }
    }

    @Nullable
    public Object yj() {
        Object obj = this.f6275o;
        if (k.qw()) {
            if (!(obj != o.qw)) {
                throw new AssertionError();
            }
        }
        this.f6275o = o.qw;
        return obj;
    }
}
