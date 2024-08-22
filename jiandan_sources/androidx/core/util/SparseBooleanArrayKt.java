package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\b\u001aH\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\bø\u0001\u0000\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\b\u001a&\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\bø\u0001\u0000\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray sparseBooleanArray, int i2) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray sparseBooleanArray, int i2) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray sparseBooleanArray, boolean z) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int size = sparseBooleanArray.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
                if (i3 < size) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray sparseBooleanArray, int i2, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    @NotNull
    public static final IntIterator keyIterator(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics.checkNotNullParameter(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics.checkNotNullParameter(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
                if (i3 < size) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i2, z);
    }

    @NotNull
    public static final BooleanIterator valueIterator(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
