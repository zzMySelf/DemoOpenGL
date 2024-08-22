package com.mars.kotlin.database;

import com.google.common.base.Ascii;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u000fJ\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u000fJ\r\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\bJ\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0015J\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u0015J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u000fJ\r\u0010\"\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u000fJ\r\u0010$\u001a\u00020\u0000¢\u0006\u0004\b$\u0010\bJ\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010(R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R#\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0+8F@\u0006X\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b3\u0010\u000f¨\u00066"}, d2 = {"Lcom/mars/kotlin/database/Column;", "column", "AS", "(Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Column;", "", "name", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Column;", "avg", "()Lcom/mars/kotlin/database/Column;", "separator", "concat", "Lcom/mars/kotlin/database/Constraint;", "constraint", "(Lcom/mars/kotlin/database/Constraint;)Lcom/mars/kotlin/database/Column;", "constraintsSql", "()Ljava/lang/String;", "count", "datetime", "defaultValueSql", "end", "isEndWith", "(Ljava/lang/String;)Ljava/lang/String;", "length", "max", "min", "defaultValue", "nullif", "", "figures", "round", "(I)Ljava/lang/String;", "param", "rtrim", "sql", "sum", "toString", "total", "Lcom/mars/kotlin/database/Type;", "type", "()Lcom/mars/kotlin/database/Type;", "(Lcom/mars/kotlin/database/Type;)Lcom/mars/kotlin/database/Column;", "_type", "Lcom/mars/kotlin/database/Type;", "", "constraints$delegate", "Lkotlin/Lazy;", "getConstraints", "()Ljava/util/List;", "constraints", "Ljava/lang/String;", "getDefaultValue$database_release", "getName$database_release", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Column {
    public Type _type;
    @NotNull
    public final Lazy constraints$delegate;
    @Nullable
    public final String defaultValue;
    @NotNull
    public final String name;

    @JvmOverloads
    public Column(@NotNull String str) {
        this(str, (String) null, 2, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public Column(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.defaultValue = str2;
        this._type = Type.TEXT;
        this.constraints$delegate = LazyKt__LazyJVMKt.lazy(Column$constraints$2.INSTANCE);
    }

    public static /* synthetic */ Column concat$default(Column column, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return column.concat(str);
    }

    @NotNull
    public final Column AS(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Column type = new Column(this.name + " AS " + str, (String) null, 2, (DefaultConstructorMarker) null).type(this._type);
        getConstraints().addAll(type.getConstraints());
        return type;
    }

    @NotNull
    public final Column avg() {
        return new Column("AVG(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        if (r4 != null) goto L_0x0027;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mars.kotlin.database.Column concat(@org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "GROUP_CONCAT("
            r0.append(r1)
            java.lang.String r1 = r3.name
            r0.append(r1)
            if (r4 == 0) goto L_0x0025
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 44
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            if (r4 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            java.lang.String r4 = ""
        L_0x0027:
            r0.append(r4)
            r4 = 41
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r0 = 2
            com.mars.kotlin.database.Column r1 = new com.mars.kotlin.database.Column
            r2 = 0
            r1.<init>(r4, r2, r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.Column.concat(java.lang.String):com.mars.kotlin.database.Column");
    }

    @NotNull
    public final Column constraint(@NotNull Constraint constraint) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        getConstraints().add(constraint);
        return this;
    }

    @NotNull
    public final String constraintsSql() {
        return CollectionsKt___CollectionsKt.joinToString$default(getConstraints(), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Column$constraintsSql$1.INSTANCE, 30, (Object) null);
    }

    @NotNull
    public final Column count() {
        return new Column("COUNT(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final String datetime() {
        return "DATETIME(" + this.name + ", 'unixepoch','localtime')";
    }

    @NotNull
    public final String defaultValueSql() {
        String str = this.defaultValue;
        if (str != null) {
            String str2 = " DEFAULT " + str;
            if (str2 != null) {
                return str2;
            }
        }
        return "";
    }

    @NotNull
    public final List<Constraint> getConstraints() {
        return (List) this.constraints$delegate.getValue();
    }

    @Nullable
    public final String getDefaultValue$database_release() {
        return this.defaultValue;
    }

    @NotNull
    public final String getName$database_release() {
        return this.name;
    }

    @NotNull
    public final String isEndWith(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "end");
        return "(SELECT " + this.name + " NOT LIKE '%" + str + "')";
    }

    @NotNull
    public final String length() {
        return "LENGTH(" + this.name + ')';
    }

    @NotNull
    public final Column max() {
        return new Column("MAX(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Column min() {
        return new Column("MIN(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final String nullif(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        return "NULLIF(" + this.name + ',' + str + ')';
    }

    @NotNull
    public final String round(int i2) {
        return "ROUND(" + this.name + ',' + i2 + ')';
    }

    @NotNull
    public final String rtrim(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "param");
        return "RTRIM(" + this.name + ",'" + str + "')";
    }

    @NotNull
    public final String sql() {
        return this.name + Ascii.CASE_MASK + type() + Ascii.CASE_MASK + constraintsSql() + defaultValueSql();
    }

    @NotNull
    public final Column sum() {
        return new Column("SUM(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    @NotNull
    public final Column total() {
        return new Column("TOTAL(" + this.name + ')', (String) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Column type(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this._type = type;
        return this;
    }

    @NotNull
    public final Type type() {
        return this._type;
    }

    @NotNull
    public final Column AS(@NotNull Column column) {
        Intrinsics.checkNotNullParameter(column, "column");
        Column type = new Column(this.name + " AS " + column.name, (String) null, 2, (DefaultConstructorMarker) null).type(this._type);
        getConstraints().addAll(type.getConstraints());
        return type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Column(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2);
    }
}
