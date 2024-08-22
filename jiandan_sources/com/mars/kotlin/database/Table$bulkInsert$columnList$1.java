package com.mars.kotlin.database;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/mars/kotlin/database/Column;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Table$bulkInsert$columnList$1 extends Lambda implements Function1<Column, Boolean> {
    public final /* synthetic */ Set $columnsInValues;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Table$bulkInsert$columnList$1(Set set) {
        super(1);
        this.$columnsInValues = set;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Column) obj));
    }

    public final boolean invoke(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "it");
        return this.$columnsInValues.contains(column.getName$database_release());
    }
}
