package com.mars.kotlin.extension;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a=\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"T", "", "Lkotlin/Function1;", "", "filter", "removeIfMatch", "(Ljava/util/Collection;Lkotlin/Function1;)Ljava/util/Collection;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class MutableCollectionKt {
    @NotNull
    public static final <T> Collection<T> removeIfMatch(@NotNull Collection<T> collection, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(collection, "$this$removeIfMatch");
        Intrinsics.checkNotNullParameter(function1, "filter");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
        return collection;
    }
}
