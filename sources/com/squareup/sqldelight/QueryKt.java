package com.squareup.sqldelight;

import com.baidu.searchbox.kmm.bottombarconfig.GetBarTypeKt;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00020\r\u001ad\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00020\r¨\u0006\u0011"}, d2 = {"Query", "Lcom/squareup/sqldelight/Query;", "RowType", "", "identifier", "", "queries", "", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "query", "", "mapper", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlCursor;", "fileName", "label", "runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Query.kt */
public final class QueryKt {
    public static final <RowType> Query<RowType> Query(int identifier, List<Query<?>> queries, SqlDriver driver, String query, Function1<? super SqlCursor, ? extends RowType> mapper) {
        Intrinsics.checkNotNullParameter(queries, GetBarTypeKt.KEY_QUERY);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return Query(identifier, queries, driver, "unknown", "unknown", query, mapper);
    }

    public static final <RowType> Query<RowType> Query(int identifier, List<Query<?>> queries, SqlDriver driver, String fileName, String label, String query, Function1<? super SqlCursor, ? extends RowType> mapper) {
        Intrinsics.checkNotNullParameter(queries, GetBarTypeKt.KEY_QUERY);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new SimpleQuery<>(identifier, queries, driver, fileName, label, query, mapper);
    }
}
