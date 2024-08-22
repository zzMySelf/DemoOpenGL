package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0017\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fB'\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/mars/kotlin/database/Unique;", "Lcom/mars/kotlin/database/Constraint;", "", "toString", "()Ljava/lang/String;", "", "Lcom/mars/kotlin/database/Column;", "columns", "[Lcom/mars/kotlin/database/Column;", "conflict", "Ljava/lang/String;", "getConflict$annotations", "()V", "columnString", "<init>", "(Ljava/lang/String;[Ljava/lang/String;)V", "(Ljava/lang/String;[Lcom/mars/kotlin/database/Column;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Unique extends Constraint {
    public final Column[] columns;
    public final String conflict;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Unique(@Nullable String str, @NotNull Column... columnArr) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        this.conflict = str;
        this.columns = columnArr;
    }

    public static /* synthetic */ void getConflict$annotations() {
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "UNIQUE";
        if (!(this.columns.length == 0)) {
            str2 = ',' + (str2 + "(" + ArraysKt___ArraysKt.joinToString$default((Object[]) this.columns, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ")");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (this.conflict != null) {
            str = " ON CONFLICT " + this.conflict;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Unique(String str, Column[] columnArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, columnArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Unique(String str, String[] strArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r10 != null) goto L_0x0033;
     */
    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "using Column instead of String")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Unique(@org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String[] r10) {
        /*
            r8 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0031
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r10.length
            r1.<init>(r2)
            int r2 = r10.length
            r3 = 0
        L_0x000b:
            if (r3 >= r2) goto L_0x001c
            r4 = r10[r3]
            com.mars.kotlin.database.Column r5 = new com.mars.kotlin.database.Column
            r6 = 2
            r7 = 0
            r5.<init>(r4, r7, r6, r7)
            r1.add(r5)
            int r3 = r3 + 1
            goto L_0x000b
        L_0x001c:
            com.mars.kotlin.database.Column[] r10 = new com.mars.kotlin.database.Column[r0]
            java.lang.Object[] r10 = r1.toArray(r10)
            if (r10 == 0) goto L_0x0029
            com.mars.kotlin.database.Column[] r10 = (com.mars.kotlin.database.Column[]) r10
            if (r10 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0029:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r10)
            throw r9
        L_0x0031:
            com.mars.kotlin.database.Column[] r10 = new com.mars.kotlin.database.Column[r0]
        L_0x0033:
            int r0 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r0)
            com.mars.kotlin.database.Column[] r10 = (com.mars.kotlin.database.Column[]) r10
            r8.<init>((java.lang.String) r9, (com.mars.kotlin.database.Column[]) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.Unique.<init>(java.lang.String, java.lang.String[]):void");
    }
}
