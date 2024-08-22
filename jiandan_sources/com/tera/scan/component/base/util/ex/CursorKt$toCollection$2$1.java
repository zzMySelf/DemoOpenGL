package com.tera.scan.component.base.util.ex;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/database/Cursor;", "invoke", "(Landroid/database/Cursor;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class CursorKt$toCollection$2$1 extends Lambda implements Function1<Cursor, Boolean> {
    public final /* synthetic */ Function1<Cursor, Boolean> $filter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CursorKt$toCollection$2$1(Function1<? super Cursor, Boolean> function1) {
        super(1);
        this.$filter = function1;
    }

    @NotNull
    public final Boolean invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "it");
        return this.$filter.invoke(cursor);
    }
}
