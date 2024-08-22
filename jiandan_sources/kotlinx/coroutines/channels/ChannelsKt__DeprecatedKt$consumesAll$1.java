package kotlinx.coroutines.channels;

import i.qw.u1.yj;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "cause", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel<?>[] $channels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$consumesAll$1(ReceiveChannel<?>[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        ReceiveChannel<?>[] receiveChannelArr = this.$channels;
        int length = receiveChannelArr.length;
        Throwable th3 = null;
        int i2 = 0;
        while (i2 < length) {
            ReceiveChannel<?> receiveChannel = receiveChannelArr[i2];
            i2++;
            try {
                yj.ad(receiveChannel, th2);
            } catch (Throwable th4) {
                if (th3 == null) {
                    th3 = th4;
                } else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th3, th4);
                }
            }
        }
        if (th3 != null) {
            throw th3;
        }
    }
}
