package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/mars/kotlin/database/Column;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Index$create$1$content$1 extends Lambda implements Function1<Column, CharSequence> {
    public static final Index$create$1$content$1 INSTANCE = new Index$create$1$content$1();

    public Index$create$1$content$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "it");
        return column.getName$database_release();
    }
}
