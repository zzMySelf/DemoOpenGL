package com.mars.kotlin.database.extension;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import com.mars.kotlin.database.Column;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001aZ\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00060\u000b*\b\u0012\u0004\u0012\u00020\u00000\u00062\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00060\u000bH\u0010¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/content/ContentValues;", "Lcom/mars/kotlin/database/Column;", "column", "", "escape", "(Landroid/content/ContentValues;Lcom/mars/kotlin/database/Column;)Ljava/lang/String;", "", "", "startContentValuesPosition", "currentContentValuesPosition", "acc", "", "list", "split", "([Landroid/content/ContentValues;IIILjava/util/List;)Ljava/util/List;", "MAX_COLUMNS", "I", "database_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentValuesKt {
    public static final int MAX_COLUMNS = 2000;

    @Nullable
    public static final String escape(@NotNull ContentValues contentValues, @NotNull Column column) {
        Intrinsics.checkNotNullParameter(contentValues, "$this$escape");
        Intrinsics.checkNotNullParameter(column, "column");
        Object obj = contentValues.get(column.toString());
        if (obj != null) {
            return DatabaseUtils.sqlEscapeString(obj.toString());
        }
        return null;
    }

    @NotNull
    public static final List<ContentValues[]> split(@NotNull ContentValues[] contentValuesArr, int i2, int i3, int i4, @NotNull List<ContentValues[]> list) {
        List list2;
        List<T> list3;
        int i5 = i3;
        int i6 = i2;
        int i7 = i5;
        List<T> list4 = list;
        while (true) {
            Intrinsics.checkNotNullParameter(contentValuesArr, "$this$split");
            Intrinsics.checkNotNullParameter(list4, "list");
            if (i7 == contentValuesArr.length) {
                if (i6 == 0) {
                    list2 = CollectionsKt__CollectionsJVMKt.listOf(contentValuesArr);
                } else if (i6 < i7) {
                    list2 = CollectionsKt__CollectionsJVMKt.listOf(ArraysKt___ArraysJvmKt.copyOfRange((T[]) contentValuesArr, i6, i7));
                } else {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                return CollectionsKt___CollectionsKt.plus(list4, list2);
            }
            int size = contentValuesArr[i7].size();
            if (size < 2000) {
                i4 += size;
                if (i4 <= 2000) {
                    i7++;
                    list3 = list4;
                } else {
                    List<T> plus = CollectionsKt___CollectionsKt.plus(list4, CollectionsKt__CollectionsJVMKt.listOf(ArraysKt___ArraysJvmKt.copyOfRange((T[]) contentValuesArr, i6, i7)));
                    i6 = i7;
                    i4 = 0;
                    list3 = plus;
                }
                list4 = list3;
            } else {
                throw new IllegalArgumentException(("size of ContentValues " + size + " must be less than 2000").toString());
            }
        }
    }

    public static /* synthetic */ List split$default(ContentValues[] contentValuesArr, int i2, int i3, int i4, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = 0;
        }
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        if ((i5 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return split(contentValuesArr, i2, i3, i4, list);
    }
}
