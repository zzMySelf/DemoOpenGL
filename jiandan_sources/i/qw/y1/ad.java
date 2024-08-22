package i.qw.y1;

import i.qw.k;
import i.qw.tt;
import i.qw.w0;
import i.qw.x1.b;
import i.qw.x1.rrr;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public static final <R, T> void ad(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        CoroutineContext context;
        Object de2;
        Continuation<? super T> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            context = continuation.getContext();
            de2 = ThreadContextKt.de(context, (Object) null);
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                ThreadContextKt.qw(context, de2);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        }
    }

    public static final <T> void de(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation<? super T> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function1 != null) {
            try {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(invoke));
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    public static final <R, T> void fe(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Continuation<? super T> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function2 != null) {
            try {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(invoke));
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    public static final <T> void qw(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        CoroutineContext context;
        Object de2;
        Continuation<? super T> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            context = continuation.getContext();
            de2 = ThreadContextKt.de(context, (Object) null);
            if (function1 != null) {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                ThreadContextKt.qw(context, de2);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        }
    }

    @Nullable
    public static final <T, R> Object rg(@NotNull rrr<? super T> rrr, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        if (function2 != null) {
            try {
                obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, rrr);
            } catch (Throwable th2) {
                obj = new tt(th2, false, 2, (DefaultConstructorMarker) null);
            }
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            Object R = rrr.R(obj);
            if (R == w0.f6218ad) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            if (!(R instanceof tt)) {
                return w0.uk(R);
            }
            Throwable th3 = ((tt) R).qw;
            Continuation<T> continuation = rrr.f6287yj;
            if (k.fe() && (continuation instanceof CoroutineStackFrame)) {
                th3 = b.o(th3, (CoroutineStackFrame) continuation);
            }
            throw th3;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    public static final <T, R> Object th(@NotNull rrr<? super T> rrr, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        boolean z = false;
        if (function2 != null) {
            try {
                obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, rrr);
            } catch (Throwable th2) {
                obj = new tt(th2, false, 2, (DefaultConstructorMarker) null);
            }
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            Object R = rrr.R(obj);
            if (R == w0.f6218ad) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            if (R instanceof tt) {
                tt ttVar = (tt) R;
                Throwable th3 = ttVar.qw;
                if (!(th3 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th3).coroutine != rrr) {
                    z = true;
                }
                if (z) {
                    Throwable th4 = ttVar.qw;
                    Continuation<T> continuation = rrr.f6287yj;
                    if (k.fe() && (continuation instanceof CoroutineStackFrame)) {
                        th4 = b.o(th4, (CoroutineStackFrame) continuation);
                    }
                    throw th4;
                } else if (obj instanceof tt) {
                    Throwable th5 = ((tt) obj).qw;
                    Continuation<T> continuation2 = rrr.f6287yj;
                    if (k.fe() && (continuation2 instanceof CoroutineStackFrame)) {
                        th5 = b.o(th5, (CoroutineStackFrame) continuation2);
                    }
                    throw th5;
                }
            } else {
                obj = w0.uk(R);
            }
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
