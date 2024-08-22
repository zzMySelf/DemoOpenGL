package com.baidu.searchbox.kmm.foundation.concurrent.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "V", "K", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentMutableMap.kt */
final class ConcurrentMutableMap$computeIfAbsent$1 extends Lambda implements Function0<V> {
    final /* synthetic */ Function1<K, V> $defaultValue;
    final /* synthetic */ K $key;
    final /* synthetic */ ConcurrentMutableMap<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConcurrentMutableMap$computeIfAbsent$1(ConcurrentMutableMap<K, V> concurrentMutableMap, K k, Function1<? super K, ? extends V> function1) {
        super(0);
        this.this$0 = concurrentMutableMap;
        this.$key = k;
        this.$defaultValue = function1;
    }

    public final V invoke() {
        Object value = this.this$0.del.get(this.$key);
        if (value != null) {
            return value;
        }
        Object newValue = this.$defaultValue.invoke(this.$key);
        this.this$0.del.put(this.$key, newValue);
        return newValue;
    }
}
