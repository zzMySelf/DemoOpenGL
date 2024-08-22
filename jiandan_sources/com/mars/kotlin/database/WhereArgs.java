package com.mars.kotlin.database;

import com.google.android.gms.actions.SearchIntents;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b@\u0018\u0000B\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u001b\u0010\u0010\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/mars/kotlin/database/WhereArgs;", "", "", "arguments", "Lcom/mars/kotlin/database/Query;", "and-impl", "(Lcom/mars/kotlin/database/Query;[Ljava/lang/Object;)Lcom/mars/kotlin/database/Query;", "and", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "inside-impl", "inside", "", "(Lcom/mars/kotlin/database/Query;Ljava/util/Collection;)Lcom/mars/kotlin/database/Query;", "or-impl", "or", "", "toString", "()Ljava/lang/String;", "query", "Lcom/mars/kotlin/database/Query;", "constructor-impl", "(Lcom/mars/kotlin/database/Query;)Lcom/mars/kotlin/database/Query;", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class WhereArgs {
    public final Query query;

    public /* synthetic */ WhereArgs(@NotNull Query query2) {
        Intrinsics.checkNotNullParameter(query2, SearchIntents.EXTRA_QUERY);
        this.query = query2;
    }

    @NotNull
    /* renamed from: and-impl  reason: not valid java name */
    public static final Query m693andimpl(Query query2, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        query2.setWhereArgs(objArr);
        query2.setWhereArgsSeparator("AND");
        return query2;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Query m695constructorimpl(@NotNull Query query2) {
        Intrinsics.checkNotNullParameter(query2, SearchIntents.EXTRA_QUERY);
        return query2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m696equalsimpl(Query query2, @Nullable Object obj) {
        return (obj instanceof WhereArgs) && Intrinsics.areEqual((Object) query2, (Object) ((WhereArgs) obj).m703unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m697equalsimpl0(@NotNull Query query2, @NotNull Query query3) {
        return Intrinsics.areEqual((Object) query2, (Object) query3);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m698hashCodeimpl(Query query2) {
        if (query2 != null) {
            return query2.hashCode();
        }
        return 0;
    }

    @NotNull
    /* renamed from: inside-impl  reason: not valid java name */
    public static final Query m700insideimpl(Query query2, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        query2.setWhereArgs(objArr);
        query2.setWhereArgsSeparator("IN");
        return query2;
    }

    @NotNull
    /* renamed from: or-impl  reason: not valid java name */
    public static final Query m701orimpl(Query query2, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        query2.setWhereArgs(objArr);
        query2.setWhereArgsSeparator("OR");
        return query2;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m702toStringimpl(Query query2) {
        return "WhereArgs(query=" + query2 + ")";
    }

    public boolean equals(Object obj) {
        return m696equalsimpl(this.query, obj);
    }

    public int hashCode() {
        return m698hashCodeimpl(this.query);
    }

    public String toString() {
        return m702toStringimpl(this.query);
    }

    @NotNull
    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Query m703unboximpl() {
        return this.query;
    }

    @NotNull
    /* renamed from: inside-impl  reason: not valid java name */
    public static final Query m699insideimpl(Query query2, @NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "arguments");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            query2.setWhereArgs(array);
            query2.setWhereArgsSeparator("IN");
            return query2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
