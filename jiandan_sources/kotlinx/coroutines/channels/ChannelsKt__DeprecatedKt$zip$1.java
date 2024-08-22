package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "E", "R", "t1", "t2"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChannelsKt__DeprecatedKt$zip$1 extends Lambda implements Function2<E, R, Pair<? extends E, ? extends R>> {
    public static final ChannelsKt__DeprecatedKt$zip$1 INSTANCE = new ChannelsKt__DeprecatedKt$zip$1();

    public ChannelsKt__DeprecatedKt$zip$1() {
        super(2);
    }

    @NotNull
    public final Pair<E, R> invoke(E e, R r) {
        return TuplesKt.to(e, r);
    }
}
