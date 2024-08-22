package com.mars.united.core.os.pagedata.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "T", "V", "Lcom/mars/united/core/os/pagedata/data/DataVersion;", "itemCursor", "Landroid/database/Cursor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DatabaseLoadTask$getData$1$1 extends Lambda implements Function1<Cursor, T> {
    public final /* synthetic */ Function1<Cursor, T> $parser;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatabaseLoadTask$getData$1$1(Function1<? super Cursor, ? extends T> function1) {
        super(1);
        this.$parser = function1;
    }

    public final T invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "itemCursor");
        return this.$parser.invoke(cursor);
    }
}
