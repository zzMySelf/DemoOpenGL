package kotlinx.coroutines.channels;

import i.qw.u1.yj;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "E", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BroadcastKt$broadcast$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel<E> $this_broadcast;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastKt$broadcast$1(ReceiveChannel<? extends E> receiveChannel) {
        super(1);
        this.$this_broadcast = receiveChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        yj.ad(this.$this_broadcast, th2);
    }
}
