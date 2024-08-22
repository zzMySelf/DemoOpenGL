package com.mars.kotlin.database.extension;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "apply", "(Ljava/lang/Integer;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class UriKt$fetchCount$2<I, O> implements Function<Integer, Integer> {
    public static final UriKt$fetchCount$2 INSTANCE = new UriKt$fetchCount$2();

    public final Integer apply(@Nullable Integer num) {
        return Integer.valueOf(num != null ? num.intValue() : -1);
    }
}
