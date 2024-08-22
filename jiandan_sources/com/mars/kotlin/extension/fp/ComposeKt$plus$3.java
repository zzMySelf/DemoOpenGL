package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u000b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00012\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "E", "A", "B", "C", "D", "a", "b", "c", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ComposeKt$plus$3 extends Lambda implements Function3<A, B, C, E> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Function3 $this_plus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeKt$plus$3(Function3 function3, Function1 function1) {
        super(3);
        this.$this_plus = function3;
        this.$block = function1;
    }

    public final E invoke(A a, B b, C c) {
        return this.$block.invoke(this.$this_plus.invoke(a, b, c));
    }
}
