package com.mars.kotlin.database;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"isNotNull", "", "Lcom/mars/kotlin/database/Column;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Table$checkWithoutRowIdOnTable$1 extends Lambda implements Function1<Column, Boolean> {
    public static final Table$checkWithoutRowIdOnTable$1 INSTANCE = new Table$checkWithoutRowIdOnTable$1();

    public Table$checkWithoutRowIdOnTable$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Column) obj));
    }

    public final boolean invoke(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "$this$isNotNull");
        List<Constraint> constraints = column.getConstraints();
        if ((constraints instanceof Collection) && constraints.isEmpty()) {
            return false;
        }
        for (Constraint constraint : constraints) {
            if (constraint instanceof NotNull) {
                return true;
            }
        }
        return false;
    }
}
