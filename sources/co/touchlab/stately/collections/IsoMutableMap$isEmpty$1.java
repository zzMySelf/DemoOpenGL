package co.touchlab.stately.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "K", "V", "it", "", "invoke", "(Ljava/util/Map;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsoMutableMap.kt */
final class IsoMutableMap$isEmpty$1 extends Lambda implements Function1<Map<K, V>, Boolean> {
    public static final IsoMutableMap$isEmpty$1 INSTANCE = new IsoMutableMap$isEmpty$1();

    IsoMutableMap$isEmpty$1() {
        super(1);
    }

    public final Boolean invoke(Map<K, V> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.isEmpty());
    }
}
