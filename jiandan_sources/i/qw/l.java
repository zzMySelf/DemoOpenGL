package i.qw;

import i.qw.x1.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

public final class l {
    @NotNull
    public static final String ad(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String de(@NotNull Continuation<?> continuation) {
        Object obj;
        if (continuation instanceof i) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(continuation + '@' + ad(continuation));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r2 = Result.m1158exceptionOrNullimpl(obj);
        String str = obj;
        if (r2 != null) {
            str = continuation.getClass().getName() + '@' + ad(continuation);
        }
        return (String) str;
    }

    @NotNull
    public static final String qw(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }
}
