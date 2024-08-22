package i.qw.x1;

import i.qw.k;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.internal.ExceptionsConstuctorKt;
import org.jetbrains.annotations.NotNull;

public final class b {

    /* renamed from: ad  reason: collision with root package name */
    public static final String f6251ad;
    public static final String qw;

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1158exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        qw = (String) obj;
        try {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m1155constructorimpl(Class.forName("i.qw.x1.b").getCanonicalName());
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.m1155constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m1158exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f6251ad = (String) obj2;
    }

    @NotNull
    public static final StackTraceElement ad(@NotNull String str) {
        return new StackTraceElement(Intrinsics.stringPlus("\b\b\b(", str), "\b", "\b", -1);
    }

    public static final <E extends Throwable> Pair<E, StackTraceElement[]> de(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !Intrinsics.areEqual((Object) cause.getClass(), (Object) e.getClass())) {
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (uk(stackTrace[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return TuplesKt.to(cause, stackTrace);
        }
        return TuplesKt.to(e, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E fe(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(ad("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int yj2 = yj(stackTrace, qw);
        int i2 = 0;
        if (yj2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + yj2)];
        if (yj2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                stackTraceElementArr[i3] = stackTrace[i3];
                if (i4 >= yj2) {
                    break;
                }
                i3 = i4;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i5 = i2 + 1;
            stackTraceElementArr[i2 + yj2] = it.next();
            i2 = i5;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (uk(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i3 <= length2) {
            while (true) {
                int i4 = length2 - 1;
                if (th(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i3) {
                    length2 = i4;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static final <E extends Throwable> E m411if(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int yj2 = yj(stackTrace, f6251ad);
        int i2 = yj2 + 1;
        int yj3 = yj(stackTrace, qw);
        int i3 = (length - yj2) - (yj3 == -1 ? 0 : length - yj3);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 == 0) {
                stackTraceElement = ad("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i2 + i4) - 1];
            }
            stackTraceElementArr[i4] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E o(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair de2 = de(e);
        E e2 = (Throwable) de2.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) de2.component2();
        E rg2 = ExceptionsConstuctorKt.rg(e2);
        if (rg2 == null || !Intrinsics.areEqual((Object) rg2.getMessage(), (Object) e2.getMessage())) {
            return e;
        }
        ArrayDeque<StackTraceElement> rg3 = rg(coroutineStackFrame);
        if (rg3.isEmpty()) {
            return e;
        }
        if (e2 != e) {
            i(stackTraceElementArr, rg3);
        }
        fe(e2, rg2, rg3);
        return rg2;
    }

    @NotNull
    public static final <E extends Throwable> E pf(@NotNull E e) {
        E rg2;
        if (!k.fe() || (rg2 = ExceptionsConstuctorKt.rg(e)) == null) {
            return e;
        }
        m411if(rg2);
        return rg2;
    }

    public static final ArrayDeque<StackTraceElement> rg(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            coroutineStackFrame = coroutineStackFrame == null ? null : coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    @NotNull
    /* renamed from: switch  reason: not valid java name */
    public static final <E extends Throwable> E m412switch(@NotNull E e) {
        E cause = e.getCause();
        if (cause != null && Intrinsics.areEqual((Object) cause.getClass(), (Object) e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (uk(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return cause;
            }
        }
        return e;
    }

    public static final boolean th(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    public static final boolean uk(@NotNull StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    public static final int yj(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Intrinsics.areEqual((Object) str, (Object) stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }
}
