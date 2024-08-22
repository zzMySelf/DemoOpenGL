package com.mars.kotlin.database;

import android.database.sqlite.SQLiteDatabase;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0003\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0003\u001a\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR \u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/mars/kotlin/database/Index;", "", "Lcom/mars/kotlin/database/Column;", "columns", "columnsByArray", "([Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Index;", "Landroid/database/sqlite/SQLiteDatabase;", "database", "create", "(Landroid/database/sqlite/SQLiteDatabase;)Lcom/mars/kotlin/database/Index;", "drop", "Lcom/mars/kotlin/database/Table;", "table", "(Lcom/mars/kotlin/database/Table;)Lcom/mars/kotlin/database/Index;", "[Lcom/mars/kotlin/database/Column;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/mars/kotlin/database/Table;", "getTable", "()Lcom/mars/kotlin/database/Table;", "setTable", "(Lcom/mars/kotlin/database/Table;)V", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("Index")
public final class Index {
    public Column[] columns;
    @NotNull
    public final String name;
    @Nullable
    public Table table;

    public Index(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    @NotNull
    public final Index columns(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        this.columns = columnArr;
        return this;
    }

    @NotNull
    @JvmName(name = "columnsByArray")
    public final Index columnsByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        this.columns = columnArr;
        return this;
    }

    @NotNull
    public final Index create(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX IF NOT EXISTS ");
        sb.append(this.name);
        sb.append(" ON ");
        sb.append(this.table);
        sb.append(" (");
        Column[] columnArr = this.columns;
        sb.append(columnArr != null ? ArraysKt___ArraysKt.joinToString$default((Object[]) columnArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Index$create$1$content$1.INSTANCE, 31, (Object) null) : null);
        sb.append(')');
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    public final Index drop(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default("DROP INDEX IF EXISTS " + this.name, (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Table getTable() {
        return this.table;
    }

    public final void setTable(@Nullable Table table2) {
        this.table = table2;
    }

    @NotNull
    public final Index table(@NotNull Table table2) {
        Intrinsics.checkNotNullParameter(table2, "table");
        this.table = table2;
        return this;
    }
}
