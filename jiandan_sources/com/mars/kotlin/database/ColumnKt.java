package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0019\u0010\u0001\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mars/kotlin/database/Column;", "ANY", "Lcom/mars/kotlin/database/Column;", "getANY", "()Lcom/mars/kotlin/database/Column;", "database_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ColumnKt {
    @NotNull
    public static final Column ANY = new Column("*", (String) null, 2, (DefaultConstructorMarker) null);

    @NotNull
    public static final Column getANY() {
        return ANY;
    }
}
