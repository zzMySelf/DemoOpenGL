package com.mars.kotlin.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.fp.Either;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B(\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\b\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR'\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\b\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/mars/kotlin/extension/CursorIterator;", "T", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "Landroid/database/Cursor;", "cursor", "Landroid/database/Cursor;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "something", "Lkotlin/Function1;", "<init>", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CursorIterator<T> implements Iterator<T>, KMappedMarker {
    public final Cursor cursor;
    public final Function1<Cursor, T> something;

    public CursorIterator(@NotNull Cursor cursor2, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(cursor2, "cursor");
        Intrinsics.checkNotNullParameter(function1, "something");
        this.cursor = cursor2;
        this.something = function1;
    }

    public boolean hasNext() {
        Either either;
        try {
            either = ExpectKt.success(Boolean.valueOf(!this.cursor.isClosed() && this.cursor.getCount() > 0 && this.cursor.moveToNext()));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        return ((Boolean) ExpectKt.successOrDefault(either, Boolean.FALSE)).booleanValue();
    }

    public T next() {
        return this.something.invoke(this.cursor);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
