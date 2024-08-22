package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0013\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\u00012\u0006\u0010\n\u001a\u0002H\u00022\u0006\u0010\u000b\u001a\u0002H\u00032\u0006\u0010\f\u001a\u0002H\u00042\u0006\u0010\r\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u0002H\u00062\u0006\u0010\u000f\u001a\u0002H\u00072\u0006\u0010\u0010\u001a\u0002H\bH\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"<anonymous>", "I", "A", "B", "C", "D", "E", "F", "G", "H", "a", "b", "c", "d", "e", "f", "g", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ComposeKt$plus$7 extends Lambda implements Function7<A, B, C, D, E, F, G, I> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Function7 $this_plus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeKt$plus$7(Function7 function7, Function1 function1) {
        super(7);
        this.$this_plus = function7;
        this.$block = function1;
    }

    public final I invoke(A a, B b, C c, D d, E e, F f, G g) {
        return this.$block.invoke(this.$this_plus.invoke(a, b, c, d, e, f, g));
    }
}
