package com.baidu.searchbox.kmm.foundation.concurrent.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "E", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentMutableCollection.kt */
final class ConcurrentMutableCollection$retainAll$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Collection<E> $elements;
    final /* synthetic */ ConcurrentMutableCollection<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConcurrentMutableCollection$retainAll$1(ConcurrentMutableCollection<E> concurrentMutableCollection, Collection<? extends E> collection) {
        super(0);
        this.this$0 = concurrentMutableCollection;
        this.$elements = collection;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.del.retainAll(this.$elements));
    }
}
