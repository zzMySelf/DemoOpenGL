package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\t\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00012\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "D", "A", "B", "C", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ComposeKt$plus$2 extends Lambda implements Function2<A, B, D> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Function2 $this_plus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeKt$plus$2(Function2 function2, Function1 function1) {
        super(2);
        this.$this_plus = function2;
        this.$block = function1;
    }

    public final D invoke(A a, B b) {
        return this.$block.invoke(this.$this_plus.invoke(a, b));
    }
}
