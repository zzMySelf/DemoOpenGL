package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/mars/kotlin/database/Column;", "it", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Table$bulkInsert$columnList$2 extends Lambda implements Function1<Column, Column> {
    public final /* synthetic */ StringBuilder $columnBuilder;
    public final /* synthetic */ Table this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Table$bulkInsert$columnList$2(Table table, StringBuilder sb) {
        super(1);
        this.this$0 = table;
        this.$columnBuilder = sb;
    }

    @NotNull
    public final Column invoke(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "it");
        this.this$0.buildBulkInsertColumn(this.$columnBuilder, column);
        return column;
    }
}
