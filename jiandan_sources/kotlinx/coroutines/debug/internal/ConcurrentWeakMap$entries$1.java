package kotlinx.coroutines.debug.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "", "K", "V", "", "k", "v"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ConcurrentWeakMap$entries$1 extends Lambda implements Function2<K, V, Map.Entry<K, V>> {
    public static final ConcurrentWeakMap$entries$1 INSTANCE = new ConcurrentWeakMap$entries$1();

    public ConcurrentWeakMap$entries$1() {
        super(2);
    }

    @NotNull
    public final Map.Entry<K, V> invoke(@NotNull K k, @NotNull V v) {
        return new ConcurrentWeakMap.ad(k, v);
    }
}
