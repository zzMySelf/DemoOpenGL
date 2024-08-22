package com.tera.scan.component.base.util.ex;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "it", "Landroid/database/Cursor;", "invoke", "(Landroid/database/Cursor;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class CursorKt$toCollection$2$2 extends Lambda implements Function1<Cursor, T> {
    public final /* synthetic */ Function1<Cursor, T> $cursorToBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CursorKt$toCollection$2$2(Function1<? super Cursor, ? extends T> function1) {
        super(1);
        this.$cursorToBean = function1;
    }

    public final T invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "it");
        return this.$cursorToBean.invoke(cursor);
    }
}
