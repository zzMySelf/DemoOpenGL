package com.mars.united.core.os.pagedata.data;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "U", "T", "<anonymous parameter 0>", "", "t"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class _DataListKt$map$1$indexOf$1 extends Lambda implements Function2<Integer, T, U> {
    public final /* synthetic */ Function1<T, U> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public _DataListKt$map$1$indexOf$1(Function1<? super T, ? extends U> function1) {
        super(2);
        this.$transform = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), obj2);
    }

    @Nullable
    public final U invoke(int i2, T t) {
        return this.$transform.invoke(t);
    }
}
