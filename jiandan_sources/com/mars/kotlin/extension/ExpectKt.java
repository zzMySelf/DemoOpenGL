package com.mars.kotlin.extension;

import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.extension.fp.EitherKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\r\u001aG\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001au\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0001`\f\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0000\"\u0004\b\u0002\u0010\u000b*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012\"\u0004\b\u0000\u0010\n*\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0015j\b\u0012\u0004\u0012\u00028\u0000`\u0016\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u001b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u0000*\u00020\u0019*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f2\u0006\u0010\u001a\u001a\u00028\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a;\u0010\u001d\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0000*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f¢\u0006\u0004\b\u001d\u0010\u001e\u001aY\u0010\u001d\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u0000*\u00020\u0019*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f0\rH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010 \u001a]\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00010\u0005j\b\u0012\u0004\u0012\u00028\u0001`\u0007\"\n\b\u0000\u0010\u0000*\u0004\u0018\u00010!\"\u0004\b\u0001\u0010\n*\u00028\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"!\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"!\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00158\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,*.\u0010-\u001a\u0004\b\u0000\u0010\n\u001a\u0004\b\u0001\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005*\u001c\u0010.\u001a\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u00028\u00000\u00112\b\u0012\u0004\u0012\u00028\u00000\u0011*(\u0010/\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000`\f2\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005*\u001c\u00100\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00152\b\u0012\u0004\u0012\u00028\u00000\u0015\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"T", "", "areExceptionsThrownAsDebug", "Lkotlin/Function0;", "block", "Lcom/mars/kotlin/extension/fp/Either;", "", "Lcom/mars/kotlin/extension/MaybeOccurException;", "catch", "(ZLkotlin/Function0;)Lcom/mars/kotlin/extension/fp/Either;", "R", "F", "Lcom/mars/kotlin/extension/Expect;", "Lkotlin/Function1;", "transform", "failTransform", "(Lcom/mars/kotlin/extension/fp/Either;Lkotlin/Function1;)Lcom/mars/kotlin/extension/fp/Either;", "Lcom/mars/kotlin/extension/fp/Either$Left;", "Lcom/mars/kotlin/extension/Failure;", "failure", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Left;", "Lcom/mars/kotlin/extension/fp/Either$Right;", "Lcom/mars/kotlin/extension/Success;", "success", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Right;", "", "defaultValue", "successOrDefault", "(Lcom/mars/kotlin/extension/fp/Either;Ljava/lang/Object;)Ljava/lang/Object;", "successOrNull", "(Lcom/mars/kotlin/extension/fp/Either;)Ljava/lang/Object;", "", "(Lcom/mars/kotlin/extension/fp/Either;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/Closeable;", "useWithCatch", "(Ljava/io/Closeable;ZLkotlin/jvm/functions/Function1;)Lcom/mars/kotlin/extension/fp/Either;", "", "FAILURE", "Lcom/mars/kotlin/extension/fp/Either$Left;", "getFAILURE", "()Lcom/mars/kotlin/extension/fp/Either$Left;", "SUCCESS", "Lcom/mars/kotlin/extension/fp/Either$Right;", "getSUCCESS", "()Lcom/mars/kotlin/extension/fp/Either$Right;", "Expect", "Failure", "MaybeOccurException", "Success", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ExpectKt {
    @NotNull
    public static final Either.Left FAILURE = failure((Object) null);
    @NotNull
    public static final Either.Right SUCCESS = success((Object) null);

    @NotNull
    /* renamed from: catch  reason: not valid java name */
    public static final <T> Either<Throwable, T> m704catch(boolean z, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return success(function0.invoke());
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            if (!z || !Logger.INSTANCE.getEnable()) {
                return failure(th2);
            }
            throw th2;
        }
    }

    public static /* synthetic */ Either catch$default(boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return success(function0.invoke());
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            if (!z || !Logger.INSTANCE.getEnable()) {
                return failure(th2);
            }
            throw th2;
        }
    }

    @NotNull
    public static final <R, T, F> Either<F, T> failTransform(@NotNull Either<? extends R, ? extends T> either, @NotNull Function1<? super R, ? extends F> function1) {
        Intrinsics.checkNotNullParameter(either, "$this$failTransform");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (either instanceof Either.Left) {
            return new Either.Left(function1.invoke(((Either.Left) either).getValue()));
        }
        if (either instanceof Either.Right) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <R> Either.Left<R> failure(R r) {
        return EitherKt.left(r);
    }

    @NotNull
    public static final Either.Left getFAILURE() {
        return FAILURE;
    }

    @NotNull
    public static final Either.Right getSUCCESS() {
        return SUCCESS;
    }

    @NotNull
    public static final <T> Either.Right<T> success(T t) {
        return EitherKt.right(t);
    }

    @NotNull
    public static final <R, T> T successOrDefault(@NotNull Either<? extends R, ? extends T> either, @NotNull T t) {
        Intrinsics.checkNotNullParameter(either, "$this$successOrDefault");
        Intrinsics.checkNotNullParameter(t, "defaultValue");
        if (either instanceof Either.Left) {
            return t;
        }
        if (either instanceof Either.Right) {
            return ((Either.Right) either).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public static final <R, T> T successOrNull(@NotNull Either<? extends R, ? extends T> either, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(either, "$this$successOrNull");
        Intrinsics.checkNotNullParameter(function1, "block");
        T successOrNull = successOrNull(either);
        if (successOrNull == null) {
            return null;
        }
        function1.invoke(successOrNull);
        return successOrNull;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r3, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r2 = move-exception;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.io.Closeable, R> com.mars.kotlin.extension.fp.Either<java.lang.Throwable, R> useWithCatch(T r3, boolean r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r5) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            r1 = 1
            java.lang.Object r5 = r5.invoke(r3)     // Catch:{ all -> 0x001b }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0019 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ all -> 0x0019 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0019 }
            com.mars.kotlin.extension.fp.Either$Right r3 = success(r5)     // Catch:{ all -> 0x0019 }
            goto L_0x003b
        L_0x0019:
            r3 = move-exception
            goto L_0x0028
        L_0x001b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x001d }
        L_0x001d:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0019 }
            kotlin.io.CloseableKt.closeFinally(r3, r5)     // Catch:{ all -> 0x0019 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0028:
            com.mars.kotlin.extension.LoggerKt.e$default(r3, r0, r1, r0)
            if (r4 == 0) goto L_0x0037
            com.mars.kotlin.extension.Logger r4 = com.mars.kotlin.extension.Logger.INSTANCE
            boolean r4 = r4.getEnable()
            if (r4 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            throw r3
        L_0x0037:
            com.mars.kotlin.extension.fp.Either$Left r3 = failure(r3)
        L_0x003b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.ExpectKt.useWithCatch(java.io.Closeable, boolean, kotlin.jvm.functions.Function1):com.mars.kotlin.extension.fp.Either");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r1, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.mars.kotlin.extension.fp.Either useWithCatch$default(java.io.Closeable r1, boolean r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0005
            r2 = 0
        L_0x0005:
            java.lang.String r4 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            r4 = 0
            java.lang.Object r3 = r3.invoke(r1)     // Catch:{ all -> 0x001f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)     // Catch:{ all -> 0x001d }
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x001d }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)     // Catch:{ all -> 0x001d }
            com.mars.kotlin.extension.fp.Either$Right r1 = success(r3)     // Catch:{ all -> 0x001d }
            goto L_0x003f
        L_0x001d:
            r1 = move-exception
            goto L_0x002c
        L_0x001f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)     // Catch:{ all -> 0x001d }
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x001d }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)     // Catch:{ all -> 0x001d }
            throw r0     // Catch:{ all -> 0x001d }
        L_0x002c:
            com.mars.kotlin.extension.LoggerKt.e$default(r1, r4, r5, r4)
            if (r2 == 0) goto L_0x003b
            com.mars.kotlin.extension.Logger r2 = com.mars.kotlin.extension.Logger.INSTANCE
            boolean r2 = r2.getEnable()
            if (r2 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            throw r1
        L_0x003b:
            com.mars.kotlin.extension.fp.Either$Left r1 = failure(r1)
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.ExpectKt.useWithCatch$default(java.io.Closeable, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):com.mars.kotlin.extension.fp.Either");
    }

    @Nullable
    public static final <R, T> T successOrNull(@NotNull Either<? extends R, ? extends T> either) {
        Intrinsics.checkNotNullParameter(either, "$this$successOrNull");
        if (either instanceof Either.Left) {
            return null;
        }
        if (either instanceof Either.Right) {
            return ((Either.Right) either).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
