package com.mars.kotlin.extension;

import android.database.Cursor;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aN\u0010\u000f\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\n\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\u00020\u00002\u0006\u0010\r\u001a\u00028\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a:\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a^\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0018\"\b\b\u0000\u0010\u0015*\u00020\u0014\"\b\b\u0001\u0010\u0016*\u00020\u0014*\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0004¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a4\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a:\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"Landroid/database/Cursor;", "Lkotlin/sequences/Sequence;", "asSequence", "(Landroid/database/Cursor;)Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "", "something", "", "forEach", "(Landroid/database/Cursor;Lkotlin/Function1;)I", "T", "", "C", "destination", "Lkotlin/ExtensionFunctionType;", "toCollection", "(Landroid/database/Cursor;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "", "toList", "(Landroid/database/Cursor;Lkotlin/Function1;)Ljava/util/List;", "", "K", "V", "Lkotlin/Pair;", "", "toMap", "(Landroid/database/Cursor;Lkotlin/Function1;)Ljava/util/Map;", "toOne", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "toSet", "(Landroid/database/Cursor;Lkotlin/Function1;)Ljava/util/Set;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CursorKt {
    @NotNull
    public static final Sequence<Cursor> asSequence(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$this$asSequence");
        return new CursorKt$asSequence$$inlined$Sequence$1(cursor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        throw r2;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int forEach(@org.jetbrains.annotations.NotNull android.database.Cursor r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, kotlin.Unit> r6) {
        /*
            java.lang.String r0 = "$this$forEach"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "something"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 1
            int r2 = r5.getCount()     // Catch:{ all -> 0x003c }
            if (r2 <= 0) goto L_0x002a
            kotlin.sequences.Sequence r3 = asSequence(r5)     // Catch:{ all -> 0x003c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x003c }
        L_0x001a:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x003c }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x003c }
            android.database.Cursor r4 = (android.database.Cursor) r4     // Catch:{ all -> 0x003c }
            r6.invoke(r4)     // Catch:{ all -> 0x003c }
            goto L_0x001a
        L_0x002a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x003c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0049 }
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ all -> 0x0049 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0049 }
            com.mars.kotlin.extension.fp.Either$Right r5 = com.mars.kotlin.extension.ExpectKt.success(r6)     // Catch:{ all -> 0x0049 }
            goto L_0x0051
        L_0x003c:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003e }
        L_0x003e:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0049 }
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ all -> 0x0049 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0049 }
            throw r2     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r5 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r5, r0, r1, r0)
            com.mars.kotlin.extension.fp.Either$Left r5 = com.mars.kotlin.extension.ExpectKt.failure(r5)
        L_0x0051:
            r6 = -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r5 = com.mars.kotlin.extension.ExpectKt.successOrDefault(r5, r6)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.CursorKt.forEach(android.database.Cursor, kotlin.jvm.functions.Function1):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        throw r4;
     */
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, C extends java.util.Collection<? super T>> C toCollection(@org.jetbrains.annotations.NotNull android.database.Cursor r2, @org.jetbrains.annotations.NotNull C r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> r4) {
        /*
            java.lang.String r0 = "$this$toCollection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "something"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            int r1 = r2.getCount()     // Catch:{ all -> 0x002b }
            if (r1 <= 0) goto L_0x0023
            com.mars.kotlin.extension.CursorIterator r1 = new com.mars.kotlin.extension.CursorIterator     // Catch:{ all -> 0x002b }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x002b }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt__SequencesKt.asSequence(r1)     // Catch:{ all -> 0x002b }
            java.util.Collection r3 = kotlin.sequences.SequencesKt___SequencesKt.toCollection(r4, r3)     // Catch:{ all -> 0x002b }
        L_0x0023:
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x0032 }
            com.mars.kotlin.extension.fp.Either$Right r2 = com.mars.kotlin.extension.ExpectKt.success(r3)     // Catch:{ all -> 0x0032 }
            goto L_0x003b
        L_0x002b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002d }
        L_0x002d:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r2 = move-exception
            r3 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r0, r3, r0)
            com.mars.kotlin.extension.fp.Either$Left r2 = com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x003b:
            java.lang.Object r2 = com.mars.kotlin.extension.ExpectKt.successOrNull(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.CursorKt.toCollection(android.database.Cursor, java.util.Collection, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @WorkerThread
    @Nullable
    public static final <T> List<T> toList(@NotNull Cursor cursor, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(cursor, "$this$toList");
        Intrinsics.checkNotNullParameter(function1, "something");
        return (List) toCollection(cursor, new ArrayList(), function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r2;
     */
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull android.database.Cursor r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends kotlin.Pair<? extends K, ? extends V>> r6) {
        /*
            java.lang.String r0 = "$this$toMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "something"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 1
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0037 }
            r2.<init>()     // Catch:{ all -> 0x0037 }
        L_0x0011:
            boolean r3 = r5.moveToNext()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r3 = r6.invoke(r5)     // Catch:{ all -> 0x0037 }
            kotlin.Pair r3 = (kotlin.Pair) r3     // Catch:{ all -> 0x0037 }
            java.lang.Object r4 = r3.component1()     // Catch:{ all -> 0x0037 }
            java.lang.Object r3 = r3.component2()     // Catch:{ all -> 0x0037 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0037 }
            goto L_0x0011
        L_0x0029:
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0044 }
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ all -> 0x0044 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0044 }
            com.mars.kotlin.extension.fp.Either$Right r5 = com.mars.kotlin.extension.ExpectKt.success(r2)     // Catch:{ all -> 0x0044 }
            goto L_0x004c
        L_0x0037:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0044 }
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ all -> 0x0044 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0044 }
            throw r2     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r5 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r5, r0, r1, r0)
            com.mars.kotlin.extension.fp.Either$Left r5 = com.mars.kotlin.extension.ExpectKt.failure(r5)
        L_0x004c:
            java.lang.Object r5 = com.mars.kotlin.extension.ExpectKt.successOrNull(r5)
            java.util.Map r5 = (java.util.Map) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.CursorKt.toMap(android.database.Cursor, kotlin.jvm.functions.Function1):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        throw r1;
     */
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T toOne(@org.jetbrains.annotations.NotNull android.database.Cursor r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> r3) {
        /*
            java.lang.String r0 = "$this$toOne"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "something"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            int r1 = r2.getCount()     // Catch:{ all -> 0x0028 }
            if (r1 <= 0) goto L_0x001f
            com.mars.kotlin.extension.CursorIterator r1 = new com.mars.kotlin.extension.CursorIterator     // Catch:{ all -> 0x0028 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0028 }
            kotlin.sequences.Sequence r3 = kotlin.sequences.SequencesKt__SequencesKt.asSequence(r1)     // Catch:{ all -> 0x0028 }
            java.lang.Object r3 = kotlin.sequences.SequencesKt___SequencesKt.firstOrNull(r3)     // Catch:{ all -> 0x0028 }
            goto L_0x0020
        L_0x001f:
            r3 = r0
        L_0x0020:
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x002f }
            com.mars.kotlin.extension.fp.Either$Right r2 = com.mars.kotlin.extension.ExpectKt.success(r3)     // Catch:{ all -> 0x002f }
            goto L_0x0038
        L_0x0028:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002a }
        L_0x002a:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x002f }
            throw r1     // Catch:{ all -> 0x002f }
        L_0x002f:
            r2 = move-exception
            r3 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r0, r3, r0)
            com.mars.kotlin.extension.fp.Either$Left r2 = com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x0038:
            java.lang.Object r2 = com.mars.kotlin.extension.ExpectKt.successOrNull(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.CursorKt.toOne(android.database.Cursor, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @WorkerThread
    @Nullable
    public static final <T> Set<T> toSet(@NotNull Cursor cursor, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(cursor, "$this$toSet");
        Intrinsics.checkNotNullParameter(function1, "something");
        return (Set) toCollection(cursor, new LinkedHashSet(), function1);
    }
}
