package com.mars.united.core.os.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/database/Cursor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class CursorExtKt$toCollection$1 extends Lambda implements Function1<Cursor, Boolean> {
    public static final CursorExtKt$toCollection$1 INSTANCE = new CursorExtKt$toCollection$1();

    public CursorExtKt$toCollection$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "it");
        return Boolean.TRUE;
    }
}
