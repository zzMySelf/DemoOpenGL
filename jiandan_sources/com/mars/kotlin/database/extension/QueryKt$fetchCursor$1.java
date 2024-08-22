package com.mars.kotlin.database.extension;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class QueryKt$fetchCursor$1 extends Lambda implements Function1<Cursor, Cursor> {
    public static final QueryKt$fetchCursor$1 INSTANCE = new QueryKt$fetchCursor$1();

    public QueryKt$fetchCursor$1() {
        super(1);
    }

    @NotNull
    public final Cursor invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$receiver");
        return cursor;
    }
}
