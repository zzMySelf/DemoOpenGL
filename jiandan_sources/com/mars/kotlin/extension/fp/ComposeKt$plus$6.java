package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0011\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\u00012\u0006\u0010\t\u001a\u0002H\u00022\u0006\u0010\n\u001a\u0002H\u00032\u0006\u0010\u000b\u001a\u0002H\u00042\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u0002H\u00062\u0006\u0010\u000e\u001a\u0002H\u0007H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"<anonymous>", "H", "A", "B", "C", "D", "E", "F", "G", "a", "b", "c", "d", "e", "f", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ComposeKt$plus$6 extends Lambda implements Function6<A, B, C, D, E, F, H> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Function6 $this_plus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeKt$plus$6(Function6 function6, Function1 function1) {
        super(6);
        this.$this_plus = function6;
        this.$block = function1;
    }

    public final H invoke(A a, B b, C c, D d, E e, F f) {
        return this.$block.invoke(this.$this_plus.invoke(a, b, c, d, e, f));
    }
}
