package com.mars.kotlin.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.SavedStateHandle;
import com.google.common.base.Ascii;
import com.mars.kotlin.database.extension.ContentValuesKt;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0011\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010>\u001a\u00020\u0014¢\u0006\u0004\b@\u0010AJ\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0004J\u000f\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u001d\u0010!\u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b#\u0010$J!\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u0001¢\u0006\u0004\b!\u0010$J\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010%J\u0017\u0010&\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b&\u0010\bJ\u0017\u0010'\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b'\u0010\bJ\u000f\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\b(\u0010\"RQ\u00100\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140*0)j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140*`+8B@\u0002X\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R#\u0010!\u001a\b\u0012\u0004\u0012\u00020\u0001018B@\u0002X\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R!\u00108\u001a\u00060\tj\u0002`\n8B@\u0002X\u0002¢\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b6\u00107R#\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d018B@\u0002X\u0002¢\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u00104R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/mars/kotlin/database/Table;", "Lcom/mars/kotlin/database/Column;", "column", "add", "(Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Table;", "Landroid/database/sqlite/SQLiteDatabase;", "database", "alter", "(Landroid/database/sqlite/SQLiteDatabase;)Lcom/mars/kotlin/database/Table;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "titleBuilder", "", "buildBulkInsertColumn", "(Ljava/lang/StringBuilder;Lcom/mars/kotlin/database/Column;)V", "", "Landroid/content/ContentValues;", "values", "", "onConflict", "", "bulkInsert", "([Landroid/content/ContentValues;I)Ljava/lang/String;", "", "bulkInsertGroup", "([Landroid/content/ContentValues;I)Ljava/util/List;", "", "checkWithoutRowIdOnColumn", "(Lcom/mars/kotlin/database/Column;)Z", "Lcom/mars/kotlin/database/Constraint;", "constraint", "checkWithoutRowIdOnTable", "(Lcom/mars/kotlin/database/Constraint;)Z", "columns", "()Ljava/lang/String;", "columnsByArray", "([Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Table;", "(Lcom/mars/kotlin/database/Constraint;)Lcom/mars/kotlin/database/Table;", "create", "drop", "toString", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "Lkotlin/collections/ArrayList;", "addColumnSqls$delegate", "Lkotlin/Lazy;", "getAddColumnSqls", "()Ljava/util/ArrayList;", "addColumnSqls", "", "columns$delegate", "getColumns", "()Ljava/util/List;", "columnsBuilder$delegate", "getColumnsBuilder", "()Ljava/lang/StringBuilder;", "columnsBuilder", "constraints$delegate", "getConstraints", "constraints", "isWithoutRowId", "Z", "name", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("Table")
public final class Table {
    public final Lazy addColumnSqls$delegate = LazyKt__LazyJVMKt.lazy(Table$addColumnSqls$2.INSTANCE);
    public final Lazy columns$delegate = LazyKt__LazyJVMKt.lazy(Table$columns$2.INSTANCE);
    public final Lazy columnsBuilder$delegate = LazyKt__LazyJVMKt.lazy(Table$columnsBuilder$2.INSTANCE);
    public final Lazy constraints$delegate = LazyKt__LazyJVMKt.lazy(Table$constraints$2.INSTANCE);
    public boolean isWithoutRowId;
    public final String name;

    public Table(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    /* access modifiers changed from: private */
    public final void buildBulkInsertColumn(StringBuilder sb, Column column) {
        if (!StringsKt__StringsKt.contains$default((CharSequence) sb, (CharSequence) "(", false, 2, (Object) null)) {
            sb.append("(");
        } else {
            sb.append(",");
        }
        sb.append(column.getName$database_release());
    }

    public static /* synthetic */ String bulkInsert$default(Table table, ContentValues[] contentValuesArr, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return table.bulkInsert(contentValuesArr, i2);
    }

    public static /* synthetic */ List bulkInsertGroup$default(Table table, ContentValues[] contentValuesArr, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return table.bulkInsertGroup(contentValuesArr, i2);
    }

    private final boolean checkWithoutRowIdOnColumn(Column column) {
        boolean z;
        boolean z2;
        if (this.isWithoutRowId) {
            return true;
        }
        if (column.type() != Type.INTEGER) {
            List<Constraint> constraints = column.getConstraints();
            if (!(constraints instanceof Collection) || !constraints.isEmpty()) {
                Iterator<T> it = constraints.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Constraint) it.next()) instanceof PrimaryKey) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                List<Constraint> constraints2 = column.getConstraints();
                if (!(constraints2 instanceof Collection) || !constraints2.isEmpty()) {
                    Iterator<T> it2 = constraints2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((Constraint) it2.next()) instanceof NotNull) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkWithoutRowIdOnTable(Constraint constraint) {
        Column column;
        if (this.isWithoutRowId) {
            return true;
        }
        if (!(constraint instanceof PrimaryKey)) {
            return false;
        }
        Column[] columns = ((PrimaryKey) constraint).getColumns();
        int length = columns.length;
        Table$checkWithoutRowIdOnTable$1 table$checkWithoutRowIdOnTable$1 = Table$checkWithoutRowIdOnTable$1.INSTANCE;
        if (length > 1) {
            for (Column invoke : columns) {
                if (!Table$checkWithoutRowIdOnTable$1.INSTANCE.invoke(invoke)) {
                    return false;
                }
            }
            return true;
        } else if (length != 1 || (column = (Column) ArraysKt___ArraysKt.singleOrNull((T[]) columns)) == null || column.type() == Type.INTEGER || !table$checkWithoutRowIdOnTable$1.invoke(column)) {
            return false;
        } else {
            return true;
        }
    }

    private final ArrayList<Triple<String, String, String>> getAddColumnSqls() {
        return (ArrayList) this.addColumnSqls$delegate.getValue();
    }

    private final List<Column> getColumns() {
        return (List) this.columns$delegate.getValue();
    }

    private final StringBuilder getColumnsBuilder() {
        return (StringBuilder) this.columnsBuilder$delegate.getValue();
    }

    private final List<Constraint> getConstraints() {
        return (List) this.constraints$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r0 != null) goto L_0x0028;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mars.kotlin.database.Table add(@org.jetbrains.annotations.NotNull com.mars.kotlin.database.Column r7) {
        /*
            r6 = this;
            java.lang.String r0 = "column"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r7.getDefaultValue$database_release()
            if (r0 == 0) goto L_0x0026
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r7.getName$database_release()
            r1.append(r2)
            java.lang.String r2 = " = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = ""
        L_0x0028:
            java.util.ArrayList r1 = r6.getAddColumnSqls()
            kotlin.Triple r2 = new kotlin.Triple
            java.lang.String r3 = r7.sql()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r7.getName$database_release()
            r4.append(r5)
            r5 = 32
            r4.append(r5)
            com.mars.kotlin.database.Type r7 = r7.type()
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r2.<init>(r3, r7, r0)
            r1.add(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.Table.add(com.mars.kotlin.database.Column):com.mars.kotlin.database.Table");
    }

    @NotNull
    @WorkerThread
    public final Table alter(@NotNull SQLiteDatabase sQLiteDatabase) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        String str = "ALTER TABLE " + this.name + " ADD COLUMN";
        Iterator<Triple<String, String, String>> it = getAddColumnSqls().iterator();
        while (it.hasNext()) {
            Triple next = it.next();
            String str2 = (String) next.component1();
            String str3 = (String) next.component2();
            String str4 = (String) next.component3();
            try {
                sQLiteDatabase.execSQL((String) LoggerKt.d(str + Ascii.CASE_MASK + str2, "alter table"));
                obj = ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                obj = ExpectKt.failure(th2);
            }
            if (obj instanceof Either.Left) {
                Throwable th3 = (Throwable) ((Either.Left) obj).getValue();
                try {
                    sQLiteDatabase.execSQL((String) LoggerKt.d(str + Ascii.CASE_MASK + str3, "alter table Without Constraint"));
                    sQLiteDatabase.execSQL((String) LoggerKt.d("UPDATE " + this.name + " SET " + str4, "update table with Default Value After Alter table"));
                    obj2 = ExpectKt.success(Unit.INSTANCE);
                } catch (Throwable th4) {
                    LoggerKt.e$default(th4, (Object) null, 1, (Object) null);
                    obj2 = ExpectKt.failure(th4);
                }
                new Either.Left(obj2);
            } else if (!(obj instanceof Either.Right)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        getAddColumnSqls().clear();
        return this;
    }

    @NotNull
    @WorkerThread
    public final String bulkInsert(@NotNull ContentValues[] contentValuesArr, int i2) {
        Intrinsics.checkNotNullParameter(contentValuesArr, SavedStateHandle.VALUES);
        Set<String> keySet = ((ContentValues) ArraysKt___ArraysKt.first((T[]) contentValuesArr)).keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "values.first().keySet()");
        StringBuilder sb = new StringBuilder("INSERT" + TableKt.CONFLICT_VALUES[i2] + " INTO " + this.name);
        List<R> list = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(getColumns()), new Table$bulkInsert$columnList$1(keySet)), new Table$bulkInsert$columnList$2(this, sb)));
        if (!list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(") VALUES");
            int length = contentValuesArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                ContentValues contentValues = contentValuesArr[i3];
                sb2.append("(");
                int i4 = 0;
                for (R r : list) {
                    if (r.type() == Type.TEXT) {
                        sb2.append(String.valueOf(ContentValuesKt.escape(contentValues, r)));
                    } else {
                        sb2.append(String.valueOf(contentValues.get(r.getName$database_release())));
                    }
                    if (i4 < list.size() - 1) {
                        sb2.append(",");
                    }
                    i4++;
                }
                sb2.append(")");
                if (i3 < contentValuesArr.length - 1) {
                    sb2.append(",");
                }
            }
            sb.append(sb2);
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "columnBuilder.append(valuesBuilder).toString()");
            return sb3;
        }
        throw new IllegalStateException("not found column".toString());
    }

    @NotNull
    @WorkerThread
    public final List<String> bulkInsertGroup(@NotNull ContentValues[] contentValuesArr, int i2) {
        Intrinsics.checkNotNullParameter(contentValuesArr, SavedStateHandle.VALUES);
        List<ContentValues[]> split$default = ContentValuesKt.split$default(contentValuesArr, 0, 0, 0, (List) null, 15, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10));
        for (ContentValues[] bulkInsert : split$default) {
            arrayList.add(bulkInsert(bulkInsert, i2));
        }
        return arrayList;
    }

    @NotNull
    public final Table column(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "column");
        StringBuilder columnsBuilder = getColumnsBuilder();
        columnsBuilder.append(column.sql());
        columnsBuilder.append(",");
        getColumns().add(column);
        if (checkWithoutRowIdOnColumn(column)) {
            this.isWithoutRowId = true;
        }
        return this;
    }

    @NotNull
    public final Table columns(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        int length = columnArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            column(columnArr[i2]);
            if (i2 < columnArr.length - 1) {
                getColumnsBuilder().append(",");
            }
        }
        return this;
    }

    @NotNull
    @JvmName(name = "columnsByArray")
    public final Table columnsByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        int length = columnArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            column(columnArr[i2]);
            if (i2 < columnArr.length - 1) {
                getColumnsBuilder().append(",");
            }
        }
        return this;
    }

    @NotNull
    public final Table constraint(@NotNull Constraint constraint) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        getConstraints().add(constraint);
        if (checkWithoutRowIdOnTable(constraint)) {
            this.isWithoutRowId = true;
        }
        return this;
    }

    @NotNull
    @WorkerThread
    public final Table create(@NotNull SQLiteDatabase sQLiteDatabase) {
        Object obj;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getConstraints(), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Table$create$1$constraints$1.INSTANCE, 30, (Object) null);
        String str = "CREATE TABLE IF NOT EXISTS " + this.name + '(' + columns() + joinToString$default + ")";
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default(str + (this.isWithoutRowId ? " WITHOUT ROWID" : ""), (Object) null, 1, (Object) null));
            obj = ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) obj).getValue();
            if (this.isWithoutRowId) {
                try {
                    sQLiteDatabase.execSQL((String) LoggerKt.d$default(str, (Object) null, 1, (Object) null));
                    ExpectKt.success(Unit.INSTANCE);
                } catch (Throwable th4) {
                    LoggerKt.e$default(th4, (Object) null, 1, (Object) null);
                    ExpectKt.failure(th4);
                }
            }
            new Either.Left(Unit.INSTANCE);
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        return this;
    }

    @NotNull
    @WorkerThread
    public final Table drop(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default("DROP TABLE IF EXISTS " + this.name, (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    private final String columns() {
        if (getColumnsBuilder().length() == 0) {
            return toString();
        }
        String sb = getColumnsBuilder().toString();
        Intrinsics.checkNotNullExpressionValue(sb, "columnsBuilder.toString()");
        return StringsKt___StringsKt.dropLast(sb, 1);
    }
}
