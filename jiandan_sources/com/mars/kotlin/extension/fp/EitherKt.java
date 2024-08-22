package com.mars.kotlin.extension.fp;

import com.mars.kotlin.extension.fp.Either;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a/\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00032\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0000H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a7\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00032\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0000H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a7\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00032\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0006\u001a7\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00032\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0000H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006\u001a7\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\r2\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u001a/\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001aa\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0011*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00030\u0012H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a=\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u0019*\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\u0004\b\u0000\u0010\u001d*\u00028\u0000¢\u0006\u0004\b\u001f\u0010 \"!\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"!\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"!\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(\"!\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"Lkotlin/Function0;", "", "condition", "Lcom/mars/kotlin/extension/fp/Either;", "", "bind", "(Lkotlin/Function0;)Lcom/mars/kotlin/extension/fp/Either;", "", "emptyArray", "", "emptyCollection", "notEmptyArray", "notEmptyCollection", "B", "notNull", "real", "A", "C", "Lkotlin/Function1;", "transform", "flatMap", "(Lcom/mars/kotlin/extension/fp/Either;Lkotlin/Function1;)Lcom/mars/kotlin/extension/fp/Either;", "default", "getOrElse", "(Lcom/mars/kotlin/extension/fp/Either;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "R", "Lcom/mars/kotlin/extension/fp/Either$Left;", "left", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Left;", "T", "Lcom/mars/kotlin/extension/fp/Either$Right;", "right", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Right;", "BEGIN", "Lcom/mars/kotlin/extension/fp/Either$Right;", "getBEGIN", "()Lcom/mars/kotlin/extension/fp/Either$Right;", "END", "Lcom/mars/kotlin/extension/fp/Either$Left;", "getEND", "()Lcom/mars/kotlin/extension/fp/Either$Left;", "LEFT", "getLEFT", "RIGHT", "getRIGHT", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class EitherKt {
    @NotNull
    public static final Either.Right BEGIN;
    @NotNull
    public static final Either.Left END = LEFT;
    @NotNull
    public static final Either.Left LEFT = left((Object) null);
    @NotNull
    public static final Either.Right RIGHT;

    static {
        Either.Right right = right((Object) null);
        RIGHT = right;
        BEGIN = right;
    }

    @NotNull
    public static final Either bind(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        return function0.invoke().booleanValue() ? right(Boolean.TRUE) : getEND();
    }

    @NotNull
    public static final Either emptyArray(@NotNull Function0<? extends Object[]> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        Object[] objArr = (Object[]) function0.invoke();
        return objArr.length == 0 ? right(objArr) : getEND();
    }

    @NotNull
    public static final Either emptyCollection(@NotNull Function0<? extends Collection<?>> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        Collection collection = (Collection) function0.invoke();
        return collection.isEmpty() ? right(collection) : getEND();
    }

    @NotNull
    public static final <A, B, C> Either<A, C> flatMap(@NotNull Either<? extends A, ? extends B> either, @NotNull Function1<? super B, ? extends Either<? extends A, ? extends C>> function1) {
        Intrinsics.checkNotNullParameter(either, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (either instanceof Either.Right) {
            return (Either) function1.invoke(((Either.Right) either).getValue());
        }
        if (either instanceof Either.Left) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final Either.Right getBEGIN() {
        return BEGIN;
    }

    @NotNull
    public static final Either.Left getEND() {
        return END;
    }

    @NotNull
    public static final Either.Left getLEFT() {
        return LEFT;
    }

    public static final <A, B> B getOrElse(@NotNull Either<? extends A, ? extends B> either, @NotNull Function0<? extends B> function0) {
        Intrinsics.checkNotNullParameter(either, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(function0, "default");
        if (either instanceof Either.Left) {
            return function0.invoke();
        }
        if (either instanceof Either.Right) {
            return ((Either.Right) either).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final Either.Right getRIGHT() {
        return RIGHT;
    }

    @NotNull
    public static final <R> Either.Left<R> left(R r) {
        return new Either.Left<>(r);
    }

    @NotNull
    public static final Either notEmptyArray(@NotNull Function0<? extends Object[]> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        Object[] objArr = (Object[]) function0.invoke();
        return (objArr.length == 0) ^ true ? right(objArr) : getEND();
    }

    @NotNull
    public static final Either notEmptyCollection(@NotNull Function0<? extends Collection<?>> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        Collection collection = (Collection) function0.invoke();
        return collection.isEmpty() ^ true ? right(collection) : getEND();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = right(r1);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <B> com.mars.kotlin.extension.fp.Either notNull(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends B> r1) {
        /*
            java.lang.String r0 = "condition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Object r1 = r1.invoke()
            if (r1 == 0) goto L_0x0012
            com.mars.kotlin.extension.fp.Either$Right r1 = right(r1)
            if (r1 == 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            com.mars.kotlin.extension.fp.Either$Left r1 = getEND()
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.fp.EitherKt.notNull(kotlin.jvm.functions.Function0):com.mars.kotlin.extension.fp.Either");
    }

    @NotNull
    public static final Either real(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        return function0.invoke().booleanValue() ? right(Boolean.TRUE) : getEND();
    }

    @NotNull
    public static final <T> Either.Right<T> right(T t) {
        return new Either.Right<>(t);
    }
}
