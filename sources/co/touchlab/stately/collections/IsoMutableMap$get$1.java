package co.touchlab.stately.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "V", "K", "it", "", "invoke", "(Ljava/util/Map;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoMutableMap.kt */
final class IsoMutableMap$get$1 extends Lambda implements Function1<Map<K, V>, V> {
    final /* synthetic */ K $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IsoMutableMap$get$1(K k) {
        super(1);
        this.$key = k;
    }

    public final V invoke(Map<K, V> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.get(this.$key);
    }
}
