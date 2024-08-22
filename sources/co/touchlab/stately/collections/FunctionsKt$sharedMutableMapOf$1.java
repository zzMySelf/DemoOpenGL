package co.touchlab.stately.collections;

import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "K", "V", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Functions.kt */
final class FunctionsKt$sharedMutableMapOf$1 extends Lambda implements Function0<Map<K, V>> {
    final /* synthetic */ Pair<K, V>[] $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionsKt$sharedMutableMapOf$1(Pair<? extends K, ? extends V>[] pairArr) {
        super(0);
        this.$items = pairArr;
    }

    public final Map<K, V> invoke() {
        Pair<K, V>[] pairArr = this.$items;
        return MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
