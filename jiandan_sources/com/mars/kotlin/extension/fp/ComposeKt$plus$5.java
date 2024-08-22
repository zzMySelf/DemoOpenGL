package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u000f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\u00012\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u00032\u0006\u0010\n\u001a\u0002H\u00042\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u0002H\u0006H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"<anonymous>", "G", "A", "B", "C", "D", "E", "F", "a", "b", "c", "d", "e", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ComposeKt$plus$5 extends Lambda implements Function5<A, B, C, D, E, G> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Function5 $this_plus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeKt$plus$5(Function5 function5, Function1 function1) {
        super(5);
        this.$this_plus = function5;
        this.$block = function1;
    }

    public final G invoke(A a, B b, C c, D d, E e) {
        return this.$block.invoke(this.$this_plus.invoke(a, b, c, d, e));
    }
}
