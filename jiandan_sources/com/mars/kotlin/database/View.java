package com.mars.kotlin.database;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010$\u001a\u00020\n¢\u0006\u0004\b1\u00102J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\n¢\u0006\u0004\b\u000e\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0007¢\u0006\u0004\b\u0018\u0010\u0010J!\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\n¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u001b\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0007¢\u0006\u0004\b\u001a\u0010\u0010J!\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\n¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b!\u0010\fR \u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010#R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010%R \u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R!\u0010-\u001a\u00060'j\u0002`(8B@\u0002X\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/mars/kotlin/database/View;", "Landroid/database/sqlite/SQLiteDatabase;", "database", "create", "(Landroid/database/sqlite/SQLiteDatabase;)Lcom/mars/kotlin/database/View;", "drop", "Lcom/mars/kotlin/database/Table;", "table", "from", "(Lcom/mars/kotlin/database/Table;)Lcom/mars/kotlin/database/View;", "", "tableName", "(Ljava/lang/String;)Lcom/mars/kotlin/database/View;", "", "groupBy", "groupByArray", "([Ljava/lang/String;)Lcom/mars/kotlin/database/View;", "condition", "having", "limit", "", "offset", "(I)Lcom/mars/kotlin/database/View;", "columns", "orderByArray", "orderBy", "selectByArray", "select", "toString", "()Ljava/lang/String;", "Lcom/mars/kotlin/database/Union;", "union", "(Lcom/mars/kotlin/database/Union;)Lcom/mars/kotlin/database/View;", "where", "[Ljava/lang/String;", "Ljava/lang/String;", "name", "Ljava/lang/Integer;", "orderByColumns", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sqlBuilder$delegate", "Lkotlin/Lazy;", "getSqlBuilder", "()Ljava/lang/StringBuilder;", "sqlBuilder", "", "unions", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("View")
public final class View {
    public String[] groupBy;
    public String having;
    public String limit;
    public final String name;
    public Integer offset;
    public String[] orderByColumns;
    public final Lazy sqlBuilder$delegate = LazyKt__LazyJVMKt.lazy(View$sqlBuilder$2.INSTANCE);
    public List<Union> unions = new ArrayList();

    public View(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    private final StringBuilder getSqlBuilder() {
        return (StringBuilder) this.sqlBuilder$delegate.getValue();
    }

    @NotNull
    @WorkerThread
    public final View create(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.groupBy;
        if (strArr != null) {
            sb.append(" GROUP BY ");
            sb.append(ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        String str = this.having;
        if (str != null) {
            sb.append(" HAVING ");
            sb.append(str);
        }
        String[] strArr2 = this.orderByColumns;
        if (strArr2 != null) {
            sb.append(" ORDER BY ");
            sb.append(ArraysKt___ArraysKt.joinToString$default((Object[]) strArr2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        String str2 = this.limit;
        if (str2 != null) {
            sb.append(" LIMIT ");
            sb.append(str2);
        }
        Integer num = this.offset;
        if (num != null) {
            int intValue = num.intValue();
            sb.append(" OFFSET ");
            sb.append(String.valueOf(intValue));
        }
        if (!this.unions.isEmpty()) {
            sb.append(" UNION " + CollectionsKt___CollectionsKt.joinToString$default(this.unions, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default(getSqlBuilder().toString() + sb.toString(), (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    @WorkerThread
    public final View drop(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default("DROP VIEW IF EXISTS " + this.name, (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    public final View from(@NotNull Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(table);
        return this;
    }

    @NotNull
    public final View groupBy(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "groupBy");
        this.groupBy = strArr;
        return this;
    }

    @NotNull
    @JvmName(name = "groupByArray")
    public final View groupByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "groupBy");
        this.groupBy = strArr;
        return this;
    }

    @NotNull
    public final View having(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "condition");
        this.having = str;
        return this;
    }

    @NotNull
    public final View limit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "limit");
        this.limit = str;
        return this;
    }

    @NotNull
    public final View offset(int i2) {
        this.offset = Integer.valueOf(i2);
        return this;
    }

    @NotNull
    public final View orderBy(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        this.orderByColumns = strArr;
        return this;
    }

    @NotNull
    @JvmName(name = "orderByArray")
    public final View orderByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        this.orderByColumns = strArr;
        return this;
    }

    @NotNull
    public final View select(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        if (getSqlBuilder().length() == 0) {
            StringBuilder sqlBuilder = getSqlBuilder();
            sqlBuilder.append("CREATE VIEW IF NOT EXISTS ");
            sqlBuilder.append(this.name);
        }
        StringBuilder sqlBuilder2 = getSqlBuilder();
        sqlBuilder2.append(" AS SELECT ");
        sqlBuilder2.append(ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        return this;
    }

    @NotNull
    @JvmName(name = "selectByArray")
    public final View selectByArray(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "columns");
        if (getSqlBuilder().length() == 0) {
            StringBuilder sqlBuilder = getSqlBuilder();
            sqlBuilder.append("CREATE VIEW IF NOT EXISTS ");
            sqlBuilder.append(this.name);
        }
        StringBuilder sqlBuilder2 = getSqlBuilder();
        sqlBuilder2.append(" AS SELECT ");
        sqlBuilder2.append(ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        return this;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    @NotNull
    public final View union(@NotNull Union union) {
        Intrinsics.checkNotNullParameter(union, "union");
        this.unions.add(union);
        return this;
    }

    @NotNull
    public final View where(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sqlBuilder = getSqlBuilder();
            sqlBuilder.append(" WHERE ");
            sqlBuilder.append(str);
        }
        return this;
    }

    @NotNull
    public final View from(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        StringBuilder sqlBuilder = getSqlBuilder();
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(str);
        return this;
    }
}
