package com.mars.kotlin.database.extension;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class UriKt$count$1 extends Lambda implements Function1<Cursor, Integer> {
    public static final UriKt$count$1 INSTANCE = new UriKt$count$1();

    public UriKt$count$1() {
        super(1);
    }

    public final int invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$receiver");
        return cursor.getInt(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke((Cursor) obj));
    }
}
