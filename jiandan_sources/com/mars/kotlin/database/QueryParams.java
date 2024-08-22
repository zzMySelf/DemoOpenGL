package com.mars.kotlin.database;

import com.google.android.gms.actions.SearchIntents;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b@\u0018\u0000B\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/mars/kotlin/database/QueryParams;", "Landroid/net/Uri;", "buildUri-impl", "(Lcom/mars/kotlin/database/Query;)Landroid/net/Uri;", "buildUri", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "", "projection-impl", "(Lcom/mars/kotlin/database/Query;)[Ljava/lang/String;", "projection", "sort-impl", "(Lcom/mars/kotlin/database/Query;)Ljava/lang/String;", "sort", "toString-impl", "toString", "where-impl", "where", "whereArgs-impl", "whereArgs", "Lcom/mars/kotlin/database/Query;", "query", "Lcom/mars/kotlin/database/Query;", "constructor-impl", "(Lcom/mars/kotlin/database/Query;)Lcom/mars/kotlin/database/Query;", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class QueryParams {
    public final Query query;

    public /* synthetic */ QueryParams(@NotNull Query query2) {
        Intrinsics.checkNotNullParameter(query2, SearchIntents.EXTRA_QUERY);
        this.query = query2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        if (r10 != null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        if (r0 != null) goto L_0x0043;
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: buildUri-impl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri m682buildUriimpl(com.mars.kotlin.database.Query r10) {
        /*
            com.mars.kotlin.database.Column[] r0 = r10.getGroupBy()
            if (r0 == 0) goto L_0x003f
            android.net.Uri r1 = r10.getUri()
            android.net.Uri$Builder r9 = r1.buildUpon()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 63
            r8 = 0
            java.lang.String r0 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default((java.lang.Object[]) r0, (java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (int) r4, (java.lang.CharSequence) r5, (kotlin.jvm.functions.Function1) r6, (int) r7, (java.lang.Object) r8)
            java.lang.String r1 = "__groupby__"
            android.net.Uri$Builder r0 = r9.appendQueryParameter(r1, r0)
            android.net.Uri r0 = r0.build()
            java.lang.String r1 = r10.getHaving()
            if (r1 == 0) goto L_0x003c
            android.net.Uri$Builder r2 = r0.buildUpon()
            java.lang.String r3 = "__having__"
            android.net.Uri$Builder r1 = r2.appendQueryParameter(r3, r1)
            android.net.Uri r1 = r1.build()
            if (r1 == 0) goto L_0x003c
            r0 = r1
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            android.net.Uri r0 = r10.getUri()
        L_0x0043:
            java.util.List r1 = r10.getSort()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004e
            return r0
        L_0x004e:
            java.lang.Integer r1 = r10.getLimit()
            if (r1 == 0) goto L_0x008e
            int r1 = r1.intValue()
            java.lang.Integer r10 = r10.getOffset()
            if (r10 == 0) goto L_0x0079
            int r10 = r10.intValue()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r10 = 44
            r2.append(r10)
            r2.append(r1)
            java.lang.String r10 = r2.toString()
            if (r10 == 0) goto L_0x0079
            goto L_0x007d
        L_0x0079:
            java.lang.String r10 = java.lang.String.valueOf(r1)
        L_0x007d:
            android.net.Uri$Builder r1 = r0.buildUpon()
            java.lang.String r2 = "__limit__"
            android.net.Uri$Builder r10 = r1.appendQueryParameter(r2, r10)
            android.net.Uri r10 = r10.build()
            if (r10 == 0) goto L_0x008e
            r0 = r10
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.QueryParams.m682buildUriimpl(com.mars.kotlin.database.Query):android.net.Uri");
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Query m683constructorimpl(@NotNull Query query2) {
        Intrinsics.checkNotNullParameter(query2, SearchIntents.EXTRA_QUERY);
        return query2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m684equalsimpl(Query query2, @Nullable Object obj) {
        return (obj instanceof QueryParams) && Intrinsics.areEqual((Object) query2, (Object) ((QueryParams) obj).m692unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m685equalsimpl0(@NotNull Query query2, @NotNull Query query3) {
        return Intrinsics.areEqual((Object) query2, (Object) query3);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m686hashCodeimpl(Query query2) {
        if (query2 != null) {
            return query2.hashCode();
        }
        return 0;
    }

    @Nullable
    /* renamed from: projection-impl  reason: not valid java name */
    public static final String[] m687projectionimpl(Query query2) {
        Column[] columns = query2.getColumns();
        if (columns == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(columns.length);
        for (Column column : columns) {
            arrayList.add(column.toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Nullable
    /* renamed from: sort-impl  reason: not valid java name */
    public static final String m688sortimpl(Query query2) {
        if (query2.getSort().isEmpty()) {
            return null;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(query2.getSort(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m689toStringimpl(Query query2) {
        return "QueryParams(query=" + query2 + ')';
    }

    @Nullable
    /* renamed from: where-impl  reason: not valid java name */
    public static final String m690whereimpl(Query query2) {
        if (query2.getSingleWhere() != null) {
            return query2.getSingleWhere();
        }
        String str = null;
        if (Intrinsics.areEqual((Object) query2.getWhereArgsSeparator(), (Object) "IN")) {
            Column[] whereColumns = query2.getWhereColumns();
            Column column = whereColumns != null ? (Column) ArraysKt___ArraysKt.firstOrNull((T[]) whereColumns) : null;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(column));
            sb.append(" ");
            sb.append(query2.getWhereArgsSeparator());
            sb.append(" (");
            Object[] whereArgs = query2.getWhereArgs();
            if (whereArgs != null) {
                str = ArraysKt___ArraysKt.joinToString$default(whereArgs, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) QueryParams$where$1.INSTANCE, 31, (Object) null);
            }
            sb.append(str);
            sb.append(")");
            return sb.toString();
        }
        Column[] whereColumns2 = query2.getWhereColumns();
        if (whereColumns2 != null) {
            str = ArraysKt___ArraysKt.joinToString$default((Object[]) whereColumns2, (CharSequence) Ascii.CASE_MASK + query2.getWhereArgsSeparator() + Ascii.CASE_MASK, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) QueryParams$where$2.INSTANCE, 30, (Object) null);
        }
        return str;
    }

    @Nullable
    /* renamed from: whereArgs-impl  reason: not valid java name */
    public static final String[] m691whereArgsimpl(Query query2) {
        Object[] whereArgs;
        if (Intrinsics.areEqual((Object) query2.getWhereArgsSeparator(), (Object) "IN") || (whereArgs = query2.getWhereArgs()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(whereArgs.length);
        for (Object obj : whereArgs) {
            arrayList.add(obj.toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean equals(Object obj) {
        return m684equalsimpl(this.query, obj);
    }

    public int hashCode() {
        return m686hashCodeimpl(this.query);
    }

    @NotNull
    public String toString() {
        return m689toStringimpl(this.query);
    }

    @NotNull
    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Query m692unboximpl() {
        return this.query;
    }
}
