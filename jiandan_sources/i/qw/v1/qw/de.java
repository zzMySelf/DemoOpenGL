package i.qw.v1.qw;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ConcurrentWeakMap<qw<?>, Boolean> f6210ad = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final ConcurrentWeakMap<CoroutineStackFrame, ad> f6211de = new ConcurrentWeakMap<>(true);
    public static volatile int installations;
    @NotNull
    public static final de qw = new de();

    public static final class qw<T> implements Continuation<T>, CoroutineStackFrame {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final Continuation<T> f6212ad;
        @NotNull
        @JvmField

        /* renamed from: th  reason: collision with root package name */
        public final ad f6213th;
        @Nullable

        /* renamed from: yj  reason: collision with root package name */
        public final CoroutineStackFrame f6214yj;

        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.f6214yj;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.f6212ad.getContext();
        }

        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.f6214yj;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        public void resumeWith(@NotNull Object obj) {
            de.qw.th(this);
            this.f6212ad.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.f6212ad.toString();
        }
    }

    static {
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        new ReentrantReadWriteLock();
        qw.fe();
        AtomicLongFieldUpdater.newUpdater(fe.class, "sequenceNumber");
    }

    public final Function1<Boolean, Unit> fe() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m1155constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (Result.m1161isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final boolean rg(qw<?> qwVar) {
        CoroutineContext ad2 = qwVar.f6213th.ad();
        Job job = ad2 == null ? null : (Job) ad2.get(Job.f6325fe);
        if (job == null || !job.nn()) {
            return false;
        }
        f6210ad.remove(qwVar);
        return true;
    }

    public final void th(qw<?> qwVar) {
        f6210ad.remove(qwVar);
        CoroutineStackFrame de2 = qwVar.f6213th.de();
        CoroutineStackFrame yj2 = de2 == null ? null : yj(de2);
        if (yj2 != null) {
            f6211de.remove(yj2);
        }
    }

    public final CoroutineStackFrame yj(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }
}
