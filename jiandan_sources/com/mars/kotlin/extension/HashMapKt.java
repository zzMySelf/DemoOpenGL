package com.mars.kotlin.extension;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001au\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lkotlin/Function2;", "", "filter", "removeIfMatch", "(Ljava/util/HashMap;Lkotlin/Function2;)Ljava/util/HashMap;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class HashMapKt {
    @NotNull
    public static final <K, V> HashMap<K, V> removeIfMatch(@NotNull HashMap<K, V> hashMap, @NotNull Function2<? super K, ? super V, Boolean> function2) {
        Intrinsics.checkNotNullParameter(hashMap, "$this$removeIfMatch");
        Intrinsics.checkNotNullParameter(function2, "filter");
        Iterator<Map.Entry<K, V>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (function2.invoke(next.getKey(), next.getValue()).booleanValue()) {
                it.remove();
            }
        }
        return hashMap;
    }
}
