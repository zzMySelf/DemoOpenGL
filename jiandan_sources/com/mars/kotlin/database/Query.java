package com.mars.kotlin.database;

import android.net.Uri;
import com.baidu.android.common.others.lang.StringUtil;
import com.mars.kotlin.extension.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000B#\u0012\u0006\u0010?\u001a\u00020>\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0004\bO\u0010PJ\u001d\u0010\u0006\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J!\u0010\b\u001a\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0005J!\u0010\u0010\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u0017J\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u0017J\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J \u0010\u001c\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0005J'\u0010\u001c\u001a\u00020\"2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0005R#\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'R,\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R$\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010 \"\u0004\b-\u0010.R$\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010/\u001a\u0004\b4\u00101\"\u0004\b5\u00103R$\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010+\u001a\u0004\b6\u0010 \"\u0004\b7\u0010.R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u0014088\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0019\u0010?\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR,\u0010C\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010+\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010.R,\u0010L\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010%\u001a\u0004\bM\u0010'\"\u0004\bN\u0010*\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006Q"}, d2 = {"Lcom/mars/kotlin/database/Query;", "", "Lcom/mars/kotlin/database/Column;", "orderBy", "ascByArray", "([Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Query;", "asc", "descByArray", "desc", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "columns", "groupByArray", "groupBy", "", "hashCode", "()I", "", "condition", "having", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Query;", "value", "limit", "(Ljava/lang/Integer;)Lcom/mars/kotlin/database/Query;", "offset", "where", "singleWhere", "sort", "toString", "()Ljava/lang/String;", "args", "Lcom/mars/kotlin/database/WhereArgs;", "whereByArray", "where-qFVhEZo", "[Lcom/mars/kotlin/database/Column;", "getColumns", "()[Lcom/mars/kotlin/database/Column;", "getGroupBy", "setGroupBy", "([Lcom/mars/kotlin/database/Column;)V", "Ljava/lang/String;", "getHaving", "setHaving", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "getOffset", "setOffset", "getSingleWhere", "setSingleWhere", "", "Ljava/util/List;", "getSort", "()Ljava/util/List;", "setSort", "(Ljava/util/List;)V", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "whereArgs", "[Ljava/lang/Object;", "getWhereArgs", "()[Ljava/lang/Object;", "setWhereArgs", "([Ljava/lang/Object;)V", "whereArgsSeparator", "getWhereArgsSeparator", "setWhereArgsSeparator", "whereColumns", "getWhereColumns", "setWhereColumns", "<init>", "(Landroid/net/Uri;[Lcom/mars/kotlin/database/Column;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("Query")
public final class Query {
    @Nullable
    public final Column[] columns;
    @Nullable
    public Column[] groupBy;
    @Nullable
    public String having;
    @Nullable
    public Integer limit;
    @Nullable
    public Integer offset;
    @Nullable
    public String singleWhere;
    @NotNull
    public List<String> sort;
    @NotNull
    public final Uri uri;
    @Nullable
    public Object[] whereArgs;
    @NotNull
    public String whereArgsSeparator;
    @Nullable
    public Column[] whereColumns;

    public Query(@NotNull Uri uri2, @Nullable Column[] columnArr) {
        Intrinsics.checkNotNullParameter(uri2, "uri");
        this.uri = uri2;
        this.columns = columnArr;
        this.sort = new ArrayList();
        this.whereArgsSeparator = "AND";
    }

    @NotNull
    public final Query asc(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        for (Column name$database_release : columnArr) {
            this.sort.add(name$database_release.getName$database_release());
        }
        return this;
    }

    @NotNull
    @JvmName(name = "ascByArray")
    public final Query ascByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        for (Column name$database_release : columnArr) {
            this.sort.add(name$database_release.getName$database_release());
        }
        return this;
    }

    @NotNull
    public final Query desc(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        for (Column column : columnArr) {
            this.sort.add(column.getName$database_release() + " DESC");
        }
        return this;
    }

    @NotNull
    @JvmName(name = "descByArray")
    public final Query descByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        for (Column column : columnArr) {
            this.sort.add(column.getName$database_release() + " DESC");
        }
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((!Intrinsics.areEqual((Object) Query.class, (Object) obj != null ? obj.getClass() : null)) || !(obj instanceof Query)) {
            return false;
        }
        Query query = (Query) obj;
        if (!Intrinsics.areEqual((Object) this.uri, (Object) query.uri)) {
            return false;
        }
        Column[] columnArr = this.columns;
        if (columnArr != null) {
            Column[] columnArr2 = query.columns;
            if (columnArr2 == null || !Arrays.equals(columnArr, columnArr2)) {
                return false;
            }
        } else if (query.columns != null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.sort, (Object) query.sort)) {
            return false;
        }
        if (this.whereArgs != null) {
            if (query.whereArgs == null) {
                return false;
            }
        } else if (query.whereArgs != null) {
            return false;
        }
        if (this.whereColumns != null) {
            if (query.whereColumns == null) {
                return false;
            }
        } else if (query.whereColumns != null) {
            return false;
        }
        if ((!Intrinsics.areEqual((Object) this.singleWhere, (Object) query.singleWhere)) || (!Intrinsics.areEqual((Object) this.whereArgsSeparator, (Object) query.whereArgsSeparator))) {
            return false;
        }
        if (this.groupBy != null) {
            if (query.groupBy == null) {
                return false;
            }
        } else if (query.groupBy != null) {
            return false;
        }
        return !(Intrinsics.areEqual((Object) this.having, (Object) query.having) ^ true) && !(Intrinsics.areEqual((Object) this.limit, (Object) query.limit) ^ true) && !(Intrinsics.areEqual((Object) this.offset, (Object) query.offset) ^ true);
    }

    @Nullable
    public final Column[] getColumns() {
        return this.columns;
    }

    @Nullable
    public final Column[] getGroupBy() {
        return this.groupBy;
    }

    @Nullable
    public final String getHaving() {
        return this.having;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }

    @Nullable
    public final String getSingleWhere() {
        return this.singleWhere;
    }

    @NotNull
    public final List<String> getSort() {
        return this.sort;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @Nullable
    public final Object[] getWhereArgs() {
        return this.whereArgs;
    }

    @NotNull
    public final String getWhereArgsSeparator() {
        return this.whereArgsSeparator;
    }

    @Nullable
    public final Column[] getWhereColumns() {
        return this.whereColumns;
    }

    @NotNull
    public final Query groupBy(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        this.groupBy = columnArr;
        return this;
    }

    @NotNull
    @JvmName(name = "groupByArray")
    public final Query groupByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        this.groupBy = columnArr;
        return this;
    }

    public int hashCode() {
        int hashCode = this.uri.hashCode() * 31;
        Column[] columnArr = this.columns;
        int i2 = 0;
        int hashCode2 = (((hashCode + (columnArr != null ? Arrays.hashCode(columnArr) : 0)) * 31) + this.sort.hashCode()) * 31;
        Object[] objArr = this.whereArgs;
        int hashCode3 = (hashCode2 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31;
        Column[] columnArr2 = this.whereColumns;
        int hashCode4 = (hashCode3 + (columnArr2 != null ? Arrays.hashCode(columnArr2) : 0)) * 31;
        String str = this.singleWhere;
        int hashCode5 = (((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.whereArgsSeparator.hashCode()) * 31;
        Column[] columnArr3 = this.groupBy;
        int hashCode6 = (hashCode5 + (columnArr3 != null ? Arrays.hashCode(columnArr3) : 0)) * 31;
        String str2 = this.having;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.limit;
        int intValue = (hashCode7 + (num != null ? num.intValue() : 0)) * 31;
        Integer num2 = this.offset;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        return intValue + i2;
    }

    @NotNull
    public final Query having(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "condition");
        this.having = str;
        return this;
    }

    @NotNull
    public final Query limit(@Nullable Integer num) {
        this.limit = num;
        return this;
    }

    @NotNull
    public final Query offset(@Nullable Integer num) {
        this.offset = num;
        return this;
    }

    public final void setGroupBy(@Nullable Column[] columnArr) {
        this.groupBy = columnArr;
    }

    public final void setHaving(@Nullable String str) {
        this.having = str;
    }

    public final void setLimit(@Nullable Integer num) {
        this.limit = num;
    }

    public final void setOffset(@Nullable Integer num) {
        this.offset = num;
    }

    public final void setSingleWhere(@Nullable String str) {
        this.singleWhere = str;
    }

    public final void setSort(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sort = list;
    }

    public final void setWhereArgs(@Nullable Object[] objArr) {
        this.whereArgs = objArr;
    }

    public final void setWhereArgsSeparator(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.whereArgsSeparator = str;
    }

    public final void setWhereColumns(@Nullable Column[] columnArr) {
        this.whereColumns = columnArr;
    }

    @NotNull
    public final Query singleWhere(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "where");
        this.singleWhere = str;
        return this;
    }

    @NotNull
    public final Query sort(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderBy");
        this.sort.add(str);
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(uri=");
        sb.append(this.uri);
        sb.append(", columns=");
        Column[] columnArr = this.columns;
        String str = null;
        sb.append(columnArr != null ? ArraysKt___ArraysKt.joinToString$default((Object[]) columnArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) : null);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("sort=");
        sb.append(this.sort);
        sb.append(", whereArgs=");
        Object[] objArr = this.whereArgs;
        sb.append(objArr != null ? ArraysKt___ArraysKt.joinToString$default(objArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) : null);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("where=");
        Column[] columnArr2 = this.whereColumns;
        if (columnArr2 != null) {
            str = ArraysKt___ArraysKt.joinToString$default((Object[]) columnArr2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }

    @NotNull
    /* renamed from: where-qFVhEZo  reason: not valid java name */
    public final Query m680whereqFVhEZo(@NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "args");
        this.whereColumns = columnArr;
        return WhereArgs.m695constructorimpl(this);
    }

    @NotNull
    @JvmName(name = "whereByArray")
    public final Query whereByArray(@NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(columnArr, "args");
        this.whereColumns = columnArr;
        return WhereArgs.m695constructorimpl(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Query(Uri uri2, Column[] columnArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri2, (i2 & 2) != 0 ? null : columnArr);
    }
}
