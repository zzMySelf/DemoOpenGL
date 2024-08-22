package com.baidu.searchbox.kmm.foundation.concurrent.collections;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "K", "V", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentMutableMap.kt */
final class ConcurrentMutableMap$clear$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConcurrentMutableMap<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConcurrentMutableMap$clear$1(ConcurrentMutableMap<K, V> concurrentMutableMap) {
        super(0);
        this.this$0 = concurrentMutableMap;
    }

    public final void invoke() {
        this.this$0.del.clear();
    }
}
