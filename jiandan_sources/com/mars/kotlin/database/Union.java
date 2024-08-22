package com.mars.kotlin.database;

import android.text.TextUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000B\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001¢\u0006\u0004\b\u000b\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\u0013\u0010\rJ!\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u001d\u0010\u0016\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\u0015\u0010\rJ!\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR \u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR!\u0010#\u001a\u00060\u001dj\u0002`\u001e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/mars/kotlin/database/Union;", "", "build", "()Ljava/lang/String;", "Lcom/mars/kotlin/database/Table;", "table", "from", "(Lcom/mars/kotlin/database/Table;)Lcom/mars/kotlin/database/Union;", "tableName", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Union;", "", "groupBy", "groupByArray", "([Ljava/lang/String;)Lcom/mars/kotlin/database/Union;", "limit", "", "offset", "(I)Lcom/mars/kotlin/database/Union;", "columns", "orderByArray", "orderBy", "selectByArray", "select", "toString", "where", "Ljava/lang/String;", "Ljava/lang/Integer;", "orderByColumns", "[Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sqlBuilder$delegate", "Lkotlin/Lazy;", "getSqlBuilder", "()Ljava/lang/StringBuilder;", "sqlBuilder", "<init>", "()V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Union {
    public String limit;
    public Integer offset;
    public String[] orderByColumns;
    public final Lazy sqlBuilder$delegate = LazyKt__LazyJVMKt.lazy(Union$sqlBuilder$2.INSTANCE);

    private final String build() {
        if (this.orderByColumns != null) {
            StringBuilder sqlBuilder = getSqlBuilder();
            sqlBuilder.append(" ORDER BY ");
            String[] strArr = this.orderByColumns;
            sqlBuilder.append(strArr != null ? ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null);
        }
        if (this.limit != null) {
            StringBuilder sqlBuilder2 = getSqlBuilder();
            sqlBuilder2.append(" LIMIT ");
            sqlBuilder2.append(this.limit);
        }
        if (this.offset != null) {
            StringBuilder sqlBuilder3 = getSqlBuilder();
            sqlBuilder3.append(" OFFSET ");
            sqlBuilder3.append(String.valueOf(this.offset));
        }
        String sb = getSqlBuilder().toString();
        Intrinsics.checkNotNullExpressionValue(sb, "sqlBuilder.toString()");
        return sb;
    }

    private final StringBuilder getSqlBuilder() {
        return (StringBuilder) this.sqlBuilder$delegate.getValue();
    }

    @NotNull
    public final Union from(@NotNull Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(table);
        return this;
    }

    @NotNull
    public final Union groupBy(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "groupBy");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" GROUP BY ");
        sqlBuilder.append(TextUtils.join(",", strArr));
        return this;
    }

    @NotNull
    @JvmName(name = "groupByArray")
    public final Union groupByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "groupBy");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" GROUP BY ");
        sqlBuilder.append(TextUtils.join(",", strArr));
        return this;
    }

    @NotNull
    public final Union limit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "limit");
        this.limit = str;
        return this;
    }

    @NotNull
    public final Union offset(int i2) {
        this.offset = Integer.valueOf(i2);
        return this;
    }

    @NotNull
    public final Union orderBy(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        this.orderByColumns = strArr;
        return this;
    }

    @NotNull
    @JvmName(name = "orderByArray")
    public final Union orderByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        this.orderByColumns = strArr;
        return this;
    }

    @NotNull
    public final Union select(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append("SELECT ");
        sqlBuilder.append(TextUtils.join(",", strArr));
        return this;
    }

    @NotNull
    @JvmName(name = "selectByArray")
    public final Union selectByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append("SELECT ");
        sqlBuilder.append(TextUtils.join(",", strArr));
        return this;
    }

    @NotNull
    public String toString() {
        return build();
    }

    @NotNull
    public final Union where(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sqlBuilder = getSqlBuilder();
            sqlBuilder.append(" WHERE ");
            sqlBuilder.append(str);
        }
        return this;
    }

    @NotNull
    public final Union from(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(str);
        return this;
    }
}
